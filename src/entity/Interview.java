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
    private String jobPostingID;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<String> dateList;
    private DoublyLinkedListInterface<Integer> timeList;
    private DoublyLinkedListInterface<String> statusList;       //scheduled, rejected, hired
    private DoublyLinkedListInterface<Integer> scoreList;

    public Interview(String jobPostingID, DoublyLinkedListInterface<JobSeeker> jobSeekerList, DoublyLinkedListInterface<String> dateList, DoublyLinkedListInterface<Integer> timeList, DoublyLinkedListInterface<String> statusList, DoublyLinkedListInterface<Integer> scoreList) {
        this.jobPostingID = jobPostingID;
        this.jobSeekerList = jobSeekerList;
        this.dateList = dateList;
        this.timeList = timeList;
        this.statusList = statusList;
        this.scoreList = scoreList;
    }

    public String getJobPostingID() {
        return jobPostingID;
    }

    public void setJobPostingID(String jobPostingID) {
        this.jobPostingID = jobPostingID;
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

    public DoublyLinkedListInterface<Integer> getTimeList() {
        return timeList;
    }

    public void setTimeList(DoublyLinkedListInterface<Integer> timeList) {
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
