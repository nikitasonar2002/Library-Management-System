package com.library.auth;

import java.util.Scanner;
import com.library.dao.UserDAO;
import com.library.user.UserMenu;

public class UserAuth {

    public static void userLoginRegister() {

        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAO();
        int choice;

        do {
            System.out.println("\n--- USER AUTH ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    if (dao.register(name, email, username, password)) {
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
                        new UserMenu().userMenu();
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
