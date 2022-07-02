package ar.edu.utn.tplink.tpIntegrador.model;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
class ApiDolar {
    
    private String fecha;
    private String compra;
    private String venta;

    public ApiDolar(String fecha, String compra, String venta) {
        super();
        this.fecha = fecha;
        this.compra = compra;
        this.venta = venta;
    }


    public ApiDolar() {
        
    }


	public String getCompra() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}
