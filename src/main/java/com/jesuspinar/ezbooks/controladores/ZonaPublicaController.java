package com.jesuspinar.ezbooks.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jesuspinar.ezbooks.modelo.Producto;
import com.jesuspinar.ezbooks.servicios.ProductoServicio;

@Controller
@RequestMapping("/public")
public class ZonaPublicaController {
	
	@Autowired
	ProductoServicio productoServicio;

	
	@ModelAttribute("productos")
	public List<Producto> productosNoVendidos() {
		return productoServicio.productosSinVender();
	}

	@ModelAttribute("productosVendidos")
	public List<Producto> productosVendidos() {

		List<Producto> vendidos = new ArrayList<>();
	    List<Producto> disponibles = productoServicio.findAll();

		int x = 0;
		for (Producto p: disponibles) {
			if (p.getCompra() != null && x < 3){
				vendidos.add(p);
				x++;
			}
		}
		if (vendidos.size() < 1){
			for (int i = 0; i < 3; i++) {
				Producto p = disponibles.get(i);
				vendidos.add(p);
			}
		}
		return vendidos;
	}

	@GetMapping({"/","index"})
	public String index(){
		return "index";
	}
	
	@GetMapping("libros")
	public String libros(Model model, @RequestParam(name="q", required=false) String query) {
		if (query != null)
			model.addAttribute("productos", productoServicio.buscar(query));
		return "libros";
	}
	
	@GetMapping("/producto/{id}")
	public String showProduct(Model model, @PathVariable Long id) {
		Producto result = productoServicio.findById(id); 
		if (result != null) {
			model.addAttribute("producto", result);
			return "producto";
		}
		return "redirect:/public";
	}
	
	

}
