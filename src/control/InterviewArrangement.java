/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InterviewArrangementUI;
import dao.EmployerInitializer;
import dao.InterviewInitializer;
import dao.JobPostingInitializer;
import entity.Employer;
import entity.Interview;
import entity.JobPosting;
import entity.JobSeeker;
import entity.Skill;
import entity.Status;
import entity.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private InterviewArrangementUI interviewUI;

    public InterviewArrangement() {
        interviewList = new DoublyLinkedList<>();
        interviewInitializer = new InterviewInitializer();

        currentDate = LocalDate.now();
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        interviewUI = new InterviewArrangementUI();
    }

    public void runInterviewArrangement() {
        interviewList = interviewInitializer.getInterview();
    }

    public void displayStudentSchedule(JobSeeker jobSeeker) {
        studentTimeList = new DoublyLinkedList<>();
        studentJobList = new DoublyLinkedList<>();
        studentStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getJobSeekerList().getPosition(j).getPosition(k).getName().equals(jobSeeker.getName()) && LocalDate.parse(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k).getDate(), formatter).isAfter(currentDate)) {
                        studentTimeList.insertBack(interviewList.getPosition(i).getTimeList().getPosition(j).getPosition(k));
                        studentJobList.insertBack(interviewList.getPosition(i).getJobPostingList().getPosition(j));
                        studentStatusList.insertBack(interviewList.getPosition(i).getStatusList().getPosition(j).getPosition(k));
                        break;
                    }
                }
            }
        }
        interviewUI.studentScheduleUI(studentTimeList, studentJobList, studentStatusList);
    }

    public void displayCompanySchedule(Employer employer) {
        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= interviewList.getCount(); i++) {
            for (int j = 1; j <= interviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                for (int k = 1; k <= interviewList.getPosition(i).getJobSeekerList().getPosition(j).getCount(); k++) {
                    if (interviewList.getPosition(i).getJobPostingList().getPosition(j).getEmployer().getName().equals(employer.getName())) {
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

    public void displayStudentResult(JobSeeker jobSeeker) {
        studentTimeList = new DoublyLinkedList<>();
        studentJobList = new DoublyLinkedList<>();
        studentStatusList = new DoublyLinkedList<>();

//        for (int i = 1; i <= studentInterviewList.getCount(); i++) {
//            for (int j = 1; j <= studentInterviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
//                if (studentInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getName() == jobSeeker.getName()) {
//                    studentDateList.insertBack(studentInterviewList.getPosition(i).getDateList().getPosition(j));
//                    studentTimeList.insertBack(studentInterviewList.getPosition(i).getTimeList().getPosition(j));
//                    studentJobList.insertBack(studentInterviewList.getPosition(i).getJobPosting().getTitle());
//                    studentCompanyList.insertBack(studentInterviewList.getPosition(i).getJobPosting().getEmployer().getName());
//                    studentStatusList.insertBack(studentInterviewList.getPosition(i).getStatusList().getPosition(j));
//                    studentScoreList.insertBack(studentInterviewList.getPosition(i).getScoreList().getPosition(j));
//                    break;
//                }
//            }
//        }
        interviewUI.studentResultUI(studentTimeList, studentJobList,  studentStatusList);
    }

    public void displayCompanyResult(Employer employer) {
//        for (int i = 1; i <= companyInterviewList.getCount(); i++) {
//            for (int j = 1; j <= companyInterviewList.getCount(); j++) {
//                if (companyInterviewList.getPosition(i).getJobPosting().getEmployer().getName() == employer.getName()) {
//                    companyDateList.insertBack(companyInterviewList.getPosition(i).getDateList().getPosition(j));
//                    companyTimeList.insertBack(companyInterviewList.getPosition(i).getTimeList().getPosition(j));
//                    companyJobList.insertBack(companyInterviewList.getPosition(i).getJobPosting().getTitle());
//                    companyJobSeekerList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getName());
//                    companyQualificationList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getQualification());
//                    companySkillList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getSkills());
//                    companyStatusList.insertBack(companyInterviewList.getPosition(i).getStatusList().getPosition(j));
//                    companyScoreList.insertBack(companyInterviewList.getPosition(i).getScoreList().getPosition(j));
//                }
//            }
//        }
//        interviewUI.companyResultUI(companyTimeList, companyJobList, companyJobSeekerList, companyQualificationList, companySkillList, companyStatusList, companyScoreList);
    }

    public void displayInterviewReport() {

    }
}
