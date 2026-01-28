package com.library.user;
import java.util.Scanner;
import com.library.dao.BookDAO;
public class UserMenu {
	 public static void userMenu() {
	        Scanner sc = new Scanner(System.in);
	        BookDAO bookDAO = new BookDAO();

	        int choice;
	        do {
	            System.out.println("\n----- USER MENU -----");
	            System.out.println("1. View Books");
	            System.out.println("2. Search Book");
	            System.out.println("3. Borrow Book");
	            System.out.println("4. Return Book");
	            System.out.println("0. Exit User");
	            System.out.print("Enter choice: ");

	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                    bookDAO.viewBooks();
	                    break;
	                case 2:
	                    System.out.print("Enter book title: ");
	                    String title = sc.nextLine();
	                    bookDAO.searchBook(title);
	                    break;
	                case 3:
	                    System.out.print("Enter Book ID to borrow: ");
	                    int borrowId = sc.nextInt();
	                    bookDAO.borrowBook(borrowId);
	                    break;
	                case 4:
	                    System.out.print("Enter Book ID to return: ");
	                    int returnId = sc.nextInt();
	                    bookDAO.returnBook(returnId);
	                    break;
	                case 0:
	                    System.out.println("Exiting User Menu...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        } while (choice != 0);
	    }

}
