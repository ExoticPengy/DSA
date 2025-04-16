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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Chea Ming Shen
 */
public class InterviewArrangementUI {

    private Scanner sc = new Scanner(System.in);

    public String RESET = "\u001B[0m";
    public String RED = "\u001B[31m";
    public String GREEN = "\u001B[32m";

    public void initializeUI(DoublyLinkedListInterface<Interview> interviewList, String title) {
        int m = 1;
        System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|                                                                            %-29s                                                                                      |\n", title);
        System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No  | Date       | Time      | Job Title                                | Company       | Applicant            | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getTimeList().getPosition(j).getCount(); k++) {
                    System.out.printf("| %03d | %-10s | %04d-%4d | %-40s | %-13s | %-20s | %-35s | %-13s %2d | %-11s | %5d |\n",
                            m,
                            interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(),
                            interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getStartTime(),
                            interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getEndTime(),
                            interviewList.getPosition(i).getJobPostingList().getPosition(j).getTitle(),
                            interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getQualification(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(1).getName(),
                            interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(1).getProficiency(),
                            interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus(),
                            interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore());

                    if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getCount() > 1) {
                        for (int l = 2; l <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getCount(); l++) {
                            System.out.printf("|     |            |           |                                          |               |                      |                                     | %-13s %2d |             |       |\n", interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(l).getName(), interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(l).getProficiency());
                        }
                    }
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                    m++;
                }
            }
        }
    }

    public int studentScheduleUI(int num,
            DoublyLinkedListInterface<Time> studentTimeList,
            DoublyLinkedListInterface<JobPosting> studentJobList,
            DoublyLinkedListInterface<Status> studentStatusList) {
        if (!studentTimeList.isEmpty()) {
            int j;
            if (num == 1) {
                System.out.println("\n+------------------------------------------------------------------------------------------------------+");
                System.out.println("| No | Date       | Time      | Job Title                                | Company       | Status      |");
                System.out.println("+------------------------------------------------------------------------------------------------------+");

                for (int i = 1; i <= studentTimeList.getCount(); i++) {
                    System.out.printf("| %02d | %-10s | %04d-%4d | %-40s | %-13s | %-11s |\n",
                            i,
                            studentTimeList.getPosition(i).getDate(),
                            studentTimeList.getPosition(i).getStartTime(),
                            studentTimeList.getPosition(i).getEndTime(),
                            studentJobList.getPosition(i).getTitle(),
                            studentJobList.getPosition(i).getEmployer().getName(),
                            studentStatusList.getPosition(i).getStatus());
                }

                System.out.println("+------------------------------------------------------------------------------------------------------+");
            } else {
                System.out.println("\n+--------------------------------------------------------------------------------------------------------------+");
                System.out.println("| No | Date       | Time      | Job Title                                | Company       | Status      | Score |");
                System.out.println("+--------------------------------------------------------------------------------------------------------------+");

                for (int i = 1; i <= studentTimeList.getCount(); i++) {
                    System.out.printf("| %02d | %-10s | %04d-%4d | %-40s | %-13s | %-11s | %5d |\n",
                            i,
                            studentTimeList.getPosition(i).getDate(),
                            studentTimeList.getPosition(i).getStartTime(),
                            studentTimeList.getPosition(i).getEndTime(),
                            studentJobList.getPosition(i).getTitle(),
                            studentJobList.getPosition(i).getEmployer().getName(),
                            studentStatusList.getPosition(i).getStatus(),
                            studentStatusList.getPosition(i).getScore());
                }

                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
            }
            if (num == 2) {
                j = 6;
            } else {
                j = 5;
            }
            System.out.println("|  Sort By           |  Search     |");
            System.out.println("+--------------------+-------------+");
            System.out.println("|  1. Date and Time  |  " + j + ". Search  |");
            System.out.println("|  2. Job Title      +-------------+");
            System.out.println("|  3. Company        |  " + (j + 1) + ". Exit    |");
            System.out.println("|  4. Status         +-------------+");

            if (num == 2) {
                System.out.println("|  5. Score          |");
            }

            System.out.println("+--------------------+\n");

            while (true) {
                System.out.print("Enter a choice: ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
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
                } catch (InputMismatchException e) {
                    MessageUI.displayInvalidCharacterMessage();
                    sc.nextLine();
                }
            }
        } else {
            switch (num) {
                case 1:
                    System.out.println("\nNo interviews scheduled");
                    break;
                case 2:
                    System.out.println("\nNo interviews result available");
                    break;
                default:
                    System.out.println("\nNo matching results found.");
                    break;
            }
            MessageUI.pressEnterContinue();
            sc.nextLine();
            return 7;
        }
    }

    public int companyScheduleUI(int num,
            DoublyLinkedListInterface<Time> companyTimeList,
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<Status> companyStatusList) {
        if (!companyTimeList.isEmpty()) {
            if (num == 1) {
                System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("| No | Date       | Time      | Job Title                                | Applicant            | Qualification                       | Skills           | Status      |");
                System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                for (int i = 1; i <= companyTimeList.getCount(); i++) {
                    System.out.printf("| %02d | %-10s | %04d-%4s | %-40s | %-20s | %-35s | %-13s %2d | %-11s |\n",
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

                    if (companySkillList.getPosition(i).getCount() > 1) {
                        for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                            System.out.printf("|    |            |           |                                          |                      |                                     | %-13s %2d |             |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                        }
                    }
                    System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                }
            } else {
                scheduleUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
            }

            if (num == 1) {
                System.out.println("|  Sort By           |  Search     |");
                System.out.println("+--------------------+-------------+");
                System.out.println("|  1. Date and Time  |  6. Search  |");
                System.out.println("|  2. Job Title      +-------------+");
                System.out.println("|  3. Applicant      |  7. Exit    |");
                System.out.println("|  4. Qualification  +-------------+");
                System.out.println("|  5. Status         |");
                System.out.println("+--------------------+\n");
            } else {
                System.out.println("|  Sort By           |  Search     |  Filter By Status  |");
                System.out.println("+--------------------+----------------------------------+");
                System.out.println("|  1. Date and Time  |  7. Search  |   9. Interviewed   |");
                System.out.println("|  2. Job Title      +-------------+  10. Hired         |");
                System.out.println("|  3. Applicant      |  8. Exit    |  11. Rejected      |");
                System.out.println("|  4. Qualification  +----------------------------------+");
                System.out.println("|  5. Status         |");
                System.out.println("|  6. Score          |");
                System.out.println("+--------------------+\n");
            }

            while (true) {
                System.out.print("Enter a choice: ");
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if (num == 1) {
                        if (choice >= 1 && choice <= 7) {
                            return choice;
                        } else {
                            MessageUI.displayInvalidChoiceMessage();
                        }
                    } else {
                        if (choice >= 1 && choice <= 11) {
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

        } else {
            switch (num) {
                case 1:
                    System.out.println("\nNo interviews scheduled");
                    break;
                case 2:
                    System.out.println("\nNo interviews result available");
                    break;
                default:
                    System.out.println("\nNo matching results found.");
                    break;
            }
            MessageUI.pressEnterContinue();
            sc.nextLine();
            return 8;
        }
    }

    public void scheduleUI(
            DoublyLinkedListInterface<Time> companyTimeList,
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<Status> companyStatusList) {
        System.out.println("\n+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No | Date       | Time      | Job Title                                | Applicant            | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        for (int i = 1; i <= companyTimeList.getCount(); i++) {
            System.out.printf("| %02d | %-10s | %04d-%4d | %-40s | %-20s | %-35s | %-13s %2d | %-11s | %5d |\n",
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
            if (companySkillList.getPosition(i).getCount() > 1) {
                for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                    System.out.printf("|    |            |           |                                          |                      |                                     | %-13s %2d |             |       |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                }
            }
            System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        }
    }

    public int implementUI(
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<MatchScore> matchList) {
        if (!companyJobList.isEmpty()) {
            System.out.println("\n+---------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("| No | Job Title                                | Applicant            | Qualification                       | Skills           | Match Score |");
            System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
            for (int i = 1; i <= companyJobList.getCount(); i++) {
                System.out.printf("| %02d | %-40s | %-20s | %-35s | %-13s %2d | %-11s |\n",
                        i,
                        companyJobList.getPosition(i).getTitle(),
                        companyJobSeekerList.getPosition(i).getName(),
                        companyJobSeekerList.getPosition(i).getQualification(),
                        companySkillList.getPosition(i).getPosition(1).getName(),
                        companySkillList.getPosition(i).getPosition(1).getProficiency(),
                        matchList.getPosition(i).getScore());
                if (companySkillList.getPosition(i).getCount() > 1) {
                    for (int j = 2; j <= companySkillList.getPosition(i).getCount(); j++) {
                        System.out.printf("|    |                                          |                      |                                     | %-13s %2d |             |\n", companySkillList.getPosition(i).getPosition(j).getName(), companySkillList.getPosition(i).getPosition(j).getProficiency());
                    }
                }
                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
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
            MessageUI.pressEnterContinue();
            sc.nextLine();
            return 2;
        }
    }

    public void monthUI(String monthName, int year, DayOfWeek startDay, int lengthOfMonth, int currentDayOfMonth, String GREEN, String RED, DayOfWeek endDay) {
        System.out.println("\n+-----------------------------+");
        System.out.printf("|     %9s %-9d     |\n", monthName, year);
        System.out.println("+-----------------------------+");
        System.out.println("| Mon Tue Wed Thu Fri Sat Sun |");
        System.out.print("|");

        int value = startDay.getValue();
        for (int i = 1; i < startDay.getValue(); i++) {
            System.out.print("    ");
        }

        for (int dayOfMonth = 1; dayOfMonth <= lengthOfMonth; dayOfMonth++) {
            if (dayOfMonth >= currentDayOfMonth) {
                System.out.print(GREEN);
            } else {
                System.out.print(RED);
            }
            System.out.printf("%4d", dayOfMonth);
            System.out.print(RESET);
            value++;
            if (value > 7) {
                value = 1;
                System.out.print(" |\n|");
            }
        }

        for (int i = 7; i > endDay.getValue(); i--) {
            System.out.print("    ");
        }

        if ((value - 1) != 0) {
            System.out.println(" |");
        }
        System.out.println("+-----------------------------+");
    }

    public int chooseMonthUI(int month, int targetDateMonth) {
        while (true) {
            System.out.print("Choose a month: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == month || choice == targetDateMonth) {
                    return choice;
                } else {
                    System.out.println("Please choose this month or next one only.");
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }

    public int chooseDayUI(int days, int lengthOfMonth, int selectMonth, int month) {
        while (true) {
            System.out.print("Choose a day: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                if (selectMonth == month) {
                    if (choice >= days && choice <= lengthOfMonth) {
                        return choice;
                    } else {
                        System.out.println("Please choose today or a later date only.");
                    }
                } else {
                    if (choice < days && choice >= 1) {
                        return choice;
                    } else {
                        System.out.println("Please choose a day up to one month from today only.");
                    }
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }

    public void slotUI(DoublyLinkedListInterface<Time> companyTimeList, int year, int month, int day) {
        int k = 1;

        System.out.println("\n+-------------+");
        System.out.println("|  Time Slot  |");
        System.out.println("+-------------+");

        for (int i = 900; i <= 1700; i += 100) {
            System.out.printf("|  %02d. ", k);
            System.out.print(GREEN);
            for (int j = 1; j <= companyTimeList.getCount(); j++) {
                if (companyTimeList.getPosition(j).getStartTime() == i
                        && LocalDate.parse(companyTimeList.getPosition(j).getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).getYear() == year
                        && LocalDate.parse(companyTimeList.getPosition(j).getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).getMonthValue() == month
                        && LocalDate.parse(companyTimeList.getPosition(j).getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).getDayOfMonth() == day) {
                    System.out.print(RED);
                    break;
                }
            }
            System.out.printf("%04d", i);
            System.out.print(RESET);
            System.out.println("   |");
            k++;
        }
        System.out.println("+-------------+");
    }

    public int chooseSlotUI() {
        while (true) {
            System.out.print("Enter a slot number: ");
            try {
                int slot = sc.nextInt();
                sc.nextLine();
                if (slot >= 1 && slot <= 9) {
                    return slot;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }

    public void slotChosenUI() {
        System.out.println("Selected slot is assigned. Try another slot.");
    }

    public void newInterviewUI(DoublyLinkedListInterface<Interview> interviewList, int i, int j) {
        int k = interviewList.getPosition(i).getTimeList().getPosition(j).getCount();

        System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No | Date       | Time      | Job Title                                | Company       | Applicant            | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| 01 | %-10s | %04d-%4d | %-40s | %-13s | %-20s | %-35s | %-13s %2d | %-11s | %5d |\n",
                interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(),
                interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getStartTime(),
                interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getEndTime(),
                interviewList.getPosition(i).getJobPostingList().getPosition(j).getTitle(),
                interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName(),
                interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName(),
                interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getQualification(),
                interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(1).getName(),
                interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(1).getProficiency(),
                interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus(),
                interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore());
        if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getCount() > 1) {
            for (int l = 2; l <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getCount(); l++) {
                System.out.printf("|    |            |           |                                          |               |                      |                                     | %-13s %2d |             |       |\n", interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(l).getName(), interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills().getPosition(l).getProficiency());
            }
        }
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        MessageUI.pressEnterContinue();
        sc.nextLine();
    }

    public int companyAssignUI(
            DoublyLinkedListInterface<Time> companyTimeList,
            DoublyLinkedListInterface<JobPosting> companyJobList,
            DoublyLinkedListInterface<JobSeeker> companyJobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList,
            DoublyLinkedListInterface<Status> companyStatusList) {
        if (!companyTimeList.isEmpty()) {
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
            MessageUI.pressEnterContinue();
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
                if (choice <= listCount) {
                    return choice;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
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
                if (score >= 0 && score <= 100) {
                    return score;
                } else {
                    System.out.println("Score must be between 0 and 100!");
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
        System.out.println("\n+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("| No | Date       | Time      | Job Title                                | Applicant            | Qualification                       | Skills           | Status      | Score |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| 01 | %-10s | %04d-%4d | %-40s | %-20s | %-35s | %-13s %2d | %-11s | %5d |\n",
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
        if (companySkill.getCount() > 1) {
            for (int j = 2; j <= companySkill.getCount(); j++) {
                System.out.printf("|    |            |           |                                          |                      |                                     | %-13s %2d |             |       |\n", companySkill.getPosition(j).getName(), companySkill.getPosition(j).getProficiency());
            }
        }
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
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

    public int recruitUI() {
        System.out.println("|  Recruit applicant? |");
        System.out.println("+---------------------+");
        System.out.println("|  1. Yes             |");
        System.out.println("|  2. No              |");
        System.out.println("+---------------------+");

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

    public int recruitApplicantUI(int listCount) {
        while (true) {
            System.out.print("Enter applicant number: ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice <= listCount) {
                    return choice;
                } else {
                    MessageUI.displayInvalidChoiceMessage();
                }
            } catch (InputMismatchException e) {
                MessageUI.displayInvalidCharacterMessage();
                sc.nextLine();
            }
        }
    }

    public void noFilterUI() {
        System.out.println("\nNo selected status.");
    }

    public String searchUI() {
        System.out.print("Search: ");
        return sc.nextLine();
    }

    public void reportHeaderUI(String dateTime, String day) {
        System.out.println("\n+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                               TUNKU ABDUL RAHMAN UNIVERSITY OF MANAGEMENT AND TECHNOLOGY                                 |");
        System.out.println("|                                             INTERNSHIP APPLICATION PROGRAM                                               |");
        System.out.println("|                                                                                                                          |");
        System.out.println("|                                           INTERVIEW ARRANGEMENT MODULE REPORT                                            |");
        System.out.println("|                                        -----------------------------------------                                         |");
        System.out.println("|                                                                                                                          |");
        System.out.printf("|  Generated at: %9s, %18s                                                                             |\n", day, dateTime);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    }

    public void reportScheduleHeaderUI() {
        System.out.println("|                                                                                                                          |");
        System.out.println("|                                                   Interview Schedule                                                     |");
        System.out.println("|                                                ------------------------                                                  |");
    }

    public void reportScheduleContentHeaderUI(String employer) {
        System.out.println("|                                                                                                                          |");
        System.out.printf("|                                                      %-13s                                                       |\n", employer);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|  Job Title                                 |  Date        |  Time       |  Applicant             |  Number of Applicant  |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    }

    public void reportScheduleUI(
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            int num) {
        for (int i = 1; i <= jobList.getCount(); i++) {
            System.out.printf("|  %-40s  |  %-10s  |  %04d-%4d  |  %-20s  |                  %3d  |\n", jobList.getPosition(i).getTitle(), timeList.getPosition(1).getDate(), timeList.getPosition(1).getStartTime(), timeList.getPosition(1).getEndTime(), jobSeekerList.getPosition(1).getName(), num);
            if (jobSeekerList.getCount() > 1) {
                for (int j = 2; j <= jobSeekerList.getCount(); j++) {
                    System.out.printf("|                                            |  %-10s  |  %04d-%4d  |  %-20s  |                       |\n", timeList.getPosition(j).getDate(), timeList.getPosition(j).getStartTime(), timeList.getPosition(j).getEndTime(), jobSeekerList.getPosition(j).getName());
                }
            }
        }
    }
    
    public void reportScheduleNumberUI(
            int positionNum,
            int interviewNum){
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|  Number of positions opened     : %-3d                                                                                    |\n", positionNum);
        System.out.printf("|  Number of interviews scheduled : %-3d                                                                                    |\n", interviewNum);
    }

    public void reportScheduleTotalUI(int positionCount, int interviewCount, int applicantCount) {
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|  Total number of positions opened     : %-3d                                                                              |\n", positionCount);
        System.out.printf("|  Total number of interviews scheduled : %-3d                                                                              |\n", interviewCount);
        System.out.printf("|  Total applicants                     : %-3d                                                                              |\n", applicantCount);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    }

    public void reportHiredHeaderUI() {
        System.out.println("|                                                                                                                          |");
        System.out.println("|                                                  Successful Applicant                                                    |");
        System.out.println("|                                               --------------------------                                                 |");
    }

    public void reportHiredContentHeaderUI(String employer) {
        System.out.println("|                                                                                                                          |");
        System.out.printf("|                                                      %-13s                                                       |\n", employer);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|  Job Title                                              |  Hired Applicant       |  Score  |  Number of Hired Applicant  |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    }

    public void reportHiredUI(
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<Status> statusList,
            int num) {
        for (int i = 1; i <= jobList.getCount(); i++) {
            System.out.printf("|  %-53s  |  %-20s  |    %3d  |                        %3d  |\n", jobList.getPosition(i).getTitle(), jobSeekerList.getPosition(1).getName(), statusList.getPosition(1).getScore(), num);
            if (jobSeekerList.getCount() > 1) {
                for (int j = 2; j <= jobSeekerList.getCount(); j++) {
                    System.out.printf("|                                                         |  %-20s  |    %3d  |                             |\n", jobSeekerList.getPosition(j).getName(), statusList.getPosition(j).getScore());
                }
            }
        }
    }
    
    public void reportHiredNumberUI(int positionNum, int applicantNum){
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|  Number of positions hired  : %-3d                                                                                        |\n", positionNum);
        System.out.printf("|  Number of applicants hired : %-3d                                                                                        |\n", applicantNum);
    }

    public void reportHiredTotalUI(int positionCount, int applicantCount) {
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|  Total number of positions hired  : %-3d                                                                                  |\n",positionCount);
        System.out.printf("|  Total number of applicants hired : %-3d                                                                                  |\n", applicantCount);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
    }

    public void reportFooterUI() {
        System.out.println("|                                                                                                                          |");
        System.out.println("|                                                    END OF THE REPORT                                                     |");
        System.out.println("|                                                                                                                          |");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------+");
        MessageUI.pressEnterContinue();
        sc.nextLine();
    }
}
