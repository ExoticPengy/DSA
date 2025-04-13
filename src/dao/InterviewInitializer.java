/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Interview;
import entity.JobApplication;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Status;
import entity.Time;

/**
 *
 * @author mings
 */
public class InterviewInitializer {
    
    public DoublyLinkedListInterface<Interview> getInterview(DoublyLinkedListInterface<JobPosting> jobList, DoublyLinkedListInterface<JobSeeker> jobSeeker) {
        DoublyLinkedListInterface<Interview> interviewList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobPosting> interviewJobList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobSeeker> jobSeekerList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<DoublyLinkedListInterface<JobSeeker>> interviewJobSeekerList = new DoublyLinkedList<>();
        
        Time time = new Time();
        DoublyLinkedListInterface<Time> timeList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<DoublyLinkedListInterface<Time>> interviewTimeList = new DoublyLinkedList<>();
        
        Status status = new Status();
        DoublyLinkedListInterface<Status> statusList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<DoublyLinkedListInterface<Status>> interviewStatusList = new DoublyLinkedList<>();

        //1
        interviewJobList.insertFront(jobList.getPosition(1));
        
        jobSeekerList.insertFront(jobSeeker.getPosition(1));
        jobSeekerList.insertBack(jobSeeker.getPosition(2));
        interviewJobSeekerList.insertFront(jobSeekerList);
        
        time.setDate("29-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("10-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(80);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertFront(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
       
        //2
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(6));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(2));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("05-03-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("27-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(90);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
              
        return interviewList;
    }
}
