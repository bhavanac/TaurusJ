package edu.ds.practice.Uber;

/**
 * Created by bchalla on 11/9/15.
 */
public class TournamentTree {
  /**
   * A tournament tree is a binary tree
   * where the parent is the minimum of the two children.
   * Given a tournament tree find the second minimum value in the tree.
   * A node in the tree will always have 2 or 0 children.
   * Also all leaves will have distinct and unique values.
   *     2
   *    / \
   *   2   3
   *  / \  | \
   * 4   2 5  3
   *
   * In this given tree the answer is 3.
   */
  class Node {
    Integer value;
    Node left, right;
    Node(Integer value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }
  /**
   * This should return the second minimum
   * int value in the given tournament tree
   */
  public static Integer secondMin(Node root) {
    if (root == null || (root.right == null || root.right == null)) {
      return null;
    }

    Integer closest = (root.left.value == root.value) ? root.right.value : root.left.value;
    Node closestNode = (root.left.value == root.value) ? root.left : root.right;
    return secondMinHelper(closestNode, closest);
  }

  public static Integer secondMinHelper(Node root, Integer closest) {
    if (root.right == null && root.left == null) {
      return closest;
    }

    Integer newClosest = (root.left.value == root.value) ? root.right.value : root.left.value;
    closest = (newClosest < closest) ? newClosest : closest;
    Node closestNode = (root.left.value == root.value) ? root.left : root.right;

    return secondMinHelper(closestNode, closest);
  }
}
