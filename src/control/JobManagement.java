/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import dao.JobPostingInitializer;
import entity.Employer;
import entity.JobPosting;
import entity.Skill;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class JobManagement {
    private Scanner scanner = new Scanner(System.in);
    private JobPostingInitializer jobPostingInitializer;
    private DoublyLinkedListInterface<JobPosting> jobPostings;
    
    public JobManagement(){
        jobPostingInitializer = new JobPostingInitializer();
        jobPostings = new DoublyLinkedList<>();
    }
    
    public void runJobManagement(DoublyLinkedListInterface<Employer> employerList) {
        jobPostings = jobPostingInitializer.getJobPosting(employerList);
    }
    
    public DoublyLinkedListInterface<JobPosting> getJobPostingList() {
        return jobPostings;
    }
    
    public void createJobPosting(Employer employer) {

        boolean keepCreating = true;
    
        while (keepCreating)  {
            System.out.print("\nEnter Job Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Job Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter Salary Range: ");
            String salaryRange = scanner.nextLine();
            System.out.print("Enter Qualification: ");
            String qualification = scanner.nextLine();

            boolean repeat = true;
            boolean validOption = false;
            int choice;
            DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        
            while (repeat) {
                String skillName = "";
                int proficiency = 0;
                validOption = false;
            
                // Prompt for required skills
                while (!validOption) {
                    System.out.print("\nWhat is the skill required?\n"
                            + "1. Communication \n2. Leadership \n3. Programming \n4. Analysis\n"
                            + "\nEnter your choice: ");

                    try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                skillName = "Communication";
                                validOption = true;
                                break;
                            case 2:
                                skillName = "Leadership";
                                validOption = true;
                                break;
                            case 3:
                                skillName = "Programming";
                                validOption = true;
                                break;
                            case 4:
                                skillName = "Analysis";
                                validOption = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a number between 1-4.");
                        scanner.nextLine();
                    }
                }

                // Get proficiency level
                validOption = false;
                while (!validOption) {
                    System.out.print(" *Enter proficiency of chosen skill (1-10): ");

                    try {
                        proficiency = scanner.nextInt();
                        scanner.nextLine();
                        if (proficiency >= 1 && proficiency <= 10) {
                            validOption = true;
                        } else {
                            System.out.println("Invalid input, please enter a number between 1-10.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.nextLine(); 
                    }
                }

                skills.insertBack(new Skill(skillName, proficiency));

                // add new skill
                validOption = false;
                while (!validOption) {
                    System.out.print("\nAdd another skill?" + "\n1. Yes\n2. No\nEnter your choice: ");
                    try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                validOption = true;
                                break;
                            case 2:
                                repeat = false;
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

            // Create a new JobPosting object
            JobPosting job = new JobPosting(employer, title, description, salaryRange, qualification, skills);

            // Add the job posting to the list
            jobPostings.insertUniqueBack(job);

        // Display created job
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("|             Newly Created Job Posting         |");
        System.out.println("+-----------------------------------------------+");
        System.out.println("Employer: " + job.getEmployer().getName());
        System.out.println("Job Title: " + job.getTitle());
        System.out.println("Description: " + job.getDescription());
        System.out.println("Salary Range: " + job.getSalaryRange());
        System.out.println("Qualification: " + job.getQualification());
        System.out.println("Skills Required:");
        for (int j = 1; j <= job.getSkills().getCount(); j++) {
            System.out.println(" " + j + ". " + job.getSkills().getPosition(j).getName() 
            + ": " + job.getSkills().getPosition(j).getProficiency());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Job posting created successfully!");
        
            boolean validCreateChoice = false;
            while (!validCreateChoice) {
                System.out.print("\nDo you want to create another job listing?" + "\n1. Yes\n2. No\nEnter your choice: ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            validCreateChoice = true;
                            break;
                        case 2:
                            keepCreating = false;
                            validCreateChoice = true;
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
    public void viewEmployerJobPosting(Employer currentEmployer) { 
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
        } else {
                  
            System.out.println("\n+-------------------------------------------------+");
            System.out.println("|                All Job Postings                 |");
            System.out.println("+-------------------------------------------------+");
            for (int i = 1; i <= jobPostings.getCount(); i++) { 
                JobPosting job = jobPostings.getPosition(i);
                if (!job.getEmployer().equals(currentEmployer)) {
                    continue;
                }
                System.out.println("Employer: " + job.getEmployer().getName());
                System.out.println("Job Title: " + job.getTitle());
                System.out.println("Description: " + job.getDescription());
                System.out.println("Salary Range: " + job.getSalaryRange());
                System.out.println("Qualification: " + job.getQualification());
                System.out.println("Skills Required: ");
                for (int j = 1; j <= job.getSkills().getCount(); j++) {
                    System.out.println(" " + j + ". " + job.getSkills().getPosition(j).getName() 
                            + ": " + job.getSkills().getPosition(j).getProficiency());
                }
                System.out.println("--------------------------------------------------");
            }
        }
    }
 
    //display all job postings
    public void viewAllJobs() { 
        if (jobPostings.isEmpty()) {
            System.out.println("No job postings available.");
        } else {
                  
            System.out.println("\n+-------------------------------------------------+");
            System.out.println("|                All Job Postings                 |");
            System.out.println("+-------------------------------------------------+");
            for (int i = 1; i <= jobPostings.getCount(); i++) { 
                JobPosting job = jobPostings.getPosition(i); 
                System.out.println("Employer: " + job.getEmployer().getName());
                System.out.println("Job Title: " + job.getTitle());
                System.out.println("Description: " + job.getDescription());
                System.out.println("Salary Range: " + job.getSalaryRange());
                System.out.println("Qualification: " + job.getQualification());
                System.out.println("Skills Required: ");
                for (int j = 1; j <= job.getSkills().getCount(); j++) {
                    System.out.println(" " + j + ". " + job.getSkills().getPosition(j).getName() 
                            + ": " + job.getSkills().getPosition(j).getProficiency());
                }
                System.out.println("--------------------------------------------------");
            }
        }
    }
    
    public void updatedJobPosting() {
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
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            System.out.println(i + ". " + job.getTitle());
        }

        int choice = 0;
        boolean chooseJob = false;
        while (!chooseJob) {
            System.out.print("\nEnter the job posting number you want to update: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice >= 1 && choice <= jobPostings.getCount()) {
                chooseJob = true;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
            }  
        }

        // Get the job posting to update
        JobPosting jobToUpdate = jobPostings.getPosition(choice);

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
        jobPostings.replacePosition(jobToUpdate, choice);
        System.out.println("Job posting updated successfully!");

        // Display all job postings after updating
        System.out.println("\nUpdated Job Postings:");
        viewAllJobs();
    
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

    public void RemoveJobPosting() {
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
        for (int i = 1; i <= jobPostings.getCount(); i++) {
            JobPosting job = jobPostings.getPosition(i);
            System.out.println(i + ". " + job.getTitle());
        }

        int choice = 0;
        boolean chooseRemoveJob = false;
        while (!chooseRemoveJob) {
            System.out.print("\nEnter the job posting number you want to remove: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice >= 1 && choice <= jobPostings.getCount()) {
                chooseRemoveJob = true;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
            }  
        }

        // Get the job posting to remove
        JobPosting jobToRemove = jobPostings.getPosition(choice);

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
                    jobPostings.deletePosition(choice); 
                    System.out.println("Job posting remove successfully!");
                    System.out.println("\nUpdated Job Postings:");
                    viewAllJobs();
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
        System.out.println("|         Search Job Posting        |");
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
                displayJobDetails(job);
                found = true;
            }
        }
        if (!found) System.out.println("No jobs found with that title in your company.");
    }

    private void searchBySkill(Employer currentEmployer) {
        System.out.print("Enter skill to search: ");
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
                    displayJobDetails(job);
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No jobs require that skill in your company.");
    }

    private void searchBySalary(Employer currentEmployer) {
        System.out.print("Enter minimum salary (e.g., 1000): ");
        double minSalary = scanner.nextDouble();
        System.out.print("Enter maximum salary (e.g., 2000): ");
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
                displayJobDetails(job);
                found = true;
            }
        }
        if (!found) System.out.println("No jobs in that salary range in your company.");
    }

    private void displayJobDetails(JobPosting job) {
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("|               Job Posting Found              |");
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
    }
    
    //end of search job function-----------------------------------------------------------------------
    
    
}