package com.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.library.db.DBConnection;
import java.sql.ResultSet;



public class BookDAO {

	public void addBook(String title, String author, int quantity) {

        String sql = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);

            ps.executeUpdate();
            System.out.println("Book added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	public void viewBooks() {
	    String sql = "SELECT * FROM books";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        System.out.println("\nID | Title | Author | Qty");
	        while (rs.next()) {
	            System.out.println(
	                rs.getInt("book_id") + " | " +
	                rs.getString("title") + " | " +
	                rs.getString("author") + " | " +
	                rs.getInt("quantity")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void searchBook(String title) {
	    String sql = "SELECT * FROM books WHERE title ILIKE ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, "%" + title + "%");
	        ResultSet rs = ps.executeQuery();

	        boolean found = false;
	        while (rs.next()) {
	            found = true;
	            System.out.println(
	                rs.getInt("book_id") + " | " +
	                rs.getString("title") + " | " +
	                rs.getString("author") + " | " +
	                rs.getInt("quantity")
	            );
	        }

	        if (!found) {
	            System.out.println("No book found!");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void borrowBook(int bookId) {
	    String sql = "UPDATE books SET quantity = quantity - 1 WHERE  book_id  = ? AND quantity > 0";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, bookId);
	        int rows = ps.executeUpdate();

	        if (rows > 0)
	            System.out.println("Book borrowed successfully!");
	        else
	            System.out.println("Book not available!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public void returnBook(int bookId) {
	    String sql = "UPDATE books SET quantity = quantity + 1 WHERE  book_id = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, bookId);
	        ps.executeUpdate();
	        System.out.println("Book returned successfully!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
