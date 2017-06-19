package edu.ds.practice.FB;

public class SubtreeOfAnotherTree {

  void getInorder(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append('$');
      return;
    }

    getInorder(root.left, sb);
    sb.append(root.val);
    getInorder(root.right, sb);
  }

  void getPreorder(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append('$');
      return;
    }

    sb.append(root.val);
    getInorder(root.left, sb);
    getInorder(root.right, sb);
  }

  public boolean isSubtree(TreeNode s, TreeNode t) {
    StringBuilder inS = new StringBuilder();
    getInorder(s, inS);

    StringBuilder inT = new StringBuilder();
    getInorder(t, inT);

    StringBuilder preS = new StringBuilder();
    getPreorder(s, preS);

    StringBuilder pretT = new StringBuilder();
    getPreorder(t, pretT);

    return inS.toString().contains(inT.toString()) && preS.toString().contains(pretT.toString());
  }
}
