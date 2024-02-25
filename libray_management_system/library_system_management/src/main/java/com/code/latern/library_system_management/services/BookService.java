package com.code.latern.library_system_management.services;

import com.code.latern.library_system_management.models.Book;
import com.code.latern.library_system_management.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllByCategory(String category){
        return bookRepository.findAllByCategory( category);
    }

    public Optional<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
