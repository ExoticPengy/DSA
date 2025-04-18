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
        
        // Main management loop
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
    
    
     // Creates a new job seeker
    public void createNewJobSeeker() {
        boolean continueCreating = true;
        
        while (continueCreating) {
            String name = jobSeekerUI.addName();
            int age = jobSeekerUI.addAge();
            String gender = jobSeekerUI.addGender();
            String email = jobSeekerUI.addEmail();
            String location = jobSeekerUI.addLocation();
            String qualification = jobSeekerUI.addQualification();

            DoublyLinkedListInterface<Skill> skills = collectSkills();
            
            // Create the job seeker
            JobSeeker newJobSeeker = new JobSeeker(name, age, gender, email, location, qualification, skills);
            
            // Insert at the beginning of the list
            jobSeekerList.insertFront(newJobSeeker);
            recentlyAddedJobSeekers.insertFront(newJobSeeker);
            
            // Display the newly created job seeker
            // Always show as position 1 since we insert at front
            jobSeekerUI.displayCreateJobsHead();
            jobSeekerUI.viewJobSeeker(newJobSeeker, 1); 
            jobSeekerUI.displayViewJobSeekerFoot();
            jobSeekerUI.continueKey();
            
            // Ask if user wants to create another job seeker
            if (jobSeekerUI.askChoice("\nDo you want to add another job seeker?") == 2) {
                continueCreating = false;
            }
        }
    }
    
    
     // Collect skills from user input
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
    
    
     // Adds a job seeker to lists and displays result    
    private void addJobSeeker(JobSeeker jobSeeker) {
        jobSeekerList.insertBack(jobSeeker);
        recentlyAddedJobSeekers.insertBack(jobSeeker);
        
        // Display the newly created job seeker
        jobSeekerUI.displayCreateJobsHead();
        jobSeekerUI.viewJobSeeker(jobSeeker, jobSeekerList.getCount());
        jobSeekerUI.displayViewJobSeekerFoot();
        jobSeekerUI.continueKey();
    }
    

     // Displays all job seekers
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
            
            // Get the job seeker at the selected position
            JobSeeker oldJobSeeker = jobSeekerList.getPosition(choice);
            
            // Display selected job seeker
            jobSeekerUI.displaySelectedJobsHead();
            jobSeekerUI.viewJobSeeker(oldJobSeeker, choice);
            jobSeekerUI.displayViewJobSeekerFoot();
            
            // Get update choice
            int updateChoice = jobSeekerUI.selectToUpdate();
            
            // Create a new job seeker with the same information
            JobSeeker updatedJobSeeker = new JobSeeker(
                oldJobSeeker.getName(),
                oldJobSeeker.getAge(),
                oldJobSeeker.getGender(),
                oldJobSeeker.getEmail(),
                oldJobSeeker.getLocation(),
                oldJobSeeker.getQualification(),
                oldJobSeeker.getSkills()
            );
            
            // Update the specific field based on user choice
            switch (updateChoice) {
                case 1:
                    updatedJobSeeker.setName(jobSeekerUI.addName());
                    break;
                case 2:
                    updatedJobSeeker.setEmail(jobSeekerUI.addEmail());
                    break;
                case 3:
                    updatedJobSeeker.setLocation(jobSeekerUI.addLocation());
                    break;
                case 4:
                    updatedJobSeeker.setQualification(jobSeekerUI.addQualification());
                    break;
                case 5:
                    // Update the existing skills list
                    int selectSkill = jobSeekerUI.selectSkillToUpdate(updatedJobSeeker);
                    Skill selectedSkill = updatedJobSeeker.getSkills().getPosition(selectSkill);
                    int newProficiency = jobSeekerUI.proficiencyUpdate();
                    selectedSkill.setProficiency(newProficiency);
                    break;
                default:
                    jobSeekerUI.invalidChoice();
            }
            
            // Replace the old job seeker with the updated one
            jobSeekerList.replacePosition(updatedJobSeeker, choice);
            
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
    

    //Method to display the list of job seekers
    private void displayJobSeekerList() {
        jobSeekerUI.displayListJobsHead();
        for (int i = 1; i <= jobSeekerList.getCount(); i++) {
            JobSeeker jobSeeker = jobSeekerList.getPosition(i);
            jobSeekerUI.displayJobsNumber(i, jobSeeker);
        }
    }
    

    //Removes a job seeker
    //Creating a copy before removing
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
                // Create a copy of the job seeker before removing
                JobSeeker removedJobSeeker = new JobSeeker(
                    jobSeekerToRemove.getName(),
                    jobSeekerToRemove.getAge(),
                    jobSeekerToRemove.getGender(),
                    jobSeekerToRemove.getEmail(),
                    jobSeekerToRemove.getLocation(),
                    jobSeekerToRemove.getQualification(),
                    jobSeekerToRemove.getSkills()
                );
                
                // Add to recently deleted list
                recentlyDeletedJobSeekers.insertFront(removedJobSeeker);
                
                // Remove from main list
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
        
        // Create new lists for sorted job seekers
        DoublyLinkedListInterface<JobSeeker> sortedAddedJobSeekers = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobSeeker> sortedDeletedJobSeekers = new DoublyLinkedList<>();
        
        // Sort added job seekers using selection sort approach
        DoublyLinkedListInterface<JobSeeker> tempAddedList = new DoublyLinkedList<>();
        // Copy all job seekers to temporary list
        for (int i = 1; i <= recentlyAddedJobSeekers.getCount(); i++) {
            tempAddedList.insertBack(recentlyAddedJobSeekers.getPosition(i));
        }
        
        // Selection sort find the minimum and add to sorted list
        while (!tempAddedList.isEmpty()) {
            JobSeeker minJobSeeker = tempAddedList.getPosition(1);
            int minIndex = 1;
            
            // Find the job seeker with the minimum name
            for (int i = 2; i <= tempAddedList.getCount(); i++) {
                JobSeeker current = tempAddedList.getPosition(i);
                if (current.getName().compareToIgnoreCase(minJobSeeker.getName()) < 0) {
                    minJobSeeker = current;
                    minIndex = i;
                }
            }
            
            // Add the minimum to the sorted list
            sortedAddedJobSeekers.insertBack(minJobSeeker);
            
            // Remove the minimum from the temporary list
            if (tempAddedList.getCount() == 1) {
                tempAddedList.clear();
            } else {
                tempAddedList.deletePosition(minIndex);
            }
        }
        
        // Sort deleted job seekers 
        DoublyLinkedListInterface<JobSeeker> tempDeletedList = new DoublyLinkedList<>();
        // Copy all job seekers to temporary list
        for (int i = 1; i <= recentlyDeletedJobSeekers.getCount(); i++) {
            tempDeletedList.insertBack(recentlyDeletedJobSeekers.getPosition(i));
        }
        
        // Selection sort find the minimum and add to sorted list
        while (!tempDeletedList.isEmpty()) {
            JobSeeker minJobSeeker = tempDeletedList.getPosition(1);
            int minIndex = 1;
            
            // Find the job seeker with the minimum name
            for (int i = 2; i <= tempDeletedList.getCount(); i++) {
                JobSeeker current = tempDeletedList.getPosition(i);
                if (current.getName().compareToIgnoreCase(minJobSeeker.getName()) < 0) {
                    minJobSeeker = current;
                    minIndex = i;
                }
            }
            
            // Add the minimum to the sorted list
            sortedDeletedJobSeekers.insertBack(minJobSeeker);
            
            // Remove the minimum from the temporary list
            if (tempDeletedList.getCount() == 1) {
                tempDeletedList.clear();
            } else {
                tempDeletedList.deletePosition(minIndex);
            }
        }
        
        // Calculate additional statistics
        int totalSkillsAdded = 0;
        int totalSkillsRemoved = 0;
        
        // Calculate statistics for added job seekers
        for (int i = 1; i <= sortedAddedJobSeekers.getCount(); i++) {
            JobSeeker jobSeeker = sortedAddedJobSeekers.getPosition(i);
            totalSkillsAdded += jobSeeker.getSkills().getCount();
        }
        
        // Calculate statistics for removed job seekers
        for (int i = 1; i <= sortedDeletedJobSeekers.getCount(); i++) {
            JobSeeker jobSeeker = sortedDeletedJobSeekers.getPosition(i);
            totalSkillsRemoved += jobSeeker.getSkills().getCount();
        }
        
        // Calculate averages
        double avgSkillsAdded = sortedAddedJobSeekers.isEmpty() ? 0 : (double) totalSkillsAdded / sortedAddedJobSeekers.getCount();
        double avgSkillsRemoved = sortedDeletedJobSeekers.isEmpty() ? 0 : (double) totalSkillsRemoved / sortedDeletedJobSeekers.getCount();
        
        // Display recently added job seekers
        if (!sortedAddedJobSeekers.isEmpty()) {
            jobSeekerUI.displayAddedJobsHeader(sortedAddedJobSeekers.getCount());
            for (int i = 1; i <= sortedAddedJobSeekers.getCount(); i++) {
                JobSeeker jobSeeker = sortedAddedJobSeekers.getPosition(i);
                jobSeekerUI.displayAddedJobRow(i, jobSeeker.getName(), jobSeeker.getEmail(), 
                        jobSeeker.getAge(), jobSeeker.getGender(), jobSeeker.getSkills().getCount());
            }
        } else {
            jobSeekerUI.displayNoNewAdditions();
        }
        
        // Display recently deleted job seekers
        if (!sortedDeletedJobSeekers.isEmpty()) {
            jobSeekerUI.displayRemovedJobsHeader(sortedDeletedJobSeekers.getCount());
            for (int i = 1; i <= sortedDeletedJobSeekers.getCount(); i++) {
                JobSeeker jobSeeker = sortedDeletedJobSeekers.getPosition(i);
                jobSeekerUI.displayRemovedJobRow(i, jobSeeker.getName(), jobSeeker.getEmail(), 
                        jobSeeker.getAge(), jobSeeker.getGender(), jobSeeker.getSkills().getCount());
            }
        } else {
            jobSeekerUI.displayNoRemovals();
        }
        
        // Display summary report 
        int totalAdded = sortedAddedJobSeekers.getCount();
        int totalRemoved = sortedDeletedJobSeekers.getCount();
        
        jobSeekerUI.displayEnhancedTotalCountReport(
                totalAdded, totalRemoved, avgSkillsAdded, avgSkillsRemoved
        );
    }
}
