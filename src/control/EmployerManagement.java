/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InternshipApplication;
import boundary.JobPostingUI;
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
    private JobPostingUI jobPostingUI;
    
    public EmployerManagement(){
        employerInitializer = new EmployerInitializer();
        employerList = new DoublyLinkedList<>();
        jobPostingUI = new JobPostingUI();
    }
    
    public void initializeEmployer() {
        employerList = employerInitializer.getEmployer();
        jobPostingUI.displayEmployersHeader();
        jobPostingUI.displayEmployers(employerList);
    }
    
    public DoublyLinkedListInterface<Employer> getEmployerList() {
        return employerList;
    }
    
    public void runEmployerManagement(){
        internshipApplication.companyNameMenu(employerList);
    }
}
        