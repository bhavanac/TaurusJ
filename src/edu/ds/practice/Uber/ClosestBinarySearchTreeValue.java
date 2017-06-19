package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/9/15.
 */
public class ClosestBinarySearchTreeValue {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int closestValue(TreeNode root, double target) {
    return closestValueHelper(root, target, root.val);
  }

  public int closestValueHelper(TreeNode root, double target, int closestMatch) {
    closestMatch =
        Math.abs(target - (double) root.val) < Math.abs(target - (double) closestMatch) ? root.val : closestMatch;
    if (target < root.val) {
      if (root.left == null) {
        return closestMatch;
      }
      return closestValueHelper(root.left, target, closestMatch);
    } else if (target > root.val) {
      if (root.right == null) {
        return closestMatch;
      }
      return closestValueHelper(root.right, target, closestMatch);
    } else {
      return root.val;
    }
  }
}
