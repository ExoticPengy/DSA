/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.JobPostingUI;
import dao.JobPostingInitializer;
import entity.Employer;
import entity.JobPosting;
import entity.Skill;

/**
 *
 * @author Elaine
 */
public class JobManagement {
    private JobPostingInitializer jobPostingInitializer;
    private DoublyLinkedListInterface<JobPosting> jobPostings;
    private JobPostingUI jobPostingUI;
    
    public JobManagement(){
        jobPostingInitializer = new JobPostingInitializer();
        jobPostings = new DoublyLinkedList<>();
        jobPostingUI = new JobPostingUI();
    }
    
    public void runJobManagement(DoublyLinkedListInterface<Employer> employerList) {
        jobPostings = jobPostingInitializer.getJobPosting(employerList);
        viewAllJobs(); 
    }
    
    public DoublyLinkedListInterface<JobPosting> getJobPostingList() {
        return jobPostings;
    }
    
    public void createJobPosting(Employer employer) {

        boolean keepCreating = true;
        while (keepCreating)  {
            String title = jobPostingUI.addTitle();
            String description = jobPostingUI.addDescription();
            String salaryRange = jobPostingUI.addSalaryRange();
            String qualification = jobPostingUI.addQualification();

            boolean repeat = true;
            DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        
            while (repeat) {
                // Prompt for required skills
                String skillName = jobPostingUI.askSkills();
                
                boolean alreadyCreated = false;
                for (int i = 1; i <= skills.getCount(); i++) {
                    if (skills.getPosition(i).getName().equals(skillName)) {
                        jobPostingUI.skillAlreadyCreated();
                        alreadyCreated = true;
                    } 
                }
                
                if (!alreadyCreated) {
                    // Ask proficiency level
                    int proficiency = jobPostingUI.askProficiency();

                    skills.insertBack(new Skill(skillName, proficiency));
                }
                
                if (jobPostingUI.askChoice("\nDo you want to add another skill?") == 2) {
                    repeat = false;
                }
            }

            // Create a new JobPosting object
            JobPosting job = new JobPosting(employer, title, description, salaryRange, qualification, skills);

            // Add the job posting to the list
            jobPostings.insertUniqueBack(job);

            // Display created job
            jobPostingUI.displayCreateJobsHead();
            jobPostingUI.viewJobPosting(job, 0);          
            jobPostingUI.displayViewJobPostingFoot();
            //ask repeat
            if (jobPostingUI.askChoice("\nDo you want to add another job posting?") == 2) {
                keepCreating = false;
            }
        }
    }
    
    //view the *SPECIFIC employer's job posting
    public void viewEmployerJobPosting(Employer currentEmployer) { 
        if (jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
        } else {
            int count = 0;
            jobPostingUI.displayViewJobPostingHead();
            for (int i = 1; i <= jobPostings.getCount(); i++) { 
                JobPosting job = jobPostings.getPosition(i);
                if (!job.getEmployer().equals(currentEmployer)) {
                continue;
                }
                count++;
                jobPostingUI.viewJobPosting(job, count);
            }
            jobPostingUI.displayViewJobPostingFoot();
        }
    }
 
    //display ALL job postings for admin use
    public void viewAllJobs() { 
        if (jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
        } else {
            jobPostingUI.displayViewJobPostingHead();
            for (int i = 1; i <= jobPostings.getCount(); i++) { 
                JobPosting job = jobPostings.getPosition(i);
                jobPostingUI.viewJobPosting(job, i);                
            }
            jobPostingUI.displayViewJobPostingFoot();
        }
    }
    
    public void updateJobPosting(Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
            return;
        }

        boolean keepUpdating = true;

