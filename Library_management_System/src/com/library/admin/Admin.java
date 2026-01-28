package com.library.admin;
import java.util.Scanner;
import com.library.dao.BookDAO;

public class Admin {

	 public void adminMenu() {
	        Scanner sc = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n----- ADMIN MENU -----");
	            System.out.println("1. Add Book");
	            System.out.println("2. Update Book");
	            System.out.println("3. Delete Book");
	            System.out.println("4. View Books");
	            System.out.println("0. Exit Admin");

	            System.out.print("Enter choice: ");
	            choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                	 System.out.print("Enter book title: ");
	                	    sc.nextLine(); // clear buffer
	                	    String title = sc.nextLine();

	                	    System.out.print("Enter author name: ");
	                	    String author = sc.nextLine();

	                	    System.out.print("Enter quantity: ");
	                	    int qty = sc.nextInt();

	                	    BookDAO dao = new BookDAO();
	                	    dao.addBook(title, author, qty);
	                	    break;
	                case 2:
	                    System.out.println("Update Book selected");
	                    break;
	                case 3:
	                    System.out.println("Delete Book selected");
	                    break;
	                case 4:
	                    System.out.println("View Books selected");
	                    break;
	                case 0:
	                    System.out.println("Exiting Admin Menu...");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 0);
	    }
}
