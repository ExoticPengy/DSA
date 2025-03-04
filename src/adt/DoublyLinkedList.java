/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author MingLi
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
            nodeCount += 1;
        }
        else {
            newNode.next = firstNode;
            firstNode.previous = newNode;
            firstNode = newNode;
            nodeCount += 1;
        }
        return true;
    }
    
    public boolean insertBack(T newEntry) {
        if (newEntry == null) {
            return false;
        }
        
        Node newNode = new Node(newEntry);
        if (isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
            nodeCount += 1;
        }
        else {
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            nodeCount += 1;
        }
        return true;
    }
    
    public boolean insertPosition(T newEntry, int position) {
        if (newEntry == null) {
            return false;
        }
        
        if (position > 0 && position <= nodeCount + 1) {
            Node newNode = new Node(newEntry); 
            
            if(position == 1) {
                insertFront(newEntry);
            }
            else if(position == nodeCount + 1) {
                insertBack(newEntry);
            }
            else {
                Node navigator = firstNode;
            for (int i = 0; i < position; i++) {
                navigator = navigator.next;
            }
            newNode.previous = navigator;
            newNode.next = navigator.next;
            navigator.next = newNode;
            }
        }
        return true;
    }
    
    public T deleteFront() {
        
        if(!isEmpty()) {
            T result = firstNode.data;
            firstNode = firstNode.next;
            firstNode.previous = null;
            nodeCount--;
            return result;
        }
        else {
            return null;
        }
    }
    
    public T deleteBack() {
        if(!isEmpty()) {
            T result = lastNode.data;
            lastNode = lastNode.previous;
            lastNode.next = null;
            nodeCount--;
            return result;
        }
        else {
            return null;
        }
    }
    
    public boolean isEmpty() {
        return nodeCount == 0;
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
