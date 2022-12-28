package com.jesuspinar.ezbooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/products-list")
    private String goToProducts() {
        return "/user/products-list";
    }

    @GetMapping("/transactions")
    private String goToTransactions() {
        return "/user/transactions";
    }

    @GetMapping("/upload/product")
    private String goToUploadProduct(){
        return "/user/upload";
    }

    @GetMapping("/checkout")
    private String goToCheckout(){
        return "/user/checkout";
    }


}
