package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



class data{
	Connection con;
	PreparedStatement ps;
	void dbsetup() throws SQLException, ClassNotFoundException {
		// 1. Load JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("1. JDBC Driver Loaded");

        // 2. Create Connection
        String url = "jdbc:mysql://localhost:3306/databasename ";
        String username = "root";
        String password = "";

         con = DriverManager.getConnection(url, username, password);
        System.out.println("2. Connection Created");
        

	}
}
public class admin extends data {
	
	void insert() throws SQLException  {
		Scanner sc = new Scanner(System.in);

        
        //1. User Input
        System.out.print("Enter Book Id: ");
        int id = sc.nextInt();

        System.out.print("Enter Book Name: ");
        String book = sc.next();

        System.out.print("Enter the Author name : ");
        String author = sc.next();

        
        // 2. SQL Query
        String insert = "INSERT INTO table_name(id, book, author) VALUES (?, ?, ?)";
        ps = con.prepareStatement(insert);
        System.out.println(". PreparedStatement Created");

        // 3. Set Values
        ps.setInt(1, id);
        ps.setString(2, book);
        ps.setString(3, author);

        // 4. Execute Query
        ps.executeUpdate();
        System.out.println("3. Data Inserted Successfully");

        // 5. Close Resources
        sc.close();
		
	}
	
	void update() throws SQLException {

		
		Scanner sc = new Scanner(System.in);
 
		//1. User Input
        System.out.print("Enter Book Id: ");
        int id = sc.nextInt();

        System.out.print("Enter Book Name: ");
        String book = sc.next();

        System.out.print("Enter the Author name : ");
        String author = sc.next();
        
     // 2. SQL Query
        String update = "UPDATE login SET book = ?,author =? WHERE id = ?";
        ps = con.prepareStatement(update);
        System.out.println(". PreparedStatement Created");

        // 3. Set Values
        ps.setString(1, book);
        ps.setString(2, author);
        ps.setInt(3, id);

        
     // 4. Execute Query
        ps.executeUpdate();
        System.out.println("3. Data Inserted Successfully");

        // 5. Close Resources
        sc.close();

	}
	
	
	
	void delete() throws SQLException {

		Scanner sc = new Scanner(System.in);
 
        // User Input
        System.out.print("1. Enter Book Id: ");
        int id = sc.nextInt();
     // 1. SQL Query
        String delete = "DELETE FROM table_name WHERE  id= ?";
        ps = con.prepareStatement(delete);
        System.out.println("2. PreparedStatement Created");
        
     // 2. Set Values
        ps.setInt(1, id);
        
     // 3. Execute Query
        ps.execute(delete);
        System.out.println("3. Data is Deleted ");
        	
		
	}
	
	void show() throws SQLException {
		
		
		// 1. SQL query
        String fetch = "SELECT * FROM student";

        // 2. Prepare statement
         ps = con.prepareStatement(fetch);

        // 3. Execute query
       
        ResultSet rs = ps.executeQuery();

        // 4. Read data
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " " +rs.getString("name") + " "+rs.getString("author")
            );
        }

        // 5. Close connection
        con.close();
        ps.close();
	}
	public static void main(String[] args) throws SQLException {

        admin ad = new admin();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ ADMIN MENU ------");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Show");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ad.insert();
                    break;

                case 2:
                    ad.update();
                    break;

                case 3:
                    ad.delete();
                    break;

                case 4:
                    ad.show();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
	

}
