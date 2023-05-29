package com.gspann.restapp.exception;


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book Not Found...!");
    }


}