package boundary;


import adt.DoublyLinkedListInterface;
import entity.Discrepancy;
import entity.JobApplication;
import entity.JobPosting;
import entity.JobSeeker;
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
    
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
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
    
    public void displayJobSeekerHead(JobSeeker jobSeeker, int index) {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-40s | %-25s |\n", "No", "Applicant", "Location", "Qualification", "Skills");
        System.out.println("+-------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-2d ", index);
        System.out.printf("| %-14s ", jobSeeker.getName());
        System.out.printf("| %-14s ", jobSeeker.getLocation());
        System.out.printf("| %-40s ", jobSeeker.getQualification());
        for (int i = 1; i <= jobSeeker.getSkills().getCount(); i++) {
            if (jobSeeker.getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobSeeker.getSkills().getPosition(i).getName(), jobSeeker.getSkills().getPosition(i).getProficiency());
            } else {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobSeeker.getSkills().getPosition(i).getName(), jobSeeker.getSkills().getPosition(i).getProficiency());
                if (i < jobSeeker.getSkills().getCount()) {
                    System.out.printf("| %-2s | %-14s | %-14s | %-40s ",
                            "", "", "", "");
                }
            }
        }
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
    
    public void printReportHeader() {
        System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                         MATCH SCORE DISCREPANCY REPORT                                                                        |");
        System.out.println("+----------------+----------------+--------------------------------+----------------------+--------------------------------+---------------------------+-----+--------+---------+");
        System.out.printf("| %-14s | %-14s | %-30s | %-20s | %-30s | %-25s | %-3s | %-6s | %-7s |\n", 
                "Applicant", "Company", "Job Posting", "Location", "Qualification", "Skills", "Set","Score", "Changes");
        System.out.println("+----------------+----------------+--------------------------------+----------------------+--------------------------------+---------------------------+-----+--------+---------+");
    }
    
    public void printReport(
        int setNo1, JobSeeker oldJobSeeker, MatchScore oldScore, int setNo2, JobSeeker newJobSeeker, MatchScore newScore, String scoreDifference
    ) {
        System.out.printf("| %-14s | %-14s | %-30s | %-20s | %-30s ", 
                
                oldJobSeeker.getName(), 
                oldScore.getJobPosting().getEmployer().getName(),
                oldScore.getJobPosting().getTitle(), 
                oldScore.getJobPosting().getEmployer().getLocation(),
                oldScore.getJobPosting().getQualification()
             );
        
        for (int i = 1; i <= oldScore.getJobPosting().getSkills().getCount(); i++) {
            if (oldScore.getJobPosting().getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d", i, oldScore.getJobPosting().getSkills().getPosition(i).getName(), oldScore.getJobPosting().getSkills().getPosition(i).getProficiency());
                System.out.printf("| %-3s | %-6d | %-7s |\n", setNo1, oldScore.getScore(), scoreDifference);
                System.out.printf("| %-14s | %-14s | %-30s | %-20s | %-30s | %-25s | %-3s | %-6d | %-7s |\n",
                                "", "", "", "", "", "", setNo2, newScore.getScore(), "");
            } else {
                System.out.printf("| (%d) %-19s %-2d", i, oldScore.getJobPosting().getSkills().getPosition(i).getName(), oldScore.getJobPosting().getSkills().getPosition(i).getProficiency());
                switch (i) {
                    case 1:
                        System.out.printf("| %-3s | %-6d | %-7s |\n", setNo1, oldScore.getScore(), scoreDifference);
                        break;
                    case 2:
                        System.out.printf("| %-3s | %-6d | %-7s |\n", setNo2, newScore.getScore(), "");
                        break;
                    default:
                        System.out.printf("| %-3s | %-6s | %-7s |\n", "","", "");
                        break;
                }

                if (i < oldScore.getJobPosting().getSkills().getCount()) {
                    System.out.printf("| %-14s | %-14s | %-30s | %-20s | %-30s ",
                            "", "", "", "", "", "", "");
                }
            }
        }

        System.out.println("+----------------+----------------+--------------------------------+----------------------+--------------------------------+---------------------------+-----+--------+---------+");
    }

    public void printReportFooter() {
        System.out.println("| End of Report                                                    |");
        System.out.println("+------------------------------------------------------------------+");
    }
    
    public void displayDiscrepancyChart(DoublyLinkedListInterface<Discrepancy> discrepancyList) {
        System.out.println("| DISCREPANCY DISTRIBUTION |");
        System.out.println("+-----------------------+");
        System.out.println("| Set # | Count | Graph |");
        System.out.println("+-------+-------+-------+");

        int maxSet = 0, maxValue = 0;
        for (int i = 1; i <= discrepancyList.getCount(); i++) {
            Discrepancy discrepancy = discrepancyList.getPosition(i);

            if (discrepancyList.getPosition(i).getAmount() > maxValue) {
                maxValue = discrepancyList.getPosition(i).getAmount();
                maxSet = discrepancyList.getPosition(i).getSetNo();
            }
            
            System.out.printf("| %-5d | %-5d | ",
                discrepancy.getSetNo(),
                discrepancy.getAmount());
            for (int j = 1; j <= discrepancy.getAmount(); j++) {
                 System.out.printf("[]");
            }
            System.out.printf(" |\n");
        }
        
        System.out.printf("Highest discrepancies: %d (Set %d)\n", maxValue, maxSet);
        System.out.println("+-----------------------+");
    }
    
    public void displayJobSeeker(JobSeeker jobSeeker) {
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                         Applicant Details                                              |");
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-14s | %-14s | %-40s | %-25s |\n", "No", "Applicant", "Location", "Qualification", "Skills");
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-14s ", jobSeeker.getName());
        System.out.printf("| %-14s ", jobSeeker.getLocation());
        System.out.printf("| %-40s ", jobSeeker.getQualification());
        for (int i = 1; i <= jobSeeker.getSkills().getCount(); i++) {
            if (jobSeeker.getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobSeeker.getSkills().getPosition(i).getName(), jobSeeker.getSkills().getPosition(i).getProficiency());
            } else {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobSeeker.getSkills().getPosition(i).getName(), jobSeeker.getSkills().getPosition(i).getProficiency());
                if (i < jobSeeker.getSkills().getCount()) {
                    System.out.printf("| %-14s | %-14s | %-40s ",
                            "", "", "", "");
                }
            }
        }
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
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
    
    public int applicationMenu() {
        while (true) {
            System.out.print("\nWould you like to"
                    + "\n1. Apply for a job"
                    + "\n2. Filter location and score"
                    + "\n3. Return"
                    + "\nEnter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        return choice;
                    case 2:
                        return choice;
                    case 3:
                        return choice;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter 1, 2 or 3.");
                scanner.nextLine(); 
            }
        }
    }
    
    public String askLocation() {
        System.out.print("Enter location to filter: ");
        String location = scanner.nextLine();
        return location;
    }
    
    public int askScore() {
        System.out.print("Enter minimum score to filter: ");
        int score = scanner.nextInt();
        scanner.nextLine();
        return score;
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
