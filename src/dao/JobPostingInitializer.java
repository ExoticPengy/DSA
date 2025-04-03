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
    
    public DoublyLinkedListInterface<JobPosting> getJobPosting(DoublyLinkedListInterface<Employer> employerList) {
        DoublyLinkedListInterface<JobPosting> jobList = new DoublyLinkedList<>();
        Employer employer;
        
        employer = employerList.getPosition(1);
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 9));
        skills.insertBack(new Skill("Communication", 7));
        jobList.insertFront(new JobPosting(employer, "Software Engineer Internship", "Coding, Debugging, Development", "RM800-RM1000", "Diploma in Computer Science", skills));

        employer = employerList.getPosition(2);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 6));
        skills.insertBack(new Skill("Communication", 5));
        jobList.insertBack(new JobPosting(employer, "IT Internship", "Programming", "RM800-RM900", "Bachelor in IT", skills));

        employer = employerList.getPosition(3);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 8));
        skills.insertBack(new Skill("Communication", 8));
        jobList.insertBack(new JobPosting(employer, "Business Development Internship", "Management, Partnership", "RM600-RM800", "Bachelor in Business", skills));

        employer = employerList.getPosition(3);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 7));
        skills.insertBack(new Skill("Communication", 10));
        jobList.insertBack(new JobPosting(employer, "Software Developer Internship", "Develop software", "RM900-RM1100", "Bachelor in Computer Science", skills));

        return jobList;
    }
}
