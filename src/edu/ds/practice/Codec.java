package edu.ds.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;


public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> deque = new ArrayDeque<>();
        sb.append(root.val+",");
        deque.add(root);
        while (!deque.isEmpty()) {
            Deque<TreeNode> currentQueue = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode current = deque.poll();
                // I add the children of dequeu to string and currentQueue
                sb.append(current.left == null ? "#," : current.left.val + ",");
                sb.append(current.right == null ? "#," : current.right.val + ",");
                if (current.left != null) currentQueue.add(current.left);
                if (current.right != null) currentQueue.add(current.right);
            }
            deque = currentQueue;
        }

        return sb.toString().substring(sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] parts = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(parts[0]));
        int index = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            Deque<TreeNode> currentQueue = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                TreeNode current = deque.poll();
                if (index < parts.length && !parts[index].equals("#")) {
                    current.left = new TreeNode(Integer.valueOf(parts[index]));
                    currentQueue.add(current.left);
                }
                index++;
                if (index < parts.length && !parts[index].equals("#")) {
                    current.right = new TreeNode(Integer.valueOf(parts[index]));
                    currentQueue.add(current.right);
                }
                index++;
            }
            deque = currentQueue;
        }

        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Deque<Integer> current = new ArrayDeque<>();
        current.push(Integer.valueOf(tokens[0]));
        int index = 1;
        while (!current.isEmpty()) {
            if (!isOperator(tokens[index])) {
                current.push(Integer.valueOf(tokens[index]));
            } else {
                int num1 = current.pop();
                int num2 = current.pop();
                switch (tokens[index]) {
                    case "+":
                        current.push(num1+num2);
                        break;
                    case "-":
                        current.push(num2-num1);
                        break;
                    case "/":
                        current.push(num2/num1);
                        break;
                    case "*":
                        current.push(num1*num2);
                        break;
                }
            }
            index++;
        }
        return current.pop();
    }

    boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    Comparator<String> largestNumberComparator = (o1, o2) -> {
        String char1 = String.valueOf(o1);
        String char2 = String.valueOf(o2);

        // Case 1 Strings are equal
        if (char1.equals(char2)) return 0;

        // Case 2 one is a substring of other
        if (char1.startsWith(char2)) return -1;
        if (char2.startsWith(char1)) return 1;

        // Case 3 one character should be more than the other
        char[] num1 = String.valueOf(o1).toCharArray();
        char[] num2 = String.valueOf(o2).toCharArray();
        int i=0,j=0;
        while (num1[i] == num2[j]) {
            i++;
            j++;
        }
        if (num1[i] > num2[j]) {
            return 1;
        }
        return -1;
    };
    public String largestNumber(int[] nums) {
        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            s_num[i] = String.valueOf(nums[i]);

        Arrays.sort(s_num, largestNumberComparator);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.insert(0, s);

        return sb.toString();
    }

    public void sortColors(int[] nums) {
        // 0 - red
        // 1 - white
        // 2 - blue
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) red++;
            else if (nums[i] == 1) white++;
            else blue++;
        }
        int index = 0;
        while (!(red <= 0)) { nums[index++] = 0; red--; }
        while (!(white <= 0)) { nums[index++] = 1; white--; }
        while (!(blue <= 0)) { nums[index++] = 2; blue--; }
    }
}