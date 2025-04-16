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
import entity.Status;
import entity.Time;

/**
 *
 * @author Chea Ming Shen
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
        
        jobSeekerList.insertFront(jobSeeker.getPosition(13));
        jobSeekerList.insertBack(jobSeeker.getPosition(4));
        jobSeekerList.insertBack(jobSeeker.getPosition(9));
        interviewJobSeekerList.insertFront(jobSeekerList);
        
        time.setDate("09-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("06-05-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("18-04-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Interviewed");
        status.setScore(70);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
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
        
        interviewJobList.insertBack(jobList.getPosition(2));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(2));
        jobSeekerList.insertBack(jobSeeker.getPosition(15));
        jobSeekerList.insertBack(jobSeeker.getPosition(11));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("25-03-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("29-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("03-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(90);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(50);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //3
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(3));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(7));
        jobSeekerList.insertBack(jobSeeker.getPosition(6));
        jobSeekerList.insertBack(jobSeeker.getPosition(20));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("19-03-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("27-04-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("22-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Interviewed");
        status.setScore(60);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //4
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(4));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(18));
        jobSeekerList.insertBack(jobSeeker.getPosition(12));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("05-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("25-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("08-05-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Rejected");
        status.setScore(10);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //5
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(5));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(1));
        jobSeekerList.insertBack(jobSeeker.getPosition(17));
        jobSeekerList.insertBack(jobSeeker.getPosition(8));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("07-04-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("12-04-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("30-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(80);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(20);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //6
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
                
        jobSeekerList.insertFront(jobSeeker.getPosition(14));
        jobSeekerList.insertBack(jobSeeker.getPosition(5));
        jobSeekerList.insertBack(jobSeeker.getPosition(10));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("14-05-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("22-03-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("01-05-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(50);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //7
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(7));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(19));
        jobSeekerList.insertBack(jobSeeker.getPosition(16));
        jobSeekerList.insertBack(jobSeeker.getPosition(7));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("01-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("24-04-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("14-04-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(90);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(70);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //8
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(8));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(13));
        jobSeekerList.insertBack(jobSeeker.getPosition(1));
        jobSeekerList.insertBack(jobSeeker.getPosition(2));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("27-03-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("10-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("02-04-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(40);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(20);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //9
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(9));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(5));
        jobSeekerList.insertBack(jobSeeker.getPosition(20));
        jobSeekerList.insertBack(jobSeeker.getPosition(18));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("24-03-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("16-04-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("13-04-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Interviewed");
        status.setScore(10);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //10
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(10));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(11));
        jobSeekerList.insertBack(jobSeeker.getPosition(4));
        jobSeekerList.insertBack(jobSeeker.getPosition(9));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("28-04-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("13-05-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("17-04-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //11
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(11));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(16));
        jobSeekerList.insertBack(jobSeeker.getPosition(18));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("30-03-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("29-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("26-03-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Rejected");
        status.setScore(30);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(80);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //12
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(12));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(12));
        jobSeekerList.insertBack(jobSeeker.getPosition(10));
        jobSeekerList.insertBack(jobSeeker.getPosition(6));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("23-04-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("31-03-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("04-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(70);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //13
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(13));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(14));
        jobSeekerList.insertBack(jobSeeker.getPosition(15));
        jobSeekerList.insertBack(jobSeeker.getPosition(17));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("21-03-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("18-03-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("19-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(50);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(40);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //14
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(14));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(19));
        jobSeekerList.insertBack(jobSeeker.getPosition(6));
        jobSeekerList.insertBack(jobSeeker.getPosition(8));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("15-04-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("17-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("12-05-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Rejected");
        status.setScore(60);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //15
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(15));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(11));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        jobSeekerList.insertBack(jobSeeker.getPosition(13));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("28-03-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("10-05-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("06-04-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(30);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(20);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //16
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(16));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(7));
        jobSeekerList.insertBack(jobSeeker.getPosition(12));
        jobSeekerList.insertBack(jobSeeker.getPosition(16));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("15-05-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("02-05-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("23-03-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(100);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //17
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(17));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(1));
        jobSeekerList.insertBack(jobSeeker.getPosition(10));
        jobSeekerList.insertBack(jobSeeker.getPosition(5));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("08-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("20-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("03-05-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(8);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //18
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(18));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(14));
        jobSeekerList.insertBack(jobSeeker.getPosition(4));
        jobSeekerList.insertBack(jobSeeker.getPosition(19));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("11-05-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("04-05-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("16-03-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(80);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //19
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(19));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(9));
        jobSeekerList.insertBack(jobSeeker.getPosition(20));
        jobSeekerList.insertBack(jobSeeker.getPosition(2));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("11-04-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("21-04-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("26-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Rejected");
        status.setScore(40);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //20
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(20));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(17));
        jobSeekerList.insertBack(jobSeeker.getPosition(15));
        jobSeekerList.insertBack(jobSeeker.getPosition(18));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("05-05-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("19-03-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("07-05-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(30);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //21
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(21));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(10));
        jobSeekerList.insertBack(jobSeeker.getPosition(6));
        jobSeekerList.insertBack(jobSeeker.getPosition(5));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("09-05-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("20-04-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("27-03-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(60);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //22
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(22));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(7));
        jobSeekerList.insertBack(jobSeeker.getPosition(8));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("06-05-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("13-05-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("12-04-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(100);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //23
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(23));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(2));
        jobSeekerList.insertBack(jobSeeker.getPosition(1));
        jobSeekerList.insertBack(jobSeeker.getPosition(4));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("31-03-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("25-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("01-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(50);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(10);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //24
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(24));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(9));
        jobSeekerList.insertBack(jobSeeker.getPosition(12));
        jobSeekerList.insertBack(jobSeeker.getPosition(11));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("03-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("14-05-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("24-04-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Interviewed");
        status.setScore(10);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //25
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(25));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(13));
        jobSeekerList.insertBack(jobSeeker.getPosition(14));
        jobSeekerList.insertBack(jobSeeker.getPosition(15));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("22-04-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("28-03-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("29-03-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(30);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(40);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //26
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(26));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(16));
        jobSeekerList.insertBack(jobSeeker.getPosition(17));
        jobSeekerList.insertBack(jobSeeker.getPosition(18));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("06-04-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("17-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("11-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Rejected");
        status.setScore(50);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //27
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(27));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(19));
        jobSeekerList.insertBack(jobSeeker.getPosition(20));
        jobSeekerList.insertBack(jobSeeker.getPosition(1));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("02-05-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("20-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("01-05-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(60);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //28
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(28));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(20));
        jobSeekerList.insertBack(jobSeeker.getPosition(2));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("21-03-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("10-05-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("19-04-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Interviewed");
        status.setScore(70);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //29
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(29));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(4));
        jobSeekerList.insertBack(jobSeeker.getPosition(5));
        jobSeekerList.insertBack(jobSeeker.getPosition(6));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("20-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("04-05-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("30-03-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(20);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //30
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(30));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(7));
        jobSeekerList.insertBack(jobSeeker.getPosition(8));
        jobSeekerList.insertBack(jobSeeker.getPosition(9));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("27-04-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("26-03-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("08-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(90);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //31
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(31));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(10));
        jobSeekerList.insertBack(jobSeeker.getPosition(11));
        jobSeekerList.insertBack(jobSeeker.getPosition(12));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("02-04-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("13-04-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("05-04-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(100);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(30);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //32
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(32));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(13));
        jobSeekerList.insertBack(jobSeeker.getPosition(14));
        jobSeekerList.insertBack(jobSeeker.getPosition(15));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("15-05-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("07-05-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("23-04-2025");
        time.setStartTime(1200);
        time.setEndTime(1300);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //33
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(33));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(16));
        jobSeekerList.insertBack(jobSeeker.getPosition(17));
        jobSeekerList.insertBack(jobSeeker.getPosition(18));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("12-05-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("09-05-2025");
        time.setStartTime(1300);
        time.setEndTime(1400);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("09-04-2025");
        time.setStartTime(1000);
        time.setEndTime(1100);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Hired");
        status.setScore(30);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //34
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(34));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(19));
        jobSeekerList.insertBack(jobSeeker.getPosition(13));
        jobSeekerList.insertBack(jobSeeker.getPosition(3));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("10-04-2025");
        time.setStartTime(1100);
        time.setEndTime(1200);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("22-03-2025");
        time.setStartTime(900);
        time.setEndTime(1000);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("11-05-2025");
        time.setStartTime(1600);
        time.setEndTime(1700);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Rejected");
        status.setScore(40);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Interviewed");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        
        //35
        interviewJobList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        interviewJobSeekerList = new DoublyLinkedList<>();
        time = new Time();
        timeList = new DoublyLinkedList<>();
        interviewTimeList = new DoublyLinkedList<>();
        status = new Status();
        statusList = new DoublyLinkedList<>();
        interviewStatusList = new DoublyLinkedList<>();
        
        interviewJobList.insertBack(jobList.getPosition(35));
                
        jobSeekerList.insertFront(jobSeeker.getPosition(7));
        jobSeekerList.insertBack(jobSeeker.getPosition(12));
        jobSeekerList.insertBack(jobSeeker.getPosition(8));
        interviewJobSeekerList.insertFront(jobSeekerList);
                
        time.setDate("24-03-2025");
        time.setStartTime(1500);
        time.setEndTime(1600);
        timeList.insertFront(time);
        
        time = new Time();
        time.setDate("30-04-2025");
        time.setStartTime(1700);
        time.setEndTime(1800);
        timeList.insertBack(time);
        
        time = new Time();
        time.setDate("07-04-2025");
        time.setStartTime(1400);
        time.setEndTime(1500);
        timeList.insertBack(time);
        interviewTimeList.insertFront(timeList);
        
        status.setStatus("Hired");
        status.setScore(50);
        statusList.insertFront(status);
        
        status = new Status();
        status.setStatus("Scheduled");
        status.setScore(0);
        statusList.insertBack(status);
        
        status = new Status();
        status.setStatus("Rejected");
        status.setScore(20);
        statusList.insertBack(status);
        interviewStatusList.insertFront(statusList);
        
        interviewList.insertBack(new Interview(interviewJobList,interviewJobSeekerList,interviewTimeList,interviewStatusList));
        return interviewList;
    }
}
