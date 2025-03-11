/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.JobPosting;
import entity.Skill;

/**
 *
 * @author mings
 */
public class JobPostingInitializer {

    public DoublyLinkedListInterface<JobPosting> getJobPosting() {
        DoublyLinkedListInterface<JobPosting> jobList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();

        skills.insertFront(new Skill("Programming", 9));
        skills.insertBack(new Skill("Communication", 7));
        jobList.insertFront(new JobPosting("J001", "E001", "Software Engineer Internship", "Coding, Debugging, Development", "RM800-RM1000", "Diploma in Information Technology", skills));

        skills.clear();
        skills.insertFront(new Skill("Leadership", 8));
        skills.insertBack(new Skill("Communication", 8));
        jobList.insertFront(new JobPosting("J002", "E003", "Finance Internship", "Management, Investment", "RM600-RM800", "Diploma in Finance", skills));

        return jobList;
    }
}
