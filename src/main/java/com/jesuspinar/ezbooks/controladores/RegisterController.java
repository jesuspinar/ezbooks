package com.jesuspinar.ezbooks.controladores;

import com.jesuspinar.ezbooks.modelo.Usuario;
import com.jesuspinar.ezbooks.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    UsuarioServicio usuarioServicio;


    @GetMapping("/auth/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "register";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute Usuario usuario) {
        usuarioServicio.registrar(usuario);
        return "redirect:/auth/login";
    }
}
