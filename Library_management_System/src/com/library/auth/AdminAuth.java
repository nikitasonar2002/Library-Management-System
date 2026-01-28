package com.library.auth;

import java.util.Scanner;
import com.library.dao.AdminDAO;
import com.library.admin.Admin;

public class AdminAuth {

    public static void adminLoginRegister() {

        Scanner sc = new Scanner(System.in);
        AdminDAO dao = new AdminDAO();
        int choice;

        do {
            System.out.println("\n--- ADMIN AUTH ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter username: ");
                    String rUser = sc.nextLine();

                    System.out.print("Enter password: ");
                    String rPass = sc.nextLine();

                    if (dao.register(rUser, rPass)) {
                        System.out.println("Registration successful! Please login.");
                    }
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String lUser = sc.nextLine();

                    System.out.print("Enter password: ");
                    String lPass = sc.nextLine();

                    if (dao.login(lUser, lPass)) {
                        System.out.println("Login successful!");
                        new Admin().adminMenu();
                    } else {
                        System.out.println("Invalid username or password!");
                    }
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (true);
    }
}
