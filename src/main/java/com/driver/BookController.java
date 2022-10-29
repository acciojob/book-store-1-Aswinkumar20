package com.driver;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookService;

    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;
    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // Your code goes here.
        Book newBook = bookService.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id){
        Book newBook = bookService.findById(id);
        return new ResponseEntity<>(newBook, HttpStatus.ACCEPTED);
    }


    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteById(@PathVariable("id") String id){
        bookService.deleteById(id);
        return new ResponseEntity("success", HttpStatus.ACCEPTED);
    }

    // get request /get-all-books
    // getAllBooks()

    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> allBooks = bookService.getBooks();
        return  new ResponseEntity<>(allBooks, HttpStatus.OK);
    }
    // delete request /delete-all-books
    // deleteAllBooks()

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("All books deleted", HttpStatus.ACCEPTED);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()

    @GetMapping("/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam("auhtor") String author){
        List<Book> book = bookService.findByAuthor(author);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBooksByGenre(@RequestParam("genre") String genre){
        List<Book> books = bookService.findByGenre(genre);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }
}
