/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;

/**
 *
 * 
 */
public class JobPosting {
    private String jobID;
    private String employerID;
    private String title;
    private String description;
    private String salaryRange;
    private String qualification;
    private Skill skillScore;

    public JobPosting(String jobID, String employerID, String title, String description, String salaryRange, String qualification, Skill skillScore) {
        this.jobID = jobID;
        this.employerID = employerID;
        this.title = title;
        this.description = description;
        this.salaryRange = salaryRange;
        this.qualification = qualification;
        this.skillScore = skillScore;
    }

    public String getJobID() {
        return jobID;
    }

    public String getEmployerID() {
        return employerID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public String getQualification() {
        return qualification;
    }

    public Skill getSkillScore() {
        return skillScore;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSkillScore(Skill skillScore) {
        this.skillScore = skillScore;
    }
    
    
}
