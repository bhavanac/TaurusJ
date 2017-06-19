package edu.ds.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;


public class RandomizedSet {

  int count = 0;
  Map<Integer, Integer> index;
  Map<Integer, Integer> rIndex;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    index = new HashMap<>();
    rIndex = new HashMap<>();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (index.containsKey(val)) return false;

    index.put(val, count);
    rIndex.put(count, val);
    count++;
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (!index.containsKey(val)) return false;

    int removingIndex = index.get(val);
    // swap the value on removingIndex
    rIndex.put(removingIndex, rIndex.get(count - 1));
    // swap the index value in the main map
    index.put(rIndex.get(count - 1), removingIndex);
    // Remove the actual element
    index.remove(val);
    // Remove from rIndex count-1
    rIndex.remove(count - 1);
    // Decrement the count;
    count--;
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    System.out.println("count " + count);
    Random random = new Random();
    int randomIndex = random.nextInt() % count;
    System.out.println(randomIndex);
    return rIndex.get(randomIndex);
  }

  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] c = s.toCharArray();
    int max = 0;
    for (int i = 0; i < c.length; i++) {
      map.put(c[i], map.getOrDefault(c[i], 0) + 1);
      max = Math.max(max, map.get(c[i]));
    }

    List<Character>[] bucket = new List[s.length() + 1];
    for (char key : map.keySet()) {
      int frequency = map.get(key);
      if (bucket[frequency] == null) {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    StringBuilder sb = new StringBuilder();
    for (int pos = bucket.length - 1; pos >= 0; pos--) {
      if (bucket[pos] != null) {
        for (char num : bucket[pos]) {
          for (int i = 0; i < map.get(num); i++) {
            sb.append(num);
          }
        }
      }
    }
    return sb.toString();
  }

  public String fractionToDecimal1(int numerator, int denominator) {
  StringBuilder result = new StringBuilder();
  String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
  long num = Math.abs((long) numerator);
  long den = Math.abs((long) denominator);
  result.append(sign);
  result.append(num/den);
  long remainder = num % den;
  if(remainder==0)
      return result.toString();
  result.append(".");
  HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
  while(!hashMap.containsKey(remainder))

  {
    hashMap.put(remainder, result.length());
    result.append(10 * remainder / den);
    remainder = 10 * remainder % den;
  }

  int index = hashMap.get(remainder);
  result.insert(index,"(");
  result.append(")");
  return result.toString().replace("(0)","");

}
  public List<String> findRepeatedDnaSequences(String s) {
    Map<String, Integer> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    for (int i = 0; i <= s.length() - 10; i++) {
      if (map.containsKey(s.substring(i,i+10))) {
        if (map.get(s.substring(i,i+10)) == 1) result.add(s.substring(i,i+10));
      }
      map.put(s.substring(i,i+10), map.getOrDefault(s.substring(i,i+10), 0)+1);
    }
    return result;
  }

  public int hIndex(int[] citations) {

    Arrays.sort(citations);
    // My max H can be citations.size()
    // so start from that
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int index = 0;
    for (int i = 0; i < citations[citations.length-1]; i++) {
      while (i > citations[index]) {
       index++;
      }
      map.put(i, citations.length-index);
      if (i == citations.length-index)  max = i;
    }
    return max;
  }

  public String getHint(String secret, String guess) {
    int[] digits = new int[10];
    for (int i = 0; i < secret.length(); i++) {
      digits[secret.charAt(i) - '0']++;
    }

    int bulls = 0;
    int cows = 0;
    for (int i = 0; i < guess.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bulls++;
        if (digits[guess.charAt(i) - '0'] == 0) cows--;
      }
      else if (digits[guess.charAt(i) - '0'] > 0) cows++;
      if (digits[guess.charAt(i) - '0'] > 0 ) digits[guess.charAt(i) - '0']--;
    }
    return bulls+"A"+cows+"B";
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) return (l1 == null) ? l2: l1;
    int borrow = 0;
    ListNode curr = new ListNode(-1);
    ListNode result = curr;
    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + borrow;
      borrow = sum/10;
      curr.next = new ListNode(sum%10);
      curr = curr.next; l1 = l1.next; l2 = l2.next;
    }

    ListNode rest = (l1 == null) ? l2 : l1;
    while (rest != null) {
      int sum = rest.val + borrow;
      borrow = sum/10;
      curr.next = new ListNode(sum%10);
      curr = curr.next;
      rest = rest.next;
    }

    if (borrow != 0) {
      curr.next = new ListNode(borrow);
    }

    return result.next;
  }

  public String convert(String s, int numRows) {
    char[] c = s.toCharArray();
    StringBuilder[] sb = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      sb[i] = new StringBuilder();
    }


    int len = s.length();
    int i = 0;
    while (i < len) {
      for (int idx = 0; idx < numRows && i < len; idx++) {
        sb[idx].append(c[i++]);
      }

      for (int idx = numRows-2; idx > 0 && i < len; idx--) {
        sb[idx].append(c[i++]);
      }
    }

    for (int j = 1; j < numRows; j++) {
      sb[0].append(sb[j].toString());
    }

    return sb[0].toString();
  }

  public int romanToInt(String s) {
    Map<String, Integer> map = new HashMap<>();
    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);
    map.put("IV", 4);
    map.put("IX", 9);
    map.put("XL", 40);
    map.put("XC", 90);
    map.put("CD", 400);
    map.put("CM", 900);

    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i < s.length()-1 && map.containsKey(s.substring(i,i+2))) {
        result += map.get(s.substring(i, i+2));
      } else if (map.containsKey(s.charAt(i))) {
        result += map.get(s.charAt(i));
      }
    }
    return result;
  }

  public String intToRoman(int num) {
    int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strings = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I" };

    StringBuilder sb = new StringBuilder();
    int index = 0;
    while (num != 0) {
      if (num >= nums[index]) {
        sb.append(strings[index]);
        num -= nums[index];
      } else {
        index++;
      }
    }
    return sb.toString();
  }

  public int getSum(int a, int b) {
    if(b == 0) return a;
    int carry = (a & b) << 1;
    int sum = a ^ b;
    return getSum(sum, carry);
  }

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int result = 0;
    while (n != 0) {
      if (n%2 != 0) result++;
      n = n/2;
    }
    return result;
  }

  public String reverseWords(String s) {
    String[] parts = s.trim().split("\\s+");
    String out = "";
    for (int i = parts.length - 1; i > 0; i--) {
      out += parts[i] + " ";
    }
    Deque list = new ArrayDeque<>();
    return out + parts[0];
  }


  public int lengthLongestPath(String input) {
      String[] tokens = input.split("\n");
      int result = 0;
      int curLen = 0;
      Stack<Integer> stack = new Stack<>();

      for (String token : tokens) {
          int level = countLevel(token);

          while (stack.size() > level) {
              curLen -= stack.pop();
          }

          int len = token.replaceAll("\t","").length()+1;
          curLen = curLen+len;

          if (token.contains(".")) {
              result = (curLen > result) ? curLen - 1 : result;
          }
          stack.push(len);
      }
      return result;
  }

    private int countLevel(String token) {
        String newString = token.replaceAll("\t", "");
        return token.length() - newString.length();
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        int runner = 0;
        while (runner != nums.length) {
            while (runner < nums.length && nums[runner] == 0) runner++;
            // swap index and runner if they are not equal
            if (runner == index) continue;
            nums[index++] = nums[runner++];
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        int len = digits.length;
        int carry = 1;
        int index = len-1;
        int index1 = len;
        while (index >= 0) {
            int num = digits[index]+carry;
            result[index1] = num%10;
            carry = num/10;
            index--; index1--;
        }
        if (carry != 0) { result[index1] = carry; return result; }
        else { return Arrays.copyOfRange(result, 1, result.length); }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i-1 > 0 && nums[i] == nums[i-1])  continue;

            int start = i+1; int end = nums.length-1;
            while (start < end) {
                int sum = nums[i]+nums[start]+nums[end];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < nums.length && nums[start] == nums[start+1]) start++;
                    while (end >= 0 && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

    class Point {
        int x;
        int y;
             Point() { x = 0; y = 0; }
             Point(int a, int b) { x = a; y = b; }
         }
    public int maxPoints(Point[] points) {
        Point[] points1 = new Point[]{new Point(2, 3), new Point(3, 3), new Point(-5, 3)};
        points = points1;
        if (points.length == 0 || points.length == 1) return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> counts = new HashMap<>();
            int duplicates = 0;
            for (int j = i + 1; j < points.length; j++) {
                if ((points[i].x == points[j].x) && (points[i].y == points[j].y)) {
                    duplicates++;
                } else if (points[i].x == points[j].x) {
                    counts.put((double) Integer.MAX_VALUE, counts.getOrDefault((double) Integer.MAX_VALUE, 0) + 1);
                } else {
                    double slope = getSlope(points[i], points[j]);
                    counts.put(slope, counts.getOrDefault(slope, 0) + 1);
                }
            }
            int local_max = 0;
            for (Integer count : counts.values()) {
                local_max = Math.max(local_max, count);
            }

            max = Math.max(local_max + duplicates + 1, max);
            counts.clear();
        }
        return max;
    }


    private double getSlope(Point point, Point point1) {
        double k =  (double)(point1.y - point.y) / (double)(point1.x - point.x);
        if (k == -0.0) return Math.abs(k); else return k;
    }

    private int[] id;
    private int[] sz;
    private int N; // number of rows
    private int M; // number of columns

    int find(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    void union(int p, int q) {
        int rootp = id[p];
        int rootq = id[q];
        if (rootp == rootq) return;

        if (sz[rootp] > sz[rootq]) { // rootq is smaller
            id[rootq] = rootp;
            sz[rootp] = sz[rootp] + sz[rootq];
        } else { // rootp is smaller
            id[rootp] = rootq;
            sz[rootq] = sz[rootq] + sz[rootp];
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length ==0) return 0;
        N = grid.length;
        M = grid[0].length;
        sz = new int[N*M];
        id = new int[N*M];
        for (int i = 0; i < N*M; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] != 0) {
                    int tmp = i*M+j;
                    if (isInternal(i-1,j,N,M) && grid[i-1][j] == 1) union(tmp, tmp-M);
                    if (isInternal(i,j-1,N,M) && grid[i][j-1] == 1) union(tmp, tmp-1);
                    if (isInternal(i,j+1,N,M) && grid[i][j+1] == 1) union(tmp, tmp+1);
                    if (isInternal(i+1,j,N,M) && grid[i+1][j] == 1) union(tmp, tmp+M);
                }
            }
        }

        int islands = 0, i=0;
        while (i <N*M) {
            if (id[i] == i && grid[i/M][i%M] == 1) islands++;
            i++;
        }
        return islands;
    }



    public int findMin(int[] nums) {
        // binary search, take the side which is screwed
        return findMinHelper(nums, 0, nums.length);
    }

    private int findMinHelper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else if (end - start == 1) {
            return (nums[start] < nums[end] ? nums[start] : nums[end]);
        }

        int mid = ((end - start)/2)+start;
        // right
        if (nums[mid] > nums[end]) {
            return findMinHelper(nums, mid, end);
        } else if (nums[mid] < nums[start]) {
            return findMinHelper(nums, start, mid);
        } else {
            // its not rotated;
            return nums[start];
        }
    }

    public int maxProfit(int[] prices) {
        prices = new int[]{6,1,3,2,4,7};
        int max = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            int profit = prices[i] - prices[i - 1];
            if (profit > 0) {
                max += profit;
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (result + nums[i] < 0) {
                result = 0;
            } else {
                result = result + nums[i];
                maxSum = Math.max(maxSum, result);
            }
        }

        return maxSum;

    }

    // 2, 1, 1, 2
    //
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return (nums[0] > nums[1]) ? nums[0] : nums[1];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int start, int end) {
        if (start > end) return Integer.MIN_VALUE;

        int[][] dp = new int[end-start+1][2];
        // dp[i][0] means we don't rob the current house;
        // dp[i][1] means we rob the current house
        dp[start][0] = 0;
        dp[start][1] = nums[0];
        for (int i = start+1; i <= end; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums[i]+dp[i-1][0];
        }
        return Math.max(dp[end][0], dp[end][1]);

    }

    // 4 cases
        // 0 [1 .... n-1] n
        // take 0 [1 .... n-1][0] // that means i didn't include n-1, so i can include n....
        // take 0 [1 .... n-1][1] // i shouldn't include n-1
        //
        // Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if(dp[i][j] == 1) { dp[i][j] = 0; continue; }
                dp[i][j] += (isInternal(i, j + 1, m, n) ? dp[i][j + 1] : 0);
                dp[i][j] += (isInternal(i + 1, j, m, n) ? dp[i + 1][j] : 0);
            }
        }
        return dp[0][0];
    }

    boolean isInternal(int row, int column, int rows, int columns) {
        return (row>=0 && column>=0 && row<rows && column<columns);
    }
}