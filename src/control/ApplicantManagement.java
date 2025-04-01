/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InternshipApplication;
import dao.JobSeekerInitializer;
import entity.JobSeeker;

/**
 *
 * @author mings
 */
public class ApplicantManagement {
    private JobSeekerInitializer jobSeekerInitializer;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private InternshipApplication internshipApplication;
    
    public ApplicantManagement(){
        jobSeekerInitializer = new JobSeekerInitializer();
        jobSeekerList = new DoublyLinkedList<>();
    }
    
    public void initializeApplicantManagement() {
        jobSeekerList = jobSeekerInitializer.getJobSeeker();
    }
    
    public void runApplicantManagement(){
        internshipApplication.studentNameMenu(jobSeekerList);
    }
    
    public DoublyLinkedListInterface<JobSeeker> getJobSeekerList() {
        return jobSeekerList;
    }
}
