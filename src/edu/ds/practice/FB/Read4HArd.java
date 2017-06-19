package edu.ds.practice.FB;

public class Read4HArd {

  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return    The number of characters read
   */
  public int read(char[] buf, int n) {
    char[] buffer = new char[4];
    int readBytes = 0;
    boolean eof = false;
    /*while (!eof) {
      int count = read4(buffer);

      if (count < 4) {
        eof = true;
      }

      int length = Math.min(n-readBytes, count+queue.size());
      int queueSize = queue.size();
      for (int i = 0; i < length; i++) {
        // First read from queue if queue is empty
        // Then read the difference (4-queue.items) from buffer
        // if there are elements in teh buffer, put them in the queue
        buf[readBytes+i] = (!queue.isEmpty()) ?  queue.poll() : buffer[i-queueSize];
      }
      for (int i = length-queueSize < 0 ? 0: length-queueSize; i < count; i++) {
        // read it into the queue, the leftovers
        queue.add(buffer[i]);
      }
      readBytes += (length);
    }*/

    return readBytes;
  }
}
