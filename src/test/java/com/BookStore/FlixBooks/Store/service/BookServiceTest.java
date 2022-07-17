package com.BookStore.FlixBooks.Store.service;

import com.BookStore.FlixBooks.Store.model.Book;
import com.BookStore.FlixBooks.Store.repository.BookRepo;
import com.BookStore.FlixBooks.Store.service.bookServiceImplementation.BookServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
    class BookServiceTest {

        @Mock
        private BookRepo bookRepo;

        @InjectMocks
        private BookServiceImpl bookService;

        private Book book;

        @BeforeEach
        public void setup(){
           book = Book.builder()
                    .bookId(1L)
                    .authorFirstName("Emma")
                    .authorLastName("Press")
                    .title("Machine Learning")
                    .publisher("London")
                    .price(6000)
                    .category("Computing")
                    .year(2010)
                    .build();
        }

        /*  // JUnit test for saveEmployee method
        @DisplayName("JUnit test for saveEmployee method")
        @Test
        public void givenBookObject_whenSaveBook_thenReturnBookObject(){
            // given - precondition or setup
            given(bookRepo.findById(book.getBookId()))
                    .willReturn(Optional.empty());


            given(bookRepo.save(book)).willReturn(book);

            System.out.println(bookRepo);
            System.out.println(bookService);

            // when -  action or the behaviour that we are going test
           Book savedBook = bookService.saveBook(book);

            System.out.println(savedBook);
            // then - verify the output
            assertThat(savedBook).isNotNull();
        }

        // JUnit test for saveEmployee method
      @DisplayName("JUnit test for saveEmployee method which throws exception")
        @Test
        public void givenExistingEmail_whenSaveEmployee_thenThrowsException(){
            // given - precondition or setup
            given(bookRepo.findById(book.getBookId()))
                    .willReturn(Optional.of(book));

            System.out.println(bookRepo);
            System.out.println(bookService);

            // when -  action or the behaviour that we are going test
            //org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
               // bookService.saveBook(book);
            //});

            // then
            verify(bookRepo, never()).save(any(Book.class));
        }*/

        // JUnit test for getAllEmployees method
        @DisplayName("JUnit test for getAllEmployees method")
        @Test
        public void givenEmployeesList_whenGetAllEmployees_thenReturnEmployeesList(){
            // given - precondition or setup

          Book book1 = Book.builder()
                  .bookId(1L)
                  .authorFirstName("Emma")
                  .authorLastName("Press")
                  .title("Machine Learning")
                  .publisher("London")
                  .price(6000)
                  .category("Computing")
                  .year(2010)
                  .build();

            given(bookRepo.findAll()).willReturn(List.of(book,book1));

            // when -  action or the behaviour that we are going test
            List<Book> bookList = bookService.getAllBooks();

            // then - verify the output
            assertThat(bookList).isNotNull();
            assertThat(bookList.size()).isEqualTo(2);
        }

        // JUnit test for getAllEmployees method
        @DisplayName("JUnit test for getAllEmployees method (negative scenario)")
        @Test
        public void givenEmptyBooksList_whenGetAllBooks_thenReturnEmptyBooksList(){
            // given - precondition or setup

            Book book1 = Book.builder()
                    .bookId(1L)
                    .authorFirstName("Emma")
                    .authorLastName("Press")
                    .title("Machine Learning")
                    .publisher("London")
                    .price(6000)
                    .category("Computing")
                    .year(2010)
                    .build();

            given(bookRepo.findAll()).willReturn(Collections.emptyList());

            // when -  action or the behaviour that we are going test
            List<Book> bookList = bookService.getAllBooks();

            // then - verify the output
            assertThat(bookList).isEmpty();
            assertThat(bookList.size()).isEqualTo(0);
        }

        // JUnit test for getEmployeeById method
        @DisplayName("JUnit test for getEmployeeById method")
        @Test
        public void givenBookId_whenGetBookById_thenReturnBookObject(){
            // given
            given(bookRepo.findById(1L)).willReturn(Optional.of(book));

            // when
           Book savedBook = bookService.getBookById(book.getBookId());
                   //.get();

            // then
            assertThat(savedBook).isNotNull();

        }

        // JUnit test for updateEmployee method
        @DisplayName("JUnit test for updateEmployee method")
        @Test
        public void givenBookObject_whenUpdateBook_thenReturnUpdatedBook(){
            // given - precondition or setup
            given(bookRepo.save(book)).willReturn(book);
            book.setAuthorFirstName("Shake");
            book.setAuthorLastName("Mani");
            // when -  action or the behaviour that we are going test
            Book updatedBook = bookService.updateBook(book);

            // then - verify the output
            assertThat(updatedBook.getAuthorFirstName()).isEqualTo("Shake");
            assertThat(updatedBook.getAuthorLastName()).isEqualTo("Mani");
        }

        // JUnit test for deleteEmployee method
        @DisplayName("JUnit test for deleteEmployee method")
        @Test
        public void givenBookId_whenDeleteBook_thenNothing(){
            // given - precondition or setup
            long bookId = 1L;

            willDoNothing().given(bookRepo).deleteById(bookId);

            // when -  action or the behaviour that we are going test
            bookService.deleteBookById(bookId);

            // then - verify the output
            verify(bookRepo, times(1)).deleteById(bookId);
        }
    }