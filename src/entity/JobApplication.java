/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author MingLi
 */
public class JobApplication {
    JobSeeker jobSeeker;
    MatchScore matchScore;

    public JobApplication(JobSeeker jobSeeker, MatchScore matchScore) {
        this.jobSeeker = jobSeeker;
        this.matchScore = matchScore;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public MatchScore getMatchScore() {
        return matchScore;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public void setScore(MatchScore matchScore) {
        this.matchScore = matchScore;
    }

    @Override
    public String toString() {
        return "JobApplication{" + "jobSeeker=" + jobSeeker + ", matchScore=" + matchScore + '}';
    }
    
    
}
