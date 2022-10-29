package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // this is the main class which executes the functions for us:

    // now we need repostrory object to perform the required actions:

    @Autowired
    BookRepository bookreopository;       // object of that clas


    // foremost queryis to create data:
    public Book createBook(Book book){

        return bookreopository.create(book);
    }

    // now the major query is to manipulate the data:

    public Book findById(String id){
        return bookreopository.findById(Integer.valueOf(id));

    }

    public List<Book> findByAuthor(String author){
        return bookreopository.findByAuthor(author);
    }

    public List<Book> findByGenre(String genre){
        return bookreopository.findByGenre(genre);
    }

    public void deleteById(String id){
        bookreopository.deleteById(Integer.valueOf(id));
    }

    public void deleteAllBooks(){
        bookreopository.deleteAllBooks();
    }

    public List<Book> getBooks(){
        return bookreopository.getBooks();
    }



}

