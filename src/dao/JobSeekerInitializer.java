/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.JobSeeker;
import entity.Skill;

/**
 *
 * @author chienxing
 */
public class JobSeekerInitializer {

    public DoublyLinkedListInterface<JobSeeker> getJobSeeker() {
        DoublyLinkedListInterface<JobSeeker> applicants = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();

        //JobSeeker 1
        skills.insertFront(new Skill("Communication",7));
        skills.insertBack(new Skill("Programming",9));
        applicants.insertFront(new JobSeeker("John Doe", 22, "Male", "john@example.com", "Kuala Lumpur", "Diploma in Computer Science", skills));

        //JobSeeker 2
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership",8));
        skills.insertBack(new Skill("Analysis",3));
        applicants.insertBack(new JobSeeker("Sarah Lee", 19, "Female", "sarah@example.com", "Penang", "Bachelor in Business", skills));

        //JobSeeker 3
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership",6));
        skills.insertBack(new Skill("Analysis",0));
        applicants.insertBack(new JobSeeker("Michael Smith", 20, "Male", "michael@example.com", "Johor Bahru", "Bachelor in Information Security", skills));

        //JobSeeker 4
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication",5));
        skills.insertBack(new Skill("Analysis",6));
        applicants.insertBack(new JobSeeker("Emma Brown", 29, "Female", "emma@example.com", "Kuala Lumpur", "Bachelor in Financial Technology", skills));

        //JobSeeker 5
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming",10));
        skills.insertBack(new Skill("Leadership",2));
        applicants.insertBack(new JobSeeker("Kevin Johnson", 32, "Male", "kevin@example.com", "Subang Jaya", "Bachelor in Software Engineering", skills));

        //JobSeeker 6
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication",8));
        skills.insertBack(new Skill("Programming",6));
        applicants.insertBack(new JobSeeker("Lily Williams", 26, "Female", "lily@example.com", "Petaling Jaya", "Bachelor in Information System", skills));

        //JobSeeker 7
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis",9));
        skills.insertBack(new Skill("Leadership",4));
        applicants.insertBack(new JobSeeker("Daniel Garcia", 28, "Male", "daniel@example.com", "Klang", "Bachelor in Public Relations", skills));

        //JobSeeker 8
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership",6));
        skills.insertBack(new Skill("Programming",5));
        applicants.insertBack(new JobSeeker("Jessica Martinez", 24, "Female", "jessica@example.com", "Ipoh", "Bachelor in International Business", skills));

        //JobSeeker 9
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis",2));
        skills.insertBack(new Skill("Communication",7));
        applicants.insertBack(new JobSeeker("Ryan Anderson", 31, "Male", "ryan@example.com", "Alor Setar", "Diploma in Information Security", skills));

        //JobSeeker 10
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming",8));
        skills.insertBack(new Skill("Analysis",8));
        applicants.insertBack(new JobSeeker("Olivia Wilson", 29, "Female", "olivia@example.com", "Melaka", "Bachelor in Information Technology", skills));

        //JobSeeker 11
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication",9));
        skills.insertBack(new Skill("Leadership",5));
        applicants.insertBack(new JobSeeker("Sam Taylor", 35, "Male", "sam@example.com", "Miri", "Bachelor in Management", skills));

        //JobSeeker 12
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis",7));
        skills.insertBack(new Skill("Communication",3));
        applicants.insertBack(new JobSeeker("Chloe Lee", 28, "Female", "chloe@example.com", "Seremban", "Bachelor in Financial Technology", skills));

        //JobSeeker 13
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership",10));
        skills.insertBack(new Skill("Programming",1));
        applicants.insertBack(new JobSeeker("Ethan Moore", 27, "Male", "ethan@example.com", "Johor Bahru", "Bachelor in Entrepreneurship", skills));

        //JobSeeker 14
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication",6));
        skills.insertBack(new Skill("Programming",5));
        applicants.insertBack(new JobSeeker("Mia Jackson", 30, "Female", "mia@example.com", "Kuantan", "Bachelor in Data Science", skills));

        //JobSeeker 15
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis",7));
        skills.insertBack(new Skill("Leadership",5));
        applicants.insertBack(new JobSeeker("Mark Harris", 32, "Male", "mark@example.com", "Shah Alam", "Diploma in Game Development", skills));

        //JobSeeker 16
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership",8));
        skills.insertBack(new Skill("Communication",7));
        applicants.insertBack(new JobSeeker("Kate Lewis", 26, "Female", "kate@example.com", "Kuala Lumpur", "Bachelor in Human Resource Management", skills));

        //JobSeeker 17
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis",9));
        skills.insertBack(new Skill("Programming",4));
        applicants.insertBack(new JobSeeker("Jason Clark", 29, "Male", "jason@example.com", "Petaling Jaya", "Bachelor in Information Security", skills));

        //JobSeeker 18
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership",6));
        skills.insertBack(new Skill("Analysis",3));
        applicants.insertBack(new JobSeeker("Vanessa Scott", 25, "Female", "vanessa@example.com", "Melaka", "Bachelor in Business", skills));

        //JobSeeker 19
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication",8));
        skills.insertBack(new Skill("Analysis",5));
        applicants.insertBack(new JobSeeker("Joshua Young", 28, "Male", "joshua@example.com", "Ipoh", "Diploma in Human Resource Management", skills));

        //JobSeeker 20
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming",8));
        skills.insertBack(new Skill("Communication",7));
        applicants.insertBack(new JobSeeker("Rachel Adams", 31, "Female", "rachel@example.com", "Kuala Lumpur", "Bachelor in Computer Science", skills));

        return applicants;
//        System.out.println("\nApplicants List:");
//        for (int i = 0; i < applicants.size(); i++) {
//            System.out.println(applicants.get(i));
//        }
//
//        // Update an applicant
//        JobSeeker updatedApplicant = new JobSeeker("JS001", "John Doe", 23, "Male", "john@example.com", "Klang", "Q001");
//        applicants.update(0, updatedApplicant);
//
//        System.out.println("\nAfter Update:");
//        for (int i = 0; i < applicants.size(); i++) {
//            System.out.println(applicants.get(i));
//        }
//
//        // Remove an applicant
//        applicants.remove(updatedApplicant);
//
//        System.out.println("\nAfter Removal:");
//        for (int i = 0; i < applicants.size(); i++) {
//            System.out.println(applicants.get(i));
//        }
//
//        // Filter applicants by location
//        String filterLocation = "Kuala Lumpur";
//        JobSeekerList<JobSeeker> KLApplicants = applicants.filterByLocation(filterLocation);
//
//        System.out.println("\nApplicants in " + filterLocation);
//        for (int i = 0; i < KLApplicants.size(); i++) {
//            System.out.println(KLApplicants.get(i));
//        }
//    }
    }
}
