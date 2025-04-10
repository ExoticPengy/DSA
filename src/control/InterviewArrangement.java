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
import java.time.LocalDateTime;
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
    private LocalDateTime leftDateTime, rightDateTime;
    private DateTimeFormatter formatter, formatter2;
    private static boolean isNum = true;
    private Scanner sc = new Scanner(System.in);

    private InterviewArrangementUI interviewUI;

    public InterviewArrangement() {
        interviewList = new DoublyLinkedList<>();
        interviewInitializer = new InterviewInitializer();

        currentDate = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyyHHmm");

        interviewUI = new InterviewArrangementUI();
    }

    public void runInterviewArrangement(DoublyLinkedListInterface<JobPosting> jobList, DoublyLinkedListInterface<JobSeeker> jobSeekerList) {
        interviewList = interviewInitializer.getInterview(jobList, jobSeekerList);
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
                        if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName().equals(jobSeeker.getName())
                                && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isAfter(currentDate)) {
                            studentTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                            studentJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                            studentStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                            break;
                        }
                    } else {
                        if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName().equals(jobSeeker.getName())
                                && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)
                                && interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore() != -1) {
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
                        } else if (studentScheduleNum == -2) {
                            break;
                        } else {
                            isNum = false;
                            MessageUI.displayInvalidChoiceMessage();
                            sc.nextLine();
                            sc.nextLine();
                            break;
                        }
                    } else {
                        if (studentScheduleNum >= 1 && studentScheduleNum <= 5) {
                            mergeSortStudent(studentScheduleNum, studentTimeList, studentJobList, studentStatusList);
                        } else if (studentScheduleNum == 6) {
                            break;
                        } else if (studentScheduleNum == -2) {
                            break;
                        } else {
                            isNum = false;
                            MessageUI.displayInvalidChoiceMessage();
                            sc.nextLine();
                            sc.nextLine();
                            break;
                        }
                    }
                    break;
            }
        } while (studentScheduleNum != 6);
    }

    public void displayCompany(int num, Employer employer) {
        int companyScheduleNum;

        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (num == 1) {
                        if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName())
                                && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isAfter(currentDate)) {
                            companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                            companyJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                            companyJobSeekerList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k));
                            companySkillList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills());
                            companyStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                        }
                    } else {
                        if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName())
                                && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)
                                && interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore() != -1) {
                            companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                            companyJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                            companyJobSeekerList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k));
                            companySkillList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills());
                            companyStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                        }
                    }
                }
            }
        }

        do {
            companyScheduleNum = interviewUI.companyScheduleUI(num, companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);

            switch (companyScheduleNum) {
                default:
                    if (num == 1) {
                        if (companyScheduleNum >= 1 && companyScheduleNum <= 5) {
                            mergeSortCompany(companyScheduleNum, companyTimeList, companyJobList,
                                    companyJobSeekerList, companySkillList, companyStatusList);
                        } else if (companyScheduleNum == 6 || companyScheduleNum == 7) {
                            companyScheduleNum = 7;
                            break;
                        } else {
                            isNum = false;
                            MessageUI.displayInvalidChoiceMessage();
                            sc.next();
                            break;
                        }
                    } else {
                        if (companyScheduleNum >= 1 && companyScheduleNum <= 6) {
                            mergeSortCompany(companyScheduleNum, companyTimeList, companyJobList,
                                    companyJobSeekerList, companySkillList, companyStatusList);
                        } else if (companyScheduleNum == 7) {
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
        } while (companyScheduleNum != 7);
    }

    public void mergeSortStudent(int num,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<Status> statusList) {
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

    public void mergeStudent(int num,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<Status> statusList,
            DoublyLinkedListInterface<Time> leftTime,
            DoublyLinkedListInterface<Time> rightTime,
            DoublyLinkedListInterface<JobPosting> leftJob,
            DoublyLinkedListInterface<JobPosting> rightJob,
            DoublyLinkedListInterface<Status> leftStatus,
            DoublyLinkedListInterface<Status> rightStatus) {
        timeList.clear();
        jobList.clear();
        statusList.clear();

        int i = 0, j = 0;

        while (i < leftJob.getCount() && j < rightJob.getCount()) {
            switch (num) {
                case 1:
                    leftDateTime = LocalDateTime.parse(leftTime.getPosition(i + 1).getDate() + leftTime.getPosition(i + 1).getStartTime(), formatter2);
                    rightDateTime = LocalDateTime.parse(rightTime.getPosition(j + 1).getDate() + rightTime.getPosition(j + 1).getStartTime(), formatter2);

                    if (leftDateTime.isBefore(rightDateTime)) {
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

    public void mergeSortCompany(int num,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> skillList,
            DoublyLinkedListInterface<Status> statusList) {
        if (timeList.getCount() <= 1) {
            return;
        }

        int mid = timeList.getCount() / 2;

        DoublyLinkedListInterface<Time> leftTime = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Time> rightTime = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobPosting> leftJob = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobPosting> rightJob = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobSeeker> leftJobSeeker = new DoublyLinkedList<>();
        DoublyLinkedListInterface<JobSeeker> rightJobSeeker = new DoublyLinkedList<>();
        DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> leftSkill = new DoublyLinkedList<>();
        DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> rightSkill = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Status> leftStatus = new DoublyLinkedList<>();
        DoublyLinkedListInterface<Status> rightStatus = new DoublyLinkedList<>();

        for (int i = 0; i < mid; i++) {
            leftTime.insertBack(timeList.getPosition(i + 1));
            leftJob.insertBack(jobList.getPosition(i + 1));
            leftJobSeeker.insertBack(jobSeekerList.getPosition(i + 1));
            leftSkill.insertBack(skillList.getPosition(i + 1));
            leftStatus.insertBack(statusList.getPosition(i + 1));
        }
        for (int i = mid; i < timeList.getCount(); i++) {
            rightTime.insertBack(timeList.getPosition(i + 1));
            rightJob.insertBack(jobList.getPosition(i + 1));
            rightJobSeeker.insertBack(jobSeekerList.getPosition(i + 1));
            rightSkill.insertBack(skillList.getPosition(i + 1));
            rightStatus.insertBack(statusList.getPosition(i + 1));
        }

        mergeSortCompany(num, leftTime, leftJob, leftJobSeeker, leftSkill, leftStatus);
        mergeSortCompany(num, rightTime, rightJob, rightJobSeeker, rightSkill, rightStatus);

        mergeCompany(num, timeList, jobList, jobSeekerList, skillList, statusList, leftTime, rightTime, leftJob, rightJob, leftJobSeeker, rightJobSeeker, leftSkill, rightSkill, leftStatus, rightStatus);
    }

    public void mergeCompany(int num,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> skillList,
            DoublyLinkedListInterface<Status> statusList,
            DoublyLinkedListInterface<Time> leftTime,
            DoublyLinkedListInterface<Time> rightTime,
            DoublyLinkedListInterface<JobPosting> leftJob,
            DoublyLinkedListInterface<JobPosting> rightJob,
            DoublyLinkedListInterface<JobSeeker> leftJobSeeker,
            DoublyLinkedListInterface<JobSeeker> rightJobSeeker,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> leftSkill,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> rightSkill,
            DoublyLinkedListInterface<Status> leftStatus,
            DoublyLinkedListInterface<Status> rightStatus) {
        timeList.clear();
        jobList.clear();
        jobSeekerList.clear();
        skillList.clear();
        statusList.clear();

        int i = 0, j = 0;

        while (i < leftJob.getCount() && j < rightJob.getCount()) {
            switch (num) {
                case 1:
                    leftDateTime = LocalDateTime.parse(leftTime.getPosition(i + 1).getDate() + leftTime.getPosition(i + 1).getStartTime(), formatter2);
                    rightDateTime = LocalDateTime.parse(rightTime.getPosition(j + 1).getDate() + rightTime.getPosition(j + 1).getStartTime(), formatter2);

                    if (leftDateTime.isBefore(rightDateTime)) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
                        skillList.insertBack(leftSkill.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
                        skillList.insertBack(rightSkill.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                case 2:
                    if (leftJob.getPosition(i + 1).getTitle().compareTo(rightJob.getPosition(j + 1).getTitle()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
                        skillList.insertBack(leftSkill.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
                        skillList.insertBack(rightSkill.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                case 3:
                    if (leftJobSeeker.getPosition(i + 1).getName().compareTo(rightJobSeeker.getPosition(j + 1).getName()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
                        skillList.insertBack(leftSkill.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
                        skillList.insertBack(rightSkill.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                case 4:
                    if (leftJobSeeker.getPosition(i + 1).getQualification().compareTo(rightJobSeeker.getPosition(j + 1).getQualification()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
                        skillList.insertBack(leftSkill.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
                        skillList.insertBack(rightSkill.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                case 5:
                    if (leftStatus.getPosition(i + 1).getStatus().compareTo(rightStatus.getPosition(j + 1).getStatus()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
                        skillList.insertBack(leftSkill.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
                        skillList.insertBack(rightSkill.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
                default:
                    if (Integer.compare(rightStatus.getPosition(i + 1).getScore(), leftStatus.getPosition(j + 1).getScore()) <= 0) {
                        timeList.insertBack(leftTime.getPosition(i + 1));
                        jobList.insertBack(leftJob.getPosition(i + 1));
                        jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
                        skillList.insertBack(leftSkill.getPosition(i + 1));
                        statusList.insertBack(leftStatus.getPosition(i + 1));
                        i++;
                    } else {
                        timeList.insertBack(rightTime.getPosition(j + 1));
                        jobList.insertBack(rightJob.getPosition(j + 1));
                        jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
                        skillList.insertBack(rightSkill.getPosition(j + 1));
                        statusList.insertBack(rightStatus.getPosition(j + 1));
                        j++;
                    }
                    break;
            }
        }

        while (i < leftJob.getCount()) {
            timeList.insertBack(leftTime.getPosition(i + 1));
            jobList.insertBack(leftJob.getPosition(i + 1));
            jobSeekerList.insertBack(leftJobSeeker.getPosition(i + 1));
            skillList.insertBack(leftSkill.getPosition(i + 1));
            statusList.insertBack(leftStatus.getPosition(i + 1));
            i++;
        }

        while (j < rightJob.getCount()) {
            timeList.insertBack(rightTime.getPosition(j + 1));
            jobList.insertBack(rightJob.getPosition(j + 1));
            jobSeekerList.insertBack(rightJobSeeker.getPosition(j + 1));
            skillList.insertBack(rightSkill.getPosition(j + 1));
            statusList.insertBack(rightStatus.getPosition(j + 1));
            j++;
        }
    }

    public void implementSchedule(){
        
    }
    
    public void assignScore(Employer employer) {
        int assignNum;

        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName())
                            && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)
                            && interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore() == -1) {
                        companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                        companyJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        companyJobSeekerList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k));
                        companySkillList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills());
                        companyStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                    }
                }
            }
        }
        
        assignNum = interviewUI.companyScoreUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
    }

    public void displayInterviewReport() {

    }
}
