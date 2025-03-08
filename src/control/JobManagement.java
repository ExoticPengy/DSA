/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import static boundary.InternshipApplication.companyMenu;
import dao.EmployerDao;
import entity.Employer;
import java.util.Scanner;
import utility.MessageUI;

//for testing display employerlist
import boundary.InternshipApplication;

/**
 *
 * @author mings
 */
public class JobManagement {
    private EmployerDao employerDao;
    private DoublyLinkedList<Employer> employerList;
    
    //for testing
    private InternshipApplication internshipApplication;
    
    public JobManagement(){
        employerDao = new EmployerDao();
        employerList = new DoublyLinkedList<>();
    }
    
    public void runJobManagement(){
        employerList = employerDao.getEmployer();
        
        internshipApplication.companyNameMenu(employerList);
    }
}
