package ar.edu.utn.tplink.tpIntegrador.model;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String nombre;
	private String direccion;
	private String cuit;
	private String telefono;
	private String mail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Proveedor( String nombre, String direccion, String cuit, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.cuit = cuit;
		this.telefono = telefono;
		this.mail = mail;
	}

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Proveedor [razonSocial=" + nombre + ", direccion=" + direccion + ", cuit=" + cuit + ", telefono="
				+ telefono + ", email=" + mail + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit, direccion, mail, id, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proveedor other = (Proveedor) obj;
		return Objects.equals(cuit, other.cuit) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(mail, other.mail) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	
	

}
