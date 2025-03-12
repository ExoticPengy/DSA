/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import dao.JobPostingInitializer;
import entity.JobPosting;
import entity.Skill;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class JobManagement {
    private Scanner scanner = new Scanner(System.in);
    private JobPostingInitializer jobPostingInitializer;
    private DoublyLinkedListInterface<JobPosting> jobPostings;
    
    public JobManagement(){
        jobPostingInitializer = new JobPostingInitializer();
        jobPostings = new DoublyLinkedList<>();
    }
    
    public void runJobManagement() {
        jobPostings = jobPostingInitializer.getJobPosting();
    }
    
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

        boolean repeat = true;
        boolean validOption = false;
        int choice;
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        
        while (repeat) {
            String skillName = "";
            int proficiency = 0;
            validOption = false;
            
            // Prompt for required skills
            while (!validOption) {
                System.out.print("What is the skill required?\n"
                        + "1. Communication \n2. Leadership \n3. Programming \n4. Analysis\n"
                        + "Enter your choice: ");

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            skillName = "Communication";
                            validOption = true;
                            break;
                        case 2:
                            skillName = "Leadership";
                            validOption = true;
                            break;
                        case 3:
                            skillName = "Programming";
                            validOption = true;
                            break;
                        case 4:
                            skillName = "Analysis";
                            validOption = true;
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a number between 1-4.");
                    scanner.nextLine();
                }
            }

            // Get proficiency level
            validOption = false;
            while (!validOption) {
                System.out.print("Enter proficiency of chosen skill (1-10): ");

                try {
                    proficiency = scanner.nextInt();
                    scanner.nextLine();
                    if (proficiency >= 1 && proficiency <= 10) {
                        validOption = true;
                    } else {
                        System.out.println("Invalid input, please enter a number between 1-10.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.nextLine(); 
                }
            }

            skills.insertBack(new Skill(skillName, proficiency));

            // add new skill
            validOption = false;
            while (!validOption) {
                System.out.print("Add another skill?" + "\n1. Yes\n2. No\nEnter your choice: ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            validOption = true;
                            break;
                        case 2:
                            repeat = false;
                            validOption = true;
                            break;
                        default:
                            System.out.println("Invalid option, try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter 1 or 2.");
                    scanner.nextLine(); 
                }
            }
        }
        
        // Create a new JobPosting object
        JobPosting job = new JobPosting(jobID, employerID, title, description, salaryRange, qualification, skills);

        // Add the job posting to the list
        jobPostings.insertUniqueBack(job);
        System.out.println("Job posting created successfully!");
    }

    //display all job postings
    public void viewAllJobs() {
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
        } else {
            System.out.println("\nAll Job Postings:");
            for (int i = 1; i <= jobPostings.getCount(); i++) { // Use getCount for size
                JobPosting job = jobPostings.getPosition(i); // Use getPosition to retrieve job postings
                System.out.println("Job ID: " + job.getJobID());
                System.out.println("Title: " + job.getTitle());
                System.out.println("Description: " + job.getDescription());
                System.out.println("Salary Range: " + job.getSalaryRange());
                System.out.println("Qualification: " + job.getQualification());
                System.out.println("Skills Required: ");
                for (int j = 1; j <= job.getSkills().getCount(); j++) {
                    System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
                            + ": " + job.getSkills().getPosition(j).getProficiency());
                }
                System.out.println("-----------------------------");
            }
        }
    }

   
}