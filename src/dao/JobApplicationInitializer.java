/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.JobApplication;
import entity.Match;

/**
 *
 * @author USER
 */
public class JobApplicationInitializer {
    
    public DoublyLinkedListInterface<JobApplication> getJobApplication(
            Match match
    ) {
        DoublyLinkedListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
        
        // JobSeeker number 1, JobPosting number 1
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(1), 
                        match.getMatchScoreList().getPosition(1).getPosition(1)
                )
        );
        
        // JobSeeker number 2, JobPosting number 1
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(2), 
                        match.getMatchScoreList().getPosition(2).getPosition(1)
                )
        );
        
        // JobSeeker number 3, JobPosting number 1
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(3), 
                        match.getMatchScoreList().getPosition(3).getPosition(1)
                )
        );
        
        return jobApplicationList;
    }
    
}
