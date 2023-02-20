package com.jesuspinar.ezbooks;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jesuspinar.ezbooks.modelo.Producto;
import com.jesuspinar.ezbooks.modelo.Usuario;
import com.jesuspinar.ezbooks.servicios.ProductoServicio;
import com.jesuspinar.ezbooks.servicios.UsuarioServicio;
import com.jesuspinar.ezbooks.upload.StorageService;

@SpringBootApplication
public class EzbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(EzbooksApplication.class, args);
	}

	/* //FOR H2 DEVELOPMENT
	@Bean
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoServicio productoServicio) {
		return args -> {

			Usuario usuario = new Usuario("Francisco", "López", null, "francisco.lopez@mail.com", "francisco");
			usuario = usuarioServicio.registrar(usuario);

			Usuario usuario2 = new Usuario("Antonio", "García", null, "antonio.garcia@mail.com", "antonio");
			usuario2 = usuarioServicio.registrar(usuario2);

			
			List<Producto> listado = Arrays.asList(
					new Producto("Codigo limpio", 25.0f, "", usuario),
					new Producto("El club de los 5", 10.f, "", usuario),
					new Producto("Romeo y Julieta", 13.f, "", usuario),
					new Producto("V de vendeta", 42.0f, "", usuario2),
					new Producto("La divina comedia", 12.0f, "", usuario2),
					new Producto("El crisol", 35.0f, "", usuario2));
			
			listado.forEach(productoServicio::insertar);
			

		};
	}
	*/
	
	/**
	 * Este bean se inicia al lanzar la aplicación. Nos permite inicializar el almacenamiento
	 * secundario del proyecto
	 * 
	 * @param storageService Almacenamiento secundario del proyecto
	 * @return
	 */
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
