/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mings
 */
public class Interview {
    private String jobPostingID;
    private String jobSeekerID;     //direct interview list of jobseeker
    private String employerID;
    private String date;
    private String time;
    private String status;
    private int score;

    public Interview(String jobPostingID, String jobSeekerID, String employerID, String date, String time, String status, int score) {
        this.jobPostingID = jobPostingID;
        this.jobSeekerID = jobSeekerID;
        this.employerID = employerID;
        this.date = date;
        this.time = time;
        this.status = status;
        this.score = score;
    }

    public String getJobPostingID() {
        return jobPostingID;
    }

    public String getJobSeekerID() {
        return jobSeekerID;
    }

    public String getEmployerID() {
        return employerID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public int getScore() {
        return score;
    }

    public void setJobPostingID(String jobPostingID) {
        this.jobPostingID = jobPostingID;
    }

    public void setJobSeekerID(String jobSeekerID) {
        this.jobSeekerID = jobSeekerID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
