package ar.edu.utn.tplink.tpIntegrador.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String apellido;
	private String documento;
	private TipoUsuario tipoUsuario = TipoUsuario.ADMINISTRADOR;


	public Administrador() {
	}

	public Administrador(String nombre, String apellido,String documento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;

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

	public void setDocumento(String nroDocumento) {
		this.documento = nroDocumento;
	}


	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

}
