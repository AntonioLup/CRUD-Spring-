package com.example.crudbook.controller;

import com.example.crudbook.model.Book;
import com.example.crudbook.repository.RepoBook;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;

@RestController
public class BookController  {
private final Logger log = LoggerFactory.getLogger(BookController.class);
    private RepoBook repoBook;

    @Value("${app.mensagger}")
    String mensagge;

    @Autowired
    public BookController(RepoBook repoBook) {
        this.repoBook = repoBook;
    }

    //    Crud sobre todas las entidades
//    buscar todos los libros

    /**
     * http://localhost:8080/api/books
     * http://localhost:8080/swagger-ui
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
        if(bookOptional.isPresent() ){
            return ResponseEntity.ok(bookOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
//        return bookOptional.orElse(null);

    }
//    crear un libro
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        if(book.getId() != null){
            log.warn("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = repoBook.save(book);
//        guardar
       return ResponseEntity.ok(result) ;
    }
//    actualizar
    @PutMapping("/api/books")
    public ResponseEntity<Book> edit(@RequestBody Book book){
        if(book.getId() == null){
            log.warn("trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!repoBook.existsById(book.getId())){
            log.warn("trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = repoBook.save(book);
//        guardar
        return ResponseEntity.ok(result) ;
    }
//    borrar
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if(!repoBook.existsById(id)){
            log.warn("trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        repoBook.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
//        if(repoBook.){
//            log.warn("trying to update a non existent book");
//            return ResponseEntity.notFound().build();
//        }
        log.info("Delete all books");
        repoBook.deleteAll();

        return ResponseEntity.noContent().build();
    }

}
