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
import entity.JobSeeker;

/**
 *
 * @author Chea Ming Shen
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
        employerManagement.initializeEmployer();
        
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
                        applicantManagement.runApplicantManagement();
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

    public static void studentNameMenu(DoublyLinkedListInterface<JobSeeker> jobSeekerList) {
        int studentNameNum = 0;

        do {
            if (isNum) {
                int i;
                System.out.println("\n+------------------------+");
                System.out.println("|  Student               |");
                System.out.println("+------------------------+");
                System.out.println("|  What is your name?    |");
                for (i = 1; i <= jobSeekerList.getCount(); i++) {
                    System.out.printf("|  %d. %-15s    |\n", i, jobSeekerList.getPosition(i).getName());
                }
                System.out.println("|                        |");
                System.out.println("|  " + i++ + ". Register           |");
                System.out.println("|  " + i++ + ". Back to Main Menu  |");
                System.out.println("+------------------------+\n");
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                studentNameNum = sc.nextInt();
                isNum = true;

                switch (studentNameNum) {
                    default:
                        if (studentNameNum >= 1 && studentNameNum <= jobSeekerList.getCount()) {
                            studentMenu(jobSeekerList.getPosition(studentNameNum));
                        } else if (studentNameNum == jobSeekerList.getCount() + 1) {
                            //applicant management create profile
                        } else if (studentNameNum == jobSeekerList.getCount() + 2) {

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
        } while (studentNameNum != jobSeekerList.getCount() + 2);
    }

    public static void studentMenu(JobSeeker jobSeeker) {
        int studentNum = 0;

        do {
            if (isNum) {
                System.out.println("\n+------------------------+");
                System.out.printf("|  %-15s       |\n", jobSeeker.getName());
                System.out.println("+------------------------+");
                System.out.println("|  What do you want?     |");
                System.out.println("|  1. Apply Job          |");
                System.out.println("|  2. View Schedule      |");
                System.out.println("|  3. View Result        |");
                System.out.println("|                        |");
                System.out.println("|  4. Previous Page      |");
                System.out.println("+------------------------+\n");
            }
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                studentNum = sc.nextInt();
                isNum = true;

                switch (studentNum) {
                    case 1:
                        //matchingEngine
                        break;
                    case 2:
                        interviewArrangement.displayStudentSchedule(jobSeeker);
                        break;
                    case 3:
                        interviewArrangement.displayStudentResult(jobSeeker);
                        break;
                    case 4:
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
        } while (studentNum != 4);
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
                            companyMenu(employerList.getPosition(companyNameNum));
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

    public static void companyMenu(Employer employer) {
        int companyNum = 0;
        jobManagement.runJobManagement(employerManagement.getEmployerList());
        do {
            if (isNum) {
                System.out.println("\n+-------------------------------------+");
                System.out.printf("|  %-10s                         |\n", employer.getName());
                System.out.println("+-------------------------------------+\n"
                        + "|  What do you want?                  |\n"
                        + "|  1. Job Posting                     |\n"
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
                        //jobManagement.createJobPosting(employer);
                        //jobManagement.viewEmployerJobPosting(employer);
                        jobManagement.searchJobs(employer);
                        break;
                    case 2:
                        //applicant management module
                        break;
                    case 3:
                        //matching engine module
                        break;
                    case 4:
                        interviewArrangement.displayCompanySchedule(employer);
                        break;
                    case 5:
                        interviewArrangement.displayCompanyResult(employer);
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
                        //job management module
                        break;
                    case 2:
                        //applicant management module
                        break;
                    case 3:
                        //job management module
                        break;
                    case 4:
                        //applicant management module
                        break;
                    case 5:
                        //matching engine module
                        break;
                    case 6:
                        interviewArrangement.displayInterviewReport();
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
