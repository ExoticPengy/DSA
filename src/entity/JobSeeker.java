/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;

/**
 *
 * @author mings
 */
public class JobSeeker {
    private String name;
    private int age;
    private String gender;
    private String email;
    private String location;
    private String qualification;
    private DoublyLinkedListInterface<Skill> skills;

    public JobSeeker(String name, int age, String gender, String email, String location, String qualification, DoublyLinkedListInterface<Skill> skills) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.location = location;
        this.qualification = qualification;
        this.skills = skills;
    }
    
    // MingLi
    public JobSeeker(JobSeeker copy) {
        this(
            copy.name,
            copy.age,
            copy.gender,
            copy.email,
            copy.location,
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
