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
    Score score;

    public JobApplication(JobSeeker jobSeeker, Score score) {
        this.jobSeeker = jobSeeker;
        this.score = score;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public Score getScore() {
        return score;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "JobApplication{" + "jobSeeker=" + jobSeeker + ", score=" + score + '}';
    }
    
    
}
