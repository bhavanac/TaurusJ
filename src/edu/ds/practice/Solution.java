package edu.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> reverseMap = new HashMap<>();
        String[] strings = new String[26];
        String[] splits = str.split(" ");
        if (pattern.length() != splits.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (strings[ch-'a'] == null) {
                strings[ch - 'a'] = splits[i];
                if (reverseMap.containsKey(splits[i])) return false;
                reverseMap.put(splits[i], ch);
            }
            if (!(strings[ch-'a'].equals(splits[i])))
                return false;
        }
        return true;
    }
    public String[] findWords(String[] words) {
        int[] dict = new int[]{1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
        List<String> result = new ArrayList<>();
        for (int i = 0; i<words.length; i++) {
            String curr = words[i];
            if (curr.length() == 0) { result.add(curr); continue; }
            int j;
            for (j = 0; j<curr.length(); j++) {
                if (dict[curr.charAt(0)-'a'] == dict[curr.charAt(j)-'a']) continue;
            }
            if (j == curr.length()) result.add(curr);
        }
        return result.toArray(new String[result.size()]);
    }
    public int distributeCandies(int[] candies) {
        int maxCandies = candies.length/2;
        int uniqueCandies = 0;
        Map<Integer,Integer> distinctCandies = new HashMap<>();
        for (int i = 0; i < candies.length; i++) {
            if (!distinctCandies.containsKey(candies[i])) {
                uniqueCandies++;
            }
            distinctCandies.put(candies[i], distinctCandies.getOrDefault(candies[i],0)+1);
        }
        return  (uniqueCandies > maxCandies) ? maxCandies : uniqueCandies;
    }

    public char findTheDifference(String s, String t) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            dict[t.charAt(i)-'a']--;
            if (dict[t.charAt(i)-'a'] == -1) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

    public boolean isHappy(int n) {
        Set<Integer> result = new HashSet<>();
        result.add(n);
        int sum = n;
        while (sum != 1) {
            sum = getSquaredSum(n);
            if (result.contains(sum)) return false;
            n = sum;
        }
        return true;
    }

    private int getSquaredSum(int n) {
        int totalSum = 0;
        while (n != 0) {
            int rem = n%10;
            totalSum += (rem*rem);
            n = n/10;
        }
        return totalSum;
    }
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (t.charAt(i) != map.get(s.charAt(i))) return false;
            } else if (reverseMap.containsKey(t.charAt(i))) {
                if (reverseMap.get(t.charAt(i)) != s.charAt(i)) return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
                reverseMap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) return false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        for (int i = k+1; i <= nums.length-k; i++) {
            set.remove(nums[i-k-1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> distinct = new HashMap<>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!(distinct.containsKey(s.charAt(i)))) {
                distinct.put(s.charAt(i), i);
                count++;
                if (count > max) max = count;
            } else {
                int index = distinct.get(s.charAt(i));
                count = i-index;
                distinct.put(s.charAt(i), i);
            }
        }
        return max;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                map.put(C[i]+C[j], map.getOrDefault(C[i]+C[j], 0)+1);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                count += map.getOrDefault(-1*(A[i]+B[j]),0);
            }
        }
        return count;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                if (map.containsKey(nums[i] + nums[j])) {
                    map.get(nums[i] + nums[j]).add(list);
                } else {
                    List<List<Integer>> current = new ArrayList<>();
                    current.add(list);
                    map.put(nums[i] + nums[j], current);
                }

                if (map.containsKey(target - (nums[i] + nums[j]))) {
                    List<List<Integer>> currResult = map.get(nums[i] + nums[j]);
                    for (List currList : currResult) {
                        List<Integer> tobeAdded = new ArrayList<>(currList);
                        tobeAdded.add(nums[i]);
                        tobeAdded.add(nums[j]);
                      Random random = new Random();
                      random.nextInt();
                    }
                }
            }
        }

        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = new String(ch);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
