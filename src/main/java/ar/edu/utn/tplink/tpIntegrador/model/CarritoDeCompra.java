package ar.edu.utn.tplink.tpIntegrador.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarritoDeCompra {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@OneToMany
	@JoinColumn(name = "carritoDeCompra_id")
	private Collection<ItemDeCompra> itemsCompras;
	@ManyToMany
	private Collection<Promocion> promociones;
	@Enumerated(EnumType.STRING)
	@Column(name = "metodoDePago")
	private MetodoDePago metodoDePago;
	@OneToOne
	private Cliente cliente;
	
	public CarritoDeCompra() {
		super();
	}
	
	public CarritoDeCompra(Collection<Promocion> promociones,
			LocalDate fechaDeCompra, MetodoDePago metodoDePago,Cliente cliente) {
		super();
		this.itemsCompras = new ArrayList<>();
		this.promociones = promociones;
		this.metodoDePago = metodoDePago;
		this.cliente=cliente;
	}
	
	public Collection<ItemDeCompra> getItemsCompras() {
		return itemsCompras;
	}
	
	public void setItemsCompras(Collection<ItemDeCompra> itemsCompras) {
		this.itemsCompras = itemsCompras;
	}

	public Collection<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}

	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoDePago medioDePago) {
		this.metodoDePago = medioDePago;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double calcularPrecioTotalSinPromociones(){
		return itemsCompras.stream().mapToDouble(x->x.precioTotalProducto()).sum();
	}
	
	public double calcularPrecioTotalConPromociones(){
		return this.calcularPrecioTotalSinPromociones()-promociones.stream().mapToDouble(x->x.aplicar(this)).sum();
	}
	
	public void agregarItem(ItemDeCompra itemCompra) {
		this.itemsCompras.add(itemCompra);
	}
	
	public void agregarPromocion(Promocion promocion) {
		this.promociones.add(promocion);
	}
}
