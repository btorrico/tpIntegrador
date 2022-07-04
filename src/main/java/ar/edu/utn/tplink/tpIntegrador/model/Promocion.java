package ar.edu.utn.tplink.tpIntegrador.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.INTEGER)
public abstract class Promocion {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	public abstract Double aplicar(CarritoDeCompra CarritoDeCompra);
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}


