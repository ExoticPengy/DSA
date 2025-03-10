/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import boundary.InternshipApplication;
import dao.EmployerDao;

/**
 *
 * @author Taruc
 */
public class EmployerManagement {
    private EmployerDao employerDao;
    private DoublyLinkedList<entity.Employer> employerList;
    private InternshipApplication internshipApplication;
    
    public EmployerManagement(){
        employerDao = new EmployerDao();
        employerList = new DoublyLinkedList<>();
    }
    
    public void runEmployerManagement(){
        employerList = employerDao.getEmployer();
        
        internshipApplication.companyNameMenu(employerList);
    }
}
