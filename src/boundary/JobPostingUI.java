/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
import entity.Employer;
import entity.JobPosting;
import java.util.InputMismatchException;
import java.util.Scanner;
import utility.MessageUI;

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
            System.out.println("| 5. View Job Post           |");
            System.out.println("| 6. View Sorted Jobs        |");
            System.out.println("| 7. Report                  |");
            System.out.println("| 8. Exit                    |");
            System.out.println("+----------------------------+");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    //jobManagement.createJobPosting(employer); 
                    break;
                case 2:
                    //jobManagement.updateJobPosting(employer);
                    break;
                case 3:
                    //jobManagement.removeJobPosting(employer);
                    break;
                case 4:
                    //jobManagement.SearchJobs();
                    break;
                case 5:
                    //jobManagement.viewEmployerJobPosting(employer);
                    break;
                case 6:
                    //jobManagement.viewSortedJobs(employer); 
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
    
    public void noJobPosting(){
        System.out.println("No job postings found.");
    }
    
    public void invalidChoice(){
        System.out.println("Invalid input! Please enter a valid number.");
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
    
    public void displaySelectedJobsHead() {
        System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                     Selected Job Postings                                                                            |");
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills");
    }
    
    public void displaySortJobsHead() {
        System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                      Sorted Job Postings                                                                             |");
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills");
    }
    
    public void displayListJobsHead() {
        System.out.println("\n+-------------------------------------------+");
        System.out.println("|            List of Job Postings           |");
        System.out.println("+-------------------------------------------+");
    }
    
    public void displaySearchResultsHead() {
        System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                         Search Result                                                                                |");
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Company", "Location", "Title", "Description", "Salary Range", "Qualification", "Skills");
    }
    
    public void displayJobsNumber(int jobNumber, JobPosting job) {
        System.out.println(jobNumber + ". " + job.getTitle());
    }
    
    public void displayViewJobPostingFoot() {
        System.out.println("+----+----------------+----------------+--------------------------------+--------------------------------+----------------+--------------------------------+---------------------------+");
    }
    
    public void continueKey(){
        MessageUI.pressAnyKeyContinue();
        scanner.nextLine(); 
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

    //ask to repeat again
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
    

    //add function
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
    
    //Creating Job Posting
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
    
    public void skillAlreadyCreated(){
        System.out.print("\nThis skill has already been created. Please choose another skill to add. ");        
    }
    
    //update function
    public void newUpdateJobTitle(){
        System.out.println("\nUpdated Job Postings:");
    }
    
    public int updateChoice(int jobNumber, String question){
        int choice = 0;
        while (true) {
                System.out.print(question);
                choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice >= 1 && choice <= jobNumber) {
                    return choice;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                }  
            }
    }
    
    public int selectToUpdate(){
        int updateChoice = 0;
            
        while (true) {
            System.out.println("\nWhat would you like to update?");
            System.out.println("1. Title");
            System.out.println("2. Description");
            System.out.println("3. Salary Range");
            System.out.println("4. Qualification");
            System.out.println("5. Skills");
            System.out.print("\nEnter your choice: ");
            updateChoice = scanner.nextInt();
            scanner.nextLine(); 

            if(updateChoice >= 1&& updateChoice <= 5) {
                return updateChoice;
            } else {
                System.out.print("Invalid input! Please enter number 1-5.\n");
            }
        }
    }
    
    public int selectSkillToUpdate(JobPosting jobToUpdate){
        System.out.print("\nChoose a skill to update: \n");
        for (int j = 1; j <= jobToUpdate.getSkills().getCount(); j++) {
            System.out.println(j + ". " + jobToUpdate.getSkills().getPosition(j).getName()
                    + ": " + jobToUpdate.getSkills().getPosition(j).getProficiency());
        }
        
        int selectSkill = 0;
        while (true) {
            System.out.print("\nEnter the skill number you want to update: ");
            selectSkill = scanner.nextInt();
            scanner.nextLine();

                if(selectSkill >= 1 && selectSkill <= jobToUpdate.getSkills().getCount()) {
                    return selectSkill;
                } else {
                    System.out.print("Invalid input! Please enter a valid number.\n");
                }
        }
    }
    
    public int proficiencyUpdate(){
        int newProficiency = 0;
        while (true) {
            System.out.print("Enter new proficiency(1-10): ");
            newProficiency = scanner.nextInt();
            scanner.nextLine();

            if(newProficiency >= 1 && newProficiency <= 10) {
                return newProficiency;
            } else {
                System.out.print("Invalid input. Please enter a valid number.\n");
            }
        }
    }
    
    public void successUpdate(){
        System.out.println("Job posting update successfully!\n");
    }
    
    //remove function
    public void successRemove(){
        System.out.println("Job posting remove successfully!\n");
    }
    
    public void cancelRemove(){
        System.out.println("Removal cancelled.");
    }
    
    //sort function
    public void successSort(){
        System.out.println("Job postings are successfully sorted!\n");
    }
    
    //search function
    public String searchEmployer(){
        System.out.print("Enter an employer name to search: ");
        String searchEmployerName = scanner.nextLine();
        return searchEmployerName;
    }
    
    public String searchSkill() {
        int choice;
        while (true) {
            System.out.print("\nWhich skill you would like to search?\n"
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
    
    //report function
    public void displayReportHeader() {
        System.out.println("\n+==================================================================+");
        System.out.println("|                     JOB POSTING SUMMARY REPORT                   |");
        System.out.println("+==================================================================+");
    }
    
    public void displayAddedJobsHeader(int count) {
        System.out.println("\n NEWLY ADDED JOB POSTINGS (" + count + ")                       ");
        System.out.println("+----+-----------------+-------------------------------------------+");
        System.out.println("| No | Company         | Job Title                                 |");
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayAddedJobRow(int index, String company, String title) {
        System.out.printf("| %-2d | %-15s | %-41s |\n", index, company, title);
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayRemovedJobsHeader(int count) {
        System.out.println("\n RECENTLY REMOVED JOB POSTINGS (" + count + ")                            ");
        System.out.println("+----+-----------------+-------------------------------------------+");
        System.out.println("| No | Company         | Job Title                                 |");
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayRemovedJobRow(int index, String company, String title) {
        System.out.printf("| %-2d | %-15s | %-41s |\n", index, company, title);
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayNoNewAdditions() {
        System.out.println("\nNo newly added job postings.");
        System.out.println("********************************************************************");
    }

    public void displayNoRemovals() {
        System.out.println("\nNo recently removed job postings.");
        System.out.println("********************************************************************");
    }

    public void displaySummaryReportHeader() {
        System.out.println("\n*JOB POSTING COMPARING*                 ");
        System.out.println("+----+------------------+-----------+-----------+------------------+");
        System.out.println("| No | Company          | Old Count | New Count | Change (+/-)     |");
        System.out.println("+----+------------------+-----------+-----------+------------------+");
    }

    public void displaySummaryReport(int index, String company, int oldCount, int newCount, int change) {
        System.out.printf("| %-2d | %-14s   | %-9d | %-9d | %2d %-8s     |\n",
                index, company, oldCount, newCount, change, change > 0 ? "(Added)" : "(Removed)");
        System.out.println("+----+------------------+-----------+-----------+------------------+\n");
    }

    public void displayNoChangesSummary() {
        System.out.println("\n-NO CHANGES MADE IN JOB POSTINGS-");
    }
    
    public void displayTotalCountReport(int totalAdded, int totalRemoved, int netChange) {
        System.out.println("____________________________________________________________________\n");
        System.out.printf(" Total Job Posting Added: %-3d                                  \n", totalAdded);
        System.out.printf(" Total Job Posting Removed: %-3d                                \n", totalRemoved);
        System.out.printf(" Net Change: %+2d                                              \n", netChange);
        System.out.println("____________________________________________________________________");
    }
    
    public void displaySummaryReportFooter() {
        System.out.println("\n+------------------------------------------------------------------+");
        System.out.println("                          End of the report                        ");
        System.out.println("+==================================================================+\n");
    }

    //employer list
    public void displayEmployersHeader() {
        System.out.println("\n+----------------------------------------------------------------------------------------------+");
        System.out.println("|                                      Employer Listing                                        |");
        System.out.println("+----+----------------+----------------+-------------------------------------------------------+");
        System.out.printf("| %-2s | %-14s | %-14s | %-53s |\n", 
                "No", "Company", "Location", "Email");
        System.out.println("+----+----------------+----------------+-------------------------------------------------------+");
    }

    public void displayEmployers(DoublyLinkedListInterface<Employer> employers) {
        for (int i = 1; i <= employers.getCount(); i++) {
            Employer employer = employers.getPosition(i);
            System.out.printf("| %-2d | %-14s | %-14s | %-53s |\n", 
                            i, 
                            employer.getName(), 
                            employer.getLocation(), 
                            employer.getEmail());
            System.out.println("+----+----------------+----------------+-------------------------------------------------------+");
        }
    }
    
}