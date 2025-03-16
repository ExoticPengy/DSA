package boundary;


import entity.JobPosting;
import entity.Match;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */
public class MatchingUI {
    
    public void displayMatchHead() {
        System.out.println("\n+-------------------------------------------------+");
        System.out.println("|               Matched Job Postings                |");
        System.out.println("+--------------------------------------------------+");
    }
    
    public void displayJobMatches(Match match, int index) {
        JobPosting job = match.getJobPostingList().getPosition(index); 
        
        System.out.println("Employer name: " + job.getEmployer().getName());
        System.out.println("Title: " + job.getTitle());
        System.out.println("Description: " + job.getDescription());
        System.out.println("Salary Range: " + job.getSalaryRange());
        System.out.println("Qualification: " + job.getQualification());
        System.out.println("Skills Required: ");
        for (int j = 1; j <= job.getSkills().getCount(); j++) {
            System.out.println(j + ". " + job.getSkills().getPosition(j).getName() 
                    + ": " + job.getSkills().getPosition(j).getProficiency());
        }
        System.out.println("Matched Score: " + match.getMatchedScoreList().getPosition(index));
        System.out.println("--------------------------------------------------");
        
    }
}
