package edu.ds.practice.TopCoder;

import java.util.Stack;

public class InorderTreeIterator {

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  Stack<TreeNode> treeNodes;
  public InorderTreeIterator(TreeNode root) {
    treeNodes = new Stack<TreeNode>();
    TreeNode node = root;
    treeNodes.push(node);

    while (node.left != null) {
      treeNodes.push(node.left);
      node = node.left;
    }
  }

  public boolean hasNext() {
    return !treeNodes.isEmpty();
  }

  public int next() {
    TreeNode node = treeNodes.pop();
    int result = node.val;
    if (node.right != null) {
      node = node.right;

      while (node != null) {
        treeNodes.push(node);
        node = node.left;
      }
    }
    return result;
  }



}
