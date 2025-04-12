/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.MatchingUI;
import dao.JobApplicationInitializer;
import entity.Discrepancy;
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
    private JobApplicationInitializer jobApplicationInitializer;
    
    public MatchingEngine(){
        matchingUI = new MatchingUI();
        matchList = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        jobPostingList = new DoublyLinkedList<>();
        jobApplicationList = new DoublyLinkedList<>();
        jobApplicationInitializer = new JobApplicationInitializer();
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
        
        matchingUI.displayInitializeMatchHead();
        for (int i = 1; i <= initializeList.getJobSeekerList().getCount(); i++) {
            matchingUI.displayJobSeekerHead(initializeList.getJobSeekerList().getPosition(i), i);
            DoublyLinkedListInterface<MatchScore> scoreList = getLatestMatch().getMatchScoreList().getPosition(i);
            for (int j = 1; j <= scoreList.getCount(); j++) {
                matchingUI.displayJobMatches(scoreList.getPosition(j), j);
            }
        }
        matchingUI.displayMatchFoot();
        
        initializeApplicants(getLatestMatch());
        matchingUI.displayInitializeApplicationHead();
        for (int i = 1; i <= initializeList.getJobSeekerList().getCount(); i++) {
            displayUserApplications(initializeList.getJobSeekerList().getPosition(i));
        }
        matchingUI.displayApplicationFoot();
                
    }
    
    private void initializeApplicants(Match match) {
        jobApplicationList = jobApplicationInitializer.getJobApplication(match);
    }
    
    public void startMatchingEngine(JobSeeker jobSeeker) {
        calculateMatches();
        sortMatch();
        displayMatches(jobSeeker);
        switch(matchingUI.applicationMenu()) {
            case 1:
                applyJob(jobSeeker);
                break;
            case 2:
                filterJob(jobSeeker);
                break;
            default:
                break;
        }
    }
    
    public void filterJob(JobSeeker jobSeeker) {
        String location = matchingUI.askLocation();
        int minScore = matchingUI.askScore();
        int jobCount = 0;
        
        if (jobSeeker != null) {
            matchingUI.displayMatchHead();
            DoublyLinkedListInterface<MatchScore> scoreList = getLatestMatch().getMatchScoreList().getPosition(getCurrentSeekerIndex(jobSeeker));
            for (int i = 1; i <= scoreList.getCount(); i++) {
                if (scoreList.getPosition(i).getJobPosting().getEmployer().getLocation().equals(location) && scoreList.getPosition(i).getScore() >= minScore) {
                    jobCount++;
                    matchingUI.displayJobMatches(scoreList.getPosition(i), jobCount);
                }
            }
            matchingUI.displayMatchFoot();
        
            if (jobCount > 0) {
                if (matchingUI.askChoice("\nWould you like to apply for a job?") == 1) {
                    Match latestMatch = getLatestMatch();
                    DoublyLinkedListInterface<MatchScore> currentUserScoreList = latestMatch.getMatchScoreList().getPosition(getCurrentSeekerIndex(jobSeeker));
                    int selectedJobIndex = matchingUI.selectJob(jobCount);
                    int findJob = 0;
                    for (int i = 1; i <= scoreList.getCount(); i++) {
                        if (scoreList.getPosition(i).getJobPosting().getEmployer().getLocation().equals(location) && scoreList.getPosition(i).getScore() >= minScore) {
                            findJob++;
                            if (findJob == selectedJobIndex) {
                                selectedJobIndex = i;
                                break;
                            }
                        }
                    }
                    JobApplication newJobApplication = new JobApplication(jobSeeker, currentUserScoreList.getPosition(selectedJobIndex));

                    if (checkApplicationExists(newJobApplication, jobSeeker)) {
                        switch(matchingUI.askChoice("\nYou have already applied to this job. Please wait for the company to review your application.\nWould you like to select another job?"
                            + "\nEnter your choice: ")){
                        case 1:
                            filterJob(jobSeeker);
                            return;
                        default:
                            return;
                        }
                    }

                    jobApplicationList.insertBack(newJobApplication);
                    matchingUI.displayNewApplicationHead();
                    matchingUI.displayApplication(jobApplicationList.getBack());
                    matchingUI.displayApplicationFoot();
                    matchingUI.displayJobSeeker(jobSeeker);
                }
            } else {
                switch(matchingUI.askChoice("\nNo job with these filters found, Try again?"
                            + "\nEnter your choice: ")){
                    case 1:
                        filterJob(jobSeeker);
                        return;
                    default:
                        return;
                    }
            }
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
        matchingUI.displayApplicationFoot();
        matchingUI.displayJobSeeker(jobSeeker);
    }
    
    public void viewUserApplications(JobSeeker jobSeeker) {
        matchingUI.displayJobSeeker(jobSeeker);
        matchingUI.displayApplyListHead();
        displayUserApplications(jobSeeker);
        matchingUI.displayApplicationFoot();
    }
    
    public void displayUserApplications(JobSeeker jobSeeker) {
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
    
    public DoublyLinkedListInterface<JobApplication> getJobApplicationList() {
        return jobApplicationList;
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

                    if (jobPosting.getEmployer().getLocation().equals(jobSeeker.getLocation())) {
                        matchScore += 10;
                    }
                    
                    if (jobPosting.getQualification().equals(jobSeeker.getQualification())) {
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
    
    public void generateMatchReport() {
        if (matchList.getCount() < 2) {
            matchingUI.displayMessage("Not enough match lists.");
            return;
        }
        
        boolean foundDiscrepancies = false;
        DoublyLinkedListInterface<Discrepancy> discrepancyList = new DoublyLinkedList<>();

        // Initialize trackers for all sets
        for (int i = 1; i <= matchList.getCount(); i++) {
            discrepancyList.insertBack(new Discrepancy(i, 0));
        }
    
        for (int i = 1; i <= matchList.getCount(); i++) {
            Match currentMatch = matchList.getPosition(i);

            for (int j = i + 1; j <= matchList.getCount(); j++) {
                Match compareMatch = matchList.getPosition(j);

                for (int k = 1; k <= currentMatch.getJobSeekerList().getCount(); k++) {
                    JobSeeker seeker = currentMatch.getJobSeekerList().getPosition(k);

                    int compareSeekerIdx = compareSeeker(seeker, compareMatch.getJobSeekerList());
                    if (compareSeekerIdx == -1) { 
                        continue;
                    }

                    DoublyLinkedListInterface<MatchScore> currentScores = currentMatch.getMatchScoreList().getPosition(k);
                    DoublyLinkedListInterface<MatchScore> compareScores = compareMatch.getMatchScoreList().getPosition(compareSeekerIdx);

                    for (int scoreIdx = 1; scoreIdx <= currentScores.getCount(); scoreIdx++) {
                        MatchScore currentScore = currentScores.getPosition(scoreIdx);

                        MatchScore compareScore = compareJobPosting(currentScore.getJobPosting(), compareScores);
                        if (compareScore == null) { 
                            continue;
                        }

                        if (currentScore.getScore() != compareScore.getScore()) {
                            incrementDiscrepancy(discrepancyList, i);
                            incrementDiscrepancy(discrepancyList, j);
                        
                            if (!foundDiscrepancies) {
                                matchingUI.printReportHeader();
                                foundDiscrepancies = true;
                            }
                            int scoreDiff;
                            String scoreDifference;
                            if (currentScore.getScore() > compareScore.getScore()) {
                                scoreDiff = currentScore.getScore() - compareScore.getScore();
                                scoreDifference = "-" + scoreDiff;
                            } else {
                                scoreDiff = compareScore.getScore() - currentScore.getScore();
                                scoreDifference = "+" + scoreDiff;
                            }
                            
                            matchingUI.printReport(
                                i, seeker, currentScore, j, compareMatch.getJobSeekerList().getPosition(compareSeekerIdx), compareScore, scoreDifference 
                            );
                        }
                    }
                }
            }
        }

        if (!foundDiscrepancies) {
            matchingUI.displayMessage("No score discrepancies found across all match sets.");
        } else {
            matchingUI.displayDiscrepancyChart(discrepancyList);
            matchingUI.printReportFooter();
        }
    }
    
    private int compareSeeker(JobSeeker seeker, DoublyLinkedListInterface<JobSeeker> list) {
        for (int i = 1; i <= list.getCount(); i++) {
            if (list.getPosition(i).equals(seeker)) {
                return i;
            }
        }
        return -1;
    }
    
    private MatchScore compareJobPosting(JobPosting posting, DoublyLinkedListInterface<MatchScore> scores) {
        for (int i = 1; i <= scores.getCount(); i++) {
            if (scores.getPosition(i).getJobPosting().equals(posting)) {
                return scores.getPosition(i);
            }
        }
        return null;
    }
    
    private void incrementDiscrepancy(DoublyLinkedListInterface<Discrepancy> discrepancyList, int setNumber) {
        for (int i = 1; i <= discrepancyList.getCount(); i++) {
            Discrepancy discrepancy = discrepancyList.getPosition(i);
            if (discrepancy.getSetNo() == setNumber) {
                discrepancy.incrementAmount();
                return;
            }
        }
    }
}
