package com.jesuspinar.ezbooks.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Producto {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String descripcion;
	private String autor;

	private String genero;
	private String editorial;

	private float precio;
	
	private String imagen; 
	
	@ManyToOne
	private Usuario propietario;
	
	@ManyToOne
	private Compra compra;
	
	public Producto() { }

	public Producto(String nombre, float precio, String imagen, Usuario propietario) {
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.propietario = propietario;
	}

	public Producto(long id, String nombre, String descripcion, String autor,
					String genero, String editorial, float precio, String imagen, Usuario propietario) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.autor = autor;
		this.genero = genero;
		this.editorial = editorial;
		this.precio = precio;
		this.imagen = imagen;
		this.propietario = propietario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		if (imagen == null) {return "https://via.placeholder.com/90x120?text=Libro";}
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Producto producto = (Producto) o;
		return id == producto.id && Float.compare(producto.precio, precio) == 0
				&& nombre.equals(producto.nombre)
				&& propietario.equals(producto.propietario)
				&& Objects.equals(compra, producto.compra);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio, propietario, compra);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", imagen=" + imagen
				+ ", propietario=" + propietario + ", compra=" + compra + "]";
	}

	
	

}
