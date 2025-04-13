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
    private DoublyLinkedListInterface<Employer> employers;
    private DoublyLinkedListInterface<JobPosting> newAddedJobPostings;
    private DoublyLinkedListInterface<JobPosting> deletedJobPostings;
    private JobPostingUI jobPostingUI;
    
    public JobManagement(){
        jobPostingInitializer = new JobPostingInitializer();
        jobPostings = new DoublyLinkedList<>();
        employers = new DoublyLinkedList<>();
        newAddedJobPostings = new DoublyLinkedList<>();  
        deletedJobPostings = new DoublyLinkedList<>(); 
        jobPostingUI = new JobPostingUI();
    }
    
    public void runJobManagement(DoublyLinkedListInterface<Employer> employerList) {
        employers = employerList;
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
            newAddedJobPostings.insertUniqueBack(job);

            // Display created job
            jobPostingUI.displayCreateJobsHead();
            jobPostingUI.viewJobPosting(job, 0);          
            jobPostingUI.displayViewJobPostingFoot();
            jobPostingUI.continueKey();
            
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
        while (keepUpdating) {
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
            jobPostingUI.continueKey();

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

        int choice = jobPostingUI.updateChoice(jobNumber, "\nEnter the job posting number you want to remove: ");

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
                deletedJobPostings.insertBack(jobPostings.deletePosition(jobIndex)); 
                jobPostingUI.newUpdateJobTitle();//displaying
                viewEmployerJobPosting(currentEmployer);
                jobPostingUI.successRemove();
                jobPostingUI.continueKey();
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
    public void sortedJobPosting(Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
            return;
        }

        mergeSort(1, jobPostings.getCount(), currentEmployer);

        // Display results
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
        jobPostingUI.successSort();
        jobPostingUI.continueKey();
    }

    private void mergeSort(int start, int end, Employer currentEmployer) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start, mid, currentEmployer);
            mergeSort(mid + 1, end, currentEmployer);
            merge(start, mid, end, currentEmployer);
        }
    }

    private void merge(int start, int mid, int end, Employer currentEmployer) {
        int left = start;
        int right = mid + 1;

        while (left <= mid && right <= end) {
            JobPosting leftJob = jobPostings.getPosition(left);
            JobPosting rightJob = jobPostings.getPosition(right);

            if (!leftJob.getEmployer().equals(currentEmployer)) {
                left++;
                continue;
            }
            if (!rightJob.getEmployer().equals(currentEmployer)) {
                right++;
                continue;
            }

            if (leftJob.getTitle().compareToIgnoreCase(rightJob.getTitle()) > 0) {
                // Swap jobs 
                jobPostings.replacePosition(rightJob, left);
                jobPostings.replacePosition(leftJob, right);

                left++;
                right++;
                mid++;
                
            } else {
                left++;
            }
        }
    }
    
    //search employer and skill
    public void searchJobPosting() { 
        if (jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
            return;
        }

        boolean keepSearching = true;
        while (keepSearching) {
            
            String employerName = jobPostingUI.searchEmployer();
            String selectedSkill = jobPostingUI.searchSkill(); 

            boolean found = false;
            jobPostingUI.displaySearchResultsHead();

            for (int i = 1; i <= jobPostings.getCount(); i++) {
                JobPosting posting = jobPostings.getPosition(i);  

                // Check if matches employer AND has the skill
                if (posting.getEmployer().getName().toLowerCase().contains(employerName.toLowerCase())) {
                    for (int j = 1; j <= posting.getSkills().getCount(); j++) {
                        if (posting.getSkills().getPosition(j).getName().equalsIgnoreCase(selectedSkill)) {
                            jobPostingUI.viewJobPosting(posting, i);
                            found = true;
                            break;
                        }
                    }
                }
            }
            jobPostingUI.displayViewJobPostingFoot();
            
            if (!found) {
            jobPostingUI.noJobPosting();
     
                if (jobPostingUI.askChoice("\nWould you like to try a different search?") == 2) {
                    keepSearching = false;
                }
            } else {

                if (jobPostingUI.askChoice("\nDo you want to search another job posting?") == 2) {
                    keepSearching = false;
                }
            }
        }
    }
    
    //report
    public void jobPostingReport() {
        
        boolean hasChanges = !newAddedJobPostings.isEmpty() || !deletedJobPostings.isEmpty();

        if (!hasChanges && jobPostings.isEmpty()) {
            jobPostingUI.noJobPosting();
            return;
        }

        // Display newly added jobs section only if there are any
        if (!newAddedJobPostings.isEmpty()) {
            jobPostingUI.displayAddedJobsHeader(newAddedJobPostings.getCount());
            for (int i = 1; i <= newAddedJobPostings.getCount(); i++) {
                JobPosting job = newAddedJobPostings.getPosition(i);
                jobPostingUI.displayAddedJobRow(i, job.getEmployer().getName(), job.getTitle());
            }
        } else {
            jobPostingUI.displayNoNewAdditions();
        }

        // Display removed jobs section only if there are any
        if (!deletedJobPostings.isEmpty()) {
            jobPostingUI.displayRemovedJobsHeader(deletedJobPostings.getCount());
            for (int i = 1; i <= deletedJobPostings.getCount(); i++) {
                JobPosting job = deletedJobPostings.getPosition(i);
                jobPostingUI.displayRemovedJobRow(i, job.getEmployer().getName(), job.getTitle());
            }
        } else {
            jobPostingUI.displayNoRemovals();
        }

        // Display summary report 
        jobPostingUI.displaySummaryReportHeader();

        if (hasChanges) {
            int totalAdded = newAddedJobPostings.getCount();
            int totalRemoved = deletedJobPostings.getCount();
            int netChange = totalAdded - totalRemoved;

            int rowNum = 1;
            for (int i = 1; i <= employers.getCount(); i++) {
                Employer employer = employers.getPosition(i);
                int oldCount = countOldPostings(employer);
                int newCount = countCurrentPostings(employer);
                int change = newCount - oldCount;

                if (change != 0) {
                    jobPostingUI.displaySummaryReport(
                        rowNum++,
                        employer.getName(),
                        oldCount,
                        newCount,
                        change
                    );
                }
            }
            jobPostingUI.displaySummaryReportFooter(totalAdded, totalRemoved, netChange);
        } else {
            jobPostingUI.displayNoChangesSummary();
        }
        jobPostingUI.continueKey();
    }

    // Count job postings in previous state 
    private int countOldPostings(Employer employer) {
        int count = 0;

        // Count in current postings
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            if (jobPostings.getPosition(i).getEmployer().equals(employer)) {
                count++;
            }
        }

        // Subtract jobs that were newly added
        for (int i = 1; i <= newAddedJobPostings.getCount(); i++) {
            if (newAddedJobPostings.getPosition(i).getEmployer().equals(employer)) {
                count--;
            }
        }

        // Add back jobs that were recently deleted
        for (int i = 1; i <= deletedJobPostings.getCount(); i++) {
            if (deletedJobPostings.getPosition(i).getEmployer().equals(employer)) {
                count++;
            }
        }
        return count;
    }

    // Count job postings in current state
    private int countCurrentPostings(Employer employer) {
        int count = 0;
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            if (jobPostings.getPosition(i).getEmployer().equals(employer)) {
                count++;
            }
        }
        return count;
    }
    
    
    
    
    
    
    
    
}