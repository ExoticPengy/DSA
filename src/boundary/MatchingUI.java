package boundary;


import entity.JobApplication;
import entity.JobPosting;
import entity.Match;
import entity.MatchScore;
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
        System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                   Matched Job Postings                                                                                        |");
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s | %-6s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills", "Score");
    }
    
    public void displayInitializeMatchHead() {
        System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                     Initialized Match List                                                                                    |");
    }
    
    public void displayInitializeApplicationHead() {
        System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                    Initialized Application List                                                                                           |");
        System.out.println("+----------------+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-14s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s | %-6s |\n",
                "Applicant", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills", "Score");
    }
    
    public void displayJobSeekerHead(String jobSeeker) {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|                                                                                      Applicant: %-20s                                                                          |\n", jobSeeker);
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s | %-6s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills", "Score");
    }
    
    public void displayMatchFoot() {
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
    }
    
    public void displayApplicationFoot() {
        System.out.println("+----------------+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
    }
    
    public void displayApplicationHead() {
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("|                 Apply for Job                   |");
        System.out.println("+-------------------------------------------------+");
    }
    
    public void displayNewApplicationHead() {
        System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                           New Application                                                                                                 |");
        System.out.println("+----------------+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-14s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s | %-6s |\n",
                "Applicant", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills", "Score");
    }
    
    public void displayApplyListHead() {
        System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                           Your Applications                                                                                               |");
        System.out.println("+----------------+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-14s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s | %-6s |\n",
                "Applicant", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills", "Score");
    }
    
    public void displayJobMatches(MatchScore score, int index) {
        JobPosting job = score.getJobPosting();
        String shortTitle = job.getTitle().length() > 29 ?
                           job.getTitle().substring(0, 25) + "..." :
                           job.getTitle();
        
        String shortDesc = job.getDescription().length() > 29 ? 
                       job.getDescription().substring(0, 25) + "..." : 
                       job.getDescription();
        
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-2d ", index);
        System.out.printf("| %-14s ", job.getEmployer().getName());
        System.out.printf("| %-14s ", job.getEmployer().getLocation());
        System.out.printf("| %-30s ", shortTitle);
        System.out.printf("| %-30s ", shortDesc);
        System.out.printf("| %-14s ", job.getSalaryRange());
        System.out.printf("| %-30s ", job.getQualification());
            
        for (int i = 1; i <= job.getSkills().getCount(); i++) {
            if (job.getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d", i, job.getSkills().getPosition(i).getName(), job.getSkills().getPosition(i).getProficiency());
                System.out.printf("| %-6d |\n", score.getScore());
            } else {
                System.out.printf("| (%d) %-19s %-2d", i, job.getSkills().getPosition(i).getName(), job.getSkills().getPosition(i).getProficiency());
                if (i == 1) {
                    System.out.printf("| %-6d |\n", score.getScore());
                } else {
                    System.out.printf("| %-6s |\n", "");
                }
                if (i < job.getSkills().getCount()) {
                    System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s ",
                            "", "", "", "", "", "", "");
                }
            }
        }
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
    
    public void displayApplication(JobApplication jobApplication) {
        MatchScore score = jobApplication.getMatchScore();
        JobPosting job = score.getJobPosting();
        
        String shortTitle = job.getTitle().length() > 29 ?
                           job.getTitle().substring(0, 25) + "..." :
                           job.getTitle();
        
        String shortDesc = job.getDescription().length() > 29 ? 
                       job.getDescription().substring(0, 25) + "..." : 
                       job.getDescription();
        
        System.out.println("+----------------+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+--------+");
        System.out.printf("| %-14s ", jobApplication.getJobSeeker().getName());
        System.out.printf("| %-14s ", job.getEmployer().getName());
        System.out.printf("| %-14s ", job.getEmployer().getLocation());
        System.out.printf("| %-30s ", shortTitle);
        System.out.printf("| %-30s ", shortDesc);
        System.out.printf("| %-14s ", job.getSalaryRange());
        System.out.printf("| %-30s ", job.getQualification());
            
        for (int i = 1; i <= job.getSkills().getCount(); i++) {
            if (job.getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d", i, job.getSkills().getPosition(i).getName(), job.getSkills().getPosition(i).getProficiency());
                System.out.printf("| %-6d |\n", score.getScore());
            } else {
                System.out.printf("| (%d) %-19s %-2d", i, job.getSkills().getPosition(i).getName(), job.getSkills().getPosition(i).getProficiency());
                if (i == 1) {
                    System.out.printf("| %-6d |\n", score.getScore());
                } else {
                    System.out.printf("| %-6s |\n", "");
                }
                if (i < job.getSkills().getCount()) {
                    System.out.printf("| %-14s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s ",
                            "", "", "", "", "", "", "");
                }
            }
        }
    }
    
}
