package assignment.service;

import assignment.model.Book;

public class BookService {

    //muon sach
    public void borrowbook(Book book) {
        String bookName = book.getName();
        int bookId = book.getId();
    }

    public void getBook(Book book) {
        String bookName = book.getName();
        int bookId = book.getId();
    }
    public int area( int a, int b,int c) {
        return a+b+c;
    }
}
