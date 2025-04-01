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
    private DoublyLinkedListInterface<JobPosting> jobPostingList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<JobSeeker>> jobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Time>> timeList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Status>> statusList;

    public Interview(DoublyLinkedListInterface<JobPosting> jobPostingList, DoublyLinkedListInterface<DoublyLinkedListInterface<JobSeeker>> jobSeekerList, DoublyLinkedListInterface<DoublyLinkedListInterface<Time>> timeList, DoublyLinkedListInterface<DoublyLinkedListInterface<Status>> statusList) {
        this.jobPostingList = jobPostingList;
        this.jobSeekerList = jobSeekerList;
        this.timeList = timeList;
        this.statusList = statusList;
    }

    public DoublyLinkedListInterface<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    public void setJobPostingList(DoublyLinkedListInterface<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
    }

    public DoublyLinkedListInterface<DoublyLinkedListInterface<JobSeeker>> getJobSeekerList() {
        return jobSeekerList;
    }

    public void setJobSeekerList(DoublyLinkedListInterface<DoublyLinkedListInterface<JobSeeker>> jobSeekerList) {
        this.jobSeekerList = jobSeekerList;
    }

    public DoublyLinkedListInterface<DoublyLinkedListInterface<Time>> getTimeList() {
        return timeList;
    }

    public void setTimeList(DoublyLinkedListInterface<DoublyLinkedListInterface<Time>> timeList) {
        this.timeList = timeList;
    }

    public DoublyLinkedListInterface<DoublyLinkedListInterface<Status>> getStatusList() {
        return statusList;
    }

    public void setStatusList(DoublyLinkedListInterface<DoublyLinkedListInterface<Status>> statusList) {
        this.statusList = statusList;
    }
    
}
