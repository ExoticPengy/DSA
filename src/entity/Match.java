package entity;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MingLi
 */
public class Match {
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<MatchScore>> matchScoreList;

    public Match(DoublyLinkedListInterface<JobSeeker> jobSeekerList, DoublyLinkedListInterface<DoublyLinkedListInterface<MatchScore>> matchScoreList) {
        this.jobSeekerList = jobSeekerList;
        this.matchScoreList = matchScoreList;
    }

    public DoublyLinkedListInterface<JobSeeker> getJobSeekerList() {
        return jobSeekerList;
    }

    public DoublyLinkedListInterface<DoublyLinkedListInterface<MatchScore>> getMatchScoreList() {
        return matchScoreList;
    }

    public void setJobSeekerList(DoublyLinkedListInterface<JobSeeker> jobSeekerList) {
        this.jobSeekerList = jobSeekerList;
    }

    public void setMatchScoreList(DoublyLinkedListInterface<DoublyLinkedListInterface<MatchScore>> matchScoreList) {
        this.matchScoreList = matchScoreList;
    }

    @Override
    public String toString() {
        return "Match{" + "jobSeekerList=" + jobSeekerList + ", matchScoreList=" + matchScoreList + '}';
    }

    
    

    
}
