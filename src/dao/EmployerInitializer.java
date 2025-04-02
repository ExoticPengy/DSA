/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Employer;

/**
 *
 * @author mings
 */
public class EmployerInitializer {

    public DoublyLinkedListInterface<Employer> getEmployer() {
        DoublyLinkedListInterface<Employer> employerList = new DoublyLinkedList<>();

        employerList.insertBack(new Employer("Macrosoft", "Petaling Jaya", "macrobecausenotmicrosoft@gmail.com"));
        employerList.insertBack(new Employer("Amazoff", "Kuala Lumpur", "amazoffbecausenoton@gmail.com"));
        employerList.insertBack(new Employer("Mayblank", "Puchong", "mayblankbecausenomoney@gmail.com"));

        return employerList;
    }
}
