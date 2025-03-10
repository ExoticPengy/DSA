/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedList;
import java.util.Scanner;
import utility.MessageUI;
import control.JobManagement;
import control.ApplicantManagement;
import control.MatchingEngine;
import control.InterviewArrangement;
import control.EmployerManagement;
import entity.Employer;

/**
 *
 * @author mings
 */
public class InternshipApplication {

    private static JobManagement jobManagement = new JobManagement();
    private static ApplicantManagement applicantManagement = new ApplicantManagement();
    private static MatchingEngine matchingEngine = new MatchingEngine();
    private static InterviewArrangement interviewArrangement = new InterviewArrangement();
    private static EmployerManagement employerManagement = new EmployerManagement();

    private static Scanner sc = new Scanner(System.in);
    private static boolean isNum = true;

    public static void main(String[] args) {
        int num = 0;

        do {
            if (isNum) {
                System.out.println("""
                               \n+--------------------------+
                               |  Internship Application  |
                               +--------------------------+
                               |  Who are you?            |
                               |  1. Student              |
                               |  2. Company              |
                               |  3. Admin                |
                               |                          |
                               |  4. Exit                 |
                               +--------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isNum = true;

                switch (num) {
                    case 1:
                        studentNameMenu();
                        break;
                    case 2:
                        employerManagement.runEmployerManagement();
                        break;
                    case 3:
                        adminMenu();
                        break;
                    case 4:
                        MessageUI.displayExitMessage();
                        break;
                    default:
                        isNum = false;
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                isNum = false;
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (num != 4);
    }

    public static void studentNameMenu() {
        int studentNameNum = 0;

        do {
            if (isNum) {
                System.out.println("""
                               \n+------------------------+
                               |  Student               |
                               +------------------------+
                               |  What is your name?    |
                               |  1. Name 1             |              
                               |  2. Name 2             |
                               |  3. Name 3             |
                               |                        |
                               |  4. Register           |
                               |  5. Back to Main Menu  |
                               +------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                studentNameNum = sc.nextInt();
                isNum = true;

                switch (studentNameNum) {
                    case 1:
                        //studentMenu();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        isNum = false;
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                isNum = false;
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (studentNameNum != 5);
    }

    public static void studentMenu(String name) {
        int studentNum = 0;

        do {
            if (isNum) {
                System.out.println("""
                               \n+------------------------+
                               |  Name                  |
                               +------------------------+
                               |  What do you want?     |
                               |  1. Apply Job          |              
                               |  2. View Schedule      |
                               |  3. View Result        |
                               |                        |
                               |  4. Register           |
                               |  5. Previous Page      |
                               +------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                studentNum = sc.nextInt();
                isNum = true;

                switch (studentNum) {
                    case 1:
                        break;
                    case 2:
                        //interviewArrangement.displayStudentSchedule();
                        break;
                    case 3:
                        //interviewArrangement.displayResult();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        isNum = false;
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                isNum = false;
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (studentNum != 5);
    }

    public static void companyNameMenu(DoublyLinkedList<Employer> employerList) {
        int companyNameNum = 0;

        do {
            if (isNum) {
                int i;

                System.out.println("\n+-------------------------+");
                System.out.println("|  Company                |");
                System.out.println("+-------------------------+");
                System.out.println("|  What is your company?  |");
                for (i = 1; i <= employerList.getCount(); i++) {
                    System.out.printf("|  %d. %-13s       |\n", i, employerList.getPosition(i).getName());
                }
                System.out.println("|                         |");
                System.out.println("|  " + i++ + ". Back to Main Menu   |");
                System.out.println("+-------------------------+");
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                companyNameNum = sc.nextInt();
                isNum = true;

                switch (companyNameNum) {
                    default:
                        if (companyNameNum >= 1 && companyNameNum <= employerList.getCount()) {
                            companyMenu(employerList.getPosition(companyNameNum).getName());
                        } else if (companyNameNum == employerList.getCount() + 1) {

                        } else {
                            isNum = false;
                            MessageUI.displayInvalidChoiceMessage();
                        }
                        break;
                }
            } else {
                isNum = false;
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (companyNameNum != employerList.getCount() + 1);
    }

    public static void companyMenu(String name) {
        int companyNum = 0;

        do {
            if (isNum) {
                System.out.println("\n+-------------------------------------+");
                System.out.printf("|  %-10s                         |\n",name);
                System.out.println("""
                               +-------------------------------------+
                               |  What do you want?                  |
                               |  1. Create Job Posting              |
                               |  2. View Job Applicant              |
                               |  3. Select Candidate for Interview  |
                               |  4. View Schedule                   |
                               |  5. View Result                     |
                               |                                     |
                               |  6. Previous Page                   |
                               +-------------------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                companyNum = sc.nextInt();
                isNum = true;

                switch (companyNum) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        interviewArrangement.displayCompanySchedule();
                        break;
                    case 5:
                        interviewArrangement.displayInterviewResult();
                        break;
                    case 6:
                        break;
                    default:
                        isNum = false;
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                isNum = false;
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (companyNum != 6);
    }

    public static void adminMenu() {
        int adminNum = 0;

        do {
            if (isNum) {
                System.out.println("""
                               \n+-------------------------------------+
                               |  Admin                              |
                               +-------------------------------------+
                               |  What do you want?                  |
                               |  1. Update / Remove Job Posting     |
                               |  2. Update / Remove Job Seeker      |
                               |  3. Job Posting Report              |
                               |  4. Applicant Report                |
                               |  5. Match Report                    |
                               |  6. Interview Report                |
                               |                                     |
                               |  7. Back to Main Menu               |
                               +-------------------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                adminNum = sc.nextInt();
                isNum = true;

                switch (adminNum) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    default:
                        isNum = false;
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                isNum = false;
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (adminNum != 7);
    }
}
