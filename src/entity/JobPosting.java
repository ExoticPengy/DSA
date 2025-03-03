/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * 
 */
public class JobPosting {
    private int jobId;
    private String title;
    private String description;
    private Qualification qualification;
    private Skill skills; //Need to use adt
    private String location;
    private String jobType;
    private double salaryRange;

    public JobPosting(int jobId, String title, String description, Qualification qualification, Skill skills, String location, String jobType, double salaryRange) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.qualification = qualification;
        this.skills = skills;
        this.location = location;
        this.jobType = jobType;
        this.salaryRange = salaryRange;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public Skill getSkills() {
        return skills;
    }

    public String getLocation() {
        return location;
    }

    public String getJobType() {
        return jobType;
    }

    public double getSalaryRange() {
        return salaryRange;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setSalaryRange(double salaryRange) {
        this.salaryRange = salaryRange;
    }

    
    
}
