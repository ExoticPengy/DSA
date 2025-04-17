/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
import entity.JobSeeker;
import java.util.InputMismatchException;
import java.util.Scanner;
import utility.MessageUI;
import control.ApplicantManagement;

/**
 *
 * @author chienxing
 */


public class JobSeekerUI {
    private Scanner scanner = new Scanner(System.in);
    private ApplicantManagement applicantManagement;

    public void setApplicantManagement(ApplicantManagement applicantManagement) {
        this.applicantManagement = applicantManagement;
    }
    
     public int displayMenu() {
        if (applicantManagement == null) {
            System.out.println("ApplicantManagement not initialized");
            return -1;
        }
        while (true) {
            System.out.println("\n+----------------------------+");
            System.out.println("|      Job Seeker Menu       |");
            System.out.println("+----------------------------+");
            System.out.println("| 1. Create Job Seeker       |");
            System.out.println("| 2. Update Job Seeker       |");
            System.out.println("| 3. Remove Job Seeker       |");
            System.out.println("| 4. View Job Seeker         |");
            System.out.println("| 5. View Report             |");
            System.out.println("| 6. Back                    |");
            System.out.println("+----------------------------+");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            

            switch (choice) {
                case 1:
                    applicantManagement.createNewJobSeeker();
                    break;
                case 2:
                    applicantManagement.updateJobSeeker();
                    break;
                case 3:
                    applicantManagement.removeJobSeeker();
                    break;
                case 4:
                    applicantManagement.viewAllJobs();
                    break;
                case 5:
                    applicantManagement.jobSeekerReport();
                    break;
                case 6:
                    System.out.println("Returning....");
                    return choice;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }    

    public void noJobSeeker(){
        System.out.println("No job seeker found.");
    }
    
    public void invalidChoice(){
        System.out.println("Invalid input! Please enter a valid number.");
    }
    
    public void displayCreateJobsHead() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                              Newly Created Job Seekers                                                               |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-14s | %-4s | %-4s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    
    public void displayViewJobSeekerHead() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                               View Your Job Seekers                                                                  |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-14s | %-4s | %-4s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    
    public void displaySelectedJobsHead() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                Selected Job Seekers                                                                 |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-14s | %-4s | %-4s | %-30s | %-14s | %-30s | %-25s |\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    
    public void displaySortJobsHead() {
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                                                 Sorted Job Seekers                                                                  |");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-14s | %-4s | %-4s | %-30s | %-14s | %-30s | %-25s |\n\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    
    public void displayListJobsHead() {
        System.out.println("\n+-------------------------------------------+");
        System.out.println("|            List of Job Seekers           |");
        System.out.println("+-------------------------------------------+");
    }
        
    public void displayJobsNumber(int jobNumber, JobSeeker job) {
        System.out.println(jobNumber + ". " + job.getName());
    }
    
    public void displayViewJobSeekerFoot() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public void continueKey(){
        MessageUI.pressEnterContinue();
        scanner.nextLine(); 
    }
    
    public void viewJobSeeker(JobSeeker jobSeeker, int index) {
        
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2d ", index);
        System.out.printf("| %-14s ", jobSeeker.getName());
        System.out.printf("| %-4s ", jobSeeker.getAge());
        System.out.printf("| %-4s ", jobSeeker.getGender());        
        System.out.printf("| %-14s ", jobSeeker.getEmail());        
        System.out.printf("| %-14s ", jobSeeker.getLocation());
        System.out.printf("| %-14s ", jobSeeker.getQualification());        
            
        for (int i = 1; i <= jobSeeker.getSkills().getCount(); i++) {
            if (jobSeeker.getSkills().getCount() == 1) {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobSeeker.getSkills().getPosition(i).getName(), jobSeeker.getSkills().getPosition(i).getProficiency());
            } else {
                System.out.printf("| (%d) %-19s %-2d|\n", i, jobSeeker.getSkills().getPosition(i).getName(), jobSeeker.getSkills().getPosition(i).getProficiency());
                if (i < jobSeeker.getSkills().getCount()) {
                    System.out.printf("| %-2s | %-14s | %-14s | %-30s | %-30s | %-14s | %-30s ",
                            "", "", "", "", "", "", "");
                }
            }
        }
    }

    //Ask to repeat again
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
    
    //Add function
    public String askSkills() {
        int choice;
        while (true) {
            System.out.print("\nWhat is the skill you have?\n"
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
            System.out.print("\n Enter proficiency of chosen skill (1-10): ");

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
    
    //Creating Job Seeker
    public String addName(){
        System.out.print("\nEnter your Name: ");
        String name = scanner.nextLine();
        return name;
    }
    
    public int addAge(){
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        return age;
    }
    
    public String addGender(){
        System.out.print("Enter your gender: ");
        scanner.nextLine();
        String gender = scanner.nextLine();
        return gender;
    }
    
    public String addEmail(){
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        return email;
    }
    
    public String addLocation(){
        System.out.print("Enter your loation: ");
        String location = scanner.nextLine();
        return location;
    }
    
    public String addQualification(){
        System.out.print("Enter your academic qualification: ");
        String qualification = scanner.nextLine();
        return qualification;
    }
    
    public void skillAlreadyCreated(){
        System.out.print("\nThis skill has already been created. Please choose another skill to add. ");        
    }
    
    //Update function
    public void displayUpdatedJobSeekerHeader(){
        System.out.println("\nUpdated Job Seekers:");
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
            System.out.println("1. Name");
            System.out.println("2. Email");
            System.out.println("3. Location");
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
    
    public int selectSkillToUpdate(JobSeeker jobToUpdate){
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
        System.out.println("Job seeker update successfully!\n");
    }
    
    //Remove function
    public void successRemove(){
        System.out.println("Job seeker remove successfully!\n");
    }
    
    public void cancelRemove(){
        System.out.println("Removal cancelled.");
    }
    
    
    //Report function
    public void displayReportHeader() {
        System.out.println("\n+==================================================================+");
        System.out.println("|                     Job Seeker Summary Report                   |");
        System.out.println("+==================================================================+");
    }
    
    public void displayAddedJobsHeader(int count) {
        System.out.println("\n Recently added job seekers (" + count + ")                       ");
        System.out.println("+----+-----------------+-------------------------------------------+");
        System.out.println("| No | Name         | Email                                 |");
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayAddedJobRow(int index, String name, String email) {
        System.out.printf("| %-2d | %-15s | %-41s |\n", index, name, email);
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayRemovedJobsHeader(int count) {
        System.out.println("\n Recently removed job seekers (" + count + ")                            ");
        System.out.println("+----+-----------------+-------------------------------------------+");
        System.out.println("| No | Name         | Email                                 |");
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayRemovedJobRow(int index, String name, String email) {
        System.out.printf("| %-2d | %-15s | %-41s |\n", index, name, email);
        System.out.println("+----+-----------------+-------------------------------------------+");
    }

    public void displayNoNewAdditions() {
        System.out.println("\nNo recently added job seekers.");
        System.out.println("********************************************************************");
    }

    public void displayNoRemovals() {
        System.out.println("\nNo recently removed job seekers.");
        System.out.println("********************************************************************");
    }

    public void displaySummaryReport(int index, String name, int oldCount, int newCount, int change) {
        System.out.printf("| %-2d | %-14s   | %-9d | %-9d | %2d %-8s      |\n",
                index, name, oldCount, newCount, change, change > 0 ? "(Added)" : "(Removed)");
        System.out.println("+----+------------------+-----------+-----------+------------------+");
    }

    public void displayNoChangesSummary() {
        System.out.println("\n-No Changes Made-");
    }
    
    public void displayTotalCountReport(int totalAdded, int totalRemoved, int netChange) {
        System.out.println("____________________________________________________________________\n");
        System.out.printf(" Total Job Seeker Added: %-3d                                  \n", totalAdded);
        System.out.printf(" Total Job Seeker Removed: %-3d                                \n", totalRemoved);
        System.out.printf(" Net Change: %+2d                                              \n", netChange);
        System.out.println("____________________________________________________________________");
    }
    
    public void displaySummaryReportFooter() {
        System.out.println("\n+==============================================================+");
        System.out.println("                        End of the report                      ");
        System.out.println("+==============================================================+\n");
    }

    //Job seeker list
    public void displayJobSeekersHeader() {
        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("|                                 JobSeeker Listing                                       |");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-14s | %-14s | %-53s |\n", 
                "No", "Name", "Location", "Email");
        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void displayJobSeekers(DoublyLinkedListInterface<JobSeeker> jobSeekers) {
        for (int i = 1; i <= jobSeekers.getCount(); i++) {
            JobSeeker jobSeekerList = jobSeekers.getPosition(i);
            System.out.printf("| %-2d | %-14s | %-14s | %-53s |\n", 
                            i, 
                            jobSeekerList.getName(), 
                            jobSeekerList.getLocation(), 
                            jobSeekerList.getEmail());
            System.out.println("-----------------------------------------------------------------------------------------+");
        }
    }
}
