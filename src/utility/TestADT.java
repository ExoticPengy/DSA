package utility;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Skill;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author USER
 */
public class TestADT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedListInterface<Skill> skills = new DoublyLinkedList<>();
        
        Skill communication1 = new Skill("Communication", 5);
        Skill communication2 = new Skill("Communication", 7);
        
        skills.insertFront(communication1);
        if(skills.contains(communication2)) {
            System.out.println("Exists");
        } else {
            System.out.println("Does not");
        }
    }
    
}
