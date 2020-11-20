package rlnitsua.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer, Node> keyNodeMap;
    private final DList dList;
    private final int capacity;

    public LRUCache(int capacity) {
        keyNodeMap = new HashMap<>();
        dList = new DList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyNodeMap.containsKey(key)) {
            Node target = keyNodeMap.get(key);
            dList.moveToLast(target);
            return target.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!keyNodeMap.containsKey(key)) {
            if (keyNodeMap.size() == capacity) {
                keyNodeMap.remove(dList.removeFirst().key);
            }
            Node node = new Node(key, value);
            dList.addLast(node);
            keyNodeMap.put(key, node);
        } else {
            Node target = keyNodeMap.get(key);
            target.value = value;
            dList.moveToLast(target);
        }
    }

    private static class DList {
        Node first;
        Node last;

        void addLast(Node node) {
            if (last == null) {
                first = node;
            } else {
                last.next = node;
                node.pre = last;
            }
            last = node;
        }

        void moveToLast(Node node) {
            addLast(removeNode(node));
        }

        private Node removeNode(Node node) {
            Node pre = node.pre;
            Node next = node.next;

            if (pre == null) {
                first = next;
            } else {
                pre.next = next;
            }

            if (next == null) {
                last = pre;
            } else {
                next.pre = pre;
            }

            return node;
        }

        Node removeFirst() {
            return removeNode(first);
        }
    }

    private static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
