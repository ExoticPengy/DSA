/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InterviewArrangementUI;
import dao.InterviewInitializer;
import entity.Employer;
import entity.Interview;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Skill;
import entity.Status;
import entity.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author mings
 */
public class InterviewArrangement {

    private DoublyLinkedListInterface<Interview> interviewList;
    private InterviewInitializer interviewInitializer;

    private DoublyLinkedListInterface<Time> studentTimeList;
    private DoublyLinkedListInterface<JobPosting> studentJobList;
    private DoublyLinkedListInterface<Status> studentStatusList;

    private DoublyLinkedListInterface<Time> companyTimeList;
    private DoublyLinkedListInterface<JobPosting> companyJobList;
    private DoublyLinkedListInterface<JobSeeker> companyJobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList;
    private DoublyLinkedListInterface<Status> companyStatusList;

    private LocalDate currentDate;
    private DateTimeFormatter formatter;
    private static boolean isNum = true;
    private Scanner sc = new Scanner(System.in);

    private InterviewArrangementUI interviewUI;

    public InterviewArrangement() {
        interviewList = new DoublyLinkedList<>();
        interviewInitializer = new InterviewInitializer();

        currentDate = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        interviewUI = new InterviewArrangementUI();
    }

    public void runInterviewArrangement(DoublyLinkedListInterface<JobPosting> jobList) {
        interviewList = interviewInitializer.getInterview(jobList);
    }

    public void displayStudent(int num, JobSeeker jobSeeker) {
        int studentScheduleNum;

        studentTimeList = new DoublyLinkedList<>();
        studentJobList = new DoublyLinkedList<>();
        studentStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (num == 1) {
                        if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName().equals(jobSeeker.getName()) && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isAfter(currentDate)) {
                            studentTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                            studentJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                            studentStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                            break;
                        }
                    } else {
                        if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName().equals(jobSeeker.getName()) && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)) {
                            studentTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                            studentJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                            studentStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                            break;
                        }
                    }
                }
            }
        }

        do {
            studentScheduleNum = interviewUI.studentScheduleUI(num, studentTimeList, studentJobList, studentStatusList);

            switch (studentScheduleNum) {
                default:
                    if (num == 1) {
                        if (studentScheduleNum >= 1 && studentScheduleNum <= 4) {
                            mergeSortStudent(studentScheduleNum, studentTimeList, studentJobList, studentStatusList);
                        } else if (studentScheduleNum == 5 || studentScheduleNum == 6) {
                            studentScheduleNum = 6;
                            break;
                        } else {
                            isNum = false;
                            MessageUI.displayInvalidChoiceMessage();
                            sc.next();
                            break;
                        }
                    } else {
                        if (studentScheduleNum >= 1 && studentScheduleNum <= 5) {
                            mergeSortStudent(studentScheduleNum, studentTimeList, studentJobList, studentStatusList);
                        } else if (studentScheduleNum == 6) {
                            break;
                        } else {
                            isNum = false;
                            MessageUI.displayInvalidChoiceMessage();
                            sc.next();
                            break;
                        }
                    }
                    break;
            }
        } while (studentScheduleNum != 6);
    }

    public void displayCompany(int num, Employer employer) {
        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName()) && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isAfter(currentDate)) {
                        companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                        companyJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        companyJobSeekerList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k));
                        companySkillList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills());
                        companyStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                    }
                }
            }
        }
        interviewUI.companyScheduleUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
    }

    public void displayCompanyResult(Employer employer) {
        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName()) && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)) {
                        companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                        companyJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        companyJobSeekerList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k));
                        companySkillList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills());
                        companyStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                    }
                }
            }
        }
        interviewUI.companyResultUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
    }

    public void mergeSortStudent(int num, DoublyLinkedListInterface<Time> timeList, DoublyLinkedListInterface<JobPosting> jobList, DoublyLinkedListInterface<Status> statusList) {
        if (timeList.getCount() <= 1) {
            return;
        }

        int mid = timeList.getCount() / 2;

        DoublyLinkedListInterface<Time> leftTime = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Time> rightTime = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobPosting> leftJob = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobPosting> rightJob = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Status> leftStatus = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Status> rightStatus = new DoublyLinkedList<>();

        for (int i = 0; i < mid; i++) {
            leftTime.insertBack(timeList.getPosition(i + 1));
            leftJob.insertBack(jobList.getPosition(i + 1));
            leftStatus.insertBack(statusList.getPosition(i + 1));
        }
        for (int i = mid; i < timeList.getCount(); i++) {
            rightTime.insertBack(timeList.getPosition(i + 1));
            rightJob.insertBack(jobList.getPosition(i + 1));
            rightStatus.insertBack(statusList.getPosition(i + 1));
        }

        mergeSortStudent(num, leftTime, leftJob, leftStatus);
        mergeSortStudent(num, rightTime, rightJob, rightStatus);

        mergeStudent(num, timeList, jobList, statusList, leftTime, rightTime, leftJob, rightJob, leftStatus, rightStatus);
    }

    public void mergeStudent(int num, DoublyLinkedListInterface<Time> timeList, DoublyLinkedListInterface<JobPosting> jobList, DoublyLinkedListInterface<Status> statusList, DoublyLinkedListInterface<Time> leftTime, DoublyLinkedListInterface<Time> rightTime, DoublyLinkedListInterface<JobPosting> leftJob, DoublyLinkedListInterface<JobPosting> rightJob, DoublyLinkedListInterface<Status> leftStatus, DoublyLinkedListInterface<Status> rightStatus) {
        timeList.clear();
        jobList.clear();
        statusList.clear();

        int i = 0, j = 0;

        while (i < leftJob.getCount() && j < rightJob.getCount()) {
            switch (num) {
                case 1:
                    break;
                case 2:
                    if (leftJob.getPosition(i + 1).getTitle().compareTo(rightJob.getPosition(j + 1).getTitle()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                case 3:
                    if (leftJob.getPosition(i + 1).getEmployer().getName().compareTo(rightJob.getPosition(j + 1).getEmployer().getName()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                case 4:
                    if (leftStatus.getPosition(i + 1).getStatus().compareTo(rightStatus.getPosition(j + 1).getStatus()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                default:
                    if (Integer.compare(rightStatus.getPosition(i + 1).getScore(), leftStatus.getPosition(j + 1).getScore()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
            }
        }

        while (i < leftJob.getCount()) {
            timeList.insertBack(leftTime.getPosition(i + 1));
            jobList.insertBack(leftJob.getPosition(i + 1));
            statusList.insertBack(leftStatus.getPosition(i + 1));
            i++;
        }

        while (j < rightJob.getCount()) {
            timeList.insertBack(rightTime.getPosition(j + 1));
            jobList.insertBack(rightJob.getPosition(j + 1));
            statusList.insertBack(rightStatus.getPosition(j + 1));
            j++;
        }
    }

    public void displayInterviewReport() {

    }
}
