package edu.ds.practice.FB;

import java.util.Stack;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InOrderSuccessor {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null || p == null) return null;
    Stack<TreeNode> parents = new Stack<>();

    // First find p in BST
    TreeNode current = root;
    while (current != null) {
      if (p == current) break;

      parents.push(current);
      if (p.val > current.val) { current = current.right; }
      else { current = current.left; }
    }

    // CASE 1 - If p has a right child and right child has a left subtree
    // CASE 2 - IF p has a right child and right child has no left subtree
    // CASE 3 - If p does not have a right child
    if (current != null) {
      if (current.right != null) {
        current = current.right;
        while (current.left != null) {
          current = current.left;
        }
        return current;
      }

      // CASE 3
      while (!parents.empty()) {
        TreeNode parent = parents.pop();
        if (parent.left == current) {
          return parent;
        }
        current = parent;
      }
    }
    return null;
  }
}