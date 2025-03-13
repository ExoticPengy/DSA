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

        employerList.insertBack(new Employer("Macrosoft", "No.288, Jalan Damansara, 47800, Petaling Jaya, Selangor", "macrobecausenotmicrosoft@gmail.com"));
        employerList.insertBack(new Employer("Amazoff", "No.42, Jalan KL 3, 53000, Kuala Lumpur", "amazoffbecausenoton@gmail.com"));
        employerList.insertBack(new Employer("Mayblank", "No.1, Jalan Puchong, 47100, Puchong, Selangor", "mayblankbecausenomoney@gmail.com"));

        return employerList;
    }
}
