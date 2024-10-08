package com.jesuspinar.ezbooks.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesuspinar.ezbooks.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findFirstByEmail(String email);
}
