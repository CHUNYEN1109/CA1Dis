/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.account;

/**
 *
 * @author brad1109
 */
public class User {
    private String userId;
    private String password;
    private Pet pet;
    
    // constuctor

    public User() {
    }

    public User(String userId, String password, Pet pet) {
        this.userId = userId;
        this.password = password;
        this.pet = pet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", password=" + password + ", pet=" + pet + '}';
    }
    
    
    
    
}
