package ar.edu.utn.tplink.tpIntegrador.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ar.edu.utn.tplink.tpIntegrador.excepciones.NoSePuedeAplicarCuponException;

@Entity
public class CuponDescuento extends Promocion {
	private String codigoCupon;
	private LocalDate fechaVencimiento;
	private boolean fueUsado;
	private double descuento;
	@ManyToOne
	private Proveedor proveedor;

	public CuponDescuento(String codigoCupon, LocalDate fechaVencimiento, boolean fueUsado, double descuento,
			Proveedor proveedor) {
		super();
		this.codigoCupon = codigoCupon;
		this.fechaVencimiento = fechaVencimiento;
		this.fueUsado = fueUsado;
		this.descuento = descuento;
		this.proveedor = proveedor;
	}

	public String getCodigoCupon() {
		return codigoCupon;
	}

	public void setCodigoCupon(String codigoCupon) {
		this.codigoCupon = codigoCupon;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public boolean isFueUsado() {
		return fueUsado;
	}

	public void setFueUsado(boolean fueUsado) {
		this.fueUsado = fueUsado;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void usarCupon() {
		fueUsado = true;
	}

	public double descuento() throws NoSePuedeAplicarCuponException {
		if (this.fechaVencimiento.compareTo(LocalDate.now()) < 0) {
			if (fueUsado)
				throw new NoSePuedeAplicarCuponException("El cupon que intenta aplicar ya fue utilizado");
			else
				throw new NoSePuedeAplicarCuponException("El cupon que intenta utilizar ya no tiene validez");
		}
		return descuento;
	}
	
	

	@Override
	public double aplicarPromocion(CarritoDeCompra unCarrito) throws NoSePuedeAplicarCuponException {
		unCarrito.contiene(proveedor);
		this.usarCupon();
		return unCarrito.getSubtotal() * (1 - this.descuento());
	}

}
