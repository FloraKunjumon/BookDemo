package com.example.BookDemo.resource;

import java.util.List;
import java.util.Optional;

import com.example.BookDemo.model.Book;
import com.example.BookDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book) {
        repository.save(book);
        return "Added book with id : " + book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/getBook")
    public Book getBook() {

        Book boo=new Book();
        boo.setId(1234567890);
        boo.setBookName("Vanita");
        boo.setAuthorName("Mukesh");

        return boo;
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        repository.deleteById(id);
        return "book deleted with id : " + id;
    }

}