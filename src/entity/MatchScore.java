/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author USER
 */
public class MatchScore {
    private JobPosting jobPosting;
    private int score;

    public MatchScore(JobPosting jobPosting, int score) {
        this.jobPosting = jobPosting;
        this.score = score;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public int getScore() {
        return score;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" + "jobPosting=" + jobPosting + ", score=" + score + '}';
    }
    
    
}
