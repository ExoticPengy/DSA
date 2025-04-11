/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author MingLi
 */
public class Discrepancy {
    private int setNo;
    private int amount;

    public Discrepancy(int setNo, int amount) {
        this.setNo = setNo;
        this.amount = amount;
    }

    public int getSetNo() {
        return setNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setSetNo(int setNo) {
        this.setNo = setNo;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void incrementAmount() {
        this.amount += 1;
    }

    @Override
    public String toString() {
        return "Discrepancy{" + "setNo=" + setNo + ", amount=" + amount + '}';
    }
    
    
}
