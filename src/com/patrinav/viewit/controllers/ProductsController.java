package com.patrinav.viewit.controllers;

import com.patrinav.viewit.entities.Product;
import com.patrinav.viewit.entities.Ticket;
import com.patrinav.viewit.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productsService.getAll();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Product>> getTickets(){
        List<Product> tickets = productsService.get("ticket");
        return new ResponseEntity<List<Product>>(tickets, HttpStatus.OK);
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Product>> getMenus(){
        List<Product> menus = productsService.get("menu");
        return new ResponseEntity<List<Product>>(menus, HttpStatus.OK);
    }
}
