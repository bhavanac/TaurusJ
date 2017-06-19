package edu.ds.practice.Uber;

import java.util.Stack;


/**
 * Created by bchalla on 11/9/15.
 */
public class InorderPredecessor {
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
      if (current == p) {
        break;
      }
      parents.push(current);
      if (current.val < p.val) {
        current = current.right;
      } else if (current.val > p.val) {
        current = current.left;
      }
    }

    // Couldn't find p in the tree
    if (current == null) {
      return null;
    }

    // CASE 1 - Left child is present, return the rightmost node of left subtree
    // CASE 2 - Left child is not present, until we find a parent of p where it is the right child, then return that parent
    if (current.left == null) {
      while (!parents.isEmpty()) {
        TreeNode element = parents.pop();
        if (element.right == current) {
          return element;
        }
        current = element;
      }
    } else {
      current = current.left;
      while (current.right != null) {
        current = current.right;
      }
      return current;
    }

    return null;
  }
}

