package com.BookStore.FlixBooks.Store.service;

import com.BookStore.FlixBooks.Store.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    Book getBookById(Long bookId);
    Book updateBook(Book book);


    void deleteBookById(Long bookId);
}
