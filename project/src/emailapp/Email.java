package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int passwordLength = 10;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	// constructor for first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		
		// call a method that retursn a random password
		this.password = randomPassword(passwordLength);
		System.out.println("Your password is: " + this.password);
		
		// combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	// ask for department
	private String setDepartment() {
		System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Devlopment\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner console = new Scanner(System.in);
		int depChoice = console.nextInt();
		if (depChoice ==1) {
			return "sales";
		} else if (depChoice == 2) {return "dev";}
		else if (depChoice ==3) {return "acct";}
		else {
			return "";
		}
	}
	
	private String randomPassword(int length) {
		String passwordSet = "ABDCEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		
		return new String(password);
	}
	
	// set mailbox capacity
	public void setMailbocCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	// set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword() {return password;}
	
	public String showInfo() {
		return"DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL: " + email + " " + 
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
	
}
