/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Chea Ming Shen
 */
public class Skill {
    private String name;
    private int proficiency;

    public Skill(String name, int proficiency) {
        this.name = name;
        this.proficiency = proficiency;
    }
    
    // MingLi
    public Skill(Skill copy) {
        this(
        copy.name,
            copy.proficiency
        );
    }

    public String getName() {
        return name;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    
}
