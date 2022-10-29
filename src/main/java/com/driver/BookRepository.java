package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Repository
public class BookRepository {


    // it have default constructor:
    // now define the book structure here

    List<Book> CollectionsOfBook = new ArrayList<>();
    int id = 1;    // when we start it will be one:


    public Book findById(int id) {
        // finding by the id
        // getting size of the book list:
        int length = CollectionsOfBook.size();
        for(int i=0; i<length; i++){
            if(CollectionsOfBook.get(i).getId() == id){
                return CollectionsOfBook.get(i);
            }
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {

        // we need new list of all matching auhtor books
        List<Book> AuthorBooks = new ArrayList<>();
        int length = CollectionsOfBook.size();
        for(int i=0; i<length; i++){
            if(Objects.equals(CollectionsOfBook.get(i).getAuthor(), author)){
                AuthorBooks.add(CollectionsOfBook.get(i));
            }
        }
        return AuthorBooks;
    }

    public List<Book> findByGenre(String genre) {
        // we need new list of all matching genre books
        List<Book> GenreBooks = new ArrayList<>();
        int length = CollectionsOfBook.size();
        for(int i=0; i<length; i++){
            if(Objects.equals(CollectionsOfBook.get(i).getAuthor(), genre)){
                GenreBooks.add(CollectionsOfBook.get(i));
            }
        }
        return GenreBooks;
    }

    public void deleteById(int id) {

        int length = CollectionsOfBook.size();
        for(int i=0; i<length; i++){
            if(CollectionsOfBook.get(i).getId() == id){
                CollectionsOfBook.remove(i);
            }
        }
    }

    public void deleteAllBooks() {
        CollectionsOfBook.removeAll(CollectionsOfBook);
    }

    public List<Book> getBooks() {

        return CollectionsOfBook;
    }

    public Book create(Book book) {

        book.setId(id);
        id +=1;
        CollectionsOfBook.add(book); // here adding the book object:
        return book;
    }
}
