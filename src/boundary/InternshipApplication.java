/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
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
                System.out.println("\n"
                        + "+--------------------------+\n"
                        + "|  Internship Application  |\n"
                        + "+--------------------------+\n"
                        + "|  Who are you?            |\n"
                        + "|  1. Student              |\n"
                        + "|  2. Company              |\n"
                        + "|  3. Admin                |\n"
                        + "|                          |\n"
                        + "|  4. Exit                 |\n"
                        + "+--------------------------+\n");
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
                System.out.println("\n"
                        + "+------------------------+\n"
                        + "|  Student               |\n"
                        + "+------------------------+\n"
                        + "|  What is your name?    |\n"
                        + "|  1. Name 1             |\n"
                        + "|  2. Name 2             |\n"
                        + "|  3. Name 3             |\n"
                        + "|                        |\n"
                        + "|  4. Register           |\n"
                        + "|  5. Back to Main Menu  |\n"
                        + "+------------------------+\n");
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
                System.out.println("\n"
                        + "+------------------------+\n"
                        + "|  Name                  |\n"
                        + "+------------------------+\n"
                        + "|  What do you want?     |\n"
                        + "|  1. Apply Job          |\n"
                        + "|  2. View Schedule      |\n"
                        + "|  3. View Result        |\n"
                        + "|                        |\n"
                        + "|  4. Register           |\n"
                        + "|  5. Previous Page      |\n"
                        + "+------------------------+\n");
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

    public static void companyNameMenu(DoublyLinkedListInterface<Employer> employerList) {
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
                System.out.printf("|  %-10s                         |\n", name);
                System.out.println("+-------------------------------------+\n"
                        + "|  What do you want?                  |\n"
                        + "|  1. Create Job Posting              |\n"
                        + "|  2. View Job Applicant              |\n"
                        + "|  3. Select Candidate for Interview  |\n"
                        + "|  4. View Schedule                   |\n"
                        + "|  5. View Result                     |\n"
                        + "|                                     |\n"
                        + "|  6. Previous Page                   |\n"
                        + "+-------------------------------------+\n");
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
                System.out.println("\n"
                        + "+-------------------------------------+\n"
                        + "|  Admin                              |\n"
                        + "+-------------------------------------+\n"
                        + "|  What do you want?                  |\n"
                        + "|  1. Update / Remove Job Posting     |\n"
                        + "|  2. Update / Remove Job Seeker      |\n"
                        + "|  3. Job Posting Report              |\n"
                        + "|  4. Applicant Report                |\n"
                        + "|  5. Match Report                    |\n"
                        + "|  6. Interview Report                |\n"
                        + "|                                     |\n"
                        + "|  7. Back to Main Menu               |\n"
                        + "+-------------------------------------+\n");
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
