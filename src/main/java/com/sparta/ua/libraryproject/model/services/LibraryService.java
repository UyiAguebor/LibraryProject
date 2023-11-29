package com.sparta.ua.libraryproject.model.services;

import com.sparta.ua.libraryproject.model.entities.AuthorDTO;
import com.sparta.ua.libraryproject.model.entities.BookDTO;
import com.sparta.ua.libraryproject.model.repositories.AuthorRepository;
import com.sparta.ua.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired // in order to make this i need to make these first. it will go back and create everything that is needed until we can get what it is that we want(OBJECT).
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }//creates another layer of abstraction on top of the two repositories

    //two methods
    public List<AuthorDTO> findAuthorsWithMoreThanOneBook(){
        List<BookDTO> books = bookRepository.findAll();
        List<AuthorDTO> authors = authorRepository.findAll();
        List<AuthorDTO> result = new ArrayList<>();

        int counter = 0;

        for(AuthorDTO author: authors){
            int id = author.getId();
            for(BookDTO book: books){
                if(book.getId() == id){
                    counter++;
                }
            }
            if(counter > 1){
                result.add(author);
                counter = 0;
            }
        }

        return result;
    }

    public List<BookDTO> findAutoBiographies(){
        List<BookDTO> books = bookRepository.findAll();
        List<AuthorDTO> authors = authorRepository.findAll();
        List<BookDTO> result = new ArrayList<>();
        int counter = 0;

        for(BookDTO book: books){
            String bookName = book.getTitle();
            for (AuthorDTO author: authors){
                if(bookName.contains(author.getFullName())){
                    result.add(book);
                }
            }
        }
        return result;
    }

    public List<AuthorDTO> findAuthorsWithMoreThanOneBook2(){
        List<BookDTO> books = bookRepository.findAll();
        List<AuthorDTO> authors = authorRepository.findAll();
        List<AuthorDTO> result = new ArrayList<>();

//        int counter = 0;
//        for(AuthorDTO author: authors){
//        result.add(books.stream().filter(book -> book.getId().equals(author.getId())).collect(List<AuthorDTO> result));
//
//        }
        return result;
    }
}
