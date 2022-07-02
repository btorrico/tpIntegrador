package ar.edu.utn.tplink.tpIntegrador.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ar.edu.utn.tplink.tpIntegrador.excepciones.NoSePuedeAplicarCuponException;
import ar.edu.utn.tplink.tpIntegrador.excepciones.SinStockException;

@Entity
public class CarritoDeCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToMany
	private Collection<ItemDeCompra> itemsDeCompra;

	private double subtotal;

	@ManyToMany
	private Collection<Promocion> promociones;

	public CarritoDeCompra(List<ItemDeCompra> itemsDeCompra) {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarritoDeCompra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarritoDeCompra(Collection<ItemDeCompra> itemsDeCompra, double subtotal, Collection<Promocion> promociones) {
		this.itemsDeCompra = itemsDeCompra;
		this.subtotal = subtotal;
		this.promociones = promociones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<ItemDeCompra> getItemsDeCompra() {
		return itemsDeCompra;
	}

	public void setItemsCarrito(Collection<ItemDeCompra> itemsCarrito) {
		this.itemsDeCompra = itemsCarrito;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Collection<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Collection<Promocion> promociones) {
		this.promociones = promociones;
	}

	public void agregarProducto(ItemDeCompra item) throws SinStockException {
		if (item.getProducto().getCantStock() < item.getCantidad()) {
			throw new SinStockException("El producto se encuentra sin stock");
		}
		itemsDeCompra.add(item);
		subtotal += item.precio();
	}

	public void quitarProducto(ItemDeCompra item) {
		itemsDeCompra.remove(item);
		subtotal -= item.precio();
	}

	public void agregarPromocion(Promocion promocion) {
		promociones.add(promocion);
	}

	public OrdenDeCompra terminarCompra() {
		itemsDeCompra.forEach(item -> item.getProducto().reducirStock(item.getCantidad()));
		return new OrdenDeCompra(LocalDate.now(), itemsDeCompra, subtotal, this.precioTotal());

	}

	public double precioTotal() {
		if (promociones.size() > 0) {
			return promociones.stream().mapToDouble(promocion -> {
				try {
					return promocion.aplicarPromocion(this);
				} catch (NoSePuedeAplicarCuponException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return subtotal;
			}).sum();
		} else {
			return subtotal;
		}
	}

	public void contiene(Proveedor proveedor) {
		itemsDeCompra.stream().map(item -> item.getProducto().getProveedor()).anyMatch(x -> x.equals(proveedor));
	}

	public void vaciarCarrito() {
		itemsDeCompra.clear();
	}


}