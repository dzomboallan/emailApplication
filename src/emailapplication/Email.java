/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emailapplication;

import java.util.Scanner;

/**
 *
 * @author hunnytaggy
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordSet = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";
    
    
    // Constructor to receive the last and first name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        
        // call method asking for the department - return the department
        this.department = setDepartment();
        
        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordSet);
        System.out.println("Your password is: "+this.password);
        
        // Combine elements to generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
    }
    
    // Ask for the department
    private String setDepartment(){
        System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        
        switch (depChoice) {
            case 1:
                return "sales";
            case 2:
                return "Development";
            case 3:
                return "Accounting";
            default:
                return "";
        }
    }
    
    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char [] password = new char[length];
        
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    
    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    
    // Change the password
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    
    public String getAlternameEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    
    public String showInfo(){
        return "DISPLAY NAME: "+firstName+" "+lastName+
                "\nCOMPANY EMAIL: "+email+
                "\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
    }
}
