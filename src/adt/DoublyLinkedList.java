/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author All Members
 * @param <T>
 */
public class DoublyLinkedList<T> implements DoublyLinkedListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int nodeCount;

    public boolean insertFront(T newEntry) {
        if (newEntry == null) {
            return false;
        }

        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            nodeCount++;
        } else {
            newNode.next = firstNode;
            firstNode.previous = newNode;
            firstNode = newNode;
            nodeCount++;
        }
        return true;
    }

    public boolean insertBack(T newEntry) {
        if (newEntry == null) {
            return false;
        }

        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
            nodeCount++;
        } else {
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            nodeCount++;
        }
        return true;
    }

    public boolean insertPosition(T newEntry, int position) {
        if (newEntry == null || position < 1 || position > nodeCount + 1) {
            return false;
        }

        Node newNode = new Node(newEntry);

        if (position == 1) {
            insertFront(newEntry);
        } else if (position == nodeCount + 1) {
            insertBack(newEntry);
        } else {
            Node navigator = firstNode;
            for (int i = 1; i < position; i++) {
                navigator = navigator.next;
            }
            newNode.previous = navigator;
            newNode.next = navigator.next;
            navigator.next = newNode;
            nodeCount++;
        }

        return true;
    }

    
    public boolean insertUniqueFront(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        
        Node newNode = new Node(newEntry);
        if (isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            nodeCount++;
        }
        else {
            if (contains(newEntry)) {
                return false;
            }
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            nodeCount++;
        }
        return true;
    }
    
    public boolean insertUniqueBack(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        
        Node newNode = new Node(newEntry);
        if (isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            nodeCount++;
        }
        else {
            if (contains(newEntry)) {
                return false;
            }
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            nodeCount++;
        }
        return true;
    }
    
    public boolean insertUniquePosition(T newEntry, int position) {
        if (newEntry == null || position < 1 || position > nodeCount + 1) {
            return false;
        }
        
        Node newNode = new Node(newEntry); 

        if(position == 1) {
            insertUniqueFront(newEntry);
        }
        else if(position == nodeCount + 1) {
            insertUniqueBack(newEntry);
        }
        else {
            if (contains(newEntry)) {
                return false;
            }
            Node navigator = firstNode;
            for (int i = 1; i < position; i++) {
                navigator = navigator.next;
            }
            newNode.previous = navigator;
            newNode.next = navigator.next;
            navigator.next = newNode;
            nodeCount++;
        }
        
        return true;
    }
    
    public T deleteFront() {
        if (isEmpty()) {
            return null;
        }
        T result = firstNode.data;
        firstNode = firstNode.next;
        firstNode.previous = null;
        nodeCount--;
        return result;
    }

    public T deleteBack() {
        if (isEmpty()) {
            return null;
        }
        T result = lastNode.data;
        lastNode = lastNode.previous;
        lastNode.next = null;
        nodeCount--;
        return result;
    }

    public T deletePosition(int position) {
        if (isEmpty() || position < 1 || position > nodeCount) {
            return null;
        }

        T result;
        if (position == 1) {
            result = deleteFront();
        } else if (position == nodeCount) {
            result = deleteBack();
        } else {
            Node navigator = firstNode;
            for (int i = 1; i < position; i++) {
                navigator = navigator.next;
            }
            result = navigator.data;
            navigator.previous.next = navigator.next;
            navigator.next.previous = navigator.previous;
            
            navigator.next = null;
            navigator.previous = null;
            nodeCount--;
        }

        return result;
    }

    public boolean replacePosition(T newEntry, int position) {
    if (isEmpty() || newEntry == null || position < 1 || position > nodeCount) {
        return false;
    }

    Node navigator = firstNode;
    for (int i = 1; i < position; i++) {
        navigator = navigator.next;
    }

    navigator.data = newEntry;

    return true;
}

    public T getFront() {
        return firstNode.data;
    }

    public T getBack() {
        return lastNode.data;
    }

    public T getPosition(int position) {
        if (isEmpty() || position < 1 || position > nodeCount) {
            return null;
        }

        T result;
        if (position == 1) {
            result = getFront();
        } else if (position == nodeCount) {
            result = getBack();
        } else {
            Node navigator = firstNode;
            for (int i = 1; i < position; i++) {
                navigator = navigator.next;
            }
            result = navigator.data;
        }
        return result;
    }

    public int getCount() {
        return nodeCount;
    }

    public boolean contains(T entry) {
        if (entry != null) {
            Node navigator = firstNode;
            while (navigator != null) {
                if (navigator.data.equals(entry)) {
                    return true;
                }
                navigator = navigator.next;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return nodeCount == 0;
    }

    public boolean clear() {
        firstNode = null;
        lastNode = null;
        nodeCount = 0;
        
        return true;
    }

    private class Node {

        private T data;
        private Node next;
        private Node previous;

        private Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        private Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

}
