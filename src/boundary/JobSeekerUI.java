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
    
    // UI Constants for consistent formatting
    private static final String HORIZONTAL_LINE = "═";
    private static final String VERTICAL_LINE = "║";
    private static final String TOP_LEFT_CORNER = "╔";
    private static final String TOP_RIGHT_CORNER = "╗";
    private static final String BOTTOM_LEFT_CORNER = "╚";
    private static final String BOTTOM_RIGHT_CORNER = "╝";
    private static final String T_LEFT = "╠";
    private static final String T_RIGHT = "╣";
    private static final String T_TOP = "╦";
    private static final String T_BOTTOM = "╩";
    private static final String CROSS = "╬";

    public void setApplicantManagement(ApplicantManagement applicantManagement) {
        this.applicantManagement = applicantManagement;
    }
    

    public int displayMenu() {
        if (applicantManagement == null) {
            System.out.println("ApplicantManagement not initialized");
            return -1;
        }
        
        while (true) {
            // Create a more visually appealing menu
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(30) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText("JOB SEEKER MANAGEMENT", 30) + VERTICAL_LINE);
            System.out.println(T_LEFT + createHorizontalLine(30) + T_RIGHT);
            System.out.println(VERTICAL_LINE + " 1. Create Job Seeker Profile    " + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 2. Update Job Seeker Profile    " + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 3. Remove Job Seeker Profile    " + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 4. View All Job Seekers         " + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 5. View Activity Report         " + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 6. Return to Main Menu          " + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(30) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice >= 1 && choice <= 6) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
    }    


    public void noJobSeeker() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("NO JOB SEEKERS FOUND", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
    }
    

    public void invalidChoice() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("INVALID INPUT", 40) + VERTICAL_LINE);
        System.out.println(VERTICAL_LINE + centerText("Please enter a valid number", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displayCreateJobsHead() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(100) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("NEWLY CREATED JOB SEEKER PROFILES", 100) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(100) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-15s | %-5s | %-6s | %-25s | %-15s | %-25s | %-15s " + VERTICAL_LINE + "\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    

    public void displayViewJobSeekerHead() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(100) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("JOB SEEKER PROFILES", 100) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(100) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-15s | %-5s | %-6s | %-25s | %-15s | %-25s | %-15s " + VERTICAL_LINE + "\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    

    public void displaySelectedJobsHead() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(100) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("SELECTED JOB SEEKER PROFILE", 100) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(100) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-15s | %-5s | %-6s | %-25s | %-15s | %-25s | %-15s " + VERTICAL_LINE + "\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    

    public void displaySortJobsHead() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(100) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("SORTED JOB SEEKER PROFILES", 100) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(100) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-15s | %-5s | %-6s | %-25s | %-15s | %-25s | %-15s " + VERTICAL_LINE + "\n",
                "No", "Name", "Age", "Gender", "Email", "Location", "Qualification", "Skills");
    }
    

    public void displayListJobsHead() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("LIST OF JOB SEEKERS", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
    }
        

    public void displayJobsNumber(int jobNumber, JobSeeker job) {
        System.out.println(jobNumber + ". " + job.getName());
    }
    

    public void displayViewJobSeekerFoot() {
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(100) + BOTTOM_RIGHT_CORNER);
    }
    

    public void continueKey() {
        MessageUI.pressEnterContinue();
        scanner.nextLine(); 
    }

    public void viewJobSeeker(JobSeeker jobSeeker, int index) {
        // Format email to fit in the column
        String email = jobSeeker.getEmail();
        if (email.length() > 25) {
            email = email.substring(0, 22) + "...";
        }
        
        // Format location to fit in the column
        String location = jobSeeker.getLocation();
        if (location.length() > 15) {
            location = location.substring(0, 12) + "...";
        }
        
        // Format qualification to fit in the column
        String qualification = jobSeeker.getQualification();
        if (qualification.length() > 25) {
            qualification = qualification.substring(0, 22) + "...";
        }
        
        // Display the job seeker's basic information
        System.out.println(T_LEFT + createHorizontalLine(100) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3d | %-15s | %-5d | %-6s | %-25s | %-15s | %-25s | ",
                index, jobSeeker.getName(), jobSeeker.getAge(), jobSeeker.getGender(), 
                email, location, qualification);
        
        // Display skills information
        if (jobSeeker.getSkills().getCount() > 0) {
            System.out.printf("%-15s ", jobSeeker.getSkills().getPosition(1).getName() + 
                    "(" + jobSeeker.getSkills().getPosition(1).getProficiency() + ")");
        } else {
            System.out.printf("%-15s ", "None");
        }
        System.out.println(VERTICAL_LINE);
        
        // Display additional skills if any
        for (int i = 2; i <= jobSeeker.getSkills().getCount(); i++) {
            System.out.printf(VERTICAL_LINE + " %-3s | %-15s | %-5s | %-6s | %-25s | %-15s | %-25s | %-15s " + VERTICAL_LINE + "\n",
                    "", "", "", "", "", "", "", 
                    jobSeeker.getSkills().getPosition(i).getName() + 
                    "(" + jobSeeker.getSkills().getPosition(i).getProficiency() + ")");
        }
    }


    public int askChoice(String question) {
        while (true) {
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText(question, 40) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 1. Yes" + createSpaces(35) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 2. No" + createSpaces(36) + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
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
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText("SELECT A SKILL", 40) + VERTICAL_LINE);
            System.out.println(T_LEFT + createHorizontalLine(40) + T_RIGHT);
            System.out.println(VERTICAL_LINE + " 1. Communication" + createSpaces(26) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 2. Leadership" + createSpaces(28) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 3. Programming" + createSpaces(27) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 4. Analysis" + createSpaces(30) + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter your choice: ");

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
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText("ENTER PROFICIENCY LEVEL", 40) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + centerText("(1-10, where 10 is highest)", 40) + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter proficiency level: ");

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
    

    public String addName() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("ENTER JOB SEEKER NAME", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        return name;
    }
    

    public int addAge() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("ENTER JOB SEEKER AGE", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return age;
    }
    

    public String addGender() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("ENTER JOB SEEKER GENDER", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        return gender;
    }
    

    public String addEmail() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("ENTER JOB SEEKER EMAIL", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        return email;
    }
    

    public String addLocation() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("ENTER JOB SEEKER LOCATION", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
        System.out.print("Location: ");
        String location = scanner.nextLine();
        return location;
    }
    

    public String addQualification() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("ENTER JOB SEEKER QUALIFICATION", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
        System.out.print("Qualification: ");
        String qualification = scanner.nextLine();
        return qualification;
    }
    

    public void skillAlreadyCreated() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("SKILL ALREADY EXISTS", 50) + VERTICAL_LINE);
        System.out.println(VERTICAL_LINE + centerText("Please choose another skill", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displayUpdatedJobSeekerHeader() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("JOB SEEKER PROFILE UPDATED", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public int updateChoice(int jobNumber, String question) {
        int choice = 0;
        while (true) {
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText(question, 50) + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter job seeker number: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                
                if (choice >= 1 && choice <= jobNumber) {
                    return choice;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    

    public int selectToUpdate() {
        int updateChoice = 0;
            
        while (true) {
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText("SELECT FIELD TO UPDATE", 40) + VERTICAL_LINE);
            System.out.println(T_LEFT + createHorizontalLine(40) + T_RIGHT);
            System.out.println(VERTICAL_LINE + " 1. Name" + createSpaces(35) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 2. Email" + createSpaces(35) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 3. Location" + createSpaces(33) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 4. Qualification" + createSpaces(27) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + " 5. Skills" + createSpaces(35) + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter your choice: ");
            
            try {
                updateChoice = scanner.nextInt();
                scanner.nextLine();
                
                if (updateChoice >= 1 && updateChoice <= 5) {
                    return updateChoice;
                } else {
                    System.out.println("Invalid input! Please enter number 1-5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    

    public int selectSkillToUpdate(JobSeeker jobToUpdate) {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("SELECT SKILL TO UPDATE", 50) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(50) + T_RIGHT);
        
        for (int j = 1; j <= jobToUpdate.getSkills().getCount(); j++) {
            System.out.printf(VERTICAL_LINE + " %d. %-20s (Proficiency: %d)" + createSpaces(50 - 25 - String.valueOf(j).length()) + VERTICAL_LINE + "\n", 
                    j, jobToUpdate.getSkills().getPosition(j).getName(), 
                    jobToUpdate.getSkills().getPosition(j).getProficiency());
        }
        
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
        
        int selectSkill = 0;
        while (true) {
            System.out.print("Enter the skill number you want to update: ");
            
            try {
                selectSkill = scanner.nextInt();
                scanner.nextLine();
                
                if (selectSkill >= 1 && selectSkill <= jobToUpdate.getSkills().getCount()) {
                    return selectSkill;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    

    public int proficiencyUpdate() {
        int newProficiency = 0;
        while (true) {
            System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
            System.out.println(VERTICAL_LINE + centerText("ENTER NEW PROFICIENCY LEVEL", 40) + VERTICAL_LINE);
            System.out.println(VERTICAL_LINE + centerText("(1-10, where 10 is highest)", 40) + VERTICAL_LINE);
            System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
            System.out.print("Enter new proficiency level: ");
            
            try {
                newProficiency = scanner.nextInt();
                scanner.nextLine();
                
                if (newProficiency >= 1 && newProficiency <= 10) {
                    return newProficiency;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1-10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
    

    public void successUpdate() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("JOB SEEKER PROFILE UPDATED SUCCESSFULLY", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void successRemove() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("JOB SEEKER PROFILE REMOVED SUCCESSFULLY", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void cancelRemove() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("REMOVAL CANCELLED", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displayReportHeader() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(70) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("JOB SEEKER ACTIVITY REPORT", 70) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(70) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displayAddedJobsHeader(int count) {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(60) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("RECENTLY ADDED JOB SEEKERS (" + count + ")", 60) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(60) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-20s | %-30s " + VERTICAL_LINE + "\n", 
                "No", "Name", "Email");
    }
    

    public void displayAddedJobRow(int index, String name, String email) {
        System.out.printf(VERTICAL_LINE + " %-3d | %-20s | %-30s " + VERTICAL_LINE + "\n", 
                index, name, email);
        System.out.println(T_LEFT + createHorizontalLine(60) + T_RIGHT);
    }
    

    public void displayRemovedJobsHeader(int count) {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(60) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("RECENTLY REMOVED JOB SEEKERS (" + count + ")", 60) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(60) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-20s | %-30s " + VERTICAL_LINE + "\n", 
                "No", "Name", "Email");
    }
    

    public void displayRemovedJobRow(int index, String name, String email) {
        System.out.printf(VERTICAL_LINE + " %-3d | %-20s | %-30s " + VERTICAL_LINE + "\n", 
                index, name, email);
        System.out.println(T_LEFT + createHorizontalLine(60) + T_RIGHT);
    }
    

    public void displayNoNewAdditions() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("NO RECENTLY ADDED JOB SEEKERS", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displayNoRemovals() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("NO RECENTLY REMOVED JOB SEEKERS", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displaySummaryReport(int index, String name, int oldCount, int newCount, int change) {
        System.out.printf(VERTICAL_LINE + " %-3d | %-20s | %-9d | %-9d | %+2d %-8s " + VERTICAL_LINE + "\n",
                index, name, oldCount, newCount, change, change > 0 ? "(Added)" : "(Removed)");
        System.out.println(T_LEFT + createHorizontalLine(60) + T_RIGHT);
    }
    

    public void displayNoChangesSummary() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(40) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("NO CHANGES MADE", 40) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(40) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displayTotalCountReport(int totalAdded, int totalRemoved, int netChange) {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("SUMMARY STATISTICS", 50) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(50) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " Total Job Seekers Added: %-3d" + createSpaces(50 - 25 - String.valueOf(totalAdded).length()) + VERTICAL_LINE + "\n", totalAdded);
        System.out.printf(VERTICAL_LINE + " Total Job Seekers Removed: %-3d" + createSpaces(50 - 28 - String.valueOf(totalRemoved).length()) + VERTICAL_LINE + "\n", totalRemoved);
        System.out.printf(VERTICAL_LINE + " Net Change: %+2d" + createSpaces(50 - 13 - String.valueOf(netChange).length()) + VERTICAL_LINE + "\n", netChange);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }
    

    public void displaySummaryReportFooter() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(50) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("END OF REPORT", 50) + VERTICAL_LINE);
        System.out.println(BOTTOM_LEFT_CORNER + createHorizontalLine(50) + BOTTOM_RIGHT_CORNER);
    }

    public void displayJobSeekersHeader() {
        System.out.println("\n" + TOP_LEFT_CORNER + createHorizontalLine(70) + TOP_RIGHT_CORNER);
        System.out.println(VERTICAL_LINE + centerText("JOB SEEKER LISTING", 70) + VERTICAL_LINE);
        System.out.println(T_LEFT + createHorizontalLine(70) + T_RIGHT);
        System.out.printf(VERTICAL_LINE + " %-3s | %-15s | %-15s | %-30s " + VERTICAL_LINE + "\n", 
                "No", "Name", "Location", "Email");
    }
    

    public void displayJobSeekers(DoublyLinkedListInterface<JobSeeker> jobSeekers) {
        for (int i = 1; i <= jobSeekers.getCount(); i++) {
            JobSeeker jobSeekerList = jobSeekers.getPosition(i);
            System.out.printf(VERTICAL_LINE + " %-3d | %-15s | %-15s | %-30s " + VERTICAL_LINE + "\n", 
                            i, 
                            jobSeekerList.getName(), 
                            jobSeekerList.getLocation(), 
                            jobSeekerList.getEmail());
            System.out.println(T_LEFT + createHorizontalLine(70) + T_RIGHT);
        }
    }
    

    private String createHorizontalLine(int length) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < length; i++) {
            line.append(HORIZONTAL_LINE);
        }
        return line.toString();
    }
    

    private String createSpaces(int length) {
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < length; i++) {
            spaces.append(" ");
        }
        return spaces.toString();
    }
    

    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return createSpaces(padding) + text + createSpaces(width - text.length() - padding);
    }
}
