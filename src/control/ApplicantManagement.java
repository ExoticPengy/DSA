/*
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

/**
 *
 * @author mings, cx
 */
public class ApplicantManagement {
    private JobSeekerInitializer jobSeekerInitializer;
    private DoublyLinkedListInterface<JobSeeker> jobSeekers;
    private DoublyLinkedListInterface<JobSeeker> newAddedJobSeekers;
    private DoublyLinkedListInterface<JobSeeker> jobSeekerList;
    private DoublyLinkedListInterface<JobSeeker> deletedJobSeekers;
    private InternshipApplication internshipApplication;
    private JobSeekerUI jobSeekerUI;
    
    public ApplicantManagement(){
        jobSeekerInitializer = new JobSeekerInitializer();
        jobSeekers = new DoublyLinkedList<>();
        jobSeekerList = new DoublyLinkedList<>();
        deletedJobSeekers = new DoublyLinkedList<>(); 
    }
    
    public void initializeApplicantManagement() {
        jobSeekerList = jobSeekerInitializer.getJobSeeker();
    }
    
    public void runApplicantManagement(){
        internshipApplication.studentNameMenu(jobSeekerList);
    }
    
    public DoublyLinkedListInterface<JobSeeker> getJobSeekerList() {
        return jobSeekerList;
    }
   
    //applicant management create profile
    public void createJobSeeker(JobSeeker jobSeekerList) {
       
        boolean keepCreating = true;
        while (keepCreating)  {
            String name = jobSeekerUI.addName();
            int age = jobSeekerUI.addAge();
            String gender = jobSeekerUI.addGender();
            String email = jobSeekerUI.addEmail();
            String location = jobSeekerUI.addLocation();
            String qualification = jobSeekerUI.addQualification();

            boolean repeat = true;
            DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        
            // Create a new JobSeeker object
            JobSeeker job = new JobSeeker(name, age, gender, email, location, qualification, skills);

            // Add the job seeker to the list
            jobSeekers.insertUniqueBack(job);
            newAddedJobSeekers.insertUniqueBack(job);

            // Display created job
            jobSeekerUI.displayCreateJobsHead();
            jobSeekerUI.viewJobSeeker(job, 0);          
            jobSeekerUI.displayViewJobSeekerFoot();
            jobSeekerUI.continueKey();
            
            //ask repeat
            if (jobSeekerUI.askChoice("\nDo you want to add another job seeker?") == 2) {
                keepCreating = false;
            }
        }
    }
    
    //view the applicant's name
    public void viewJobSeekers(JobSeeker currentApplicant) { 
        if (jobSeekers.isEmpty()) {
            jobSeekerUI.noJobSeeker();
        } else {
            int count = 0;
            jobSeekerUI.displayViewJobSeekerHead();
            for (int i = 1; i <= jobSeekers.getCount(); i++) { 
                JobSeeker job = jobSeekers.getPosition(i);
                if (!job.getName().equals(currentApplicant)) {
                continue;
                }
                count++;
                jobSeekerUI.viewJobSeeker(job, count);
            }
            jobSeekerUI.displayViewJobSeekerFoot();
        }
    }

    public void adminJobSeeker(){
        viewAllJobs();
        boolean repeat = true;
        while(repeat){
            switch (jobSeekerUI.adminJobSeeker()){
                case 1:
                    updateJobSeeker();
                    repeat = false;
                    break;
                case 2 :
                    removeJobSeeker();
                    repeat = false;
                    break;
                case 3 :
                    return;
                default:
                    jobSeekerUI.invalidChoice();
            }
        }
    }
    
    //applicant management view applicant
    //display ALL job seekers for admin use
    public void viewAllJobs() { 
        if (jobSeekers.isEmpty()) {
            jobSeekerUI.noJobSeeker();
        } else {
            jobSeekerUI.displayViewJobSeekerHead();
            for (int i = 1; i <= jobSeekers.getCount(); i++) { 
                JobSeeker job = jobSeekers.getPosition(i);
                jobSeekerUI.viewJobSeeker(job, i);                
            }
            jobSeekerUI.displayViewJobSeekerFoot();
        }
    }
    
