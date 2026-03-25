/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.manager;
import data.account.User;
import data.account.Pet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author brad1109
 */
public class AccountManager {
    Map<String, User> accountDB = new HashMap<>(); 
    // key == userId; value == User
    // Constructor for mock DB

    public AccountManager() {
        // objects
        Pet p1 = new Pet("Cat",5,10);
        User u1 = new User("u1","password1",p1);
        
        Pet p2 = new Pet("Dog",3,20);
        User u2 = new User("u2","password2",p2);
        
        
        // store 
        accountDB.put(u1.getUserId(), u1);
        accountDB.put(u2.getUserId(), u2);
        
    }
    // methods; operations 
    public User getUser(String id){
        return accountDB.get(id);
    }
    
    public boolean contains(String id){
        if(accountDB.containsKey(id)) return true;
        return false;
    }
    
    public boolean validate(String id, String password){
        // if it didn't exist
        if(id == null || password == null) return false;
        
        User user = accountDB.get(id);
        if(user == null) return false;
        return user.getPassword().equals(password);
    }
    
    
    
    public static void main(String[] args){
        // test
        AccountManager am = new AccountManager();
        String s = am.getUser("u1").toString();
        System.out.println(s);
        
        System.out.println("contains method test");
        System.out.println(am.contains("u3"));
        
        System.out.println("validate method test");
        System.out.println(am.validate("u1", "password1"));
        System.out.println(am.validate("u1", "password2"));
        
    }
    
}
