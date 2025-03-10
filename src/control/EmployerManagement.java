/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import boundary.InternshipApplication;
import dao.EmployerInitializer;

/**
 *
 * @author Taruc
 */
public class EmployerManagement {
    private EmployerInitializer employerInitializer;
    private DoublyLinkedList<entity.Employer> employerList;
    private InternshipApplication internshipApplication;
    
    public EmployerManagement(){
        employerInitializer = new EmployerInitializer();
        employerList = new DoublyLinkedList<>();
    }
    
    public void runEmployerManagement(){
        employerList = employerInitializer.getEmployer();
        
        internshipApplication.companyNameMenu(employerList);
    }
}
