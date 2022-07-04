package ar.edu.utn.tplink.tpIntegrador.model;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("3")
public class MedioDePago extends Promocion{
	@Enumerated(EnumType.STRING)
	@Column(name = "metodoDePago")
	private MetodoDePago metodoDePago;
	private Double porcentaje;
	
	protected MedioDePago() {
		super();
	}
	
	public MedioDePago(MetodoDePago metodoDePago, double porcentaje) {
		super();
		this.metodoDePago = metodoDePago;
		this.porcentaje = porcentaje;
	}

	@Override
	public Double aplicar(CarritoDeCompra carritoDeCompra) {
		if(carritoDeCompra.getMetodoDePago().equals(this.metodoDePago)) {
			return carritoDeCompra.calcularPrecioTotalSinPromociones() * porcentaje;
		}
		return 0.0;
	}



	public MetodoDePago getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(MetodoDePago metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}
