package com.sparta.ua.libraryproject.model.repositories;

import com.sparta.ua.libraryproject.model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<BookDTO, Integer> {
    List<BookDTO> findBookDTOByTitle(String title);
}