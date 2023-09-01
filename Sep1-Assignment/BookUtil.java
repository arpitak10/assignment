//Main function is BookUtil with the package bookUtil  and here InvalidBookException also makes
//Create a class BookUtil in package com.bookutil which has the main method. 
//1• Instantiate the BookStore class 
//2• Read data from user for 3 Book objects. 
//3• Call the addBook method to add the book objects into the collection 
//4• Search the books by title and author 
//5• Display all the book details 
package com.bookUtil;

import com.book.Book;
import com.book.BookStore;

import java.util.ArrayList;
import java.util.Scanner;
class InvalidBookException extends RuntimeException{
    private String message = "Input is not valid";
    public InvalidBookException(){

    }
    public String toString(){
        return "InvalidBookException:" +message;
    }
}

public class BookUtil {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        BookStore bs = new BookStore();
        boolean flag = false;
        while (true){

            System.out.println("1. Add Employee details");
            System.out.println("2. Search book by author name");
            System.out.println("3. Search book by title name");
            System.out.println("4 Display all Book Details");
            System.out.println("5 Exit");
            int key = sc.nextInt();
            switch (key) {
                case 1:
                    System.out.println("Adding Details");
                    for (int i = 1; i <= 3; i++) {
                        System.out.println("Enter the book id");
                        String book_id = sc.next();
                        System.out.println("Enter the title");
                        String book_title = sc.next();
                        System.out.println("Enter the Author");
                        String book_author = sc.next();
                        System.out.println("Enter the category");
                        String book_category = sc.next();
                        System.out.println("Enter the price");
                        Double book_price = sc.nextDouble();
                        Book book = new Book(book_id, book_title, book_author, book_category, book_price);
                        if (bs.addEmployee(book)) {
                            System.out.println("Successfully data is I N S E R T E D");
                        } else {
                            throw new InvalidBookException();
                        }
                    }
                    break;

                case 2:

                    System.out.println("Search book by author name");
                    ArrayList<Book> b1 = bs.displayAll();
                    String auth_name = sc.next();
                    b1 = bs.searchByAuthor(auth_name);
                    for(Book b:b1){
                        System.out.println(b);
                    }
                    break;
                case 3:

                    System.out.println("Search book by title name");
                    System.out.println(bs.searchByTitle(sc.next()));
                    break;

                case 4:

                    System.out.println("Displaying all the book details");
                    b1 = bs.displayAll();
                    for(Book b:b1){
                        System.out.println(b);
                    }
                    break;

                default:
                    flag = true;
            }
            if (flag==true)
                break;
    }

    }
}
