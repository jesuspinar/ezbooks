package com.jesuspinar.ezbooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Actua como mapeador para las peticiones de usuarios no loggeados
 */
@Controller
public class PrincipalController {

    @GetMapping("/index")
    private String goToIndex(){
        return "index";
    }
    @GetMapping("/login")
    private String goToLogin(){
        return "login";
    }
    @GetMapping("/register")
    private String goToRegister(){
        return "register";
    }

    @GetMapping({"libros","books", "products"})
    private String goToBooks(){
        return "products";
    }
}
