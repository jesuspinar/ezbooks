package com.jesuspinar.ezbooks.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesuspinar.ezbooks.modelo.Compra;
import com.jesuspinar.ezbooks.modelo.Usuario;

public interface CompraRepository extends JpaRepository<Compra, Long>{

	List<Compra> findByPropietario(Usuario propietario);
	
}
