/**
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InternshipApplication;
import boundary.JobSeekerUI;
import dao.JobSeekerInitializer;
import entity.JobSeeker;
import entity.Skill;


 /* *
 * 
 * @author chienxing
 */
public class ApplicantManagement {
    // Data structures
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<JobSeeker> recentlyAddedJobSeekers;
    private DoublyLinkedListInterface<JobSeeker> recentlyDeletedJobSeekers;
    
    // Dependencies
    private JobSeekerInitializer jobSeekerInitializer;
    private InternshipApplication internshipApplication;
    private JobSeekerUI jobSeekerUI;
    
    // Constructor initializes all required data structures
     
    public ApplicantManagement() {
        // Initialize data structures
        jobSeekerList = new DoublyLinkedList<>();
        recentlyAddedJobSeekers = new DoublyLinkedList<>();
        recentlyDeletedJobSeekers = new DoublyLinkedList<>();
        
        // Initialize dependencies
        jobSeekerInitializer = new JobSeekerInitializer();
        internshipApplication = new InternshipApplication();
    }
    

    public void initializeApplicantManagement() {
        jobSeekerList = jobSeekerInitializer.getJobSeeker();
    }
    

    //Runs the internship application with the current job seeker list

    public void runApplicantManagement() {
        internshipApplication.studentNameMenu(jobSeekerList);
    }
    

    //Returns the current job seeker list

    public DoublyLinkedListInterface<JobSeeker> getJobSeekerList() {
        return jobSeekerList;
    }

    
     // Sets the UI component for this management class
     
    public void setJobSeekerUI(JobSeekerUI ui) {
        this.jobSeekerUI = ui;
    }
    
    
     // Main entry point for admin job seeker management
     
    public void adminJobSeeker() {
        viewAllJobSeekers();
        
        boolean continueManagement = true;
        while(continueManagement) {
            int choice = jobSeekerUI.displayMenu();
            
            switch (choice) {
                case 1:
                    createNewJobSeeker();
                    break;
                case 2:
                    updateJobSeeker();
                    break;
                case 3:
                    removeJobSeeker();
                    break;
                case 4:
                    viewAllJobSeekers();
                    break;
                case 5:
                    generateJobSeekerReport();
                    break;
                case 6:
                    System.out.println("Returning to admin menu...");
                    return;
                default:
                    jobSeekerUI.invalidChoice();
            }
        }
    }
    
    
     // Creates a new job seeker with user input
     
    public void createNewJobSeeker() {
        boolean continueCreating = true;
        
        while (continueCreating) {
            // Collect basic information
            String name = jobSeekerUI.addName();
            int age = jobSeekerUI.addAge();
            String gender = jobSeekerUI.addGender();
            String email = jobSeekerUI.addEmail();
            String location = jobSeekerUI.addLocation();
            String qualification = jobSeekerUI.addQualification();

            // Collect skills information
            DoublyLinkedListInterface<Skill> skills = collectSkills();
            
            // Create and add the job seeker
            JobSeeker newJobSeeker = new JobSeeker(name, age, gender, email, location, qualification, skills);
            addJobSeeker(newJobSeeker);
            
            // Ask if user wants to create another job seeker
            if (jobSeekerUI.askChoice("\nDo you want to add another job seeker?") == 2) {
                continueCreating = false;
            }
        }
    }
    
    
     // Helper method to collect skills from user input
     
    private DoublyLinkedListInterface<Skill> collectSkills() {
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        boolean addMoreSkills = true;
        
        while(addMoreSkills) {
            String skillName = jobSeekerUI.askSkills();
            int proficiency = jobSeekerUI.askProficiency();
            skills.insertBack(new Skill(skillName, proficiency));
            
            if (jobSeekerUI.askChoice("\nDo you want to add another skill?") == 2) {
                addMoreSkills = false;
            }
        }
        
        return skills;
    }
    
    
     // Adds a job seeker to all relevant lists and displays the result
     
    private void addJobSeeker(JobSeeker jobSeeker) {
        jobSeekerList.insertBack(jobSeeker);
        recentlyAddedJobSeekers.insertBack(jobSeeker);
        
        // Display the newly created job seeker
        jobSeekerUI.displayCreateJobsHead();
        jobSeekerUI.viewJobSeeker(jobSeeker, jobSeekerList.getCount());
        jobSeekerUI.displayViewJobSeekerFoot();
        jobSeekerUI.continueKey();
    }
    
    
     // Displays all job seekers in the system
     
    public void viewAllJobSeekers() { 
        if (jobSeekerList.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }
        
        jobSeekerUI.displayViewJobSeekerHead();
        for (int i = 1; i <= jobSeekerList.getCount(); i++) { 
            JobSeeker jobSeeker = jobSeekerList.getPosition(i);
            jobSeekerUI.viewJobSeeker(jobSeeker, i);                
        }
        jobSeekerUI.displayViewJobSeekerFoot();
    }
    
    
     // Updates an existing job seeker's information
     
    public void updateJobSeeker() {
        if (jobSeekerList.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }

        boolean continueUpdating = true;
        while (continueUpdating) {
            // Display list of job seekers
            displayJobSeekerList();
            
            // Get job seeker to update
            int choice = jobSeekerUI.updateChoice(jobSeekerList.getCount(), 
                    "\nEnter the job seeker number you want to update: ");
            JobSeeker jobSeekerToUpdate = jobSeekerList.getPosition(choice);

            // Display selected job seeker
            jobSeekerUI.displaySelectedJobsHead();
            jobSeekerUI.viewJobSeeker(jobSeekerToUpdate, 0);
            jobSeekerUI.displayViewJobSeekerFoot();

            // Get update choice and perform update
            int updateChoice = jobSeekerUI.selectToUpdate();
            updateJobSeekerField(jobSeekerToUpdate, updateChoice);

            // Update the job seeker in the list
            jobSeekerList.replacePosition(jobSeekerToUpdate, choice);
            
            // Display updated information
            jobSeekerUI.displayUpdatedJobSeekerHeader();
            viewAllJobSeekers();
            jobSeekerUI.successUpdate();
            jobSeekerUI.continueKey();

            // Ask if user wants to update another job seeker
            if (jobSeekerUI.askChoice("\nDo you want to update another job seeker?") == 2) {
                continueUpdating = false;
            }
        }
    }
    
    
     // Helper method to display the list of job seekers
     
