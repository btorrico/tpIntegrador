package ar.edu.utn.tplink.tpIntegrador.excepciones;

import ar.edu.utn.tplink.tpIntegrador.model.Cliente;

public class ClienteRepetidoException extends Exception {

	
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ClienteRepetidoException(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteRepetidoException() {
		super();
	}

	public ClienteRepetidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClienteRepetidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteRepetidoException(String message) {
		super(message);
	}

	public ClienteRepetidoException(Throwable cause) {
		super(cause);
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	

}
