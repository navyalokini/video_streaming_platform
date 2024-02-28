package com.code.latern.library_system_management.controllers;

import com.code.latern.library_system_management.exceptions.DuplicateTitleException;
import com.code.latern.library_system_management.exceptions.TitleNotFound;
import com.code.latern.library_system_management.models.Book;
import com.code.latern.library_system_management.repositories.BookRepository;
import com.code.latern.library_system_management.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @PostMapping("/save-book")
    public ResponseEntity<?> saveBook(@Valid @RequestBody Book book, BindingResult result) throws DuplicateTitleException {

        if (result.hasErrors()) {
            HashMap<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                String field = fieldError.getField();
                String defaultMessage = fieldError.getDefaultMessage();
                errorMap.put(field, defaultMessage);
            }
            return new ResponseEntity<>(errorMap, HttpStatusCode.valueOf(200));
        }

        try {
            return new ResponseEntity<>(bookRepository.save(book), HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            throw new DuplicateTitleException("Duplicate title is encountered");
        }

    }


    @GetMapping("/get-all-books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable long id) {
        var book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return "book is deleted successfully";
        }
        return "book is not deleted succesfully";

    }

    @GetMapping("/find-by-category/{category}")
    public List<Book> findByCategory(@PathVariable String category) {
        return bookService.findAllByCategory(category);
    }

    @GetMapping("/find-by-title/{title}")
    public Optional<Book> findByTitle(@PathVariable String title) {
        return bookService.findByTitle(title);
    }

    @PostMapping("/acquire-book/{title}")
    public ResponseEntity<?> acquireBookTitle(@PathVariable String title) throws TitleNotFound {
        Optional<Book> book = bookRepository.findByTitle(title);
        if (book.isPresent()) {
            var myBook = book.get();
            int availableQuantity = myBook.getAvailableQuantity();
            if (availableQuantity > 0) {
                myBook.setAvailableQuantity(availableQuantity - 1);
                return new ResponseEntity<>(myBook, HttpStatusCode.valueOf(200));
            }
            return new ResponseEntity<>("Request book is not available", HttpStatusCode.valueOf(200));
        } else {
            throw new TitleNotFound("book title doesn't exist");
        }
   }
}
