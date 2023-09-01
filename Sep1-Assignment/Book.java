package com.book;


public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    public Book(String bookId,String title,String author,String category,double price){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;

    }
    public Book(){}

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return bookId+" "+title+" "+ author+ " "+category+" "+price;
    }
}
