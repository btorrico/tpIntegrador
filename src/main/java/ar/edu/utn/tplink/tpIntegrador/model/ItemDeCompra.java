package ar.edu.utn.tplink.tpIntegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ItemDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne
	private Producto producto;

	private int cantidad;

	double precio() {
		return producto.getPrecio() * cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ItemDeCompra(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ItemDeCompra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public double precioTotalProducto() {
		return producto.getPrecio() * cantidad;
	}

	@Override
	public String toString() {
		return "ItemCarrito [producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}
