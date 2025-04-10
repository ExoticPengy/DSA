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
import java.util.InputMismatchException;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Elaine
 */
public class JobManagement {
    private JobPostingInitializer jobPostingInitializer;
    private DoublyLinkedListInterface<JobPosting> jobPostings;
    private JobPostingUI jobPostingUI;
    private Scanner scanner = new Scanner(System.in);
    
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

                // Ask proficiency level
                int proficiency = jobPostingUI.askProficiency();

                skills.insertBack(new Skill(skillName, proficiency));

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
            if (jobPostingUI.askChoice("\nDo you want to add another job posting?") == 2) {
                keepCreating = false;
            }
        }
    }
    
    //view the *specific employer's job posting
    public void viewEmployerJobPosting(Employer currentEmployer) { 
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
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
 
    //display all job postings for admin use
    public void viewAllJobs() { 
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
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
            System.out.println("No job postings available to update.");
            return;
        }

        boolean keepUpdating = true;

        while (keepUpdating)  {
            // Display a list of job titles
            System.out.println("\n+-------------------------------------------+");
            System.out.println("|            List of Job Postings           |");
            System.out.println("+-------------------------------------------+");
            int jobNumber = 0;
            for (int i = 1; i <= jobPostings.getCount(); i++) {
                JobPosting job = jobPostings.getPosition(i);
                if (job.getEmployer().equals(currentEmployer)) {
                    jobNumber++;
                    System.out.println(jobNumber + ". " + job.getTitle());
                }
            }

            int choice = 0;
            boolean chooseJob = false;
            while (!chooseJob) {
                System.out.print("\nEnter the job posting number you want to update: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice >= 1 && choice <= jobNumber) {
                    chooseJob = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                }  
            }

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
            System.out.println("\n+-----------------------------------------------+");
            System.out.println("|             Selected Job Posting              |");
            System.out.println("+-----------------------------------------------+");
            System.out.println("Employer: " + jobToUpdate.getEmployer().getName());
            System.out.println("Job Title: " + jobToUpdate.getTitle());
            System.out.println("Description: " + jobToUpdate.getDescription());
            System.out.println("Salary Range: " + jobToUpdate.getSalaryRange());
            System.out.println("Qualification: " + jobToUpdate.getQualification());
            System.out.println("Skills Required: ");
            for (int j = 1; j <= jobToUpdate.getSkills().getCount(); j++) {
                System.out.println(j + ". " + jobToUpdate.getSkills().getPosition(j).getName()
                        + ": " + jobToUpdate.getSkills().getPosition(j).getProficiency());
            }
            System.out.println("+-----------------------------------------------+");

            int updateChoice = 0;
            boolean validUpdateChoice = false;
            while (!validUpdateChoice) {
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
                    validUpdateChoice = true;
                } else {
                    System.out.print("Invalid input! Please enter number 1-5.\n");
                }
            }

            switch (updateChoice) {
                case 1:
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    jobToUpdate.setTitle(newTitle);
                    break;
                case 2:
                    System.out.print("Enter new Description: ");
                    String newDescription = scanner.nextLine();
                    jobToUpdate.setDescription(newDescription);
                    break;
                case 3:
                    System.out.print("Enter new Salary Range: ");
                    String newSalaryRange = scanner.nextLine();
                    jobToUpdate.setSalaryRange(newSalaryRange);
                    break;
                case 4:
                    System.out.print("Enter new Qualification: ");
                    String newQualification = scanner.nextLine();
                    jobToUpdate.setQualification(newQualification);
                    break;
                case 5:
                    System.out.print("\nChoose skill to update: \n");
                    for (int j = 1; j <= jobToUpdate.getSkills().getCount(); j++) {
                        System.out.println(j + ". " + jobToUpdate.getSkills().getPosition(j).getName()
                                + ": " + jobToUpdate.getSkills().getPosition(j).getProficiency());
                    }

                    int selectSkill = 0;
                    boolean chooseUpdateSkill = false;
                    while (!chooseUpdateSkill) {
                    System.out.print("\nEnter the skill number you want to update: ");
                    selectSkill = scanner.nextInt();
                    scanner.nextLine();

                        if(selectSkill >= 1 && selectSkill <= jobToUpdate.getSkills().getCount()) {
                            chooseUpdateSkill = true;
                        } else {
                            System.out.print("Invalid input! Please enter a valid number.\n");
                        }
                    }

                    // Get the selected skill
                    Skill selectedSkill = jobToUpdate.getSkills().getPosition(selectSkill);

                    int newProficiency = 0;
                    boolean updateProficiency = false;
                    while (!updateProficiency) {
                    System.out.print("Enter new proficiency(1-10): ");
                    newProficiency = scanner.nextInt();
                    scanner.nextLine();

                        if(newProficiency >= 1 && newProficiency <= 10) {
                              updateProficiency = true;
                        } else {
                            System.out.print("Invalid input. Please enter a valid number.\n");
                        }
                    }
                    selectedSkill.setProficiency(newProficiency);  
                    break;

                default:
                    System.out.println("Invalid input! Please enter a valid number.");
                    return;
            }

            // Replace the old job posting with the updated one
            jobPostings.replacePosition(jobToUpdate, jobIndex);
            System.out.println("Job posting updated successfully!");

            // Display all job postings after updating
            System.out.println("\nUpdated Job Postings:");
            viewEmployerJobPosting(currentEmployer);

            // Ask repeat
            boolean validOption = false;
            while (!validOption) {
                System.out.print("\nUpdate another job listing?" + "\n1. Yes\n2. No\nEnter your choice: ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            validOption = true;
                            break;
                        case 2:
                            keepUpdating = false;
                            validOption = true;
                            break;
                        default:
                            System.out.println("Invalid option, please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter 1 or 2.");
                    scanner.nextLine(); 
                }
            }
        }
    }

    public void removeJobPosting(Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
        System.out.println("No job postings available to remove.");
        return;
        }
        
      boolean keepRemoving = true;
      while (keepRemoving)  {
        // Display a list of job titles
        System.out.println("\n+-------------------------------------------+");
        System.out.println("|            List of Job Postings           |");
        System.out.println("+-------------------------------------------+");
        
        int jobNumber = 0;
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (job.getEmployer().equals(currentEmployer)) {
                jobNumber++;
                System.out.println(jobNumber + ". " + job.getTitle());
            }
        }

        int choice = 0;
        boolean chooseRemoveJob = false;
        while (!chooseRemoveJob) {
            System.out.print("\nEnter the job posting number you want to remove: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice >= 1 && choice <= jobNumber) {
                chooseRemoveJob = true;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
            }  
        }

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
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("|             Selected Job Posting              |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("Employer: " + jobToRemove.getEmployer().getName());
        System.out.println("Job Title: " + jobToRemove.getTitle());
        System.out.println("Description: " + jobToRemove.getDescription());
        System.out.println("Salary Range: " + jobToRemove.getSalaryRange());
        System.out.println("Qualification: " + jobToRemove.getQualification());
        System.out.println("Skills Required: ");
        for (int j = 1; j <= jobToRemove.getSkills().getCount(); j++) {
            System.out.println(j + ". " + jobToRemove.getSkills().getPosition(j).getName()
                    + ": " + jobToRemove.getSkills().getPosition(j).getProficiency());
        }
        System.out.println("+-----------------------------------------------+");
        
        int removeChoice = 0;
        boolean confirmation = false;
        while (!confirmation) {
            System.out.print("\nConfirm remove this job posting?" + "\n1. Yes\n2. No\nEnter your choice: ");
            try {
            removeChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch(removeChoice) {
                case 1:
                    jobPostings.deletePosition(jobIndex); 
                    System.out.println("Job posting remove successfully!");
                    System.out.println("\nUpdated Job Postings:");
                    viewEmployerJobPosting(currentEmployer);
                    confirmation = true;
                    break;
                case 2:
                    System.out.println("Removal cancelled.");
                    confirmation = true;
                    break;
                default: 
                    System.out.print("Invalid input. Please enter a valid number.\n");
            }
            
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter 1 or 2");
                scanner.nextLine();
            }
        }
    
        // Ask repeat
        boolean removeOption = false;
        while (!removeOption) {
            System.out.print("\nRemove another job listing?" + "\n1. Yes\n2. No\nEnter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        removeOption = true;
                        break;
                    case 2:
                        keepRemoving = false;
                        removeOption = true;
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter 1 or 2.");
                scanner.nextLine(); 
            }
        }
        
      }
    }
        
    //search job-----------------------------------------------------------------------------------------
    public void searchJobs(Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available to search.");
            return;
        }

        System.out.println("\n+--------------------------------+");
        System.out.println("|         Search Job Posting     |");
        System.out.println("+--------------------------------+");
        System.out.println("| Search by:                     |");
        System.out.println("| 1. Job Title                   |");
        System.out.println("| 2. Skill Required              |");
        System.out.println("| 3. Salary Range                |");
        System.out.println("| 4. Back to Menu                |");
        System.out.println("+--------------------------------+");
        System.out.print("Enter your choice: ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                searchByTitle(currentEmployer);
                break;
            case 2:
                searchBySkill(currentEmployer);
                break;
            case 3:
                searchBySalary(currentEmployer);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void searchByTitle(Employer currentEmployer) {
        System.out.print("Enter job title to search: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (job.getEmployer().equals(currentEmployer) && 
                job.getTitle().toLowerCase().contains(searchTerm)) {
                displaySearchJob(job);
                found = true;
            }
        }
        if (!found) System.out.println("No jobs found with that title in your company.");
    }

    private void searchBySkill(Employer currentEmployer) {
        System.out.print("\nWhich skill you want to search: \n"
                            + "1. Communication \n2. Leadership \n3. Programming \n4. Analysis\n"
                            + "\nEnter your choice: ");
        
   
        String searchTerm = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (!job.getEmployer().equals(currentEmployer)) {
                continue;
            }

            for (int j = 1; j <= job.getSkills().getCount(); j++) {
                Skill skill = job.getSkills().getPosition(j);
                if (skill.getName().toLowerCase().contains(searchTerm)) {
                    displaySearchJob(job);
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No jobs require that skill in your company.");
    }

    private void searchBySalary(Employer currentEmployer) {
        System.out.print("Enter MINimum salary (e.g., 100): ");
        double minSalary = scanner.nextDouble();
        System.out.print("Enter MAXimum salary (e.g., 200): ");
        double maxSalary = scanner.nextDouble();
        scanner.nextLine(); 

        boolean found = false;
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (!job.getEmployer().equals(currentEmployer)) {
                continue;
            }

            String salaryStr = job.getSalaryRange().replaceAll("[^0-9-]", "");
            String[] range = salaryStr.split("-");
            double jobMin = Double.parseDouble(range[0]);
            double jobMax = range.length > 1 ? Double.parseDouble(range[1]) : jobMin;

            if (jobMax >= minSalary && jobMin <= maxSalary) {
                displaySearchJob(job);
                found = true;
            }
        }
        if (!found) System.out.println("No jobs in that salary range in your company.");
    }

    private void displaySearchJob(JobPosting job) {
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("|               Job Posting Found               |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("Employer: " + job.getEmployer().getName());
        System.out.println("Job Title: " + job.getTitle());
        System.out.println("Description: " + job.getDescription());
        System.out.println("Salary: " + job.getSalaryRange());
        System.out.println("Skills Required:");
        for (int j = 1; j <= job.getSkills().getCount(); j++) {
            System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
            + ": " + job.getSkills().getPosition(j).getProficiency());
        }
        System.out.println("--------------------------------------------------");
               
        // Ask repeat
            boolean validOption = false;
            int searchChoice;
            while (!validOption) {
                System.out.print("\nDo you want to search another job posting?" + "\n1. Yes\n2. No\nEnter your choice: ");
                try {
                    searchChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (searchChoice) {
                        case 1:
                            validOption = true;
                            searchJobs(job.getEmployer());
                            break;
                        case 2:
                            validOption = true;
                            break;
                        default:
                            System.out.println("Invalid option, please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter 1 or 2.");
                    scanner.nextLine(); 
                }
            }
        
        
        
    }
    //end of search job function-----------------------------------------------------------------------
    
    
    
    //sort job
    public void viewSortedJobs(Employer currentEmployer) {
    System.out.println("\n+--------------------------------------------+");
    System.out.println("|               Sort Jobs Menu               |");
    System.out.println("+--------------------------------------------+");
    System.out.println("| 1. Sort by Job Title (A-Z)                 |");
    System.out.println("| 2. Sort by Highest Salary                  |");
    System.out.println("| 3. Sort by Highest Total Skill Proficiency |");
    System.out.println("| 4. Back to Main Menu                       |");
    System.out.println("+--------------------------------------------+");
    System.out.print("\nEnter your choice: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

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
            System.out.println("Invalid choice. Please try again.");
    }
}

    public void sortJobs(int sortBy, Employer currentEmployer) {
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available to sort.");
            return;
        }

         // Step 2: Sort the filtered list
        mergeSort(1, jobPostings.getCount(), sortBy, currentEmployer);

        // Step 3: Display sorted results
        System.out.println("\n+-----------------------------------------------+");
            System.out.println("|               Sorted Job Posting               |");
            System.out.println("+-----------------------------------------------+");


       for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            if (job.getEmployer().equals(currentEmployer)) {
            System.out.println("Employer: " + job.getEmployer().getName());
            System.out.println("Job Title: " + job.getTitle());
            System.out.println("Description: " + job.getDescription());
            System.out.println("Salary: " + job.getSalaryRange());
            System.out.println("Skills Required:");
            for (int j = 1; j <= job.getSkills().getCount(); j++) {
                System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
                    + ": " + job.getSkills().getPosition(j).getProficiency());
            }
            System.out.println("--------------------------------------------------");
        }
       }
        MessageUI.pressAnyKeyContinue();
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

            // Only compare employer's jobs
            if (leftJob.getEmployer().equals(currentEmployer) && 
                rightJob.getEmployer().equals(currentEmployer)) {

                if (shouldSwap(leftJob, rightJob, sortBy)) {
                    // Swap positions
                    jobPostings.replacePosition(rightJob, i);
                    jobPostings.replacePosition(leftJob, j);
                    i++;
                }
                j++;
            } 
            else if (!leftJob.getEmployer().equals(currentEmployer)) {
                i++;
            }
            else {
                j++;
            }
        }
    }
        
    private boolean shouldSwap(JobPosting left, JobPosting right, int sortBy) {
        switch (sortBy) {
            case 1: // Sort by title (A-Z)
                return left.getTitle().compareToIgnoreCase(right.getTitle()) > 0;

            case 2: // Sort by highest salary (descending)
                return extractMaxSalary(left.getSalaryRange()) < 
                       extractMaxSalary(right.getSalaryRange());

            case 3: // Sort by total skill proficiency (descending)
                return getTotalSkillProficiency(left) < 
                       getTotalSkillProficiency(right);

            default:
                return false;
        }
    }

//    // Comparison methods remain the same as before
//    private int compareJobs(JobPosting a, JobPosting b, int sortBy) {
//        switch (sortBy) {
//            case 1: return a.getTitle().compareToIgnoreCase(b.getTitle());
//            case 2: return Double.compare(
//                extractMaxSalary(b.getSalaryRange()),
//                extractMaxSalary(a.getSalaryRange()));
//            case 3: return Integer.compare(
//                getTotalSkillProficiency(b),
//                getTotalSkillProficiency(a));
//            default: return 0;
//        }
//    }

    private double extractMaxSalary(String range) {
        String[] parts = range.replaceAll("[^0-9-]", "").split("-");
        return parts.length > 1 ? Double.parseDouble(parts[1]) : Double.parseDouble(parts[0]);
    }

    private int getTotalSkillProficiency(JobPosting job) {
        int total = 0;
        for (int i = 1; i <= job.getSkills().getCount(); i++) {
            total += job.getSkills().getPosition(i).getProficiency();
        }
        return total;
    }
    
}