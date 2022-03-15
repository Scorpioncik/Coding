package com.udemy.list.linked;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> root;
    private int sizeOfList = 0;

    @Override
    public void insert(T data) {
        ++sizeOfList;
        if (root == null) {
            root = new Node<T>(data);
        } else {
            insertDataAtBeginning(data);
        }
    }

    // O(1)
    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    //O(N)
    private void insertDataAtEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertDataAtEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if (root == null) {
            return;
        }

        --sizeOfList;

        if (root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }
    }

    public void reverseRec() {
        root = reverseRec(root, null);
    }

    private Node<T> reverseRec(Node<T> head, Node<T> prev) {
        if(head == null) {
            return prev;
        }
        Node<T> next = head.getNextNode();
        head.setNextNode(prev);
        return reverseRec(next, head);
    }

    /**
     *              A    ->    B   ->   C   ->   D
     *   prev      curr      next
     */
    public void reverseIter() {
        Node<T> prev = null;
        Node<T> current = root;
        while (current != null) {
            Node<T> next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }
        root = prev;
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {
        if (root == null) {
            return;
        }

        Node<T> actualNode = root;
        while (actualNode != null) {
            System.out.print(actualNode + " -> ");
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return sizeOfList;
    }
}
