import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class MyBank {
	public static void main(String[] args) {
		System.out.println("^^^^^^^^^^^Welocme to National Banking System^^^^^^^^^");
		System.out.println("\n");
		System.out.println("Do you wnt to open an account in my service: 1. yes 2.No");
		
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
				
		if (choice.equalsIgnoreCase("yes")) {
			OpenAccount obj =new OpenAccount();
			obj.createAccount();
		}
		
		if(choice.equalsIgnoreCase("No")) {
			BankAccount obj1 = new BankAccount();
			obj1.showMenu();			
		}
	}

}

class OpenAccount{
	String name;
	int accountNum;
	String accountType;
	
	String dob;
	String bank;
	
	void createAccount() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("In which bank you want to open it:1.Union 2.paytm 3.HDFC");
		int choiceBank = sc.nextInt();
		if(choiceBank ==1) {
			bank ="Union";
		}
		if (choiceBank ==2) {
			bank ="paytm";
		}
		if (choiceBank ==3) {
			bank ="HDFC";
		}
		
		System.out.println("Please enter your name:");
		sc.nextLine();
		name =sc.nextLine();
		
		System.out.println("Please enter your data of birth:");
		dob =sc.nextLine();
		
		System.out.println("what type of account you want to open :1.Saving 2.Current");
		int choice =sc.nextInt();		
		if(choice ==1) {
			accountType = "Saving";
		}
		if(choice ==2) {
			accountType = "Current";
		}
		
		System.out.println("Your account has been opened with following details");
		System.out.println("Bank: " + bank);
		System.out.println("Name: " + name);
		System.out.println("DOB: " + dob);
		System.out.println("Account Type: " +accountType);
		System.out.println("Account Number: "+ Math.random());
		
		System.out.println("\n");
		
		BankAccount obj1 =new BankAccount();
		obj1.showMenu();
		sc.close();		
	}
}

class BankAccount{
	int balance;
    int previousTransaction;
	String customername;
	String CustomerId;
	String accountType;
	
	double totalInterest;
	
	void calculateInterest(double balance) {
		System.out.println("What type of account you have: 1.Saving 2. Current");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if(choice == 1) 
		{
			accountType = "Savinng";
			int r =5;
			int t;
			System.out.println("Enter year to calculate interest");
			t = sc.nextInt();
			
			double finalAmount = balance * (1 + r * t);
			
			totalInterest = finalAmount - balance;
			System.out.println("total interest earned is: " + totalInterest);
			sc.close();			
		  }		
		}
	 void deposite(int amount) {
		 if(amount != 0) {
			 balance =balance +amount;
			 System.out.println("Balance after deposit:" + balance);
			 previousTransaction = amount;
		 }
	 }
	 
	 void withdraw(int amount) {
		 if(amount !=0) {
			 balance = balance -amount;
			 System.out.println("Balance after withdraw "+ balance);
			 previousTransaction = -amount;
		 }
	 }
	 
	 void getPreviousTransaction() {
		 
		 FileOutputStream out;
		 PrintStream p;
		 
		 try {
			 out = new FileOutputStream ("C:\\Users\\Dhara\\eclipse-workspace\\Project_2\\src");
			 p = new PrintStream(out);
			 
			 if (previousTransaction > 0) {
				 p.append("Deposited: "+ previousTransaction );
				 System.out.println("Deposited: "+ previousTransaction);
				 
			 }else if(previousTransaction <0) {
				 p.append("withdrawn" +previousTransaction);
				 System.out.println("withdrawn" +previousTransaction);
			 }else {
				 System.out.println("No Transaction occured");
			 }
			 
			 p.close();
			 
		 }catch(Exception e) {
			 System.out.println("Error in printing the data " + e);
		 }
	 }
	 
	 void showMenu() {
		 char option = '\0';
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Welcome to the menu");
		 System.out.println("\n");
		 System.out.println("A. check Balance");
		 System.out.println("B. Deposite Amount");
		 System.out.println("C. Withdraw amount");
		 System.out.println("D. see previous trnsaction");
		 System.out.println("E. Calculate Interest");
		 System.out.println("F. Exit");
		 
		 
		 do {
			 System.out.println("<<<<<<<<<<<<<<<.>>>>>>>>>>");
			 System.out.println("Enter an option");
			 System.out.println("<<<<<<<<<<<<<<<.>>>>>>>>>>");
			 option = scanner.next().charAt(0);
			 System.out.println("\n");
			 
			 switch(option) {
			 case 'A':
				 System.out.println("<<<<<<<<<<<<<.>>>>>>>>>>");
				 System.out.println("Balance ="+balance);
				 System.out.println("\n");
				 break;
				 
			 case 'B':
				 System.out.println("<<<<<<<<<<<<<<<.>>>>>>>>>");
				 System.out.println("Enter an amount to deposite:");
				 int amount = scanner.nextInt();
				 deposite(amount);
				 System.out.println("\n");
				 break;
				 
			 case 'C':
				 System.out.println("<<<<<<<<<<<<<<<.>>>>>>>>>>");
				 System.out.println("Enter an amount to withdraw");
				 int amount2 = scanner.nextInt();
				 withdraw(amount2);
				 System.out.println("\n");
				 break;
				 
			 case 'D':
				 System.out.println("<<<<<<<<<<<<<<.>>>>>>>>>>>");
				 getPreviousTransaction();
				 System.out.println("\n");
				 break;
				 
			 case 'E':
				 System.out.println("<<<<<<<<<<<<<<.>>>>>>>>>>>>");
				 calculateInterest(balance);
				 System.out.println("\n");
				 break;
				 
			 case 'F':
				 System.out.println("Entered Invalid option...Please enter Again");
				 break;
			 }
		 }while(option != 'F');
		 System.out.println("Thank you for using our services");
		 scanner.close();
	 }
		
}
