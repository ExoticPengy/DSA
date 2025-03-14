/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedListInterface;

/**
 *
 * @author mings
 */
public class Interview {
    private JobPosting jobPosting;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<String> dateList;
    private DoublyLinkedListInterface<String> timeList;
    private DoublyLinkedListInterface<String> statusList;       //scheduled, rejected, hired
    private DoublyLinkedListInterface<Integer> scoreList;

    public Interview(JobPosting jobPosting, DoublyLinkedListInterface<JobSeeker> jobSeekerList, DoublyLinkedListInterface<String> dateList, DoublyLinkedListInterface<String> timeList, DoublyLinkedListInterface<String> statusList, DoublyLinkedListInterface<Integer> scoreList) {
        this.jobPosting = jobPosting;
        this.jobSeekerList = jobSeekerList;
        this.dateList = dateList;
        this.timeList = timeList;
        this.statusList = statusList;
        this.scoreList = scoreList;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public DoublyLinkedListInterface<JobSeeker> getJobSeekerList() {
        return jobSeekerList;
    }

    public void setJobSeekerList(DoublyLinkedListInterface<JobSeeker> jobSeekerList) {
        this.jobSeekerList = jobSeekerList;
    }

    public DoublyLinkedListInterface<String> getDateList() {
        return dateList;
    }

    public void setDateList(DoublyLinkedListInterface<String> dateList) {
        this.dateList = dateList;
    }

    public DoublyLinkedListInterface<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(DoublyLinkedListInterface<String> timeList) {
        this.timeList = timeList;
    }

    public DoublyLinkedListInterface<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(DoublyLinkedListInterface<String> statusList) {
        this.statusList = statusList;
    }

    public DoublyLinkedListInterface<Integer> getScoreList() {
        return scoreList;
    }

    public void setScoreList(DoublyLinkedListInterface<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    
}
