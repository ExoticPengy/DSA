/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import java.util.Scanner;
import utility.MessageUI;
import control.JobManagement;
import control.ApplicantManagement;
import control.MatchingEngine;
import control.InterviewArrangement;

/**
 *
 * @author mings
 */
public class InternshipApplication {

    private static JobManagement jobManagement = new JobManagement();
    private static ApplicantManagement applicantManagement = new ApplicantManagement();
    private static MatchingEngine matchingEngine = new MatchingEngine();
    private static InterviewArrangement interviewArrangement = new InterviewArrangement();

    private static Scanner sc = new Scanner(System.in);
    private static int num = 0;
    private static boolean isNum = true;

    public static void main(String[] args) {
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
                        studentMenu();
                        break;
                    case 2:
                        companyMenu();
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

    public static void studentMenu() {
        do {
            if (isNum) {
            System.out.println("""
                               \n+------------------------------+
                               |  Student                     |
                               +------------------------------+
                               |  What do you want?           |
                               |  1. Register                 |
                               |  2. Apply Job                |
                               |  3. View Interview Schedule  |
                               |  4. View Result              |
                               |                              |
                               |  5. Exit                     |
                               +------------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isNum = true;

                switch (num) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        interviewArrangement.displayStudentSchedule();
                        break;
                    case 4:
                        interviewArrangement.displayResult();
                        break;
                    case 5:
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
        } while (num != 5);
    }

    public static void companyMenu() {
        do {
            if (isNum) {
            System.out.println("""
                               \n+-------------------------------------+
                               |  Company                            |
                               +-------------------------------------+
                               |  What do you want?                  |
                               |  1. Create Job Posting              |
                               |  2. View Job Applicant              |
                               |  3. Select Candidate for Interview  |
                               |  4. View Interview Schedule         |
                               |  5. View Interview Result           |
                               |                                     |
                               |  6. Exit                            |
                               +-------------------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isNum = true;

                switch (num) {
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
        } while (num != 6);
    }

    public static void adminMenu() {
        do {
            if (isNum) {
            System.out.println("""
                               \n+-------------------------------------+
                               |  Admin                              |
                               +-------------------------------------+
                               |  What do you want?                  |
                               |  1. Update / Remove Job Posting     |
                               |  2. Update / Remove Applicant       |
                               |  3. Job Posting Report              |
                               |  4. Applicant Report                |
                               |  5. Match Report                    |
                               |  6. Interview and Candidate Report  |
                               |                                     |
                               |  7. Exit                            |
                               +-------------------------------------+
                               """);
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isNum = true;

                switch (num) {
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
        } while (num != 7);
    }
}
