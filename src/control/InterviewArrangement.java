/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import boundary.InterviewArrangementUI;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author mings
 */
public class InterviewArrangement {

    private InterviewArrangementUI interviewArrangementUI;

    private Scanner sc = new Scanner(System.in);

    public InterviewArrangement() {
        interviewArrangementUI = new InterviewArrangementUI();
    }

    public void runInterviewArrangement() {
        int num = 0;

        do {
            interviewArrangementUI.InterviewArrangementMenu();
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        MessageUI.displayInvalidChoiceMessage();
                        break;
                }
            } else {
                MessageUI.displayInvalidCharacterMessage();
                sc.next();
            }
        } while (num != 3);
    }
}
