/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import control.JobManagement;
import entity.JobPosting;
import java.util.Scanner;

/**
 *
 * @author Elaine
 */
public class JobPostingUI {

    private Scanner scanner = new Scanner(System.in);
    private JobManagement jobManagement; // Declare JobManagement

    // Constructor to initialize JobManagement
    public JobPostingUI(JobManagement jobManagement) {
        this.jobManagement = jobManagement;
    }

    public void displayMenu() {
        while (true) {
            System.out.println("+----------------------------+");
            System.out.println("|      Job Posting Menu      |\n");
            System.out.println("+----------------------------+\n");
            System.out.println("| 1. Create Job Posting      |");
            System.out.println("| 2. Update Job Posting      |");
            System.out.println("| 3. Remove Job Posting      |");
            System.out.println("| 4. Search Jobs             |");
            System.out.println("| 5. Filter Jobs by Location |");
            System.out.println("| 6. View All Jobs           |");
            System.out.println("| 7. Exit                    |");
            System.out.println("+----------------------------+");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    jobManagement.createJobPosting(); 
                    break;
                case 2:
                    //updateJobPosting();
                    break;
                case 3:
                    //removeJobPosting();
                    break;
                case 4:
                    //SearchJobs();
                    break;
                case 5:
                    //filterByLocation();
                    break;
                case 6:
                    jobManagement.viewAllJobs(); 
                    break;
                case 7:
                    System.out.println("Exiting...");
                    //jobManagement.closeScanner(); // Close the scanner
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

