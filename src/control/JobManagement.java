/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedListInterface;
import entity.JobPosting;
import entity.Skill;
import java.util.Scanner;

/**
 *
 * @author mings
 */
public class JobManagement {
    private Scanner scanner = new Scanner(System.in);
    private DoublyLinkedListInterface<JobPosting> jobPostings; // Store job postings

    // Constructor to initialize jobPostings
    public JobManagement(DoublyLinkedListInterface<JobPosting> jobPostings) {
        this.jobPostings = jobPostings;
    }

    // Method to create a job posting
    public void createJobPosting() {
        System.out.print("Enter Job ID: ");
        String jobID = scanner.nextLine();
        System.out.print("Enter Employer Id: ");
        String employerID = scanner.nextLine();
        System.out.print("Enter Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Salary Range: ");
        String salaryRange = scanner.nextLine();
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();
        System.out.print("What is the skill required?\n"
                + "1. Communication \n2. Leadership \n3. Programming \n4. Analysis");
        String skillName ;
        switch(scanner.nextInt()) {
            case 1:
                    skillName = "Communication";
                break;
            case 2:
                    skillName = "Leadership";
                break;
            case 3:
                    skillName = "Programming";
                break;
            case 4:
                    
                break;
        }


        // Create a new JobPosting object
        JobPosting job = new JobPosting(jobID, employerID, title, description, salaryRange, qualification, skills);

        // Add the job posting to the list
        jobPostings.add(job);
        System.out.println("Job posting created successfully!");
    }

    // Method to display all job postings
    public void viewAllJobs() {
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
        } else {
            System.out.println("\nAll Job Postings:");
            for (int i = 0; i < jobPostings.size(); i++) {
                JobPosting job = jobPostings.get(i);
                System.out.println("Job ID: " + job.getJobID());
                System.out.println("Title: " + job.getTitle());
                System.out.println("Description: " + job.getDescription());
                System.out.println("Salary Range: " + job.getSalaryRange());
                System.out.println("Qualification: " + job.getQualification());
                System.out.println("Skills Required: " + job.getSkills());
                System.out.println("-----------------------------");
            }
        }
    }

    // Method to close the scanner
    public void closeScanner() {
        scanner.close();
    }
}