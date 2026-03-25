/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.account;

/**
 *
 * @author brad1109
 */
public class Pet {
    private String name;
    private int level;
    private int credit;

    public Pet() {
    }

    public Pet(String name, int level, int credit) {
        this.name = name;
        this.level = level;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Pet{" + "name=" + name + ", level=" + level + ", credit=" + credit + '}';
    }
    
    
}
