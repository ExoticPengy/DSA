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
import entity.Score;
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
        calculateMatches();
        sortMatch();
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
        matchingUI.selectJob(matchList.getBack().getMatchedScoreList().getPosition(getCurrentSeekerIndex(jobSeeker)).getCount());
    }
    
    public void displayMatches(JobSeeker jobSeeker) {
        if (jobSeeker != null) {
            matchingUI.displayMatchHead();
            DoublyLinkedListInterface<Score> scoreList = matchList.getBack().getMatchedScoreList().getPosition(getCurrentSeekerIndex(jobSeeker));
            for (int i = 1; i <= scoreList.getCount(); i++) {
                matchingUI.displayJobMatches(scoreList.getPosition(i), i);
            }
        }
    }
    
    private int getCurrentSeekerIndex(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return 0;
        }
        
        Match latestMatch = matchList.getBack();
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
        DoublyLinkedListInterface<DoublyLinkedListInterface<Score>> matchedScoreList = new DoublyLinkedList<>();
        
        if (newJobSeekerList != null) {
            for (int i = 1; i <= jobSeekerList.getCount(); i++) {
                
                JobSeeker jobSeeker = jobSeekerList.getPosition(i);
                
                DoublyLinkedListInterface<JobPosting> newJobPostingList = copyJobPostingList();
                DoublyLinkedListInterface<Score> scoreList = new DoublyLinkedList<>();

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
                    scoreList.insertBack(new Score(jobPosting, matchScore));
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
        Match match = matchList.getBack();
        
        for (int i = 1; i <= match.getJobSeekerList().getCount(); i++) {
            quickSort(match, i, 1, match.getMatchedScoreList().getPosition(i).getCount());
        }
    }
    
    private void quickSort(Match match, int index, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(match, index, low, high);

            quickSort(match, index, low, partitionIndex - 1);
            quickSort(match, index, partitionIndex + 1, high);
        }
    }

    private int partition(Match match, int index, int low, int high) {
        double pivot = match.getMatchedScoreList().getPosition(index).getPosition(high).getScore();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (match.getMatchedScoreList().getPosition(index).getPosition(j).getScore() >= pivot) {
                i++;
                swap(match, index, i, j);
            }
        }

        swap(match, index, i + 1, high);
        return i + 1;
    }

    private void swap(Match match, int index, int i, int j) {
        Score tempScore = match.getMatchedScoreList().getPosition(index).getPosition(i);
        
        match.getMatchedScoreList().getPosition(index).replacePosition(match.getMatchedScoreList().getPosition(index).getPosition(j), i);
        match.getMatchedScoreList().getPosition(index).replacePosition(tempScore, j);
    }
}
