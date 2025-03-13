/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Interview;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Skill;

/**
 *
 * @author mings
 */
public class InterviewInitializer {
    private JobPostingInitializer jobInitializer;
    private JobSeekerInitializer jobSeekerInitializer;

    public DoublyLinkedListInterface<Interview> getInterview() {
        DoublyLinkedListInterface<Interview> interviewList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobPosting> jobList = jobInitializer.getJobPosting();
        JobPosting job;
        DoublyLinkedListInterface<JobSeeker> jobSeekerList = jobSeekerInitializer.getJobSeeker();
        DoublyLinkedListInterface<String> dateList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Integer> timeList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<String> statusList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Integer> scoreList = new DoublyLinkedList<>();

        job = jobList.getPosition(1);
        jobSeekerList.insertFront(jobSeekerList.getPosition(1));
        jobSeekerList.insertFront(jobSeekerList.getPosition(2));        
        dateList.insertFront("29-04-2025");
        dateList.insertBack("10-03-2025");
        timeList.insertFront(900);
        timeList.insertBack(1100);
        statusList.insertFront("Scheduled");
        statusList.insertBack("Rejected");
        scoreList.insertFront(0);
        scoreList.insertBack(20);
        interviewList.insertFront(new Interview(job, jobSeekerList, dateList, timeList, statusList, scoreList));
               
        job = jobList.getPosition(2);
        jobSeekerList.insertFront(jobSeekerList.getPosition(2));
        jobSeekerList.insertFront(jobSeekerList.getPosition(3));        
        dateList.insertFront("05-03-2025");
        dateList.insertBack("27-04-2025");
        timeList.insertFront(1500);
        timeList.insertBack(1000);
        statusList.insertFront("Hired");
        statusList.insertBack("Scheduled");
        scoreList.insertFront(90);
        scoreList.insertBack(0);
        interviewList.insertFront(new Interview(job, jobSeekerList, dateList, timeList, statusList, scoreList));
        
        return interviewList;
    }
}
