///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package dao;
//
//import adt.DoublyLinkedList;
//import adt.DoublyLinkedListInterface;
//import entity.Interview;
//import entity.JobPosting;
//import entity.JobSeeker;
//
///**
// *
// * @author mings
// */
//public class InterviewInitializer {
//
//    private JobPostingInitializer jobInitializer;
//    private JobSeekerInitializer jobSeekerInitializer;
//
//    public InterviewInitializer() {
//        jobInitializer = new JobPostingInitializer();
//        jobSeekerInitializer = new JobSeekerInitializer();
//    }
//
//    public DoublyLinkedListInterface<Interview> getInterview() {
//        DoublyLinkedListInterface<Interview> interviewList = new DoublyLinkedList<>();
//        DoublyLinkedListInterface<JobPosting> jobList = jobInitializer.getJobPosting();
//        JobPosting job;
//        DoublyLinkedListInterface<JobSeeker> jobSeekerList = jobSeekerInitializer.getJobSeeker();
//        DoublyLinkedListInterface<JobSeeker> interviewJobSeekerList = new DoublyLinkedList<>();
//        DoublyLinkedListInterface<String> dateList = new DoublyLinkedList<>();
//        DoublyLinkedListInterface<String> timeList = new DoublyLinkedList<>();
//        DoublyLinkedListInterface<String> statusList = new DoublyLinkedList<>();
//        DoublyLinkedListInterface<Integer> scoreList = new DoublyLinkedList<>();
//
//        job = jobList.getPosition(1);
//        interviewJobSeekerList.insertFront(jobSeekerList.getPosition(1));
//        interviewJobSeekerList.insertBack(jobSeekerList.getPosition(2));
//        dateList.insertFront("29-04-2025");
//        dateList.insertBack("10-03-2025");
//        timeList.insertFront("0900-1000");
//        timeList.insertBack("1100-1200");
//        statusList.insertFront("Scheduled");
//        statusList.insertBack("Rejected");
//        scoreList.insertFront(0);
//        scoreList.insertBack(20);
//        interviewList.insertFront(new Interview(job, interviewJobSeekerList, dateList, timeList, statusList, scoreList));
//
//        interviewJobSeekerList = new DoublyLinkedList<>();
//        dateList = new DoublyLinkedList<>();
//        timeList = new DoublyLinkedList<>();
//        statusList = new DoublyLinkedList<>();
//        scoreList = new DoublyLinkedList<>();
//        job = jobList.getPosition(2);
//        interviewJobSeekerList.insertFront(jobSeekerList.getPosition(2));
//        interviewJobSeekerList.insertBack(jobSeekerList.getPosition(3));
//        dateList.insertFront("05-03-2025");
//        dateList.insertBack("27-04-2025");
//        timeList.insertFront("1500-1600");
//        timeList.insertBack("1000-1100");
//        statusList.insertFront("Hired");
//        statusList.insertBack("Scheduled");
//        scoreList.insertFront(90);
//        scoreList.insertBack(0);
//        interviewList.insertBack(new Interview(job, interviewJobSeekerList, dateList, timeList, statusList, scoreList));
//
//        return interviewList;
//    }
//}
