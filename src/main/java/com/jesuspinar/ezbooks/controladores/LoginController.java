package com.jesuspinar.ezbooks.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.jesuspinar.ezbooks.modelo.Usuario;
import com.jesuspinar.ezbooks.servicios.UsuarioServicio;
import com.jesuspinar.ezbooks.upload.StorageService;

@Controller
public class LoginController {

	@GetMapping("/")
	public String welcome() {
		return "redirect:/public/";
	}

	@GetMapping("/auth/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

}
