package edu.ds.practice.SquareSpace;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


public class  Percentile {
    int percentile; // 90th percentile, 50th percentile etc
    int[] prevBuckets; // We will only consider a bracket of response times. Since we are monitoring backend response times, we don't need to use the stray values (in this case above 150 milli seconds)
    int[] currentBuckets;

    LocalDateTime prev = null;
    LocalDateTime curr = null;

    public Percentile(int percentile) {
      this.percentile = percentile;
      this.prevBuckets = new int[150];
      this.currentBuckets = new int[150];
    }

    public void read(int seconds, double responseTime) {
      int responseBucket = (int) Math.round(Math.floor(responseTime));

      // Here, when i hit 10:23:34, i.e. 23 second for the first time, I should output the buckets
      // calculation related to 21 second. and use the same buckets for 23 second after resetting
      // the counter
      Instant instant = Instant.ofEpochSecond(seconds);
      LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

      if (prev == null && curr == null) {
        curr = dateTime;
        currentBuckets[responseBucket]++;
        return;
      }

      // When we reach this point, it means curr != null
      if (curr != null) {
        if (getMinutesDifference(dateTime, curr) >= 2) {
          // This means when we are processing 24 minute, I got a dateTime which is 2 or more minutes behind. so disregard
          return;
        } else if (getMinutesDifference(dateTime, curr) == 1) {
          // If previous is null, then we should process this dateTime as well
          // For ex, if you are processing minute 23, and you got a time for minute 22 (which should be printed as soon
          // as you see minute 24) should still be processed
          if (prev == null) {
            prev = dateTime;
          }
          prevBuckets[responseBucket]++;
        } else if (getMinutesDifference(dateTime, curr) == 0) {
          // belong to the same minutes
          currentBuckets[responseBucket]++;
        } else if (getMinutesDifference(dateTime, curr) == -1) {
          // This means when we are processing 25 minute as curr, we got a dateTime which is 26 minute
          // This means two things, we need to process 24th minute if prev != null
          // otherwise make 25 as prev, and 26th as current bucket
          if (prev != null) {
            outputValue(prev, calculatePercentileRequestTime(90, prevBuckets));
          }
          prev = curr;
          prevBuckets = currentBuckets;

          curr = dateTime;
          currentBuckets = new int[150];
          currentBuckets[responseBucket]++;
        } else if (getMinutesDifference(dateTime, curr) <= -2) {
          // This means when we are processing 25 minute as curr, we got a dateTime which is 27 minute.
          // So output prev & curr if available
          if (prev != null) {
            outputValue(prev, calculatePercentileRequestTime(90, prevBuckets));
            prev = null;
          }
          outputValue(curr, calculatePercentileRequestTime(90, currentBuckets));
          prevBuckets = new int[150];

          currentBuckets = new int[150];
          currentBuckets[responseBucket]++;
          curr = dateTime; // Assign 27 as current processing minute;
        }
      }
    }

  /**
   * If dateTime is before prev, we will get a positive difference in minutes
   * otherwise negative
   *
   * If the result is -2, dateTime is 2 minutes ahead of prev (ignore seconds)
   * If the result is 0, both dateTime and prev have the same min but different seconds
   * If the result is +1, dateTime is one minute behind prev (ignore seconds)
   */
  public long getMinutesDifference(LocalDateTime dateTime, LocalDateTime prev) {
    // Always take the seconds out of equation to get the right minute difference
    return Duration.between(dateTime.minusSeconds(dateTime.getSecond()), prev.minusSeconds(prev.getSecond())).toMinutes();
  }

  /**
   * This will be called after the stream of timestamps ends to flush out any calculations we were maintainign
   */
  public void flush() {
      // Flush prevCalendar if calendar != null
      if (prev != null) {
        outputValue(prev, calculatePercentileRequestTime(90, prevBuckets));
      }
      // Flush currentCalendar for the same reason
      if (curr != null) {
        outputValue(curr, calculatePercentileRequestTime(90, currentBuckets));
      }
    }

    void outputValue(LocalDateTime dateTime, Double percentileRequestTime) {
      System.out.print(dateTime.minusSeconds(dateTime.getSecond()) +":00Z");
      System.out.print(" ");
      System.out.print(percentileRequestTime);
      System.out.println();
    }

    double calculatePercentileRequestTime(int n, int[] buckets) {
      int totalCount = 0;
      for (int i=0; i<150; i++) {
        totalCount+=buckets[i];
      }

      int sumSoFar = 0;
      int index = 0;

      // NOTE: optimize this calculation
      for (int i=0; i<150; i++) {
        double percentage = ((double)(sumSoFar+buckets[i])/totalCount)*100;
        if (percentage > n) { index = i; break;}
        // Otherwise include buckets[i] in sumSoFar;
        sumSoFar+=buckets[i];
      }
      return index;
    }
  }

