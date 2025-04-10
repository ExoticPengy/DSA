/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import control.JobManagement;
import entity.JobPosting;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class JobPostingUI {

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("+----------------------------+");
            System.out.println("|      Job Posting Menu      |\n");
            System.out.println("+----------------------------+\n");
            System.out.println("| 1. Create Job Posting      |");
            System.out.println("| 2. Update Job Posting      |");
            System.out.println("| 3. Remove Job Posting      |");
            System.out.println("| 4. Search Jobs             |");
            System.out.println("| 5. View All Jobs           |");
            System.out.println("| 6. View Sorted Jobs        |");
            System.out.println("| 7. Report                  |");
            System.out.println("| 8. Exit                    |");
            System.out.println("+----------------------------+");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    //jobManagement.createJobPosting(); 
                    break;
                case 2:
                    //updateJobPosting();
                    break;
                case 3:
                    //removeJobPosting();
                    break;
                case 4:
                    //SearchJobs();
                    break;
                case 5:
                    //viewEmployerJobPosting();
                    break;
                case 6:
                    //jobManagement.viewSortedJobs(); 
                    break;
                case 7:
                    //jobManagement.report(); 
                    break;
                case 8:
                    System.out.println("Exiting...");
                    //jobManagement.closeScanner(); 
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }    
    public void displayCreateJobsHead() {
        System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                     Newly Created Job Postings                                                                       |");
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills");
    }
    
    public void displayViewJobPostingHead() {
        System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                     View Your Job Postings                                                                           |");
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills");
    }
    
    public void displayViewJobPostingFoot() {
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
    }
    
    public void viewJobPosting(JobPosting jobPosting, int index) {
        String shortTitle = jobPosting.getTitle().length() > 29 ?
                           jobPosting.getTitle().substring(0, 25) + "..." :
                           jobPosting.getTitle();
        
        String shortDesc = jobPosting.getDescription().length() > 29 ? 
                       jobPosting.getDescription().substring(0, 25) + "..." : 
                       jobPosting.getDescription();
        
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
        System.out.printf("| %-2d ", index);
        System.out.printf("| %-14s ", jobPosting.getEmployer().getName());
        System.out.printf("| %-14s ", jobPosting.getEmployer().getLocation());
        System.out.printf("| %-30s ", shortTitle);
        System.out.printf("| %-30s ", shortDesc);
        System.out.printf("| %-14s ", jobPosting.getSalaryRange());
        System.out.printf("| %-30s ", jobPosting.getQualification());
            
        for (int i = 1; i <= jobPosting.getSkills().getCount(); i++) {
            if (jobPosting.getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobPosting.getSkills().getPosition(i).getName(), jobPosting.getSkills().getPosition(i).getProficiency());
            } else {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobPosting.getSkills().getPosition(i).getName(), jobPosting.getSkills().getPosition(i).getProficiency());
                if (i < jobPosting.getSkills().getCount()) {
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
    
    public String askSkills() {
        int choice;
        while (true) {
            System.out.print("\nWhat is the skill required?\n"
                    + "1. Communication \n2. Leadership \n3. Programming \n4. Analysis\n"
                    + "Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        return "Communication";
                    case 2:
                        return "Leadership";
                    case 3:
                        return "Programming";
                    case 4:
                        return "Analysis";
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1-4.");
                scanner.nextLine();
            }
        }
    }
    
    public int askProficiency() {
        int proficiency = 0;
        while (true) {
            System.out.print("\n *Enter proficiency of chosen skill (1-10): ");

            try {
                proficiency = scanner.nextInt();
                scanner.nextLine();
                if (proficiency >= 1 && proficiency <= 10) {
                    return proficiency;
                } else {
                    System.out.println("Invalid input, please enter a number between 1-10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); 
            }
        }
    }
    
    //Create Job Posting
    public String addTitle(){
        System.out.print("\nEnter Job Title: ");
        String title = scanner.nextLine();
        return title;
    }
    
    public String addDescription(){
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine();
        return description;
    }
    
    public String addSalaryRange(){
        System.out.print("Enter Salary Range: ");
        String salaryRange = scanner.nextLine();
        return salaryRange;
    }
    
    public String addQualification(){
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();
        return qualification;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

