package com.example.crudbook.controller;


import com.example.crudbook.repository.RepoBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProofController  {

    @GetMapping("/hola")
    public String hola(){
        return "hola wey yeee";
    }

    @GetMapping("/taildwind")
    public String taildwind(){
        return """
                <!doctype html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <link href="/dist/output.css" rel="stylesheet">
                </head>
                <body>
                  <h1 class="text-3xl font-bold underline">
                    Hello world from spring!
                  </h1>
                </body>
                </html>
                """;

    }
}
