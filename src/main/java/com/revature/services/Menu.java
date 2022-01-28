package com.revature.services;

import com.revature.models.Cashier;
import com.revature.models.Customer;
import com.revature.models.Manager;

import java.util.Scanner;

public class Menu {
    private int option;
    private Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void mainMenu(){
        do{
            System.out.println();
            System.out.println("1. Manager");
            System.out.println("2. Cashier");
            System.out.println("3. Customer");
            System.out.println("4. Exit");
            System.out.print("Enter User Type: ");
            option = scanner.nextInt();

            switch (option){
                case 1 :
                    managerMenu();
                    break;
                case 2 :
                    cashierMenu();
                    break;
                case 3 :
                    customerMenu();
                    break;
                case 4 :
                    System.exit(0);
                    break;
                default :
                    System.out.println("Error: Please enter valid input. (1) (2) (3) (4)");
            }
        } while(true);
    }

    private  void managerMenu() {
        Manager manager = new Manager();

        loop: while(true){
            System.out.println("1. Log In");
            System.out.println("2. Log Out");
            System.out.println("3. Approve Pending Accounts");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter Option: ");
            option = scanner.nextInt();

            switch (option){
                case 1 :
                    manager.logIn();
                    break;
                case 2 :
                    manager.logOut();
                    break;
                case 3 :
                    manager.approveAccounts();
                    break;
                case 4 :
                    break loop;
                default :
                    System.out.println("Error: Please enter valid input. (1) (2) (3) (4)");
            }
        }
    }

    private  void cashierMenu() {
        Cashier cashier = new Cashier();

        loop: while(true){
            System.out.println("1. Log In");
            System.out.println("2. Log Out");
            System.out.println("3. Write Cashiers Check");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter Option: ");
            option = scanner.nextInt();

            switch (option){
                case 1 :
                    cashier.logIn();
                    break;
                case 2 :
                    cashier.logOut();
                    break;
                case 3 :
                    cashier.wrightCashiersCheck();
                    break;
                case 4 :
                    break loop;
                default :
                    System.out.println("Error: Please enter valid input. (1) (2) (3) (4)");
            }
        }
    }

    private void customerMenu(){
        Customer customer = new Customer();

        loop: while(true){
            System.out.println("1. Register");
            System.out.println("2. Open Joint Account");
            System.out.println("3. Open Single Account");
            System.out.println("4. Close Account");
            System.out.println("5. Deposit");
            System.out.println("6. Withdraw");
            System.out.println("7. Current Balance");
            System.out.println("8. Exit");
            System.out.println();
            System.out.print("Enter Option: ");
            option = scanner.nextInt();

            switch (option){
                case 1 :
                    customer.register();
                    break;
                case 2 :
                    customer.openJointAccount();
                    break;
                case 3 :
                    customer.openSingleAccount();
                    break;
                case 4 :
                    customer.closeAccount();
                    break;
                case 5 :
                    customer.deposit(10);
                    break;
                case 6 :
                    customer.withdraw(10);
                    break;
                case 7 :
                    customer.currentBalance();
                    break;
                case 8 :
                    break loop;
                default :
                    System.out.println("Error: Please enter valid input. (1) (2) (3) (4) (5) (6) (7) (8)");
            }
        }
    }
}