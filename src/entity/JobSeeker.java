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

    private String jobSeekerID;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String location;
    private String qualification;
    private DoublyLinkedListInterface<Skill> skills;

    //filter
//    public boolean inLocation(String targetLocation) {
//        return location.equalsIgnoreCase(targetLocation);
//    }
//
//    @Override
//    public String toString() {
//        return "Applicant {"
//                + "ID:'" + jobSeekerID + '\''
//                + ", Name:'" + name + '\''
//                + ", Age:" + age
//                + ", Gender:'" + gender + '\''
//                + ", Email:'" + email + '\''
//                + ", Location:'" + location + '\''
//                + ", QualificationID:'" + qualificationID + '\''
//                + '}';
//    }

    public JobSeeker(String jobSeekerID, String name, int age, String gender, String email, String location, String qualification, DoublyLinkedListInterface<Skill> skills) {
        this.jobSeekerID = jobSeekerID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.location = location;
        this.qualification = qualification;
        this.skills = skills;
    }

    public String getJobSeekerID() {
        return jobSeekerID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getQualification() {
        return qualification;
    }

    public DoublyLinkedListInterface<Skill> getSkills() {
        return skills;
    }

    public void setJobSeekerID(String jobSeekerID) {
        this.jobSeekerID = jobSeekerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSkills(DoublyLinkedListInterface<Skill> skills) {
        this.skills = skills;
    }

    
}
