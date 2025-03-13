/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import adt.DoublyLinkedListInterface;
import entity.Interview;

/**
 *
 * @author Taruc
 */
public class InterviewArrangementUI {
    public void scheduleUI(DoublyLinkedListInterface<Interview> interviewList){
        //System.out.println(interviewList.getPosition(1).getJobPostingID());
        System.out.println("\n+---------------------------+");
        System.out.println("| Date | Time | Job Title | Company Name |");
    }
}
