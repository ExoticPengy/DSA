package boundary;


import entity.JobPosting;
import entity.Match;
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
        System.out.println("|              Matched Job Postings                |");
        System.out.println("+-------------------------------------------------+");
    }
    
    public void displayApplicationHead() {
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("|                 Apply for Job                    |");
        System.out.println("+-------------------------------------------------+");
    }
    
    public void displayJobMatches(Match match, int index) {
        JobPosting job = match.getJobPostingList().getPosition(index); 
        System.out.println("Option Number: " + index);
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
        System.out.println("Matched Score: " + match.getMatchedScoreList().getPosition(index));
        System.out.println("--------------------------------------------------");
    }
    
    public int askApplyJob() {
        while (true) {
            System.out.print("\nApply for a job?"
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
                if (choice >= 1 || choice <= range) {
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
}
