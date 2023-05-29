package com.gspann.restapp.controller;

import com.gspann.restapp.service.BookService;
import com.gspann.restapp.model.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping()
    @ApiOperation(value = "This is API To Get List Book  of All Books ", response = Book.class, tags = "Get List Of All Books Present")
    public ResponseEntity<List<Book>> getListOfAllBooks() {

        return bookService.getListOfAllBooks();
    }



    @PostMapping()
    @ApiOperation(value = "This is Api Used to add the Book into Library ", response = Book.class, tags = "Create/Insert The Book")
    public ResponseEntity<Book> createBook(@ApiParam("Information about Books to be added") @Valid @RequestBody Book book) {

        return bookService.createBooks(book);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "This is Api  To Update Book Data By Id ", response = Book.class, tags = "Update Book Content Corresponding To  Particular Id")
    public Optional<Book> updateBook(@ApiParam("Information about Books to be Update Data") @PathVariable("id") long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "This is Api To Delete Book Data By Id", response = Book.class, tags = "Delete The Book Corresponding  To Particular Id")
    public ResponseEntity<Book> deleteBookById(@ApiParam("Enter The Id of Book which is to be delete") @PathVariable("id") long id) {
        return bookService.deleteBookById(id);

    }
    @GetMapping("/{id}")
    @ApiOperation(value = "This is Api To Get Book Details By Id", response = Book.class, tags = "Get The Single Book Data Corresponding To Id")
    public Optional<Book> getBookById(@ApiParam("Enter the Boook Id To Fetch Particular Book ") @PathVariable long id) {
        System.out.println("id>>>>>>>>>>" + id);
        return bookService.getBookById(id);
    }
}
