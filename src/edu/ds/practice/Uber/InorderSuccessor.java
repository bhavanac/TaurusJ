package edu.ds.practice.Uber;

import java.util.Stack;


public class InorderSuccessor {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode getInorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) {
      return null;
    }

    TreeNode current = root;
    Stack<TreeNode> parents = new Stack<TreeNode>();
    while (current != null) {
      if (current != p) {
        parents.push(current);
        if (current.val < p.val) {
          current = current.right;
        } else if (current.val > p.val) {
          current = current.left;
        }
      } else {
        break;
      }
    }

    // Couldn't find p in the tree
    if (current == null) {
      return null;
    }

    // CASE 1 - Right child is present, return the leftmost node of right subtree
    // CASE 2 - Right child is not present, until we find a parent of p where it is the left child, then return that parent
    if (current.right == null) {
      while (!parents.isEmpty()) {
        TreeNode element = parents.pop();
        if (element.left == current) {
          return element;
        }
        current = element;
      }
    } else {
      current = current.right;
      while (current.left != null) {
        current = current.left;
      }
      return current;
    }

    return null;
  }
}
