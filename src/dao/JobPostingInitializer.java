/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Employer;
import entity.JobPosting;
import entity.Skill;

/**
 *
 * @author mings
 */
public class JobPostingInitializer {
    private EmployerInitializer employerInitializer;
    
    public JobPostingInitializer(){
        employerInitializer = new EmployerInitializer();
    }
   
    public DoublyLinkedListInterface<JobPosting> getJobPosting() {
        DoublyLinkedListInterface<JobPosting> jobList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Employer> employerList = employerInitializer.getEmployer();
        Employer employer;
        
        employer = employerList.getPosition(1);
        skills.insertFront(new Skill("Programming", 9));
        skills.insertBack(new Skill("Communication", 7));
        jobList.insertFront(new JobPosting(employer, "Software Engineer Internship", "Coding, Debugging, Development", "RM800-RM1000", "Diploma in Computer Science", skills));

        employer = employerList.getPosition(3);
        skills.clear();
        skills.insertFront(new Skill("Leadership", 8));
        skills.insertBack(new Skill("Communication", 8));
        jobList.insertBack(new JobPosting(employer, "Business Development Internship", "Management, Partnership", "RM600-RM800", "Bachelor in Business", skills));

        return jobList;
    }
}
