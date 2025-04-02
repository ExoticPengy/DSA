/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
import entity.Employer;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Skill;
import entity.Status;
import entity.Time;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Taruc
 */
public class InterviewArrangementUI {

    private Scanner sc = new Scanner(System.in);

    public void studentScheduleUI(DoublyLinkedListInterface<Time> studentTimeList, DoublyLinkedListInterface<JobPosting> studentJobList, DoublyLinkedListInterface<Status> studentStatusList) {
        if (studentTimeList.getCount() != 0) {
            System.out.println("\n+--------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Company    | Status     |");
            System.out.println("+--------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= studentTimeList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-10s | %-10s |\n", i, studentTimeList.getPosition(i).getDate(), studentTimeList.getPosition(i).getStartTime(), studentTimeList.getPosition(i).getEndTime(), studentJobList.getPosition(i).getTitle(), studentJobList.getPosition(i).getEmployer().getName(), studentStatusList.getPosition(i).getStatus());
            }
            System.out.println("+--------------------------------------------------------------------------------------------------+");

        } else {
            System.out.println("\nNo interviews scheduled");
        }
        sc.nextLine();
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }

    public void companyScheduleUI(DoublyLinkedListInterface<Time> companyTimeList, DoublyLinkedListInterface<JobPosting> companyJobList, DoublyLinkedListInterface<JobSeeker> companyJobSeekerList, DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList, DoublyLinkedListInterface<Status> companyStatusList) {
        if (companyTimeList.getCount() != 0) {
            System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status     |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= companyTimeList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-15s | %-35s | %-13s %2d | %-10s |\n", i, companyTimeList.getPosition(i).getDate(), companyTimeList.getPosition(i).getStartTime(), companyTimeList.getPosition(i).getEndTime(), companyJobList.getPosition(i).getTitle(), companyJobSeekerList.getPosition(i).getName(), companyJobSeekerList.getPosition(i).getQualification(), companySkillList.getPosition(i).getPosition(1).getName(), companySkillList.getPosition(i).getPosition(1).getProficiency(), companyStatusList.getPosition(i).getStatus());

                for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                    System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |            |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                }
                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }
        } else {
            System.out.println("\nNo interviews scheduled");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }

    public void studentResultUI(DoublyLinkedListInterface<Time> studentTimeList, DoublyLinkedListInterface<JobPosting> studentJobList, DoublyLinkedListInterface<Status> studentStatusList) {
        if (studentTimeList.getCount() != 0) {
            System.out.println("\n+----------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Company    | Status     | Score |");
            System.out.println("+----------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= studentTimeList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-10s | %-10s | %5d |\n", i, studentTimeList.getPosition(i).getDate(), studentTimeList.getPosition(i).getStartTime(), studentTimeList.getPosition(i).getEndTime(), studentJobList.getPosition(i).getTitle(), studentJobList.getPosition(i).getEmployer().getName(), studentStatusList.getPosition(i).getStatus(), studentStatusList.getPosition(i).getScore());
            }
            System.out.println("+----------------------------------------------------------------------------------------------------------+");

        } else {
            System.out.println("\nNo interviews result available");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }

    public void companyResultUI(DoublyLinkedListInterface<Time> companyTimeList, DoublyLinkedListInterface<JobPosting> companyJobList, DoublyLinkedListInterface<JobSeeker> companyJobSeekerList, DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList, DoublyLinkedListInterface<Status> companyStatusList) {
        if (companyTimeList.getCount() != 0) {
            System.out.println("\n+------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status     | Score |");
            System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= companyTimeList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-15s | %-35s | %-13s %2d | %-10s | %5d |\n", i, companyTimeList.getPosition(i).getDate(), companyTimeList.getPosition(i).getStartTime(), companyTimeList.getPosition(i).getEndTime(), companyJobList.getPosition(i).getTitle(), companyJobSeekerList.getPosition(i).getName(), companyJobSeekerList.getPosition(i).getQualification(), companySkillList.getPosition(i).getPosition(1).getName(), companySkillList.getPosition(i).getPosition(1).getProficiency(), companyStatusList.getPosition(i).getStatus(), companyStatusList.getPosition(i).getScore());

                for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                    System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |            |       |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                }
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }
        } else {
            System.out.println("\nNo interviews result available");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }

    public int sortStudentScheduleUI(boolean isNum) {
        if (isNum) {
            System.out.println("\n+--------------------+");
            System.out.println("|  Sort By           |");
            System.out.println("+--------------------+");
            System.out.println("|  1. Date and Time  |");
            System.out.println("|  2. Job Title      |");
            System.out.println("|  3. Company        |");
            System.out.println("|  4. Status         |");
            System.out.println("+--------------------+");
        }
        System.out.print("Enter a choice: ");

        if (sc.hasNextInt()) {
            //isNum = true;
            return sc.nextInt();
        } else {
            //isNum = false;
            MessageUI.displayInvalidCharacterMessage();
            sc.next();
            return -1;
        }
    }
}
