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
    private JobPosting jobPosting;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList = new DoublyLinkedList<>();
    private DoublyLinkedListInterface<Double> matchedScoreList = new DoublyLinkedList<>();

    public Match(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }
    
    public void insertMatchScore(double score, int position) {
        matchedScoreList.insertPosition(score, position);
    }

    private boolean calculateMatch() {
        if (jobSeekerList.isEmpty()) {
            return false;
        }
        
        int communicationRequirement = 0;
        int leadershipRequirement = 0;
        int programmingRequirement = 0;
        int analysisRequirement = 0;
        
        for (int i = 0; i < jobPosting.getSkills().getCount(); i++) {
            Skill skill = jobPosting.getSkills().getPosition(i);
            switch(skill.getName()) {
                case "Communication":
                    communicationRequirement = skill.getProficiency();
                    break;
                case "Leadership":
                    leadershipRequirement = skill.getProficiency();
                    break;
                case "Programming":
                    programmingRequirement = skill.getProficiency();
                    break;
                case "Analysis":
                    analysisRequirement = skill.getProficiency();
                    break;
            }
        }
        
        for (int i = 0; i < jobSeekerList.getCount(); i++) {
            JobSeeker jobSeeker = jobSeekerList.getPosition(i);
            double matchScore = 0.0;
            
            for (int j = 0; j < jobSeeker.getSkills().getCount(); j++) {
                Skill skill = jobSeeker.getSkills().getPosition(j);
                switch(skill.getName()) {
                    case "Communication":
                        if (skill.getProficiency() >= communicationRequirement) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    case "Leadership":
                        if (skill.getProficiency() >= leadershipRequirement) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    case "Programming":
                        if (skill.getProficiency() >= programmingRequirement) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    case "Analysis":
                        if (skill.getProficiency() >= analysisRequirement) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    default:
                        break;
                } //switch
            } //inner forloop
            
//            if(jobPosting.getLocation().get.equals(jobSeeker.getLocation())) {
//                matchScore += 10;
//            }
            
            insertMatchScore(matchScore, i + 1);
        } //outer forloop
        return true;
    } //calculateMatch
}
