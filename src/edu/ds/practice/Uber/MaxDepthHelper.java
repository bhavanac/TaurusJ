package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/11/15.
 */
public class MaxDepthHelper {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int maxDepth(TreeNode root) {
    return maxDepthHelper(root);
  }

  private int maxDepthHelper(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = maxDepthHelper(root.left);
    int rightDepth = maxDepthHelper(root.right);
    return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
  }
}
