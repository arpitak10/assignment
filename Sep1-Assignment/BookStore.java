//it is the BookStore(DAO) class
//Design a class called BookStore which contains an appropriate collection object to store Book instances. 
//Implement the below operations. 
//1. addBook(Book b)     To add a new Book object into the book table 
//2. searchByTitle(String title)   Search a book from DB based on title and if found, display the details 
//3. searchByAuthor(String author) Search a book from DB based on author and if found, display the details 
//4. displayAll()  Print the details of all the books 
//Perform the below validations 
//1• Category must be “Science”, “Fiction”, “Technology” or “Others” 
//2• Price cannot be negative 
//3• bookID must start with ‘B’ and must be of length 4 characters 



package com.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookStore {
    private static String url = "jdbc:mysql://localhost:3306/gain";

    public boolean addEmployee(Book b){
        int count = 0;
        try(Connection con = DriverManager.getConnection(url,"root","Arpitak@10");
            PreparedStatement pst = con.prepareStatement("insert into book values(?,?,?,?,?)")){
            pst.setString(1,b.getBookId());
            pst.setString(2,b.getTitle());
            pst.setString(3,b.getAuthor());
            pst.setString(4,b.getCategory());
            pst.setDouble(5,b.getPrice());
            if(!(b.getCategory().equals("Science") || b.getCategory().equals("Fiction") || b.getCategory().equals("Technology") || b.getCategory().equals("Others"))){
                System.out.println("book category");
                count = 0;}
            else if (b.getPrice()<0) {
                System.out.println("book price");
                count = 0;

            } else if (!(b.getBookId().startsWith("B") && b.getBookId().length()==4)) {
                System.out.println("book length");
                count = 0;
            }
            else

                count = pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count == 1;

    }
    public Book searchByTitle(String bookTitle){
        Book b = null;
        try (Connection con = DriverManager.getConnection(url,"root","Arpitak@10");
             PreparedStatement pst = con.prepareStatement("select * from book where title=?")){
            pst.setString(1,bookTitle);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                b = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
        }
        catch (Exception ex){
            ex.printStackTrace();;
        }
        return b;
    }

    public ArrayList<Book> searchByAuthor(String bookAuthor){
        ArrayList<Book> blist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("select * from book where author = ?")){
             pst.setString(1,bookAuthor);
             ResultSet rs = pst.executeQuery();
             while (rs.next())
                 blist.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5) ));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return blist;

    }
    public ArrayList<Book> displayAll(){
        ArrayList<Book> blist = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "root", "Arpitak@10");
             PreparedStatement pst = con.prepareStatement("select * from book")){
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                blist.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));

            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return blist;

    }


}
