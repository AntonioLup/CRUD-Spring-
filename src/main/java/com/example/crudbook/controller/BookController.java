package com.example.crudbook.controller;

import com.example.crudbook.model.Book;
import com.example.crudbook.repository.RepoBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController  {

    private RepoBook repoBook;

    @Autowired
    public BookController(RepoBook repoBook) {
        this.repoBook = repoBook;
    }

    //    Crud sobre todas las entidades
//    buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * @return Lista books
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
//        recuperar y devolver
        return repoBook.findAll();
    }
//    buscar un solo libro

    /**
     * Request
     * response
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book>  findOnlyById(@PathVariable Long id){
        Optional<Book> bookOptional = repoBook.findById(id);
        if(bookOptional.isPresent()){
            return ResponseEntity.ok(bookOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
//        return bookOptional.orElse(null);

    }
//    crear un libro
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
//        guardar
       return repoBook.save(book);
    }
//    actualizar
//    borrar

}
