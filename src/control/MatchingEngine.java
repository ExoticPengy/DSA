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
    private DoublyLinkedListInterface<Match> matchList;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<JobPosting> jobPostingList;
    
    public MatchingEngine(){
        matchList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        jobPostingList = new DoublyLinkedList<>();
    }
    
    public void startMatchingEngine(
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<JobPosting> jobPostingList,
            JobSeeker jobSeeker
    ) {
        this.jobSeekerList = jobSeekerList;
        this.jobPostingList = jobPostingList;
        
        matchJobs(jobSeeker);
        sortMatch(jobSeeker);
    }
    
    // To get all students matches
    public void matchJobs() {
        matchList.clear();
        for (int i = 1; i <= jobSeekerList.getCount(); i++) {
            JobSeeker jobSeeker = jobSeekerList.getPosition(i);
            matchList.insertBack(new Match(jobSeeker, jobPostingList, calculateMatches(jobSeeker)));
        }
    }
    
    // To get only one student match
    public void matchJobs(JobSeeker jobSeeker) {
        matchList.clear();
        matchList.insertBack(new Match(jobSeeker, jobPostingList, calculateMatches(jobSeeker)));
    }
    
    private void sortMatch(JobSeeker jobSeeker) {
        Match match = matchList.getPosition(getCurrentMatchIndex(jobSeeker));
        
        quickSort(match, 1, match.getMatchedScoreList().getCount());
    }
    
    private Boolean hasMatched(JobSeeker jobSeeker) {
        for (int i = 1; i < matchList.getCount(); i++) {
            if (matchList.getPosition(i).getJobSeeker().equals(jobSeeker)) {
                return true;
            }
        }
        return false;
    }
    
    private int getCurrentMatchIndex(JobSeeker jobSeeker) {
        for (int i = 1; i <= matchList.getCount(); i++) {
            Match match = matchList.getPosition(i);
            if (match.getJobSeeker().equals(jobSeeker)) {
                return i;
            }
        }
        
        return 0;
    }
    
    private DoublyLinkedListInterface<Double> calculateMatches(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return null;
        }
        
        DoublyLinkedListInterface<JobPosting> newJobPostingList = copyJobPostingList();
        DoublyLinkedListInterface<Double> scoreList = new DoublyLinkedList<>();
        
        int communicationSkill = 0;
        int leadershipSkill = 0;
        int programmingSkill = 0;
        int analysisSkill = 0;
        
        for (int i = 1; i <= jobSeeker.getSkills().getCount(); i++) {
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
            } //switch
        } //forloop
        
        for (int i = 1; i <= newJobPostingList.getCount(); i++) {
            JobPosting jobPosting = newJobPostingList.getPosition(i);
            double matchScore = 0.0;
            
            for (int j = 1; j <= jobPosting.getSkills().getCount(); j++) {
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
            
            scoreList.insertPosition(matchScore, i);
        } //outer forloop
        
        return scoreList;
    } //calculateMatch
    
    private DoublyLinkedListInterface<JobPosting> copyJobPostingList() {
        DoublyLinkedListInterface<JobPosting> copiedList = new DoublyLinkedList<>();
        for (int i = 1; i <= jobPostingList.getCount(); i++) {
            JobPosting originalJobPosting = jobPostingList.getPosition(i);
            JobPosting copiedJobPosting = new JobPosting(originalJobPosting);
            copiedList.insertBack(copiedJobPosting);
        }
        return copiedList;
    }
    
    private void quickSort(Match match, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(match, low, high);

            quickSort(match, low, partitionIndex - 1);
            quickSort(match, partitionIndex + 1, high);
        }
    }

    private int partition(Match match, int low, int high) {
        double pivot = match.getMatchedScoreList().getPosition(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (match.getMatchedScoreList().getPosition(j) >= pivot) {
                i++;
                swap(match, i, j);
            }
        }

        swap(match, i + 1, high);
        return i + 1;
    }

    private void swap(Match match, int i, int j) {
        JobPosting tempJob = match.getJobPostingList().getPosition(i);
        double tempScore = match.getMatchedScoreList().getPosition(i);
        
        match.getJobPostingList().replacePosition(match.getJobPostingList().getPosition(j), i);
        match.getJobPostingList().replacePosition(tempJob, j);
        match.getMatchedScoreList().replacePosition(match.getMatchedScoreList().getPosition(j), i);
        match.getMatchedScoreList().replacePosition(tempScore, j);
    }
}
