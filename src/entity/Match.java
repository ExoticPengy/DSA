package entity;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class Match {
    private JobSeeker jobSeeker;
    private DoublyLinkedListInterface<JobPosting> jobPostingList;
    private DoublyLinkedListInterface<Double> matchedScoreList;

    public Match(JobSeeker jobSeeker, DoublyLinkedListInterface<JobPosting> jobPostingList, DoublyLinkedListInterface<Double> matchedScoreList) {
        this.jobSeeker = jobSeeker;
        this.jobPostingList = jobPostingList;
        this.matchedScoreList = matchedScoreList;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public DoublyLinkedListInterface<JobPosting> getJobPostingList() {
        return jobPostingList;
    }

    public DoublyLinkedListInterface<Double> getMatchedScoreList() {
        return matchedScoreList;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public void setJobPostingList(DoublyLinkedListInterface<JobPosting> jobPostingList) {
        this.jobPostingList = jobPostingList;
    }

    public void setMatchedScoreList(DoublyLinkedListInterface<Double> matchedScoreList) {
        this.matchedScoreList = matchedScoreList;
    }

    @Override
    public String toString() {
        return "Match{" + "jobSeeker=" + jobSeeker + ", jobPostingList=" + jobPostingList + ", matchedScoreList=" + matchedScoreList + '}';
    }

    
}
