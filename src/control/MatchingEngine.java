/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import dao.JobPostingInitializer;
import dao.JobSeekerInitializer;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Match;
import entity.Skill;

/**
 *
 * @author MingLi
 */
public class MatchingEngine {
    //private MatchInitializer matchInitializer;
    private JobPostingInitializer jobPostingInitializer;
    private JobSeekerInitializer jobSeekerInitializer;
    private DoublyLinkedListInterface<Match> matchList;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<JobPosting> jobPostingList;
    
    public MatchingEngine(){
        //matchInitializer = new MatchInitializer();
        jobPostingInitializer = new JobPostingInitializer();
        jobSeekerInitializer = new JobSeekerInitializer();
        matchList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        jobPostingList = new DoublyLinkedList<>();
    }
    
    private DoublyLinkedListInterface<Double> calculateMatches(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return null;
        }
        DoublyLinkedListInterface<Double> scoreList = new DoublyLinkedList<>();
        int communicationSkill = 0;
        int leadershipSkill = 0;
        int programmingSkill = 0;
        int analysisSkill = 0;
        
        for (int i = 0; i < jobSeeker.getSkills().getCount(); i++) {
            Skill skill = jobSeeker.getSkills().getPosition(i);
            switch(skill.getName()) {
                case "Communication":
                    communicationSkill = skill.getProficiency();
                    break;
                case "Leadership":
                    leadershipSkill = skill.getProficiency();
                    break;
                case "Programming":
                    programmingSkill = skill.getProficiency();
                    break;
                case "Analysis":
                    analysisSkill = skill.getProficiency();
                    break;
            }
        }
        
        for (int i = 0; i < jobPostingList.getCount(); i++) {
            JobPosting jobPosting = jobPostingList.getPosition(i);
            double matchScore = 0.0;
            
            for (int j = 0; j < jobPosting.getSkills().getCount(); j++) {
                Skill skill = jobPosting.getSkills().getPosition(j);
                switch(skill.getName()) {
                    case "Communication":
                        if (skill.getProficiency() >= communicationSkill) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    case "Leadership":
                        if (skill.getProficiency() >= leadershipSkill) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    case "Programming":
                        if (skill.getProficiency() >= programmingSkill) {
                            matchScore += (skill.getProficiency() * 2);
                        }
                        else {
                            matchScore += skill.getProficiency();
                        }
                        break;
                    case "Analysis":
                        if (skill.getProficiency() >= analysisSkill) {
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
            
            if(jobPosting.getEmployer().getLocation().equals(jobSeeker.getLocation())) {
                matchScore += 10;
            }
            
            scoreList.insertPosition(matchScore, i + 1);
        } //outer forloop
        return scoreList;
    } //calculateMatch
}
