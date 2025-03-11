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
    private Scanner scanner =new Scanner(System.in);
    private JobManagement jobManagement;
    
     private void createJobPosting() {
        System.out.print("Enter Job ID: ");
        String jobID = scanner.nextLine();
        System.out.print("Enter Employer ID: ");
        String employerID = scanner.nextLine();
        System.out.print("Enter Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Salary Range: ");
        String salaryRange = scanner.nextLine();
        System.out.print("Enter Qualification: ");
        double qualification = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Required Skills (comma-separated): ");
        String[] skills = scanner.nextLine().split(",");
        System.out.print("Enter Benefits (comma-separated): ");
        String[] benefits = scanner.nextLine().split(",");
        System.out.print("Enter Application Deadline: ");
        String deadline = scanner.nextLine();

        JobPosting job = new JobPosting(jobID, employerID, title, description, salaryRange, qualification, skills);
        jobPosting.createJobPosting(job);
        System.out.println("Job posting created successfully!");
    }
}
