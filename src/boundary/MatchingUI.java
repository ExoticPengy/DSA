package boundary;


import entity.JobApplication;
import entity.JobPosting;
import entity.Match;
import entity.Score;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class MatchingUI {
    
    private Scanner scanner = new Scanner(System.in);
    
    public void displayMatchHead() {
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("|              Matched Job Postings               |");
        System.out.println("+-------------------------------------------------+");
    }
    
    public void displayApplicationHead() {
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("|                 Apply for Job                   |");
        System.out.println("+-------------------------------------------------+");
    }
    
    public void displayAppliedHead() {
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("|             Newly Added Application             |");
        System.out.println("+-------------------------------------------------+");
    }
    
    public void displayJobMatches(Score score, int index) {
        JobPosting job = score.getJobPosting(); 
        System.out.println("Option Number: " + index);
        System.out.println("Company: " + job.getEmployer().getName());
        System.out.println("Title: " + job.getTitle());
        System.out.println("Description: " + job.getDescription());
        System.out.println("Salary Range: " + job.getSalaryRange());
        System.out.println("Qualification: " + job.getQualification());
        System.out.println("Skills Required: ");
        for (int j = 1; j <= job.getSkills().getCount(); j++) {
            System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
                    + ": " + job.getSkills().getPosition(j).getProficiency());
        }
        System.out.println("Matched Score: " + score.getScore());
        System.out.println("--------------------------------------------------");
    }
    
    public int askChoice(String question) {
        while (true) {
            System.out.print(question
                    + "\n1. Yes"
                    + "\n2. No"
                    + "\nEnter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        return choice;
                    case 2:
                        return choice;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter 1 or 2.");
                scanner.nextLine(); 
            }
        }
    }
    
    public int selectJob(int range) {
        while (true) {
            System.out.print("\nEnter the option number for the job you want to apply for."
                    + "\nEnter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= range) {
                    return choice;
                } else {
                    System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number within the option range.");
                scanner.nextLine(); 
            }
        }
    }
    
    public void displayNewApplication(JobApplication jobApplication) {
        JobPosting job = jobApplication.getScore().getJobPosting();
        System.out.println("Applicant name: " + jobApplication.getJobSeeker().getName());
        System.out.println("Company: " + job.getEmployer().getName());
        System.out.println("Title: " + job.getTitle());
        System.out.println("Description: " + job.getDescription());
        System.out.println("Salary Range: " + job.getSalaryRange());
        System.out.println("Qualification: " + job.getQualification());
        System.out.println("Skills Required: ");
        for (int j = 1; j <= job.getSkills().getCount(); j++) {
            System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
                    + ": " + job.getSkills().getPosition(j).getProficiency());
        }
        System.out.println("Matched Score: " + jobApplication.getScore().getScore());
        System.out.println("--------------------------------------------------");
    }
}
