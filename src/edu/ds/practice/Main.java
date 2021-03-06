package edu.ds.practice;

import edu.ds.practice.SquareSpace.Percentile;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;


public class Main {

    public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        // You should not try to calculate an exact number <-- key piece of information
        // Problem can be broken down into two pieces
        // How do we aggregate the data for one minute
        // Also if there are million data points, how do we approximate
        // Possibly use Data to get the seconds
        // At 10:01:00 - I am trying to calculate 10:00:00 so disregard any data apart from that
        // One possible way is bucketing. Since our range (0 - 150 ms) is much smaller, we can have buckets for
        // each ms
        // our hashing into the buc;ket strategy would be anything between 60.0000 to 60.9999 should go into 60
        // bucket. Ideally an array would give us 0(1) access since we know the index we want to increment.

        Percentile percentile = new Percentile(90);
        LocalDateTime one = LocalDateTime.ofInstant(Instant.ofEpochSecond(962668800), ZoneOffset.UTC); //59:09
        LocalDateTime two = LocalDateTime.ofInstant(Instant.ofEpochSecond(962668760), ZoneOffset.UTC); //00:00
        System.out.println(Duration.between(one, two).abs().getSeconds());
        System.out.println(Duration.between(one, two).getSeconds() < 60 && one.getMinute() == two.getMinute());

        System.out.println(one);
        System.out.println(two);
        System.out.println(isLessThan(one, two));
        System.out.println(percentile.getMinutesDifference(one, two));

        List<String> list = new ArrayList<>();
        list.add("962668800 60.5");

        list.add("962668800 60.5");
        list.add("962668800 60.5");
        list.add("962668800 60.5");
        list.add("962668800 60.5");
        list.add("962668800 60.5");
        list.add("962668800 60.5");
        list.add("962668800 60.5");
        list.add("962668800 60.5");

        list.add("962667000 60.5");
        /*list.add("962668801 61.5");
        list.add("962668802 62.5");
        list.add("962668803 63.5");
        list.add("962668804 64.5");
        list.add("962668805 65.5");
        list.add("962668806 66.5");
        list.add("962668807 67.5");
        list.add("962668808 68.5");
        list.add("962668809 69.5");
        list.add("962668810 70.5");
        list.add("962668860 71.5");*/
        int index = 0;
        while (index < list.size()) {
            String input = list.get(index);
            String[] numbers = input.split(" ");
            percentile.read(Integer.parseInt(numbers[0]), Double.parseDouble(numbers[1]));
            index++;
        }
        percentile.flush();

    }

    private static long getMinutesDifference(LocalDateTime dateTime, LocalDateTime prev) {
        return Duration.between(dateTime, prev).toMinutes();
    }

    private static boolean isLessThan(LocalDateTime dateTime, LocalDateTime prev) {
        return dateTime.isBefore(prev) && dateTime.getMinute() != prev.getMinute();
    }

    public int titleToNumber(String s) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        char[] charArray = s.toCharArray();
        int result = 0;
        for (char c: charArray) {
            result = result*26 + nums[c-'A'];
        }
        return result;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c: charArray) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (map.get(charArray[i]) == 1) return i;
        }
        return -1;
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return null;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(1);
        result.add(current);

        int level = 1;
        while (level != numRows) {
            List<Integer> prepare = new ArrayList<>();
            prepare.add(1);
            for(int i = 0; i<current.size()-1; i++) {
                prepare.add(current.get(i) + current.get(i+1));
            }
            prepare.add(1);
            result.add(prepare);
            level++;
            current = prepare;
        }
        return result;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) return nums.length;

        int index = 0;
        for (int i = 1; i <nums.length; i++) {
            if (nums[index] == nums[i]) continue;
            nums[++index] = nums[i];
        }
        return index+1;
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";

        int currentLevel = 1;
        String current = "1";
        while (currentLevel != n) {
            StringBuilder sb = new StringBuilder();

            // Start counting till the next char is different from the current char
            int level = 1;
            for (int i = 0; i < current.length() - 1; i++) {
                if (current.charAt(i) != current.charAt(i+1)) {
                    sb.append(level);
                    sb.append(current.charAt(i));
                    level = 1;
                    continue;
                }
                level++;
            }
            sb.append(level);
            sb.append(current.charAt(current.length()-1));

            currentLevel++;
            current = sb.toString();
        }

        return current;
    }

    public boolean isValid(String s) {
        Set<Character> opening = new HashSet<>();
        opening.add('(');
        opening.add('{');
        opening.add('[');

        Map<Character, Character> closing = new HashMap<>();
        closing.put(')', '(');
        closing.put('}', '{');
        closing.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            if (opening.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }

            if (!closing.containsKey(s.charAt(i))) return false;
            if (!closing.get(s.charAt(i)).equals(stack.pop())) return false;
        }

        return stack.isEmpty();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return null;

        int index = -1;
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (!(strs[0].length() > index+1))  return sb.toString();

            int count = 0;
            char current = strs[0].charAt(index+1);
            for (String s : strs) {
                if (!(s.length() > index+1)) return sb.toString();

                if (current == s.charAt(index+1)) count++;
            }
            if (count == strs.length) {
                sb.append(current);
                index++;
                continue;
            }
            return sb.toString();
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;

        int i = 0;
        int j=s.length()-1;
        while (i < j) {
            while (i < s.length()-1 && !Character.isLetterOrDigit(s.charAt(i))) { i++; }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) { j--; }
            if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }

        return true;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, tmp=1; i < nums.length; i++) {
            result[i] *= tmp;
            tmp *= nums[i];
        }

        for (int i = nums.length-1, tmp=1; i >= 0 ; i--) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = treeMap.getOrDefault(entry.getValue(), new ArrayList<>());
            list.add(entry.getKey());
            treeMap.put(entry.getValue(), list);
        }

        List<Integer> result = new ArrayList<>();
        while (result.size() < k) {
            Map.Entry<Integer, List<Integer>> listt = treeMap.pollLastEntry();
            if (listt.getValue().size() < k) {
                result.addAll(listt.getValue());
            } else {
                result.addAll(listt.getValue().subList(0, k - result.size()));
            }
        }
        return result;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(nums, 0, nums.length-1, list);
        return list;
    }

    private static void permuteHelper(int[] nums, int start, int end, List<List<Integer>> list) {
        if (start == nums.length-1) {
            List<Integer> result = new ArrayList<Integer>() {{ for (int i : nums) add(i); }};
            list.add(result);
        }

        for (int i = start; i <= end; i++) {
            if (i != start) {
                // find the next greatest number
                while ((i <= end && nums[i] == nums[start]) || (i <= end && i > 0 && nums[i-1] == nums[i])) i++;
                if (i > end) break;
                swap(nums, start, i);
            }
            permuteHelper(nums, start+1, end, list);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
