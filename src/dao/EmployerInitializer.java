/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.DoublyLinkedListInterface;
import entity.Employer;

/**
 *
 * @author Elaine
 */
public class EmployerInitializer {

    public DoublyLinkedListInterface<Employer> getEmployer() {
        DoublyLinkedListInterface<Employer> employerList = new DoublyLinkedList<>();

        employerList.insertBack(new Employer("Macrosoft", "Petaling Jaya", "macrobecausenotmicrosoft@gmail.com"));
        employerList.insertBack(new Employer("Amazoff", "Kuala Lumpur", "amazoffbecausenoton@gmail.com"));
        employerList.insertBack(new Employer("Mayblank", "Puchong", "mayblankbecausenomoney@gmail.com"));
        employerList.insertBack(new Employer("Goggle", "Selangor", "gogglebecauseswimming@gmail.com"));
        employerList.insertBack(new Employer("Facepaper", "Shah Alam", "noenoughpapermakebook@gmail.com"));
        employerList.insertBack(new Employer("Netflux", "Putrajaya", "netflukandburn@gmail.com"));
        employerList.insertBack(new Employer("Instakilogram", "Setapak", "instagrambutheavier@gmail.com"));
        employerList.insertBack(new Employer("Snapstalk", "Kepong", "snapstalk@gmail.com"));
        employerList.insertBack(new Employer("Toktik", "Ampang", "toktiktiktok@gmail.com"));
        employerList.insertBack(new Employer("Pineapple", "Cheras", "applebutwithpine@gmail.com"));
        return employerList;
    }
}
