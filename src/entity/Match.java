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
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Score>> matchedScoreList;

    public Match(DoublyLinkedListInterface<JobSeeker> jobSeekerList, DoublyLinkedListInterface<DoublyLinkedListInterface<Score>> matchedScoreList) {
        this.jobSeekerList = jobSeekerList;
        this.matchedScoreList = matchedScoreList;
    }

    public DoublyLinkedListInterface<JobSeeker> getJobSeekerList() {
        return jobSeekerList;
    }

    public DoublyLinkedListInterface<DoublyLinkedListInterface<Score>> getMatchedScoreList() {
        return matchedScoreList;
    }

    public void setJobSeekerList(DoublyLinkedListInterface<JobSeeker> jobSeekerList) {
        this.jobSeekerList = jobSeekerList;
    }

    public void setMatchedScoreList(DoublyLinkedListInterface<DoublyLinkedListInterface<Score>> matchedScoreList) {
        this.matchedScoreList = matchedScoreList;
    }

    @Override
    public String toString() {
        return "Match{" + "jobSeekerList=" + jobSeekerList + ", matchedScoreList=" + matchedScoreList + '}';
    }

    
    

    
}
