package com.jesuspinar.ezbooks.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesuspinar.ezbooks.modelo.Compra;
import com.jesuspinar.ezbooks.modelo.Producto;
import com.jesuspinar.ezbooks.modelo.Usuario;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	List<Producto> findByPropietario(Usuario propietario);
	
	List<Producto> findByCompra(Compra compra);
	
	List<Producto> findByCompraIsNull();
	
	List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);
	
	List<Producto> findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
	
}
