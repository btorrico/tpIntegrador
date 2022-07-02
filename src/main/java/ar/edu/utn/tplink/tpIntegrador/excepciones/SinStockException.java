package ar.edu.utn.tplink.tpIntegrador.excepciones;


public class SinStockException extends Exception {
	
	private static final long serialVersionUID = 1L;
	


	public SinStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SinStockException(String message, String nombre) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SinStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SinStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
