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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import utility.MessageUI;

/**
 *
 * @author Chea Ming Shen
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

    private DoublyLinkedListInterface<Time> searchTimeList;
    private DoublyLinkedListInterface<JobPosting> searchJobList;
    private DoublyLinkedListInterface<JobSeeker> searchJobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> searchSkillList;
    private DoublyLinkedListInterface<Status> searchStatusList;

    private DoublyLinkedListInterface<Time> filterTimeList;
    private DoublyLinkedListInterface<JobPosting> filterJobList;
    private DoublyLinkedListInterface<JobSeeker> filterJobSeekerList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> filterSkillList;
    private DoublyLinkedListInterface<Status> filterStatusList;

    private DoublyLinkedListInterface<Employer> interviewEmployerList;
    private DoublyLinkedListInterface<Time> interviewTimeList;
    private DoublyLinkedListInterface<JobPosting> interviewJobList;
    private DoublyLinkedListInterface<JobSeeker> interviewJobSeekerList;

    private DoublyLinkedListInterface<Employer> hiredEmployerList;
    private DoublyLinkedListInterface<JobPosting> hiredJobList;
    private DoublyLinkedListInterface<JobSeeker> hiredJobSeekerList;
    private DoublyLinkedListInterface<Status> hiredStatusList;

    private DoublyLinkedListInterface<MatchScore> matchList;

    private LocalDate currentDate;
    private LocalDateTime leftDateTime, rightDateTime;
    private DateTimeFormatter formatter, formatter2, formatter3;

    private Scanner sc = new Scanner(System.in);

    private InterviewArrangementUI interviewUI;

    public InterviewArrangement() {
        interviewList = new DoublyLinkedList<>();
        interviewInitializer = new InterviewInitializer();

        currentDate = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyyHHmm");
        formatter3 = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");

        interviewUI = new InterviewArrangementUI();
    }

    public void runInterviewArrangement(DoublyLinkedListInterface<JobPosting> jobList, DoublyLinkedListInterface<JobSeeker> jobSeekerList, DoublyLinkedListInterface<JobApplication> applicationList) {
        interviewList = interviewInitializer.getInterview(jobList, jobSeekerList);
        jobApplicationList = applicationList;

        interviewUI.initializeUI(interviewList,"Initialized Interview");

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getTimeList().getPosition(j).getCount(); k++) {
                    if (LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)
                            && !interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Hired")
                            && !interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Rejected")) {
                        interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).setStatus("Interviewed");
                    } else if (LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).equals(currentDate)
                            && interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getEndTime() < Integer.parseInt(LocalTime.now().format(DateTimeFormatter.ofPattern("HHmm")))
                            && !interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Hired")
                            && !interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Rejected")) {
                        interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).setStatus("Interviewed");
                    }
                }
            }
        }

        interviewUI.initializeUI(interviewList, "Updated Initialized Interview");
    }

    public void displayStudent(int num, JobSeeker jobSeeker) {
        int studentScheduleNum;
        String search;

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

            if (num == 1) {
                if (studentScheduleNum >= 1 && studentScheduleNum <= 4) {
                    mergeSortStudent(studentScheduleNum, studentTimeList, studentJobList, studentStatusList);
                } else if (studentScheduleNum == 5) {
                    search = interviewUI.searchUI();
                    searchStudent(1, search, studentTimeList, studentJobList, studentStatusList);
                    if (studentTimeList.isEmpty()) {
                        num = 3;
                    }
                } else {
                    studentScheduleNum = 7;
                    break;
                }
            } else if (num == 2) {
                if (studentScheduleNum >= 1 && studentScheduleNum <= 5) {
                    mergeSortStudent(studentScheduleNum, studentTimeList, studentJobList, studentStatusList);
                } else if (studentScheduleNum == 6) {
                    search = interviewUI.searchUI();
                    searchStudent(2, search, studentTimeList, studentJobList, studentStatusList);
                    if (studentTimeList.isEmpty()) {
                        num = 3;
                    }
                }
            }
        } while (studentScheduleNum != 7);
    }

    public void displayCompany(int num, Employer employer) {
        int companyScheduleNum;
        String search;

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
                                && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isBefore(currentDate)) {
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

            if (num == 1) {
                if (companyScheduleNum >= 1 && companyScheduleNum <= 5) {
                    mergeSortCompany(companyScheduleNum, companyTimeList, companyJobList,
                            companyJobSeekerList, companySkillList, companyStatusList);
                } else if (companyScheduleNum == 6) {
                    search = interviewUI.searchUI();
                    searchCompany(1, search, companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
                    if (companyTimeList.isEmpty()) {
                        num = 3;
                    }
                } else {
                    companyScheduleNum = 8;
                    break;
                }
            } else {
                if (companyScheduleNum >= 1 && companyScheduleNum <= 6) {
                    mergeSortCompany(companyScheduleNum, companyTimeList, companyJobList,
                            companyJobSeekerList, companySkillList, companyStatusList);
                } else if (companyScheduleNum == 7) {
                    search = interviewUI.searchUI();
                    searchCompany(1, search, companyTimeList, companyJobList, companyJobSeekerList, companySkillList, companyStatusList);
                    if (companyTimeList.isEmpty()) {
                        num = 3;
                    }
                } else if (companyScheduleNum >= 9 && companyScheduleNum <= 11) {
                    filterStatus(companyScheduleNum, companyTimeList, companyJobList,
                            companyJobSeekerList, companySkillList, companyStatusList);
                }
            }
        } while (companyScheduleNum != 8);
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
                    leftDateTime = LocalDateTime.parse(leftTime.getPosition(i + 1).getDate() + String.format("%04d", leftTime.getPosition(i + 1).getStartTime()), formatter2);
                    rightDateTime = LocalDateTime.parse(rightTime.getPosition(j + 1).getDate() + String.format("%04d", rightTime.getPosition(j + 1).getStartTime()), formatter2);

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
                    if (Integer.compare(rightStatus.getPosition(j + 1).getScore(), leftStatus.getPosition(i + 1).getScore()) <= 0) {
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
                    leftDateTime = LocalDateTime.parse(leftTime.getPosition(i + 1).getDate() + String.format("%04d", leftTime.getPosition(i + 1).getStartTime()), formatter2);
                    rightDateTime = LocalDateTime.parse(rightTime.getPosition(j + 1).getDate() + String.format("%04d", rightTime.getPosition(j + 1).getStartTime()), formatter2);

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
                    if (Integer.compare(rightStatus.getPosition(j + 1).getScore(), leftStatus.getPosition(i + 1).getScore()) <= 0) {
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

    public void searchStudent(int num,
            String search,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<Status> statusList) {

        searchTimeList = new DoublyLinkedList<>();
        searchJobList = new DoublyLinkedList<>();
        searchStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= timeList.getCount(); i++) {
            if (num == 1) {
                if (timeList.getPosition(i).getDate().toLowerCase().contains(search)
                        || String.valueOf(timeList.getPosition(i).getStartTime()).toLowerCase().contains(search)
                        || String.valueOf(timeList.getPosition(i).getEndTime()).toLowerCase().contains(search)
                        || jobList.getPosition(i).getTitle().toLowerCase().contains(search)
                        || jobList.getPosition(i).getEmployer().getName().toLowerCase().contains(search)
                        || statusList.getPosition(i).getStatus().toLowerCase().contains(search)) {
                    searchTimeList.insertBack(timeList.getPosition(i));
                    searchJobList.insertBack(jobList.getPosition(i));
                    searchStatusList.insertBack(statusList.getPosition(i));
                }
            } else if (num == 2) {
                if (timeList.getPosition(i).getDate().toLowerCase().contains(search)
                        || String.valueOf(timeList.getPosition(i).getStartTime()).toLowerCase().contains(search)
                        || String.valueOf(timeList.getPosition(i).getEndTime()).toLowerCase().contains(search)
                        || jobList.getPosition(i).getTitle().toLowerCase().contains(search)
                        || jobList.getPosition(i).getEmployer().getName().toLowerCase().contains(search)
                        || statusList.getPosition(i).getStatus().toLowerCase().contains(search)
                        || String.valueOf(statusList.getPosition(i).getScore()).toLowerCase().contains(search)) {
                    searchTimeList.insertBack(timeList.getPosition(i));
                    searchJobList.insertBack(jobList.getPosition(i));
                    searchStatusList.insertBack(statusList.getPosition(i));
                }
            }
        }

        timeList.clear();
        jobList.clear();
        statusList.clear();

        for (int i = 1; i <= searchTimeList.getCount(); i++) {
            timeList.insertBack(searchTimeList.getPosition(i));
            jobList.insertBack(searchJobList.getPosition(i));
            statusList.insertBack(searchStatusList.getPosition(i));
        }
    }

    public void searchCompany(int num,
            String search,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> skillList,
            DoublyLinkedListInterface<Status> statusList) {

        searchTimeList = new DoublyLinkedList<>();
        searchJobList = new DoublyLinkedList<>();
        searchJobSeekerList = new DoublyLinkedList<>();
        searchSkillList = new DoublyLinkedList<>();
        searchStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= timeList.getCount(); i++) {
            if (num == 1) {
                for (int j = 1; j <= skillList.getPosition(i).getCount(); j++) {
                    if (timeList.getPosition(i).getDate().toLowerCase().contains(search)
                            || String.valueOf(timeList.getPosition(i).getStartTime()).toLowerCase().contains(search)
                            || String.valueOf(timeList.getPosition(i).getEndTime()).toLowerCase().contains(search)
                            || jobList.getPosition(i).getTitle().toLowerCase().contains(search)
                            || jobSeekerList.getPosition(i).getName().toLowerCase().contains(search)
                            || jobSeekerList.getPosition(i).getQualification().toLowerCase().contains(search)
                            || skillList.getPosition(i).getPosition(j).getName().toLowerCase().contains(search)
                            || String.valueOf(skillList.getPosition(i).getPosition(j).getProficiency()).toLowerCase().contains(search)
                            || statusList.getPosition(i).getStatus().toLowerCase().contains(search)) {
                        searchTimeList.insertBack(timeList.getPosition(i));
                        searchJobList.insertBack(jobList.getPosition(i));
                        searchJobSeekerList.insertBack(jobSeekerList.getPosition(i));
                        searchSkillList.insertBack(skillList.getPosition(i));
                        searchStatusList.insertBack(statusList.getPosition(i));
                    }
                }
            } else if (num == 2) {
                for (int j = 1; j <= skillList.getPosition(i).getCount(); j++) {
                    if (timeList.getPosition(i).getDate().toLowerCase().contains(search)
                            || String.valueOf(timeList.getPosition(i).getStartTime()).toLowerCase().contains(search)
                            || String.valueOf(timeList.getPosition(i).getEndTime()).toLowerCase().contains(search)
                            || jobList.getPosition(i).getTitle().toLowerCase().contains(search)
                            || jobSeekerList.getPosition(i).getName().toLowerCase().contains(search)
                            || jobSeekerList.getPosition(i).getQualification().toLowerCase().contains(search)
                            || skillList.getPosition(i).getPosition(j).getName().toLowerCase().contains(search)
                            || String.valueOf(skillList.getPosition(i).getPosition(j).getProficiency()).toLowerCase().contains(search)
                            || statusList.getPosition(i).getStatus().toLowerCase().contains(search)
                            || String.valueOf(statusList.getPosition(i).getScore()).toLowerCase().contains(search)) {
                        searchTimeList.insertBack(timeList.getPosition(i));
                        searchJobList.insertBack(jobList.getPosition(i));
                        searchJobSeekerList.insertBack(jobSeekerList.getPosition(i));
                        searchSkillList.insertBack(skillList.getPosition(i));
                        searchStatusList.insertBack(statusList.getPosition(i));
                    }
                }
            }
        }

        timeList.clear();
        jobList.clear();
        jobSeekerList.clear();
        skillList.clear();
        statusList.clear();

        for (int i = 1; i <= searchTimeList.getCount(); i++) {
            timeList.insertBack(searchTimeList.getPosition(i));
            jobList.insertBack(searchJobList.getPosition(i));
            jobSeekerList.insertBack(searchJobSeekerList.getPosition(i));
            skillList.insertBack(searchSkillList.getPosition(i));
            statusList.insertBack(searchStatusList.getPosition(i));
        }
    }

    public void filterStatus(int num,
            DoublyLinkedListInterface<Time> timeList,
            DoublyLinkedListInterface<JobPosting> jobList,
            DoublyLinkedListInterface<JobSeeker> jobSeekerList,
            DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> skillList,
            DoublyLinkedListInterface<Status> statusList) {

        int recruitNum, applicantNum;

        filterTimeList = new DoublyLinkedList<>();
        filterJobList = new DoublyLinkedList<>();
        filterJobSeekerList = new DoublyLinkedList<>();
        filterSkillList = new DoublyLinkedList<>();
        filterStatusList = new DoublyLinkedList<>();

        switch (num) {
            case 9:
                for (int i = 1; i <= statusList.getCount(); i++) {
                    if (statusList.getPosition(i).getStatus().equals("Interviewed")) {
                        filterTimeList.insertBack(timeList.getPosition(i));
                        filterJobList.insertBack(jobList.getPosition(i));
                        filterJobSeekerList.insertBack(jobSeekerList.getPosition(i));
                        filterSkillList.insertBack(skillList.getPosition(i));
                        filterStatusList.insertBack(statusList.getPosition(i));
                    }
                }
                break;
            case 10:
                for (int i = 1; i <= statusList.getCount(); i++) {
                    if (statusList.getPosition(i).getStatus().equals("Hired")) {
                        filterTimeList.insertBack(timeList.getPosition(i));
                        filterJobList.insertBack(jobList.getPosition(i));
                        filterJobSeekerList.insertBack(jobSeekerList.getPosition(i));
                        filterSkillList.insertBack(skillList.getPosition(i));
                        filterStatusList.insertBack(statusList.getPosition(i));
                    }
                }
                break;
            default:
                for (int i = 1; i <= statusList.getCount(); i++) {
                    if (statusList.getPosition(i).getStatus().equals("Rejected")) {
                        filterTimeList.insertBack(timeList.getPosition(i));
                        filterJobList.insertBack(jobList.getPosition(i));
                        filterJobSeekerList.insertBack(jobSeekerList.getPosition(i));
                        filterSkillList.insertBack(skillList.getPosition(i));
                        filterStatusList.insertBack(statusList.getPosition(i));
                    }
                }
                break;
        }

        if (!filterTimeList.isEmpty()) {
            mergeSortCompany(6, filterTimeList, filterJobList, filterJobSeekerList, filterSkillList, filterStatusList);
            interviewUI.scheduleUI(filterTimeList, filterJobList, filterJobSeekerList, filterSkillList, filterStatusList);

            if (num == 8) {
                recruitNum = interviewUI.recruitUI();
                if (recruitNum == 1) {
                    applicantNum = interviewUI.recruitApplicantUI(filterTimeList.getCount());

                    for (int i = 1; i <= interviewList.getCount(); i++) {
                        for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                            for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                                if (filterJobSeekerList.getPosition(applicantNum).equals(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k))) {
                                    interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).setStatus("Hired");
                                }
                            }
                        }
                    }

                    interviewUI.scheduleUI(filterTimeList, filterJobList, filterJobSeekerList, filterSkillList, filterStatusList);
                }
            }

        } else {
            interviewUI.noFilterUI();
        }
        MessageUI.pressEnterContinue();
        sc.nextLine();
    }

    public void implementSchedule(Employer employer) {
        int implementNum, year = currentDate.getYear(), month = currentDate.getMonthValue(), currentDayOfMonth = currentDate.getDayOfMonth(), count = 0, p = 0;
        LocalDate firstDay = LocalDate.of(year, month, 1);
        int lengthOfMonth = firstDay.lengthOfMonth();
        LocalDate lastDay = LocalDate.of(year, month, lengthOfMonth);
        DayOfWeek startDay = firstDay.getDayOfWeek();
        DayOfWeek endDay = lastDay.getDayOfWeek();
        String monthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        LocalDate nextMonth = currentDate.plusMonths(1);

        String viewMonthName = monthName, viewRED = "\u001B[31m", viewGREEN = "\u001B[32m";
        int viewYear = year, viewMonth, viewLengthOfMonth = lengthOfMonth, viewCurrentDayOfMonth = currentDayOfMonth;
        LocalDate viewFirstDay, viewLastDay;
        DayOfWeek viewStartDay = startDay, viewEndDay = endDay;

        LocalDate targetDate;
        if (currentDate.getDayOfMonth() == 1) {
            targetDate = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        } else {
            targetDate = nextMonth.minusDays(1);
        }

        int selectNum, selectMonth, selectDay, selectSlot, selectTime;
        boolean retry, inList = false;

        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        matchList = new DoublyLinkedList<>();

        for (int i = 1; i <= jobApplicationList.getCount(); i++) {
            if (jobApplicationList.getPosition(i).getMatchScore().getJobPosting().getEmployer().equals(employer)) {
                companyJobList.insertBack(jobApplicationList.getPosition(i).getMatchScore().getJobPosting());
                companyJobSeekerList.insertBack(jobApplicationList.getPosition(i).getJobSeeker());
                companySkillList.insertBack(jobApplicationList.getPosition(i).getJobSeeker().getSkills());
                matchList.insertBack(jobApplicationList.getPosition(i).getMatchScore());
            }
        }

        implementNum = interviewUI.implementUI(companyJobList, companyJobSeekerList, companySkillList, matchList);

        if (implementNum == 1) {
            selectNum = interviewUI.numberUI(companyJobList.getCount());
            do {
                interviewUI.monthUI(viewMonthName, viewYear, viewStartDay, viewLengthOfMonth, viewCurrentDayOfMonth, viewGREEN, viewRED, viewEndDay);

                viewMonthName = currentDate.plusMonths(1).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                viewYear = currentDate.plusMonths(1).getYear();
                viewMonth = currentDate.plusMonths(1).getMonthValue();
                viewFirstDay = LocalDate.of(viewYear, viewMonth, 1);
                viewStartDay = viewFirstDay.getDayOfWeek();
                viewLengthOfMonth = viewFirstDay.lengthOfMonth();
                viewCurrentDayOfMonth = currentDate.plusMonths(1).getDayOfMonth();
                viewLastDay = LocalDate.of(viewYear, viewMonth, viewLengthOfMonth);
                viewEndDay = viewLastDay.getDayOfWeek();
                viewRED = "\u001B[32m";
                viewGREEN = "\u001B[31m";
                if (currentDate.isBefore(targetDate.plusDays(1))) {
                    count++;
                }
            } while (count == 1);

            if (targetDate.getMonthValue() != currentDate.getMonthValue()) {
                selectMonth = interviewUI.chooseMonthUI(currentDate.getMonthValue(), targetDate.getMonthValue());
            } else {
                selectMonth = currentDate.getMonthValue();
            }

            selectDay = interviewUI.chooseDayUI(currentDate.getDayOfMonth(), LocalDate.of(currentDate.getYear(), currentDate.getMonthValue(), 1).lengthOfMonth(), selectMonth, currentDate.getMonthValue());

            for (int i = 1; i <= interviewList.getCount(); i++) {
                for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                    for (int k = 1; k <= interviewList.getPosition(i).getTimeList().getPosition(j).getCount(); k++) {
                        if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().equals(employer)) {
                            companyTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                        }
                    }
                }
            }

            interviewUI.slotUI(companyTimeList, year, selectMonth, selectDay);

            do {
                retry = false;
                selectSlot = interviewUI.chooseSlotUI();

                switch (selectSlot) {
                    case 1:
                        selectTime = 900;
                        break;
                    case 2:
                        selectTime = 1000;
                        break;
                    case 3:
                        selectTime = 1100;
                        break;
                    case 4:
                        selectTime = 1200;
                        break;
                    case 5:
                        selectTime = 1300;
                        break;
                    case 6:
                        selectTime = 1400;
                        break;
                    case 7:
                        selectTime = 1500;
                        break;
                    case 8:
                        selectTime = 1600;
                        break;
                    default:
                        selectTime = 1700;
                        break;
                }

                for (int i = 1; i <= interviewList.getCount(); i++) {
                    for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                        for (int k = 1; k <= companyTimeList.getCount(); k++) {
                            if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().equals(employer)
                                    && companyTimeList.getPosition(k).getStartTime() == selectTime
                                    && LocalDate.parse(companyTimeList.getPosition(k).getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).getYear() == year
                                    && LocalDate.parse(companyTimeList.getPosition(k).getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).getMonthValue() == selectMonth
                                    && LocalDate.parse(companyTimeList.getPosition(k).getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).getDayOfMonth() == selectDay) {
                                if (p == 0) {
                                    interviewUI.slotChosenUI();
                                    p++;
                                }
                                retry = true;
                                break;
                            }
                        }
                    }
                }
            } while (retry);

            for (int i = 1; i <= interviewList.getCount(); i++) {
                for (int j = 1; j <= interviewList.getPosition(i).getJobPostingList().getCount(); j++) {
                    if (interviewList.getPosition(i).getJobPostingList().getPosition(j).equals(companyJobList.getPosition(selectNum))) {
                        interviewList.getPosition(i).getJobSeekerList().getPosition(j).insertBack(companyJobSeekerList.getPosition(selectNum));

                        Time time = new Time();
                        time.setDate(LocalDate.of(year, selectMonth, selectDay).format(formatter));
                        time.setStartTime(selectTime);
                        time.setEndTime(selectTime + 100);

                        interviewList.getPosition(i).getTimeList().getPosition(j).insertBack(time);

                        Status status = new Status();
                        status.setStatus("Scheduled");
                        status.setScore(0);

                        interviewList.getPosition(i).getStatusList().getPosition(j).insertBack(status);

                        for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                            for (int l = 1; l <= jobApplicationList.getCount(); l++) {
                                if (jobApplicationList.getPosition(l).getJobSeeker().equals(interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k))) {
                                    jobApplicationList.deletePosition(l);
                                }
                            }
                        }

                        interviewUI.newInterviewUI(interviewList, i, j);
                        inList = true;
                    }
                }
            }

            if (!inList) {
                DoublyLinkedListInterface<JobPosting> interviewJobList = new DoublyLinkedList<>();
                DoublyLinkedListInterface<JobSeeker> jobSeekerList = new DoublyLinkedList<>();
                DoublyLinkedListInterface<DoublyLinkedListInterface<JobSeeker>> interviewJobSeekerList = new DoublyLinkedList<>();

                Time time = new Time();
                DoublyLinkedListInterface<Time> timeList = new DoublyLinkedList<>();
                DoublyLinkedListInterface<DoublyLinkedListInterface<Time>> interviewTimeList = new DoublyLinkedList<>();

                Status status = new Status();
                DoublyLinkedListInterface<Status> statusList = new DoublyLinkedList<>();
                DoublyLinkedListInterface<DoublyLinkedListInterface<Status>> interviewStatusList = new DoublyLinkedList<>();

                interviewJobList.insertFront(companyJobList.getPosition(selectNum));

                jobSeekerList.insertFront(companyJobSeekerList.getPosition(selectNum));
                interviewJobSeekerList.insertFront(jobSeekerList);

                time.setDate(LocalDate.of(year, selectMonth, selectDay).format(formatter));
                time.setStartTime(selectTime);
                time.setEndTime(selectTime + 100);
                timeList.insertFront(time);
                interviewTimeList.insertFront(timeList);

                status.setStatus("Scheduled");
                status.setScore(0);
                statusList.insertFront(status);
                interviewStatusList.insertFront(statusList);

                interviewList.insertBack(new Interview(interviewJobList, interviewJobSeekerList, interviewTimeList, interviewStatusList));

                interviewUI.newInterviewUI(interviewList, interviewList.getCount(), interviewList.getPosition(interviewList.getCount()).getTimeList().getCount());
            }
        }
    }

    public void assignScore(Employer employer) {
        int assignNum, scoreNum, score, finalScore, matchScore = 0, continueNum;

        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName())
                            && !LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isAfter(currentDate)
                            && interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Interviewed")
                            && interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getScore() == 0) {
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

            if (!companyTimeList.isEmpty()) {
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
        LocalDateTime now = LocalDateTime.now();
        String formatDateTime = now.format(formatter3);
        String day = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        int positionCount = 0, interviewCount = 0, applicantCount = 0, positionCount2 = 0, applicantCount2 = 0, totalPositionCount = 0, totalInterviewCount = 0, totalApplicantCount = 0, totalPositionCount2 = 0, totalApplicantCount2 = 0;

        interviewUI.reportHeaderUI(formatDateTime, day);

        filterTimeList = new DoublyLinkedList<>();
        filterJobList = new DoublyLinkedList<>();
        filterStatusList = new DoublyLinkedList<>();

        interviewEmployerList = new DoublyLinkedList<>();

        hiredEmployerList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getTimeList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Scheduled")) {
                        filterJobList.insertUniqueBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        interviewEmployerList.insertUniqueBack(interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer());
                    }
                }
            }
        }

        interviewUI.reportScheduleHeaderUI();

        for (int i = 1; i <= interviewEmployerList.getCount(); i++) {
            interviewUI.reportScheduleContentHeaderUI(interviewEmployerList.getPosition(i).getName());
            for (int j = 1; j <= filterJobList.getCount(); j++) {
                if (filterJobList.getPosition(j).getEmployer().equals(interviewEmployerList.getPosition(i))) {
                    interviewJobList = new DoublyLinkedList<>();
                    interviewTimeList = new DoublyLinkedList<>();
                    interviewJobSeekerList = new DoublyLinkedList<>();

                    interviewJobList.insertUniqueBack(filterJobList.getPosition(j));
                    for (int k = 1; k <= interviewList.getCount(); k++) {
                        for (int l = 1; l <= interviewList.getPosition(k).getStatusList().getCount(); l++) {
                            for (int m = 1; m <= interviewList.getPosition(k).getStatusList().getPosition(l).getCount(); m++) {
                                if (interviewList.getPosition(k).getStatusList().getPosition(l).getPosition(m).getStatus().equals("Scheduled")
                                        && interviewList.getPosition(k).getJobPostingList().getPosition(l).equals(filterJobList.getPosition(j))
                                        && interviewList.getPosition(k).getJobPostingList().getPosition(l).getEmployer().equals(interviewEmployerList.getPosition(i))) {
                                    interviewJobSeekerList.insertBack(interviewList.getPosition(k).getJobSeekerList().getPosition(l).getPosition(m));
                                    interviewTimeList.insertBack(interviewList.getPosition(k).getTimeList().getPosition(l).getPosition(m));
                                }
                            }
                        }
                    }

                    interviewUI.reportScheduleUI(
                            interviewJobList,
                            interviewTimeList,
                            interviewJobSeekerList,
                            interviewJobSeekerList.getCount()
                    );

                    positionCount += interviewJobList.getCount();
                    interviewCount += interviewTimeList.getCount();
                    applicantCount += interviewJobSeekerList.getCount();
                    
                    totalPositionCount += interviewJobList.getCount();
                    totalInterviewCount += interviewTimeList.getCount();
                    totalApplicantCount += interviewJobSeekerList.getCount();
                }
            }
            interviewUI.reportScheduleNumberUI(positionCount, interviewCount);
            positionCount = 0;
            interviewCount = 0;
            applicantCount = 0;
        }

        interviewUI.reportScheduleTotalUI(totalPositionCount, totalInterviewCount, totalApplicantCount);

        filterJobList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getTimeList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getTimeList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k).getStatus().equals("Hired")) {
                        filterJobList.insertUniqueBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        hiredEmployerList.insertUniqueBack(interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer());
                    }
                }
            }
        }

        interviewUI.reportHiredHeaderUI();

        for (int i = 1; i <= hiredEmployerList.getCount(); i++) {
            interviewUI.reportHiredContentHeaderUI(hiredEmployerList.getPosition(i).getName());
            for (int j = 1; j <= filterJobList.getCount(); j++) {
                if (filterJobList.getPosition(j).getEmployer().equals(hiredEmployerList.getPosition(i))) {
                    hiredJobList = new DoublyLinkedList<>();
                    hiredJobSeekerList = new DoublyLinkedList<>();
                    hiredStatusList = new DoublyLinkedList<>();

                    hiredJobList.insertUniqueBack(filterJobList.getPosition(j));
                    for (int k = 1; k <= interviewList.getCount(); k++) {
                        for (int l = 1; l <= interviewList.getPosition(k).getStatusList().getCount(); l++) {
                            for (int m = 1; m <= interviewList.getPosition(k).getStatusList().getPosition(l).getCount(); m++) {
                                if (interviewList.getPosition(k).getStatusList().getPosition(l).getPosition(m).getStatus().equals("Hired")
                                        && interviewList.getPosition(k).getJobPostingList().getPosition(l).equals(filterJobList.getPosition(j))
                                        && interviewList.getPosition(k).getJobPostingList().getPosition(l).getEmployer().equals(hiredEmployerList.getPosition(i))) {
                                    hiredJobSeekerList.insertBack(interviewList.getPosition(k).getJobSeekerList().getPosition(l).getPosition(m));
                                    hiredStatusList.insertBack(interviewList.getPosition(k).getStatusList().getPosition(l).getPosition(m));
                                }
                            }
                        }
                    }

                    interviewUI.reportHiredUI(
                            hiredJobList,
                            hiredJobSeekerList,
                            hiredStatusList,
                            hiredJobSeekerList.getCount()
                    );

                    positionCount2 += hiredJobList.getCount();
                    applicantCount2 += hiredJobSeekerList.getCount();
                    
                    totalPositionCount2 += hiredJobList.getCount();
                    totalApplicantCount2 += hiredJobSeekerList.getCount();
                }
            }
            interviewUI.reportHiredNumberUI(positionCount2, applicantCount2);
            positionCount2 = 0;
            applicantCount2 = 0;
        }

        interviewUI.reportHiredTotalUI(totalPositionCount2, totalApplicantCount2);
        interviewUI.reportFooterUI();
    }
}