    //applicant mangement update/remove applicant
    public void updateJobSeeker(JobSeeker currentApplicant) {
        if (jobSeekers.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }

        boolean keepUpdating = true;
        while (keepUpdating) {
            // Display a list of job titles
            jobSeekerUI.displayListJobsHead();
            int jobNumber = 0;
            for (int i = 1; i <= jobSeekers.getCount(); i++) {
                JobSeeker job = jobSeekers.getPosition(i);
                if (job.getName().equals(currentApplicant)) {
                    jobNumber++;
                    jobSeekerUI.displayJobsNumber(jobNumber, job);
                }
            }
            int choice =jobSeekerUI.updateChoice(jobNumber, "\nEnter the job seeker number you want to update: ");

            int count = 0;
            int jobIndex = 0;
            // Get the job seeker index to remove
            for(int i = 1; i <= jobSeekers.getCount(); i++) {
                JobSeeker job = jobSeekers.getPosition(i);
                if (job.getName().equals(currentApplicant)) {
                    count++;
                    if (count == choice) {
                        jobIndex = i;
                    }
                }
            }
           
            JobSeeker jobToUpdate = jobSeekers.getPosition(jobIndex);

            // Display the selected job seeker
            jobSeekerUI.displaySelectedJobsHead();
            jobSeekerUI.viewJobSeeker(jobToUpdate, 0);
            jobSeekerUI.displayViewJobSeekerFoot();

            int updateChoice = jobSeekerUI.selectToUpdate();

            switch (updateChoice) {
                case 1:
                    String newName = jobSeekerUI.addName();
                    jobToUpdate.setName(newName);
                    break;
                case 2:
                    int newAge = jobSeekerUI.addAge();
                    jobToUpdate.setAge(newAge);
                    break;
                case 3:
                    String newGender = jobSeekerUI.addGender();
                    jobToUpdate.setGender(newGender);
                    break;
                case 4:
                    String newEmail = jobSeekerUI.addEmail();
                    jobToUpdate.setEmail(newEmail);
                    break;
                case 5:
                    String newLocation = jobSeekerUI.addLocation();
                    jobToUpdate.setLocation(newLocation);
                    break;
                case 6:
                    String newQualification = jobSeekerUI.addQualification();
                    jobToUpdate.setQualification(newQualification);
                    break;
                case 7:
                    int selectSkill = jobSeekerUI.selectSkillToUpdate(jobToUpdate);
                    Skill selectedSkill = jobToUpdate.getSkills().getPosition(selectSkill);

                    int newProficiency = jobSeekerUI.proficiencyUpdate();
                    selectedSkill.setProficiency(newProficiency);  
                    break;

                default:
                    jobSeekerUI.invalidChoice();
                    return;
            }

            // Replace the old job seeker with the updated one
            jobSeekers.replacePosition(jobToUpdate, jobIndex);
            
            // Display all job seekers after updating
            jobSeekerUI.newUpdateJobTitle();
            viewJobSeekers(currentApplicant);
            jobSeekerUI.successUpdate();
            jobSeekerUI.continueKey();

            // Ask repeat
            if (jobSeekerUI.askChoice("\nDo you want to update another job seeker?") == 2) {
                keepUpdating = false;
            }
          
        }
    }

    public void removeJobSeeker(JobSeeker currentApplicant) {
        if (jobSeekers.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }
        
      boolean keepRemoving = true;
      while (keepRemoving)  {
        // Display a list of job titles
        jobSeekerUI.displayListJobsHead();
        int jobNumber = 0;
        for (int i = 1; i <= jobSeekers.getCount(); i++) {
            JobSeeker job = jobSeekers.getPosition(i);
            if (job.getName().equals(currentApplicant)) {
                jobNumber++;
                jobSeekerUI.displayJobsNumber(jobNumber,job);
            }
        }

        int choice = jobSeekerUI.updateChoice(jobNumber, "\nEnter the job seeker number you want to remove: ");

        int count = 0;
        int jobIndex = 0;
        // Get the job seeker index to remove
        for(int i = 1; i <= jobSeekers.getCount(); i++) {
            JobSeeker job = jobSeekers.getPosition(i);
            if (job.getName().equals(currentApplicant)) {
                count++;
                if (count == choice) {
                    jobIndex = i;
                }
            }
        }
        
        JobSeeker jobToRemove = jobSeekers.getPosition(jobIndex);
        // Display the selected job seeker
        jobSeekerUI.displaySelectedJobsHead();
        jobSeekerUI.viewJobSeeker(jobToRemove, 0);
        jobSeekerUI.displayViewJobSeekerFoot();
        
        int removeChoice = jobSeekerUI.askChoice("\nConfirm remove this job seeker?");
            
        switch(removeChoice) {
            case 1:
                deletedJobSeekers.insertBack(jobSeekers.deletePosition(jobIndex)); 
                jobSeekerUI.newUpdateJobTitle();//displaying
                viewJobSeekers(currentApplicant);
                jobSeekerUI.successRemove();
                jobSeekerUI.continueKey();
                break;
            case 2:
                jobSeekerUI.cancelRemove();
                break;
            default: 
                break;
        }
    
        // Ask repeat
        if (jobSeekerUI.askChoice("\nDo you want to remove another job seeker?") == 2) {
            keepRemoving = false;
        }
     
      }
    }

