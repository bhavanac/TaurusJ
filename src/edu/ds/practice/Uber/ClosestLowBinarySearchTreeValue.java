package edu.ds.practice.Uber;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by bchalla on 11/9/15.
 */
public class ClosestLowBinarySearchTreeValue {
  private TreeNode root = null;
  public int closestValue(double target) {
    return closestValueHelper(root, target, root.val);
  }

  public int closestValueHelper1(TreeNode root, double target, int closestMatch) {
      if (root == null) {
        return closestMatch;
      }
      if (root.val > target) {
        return closestValueHelper1(root.left, target, closestMatch);
      } else if (root.val < target) {
        return closestValueHelper1(root.right, target, root.val);
      } else {
        return root.val;
      }
    }


  public int closestValueHelper(TreeNode root, double target, int closestMatch) {
    if (root == null) {
      return closestMatch;
    }
    if (root.val > target) {
      return closestValueHelper(root.left, target, closestMatch);
    } else if (root.val < target) {
      if (closestMatch > root.val) {
        closestMatch = root.val;
      }
      return closestValueHelper(root.right, target, closestMatch);
    } else {
      return root.val;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public void insertBST(int val) {
    TreeNode treeNode = new TreeNode(val);
    if (root == null) {
      root = treeNode;
      return;
    }

    TreeNode current = root;
    while (current != null) {
      if (current.val < val) {
        if (current.right == null) {
          current.right = treeNode;
          break;
        }
        current = current.right;
      } else {
        if (current.left == null) {
          current.left = treeNode;
          break;
        }
        current = current.left;
      }
    }

    current = treeNode;
  }

  public void levelOrder() {
    List<List<Integer>> finalList = new LinkedList<List<Integer>>();
    if (root == null) {
      return;
    }

    Queue<TreeNode> parentList = new java.util.LinkedList<TreeNode>();
    parentList.add(root);

    while (!parentList.isEmpty()) {
      List<Integer> list = new java.util.LinkedList<Integer>();
      Queue<TreeNode> childList = new java.util.LinkedList<TreeNode>();
      while (!parentList.isEmpty()) {
        TreeNode current = parentList.remove();
        list.add(current.val);
        if (current.left != null) {
          childList.add(current.left);
        }

        if (current.right != null) {
          childList.add(current.right);
        }
      }
      finalList.add(list);
      parentList = childList;
    }

    for (int i=0; i<finalList.size(); i++) {
      List<Integer> list = finalList.get(i);
      for (int j=0; j<list.size(); j++) {
        System.out.print(list.get(j) + " ");
      }
      System.out.println("");
    }
  }
}
