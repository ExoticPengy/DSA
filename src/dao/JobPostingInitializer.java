/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import entity.JobPosting;
import entity.Skill;

/**
 *
 * @author mings
 */
public class JobPostingInitializer {

    public DoublyLinkedList<JobPosting> getJobPosting() {
        DoublyLinkedList<JobPosting> jobList = new DoublyLinkedList<>();

        JobPosting job1 = new JobPosting("J001", "E001", "Software Engineer Internship", "Coding, Debugging, Development", "RM800-RM1000", "Diploma in Information Technology", new Skill(5,5,9,9));

        jobList.insertFront(job1);
        
        return jobList;
    }
}
