package ar.edu.utn.tplink.tpIntegrador.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Vendedor {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String apellido;
	
	@OneToMany
	private List<Proveedor> proveedores;
	
	private String direccion;
	private String documento;
	private TipoUsuario tipoUsuario = TipoUsuario.VENDEDOR;
	
	@OneToMany
	private List<Producto> productos;
	
	@OneToMany
	private List<OrdenDeCompra> ordenesDeCompra;
	

	

	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Vendedor(String nombre, String apellido, String documento, List<Proveedor> proveedores, List<OrdenDeCompra> ordenesDeCompra,
			List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.proveedores = proveedores;
		this.ordenesDeCompra = ordenesDeCompra;
		this.productos = productos;
	}

	
	public Vendedor(String nombre, String apellido, List<Proveedor> proveedores, String direccion, String documento, List<Producto> productos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.proveedores = proveedores;
		this.direccion = direccion;
		this.documento = documento;
		this.productos = productos;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public List<OrdenDeCompra> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenes(List<OrdenDeCompra> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}



	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}



	public void setRol(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}



	public void setOrdenesDeCompra(List<OrdenDeCompra> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}


}
