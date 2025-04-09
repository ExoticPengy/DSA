/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;

/**
 *
 * 
 */
public class JobPosting {
    private Employer employer;
    private String title;
    private String description;
    private String salaryRange;
    private String qualification;
    private DoublyLinkedListInterface<Skill> skills;
    
    public JobPosting(Employer employer, String title, String description, String salaryRange, String qualification, DoublyLinkedListInterface<Skill> skills) {
        this.employer = employer;
        this.title = title;
        this.description = description;
        this.salaryRange = salaryRange;
        this.qualification = qualification;
        this.skills = skills;
    }
    
    // MingLi
    public JobPosting(JobPosting copy) {
        this(
            copy.employer,
            copy.title,
            copy.description,
            copy.salaryRange,
            copy.qualification,
            copySkillList(copy.skills)
        );
    }
    
    //MingLi
    private static DoublyLinkedListInterface<Skill> copySkillList(DoublyLinkedListInterface<Skill> originalSkills) {
        DoublyLinkedListInterface<Skill> copiedSkills = new DoublyLinkedList<>();
        for (int i = 1; i <= originalSkills.getCount(); i++) {
            Skill originalSkill = originalSkills.getPosition(i);
            Skill copiedSkill = new Skill(originalSkill); 
            copiedSkills.insertBack(copiedSkill);
        }
        return copiedSkills;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public DoublyLinkedListInterface<Skill> getSkills() {
        return skills;
    }

    public void setSkills(DoublyLinkedListInterface<Skill> skills) {
        this.skills = skills;
    }

    
}
