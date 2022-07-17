package com.BookStore.FlixBooks.Store.controller;

import com.BookStore.FlixBooks.Store.model.Book;
import com.BookStore.FlixBooks.Store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
@Controller
public class BookController {

    private final BookService bookService;
@Autowired
    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    //handler method to handle list of books and return model and view
    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";

    }
    @GetMapping("/books/new")
    public String createBookCatalog(Model model){
    //create book object to hold book catalog data
        Book book=new Book();
        model.addAttribute("book",book);
        return "create_book";
    }
    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book){
    //binding to the book Entity
        bookService.saveBook(book);
        return "redirect:/books"; //redirect to books method handler above
    }
    @GetMapping("/books/edit/{bookId}")
    public String editBookCatalog(@PathVariable Long bookId, Model model){
        model.addAttribute("book", bookService.getBookById(bookId));
    return "edit_book";
    }
    @PostMapping  ("/books/{bookId}")
    public String updateBook (@PathVariable("bookId") Long bookId,
        @ModelAttribute("book") Book book, Model model){
    //get book from database by Id
        Book existingBook=bookService.getBookById(bookId);

        existingBook.setBookId(bookId);
        existingBook.setAuthorFirstName(book.getAuthorFirstName());
        existingBook.setAuthorLastName(book.getAuthorLastName());
        existingBook.setCategory(book.getCategory());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setTitle(book.getTitle());
        existingBook.setYear(book.getYear());
        existingBook.setPrice(book.getPrice());

        //save updated book object
        bookService.updateBook(existingBook);
        return "redirect:/books";

    }
    // handler method to handle delete book request

    @GetMapping("/books/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/books";
    }



}