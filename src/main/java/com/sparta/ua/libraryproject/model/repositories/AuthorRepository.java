package com.sparta.ua.libraryproject.model.repositories;

import com.sparta.ua.libraryproject.model.entities.AuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDTO, Integer> {

    List<AuthorDTO> findAuthorDTOByFullNameStartingWith(String name);
    List<AuthorDTO> findAuthorDTOByFullName(String name);

    @Override
    void deleteById(Integer integer);

}