    private void displayJobSeekerList() {
        jobSeekerUI.displayListJobsHead();
        for (int i = 1; i <= jobSeekerList.getCount(); i++) {
            JobSeeker jobSeeker = jobSeekerList.getPosition(i);
            jobSeekerUI.displayJobsNumber(i, jobSeeker);
        }
    }
    
    
     // Helper method to update a specific field of a job seeker
     
    private void updateJobSeekerField(JobSeeker jobSeeker, int updateChoice) {
        switch (updateChoice) {
            case 1:
                jobSeeker.setName(jobSeekerUI.addName());
                break;
            case 2:
                jobSeeker.setEmail(jobSeekerUI.addEmail());
                break;
            case 3:
                jobSeeker.setLocation(jobSeekerUI.addLocation());
                break;
            case 4:
                jobSeeker.setQualification(jobSeekerUI.addQualification());
                break;
            case 5:
                updateJobSeekerSkill(jobSeeker);
                break;
            default:
                jobSeekerUI.invalidChoice();
        }
    }
    
    
     // Helper method to update a job seeker's skill
     
    private void updateJobSeekerSkill(JobSeeker jobSeeker) {
        int selectSkill = jobSeekerUI.selectSkillToUpdate(jobSeeker);
        Skill selectedSkill = jobSeeker.getSkills().getPosition(selectSkill);
        int newProficiency = jobSeekerUI.proficiencyUpdate();
        selectedSkill.setProficiency(newProficiency);
    }
    
    
     // Removes a job seeker from the system
     
    public void removeJobSeeker() {
        if (jobSeekerList.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }
        
        boolean continueRemoving = true;
        while (continueRemoving) {
            // Display list of job seekers
            jobSeekerUI.displayListJobsHead();
            for (int i = 1; i <= jobSeekerList.getCount(); i++) {
                JobSeeker jobSeeker = jobSeekerList.getPosition(i);
                jobSeekerUI.displayJobsNumber(i, jobSeeker);
            }

            // Get job seeker to remove
            int choice = jobSeekerUI.updateChoice(jobSeekerList.getCount(), 
                    "\nEnter the job seeker number you want to remove: ");
            JobSeeker jobSeekerToRemove = jobSeekerList.getPosition(choice);
            
            // Display selected job seeker
            jobSeekerUI.displaySelectedJobsHead();
            jobSeekerUI.viewJobSeeker(jobSeekerToRemove, 0);
            jobSeekerUI.displayViewJobSeekerFoot();
            
            // Confirm and remove
            if (jobSeekerUI.askChoice("\nConfirm remove this job seeker?") == 1) {
                recentlyDeletedJobSeekers.insertBack(jobSeekerToRemove);
                jobSeekerList.deletePosition(choice);
                System.out.println("\nJob seeker '" + jobSeekerToRemove.getName() + "' has been removed successfully.");
                jobSeekerUI.continueKey();
            }
            
            // Ask if user wants to remove another job seeker
            if (jobSeekerUI.askChoice("\nDo you want to remove another job seeker?") == 2) {
                continueRemoving = false;
            }
        }
        
        adminJobSeeker();
    }
    
    
     // Generates a report of job seeker changes
     
    public void generateJobSeekerReport() {
        jobSeekerUI.displayReportHeader();
        
        boolean hasChanges = !recentlyAddedJobSeekers.isEmpty() || !recentlyDeletedJobSeekers.isEmpty();
        
        if (!hasChanges) {
            jobSeekerUI.displayNoChangesSummary();
            return;
        }
        
        // Display recently added job seekers
        if (!recentlyAddedJobSeekers.isEmpty()) {
            jobSeekerUI.displayAddedJobsHeader(recentlyAddedJobSeekers.getCount());
            for (int i = 1; i <= recentlyAddedJobSeekers.getCount(); i++) {
                JobSeeker jobSeeker = recentlyAddedJobSeekers.getPosition(i);
                jobSeekerUI.displayAddedJobRow(i, jobSeeker.getName(), jobSeeker.getEmail());
            }
        } else {
            jobSeekerUI.displayNoNewAdditions();
        }
        
        // Display recently deleted job seekers
        if (!recentlyDeletedJobSeekers.isEmpty()) {
            jobSeekerUI.displayRemovedJobsHeader(recentlyDeletedJobSeekers.getCount());
            for (int i = 1; i <= recentlyDeletedJobSeekers.getCount(); i++) {
                JobSeeker jobSeeker = recentlyDeletedJobSeekers.getPosition(i);
                jobSeekerUI.displayRemovedJobRow(i, jobSeeker.getName(), jobSeeker.getEmail());
            }
        } else {
            jobSeekerUI.displayNoRemovals();
        }
        
        // Display summary report
        int totalAdded = recentlyAddedJobSeekers.getCount();
        int totalRemoved = recentlyDeletedJobSeekers.getCount();
        int netChange = totalAdded - totalRemoved;
        
        jobSeekerUI.displayTotalCountReport(totalAdded, totalRemoved, netChange);
        jobSeekerUI.displaySummaryReportFooter();
    }
}