    //applicant management report
    public void jobSeekerReport() {
        
        jobSeekerUI.displayReportHeader(); 
        
        boolean hasChanges = !newAddedJobSeekers.isEmpty() || !deletedJobSeekers.isEmpty();

        if (!hasChanges && jobSeekers.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }

        // Display newly added jobs section only if there are any
        if (!newAddedJobSeekers.isEmpty()) {
            jobSeekerUI.displayAddedJobsHeader(newAddedJobSeekers.getCount());
            for (int i = 1; i <= newAddedJobSeekers.getCount(); i++) {
                JobSeeker job = newAddedJobSeekers.getPosition(i);
                jobSeekerUI.displayAddedJobRow(i, job.getName(), job.getGender());
            }
        } else {
            jobSeekerUI.displayNoNewAdditions();
        }

        // Display removed jobs section only if there are any
        if (!deletedJobSeekers.isEmpty()) {
            jobSeekerUI.displayRemovedJobsHeader(deletedJobSeekers.getCount());
            for (int i = 1; i <= deletedJobSeekers.getCount(); i++) {
                JobSeeker job = deletedJobSeekers.getPosition(i);
                jobSeekerUI.displayRemovedJobRow(i, job.getName(), job.getGender());
            }
        } else {
            jobSeekerUI.displayNoRemovals();
        }

        // Display summary report 
        jobSeekerUI.displaySummaryReportHeader();

        if (hasChanges) {
            int totalAdded = newAddedJobSeekers.getCount();
            int totalRemoved = deletedJobSeekers.getCount();
            int netChange = totalAdded - totalRemoved;

            int rowNum = 1;
            for (int i = 1; i <= jobSeekers.getCount(); i++) {
                JobSeeker jobSeekerList = jobSeekers.getPosition(i);
                int oldCount = countOldSeekers(jobSeekerList);
                int newCount = countCurrentSeekers(jobSeekerList);
                int change = newCount - oldCount;

                if (change != 0) {
                    jobSeekerUI.displaySummaryReport(
                        rowNum++,
                        jobSeekerList.getName(),
                        oldCount,
                        newCount,
                        change
                    );
                }
            }
            jobSeekerUI.displayTotalCountReport(totalAdded, totalRemoved, netChange);
            jobSeekerUI.displaySummaryReportFooter();
        } else {
            jobSeekerUI.displayNoChangesSummary();
            jobSeekerUI.displayTotalCountReport(0, 0, 0);
            jobSeekerUI.displaySummaryReportFooter();
        }
        jobSeekerUI.continueKey();
    }

    // Count job seekers in previous state 
    private int countOldSeekers(JobSeeker jobSeekerList) {
        int count = 0;

        // Count in current seekers
        for (int i = 1; i <= jobSeekers.getCount(); i++) {
            if (jobSeekers.getPosition(i).getName().equals(jobSeekerList)) {
                count++;
            }
        }

        // Subtract jobs that were newly added
        for (int i = 1; i <= newAddedJobSeekers.getCount(); i++) {
            if (newAddedJobSeekers.getPosition(i).getName().equals(jobSeekerList)) {
                count--;
            }
        }

        // Add back jobs that were recently deleted
        for (int i = 1; i <= deletedJobSeekers.getCount(); i++) {
            if (deletedJobSeekers.getPosition(i).getName().equals(jobSeekerList)) {
                count++;
            }
        }
        return count;
    }

    // Count job seekers in current state
    private int countCurrentSeekers(JobSeeker jobSeekerList) {
        int count = 0;
        for (int i = 1; i <= jobSeekers.getCount(); i++) {
            if (jobSeekers.getPosition(i).getName().equals(jobSeekerList)) {
                count++;
            }
        }
        return count;
    }
}
