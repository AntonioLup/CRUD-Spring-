package com.example.crudbook.service;


import com.example.crudbook.model.Book;

public class Service {

    double priceBook = 30.3;
    int pages = 250;
    public double calculate(Book book){
        double price = priceBook;

        if(pages > 300){
            price += 50;
        }

        price += 15;
        return price;

    }
}
