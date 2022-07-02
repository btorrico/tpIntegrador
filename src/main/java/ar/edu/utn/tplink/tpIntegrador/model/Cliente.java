package ar.edu.utn.tplink.tpIntegrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import ar.edu.utn.tplink.tpIntegrador.excepciones.SinStockException;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String apellido;
	private String documento;
    private String direccion;
    private String telefono;
	
	@OneToOne
	private CarritoDeCompra carritoDeCompras;
	private boolean esMiembro;

	@OneToMany
	private List<OrdenDeCompra> comprasRealizadas;
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario = TipoUsuario.CLIENTE;

	public Cliente(String nombre, String apellido, String documento, CarritoDeCompra carritoDeCompras, boolean esMiembro,
			List<OrdenDeCompra> comprasRealizadas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.carritoDeCompras = carritoDeCompras;
		this.esMiembro = esMiembro;
		this.comprasRealizadas = comprasRealizadas;
	}
	
	

	public Cliente(Integer id, String nombre, String apellido, String documento, String direccion, String telefono,
			CarritoDeCompra carritoDeCompras, boolean esMiembro, List<OrdenDeCompra> comprasRealizadas,
			TipoUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.carritoDeCompras = carritoDeCompras;
		this.esMiembro = esMiembro;
		this.comprasRealizadas = comprasRealizadas;
		this.tipoUsuario = tipoUsuario;
	}



	public Cliente( String nombre, String apellido, String documento, String direccion, String telefono,
			CarritoDeCompra carritoDeCompras, boolean esMiembro, List<OrdenDeCompra> comprasRealizadas) {
		super();
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.carritoDeCompras = carritoDeCompras;
		this.esMiembro = esMiembro;
		this.comprasRealizadas = comprasRealizadas;
	}



	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
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


	public List<OrdenDeCompra> getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setComprasRealizadas(ArrayList<OrdenDeCompra> comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}

	public CarritoDeCompra getCarritoDeCompras() {
		return carritoDeCompras;
	}

	public void setCarritoDeCompras(CarritoDeCompra carritoDeCompras) {
		this.carritoDeCompras = carritoDeCompras;
	}

	public boolean EsMiembro() {
		return true;
	}

	public boolean isEsMiembro() {
		return esMiembro;
	}

	public void setEsMiembro(boolean esMiembro) {
		this.esMiembro = esMiembro;
	}


	public void agregarACarrito(ItemDeCompra item) throws SinStockException {
		carritoDeCompras.agregarProducto(item);
	}

	public void finalizarCompra() {
		OrdenDeCompra orden = carritoDeCompras.terminarCompra();
		comprasRealizadas.add(orden);
		carritoDeCompras.vaciarCarrito();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



}
