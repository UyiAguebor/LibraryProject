package com.sparta.ua.libraryproject.controller;

import com.sparta.ua.libraryproject.model.entities.AuthorDTO;
import com.sparta.ua.libraryproject.model.repositories.AuthorRepository;
import com.sparta.ua.libraryproject.model.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final LibraryService libraryService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, LibraryService libraryService) {
        this.authorRepository = authorRepository;
        this.libraryService = libraryService;
    }

    @GetMapping("/author/{id}")
    public Optional<AuthorDTO> getAuthorsById(@PathVariable Integer id){
        return authorRepository.findById(id);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name",required = false)String name){//assumes an argument or no argument either a string or null
        List<AuthorDTO> author = new ArrayList<>();

        if(name == null){
            author = authorRepository.findAll();
        } else {
            author = authorRepository.findAuthorDTOByFullName(name);
        }
        return author;
    }

    @PatchMapping("/author/{id}")
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO newAuthor,@PathVariable Integer id){
        AuthorDTO author = null;
        if(authorRepository.findById(id).isPresent()){
            author = authorRepository.findById(id).get();
            author.setFullName(newAuthor.getFullName());
        }
        return authorRepository.save(author);
    }
}
