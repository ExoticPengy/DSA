/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import boundary.InterviewArrangementUI;
import dao.EmployerInitializer;
//import dao.InterviewInitializer;
import dao.JobPostingInitializer;
import entity.Employer;
import entity.Interview;
import entity.JobSeeker;
import entity.Skill;

/**
 *
 * @author mings
 */
public class InterviewArrangement {

    //private InterviewInitializer interviewInitializer;
    private JobPostingInitializer jobPostingInitializer;
    private EmployerInitializer employerInitializer;

    private DoublyLinkedListInterface<Interview> studentInterviewList;
    private DoublyLinkedListInterface<String> studentDateList;
    private DoublyLinkedListInterface<String> studentTimeList;
    private DoublyLinkedListInterface<String> studentJobList;
    private DoublyLinkedListInterface<String> studentCompanyList;
    private DoublyLinkedListInterface<String> studentStatusList;
    private DoublyLinkedListInterface<Integer> studentScoreList;

    private DoublyLinkedListInterface<Interview> companyInterviewList;
    private DoublyLinkedListInterface<String> companyDateList;
    private DoublyLinkedListInterface<String> companyTimeList;
    private DoublyLinkedListInterface<String> companyJobList;
    private DoublyLinkedListInterface<String> companyJobSeekerList;
    private DoublyLinkedListInterface<String> companyQualificationList;
    private DoublyLinkedListInterface<DoublyLinkedListInterface<Skill>> companySkillList;
    private DoublyLinkedListInterface<String> companyStatusList;
    private DoublyLinkedListInterface<Integer> companyScoreList;

    private InterviewArrangementUI interviewUI;

