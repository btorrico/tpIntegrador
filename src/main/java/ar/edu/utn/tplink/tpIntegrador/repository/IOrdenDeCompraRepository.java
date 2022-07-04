package ar.edu.utn.tplink.tpIntegrador.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.tplink.tpIntegrador.app.DTO.OrdenDeCompraDTO;
import ar.edu.utn.tplink.tpIntegrador.model.OrdenDeCompra;



//@RepositoryRestResource(path="ordenes", excerptProjection = OrdenDeCompraDTO.class)
@RepositoryRestResource(path="ordenes")

public interface IOrdenDeCompraRepository extends PagingAndSortingRepository<OrdenDeCompra, Integer>{
	
	Optional<OrdenDeCompra> findByFecha(LocalDate fecha);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(OrdenDeCompra entity);
}
