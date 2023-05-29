package com.gspann.restapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(readOnly = true,notes = "Book Id ",name="id",required=false,value="This is Book id Auto Generated No Need To Enter")
    private Long id;
    @ApiModelProperty(notes = "Book isbn ",name="isbn",example = "978-56565",required=true,value="This is Isbn No. Of Book")
    private String isbn;

    @NotNull
    @ApiModelProperty(notes = "Book Name",name="bookName",example="Test Book Name ",required=true,value="This is Book Name")
    private String bookName;
    @NotNull
    @ApiModelProperty(notes = "Book Author",name="author",example="Test Book Author",required=true,value="This is Book's Author Name")
    private String author;
    @ApiModelProperty(notes = "No. Of Copies Books",example="100 ",name="copies",required=true,value="This is No. of Copies of Books")
    @NotNull
    private Integer copies;


    public Book(String isbn, String bookName, String author, Integer copies) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.copies = copies;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", copies=" + copies +
                '}';
    }
}
