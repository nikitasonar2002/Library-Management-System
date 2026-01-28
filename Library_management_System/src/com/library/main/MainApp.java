package com.library.main;
import java.util.Scanner;
import com.library.admin.Admin;
import com.library.user.UserMenu;
import com.library.auth.AdminAuth;
import com.library.auth.UserAuth;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=================================");
        System.out.println(" Welcome to Library Management ");
        System.out.println("=================================");

        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin();

        int choice;

        do {
            System.out.println("\n====== LIBRARY SYSTEM ======");
            System.out.println("1. Admin ");
            System.out.println("2. User");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
//                    admin.adminMenu();
                	 AdminAuth.adminLoginRegister();
                    break;
                case 2:
//                    UserMenu.userMenu();
                	 UserAuth.userLoginRegister();
                    break;
                case 0:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
	}


