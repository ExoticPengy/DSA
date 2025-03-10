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
public class EmployerInitializer {

    public DoublyLinkedList<Employer> getEmployer() {
        DoublyLinkedList<Employer> employerList = new DoublyLinkedList<>();

        Employer employer1 = new Employer("E001", "Macrosoft", "No.288, Jalan Damansara, 47800, Petaling Jaya, Selangor", "macrobecausenotmicrosoft@gmail.com");
        Employer employer2 = new Employer("E002", "Amazoff", "No.42, Jalan KL 3, 53000, Kuala Lumpur", "amazoffbecausenoton@gmail.com");
        Employer employer3 = new Employer("E003", "Mayblank", "No.1, Jalan Puchong, 47100, Puchong, Selangor", "mayblankbecausenomoney@gmail.com");

        employerList.insertBack(employer1);
        employerList.insertBack(employer2);
        employerList.insertBack(employer3);

        return employerList;
    }
}
