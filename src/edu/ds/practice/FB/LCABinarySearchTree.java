package edu.ds.practice.FB;

public class LCABinarySearchTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return root;
    }

    if (((p.val < q.val) && (p.val <= root.val && root.val <= q.val)) ||
        ((q.val < p.val) && (q.val <= root.val && root.val <= p.val))) {
      return root;
    } else if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
  }
}
