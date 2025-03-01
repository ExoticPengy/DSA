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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        System.out.println("""
                               +----------------------------+
                               |  Internship Application    |
                               +----------------------------+
                               |  1. Job Management         |
                               |  2. Applicant Management   |
                               |  3. Matching Engine        |
                               |  4. Interview Arrangement  |
                               |  5. Exit                   |
                               +----------------------------+
                               """);

        do {
            System.out.print("Enter a choice: ");

            if (sc.hasNextInt()) {
                num = sc.nextInt();

                switch (num) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        interviewArrangement.
                        break;
                    case 5:
                        MessageUI.displayExitMessage();
                        break;
                    default:
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (num != 5);
    }
}
