package com.sparta.ua.libraryproject.controller;

import com.sparta.ua.libraryproject.model.entities.AuthorDTO;
import com.sparta.ua.libraryproject.model.entities.BookDTO;
import com.sparta.ua.libraryproject.model.repositories.BookRepository;
import com.sparta.ua.libraryproject.model.services.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final LibraryService libraryService;

    public BookController(BookRepository bookRepository, LibraryService libraryService) {
        this.bookRepository = bookRepository;
        this.libraryService = libraryService;
    }

    @GetMapping("/book/{id}")
    public Optional<BookDTO> getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBookByTitle(@RequestParam(name = "name", required = false) String name) {//assumes an argument or no argument either a string or null
        List<BookDTO> book = new ArrayList<>();

        if (name == null) {
            book = bookRepository.findAll();
        } else {
            book = bookRepository.findBookDTOByTitle(name);
        }
        return book;
    }

    @PatchMapping("/book/{id}")
    public BookDTO changeBookTitle(@RequestBody BookDTO newBook, @PathVariable Integer id) {
        BookDTO book = null;
        if (bookRepository.findById(id).isPresent()) {
            book = bookRepository.findById(id).get();
            book.setTitle(newBook.getTitle());
        }
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookRepository.deleteById(id);
    }

    @PostMapping("/books/add")
    public void addBook(@RequestBody BookDTO book){
        bookRepository.save(book);
    }
}
