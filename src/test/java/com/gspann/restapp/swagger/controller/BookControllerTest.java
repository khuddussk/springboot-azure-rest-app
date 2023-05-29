package com.gspann.restapp.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gspann.restapp.controller.BookController;
import com.gspann.restapp.model.Book;
import com.gspann.restapp.repositry.BookRepository;
import com.gspann.restapp.service.BookService;
import com.gspann.restapp.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private  ObjectMapper objectMapper;

    @MockBean
    BookRepository bookRepository;

    @MockBean
    BookService bookService;





   @Test
    void getListOfAllBooks() throws Exception {
        List<Book> bookList = new ArrayList<>(
                Arrays.asList(new Book("11-434-555", "Spring Boot Name 1", "Book Author Name 1", 11),
                        new Book("12-434-555", "Spring Boot Name 2", "Book Author Name 2" , 12),
                        new Book("13-434-555", "Spring Boot Name 3", "Book Author Name", 13)));

        when(bookRepository.findAll()).thenReturn(bookList);
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    void DeleteBookById() throws Exception {
        long id = 1L;

        doNothing().when(bookRepository).deleteById(id);
        mockMvc.perform(delete("/api/books/{id}", id))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
