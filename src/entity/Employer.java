/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author mings
 */
public class Employer {
    private String employerId;
    private String name;
    private String email;

    public Employer(String employerId, String name, String email) {
        this.employerId = employerId;
        this.name = name;
        this.email = email;
    }

    public String getEmployerId() {
        return employerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
