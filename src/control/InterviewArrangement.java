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
import entity.JobApplication;
import entity.JobPosting;
import entity.JobSeeker;
import entity.MatchScore;
import entity.Skill;
import entity.Status;
import entity.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author mings
 */
public class InterviewArrangement {

    private DoublyLinkedListInterface<Interview> interviewList;
    private InterviewInitializer interviewInitializer;
    private DoublyLinkedListInterface<JobApplication> jobApplicationList;

    private DoublyLinkedListInterface<Time> studentTimeList;
    private DoublyLinkedListInterface<JobPosting> studentJobList;
    private DoublyLinkedListInterface<Status> studentStatusList;

    private DoublyLinkedListInterface<Time> companyTimeList;
    private DoublyLinkedListInterface<JobPosting> companyJobList;
    private DoublyLinkedListInterface<JobSeeker> companyJobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList;
    private DoublyLinkedListInterface<Status> companyStatusList;
    
    private DoublyLinkedListInterface<MatchScore> matchList;

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

    public void runInterviewArrangement(DoublyLinkedListInterface<JobPosting> jobList, DoublyLinkedListInterface<JobSeeker> jobSeekerList, DoublyLinkedListInterface<JobApplication> applicationList) {
        interviewList = interviewInitializer.getInterview(jobList, jobSeekerList);
        jobApplicationList = applicationList;

        interviewUI.initializeUI(interviewList);
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
                                && !interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Interviewed")) {
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
                        } else {
                            studentScheduleNum = 6;
                            break;
                        }
                    } else {
                        mergeSortStudent(studentScheduleNum, studentTimeList, studentJobList, studentStatusList);
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
                                && !interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Interviewed")) {
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
                        } else {
                            companyScheduleNum = 7;
                            break;
                        }
                    } else {
                        mergeSortCompany(companyScheduleNum, companyTimeList, companyJobList,
                                companyJobSeekerList, companySkillList, companyStatusList);
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

    public void implementSchedule(Employer employer) {
        int implementNum, selectNum, slot;
        
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        matchList = new DoublyLinkedList<>();
        
        for(int i = 1; i <= jobApplicationList.getCount(); i++){
            companyJobList.insertBack(jobApplicationList.getPosition(i).getMatchScore().getJobPosting());
            companyJobSeekerList.insertBack(jobApplicationList.getPosition(i).getJobSeeker());
            companySkillList.insertBack(jobApplicationList.getPosition(i).getJobSeeker().getSkills());
            matchList.insertBack(jobApplicationList.getPosition(i).getMatchScore());
        }
        
        implementNum = interviewUI.implementUI(companyJobList, companyJobSeekerList, companySkillList, matchList);
        
        if (implementNum == 1) {
            selectNum = interviewUI.numberUI(companyJobList.getCount());
            slot = interviewUI.slotUI(interviewList);
        }
    }

    public void assignScore(Employer employer) {
        int assignNum, scoreNum, score, finalScore, matchScore = 0, continueNum;
        String finalStatus;

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
                            && interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Interviewed")) {
                        companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                        companyJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        companyJobSeekerList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k));
                        companySkillList.insertBack(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills());
                        companyStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                    }
                }
            }
        }

        assignNum = interviewUI.companyAssignUI(companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);

        if (assignNum == 1) {
            scoreNum = interviewUI.numberUI(companyTimeList.getCount());
            score = interviewUI.getScoreUI();

            if (companyTimeList.getCount() != 0) {
                outerloop:
                for (int i = 1; i <= interviewList.getCount(); i++) {
                    for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                        for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                            if (companyTimeList.getPosition(scoreNum).equals(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k))
                                    && companyJobList.getPosition(scoreNum).equals(interviewList.getPosition(i).getJobPostingList().getPosition(j))
                                    && companyJobSeekerList.getPosition(scoreNum).equals(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k))
                                    && companySkillList.getPosition(scoreNum).equals(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills())
                                    && companyStatusList.getPosition(scoreNum).equals(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k))) {
                                for (int l = 1; l <= jobApplicationList.getCount(); l++) {
                                    if (jobApplicationList.getPosition(l).getJobSeeker().equals(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k))
                                            && jobApplicationList.getPosition(l).getMatchScore().getJobPosting().equals(interviewList.getPosition(i).getJobPostingList().getPosition(j))) {
                                        matchScore = jobApplicationList.getPosition(l).getMatchScore().getScore();
                                    }
                                }
                                finalScore = (int) (matchScore * 0.6 + score * 0.4);
                                interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).setScore(finalScore);

                                if (finalScore >= 50) {
                                    finalStatus = "Hired";
                                } else {
                                    finalStatus = "Rejected";
                                }
                                interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).setStatus(finalStatus);

                                continueNum = interviewUI.assignedUI(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k),
                                        interviewList.getPosition(i).getJobPostingList().getPosition(j),
                                        interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k),
                                        interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getSkills(),
                                        interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));

                                if (continueNum == 1) {
                                    assignScore(employer);
                                    break outerloop;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void displayInterviewReport() {

    }
}
