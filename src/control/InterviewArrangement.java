/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InternshipApplication;
import boundary.InterviewArrangementUI;
import dao.EmployerInitializer;
import dao.InterviewInitializer;
import dao.JobPostingInitializer;
import entity.Employer;
import entity.Interview;
import entity.JobPosting;

/**
 *
 * @author mings
 */
public class InterviewArrangement {

    private InterviewInitializer interviewInitializer;
    private JobPostingInitializer jobPostingInitializer;
    private EmployerInitializer employerInitializer;
    
    private DoublyLinkedListInterface<Interview> interviewList;
    private DoublyLinkedListInterface<Interview> studentInterviewList;
    private DoublyLinkedListInterface<JobPosting> jobList;
    private DoublyLinkedListInterface<Employer> employerList;
    
    private InterviewArrangementUI interviewUI;
    private String employerName;

    public InterviewArrangement() {
        interviewInitializer = new InterviewInitializer();
        interviewList = new DoublyLinkedList<>();
        interviewUI = new InterviewArrangementUI();
    }

//    public void runInterviewArrangement(){
//        interviewList = interviewInitializer.getInterview();
//    }
    public void displayStudentSchedule(String jobSeekerName) {
        interviewList = interviewInitializer.getInterview();
        jobList = jobPostingInitializer.getJobPosting();
        employerList = employerInitializer.getEmployer();
        studentInterviewList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
//            if (interviewList.getPosition(i).getJobPostingID() == jobList.getPosition(i).getJobID()) {
//                if (jobList.getPosition(i).getEmployerID() == employerList.getPosition(i).getEmployerId()) {
//                    employerName = employerList.getPosition(i).getName();
//                }
//            }
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getName() == (jobSeekerName)) {
                    studentInterviewList.insertBack(interviewList.getPosition(i));
                }
            }
        }
        interviewUI.scheduleUI(studentInterviewList);
    }

    public void displayCompanySchedule(String employerName) {

    }

    public void displayResult(String jobSeekerName) {

    }

    public void displayInterviewResult(String employerName) {

    }

    public void displayInterviewReport() {

    }
}
