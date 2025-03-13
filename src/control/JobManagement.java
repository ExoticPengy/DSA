/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import dao.JobPostingInitializer;
import entity.Employer;
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
    
    public void createJobPosting(Employer employer) {
        
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
        JobPosting job = new JobPosting(employer, title, description, salaryRange, qualification, skills);

        // Add the job posting to the list
        jobPostings.insertUniqueBack(job);
        
        System.out.println("Job posting created successfully!");
    }

    //display all job postings
    public void viewAllJobs() {
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
        } else {
            System.out.println("\n+-------------------------------------------------+");
            System.out.println("|                All Job Postings                 |");
            System.out.println("+-------------------------------------------------+");
            for (int i = 1; i <= jobPostings.getCount(); i++) { 
                JobPosting job = jobPostings.getPosition(i); 
                System.out.println("Employer name: " + job.getEmployer().getName());
                System.out.println("Title: " + job.getTitle());
                System.out.println("Description: " + job.getDescription());
                System.out.println("Salary Range: " + job.getSalaryRange());
                System.out.println("Qualification: " + job.getQualification());
                System.out.println("Skills Required: ");
                for (int j = 1; j <= job.getSkills().getCount(); j++) {
                    System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
                            + ": " + job.getSkills().getPosition(j).getProficiency());
                }
                System.out.println("--------------------------------------------------");
            }
        }
    }
    
    public void updatedJobPosting() {
    if (jobPostings.isEmpty()) {
        System.out.println("No job postings available to update.");
        return;
    }

    // Display a numbered list of job titles
    System.out.println("\nList of Job Postings:");
    for (int i = 1; i <= jobPostings.getCount(); i++) {
        JobPosting job = jobPostings.getPosition(i);
        System.out.println(i + ". " + job.getTitle());
    }

    // Prompt the user to select a job posting by number
    System.out.print("Enter the number of the job posting you want to update: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Clear the buffer

    if (choice < 1 || choice > jobPostings.getCount()) {
        System.out.println("Invalid choice. No changes made.");
        return;
    }

    // Get the job posting to update
    JobPosting jobToUpdate = jobPostings.getPosition(choice);

    // Display the selected job posting
    System.out.println("\nSelected Job Posting:");
    System.out.println("Employer Name: " + jobToUpdate.getEmployer().getName());
    System.out.println("Title: " + jobToUpdate.getTitle());
    System.out.println("Description: " + jobToUpdate.getDescription());
    System.out.println("Salary Range: " + jobToUpdate.getSalaryRange());
    System.out.println("Qualification: " + jobToUpdate.getQualification());
    System.out.println("Skills Required: ");
    for (int j = 1; j <= jobToUpdate.getSkills().getCount(); j++) {
        System.out.println(j + ". " + jobToUpdate.getSkills().getPosition(j).getName()
                + ": " + jobToUpdate.getSkills().getPosition(j).getProficiency());
    }

    // Prompt the user to update attributes
    System.out.println("\nWhat would you like to update?");
    System.out.println("1. Title");
    System.out.println("2. Description");
    System.out.println("3. Salary Range");
    System.out.println("4. Qualification");
    System.out.println("5. Skills");
    System.out.print("Enter your choice: ");
    int updateChoice = scanner.nextInt();
    scanner.nextLine(); // Clear the buffer

    switch (updateChoice) {
        case 1:
            System.out.print("Enter new Title: ");
            String newTitle = scanner.nextLine();
            jobToUpdate.setTitle(newTitle);
            break;
        case 2:
            System.out.print("Enter new Description: ");
            String newDescription = scanner.nextLine();
            jobToUpdate.setDescription(newDescription);
            break;
        case 3:
            System.out.print("Enter new Salary Range: ");
            String newSalaryRange = scanner.nextLine();
            jobToUpdate.setSalaryRange(newSalaryRange);
            break;
        case 4:
            System.out.print("Enter new Qualification: ");
            String newQualification = scanner.nextLine();
            jobToUpdate.setQualification(newQualification);
            break;
        case 5:
            //updateSkills(jobToUpdate); 
            break;
        default:
            System.out.println("Invalid choice. No changes made.");
            return;
    }

    // Replace the old job posting with the updated one
    jobPostings.replacePosition(jobToUpdate, choice);
    System.out.println("Job posting updated successfully!");
}

}