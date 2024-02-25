package com.code.latern.library_system_management.repositories;

import com.code.latern.library_system_management.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {
   List<Book> findAllByCategory( String category);
   Optional<Book> findByTitle(String title);

}
