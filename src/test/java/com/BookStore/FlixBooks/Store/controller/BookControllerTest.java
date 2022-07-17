package com.BookStore.FlixBooks.Store.controller;

import com.BookStore.FlixBooks.Store.model.Book;
import com.BookStore.FlixBooks.Store.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;



@WebMvcTest
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnSavedEmployee() throws Exception{

        // given - precondition or setup
       Book book= Book.builder()
               .authorFirstName("Emma")
               .authorLastName("Pan")
               .title("Machine Learning")
               .publisher("London")
               .price(6000)
               .category("Computing")
               .year(2010)
               .build();
        given(bookService.saveBook(any(Book.class)))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)));

        // then - verify the result or output using assert statements
        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName",
                        is(book.getAuthorFirstName())))
                .andExpect(jsonPath("$.authorFirstName",
                        is(book.getAuthorLastName())))
                .andExpect(jsonPath("$.authorLatName",
                        is(book.getAuthorLastName())));

    }

    // JUnit test for Get All employees REST API
    @Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception{
        // given - precondition or setup
        List<Book> listOfBooks = new ArrayList<>();
       listOfBooks.add(Book.builder().authorFirstName("Emma").authorLastName("Press").build());
        listOfBooks.add(Book.builder().authorFirstName("Mani").authorLastName("Grey").build());
      // listOfBooks.add(Book.builder().firstName("Tony").lastName("Stark").email("tony@gmail.com").build());
        given(bookService.getAllBooks()).willReturn(listOfBooks);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/books/new"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfBooks.size())));

    }

}
