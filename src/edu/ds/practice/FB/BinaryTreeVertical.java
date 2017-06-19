package edu.ds.practice.FB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;


public class BinaryTreeVertical {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  class TreeNodeCol {
    TreeNode node;
    int col;
    TreeNodeCol(TreeNode node, int col) { this.node = node; this.col = col; }
  }

  public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
      Map<Integer, List<Integer>> result = new HashMap<>();
      Queue<TreeNodeCol> queue = new LinkedList<>();
      queue.add(new TreeNodeCol(root,0));

      while (!queue.isEmpty()) {
        TreeNodeCol treeNodeCol = queue.poll();
        List<Integer> current = result.getOrDefault(treeNodeCol.col, new ArrayList<>());
        current.add(treeNodeCol.node.val);

        if (treeNodeCol.node.left != null) {
          queue.add(new TreeNodeCol(treeNodeCol.node.left, treeNodeCol.col--));
        }
        if (treeNodeCol.node.right != null) {
          queue.add(new TreeNodeCol(treeNodeCol.node.right, treeNodeCol.col++));
        }
      }

      return result.values().stream().collect(Collectors.toList());
    }
  }

}
