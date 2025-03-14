/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
import entity.Skill;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Taruc
 */
public class InterviewArrangementUI {

    private Scanner sc = new Scanner(System.in);

    public void studentScheduleUI(DoublyLinkedListInterface<String> studentDateList, DoublyLinkedListInterface<String> studentTimeList, DoublyLinkedListInterface<String> studentJobList, DoublyLinkedListInterface<String> studentCompanyList, DoublyLinkedListInterface<String> studentStatusList) {
        if (studentDateList.getCount() != 0) {
            System.out.println("\n+--------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Company    | Status     |");
            System.out.println("+--------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= studentDateList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %9s | %-40s | %-10s | %-10s |\n", i, studentDateList.getPosition(i), studentTimeList.getPosition(i), studentJobList.getPosition(i), studentCompanyList.getPosition(i), studentStatusList.getPosition(i));
            }
            System.out.println("+--------------------------------------------------------------------------------------------------+");

        } else {
            System.out.println("\nNo interviews scheduled");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }

    public void companyScheduleUI(DoublyLinkedListInterface<String> companyDateList, DoublyLinkedListInterface<String> companyTimeList, DoublyLinkedListInterface<String> companyJobList, DoublyLinkedListInterface<String> companyJobSeekerList, DoublyLinkedListInterface<String> companyQualificationList, DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList, DoublyLinkedListInterface<String> companyStatusList) {
        if (companyDateList.getCount() != 0) {
            System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status     |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= companyDateList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %9s | %-40s | %-15s | %-35s | %-13s %2d | %-10s |\n", i, companyDateList.getPosition(i), companyTimeList.getPosition(i), companyJobList.getPosition(i), companyJobSeekerList.getPosition(i), companyQualificationList.getPosition(i), companySkillList.getPosition(i).getPosition(1).getName(), companySkillList.getPosition(i).getPosition(1).getProficiency(), companyStatusList.getPosition(i));

                for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                    System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |            |\n", companySkillList.getPosition(i).getPosition(j).getName(),companySkillList.getPosition(i).getPosition(j).getProficiency());
                }
                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }
        } else {
            System.out.println("\nNo interviews scheduled");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }

    public void studentResultUI(DoublyLinkedListInterface<String> studentDateList, DoublyLinkedListInterface<String> studentTimeList, DoublyLinkedListInterface<String> studentJobList, DoublyLinkedListInterface<String> studentCompanyList, DoublyLinkedListInterface<String> studentStatusList, DoublyLinkedListInterface<Integer> studentScoreList) {
        if (studentDateList.getCount() != 0) {
            System.out.println("\n+----------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Company    | Status     | Score |");
            System.out.println("+----------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= studentDateList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %9s | %-40s | %-10s | %-10s | %5d |\n", i, studentDateList.getPosition(i), studentTimeList.getPosition(i), studentJobList.getPosition(i), studentCompanyList.getPosition(i), studentStatusList.getPosition(i), studentScoreList.getPosition(i));
            }
            System.out.println("+----------------------------------------------------------------------------------------------------------+");

        } else {
            System.out.println("\nNo interviews scheduled");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }
    
    public void companyResultUI(DoublyLinkedListInterface<String> companyDateList, DoublyLinkedListInterface<String> companyTimeList, DoublyLinkedListInterface<String> companyJobList, DoublyLinkedListInterface<String> companyJobSeekerList, DoublyLinkedListInterface<String> companyQualificationList, DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList, DoublyLinkedListInterface<String> companyStatusList, DoublyLinkedListInterface<Integer> companyScoreList) {
        if (companyDateList.getCount() != 0) {
            System.out.println("\n+------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status     | Score |");
            System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= companyDateList.getCount(); i++) {
                System.out.printf("| %02d | %-10s | %9s | %-40s | %-15s | %-35s | %-13s %2d | %-10s | %5d |\n", i, companyDateList.getPosition(i), companyTimeList.getPosition(i), companyJobList.getPosition(i), companyJobSeekerList.getPosition(i), companyQualificationList.getPosition(i), companySkillList.getPosition(i).getPosition(1).getName(), companySkillList.getPosition(i).getPosition(1).getProficiency(), companyStatusList.getPosition(i), companyScoreList.getPosition(i));

                for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                    System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |            |       |\n", companySkillList.getPosition(i).getPosition(j).getName(),companySkillList.getPosition(i).getPosition(j).getProficiency());
                }
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }
        } else {
            System.out.println("\nNo interviews scheduled");
        }
        MessageUI.pressAnyKeyContinue();
        sc.nextLine();
    }
}
