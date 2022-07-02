package ar.edu.utn.tplink.tpIntegrador.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class OrdenDeCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDate fecha;
	@Transient
	private Collection<ItemDeCompra> itemsDeCompra;
	private double subtotal;
	private double total;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public OrdenDeCompra(LocalDate fecha, Collection<ItemDeCompra> itemsDeCompra, double subtotal, double total) {
		super();
		this.fecha = fecha;
		this.itemsDeCompra = itemsDeCompra;
		this.subtotal = subtotal;
		this.total = total;
	}
	
	

	public OrdenDeCompra(LocalDate fecha, Collection<ItemDeCompra> itemsDeCompra) {
		super();
		this.fecha = fecha;
		this.itemsDeCompra = itemsDeCompra;
	}

	public Collection<ItemDeCompra> getItemsDeCompra() {
		return itemsDeCompra;
	}

	public void setItemsDeCompra(Collection<ItemDeCompra> itemsDeCompra) {
		this.itemsDeCompra = itemsDeCompra;
	}

	public OrdenDeCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<ItemDeCompra> getItems() {
		return itemsDeCompra;
	}

	public void setItems(Collection<ItemDeCompra> itemsDeCompra) {
		this.itemsDeCompra = itemsDeCompra;
	}

}
