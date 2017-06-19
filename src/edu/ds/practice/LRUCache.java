package edu.ds.practice;

import java.util.HashMap;
import java.util.Map;
public class LRUCache {
    int capacity = 0;
    int count = 0;
    Map<Integer, DoubleLinkedList.DLinkedNode> map = new HashMap<>();
    DoubleLinkedList _doubleLinkedList = new DoubleLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            _doubleLinkedList.addNodeToTheEnd(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedList.DLinkedNode node = map.get(key);
            node.value = value;
            _doubleLinkedList.addNodeToTheEnd(node);
            return;
        }

        if (count == capacity) {
            _doubleLinkedList.removeHead();
            count--;
        }

        map.put(key, _doubleLinkedList.add(key, value));
        count++;
    }

    class DoubleLinkedList {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;

            public DLinkedNode(int key, int val) {
                this.key = key;
                this.value = val;
            }

            public DLinkedNode(int key, int val, DLinkedNode pre, DLinkedNode post) {
                this(key, val);
                this.pre = pre;
                this.post = post;

            }
        }

        private DLinkedNode head = null;
        private DLinkedNode tail = null;
        public DoubleLinkedList() {
            head = null;
            tail = null;
        }

        public DLinkedNode add(int key, int val) {
            DLinkedNode nodeToAdd = new DLinkedNode(key, val);
            if (head == null && tail == null) {
                head = tail = nodeToAdd;
                return nodeToAdd;
            }

            tail.post = nodeToAdd;
            nodeToAdd.pre = tail;
            tail = nodeToAdd;
            return nodeToAdd;
        }

        public void removeHead() {
            if (head == null) return;
            map.remove(head.key);
            head = head.post;

            if (head == null) { tail = null; return; }

            head.pre.post = null;
            head.pre = null;
        }

        public void addNodeToTheEnd(DLinkedNode node) {
            if (node == null || node == tail) return;
            if (node == head) head = head.post;

            if (node.pre != null) {
                node.pre.post = node.post;
            }
            if (node.post != null) {
                node.post.pre = node.pre;
            }

            tail.post = node;
            node.pre = tail;
            tail = tail.post;
            tail.post = null;
        }
    }


}