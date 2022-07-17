package com.BookStore.FlixBooks.Store.service.bookServiceImplementation;

import com.BookStore.FlixBooks.Store.model.Book;
import com.BookStore.FlixBooks.Store.repository.BookRepo;
import com.BookStore.FlixBooks.Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepo.findById(bookId).get();
    }


    @Override
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepo.deleteById(bookId);
    }


}