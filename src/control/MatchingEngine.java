/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.MatchingUI;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Match;
import entity.Skill;

/**
 *
 * @author MingLi
 */
public class MatchingEngine {
    private MatchingUI matchingUI;
    private DoublyLinkedListInterface<Match> matchList;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<JobPosting> jobPostingList;
    
    public MatchingEngine(){
        matchingUI = new MatchingUI();
        matchList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        jobPostingList = new DoublyLinkedList<>();
    }
    
    public void initializeMatchingEngine(
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<JobPosting> jobPostingList
    ) {
        this.jobSeekerList = jobSeekerList;
        this.jobPostingList = jobPostingList;
    }
    
    public void startMatchingEngine(JobSeeker jobSeeker) {
        matchJobs(jobSeeker);
        sortMatch(jobSeeker);
        displayMatches(jobSeeker);
        switch(matchingUI.askApplyJob()) {
            case 1:
                applyJob(jobSeeker);
                break;
            default:
                break;
        }
    }
    
    public void applyJob(JobSeeker jobSeeker) {
        matchingUI.selectJob(matchList.getPosition(getCurrentMatchIndex(jobSeeker)).getJobPostingList().getCount());
    }
    
    public void displayMatches(JobSeeker jobSeeker) {
        if (hasMatched(jobSeeker)) {
            matchingUI.displayMatchHead();
            Match match = matchList.getPosition(getCurrentMatchIndex(jobSeeker));
            for (int i = 1; i <= match.getJobPostingList().getCount(); i++) {
                matchingUI.displayJobMatches(match, i);
            }
        }
    }
    
    // To get all students matches
    public void matchJobs() {
        matchList.clear();
        for (int i = 1; i <= jobSeekerList.getCount(); i++) {
            JobSeeker jobSeeker = jobSeekerList.getPosition(i);
            matchList.insertUniqueBack(new Match(jobSeeker, copyJobPostingList(), calculateMatches(jobSeeker)));
        }
    }
    
    // To get only one student match
    public void matchJobs(JobSeeker jobSeeker) {
        matchList.clear();
        matchList.insertUniqueBack(new Match(jobSeeker, copyJobPostingList(), calculateMatches(jobSeeker)));
    }
    
    private void sortMatch(JobSeeker jobSeeker) {
        Match match = matchList.getPosition(getCurrentMatchIndex(jobSeeker));
        
        quickSort(match, 1, match.getMatchedScoreList().getCount());
    }
    
    private Boolean hasMatched(JobSeeker jobSeeker) {
        for (int i = 1; i <= matchList.getCount(); i++) {
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

            boolean communicationRequired = false;
            boolean leadershipRequired = false;
            boolean programmingRequired = false;
            boolean analysisRequired = false;

            for (int j = 1; j <= jobPosting.getSkills().getCount(); j++) {
                Skill requiredSkill = jobPosting.getSkills().getPosition(j);
                int jobSeekerSkillProficiency = 0;

                switch(requiredSkill.getName()) {
                    case "Communication":
                        jobSeekerSkillProficiency = communicationSkill;
                        communicationRequired = true;
                        break;
                    case "Leadership":
                        jobSeekerSkillProficiency = leadershipSkill;
                        leadershipRequired = true;
                        break;
                    case "Programming":
                        jobSeekerSkillProficiency = programmingSkill;
                        programmingRequired = true;
                        break;
                    case "Analysis":
                        jobSeekerSkillProficiency = analysisSkill;
                        analysisRequired = true;
                        break;
                }

                if (jobSeekerSkillProficiency >= requiredSkill.getProficiency()) {
                    matchScore += (jobSeekerSkillProficiency * 2);
                } else {
                    matchScore += jobSeekerSkillProficiency;
                }
            } //inner forloop

            if (!communicationRequired) {
                matchScore += communicationSkill;
            }
            if (!leadershipRequired) {
                matchScore += leadershipSkill;
            }
            if (!programmingRequired) {
                matchScore += programmingSkill;
            }
            if (!analysisRequired) {
                matchScore += analysisSkill;
            }

            // Add 10 points if location matches
            if (jobPosting.getEmployer().getLocation().equals(jobSeeker.getLocation())) {
                matchScore += 10;
            }

            // Insert the match score into the score list
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
