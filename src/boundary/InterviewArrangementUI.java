/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
import entity.Interview;
import entity.JobPosting;
import entity.JobSeeker;
import entity.MatchScore;
import entity.Skill;
import entity.Status;
import entity.Time;
import java.util.InputMismatchException;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Taruc
 */
public class InterviewArrangementUI {

    private Scanner sc = new Scanner(System.in);

    public void initializeUI(DoublyLinkedListInterface<Interview> interviewList) {
        int m = 1;
        System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                          Initialized Interview                                                                          |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getTimeList().getPosition(j).getCount(); k++) {
                    System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-15s | %-35s | %-13s %2d | %-11s | %5d |\n",
                            m,
                            interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(),
                            interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getStartTime(),
                            interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getEndTime(),
                            interviewList.getPosition(i).getJobPostingList().getPosition(j).getTitle(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getQualification(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(1).getName(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(1).getProficiency(),
                            interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus(),
                            interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore());

                    for (int l = 2; l <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getCount(); l++) {
                        System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |             |       |\n", interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(l).getName(), interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(l).getProficiency());
                    }
                    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    m++;
                }
            }
        }
    }

    public int studentScheduleUI(int num,
            DoublyLinkedListInterface<Time> studentTimeList,
            DoublyLinkedListInterface<JobPosting> studentJobList,
            DoublyLinkedListInterface<Status> studentStatusList) {
        if (studentTimeList.getCount() != 0) {
            int j;
            if (num == 1) {
                System.out.println("\n+---------------------------------------------------------------------------------------------------+");
                System.out.println("| No | Date       | Time      | Job Title                                | Company    | Status      |");
                System.out.println("+---------------------------------------------------------------------------------------------------+");

                for (int i = 1; i <= studentTimeList.getCount(); i++) {
                    System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-10s | %-11s |\n",
                            i,
                            studentTimeList.getPosition(i).getDate(),
                            studentTimeList.getPosition(i).getStartTime(),
                            studentTimeList.getPosition(i).getEndTime(),
                            studentJobList.getPosition(i).getTitle(),
                            studentJobList.getPosition(i).getEmployer().getName(),
                            studentStatusList.getPosition(i).getStatus());
                }

                System.out.println("+---------------------------------------------------------------------------------------------------+");
            } else {
                System.out.println("\n+-----------------------------------------------------------------------------------------------------------+");
                System.out.println("| No | Date       | Time      | Job Title                                | Company    | Status      | Score |");
                System.out.println("+-----------------------------------------------------------------------------------------------------------+");

                for (int i = 1; i <= studentTimeList.getCount(); i++) {
                    System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-10s | %-11s | %5d |\n",
                            i,
                            studentTimeList.getPosition(i).getDate(),
                            studentTimeList.getPosition(i).getStartTime(),
                            studentTimeList.getPosition(i).getEndTime(),
                            studentJobList.getPosition(i).getTitle(),
                            studentJobList.getPosition(i).getEmployer().getName(),
                            studentStatusList.getPosition(i).getStatus(),
                            studentStatusList.getPosition(i).getScore());
                }

                System.out.println("+-----------------------------------------------------------------------------------------------------------+");
            }
            System.out.println("|  Sort By           |");
            System.out.println("+--------------------+");
            System.out.println("|  1. Date and Time  |");
            System.out.println("|  2. Job Title      |");
            System.out.println("|  3. Company        |");
            System.out.println("|  4. Status         |");

            if (num == 2) {
                System.out.println("|  5. Score          |");
                j = 6;
            } else {
                j = 5;
            }

            System.out.println("|                    |");
            System.out.println("|  " + j + ". Exit           |");
            System.out.println("+--------------------+\n");

            while (true) {
                System.out.print("Enter a choice: ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        default:
                            if (num == 1) {
                                if (choice >= 1 && choice <= 5) {
                                    return choice;
                                } else {
                                    MessageUI.displayInvalidChoiceMessage();
                                }
                            } else {
                                if (choice >= 1 && choice <= 6) {
                                    return choice;
                                } else {
                                    MessageUI.displayInvalidChoiceMessage();
                                }
                            }
                    }
                } catch (InputMismatchException e) {
                    MessageUI.displayInvalidCharacterMessage();
                    sc.nextLine();
                }
            }
        } else {
            if (num == 1) {
                System.out.println("\nNo interviews scheduled");
            } else {
                System.out.println("\nNo interviews result available");
            }
            MessageUI.pressAnyKeyContinue();
            sc.nextLine();
            return 6;
        }
    }

    public int companyScheduleUI(int num,
            DoublyLinkedListInterface<Time> companyTimeList,
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<Status> companyStatusList) {
        if (companyTimeList.getCount() != 0) {
            int k;
            if (num == 1) {
                System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status      |");
                System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                for (int i = 1; i <= companyTimeList.getCount(); i++) {
                    System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-15s | %-35s | %-13s %2d | %-11s |\n",
                            i,
                            companyTimeList.getPosition(i).getDate(),
                            companyTimeList.getPosition(i).getStartTime(),
                            companyTimeList.getPosition(i).getEndTime(),
                            companyJobList.getPosition(i).getTitle(),
                            companyJobSeekerList.getPosition(i).getName(),
                            companyJobSeekerList.getPosition(i).getQualification(),
                            companySkillList.getPosition(i).getPosition(1).getName(),
                            companySkillList.getPosition(i).getPosition(1).getProficiency(),
                            companyStatusList.getPosition(i).getStatus());

                    for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                        System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |             |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                    }
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                }
            } else {
                scheduleUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
            }
            System.out.println("|  Sort By           |");
            System.out.println("+--------------------+");
            System.out.println("|  1. Date and Time  |");
            System.out.println("|  2. Job Title      |");
            System.out.println("|  3. Applicant      |");
            System.out.println("|  4. Qualification  |");
            System.out.println("|  5. Status         |");
            if (num == 2) {
                System.out.println("|  6. Score          |");
                k = 7;
            } else {
                k = 6;
            }

            System.out.println("|                    |");
            System.out.println("|  " + k + ". Exit           |");
            System.out.println("+--------------------+\n");

            while (true) {
                System.out.print("Enter a choice: ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        default:
                            if (num == 1) {
                                if (choice >= 1 && choice <= 6) {
                                    return choice;
                                } else {
                                    MessageUI.displayInvalidChoiceMessage();
                                }
                            } else {
                                if (choice >= 1 && choice <= 7) {
                                    return choice;
                                } else {
                                    MessageUI.displayInvalidChoiceMessage();
                                }
                            }
                    }
                } catch (InputMismatchException e) {
                    MessageUI.displayInvalidCharacterMessage();
                    sc.nextLine();
                }
            }

        } else {
            if (num == 1) {
                System.out.println("\nNo interviews scheduled");
            } else {
                System.out.println("\nNo interviews result available");
            }
            MessageUI.pressAnyKeyContinue();
            sc.nextLine();
            return 7;
        }
    }

    public void scheduleUI(
            DoublyLinkedListInterface<Time> companyTimeList,
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<Status> companyStatusList) {
        System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 1; i <= companyTimeList.getCount(); i++) {
            System.out.printf("| %02d | %-10s | %4s-%4s | %-40s | %-15s | %-35s | %-13s %2d | %-11s | %5d |\n",
                    i,
                    companyTimeList.getPosition(i).getDate(),
                    companyTimeList.getPosition(i).getStartTime(),
                    companyTimeList.getPosition(i).getEndTime(),
                    companyJobList.getPosition(i).getTitle(),
                    companyJobSeekerList.getPosition(i).getName(),
                    companyJobSeekerList.getPosition(i).getQualification(),
                    companySkillList.getPosition(i).getPosition(1).getName(),
                    companySkillList.getPosition(i).getPosition(1).getProficiency(),
                    companyStatusList.getPosition(i).getStatus(),
                    companyStatusList.getPosition(i).getScore());

            for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |             |       |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
            }
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        }
    }

    public int implementUI(
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<MatchScore> matchList) {
        if (companyJobList.getCount() != 0) {
            System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Job Title                                | Applicant       | Qualification                       | Skills           | Match Score |");
            System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= companyJobList.getCount(); i++) {
                System.out.printf("| %02d | %-40s | %-15s | %-35s | %-13s %2d | %-11s |\n",
                        i,
                        companyJobList.getPosition(i).getTitle(),
                        companyJobSeekerList.getPosition(i).getName(),
                        companyJobSeekerList.getPosition(i).getQualification(),
                        companySkillList.getPosition(i).getPosition(1).getName(),
                        companySkillList.getPosition(i).getPosition(1).getProficiency(),
                        matchList.getPosition(i).getScore());

                for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                    System.out.printf("|    |                                          |                 |                                     | %-13s %2d |             |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                }
                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
            }
            System.out.println("|  Shortlist Candidate?  |");
            System.out.println("+------------------------+");
            System.out.println("|  1. Yes                |");
            System.out.println("|  2. No                 |");
            System.out.println("+------------------------+");
            while (true) {
                System.out.print("Enter a choice: ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            return choice;
                        case 2:
                            return choice;
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                    }
                } catch (InputMismatchException e) {
                    MessageUI.displayInvalidCharacterMessage();
                    sc.nextLine();
                }
            }
        } else {
            System.out.println("\nNo Job Application available");
            MessageUI.pressAnyKeyContinue();
            sc.nextLine();
            return 2;
        }
    }
    
    public int slotUI(DoublyLinkedListInterface<Interview> interviewList){
        System.out.println("+-----------------------------+");
        System.out.println("| Day / | 0900");
        System.out.println("| Time  |");
        System.out.println("+----------------------------------+");
        System.out.println("|  Mon  |");
        System.out.println("");
        System.out.println("");
        return 0;
    }

    public int companyAssignUI(
            DoublyLinkedListInterface<Time> companyTimeList,
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<Status> companyStatusList) {
        if (companyTimeList.getCount() != 0) {
            scheduleUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);

            System.out.println("|  Assign Interview Score?  |");
            System.out.println("+---------------------------+");
            System.out.println("|  1. Yes                   |");
            System.out.println("|  2. No                    |");
            System.out.println("+---------------------------+\n");

            while (true) {
                System.out.print("Enter a choice: ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            return choice;
                        case 2:
                            return choice;
                        default:
                            MessageUI.displayInvalidChoiceMessage();
                    }
                } catch (InputMismatchException e) {
                    MessageUI.displayInvalidCharacterMessage();
                    sc.nextLine();
                }
            }
        } else {
            System.out.println("\nAll scores are assigned.");
            MessageUI.pressAnyKeyContinue();
            sc.nextLine();
            return 2;
        }
    }

    public int numberUI(int listCount) {
        while (true) {
            System.out.print("Enter a number: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    default:
                        if (choice <= listCount) {
                            return choice;
                        } else {
                            MessageUI.displayInvalidChoiceMessage();
                        }
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }

    public int getScoreUI() {
        while (true) {
            System.out.print("Enter interview score: ");
            try {
                int score = sc.nextInt();
                sc.nextLine();
                switch (score) {
                    default:
                        if (score >= 0 && score <= 100) {
                            return score;
                        } else {
                            System.out.println("Score must be between 0 and 100!");
                        }
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }

    public int assignedUI(
            Time companyTime,
            JobPosting companyJob,
            JobSeeker companyJobSeeker,
            DoublyLinkedListInterface<Skill> companySkill,
            Status companyStatus) {
        System.out.println("\n+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No | Date       | Time      | Job Title                                | Applicant       | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| 01 | %-10s | %4s-%4s | %-40s | %-15s | %-35s | %-13s %2d | %-11s | %5d |\n",
                companyTime.getDate(),
                companyTime.getStartTime(),
                companyTime.getEndTime(),
                companyJob.getTitle(),
                companyJobSeeker.getName(),
                companyJobSeeker.getQualification(),
                companySkill.getPosition(1).getName(),
                companySkill.getPosition(1).getProficiency(),
                companyStatus.getStatus(),
                companyStatus.getScore());

        for (int j = 2; j <= companySkill.getCount(); j++) {
            System.out.printf("|    |            |           |                                          |                 |                                     | %-13s %2d |             |       |\n", companySkill.getPosition(j).getName(), companySkill.getPosition(j).getProficiency());
        }
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("Score Assigned Successfully!\n");
        System.out.println("+--------------------+");
        System.out.println("|  Continue Assign?  |");
        System.out.println("+--------------------+");
        System.out.println("|  1. Yes            |");
        System.out.println("|  2. No             |");
        System.out.println("+--------------------+");
        while (true) {
            System.out.print("Enter a choice: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        return choice;
                    case 2:
                        return choice;
                    default:
                        MessageUI.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }
}
