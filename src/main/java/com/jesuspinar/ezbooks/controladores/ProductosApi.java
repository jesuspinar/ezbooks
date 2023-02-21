package com.jesuspinar.ezbooks.controladores;

import com.jesuspinar.ezbooks.modelo.Producto;
import com.jesuspinar.ezbooks.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ProductosApi {
    @Autowired
    ProductoServicio productoServicio;
    @GetMapping("/productos")
    public List<Producto> productos() {
        List<Producto> productos = productoServicio.productosSinVender();
        List<Producto> sinPropietarios = new ArrayList<>();
        for (Producto p: productos) {
            sinPropietarios.add(new Producto(p.getId(),p.getNombre(),p.getDescripcion(), p.getAutor(),
                    p.getGenero(), p.getEditorial(), p.getPrecio(), p.getImagen(),null));
        }
        return sinPropietarios;
    }
}
