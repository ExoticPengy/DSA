/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InternshipApplication;
import dao.EmployerInitializer;
import entity.Employer;

/**
 *
 * @author Chea Ming Shen
 */
public class EmployerManagement {
    private EmployerInitializer employerInitializer;
    private DoublyLinkedListInterface<Employer> employerList;
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
