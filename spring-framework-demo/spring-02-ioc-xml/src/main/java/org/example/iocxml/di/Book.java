package org.example.iocxml.di;

public class Book {
    private String bookName;
    private String author;

    public Book() {
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    /**
     * 默认实现
     */
    public static void main(String[] args) {
        // set方法注入
        Book book = new Book();
        book.setBookName("Java从入门到精通");
        book.setAuthor("J");

        // 构造器注入
        Book book1 = new Book("Java从入门到精通", "J");


    }
}
