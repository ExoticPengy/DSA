/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.Scanner;


/**
 *
 * @author mings
 */
public class JobManagement {
    private Scanner scanner =new Scanner(System.in);
    private JobManagement jobManagement;
    
     private void createJobPosting() {
        System.out.print("Enter Job Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Company Name: ");
        String company = scanner.nextLine();
        System.out.print("Enter Location: ");
        String location = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Employment Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Required Skills (comma-separated): ");
        String[] skills = scanner.nextLine().split(",");
        System.out.print("Enter Benefits (comma-separated): ");
        String[] benefits = scanner.nextLine().split(",");
        System.out.print("Enter Application Deadline: ");
        String deadline = scanner.nextLine();

        JobPosting job = new JobPosting(title, company, location, description, type, salary, skills, benefits, deadline);
        jobManagement.createJobPosting(job);
        System.out.println("Job posting created successfully!");
    }
}
