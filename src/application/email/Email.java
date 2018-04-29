package application.email;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;

    // Constructor to receive the first and last name 
    public Email(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

        //System.out.println("Email created : " + this.firstName + " " + this.lastName);

        //call a method asking for department - return the department
        this.department = setDepartment();
        //System.out.println("Department : " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is : " + this.password);
        
        //combine elements togenerate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("Your email is : " + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker: "+ firstName + "." +"\nDepartment code \n1 for Sales\n2 for development\n3 for Accounting\n\n0 for none\nEnter department code:");

        Scanner in = new Scanner(System.in);

        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }

    }

    //Generate random password
    private String randomPassword(int length) {

        String passwordSet = "abcdefghijklmnopqrstuxyz0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    //Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    //Set mail capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // get methods
    public String getPassword() {
        return password;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    
    public String showInfo(){
    
    return "DISPLAY NAME : "+ firstName + lastName + "\nCOMPANY EMAIL : " + email + "\nMAILBOX CAPACITY :" + mailboxCapacity + "mb";
    }
}