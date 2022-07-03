package ar.edu.utn.tplink.tpIntegrador.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nombre;
	private String descripcion;
	private int cantStock;
    @Enumerated(EnumType.STRING)
	 CategoriaDeProducto categoria;
	private double precio;
	@ManyToOne
	private Proveedor proveedor;

	private String imagen;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public int getCantStock() {
		return cantStock;
	}

	public void setCantStock(int stock) {
		this.cantStock = stock;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Producto(String nombre, double precio, Proveedor proveedor, int cantStock, String imagen) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.proveedor = proveedor;
		this.cantStock = cantStock;
		this.imagen = imagen;
	}

	public Producto(String nombre, String descripcion, int cantStock, CategoriaDeProducto categoria, double precio,
			Proveedor proveedor, String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantStock = cantStock;
		this.categoria = categoria;
		this.precio = precio;
		this.proveedor = proveedor;
		this.imagen = imagen;
	}

	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(proveedor, other.proveedor);
	}

	public void agregarStock(int cantidad) {
		cantStock += cantidad;	
	}
	
	public void reducirStock(int cantidad) {
		cantStock -= cantidad;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", proveedor=" + proveedor + ", stock=" + cantStock
				+ ", imagen=" + imagen + "]";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaDeProducto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDeProducto categoria) {
		this.categoria = categoria;
	}

	
	
}
