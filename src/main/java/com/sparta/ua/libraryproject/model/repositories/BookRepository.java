package com.sparta.ua.libraryproject.model.repositories;

import com.sparta.ua.libraryproject.model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDTO, Integer> {
}