    public InterviewArrangement() {
        //interviewInitializer = new InterviewInitializer();
        interviewUI = new InterviewArrangementUI();
        jobPostingInitializer = new JobPostingInitializer();
        employerInitializer = new EmployerInitializer();
    }

//    public void runInterviewArrangement(){
//        interviewList = interviewInitializer.getInterview();
//    }
    public void displayStudentSchedule(JobSeeker jobSeeker) {
        //studentInterviewList = interviewInitializer.getInterview();
        studentDateList = new DoublyLinkedList<>();
        studentTimeList = new DoublyLinkedList<>();
        studentJobList = new DoublyLinkedList<>();
        studentCompanyList = new DoublyLinkedList<>();
        studentStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= studentInterviewList.getCount(); i++) {
            for (int j = 1; j <= studentInterviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                if (studentInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getName() == jobSeeker.getName()) {
                    studentDateList.insertBack(studentInterviewList.getPosition(i).getDateList().getPosition(j));
                    studentTimeList.insertBack(studentInterviewList.getPosition(i).getTimeList().getPosition(j));
                    studentJobList.insertBack(studentInterviewList.getPosition(i).getJobPosting().getTitle());
                    studentCompanyList.insertBack(studentInterviewList.getPosition(i).getJobPosting().getEmployer().getName());
                    studentStatusList.insertBack(studentInterviewList.getPosition(i).getStatusList().getPosition(j));
                    break;
                }
            }
        }
        interviewUI.studentScheduleUI(studentDateList, studentTimeList, studentJobList, studentCompanyList, studentStatusList);
    }

    public void displayCompanySchedule(Employer employer) {
        //companyInterviewList = interviewInitializer.getInterview();
        companyDateList = new DoublyLinkedList<>();
        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companyQualificationList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();

        for (int i = 1; i <= companyInterviewList.getCount(); i++) {
            for (int j = 1; j <= companyInterviewList.getCount(); j++) {
                if (companyInterviewList.getPosition(i).getJobPosting().getEmployer().getName() == employer.getName()) {
                    companyDateList.insertBack(companyInterviewList.getPosition(i).getDateList().getPosition(j));
                    companyTimeList.insertBack(companyInterviewList.getPosition(i).getTimeList().getPosition(j));
                    companyJobList.insertBack(companyInterviewList.getPosition(i).getJobPosting().getTitle());
                    companyJobSeekerList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getName());
                    companyQualificationList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getQualification());
                    companySkillList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getSkills());
                    companyStatusList.insertBack(companyInterviewList.getPosition(i).getStatusList().getPosition(j));
                }
            }
        }
        interviewUI.companyScheduleUI(companyDateList, companyTimeList, companyJobList, companyJobSeekerList, companyQualificationList, companySkillList, companyStatusList);
    }

    public void displayStudentResult(JobSeeker jobSeeker) {
        //studentInterviewList = interviewInitializer.getInterview();
        studentDateList = new DoublyLinkedList<>();
        studentTimeList = new DoublyLinkedList<>();
        studentJobList = new DoublyLinkedList<>();
        studentCompanyList = new DoublyLinkedList<>();
        studentStatusList = new DoublyLinkedList<>();
        studentScoreList = new DoublyLinkedList<>();

        for (int i = 1; i <= studentInterviewList.getCount(); i++) {
            for (int j = 1; j <= studentInterviewList.getPosition(i).getJobSeekerList().getCount(); j++) {
                if (studentInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getName() == jobSeeker.getName()) {
                    studentDateList.insertBack(studentInterviewList.getPosition(i).getDateList().getPosition(j));
                    studentTimeList.insertBack(studentInterviewList.getPosition(i).getTimeList().getPosition(j));
                    studentJobList.insertBack(studentInterviewList.getPosition(i).getJobPosting().getTitle());
                    studentCompanyList.insertBack(studentInterviewList.getPosition(i).getJobPosting().getEmployer().getName());
                    studentStatusList.insertBack(studentInterviewList.getPosition(i).getStatusList().getPosition(j));
                    studentScoreList.insertBack(studentInterviewList.getPosition(i).getScoreList().getPosition(j));
                    break;
                }
            }
        }
        interviewUI.studentResultUI(studentDateList, studentTimeList, studentJobList, studentCompanyList, studentStatusList, studentScoreList);
    }

    public void displayCompanyResult(Employer employer) {
        //companyInterviewList = interviewInitializer.getInterview();
        companyDateList = new DoublyLinkedList<>();
        companyTimeList = new DoublyLinkedList<>();
        companyJobList = new DoublyLinkedList<>();
        companyJobSeekerList = new DoublyLinkedList<>();
        companyQualificationList = new DoublyLinkedList<>();
        companySkillList = new DoublyLinkedList<>();
        companyStatusList = new DoublyLinkedList<>();
        companyScoreList = new DoublyLinkedList<>();

        for (int i = 1; i <= companyInterviewList.getCount(); i++) {
            for (int j = 1; j <= companyInterviewList.getCount(); j++) {
                if (companyInterviewList.getPosition(i).getJobPosting().getEmployer().getName() == employer.getName()) {
                    companyDateList.insertBack(companyInterviewList.getPosition(i).getDateList().getPosition(j));
                    companyTimeList.insertBack(companyInterviewList.getPosition(i).getTimeList().getPosition(j));
                    companyJobList.insertBack(companyInterviewList.getPosition(i).getJobPosting().getTitle());
                    companyJobSeekerList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getName());
                    companyQualificationList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getQualification());
                    companySkillList.insertBack(companyInterviewList.getPosition(i).getJobSeekerList().getPosition(j).getSkills());
                    companyStatusList.insertBack(companyInterviewList.getPosition(i).getStatusList().getPosition(j));
                    companyScoreList.insertBack(companyInterviewList.getPosition(i).getScoreList().getPosition(j));
                }
            }
        }
        interviewUI.companyResultUI(companyDateList, companyTimeList, companyJobList, companyJobSeekerList, companyQualificationList, companySkillList, companyStatusList, companyScoreList);
    }

    public void displayInterviewReport() {

    }
}
