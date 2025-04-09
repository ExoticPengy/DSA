/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.MatchingUI;
import entity.JobApplication;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Match;
import entity.MatchScore;
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
    private DoublyLinkedListInterface<JobApplication> jobApplicationList;
    
    public MatchingEngine(){
        matchingUI = new MatchingUI();
        matchList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        jobPostingList = new DoublyLinkedList<>();
        jobApplicationList = new DoublyLinkedList<>();
    }
    
    public void initializeMatchingEngine(
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<JobPosting> jobPostingList
    ) {
        this.jobSeekerList = jobSeekerList;
        this.jobPostingList = jobPostingList;
        calculateMatches();
        sortMatch();
        Match initializeList = getLatestMatch();
        matchingUI.displayInitializeHead();
            for (int i = 1; i <= initializeList.getJobSeekerList().getCount(); i++) {
                matchingUI.displayJobSeekerHead(initializeList.getJobSeekerList().getPosition(i).getName());
                DoublyLinkedListInterface<MatchScore> scoreList = getLatestMatch().getMatchScoreList().getPosition(i);
                for (int j = 1; j <= scoreList.getCount(); j++) {
                    matchingUI.displayJobMatches(scoreList.getPosition(j), j);
                }
            }
        matchingUI.displayMatchFoot();
    }
    
    public void startMatchingEngine(JobSeeker jobSeeker) {
        calculateMatches();
        sortMatch();
        displayMatches(jobSeeker);
        switch(matchingUI.askChoice("\nApply for a job?")) {
            case 1:
                applyJob(jobSeeker);
                break;
            default:
                break;
        }
    }
    
    public void applyJob(JobSeeker jobSeeker) {
        Match latestMatch = getLatestMatch();
        DoublyLinkedListInterface<MatchScore> currentUserScoreList = latestMatch.getMatchScoreList().getPosition(getCurrentSeekerIndex(jobSeeker));
        int selectedJobIndex = matchingUI.selectJob(currentUserScoreList.getCount());
        JobApplication newJobApplication = new JobApplication(jobSeeker, currentUserScoreList.getPosition(selectedJobIndex));
        
        if (checkApplicationExists(newJobApplication, jobSeeker)) {
            switch(matchingUI.askChoice("\nYou have already applied to this job. Please wait for the company to review your application.\nWould you like to select another job?"
                + "\nEnter your choice: ")){
            case 1:
                applyJob(jobSeeker);
                return;
            default:
                return;
            }
        }
        
        jobApplicationList.insertBack(newJobApplication);
        matchingUI.displayNewApplicationHead();
        matchingUI.displayApplication(jobApplicationList.getBack());
    }
    
    public void viewUserApplications(JobSeeker jobSeeker) {
        for (int i = 1; i <= jobApplicationList.getCount(); i++) {
            if (jobApplicationList.getPosition(i).getJobSeeker().equals(jobSeeker)) {
                matchingUI.displayApplication(jobApplicationList.getPosition(i));
            }
        }
    }
    
    public boolean checkApplicationExists(JobApplication newJobApplication, JobSeeker jobSeeker) {
        for(int i = 1; i <= jobApplicationList.getCount(); i++) {
            if (newJobApplication.getJobSeeker().equals(jobApplicationList.getPosition(i).getJobSeeker())
                    && newJobApplication.getMatchScore().getJobPosting().equals(jobApplicationList.getPosition(i).getMatchScore().getJobPosting())
                    && newJobApplication.getMatchScore().getScore() == jobApplicationList.getPosition(i).getMatchScore().getScore()
                ) {
                return true;
            }
        }
        return false;
    }
    
    public void displayMatches(JobSeeker jobSeeker) {
        if (jobSeeker != null) {
            matchingUI.displayMatchHead();
            DoublyLinkedListInterface<MatchScore> scoreList = getLatestMatch().getMatchScoreList().getPosition(getCurrentSeekerIndex(jobSeeker));
            for (int i = 1; i <= scoreList.getCount(); i++) {
                matchingUI.displayJobMatches(scoreList.getPosition(i), i);
            }
            matchingUI.displayMatchFoot();
        }
    }
    
    public Match getLatestMatch() {
        return matchList.getBack();
    }
    
    private int getCurrentSeekerIndex(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return 0;
        }
        
        Match latestMatch = getLatestMatch();
        DoublyLinkedListInterface<JobSeeker> latestJobSeekerList = latestMatch.getJobSeekerList();
        
        for (int i = 1; i <= latestJobSeekerList.getCount(); i++) {
            JobSeeker currentJobSeeker = latestJobSeekerList.getPosition(i);
            if (currentJobSeeker.equals(jobSeeker)) {
                return i;
            }
        }
        
        return 0;
    }
    
    private void calculateMatches() {
        DoublyLinkedListInterface<JobSeeker> newJobSeekerList = copyJobSeekerList();
        DoublyLinkedListInterface<DoublyLinkedListInterface<MatchScore>> matchedScoreList = new DoublyLinkedList<>();
        
        if (newJobSeekerList != null) {
            for (int i = 1; i <= jobSeekerList.getCount(); i++) {
                
                JobSeeker jobSeeker = jobSeekerList.getPosition(i);
                
                DoublyLinkedListInterface<JobPosting> newJobPostingList = copyJobPostingList();
                DoublyLinkedListInterface<MatchScore> scoreList = new DoublyLinkedList<>();

                int communicationSkill = 0;
                int leadershipSkill = 0;
                int programmingSkill = 0;
                int analysisSkill = 0;

                for (int j = 1; j <= jobSeeker.getSkills().getCount(); j++) {
                    Skill skill = jobSeeker.getSkills().getPosition(j);
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
                } //forloop j

                for (int j = 1; j <= newJobPostingList.getCount(); j++) {
                    JobPosting jobPosting = newJobPostingList.getPosition(j);
                    int matchScore = 0;

                    boolean communicationRequired = false;
                    boolean leadershipRequired = false;
                    boolean programmingRequired = false;
                    boolean analysisRequired = false;

                    for (int k = 1; k <= jobPosting.getSkills().getCount(); k++) {
                        Skill requiredSkill = jobPosting.getSkills().getPosition(k);
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
                    } //inner forloopk

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
                    scoreList.insertBack(new MatchScore(jobPosting, matchScore));
                } //outer forloop j
                matchedScoreList.insertBack(scoreList);
            } //forloop i
            matchList.insertBack(new Match(jobSeekerList, matchedScoreList));
        } //if null check
    } //calculateMatch
        
    private DoublyLinkedListInterface<JobSeeker> copyJobSeekerList() {
        DoublyLinkedListInterface<JobSeeker> copiedList = new DoublyLinkedList<>();
        for (int i = 1; i <= jobSeekerList.getCount(); i++) {
            copiedList.insertBack(jobSeekerList.getPosition(i));
        }
        return copiedList;
    }
    
    private DoublyLinkedListInterface<JobPosting> copyJobPostingList() {
        DoublyLinkedListInterface<JobPosting> copiedList = new DoublyLinkedList<>();
        for (int i = 1; i <= jobPostingList.getCount(); i++) {
            copiedList.insertBack(jobPostingList.getPosition(i));
        }
        return copiedList;
    }
    
    private void sortMatch() {
        Match match = getLatestMatch();
        
        for (int i = 1; i <= match.getJobSeekerList().getCount(); i++) {
            DoublyLinkedListInterface<MatchScore> scoreList = match.getMatchScoreList().getPosition(i);
            mergeSort(scoreList, 1, scoreList.getCount());
        } //for
    }

    private void mergeSort(DoublyLinkedListInterface<MatchScore> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    private void merge(DoublyLinkedListInterface<MatchScore> list, int left, int mid, int right) {
        DoublyLinkedListInterface<MatchScore> leftList = new DoublyLinkedList<>();
        DoublyLinkedListInterface<MatchScore> rightList = new DoublyLinkedList<>();

        for (int i = left; i <= mid; i++) {
            leftList.insertBack(list.getPosition(i));
        }

        for (int i = mid + 1; i <= right; i++) {
            rightList.insertBack(list.getPosition(i));
        }

        int i = left; 
        int leftIdx = 1, rightIdx = 1;

        while (leftIdx <= leftList.getCount() && rightIdx <= rightList.getCount()) {
            MatchScore leftScore = leftList.getPosition(leftIdx);
            MatchScore rightScore = rightList.getPosition(rightIdx);

            // Sort in descending order (highest score first)
            if (leftScore.getScore() >= rightScore.getScore()) {
                list.replacePosition(leftScore, i++);
                leftIdx++;
            } else {
                list.replacePosition(rightScore, i++);
                rightIdx++;
            }
        }

        while (leftIdx <= leftList.getCount()) {
            list.replacePosition(leftList.getPosition(leftIdx++), i++);
        }

        while (rightIdx <= rightList.getCount()) {
            list.replacePosition(rightList.getPosition(rightIdx++), i++);
        }
    }
}
