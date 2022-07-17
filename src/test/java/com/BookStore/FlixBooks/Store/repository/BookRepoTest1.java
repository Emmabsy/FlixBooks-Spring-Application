package com.BookStore.FlixBooks.Store.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.BookStore.FlixBooks.Store.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


@DataJpaTest
class BookRepoTest1 {

    @Autowired
    private BookRepo bookRepo;
    private Book book;

    @BeforeEach
    public void setup(){
        book = Book.builder()
                .authorFirstName("Emma")
                .authorLastName("Press")
                .title("Machine Learning")
                .publisher("London")
                .price(6000)
                .category("Computing")
                .year(2010)
                .build();
    }
    // JUnit test for save book operation
    //@DisplayName("JUnit test for save book operation")
    @Test
    public void givenBookObject_whenSave_thenReturnSavedBook(){

        //given - precondition or setup
        Book book = Book.builder()
                .authorFirstName("Emma")
                .authorLastName("Pan")
                .title("Machine Learning")
                .publisher("London")
                .price(6000)
                .category("Computing")
                .year(2010)
                .build();

        // when - action or the behaviour that we are going test
        Book savedBook = bookRepo.save(book);

        // then - verify the output
        assertThat(savedBook).isNotNull();
        assertThat(savedBook.getBookId()).isGreaterThan(0);
    }

    // JUnit test for get all books operation
   /* @DisplayName("JUnit test for get all employees operation")
    @Test
    public void givenBooksList_whenFindAll_thenBooksList(){
        // given - precondition or setup

        Book book1 = Book.builder()
                .authorFirstName(",King")
                .authorLastName("May")
                .title("Aliens")
                .publisher("Newyork")
                .price(4000)
                .category("Cosmos")
                .year(2008)
                .build();

        bookRepo.save(book);
        bookRepo.save(book1);

        // when -  action or the behaviour that we are going test
        List<Book> bookList = bookRepo.findAll();

        // then - verify the output
        assertThat(bookList).isNotNull();
        assertThat(bookList.size()).isEqualTo(2);

    }
    */

    // JUnit test for get book by id operation
    @DisplayName("JUnit test for get book by id operation")
    @Test
    public void givenBookObject_whenFindById_thenReturnBookObject(){

       bookRepo.save(book);

        // when -  action or the behaviour that we are going test
       Book bookDB = bookRepo.findById(book.getBookId()).get();

        // then - verify the output
        assertThat(bookDB).isNotNull();
    }
    // JUnit test for update book operation
   // @DisplayName("JUnit test for update book operation")
    //@Test
    /*public void givenBookObject_whenUpdateBook_thenReturnUpdatedBook(){

        bookRepo.save(book);

        // when -  action or the behaviour that we are going test
      Book savedBook = bookRepo.findById(book.getBookId()).get();
        savedBook.setAuthorFirstName("Emma");
        savedBook.setAuthorLastName("Press");
        savedBook.setPrice(6000);
        savedBook.setYear(2010);
        savedBook.setPublisher("Newyork");
        savedBook.setTitle("Machinne Learning");
        savedBook.setCategory("Computing");
       Book updatedBook =  bookRepo.save(savedBook);

        // then - verify the output
        assertThat(updatedBook.getAuthorFirstName()).isEqualTo("Emms");
        assertThat(updatedBook.getAuthorLastName()).isEqualTo("PressK");
        assertThat(updatedBook.getCategory()).isEqualTo("Computing");
        assertThat(updatedBook.getPrice()).isEqualTo(6000);
        assertThat(updatedBook.getTitle()).isEqualTo("Machine Learning");
        assertThat(updatedBook.getAuthorLastName()).isEqualTo("PressK");
        assertThat(updatedBook.getPublisher()).isEqualTo("Newyork");
    }*/


    // JUnit test for delete employee operation
    @DisplayName("JUnit test for delete book operation")
    @Test
    public void givenBookObject_whenDelete_thenRemoveBook(){

        bookRepo.save(book);

        // when -  action or the behaviour that we are going test
        bookRepo.deleteById(book.getBookId());
        Optional<Book> bookOptional = bookRepo.findById(book.getBookId());

        // then - verify the output
        assertThat(bookOptional).isEmpty();
    }
}