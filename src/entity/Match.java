package entity;

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
    private JobSeeker jobSeeker;
    private int matchScore;

    public Match(JobPosting jobPosting, JobSeeker jobSeeker, int matchScore) {
        this.jobPosting = jobPosting;
        this.jobSeeker = jobSeeker;
        this.matchScore = matchScore;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public int getMatchScore() {
        return matchScore;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public void setMatchScore(int matchScore) {
        this.matchScore = matchScore;
    }
    
    
}
