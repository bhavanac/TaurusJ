package edu.ds.practice.FB;

public class SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (isLeaf(root.left)) {
      return root.left.val + sumOfLeftLeaves(root.right);
    }

    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

  }

  boolean isLeaf(TreeNode root) {
    return root != null && root.left == null && root.right == null;
  }
}
