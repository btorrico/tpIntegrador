package ar.edu.utn.tplink.tpIntegrador.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	
	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Rol(TipoUsuario tipoUsuario) {
		super();
		this.tipoUsuario = tipoUsuario;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	

}
