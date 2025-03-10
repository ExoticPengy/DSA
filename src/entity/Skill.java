/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mings
 */
public class Skill {
    private int commScore;      //communication
    private int leaderScore;    //leadership
    private int appDevScore;    //app development
    private int analysisScore;  //data analysis

    public Skill(int commScore, int leaderScore, int appDevScore, int analysisScore) {
        this.commScore = commScore;
        this.leaderScore = leaderScore;
        this.appDevScore = appDevScore;
        this.analysisScore = analysisScore;
    }

    public int getCommScore() {
        return commScore;
    }

    public int getLeaderScore() {
        return leaderScore;
    }

    public int getAppDevScore() {
        return appDevScore;
    }

    public int getAnalysisScore() {
        return analysisScore;
    }

    public void setCommScore(int commScore) {
        this.commScore = commScore;
    }

    public void setLeaderScore(int leaderScore) {
        this.leaderScore = leaderScore;
    }

    public void setAppDevScore(int appDevScore) {
        this.appDevScore = appDevScore;
    }

    public void setAnalysisScore(int analysisScore) {
        this.analysisScore = analysisScore;
    }
    
    
}
