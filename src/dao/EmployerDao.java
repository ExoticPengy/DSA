/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import entity.Employer;

/**
 *
 * @author mings
 */
public class EmployerDao {
    public DoublyLinkedList<Employer> getEmployer(){
        DoublyLinkedList<Employer> employerList = new DoublyLinkedList<>();
        
        Employer employer1 = new Employer("E001", "Macrosoft", "macrobecausenotmicrosoft@gmail.com");
        Employer employer2 = new Employer("E002", "Amazoff", "amazoffbecausenoton@gmail.com");
        Employer employer3 = new Employer("E003", "Mayblank", "mayblankbecausenomoney@gmail.com");
        
        employerList.insertBack(employer1);
        employerList.insertBack(employer2);
        employerList.insertBack(employer3);
        
        return employerList;
    }
}
