package ar.edu.utn.tplink.tpIntegrador;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ar.edu.utn.tplink.tpIntegrador.model.ApiDolar;


@Component
public final class Cotizador{
	RestTemplate restTemplate = new RestTemplate();
	private Double precioDolar;
	private static Cotizador cotizadorDeDolar;
	 
	 public  static Cotizador getConfigurador() {
	 
	 if (cotizadorDeDolar==null) {
	 
		 cotizadorDeDolar = new Cotizador();
	 }
	 return cotizadorDeDolar;
	 }

	public ApiDolar run(RestTemplate restTemplate) {
		ApiDolar precioActual = restTemplate.getForObject(
		"http://api-dolar-argentina.herokuapp.com/api/dolaroficial", ApiDolar.class);
		return precioActual;
	}
	
	public Double getPrecioDolar() {
		return precioDolar;
	}

	@Scheduled(fixedRate = 1000*60*30)
	public void actualizarPrecioDolar() {
		this.precioDolar = this.run(restTemplate).getCompra();
		System.out.println("El precio del dolar ha sido actualizado"); 
	}

	public Cotizador() {
		super();
		this.precioDolar = this.run(restTemplate).getCompra();
	}
	
}
