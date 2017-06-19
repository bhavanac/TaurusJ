package edu.ds.practice.Uber;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


/**
 * Created by bchalla on 11/10/15.
 */
public class SerializeAndDeserialize {
  /** A binary tree. */
  static class BT {

    private final Node root;

    public BT(Node root) {
      this.root = root;
    }

    public Node getRoot() {
      return root;
    }

    static class Node {

      private int data;
      private Node left = null;
      private Node right = null;

      public Node() {}

      public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
      }

      public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
      }

      public Node getLeft() {
        return left;
      }
      public void setLeft(Node n) {
        left = n;
      }

      public Node getRight() {
        return right;
      }
      public void setRight(Node n) {
        right = n;
      }

      public int getData() {
        return data;
      }

      public void setData(int d) {
        data = d;
      }
    }
  }

  public BT readBT(String fileName) throws IOException {
    Scanner reader = new Scanner(fileName);
    BT bt = null;
    reader.useDelimiter(" ");

    return new BT(readBT1(reader));
  }

  private BT.Node readBT1(Scanner reader) {
     if (reader.hasNext()) {
      if (reader.next() == "#") {
        return null;
      }

      String data = reader.next();
      BT.Node node = new BT.Node();
      node.data = Integer.parseInt(data);
      node.setLeft(readBT1(reader));
      node.setRight(readBT1(reader));
      return node;
    }
    return null;
  }

  public void writeBT(BT bt, String fileName) throws IOException {
    ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
    if(null != bt) {
      writeBT(bt.getRoot(), writer);
    }
  }

  private void writeBT(BT.Node node, ObjectOutputStream writer)
      throws IOException {
    if (node == null) {
      writer.writeChars("# ");
    } else {
      writer.writeChars(node.getData() + " ");
      writeBT(node.getLeft(), writer);
      writeBT(node.getRight(), writer);
    }
  }
}
