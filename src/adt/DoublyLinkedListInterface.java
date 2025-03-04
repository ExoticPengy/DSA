package adt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author MingLi
 */
public interface DoublyLinkedListInterface<T> {
    public boolean insertFront(T newEntry);
    public boolean insertBack(T newEntry);
    public boolean insertPosition(T newEntry, int position);
    public T deleteFront();
    public T deleteBack();
    public boolean isEmpty();
}