        while (keepUpdating)  {
            // Display a list of job titles
            jobPostingUI.displayListJobsHead();
            int jobNumber = 0;
            for (int i = 1; i <= jobPostings.getCount(); i++) {
                JobPosting job = jobPostings.getPosition(i);
                if (job.getEmployer().equals(currentEmployer)) {
                    jobNumber++;
                    jobPostingUI.displayJobsNumber(jobNumber, job);
                }
            }
            int choice =jobPostingUI.updateChoice(jobNumber, "\nEnter the job posting number you want to update: ");

            int count = 0;
            int jobIndex = 0;
            // Get the job posting index to remove
            for(int i = 1; i <= jobPostings.getCount(); i++) {
                JobPosting job = jobPostings.getPosition(i);
                if (job.getEmployer().equals(currentEmployer)) {
                    count++;
                    if (count == choice) {
                        jobIndex = i;
                    }
                }
            }
            
            // Get the job posting to update
            JobPosting jobToUpdate = jobPostings.getPosition(jobIndex);

            // Display the selected job posting
            jobPostingUI.displaySelectedJobsHead();
            jobPostingUI.viewJobPosting(jobToUpdate, 0);
            jobPostingUI.displayViewJobPostingFoot();

            int updateChoice = jobPostingUI.selectToUpdate();

            switch (updateChoice) {
                case 1:
                    String newTitle = jobPostingUI.addTitle();
                    jobToUpdate.setTitle(newTitle);
                    break;
                case 2:
                    String newDescription = jobPostingUI.addDescription();
                    jobToUpdate.setDescription(newDescription);
                    break;
                case 3:
                    String newSalaryRange = jobPostingUI.addSalaryRange();
                    jobToUpdate.setSalaryRange(newSalaryRange);
                    break;
                case 4:
                    String newQualification = jobPostingUI.addQualification();
                    jobToUpdate.setQualification(newQualification);
                    break;
                case 5:
                    int selectSkill = jobPostingUI.selectSkillToUpdate(jobToUpdate);

                    // Get the selected skill
                    Skill selectedSkill = jobToUpdate.getSkills().getPosition(selectSkill);

                    int newProficiency = jobPostingUI.proficiencyUpdate();
                    selectedSkill.setProficiency(newProficiency);  
                    break;

                default:
                    jobPostingUI.invalidChoice();
                    return;
            }

            // Replace the old job posting with the updated one
            jobPostings.replacePosition(jobToUpdate, jobIndex);
            
            // Display all job postings after updating
            jobPostingUI.newUpdateJobTitle();
            viewEmployerJobPosting(currentEmployer);
            jobPostingUI.successUpdate();

            // Ask repeat
            if (jobPostingUI.askChoice("\nDo you want to update another job posting?") == 2) {
                keepUpdating = false;
            }
          
        }
    }

    public void removeJobPosting(Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
        jobPostingUI.noJobPosting();
        return;
        }
        
      boolean keepRemoving = true;
      while (keepRemoving)  {
        // Display a list of job titles
        jobPostingUI.displayListJobsHead();
        int jobNumber = 0;
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (job.getEmployer().equals(currentEmployer)) {
                jobNumber++;
                jobPostingUI.displayJobsNumber(jobNumber,job);
            }
        }

        int choice =jobPostingUI.updateChoice(jobNumber, "\nEnter the job posting number you want to remove: ");

        int count = 0;
        int jobIndex = 0;
        // Get the job posting index to remove
        for(int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (job.getEmployer().equals(currentEmployer)) {
                count++;
                if (count == choice) {
                    jobIndex = i;
                }
            }
        }
        
        JobPosting jobToRemove = jobPostings.getPosition(jobIndex);
        // Display the selected job posting
        jobPostingUI.displaySelectedJobsHead();
        jobPostingUI.viewJobPosting(jobToRemove, 0);
        jobPostingUI.displayViewJobPostingFoot();
        
        int removeChoice = jobPostingUI.askChoice("\nConfirm remove this job posting?");
            
        switch(removeChoice) {
            case 1:
                jobPostings.deletePosition(jobIndex); 
                jobPostingUI.newUpdateJobTitle();
                viewEmployerJobPosting(currentEmployer);
                jobPostingUI.successRemove();
                break;
            case 2:
                jobPostingUI.cancelRemove();
                break;
            default: 
                break;
        }
    
        // Ask repeat
        if (jobPostingUI.askChoice("\nDo you want to remove another job posting?") == 2) {
            keepRemoving = false;
        }
     
      }
    }
        
    //sort job
    public void viewSortedJobs(Employer currentEmployer) {
        int choice = jobPostingUI.displaySortMenu(currentEmployer);
        switch (choice) {
            case 1:
                sortJobs(1, currentEmployer); // Sort by Job Title
                break;
            case 2:
                sortJobs(2, currentEmployer); // Sort by Highest Salary
                break;
            case 3:
                sortJobs(3, currentEmployer); // Sort by Highest Skill Proficiency
                break;
            case 4:
                return;
            default:
                jobPostingUI.invalidChoice();
        }
    }

    public void sortJobs(int sortBy, Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
            return;
        }

        mergeSort(1, jobPostings.getCount(), sortBy, currentEmployer);

        //Display sorted results
        int count = 0;  
        jobPostingUI.displaySortJobsHead();
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
                if (job.getEmployer().equals(currentEmployer)) {
                   count++;
                   jobPostingUI.viewJobPosting(job, count);
                }   
        }
        jobPostingUI.displayViewJobPostingFoot();
    }

    private void mergeSort(int start, int end, int sortBy, Employer currentEmployer) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start, mid, sortBy, currentEmployer);
            mergeSort(mid + 1, end, sortBy, currentEmployer);
            merge(start, mid, end, sortBy, currentEmployer);
        }
    }

    private void merge(int start, int mid, int end, int sortBy, Employer currentEmployer) {
        int i = start;
        int j = mid + 1;

        while (i <= mid && j <= end) {
            JobPosting leftJob = jobPostings.getPosition(i);
            JobPosting rightJob = jobPostings.getPosition(j);

            // Only compare if both are employer's jobs
            if (leftJob.getEmployer().equals(currentEmployer) && 
                rightJob.getEmployer().equals(currentEmployer)) {

                if (shouldSwap(leftJob, rightJob, sortBy)) {
                    // Perform the swap
                    jobPostings.replacePosition(rightJob, i);
                    jobPostings.replacePosition(leftJob, j);
                }
            }

            // Always move at least one pointer
            if (j > end || !rightJob.getEmployer().equals(currentEmployer) ||
                (leftJob.getEmployer().equals(currentEmployer) && 
                 !shouldSwap(leftJob, rightJob, sortBy))) {
                i++;
            } else {
                j++;
            }
        }
    }
        
    private boolean shouldSwap(JobPosting left, JobPosting right, int sortBy) {
        switch (sortBy) {
            case 1: // Title A-Z
                return left.getTitle().compareToIgnoreCase(right.getTitle()) > 0;

            case 2: // Highest salary (compare right side only)
                return getMaxSalaryValue(left.getSalaryRange()) < 
                       getMaxSalaryValue(right.getSalaryRange());

            case 3: // Highest total skills
                return getTotalSkillProficiency(left) < 
                       getTotalSkillProficiency(right);

            default:
                return false;
        }
    }

    private int getMaxSalaryValue(String range) {
        int value = 0;
        boolean afterHyphen = false;

        for (int i = 0; i < range.length(); i++) {
            char c = range.charAt(i);
            if (c == '-') {
                afterHyphen = true;
                value = 0; // Reset to get right side value
            } 
            else if (Character.isDigit(c) && afterHyphen) {
                value = value * 10 + (c - '0');
            }
        }
        return value;
    }


    private int getTotalSkillProficiency(JobPosting job) {
        int total = 0;
        for (int i = 1; i <= job.getSkills().getCount(); i++) {
            total += job.getSkills().getPosition(i).getProficiency();
        }
        return total;
    }
    
}