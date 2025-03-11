/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Interview;
import entity.JobSeeker;
import entity.Skill;

/**
 *
 * @author mings
 */
public class InterviewInitializer {

    public DoublyLinkedListInterface<Interview> getInterview() {
        DoublyLinkedListInterface<Interview> interviewList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobSeeker> jobSeekerList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<String> dateList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Integer> timeList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<String> statusList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Integer> scoreList = new DoublyLinkedList<>();

        skills.insertFront(new Skill("Communication", 7));
        skills.insertBack(new Skill("Programming", 9));
        jobSeekerList.insertFront(new JobSeeker("JS001", "John Doe", 22, "Male", "john@example.com", "Kuala Lumpur", "Diploma in Computer Science", skills));
        skills.clear();
        skills.insertFront(new Skill("Leadership", 8));
        skills.insertBack(new Skill("Analysis", 3));
        jobSeekerList.insertBack(new JobSeeker("JS002", "Sarah Lee", 19, "Female", "sarah@example.com", "Penang", "Bachelor in Business", skills));
        skills.clear();
        skills.insertFront(new Skill("Leadership", 6));
        skills.insertBack(new Skill("Analysis", 0));
        jobSeekerList.insertBack(new JobSeeker("JS003", "Michael Smith", 20, "Male", "michael@example.com", "Johor Bahru", "Bachelor in Information Security", skills));
        dateList.insertFront("25-03-2025");
        dateList.insertBack("26-03-2025");
        dateList.insertBack("10-03-2025");
        timeList.insertFront(900);
        timeList.insertBack(1800);
        timeList.insertBack(1100);
        statusList.insertFront("Scheduled");
        statusList.insertBack("Scheduled");
        statusList.insertBack("Hired");
        scoreList.insertFront(0);
        scoreList.insertBack(0);
        scoreList.insertBack(90);

        interviewList.insertFront(new Interview("J001", jobSeekerList, dateList, timeList, statusList, scoreList));
        interviewList.insertBack(new Interview("J002", jobSeekerList, dateList, timeList, statusList, scoreList));
        interviewList.insertBack(new Interview("J001", jobSeekerList, dateList, timeList, statusList, scoreList));
        
        return interviewList;
    }
}
