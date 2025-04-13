/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Employer;
import entity.JobPosting;
import entity.Skill;

/**
 *
 * @author Elaine
 */
public class JobPostingInitializer {
    
    public DoublyLinkedListInterface<JobPosting> getJobPosting(DoublyLinkedListInterface<Employer> employerList) {
        DoublyLinkedListInterface<JobPosting> jobList = new DoublyLinkedList<>();
        Employer employer;
        
        //employer 1
        employer = employerList.getPosition(1);
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 9));
        skills.insertBack(new Skill("Communication", 7));
        jobList.insertFront(new JobPosting(employer, "Software Engineer Internship", "Coding, Debugging, Development", "RM800-RM1000", "Diploma in Computer Science", skills));
        
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 8));
        skills.insertBack(new Skill("Analysis", 7));
        jobList.insertBack(new JobPosting(employer, "Backend Developer Intern", "API development, database management", "RM900-RM1100", "Bachelor in Computer Science", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 7));
        jobList.insertBack(new JobPosting(employer, "Frontend Developer Intern", "UI/UX development, responsive design", "RM800-RM950", "Diploma in IT", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 8));
        skills.insertBack(new Skill("Communication", 7));
        jobList.insertBack(new JobPosting(employer, "Data Analyst Intern", "Data processing, visualization", "RM850-RM1000", "Bachelor in Data Science", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 8));
        skills.insertBack(new Skill("Leadership", 5));
        jobList.insertBack(new JobPosting(employer, "DevOps Intern", "CI/CD pipelines, cloud deployment", "RM950-RM1200", "Bachelor in Software Engineer", skills));
        
        //employer 2
        employer = employerList.getPosition(2);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 9));
        jobList.insertBack(new JobPosting(employer, "IT Internship", "Programming", "RM800-RM900", "Bachelor in IT", skills));
        
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 7));
        skills.insertBack(new Skill("Analysis", 6));
        jobList.insertBack(new JobPosting(employer, "Cybersecurity Intern", "Security monitoring, vulnerability assessment", "RM900-RM1100", "Bachelor in Cybersecurity", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication",9));
        skills.insertBack(new Skill("Leadership", 9));
        jobList.insertBack(new JobPosting(employer, "Project Management Intern", "Project coordination, documentation", "RM750-RM850", "Bachelor in Business IT", skills));

        //employer 3
        employer = employerList.getPosition(3);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 8));
        jobList.insertBack(new JobPosting(employer, "Business Development Internship", "Management, Partnership", "RM600-RM800", "Bachelor in Business", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 10));
        skills.insertBack(new Skill("Programming", 7));
        jobList.insertBack(new JobPosting(employer, "Software Developer Internship", "Develop software", "RM900-RM1100", "Bachelor in Computer Science", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 9));
        skills.insertBack(new Skill("Programming", 6));
        jobList.insertBack(new JobPosting(employer, "AI Research Intern", "Machine learning model development", "RM1000-RM1300", "Master in Computer Science", skills));
        
        //employer 4
        employer = employerList.getPosition(4);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 8));
        jobList.insertBack(new JobPosting(employer, "Business Analyst Intern", "Data analysis, process improvement", "RM850-RM950", "Bachelor in Business Analytics", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 9));
        skills.insertBack(new Skill("Leadership", 7));
        jobList.insertBack(new JobPosting(employer, "Marketing Intern", "Digital marketing, campaign management", "RM700-RM850", "Diploma in Marketing", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 8));
        skills.insertBack(new Skill("Communication", 5));
        jobList.insertBack(new JobPosting(employer, "Financial Analyst Intern", "Financial reporting, data analysis", "RM950-RM1100", "Bachelor in Finance", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 8));
        skills.insertBack(new Skill("Communication", 8));
        jobList.insertBack(new JobPosting(employer, "HR Intern", "Recruitment, employee relations", "RM750-RM850", "Bachelor in HR Management", skills));
        
        //employer 5
        employer = employerList.getPosition(5);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 10));
        jobList.insertBack(new JobPosting(employer, "Game Developer Intern", "Game design and development", "RM900-RM1100", "Diploma in Game Development", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 9));
        skills.insertBack(new Skill("Leadership", 4));
        jobList.insertBack(new JobPosting(employer, "Customer Support Intern", "Client assistance, troubleshooting", "RM700-RM800", "Diploma in any field", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 10));
        skills.insertBack(new Skill("Communication", 6));
        skills.insertBack(new Skill("Leadership", 7));
        jobList.insertBack(new JobPosting(employer, "Mobile App Developer Intern", "iOS/Android app development", "RM850-RM1000", "Diploma in Mobile Computing", skills));
        
        //employer 6
        employer = employerList.getPosition(6);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 9));
        jobList.insertBack(new JobPosting(employer, "Data Scientist Intern", "Machine learning, predictive modeling", "RM1000-RM1300", "Master in Data Science", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 5));
        skills.insertBack(new Skill("Communication", 9));
        jobList.insertBack(new JobPosting(employer, "Public Relations Intern", "Media relations, event planning", "RM750-RM850", "Bachelor in Communications", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 10));
        skills.insertBack(new Skill("Analysis", 8));
        jobList.insertBack(new JobPosting(employer, "Systems Analyst Intern", "System requirements analysis", "RM900-RM1100", "Bachelor in Information System", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 7));
        skills.insertBack(new Skill("Leadership", 9));
        skills.insertBack(new Skill("Analysis", 5));
        jobList.insertBack(new JobPosting(employer, "Sales Intern", "Client acquisition, sales support", "RM700-RM850", "Diploma in Business", skills));
        
        //employer 7
        employer = employerList.getPosition(7);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 9));
        skills.insertBack(new Skill("Analysis", 5));
        jobList.insertBack(new JobPosting(employer, "Embedded Systems Intern", "Firmware development, hardware integration", "RM950-RM1200", "Bachelor in IT", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 9));
        skills.insertBack(new Skill("Leadership", 3));
        jobList.insertBack(new JobPosting(employer, "Content Writer Intern", "Technical writing, content creation", "RM750-RM850", "Bachelor in English", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 5));
        skills.insertBack(new Skill("Programming", 8));
        skills.insertBack(new Skill("Leadership", 7));
        jobList.insertBack(new JobPosting(employer, "Database Admin Intern", "Database management, optimization", "RM850-RM950", "Diploma in Database Management", skills));
        
        //employer 8
        employer = employerList.getPosition(8);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 8));
        skills.insertBack(new Skill("Communication", 10));
        jobList.insertBack(new JobPosting(employer, "Event Management Intern", "Event planning, coordination", "RM700-RM850", "Diploma in Event Management", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 10));
        skills.insertBack(new Skill("Analysis", 7));
        jobList.insertBack(new JobPosting(employer, "Web Developer Intern", "Website development, maintenance", "RM800-RM950", "Diploma in Web Development", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 8));
        jobList.insertBack(new JobPosting(employer, "Social Media Intern", "Content creation, community management", "RM700-RM800", "Diploma in Marketing", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 8));
        skills.insertBack(new Skill("Communication", 6));
        jobList.insertBack(new JobPosting(employer, "Market Research Intern", "Data collection, analysis", "RM750-RM850", "Bachelor in Marketing", skills));
        
        //employer 9
        employer = employerList.getPosition(9);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 8));
        skills.insertBack(new Skill("Analysis", 8));
        jobList.insertBack(new JobPosting(employer, "AI Developer Intern", "AI model training, implementation", "RM1000-RM1300", "Bachelor in Computer Science", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 9));
        skills.insertBack(new Skill("Leadership", 8));
        skills.insertFront(new Skill("Analysis", 4));
        jobList.insertBack(new JobPosting(employer, "Customer Success Intern", "Client onboarding, support", "RM800-RM900", "Bachelor in Business", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Leadership", 7));
        skills.insertBack(new Skill("Communication", 8));
        jobList.insertBack(new JobPosting(employer, "Operations Intern", "Process improvement, logistics", "RM750-RM850", "Diploma in Business Management", skills));
        
        //employer 10
        employer = employerList.getPosition(10);
        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Programming", 8));
        skills.insertBack(new Skill("Analysis", 7));
        jobList.insertBack(new JobPosting(employer, "Cloud Engineer Intern", "Cloud deployment, maintenance", "RM950-RM1150", "Bachelor in Cloud Computing", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Communication", 8));
        skills.insertBack(new Skill("Leadership", 5));
        skills.insertBack(new Skill("Analysis", 7));
        jobList.insertBack(new JobPosting(employer, "Recruitment Intern", "Candidate screening, interviews", "RM700-RM800", "Diploma in Business", skills));

        skills = new DoublyLinkedList<>();
        skills.insertFront(new Skill("Analysis", 7));
        skills.insertBack(new Skill("Communication", 6));
        skills.insertFront(new Skill("Programming", 4));
        jobList.insertBack(new JobPosting(employer, "Business Intelligence Intern", "Data visualization, reporting", "RM850-RM1000", "Bachelor in Business Analytics", skills));
          
        return jobList;
    }
}
