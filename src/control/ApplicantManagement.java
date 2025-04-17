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
        internshipApplication = new InternshipApplication();
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

    public void setJobSeekerUI(JobSeekerUI ui) {
        this.jobSeekerUI = ui;
    }
   
    //applicant management create profile
    // public void createJobSeeker(JobSeeker jobSeekerList) {
              
    //     newAddedJobSeekers = new DoublyLinkedList<>();
    //     boolean keepCreating = true;

    //     while (keepCreating)  {
    //         String name = jobSeekerUI.addName();
    //         int age = jobSeekerUI.addAge();
    //         String gender = jobSeekerUI.addGender();
    //         String email = jobSeekerUI.addEmail();
    //         String location = jobSeekerUI.addLocation();
    //         String qualification = jobSeekerUI.addQualification();

    //         DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
    //         boolean addMoreSkills = true;
            
    //         while(addMoreSkills) {
    //             String skillName = jobSeekerUI.askSkills();
    //             int proficiency = jobSeekerUI.askProficiency();
    //             skills.insertBack(new Skill(skillName, proficiency));
                
    //             if (jobSeekerUI.askChoice("\nDo you want to add another skill?") == 2) {
    //                 addMoreSkills = false;
    //             }
    //         }

    //         JobSeeker job = new JobSeeker(name, age, gender, email, location, qualification, skills);
    //         jobSeekers.insertBack(job);
    //         newAddedJobSeekers.insertBack(job);

    //         jobSeekerUI.displayCreateJobsHead();
    //         jobSeekerUI.viewJobSeeker(job, jobSeekers.getCount());
    //         jobSeekerUI.displayViewJobSeekerFoot();
    //         jobSeekerUI.continueKey();

    //         if (jobSeekerUI.askChoice("\nDo you want to add another job seeker?") == 2) {
    //             keepCreating = false;
    //         }
    //     }
    // }

    // public void createNewJobSeeker() {
    //     String name = jobSeekerUI.addName();
    //     int age = jobSeekerUI.addAge();
    //     String gender = jobSeekerUI.addGender();
    //     String email = jobSeekerUI.addEmail();
    //     String location = jobSeekerUI.addLocation();
    //     String qualification = jobSeekerUI.addQualification();

    //     DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
    //     boolean addMoreSkills = true;
        
    //     while(addMoreSkills) {
    //         String skillName = jobSeekerUI.askSkills();
    //         int proficiency = jobSeekerUI.askProficiency();
    //         skills.insertBack(new Skill(skillName, proficiency));
            
    //         if (jobSeekerUI.askChoice("\nDo you want to add another skill?") == 2) {
    //             addMoreSkills = false;
    //         }
    //     }
        
    //     JobSeeker newJobSeeker = new JobSeeker(name, age, gender, email, location, qualification, skills);
    //     createJobSeeker(newJobSeeker);
    // }

    public void createJobSeeker(JobSeeker newJobSeeker) {
        if (newAddedJobSeekers == null) {
            newAddedJobSeekers = new DoublyLinkedList<>();
        }
        
        jobSeekers.insertBack(newJobSeeker);
        jobSeekerList.insertBack(newJobSeeker);
        newAddedJobSeekers.insertBack(newJobSeeker);

        jobSeekerUI.displayCreateJobsHead();
        jobSeekerUI.viewJobSeeker(newJobSeeker, jobSeekerList.getCount());
        jobSeekerUI.displayViewJobSeekerFoot();
        jobSeekerUI.continueKey();
    }

    public void createNewJobSeeker() {
        boolean keepCreating = true;
        while (keepCreating) {
            String name = jobSeekerUI.addName();
            int age = jobSeekerUI.addAge();
            String gender = jobSeekerUI.addGender();
            String email = jobSeekerUI.addEmail();
            String location = jobSeekerUI.addLocation();
            String qualification = jobSeekerUI.addQualification();

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

            JobSeeker newJobSeeker = new JobSeeker(name, age, gender, email, location, qualification, skills);
            createJobSeeker(newJobSeeker);

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
                    viewAllJobs();
                    break;
                case 5:
                    jobSeekerReport();
                    break;
                case 6:
                    System.out.println("Returning to admin menu...");
                    return;
                default:
                    jobSeekerUI.invalidChoice();
            }
        }
    }
    
    //applicant management view applicant
    //display ALL job seekers for admin use
    public void viewAllJobs() { 
        if (jobSeekerList.isEmpty()) {
            jobSeekerUI.noJobSeeker();
        } else {
            jobSeekerUI.displayViewJobSeekerHead();
            for (int i = 1; i <= jobSeekerList.getCount(); i++) { 
                JobSeeker job = jobSeekerList.getPosition(i);
                jobSeekerUI.viewJobSeeker(job, i);                
            }
            jobSeekerUI.displayViewJobSeekerFoot();
        }
    }
    
    //applicant mangement update applicant
    public void updateJobSeeker() {
        if (jobSeekerList.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }

        boolean keepUpdating = true;
        while (keepUpdating) {
            jobSeekerUI.displayListJobsHead();
            for (int i = 1; i <= jobSeekerList.getCount(); i++) {
                JobSeeker job = jobSeekerList.getPosition(i);
                jobSeekerUI.displayJobsNumber(i, job);
            }
            
            int choice = jobSeekerUI.updateChoice(jobSeekerList.getCount(), "\nEnter the job seeker number you want to update: ");
            JobSeeker jobToUpdate = jobSeekerList.getPosition(choice);

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
                    String newEmail = jobSeekerUI.addEmail();
                    jobToUpdate.setEmail(newEmail);
                    break;
                case 3:
                    String newLocation = jobSeekerUI.addLocation();
                    jobToUpdate.setLocation(newLocation);
                    break;
                case 4:
                    String newQualification = jobSeekerUI.addQualification();
                    jobToUpdate.setQualification(newQualification);
                    break;
                case 5:
                    int selectSkill = jobSeekerUI.selectSkillToUpdate(jobToUpdate);
                    Skill selectedSkill = jobToUpdate.getSkills().getPosition(selectSkill);
                    int newProficiency = jobSeekerUI.proficiencyUpdate();
                    selectedSkill.setProficiency(newProficiency);  
                    break;
                default:
                    jobSeekerUI.invalidChoice();
                    return;
            }

            jobSeekerList.replacePosition(jobToUpdate, choice);
            
            jobSeekerUI.newUpdateJobSeeker();
            viewAllJobs();
            jobSeekerUI.successUpdate();
            jobSeekerUI.continueKey();

            if (jobSeekerUI.askChoice("\nDo you want to update another job seeker?") == 2) {
                keepUpdating = false;
            }
        }
    }

    public void removeJobSeeker() {
        if (jobSeekerList.isEmpty()) {
            jobSeekerUI.noJobSeeker();
            return;
        }
        
        boolean keepRemoving = true;
        while (keepRemoving)  {
         // Display a list of job titles
         jobSeekerUI.displayListJobsHead();
         for (int i = 1; i <= jobSeekerList.getCount(); i++) {
             JobSeeker job = jobSeekerList.getPosition(i);
             jobSeekerUI.displayJobsNumber(i, job);
         }

         int choice = jobSeekerUI.updateChoice(jobSeekerList.getCount(), "\nEnter the job seeker number you want to remove: ");
         
         JobSeeker jobToRemove = jobSeekerList.getPosition(choice);
         // Display the selected job seeker
         jobSeekerUI.displaySelectedJobsHead();
         jobSeekerUI.viewJobSeeker(jobToRemove, 0);
         jobSeekerUI.displayViewJobSeekerFoot();
         
         if (jobSeekerUI.askChoice("\nConfirm remove this job seeker?") == 1) {
            deletedJobSeekers.insertBack(jobToRemove); // Store deleted job seeker
            jobSeekerList.deletePosition(choice);
            System.out.println("\nJob seeker '" + jobToRemove.getName() + "' has been removed successfully.");
            jobSeekerUI.continueKey();
        }
        
        if (jobSeekerUI.askChoice("\nDo you want to remove another job seeker?") == 2) {
            keepRemoving = false;
        }
        }
        adminJobSeeker();
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
        //jobSeekerUI.displaySummaryReportHeader();

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
