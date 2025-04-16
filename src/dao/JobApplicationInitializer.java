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
 * @author MingLi
 */
public class JobApplicationInitializer {
    
    public DoublyLinkedListInterface<JobApplication> getJobApplication(
            Match match
    ) {
        DoublyLinkedListInterface<JobApplication> jobApplicationList = new DoublyLinkedList<>();
        
        // JobSeeker 1 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(1), 
                        match.getMatchScoreList().getPosition(1).getPosition(1)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(1), 
                        match.getMatchScoreList().getPosition(1).getPosition(2)
                )
        );

        // JobSeeker 2 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(2), 
                        match.getMatchScoreList().getPosition(2).getPosition(3)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(2), 
                        match.getMatchScoreList().getPosition(2).getPosition(4)
                )
        );

        // JobSeeker 3 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(3), 
                        match.getMatchScoreList().getPosition(3).getPosition(5)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(3), 
                        match.getMatchScoreList().getPosition(3).getPosition(6)
                )
        );

        // JobSeeker 4 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(4), 
                        match.getMatchScoreList().getPosition(4).getPosition(7)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(4), 
                        match.getMatchScoreList().getPosition(4).getPosition(8)
                )
        );

        // JobSeeker 5 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(5), 
                        match.getMatchScoreList().getPosition(5).getPosition(9)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(5), 
                        match.getMatchScoreList().getPosition(5).getPosition(10)
                )
        );

        // JobSeeker 6 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(6), 
                        match.getMatchScoreList().getPosition(6).getPosition(11)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(6), 
                        match.getMatchScoreList().getPosition(6).getPosition(12)
                )
        );

        // JobSeeker 7 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(7), 
                        match.getMatchScoreList().getPosition(7).getPosition(13)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(7), 
                        match.getMatchScoreList().getPosition(7).getPosition(14)
                )
        );

        // JobSeeker 8 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(8), 
                        match.getMatchScoreList().getPosition(8).getPosition(15)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(8), 
                        match.getMatchScoreList().getPosition(8).getPosition(16)
                )
        );

        // JobSeeker 9 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(9), 
                        match.getMatchScoreList().getPosition(9).getPosition(17)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(9), 
                        match.getMatchScoreList().getPosition(9).getPosition(18)
                )
        );

        // JobSeeker 10 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(10), 
                        match.getMatchScoreList().getPosition(10).getPosition(19)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(10), 
                        match.getMatchScoreList().getPosition(10).getPosition(20)
                )
        );

        // JobSeeker 11 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(11), 
                        match.getMatchScoreList().getPosition(11).getPosition(21)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(11), 
                        match.getMatchScoreList().getPosition(11).getPosition(22)
                )
        );

        // JobSeeker 12 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(12), 
                        match.getMatchScoreList().getPosition(12).getPosition(23)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(12), 
                        match.getMatchScoreList().getPosition(12).getPosition(24)
                )
        );

        // JobSeeker 13 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(13), 
                        match.getMatchScoreList().getPosition(13).getPosition(25)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(13), 
                        match.getMatchScoreList().getPosition(13).getPosition(26)
                )
        );

        // JobSeeker 14 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(14), 
                        match.getMatchScoreList().getPosition(14).getPosition(27)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(14), 
                        match.getMatchScoreList().getPosition(14).getPosition(28)
                )
        );

        // JobSeeker 15 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(15), 
                        match.getMatchScoreList().getPosition(15).getPosition(29)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(15), 
                        match.getMatchScoreList().getPosition(15).getPosition(30)
                )
        );

        // JobSeeker 16 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(16), 
                        match.getMatchScoreList().getPosition(16).getPosition(31)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(16), 
                        match.getMatchScoreList().getPosition(16).getPosition(32)
                )
        );

        // JobSeeker 17 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(17), 
                        match.getMatchScoreList().getPosition(17).getPosition(33)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(17), 
                        match.getMatchScoreList().getPosition(17).getPosition(34)
                )
        );

        // JobSeeker 18 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(18), 
                        match.getMatchScoreList().getPosition(18).getPosition(35)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(18), 
                        match.getMatchScoreList().getPosition(18).getPosition(1)
                )
        );

        // JobSeeker 19 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(19), 
                        match.getMatchScoreList().getPosition(19).getPosition(2)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(19), 
                        match.getMatchScoreList().getPosition(19).getPosition(3)
                )
        );

        // JobSeeker 20 Applications
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(20), 
                        match.getMatchScoreList().getPosition(20).getPosition(4)
                )
        );
        jobApplicationList.insertBack(
                new JobApplication(
                        match.getJobSeekerList().getPosition(20), 
                        match.getMatchScoreList().getPosition(20).getPosition(5)
                )
        );
        
        return jobApplicationList;
    }
    
}
