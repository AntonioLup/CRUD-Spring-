package com.example.crudbook.repository;

import com.example.crudbook.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoBook extends JpaRepository<Book, Long> {
}
