package ar.edu.utn.tplink.tpIntegrador.repository;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.tplink.tpIntegrador.app.DTO.CarritoDeCompraDTO;
import ar.edu.utn.tplink.tpIntegrador.model.CarritoDeCompra;


@RepositoryRestResource(path="carritos", excerptProjection = CarritoDeCompraDTO.class)
public interface ICarritoDeCompraRepository extends PagingAndSortingRepository<CarritoDeCompra, Integer>{
	
	Optional<CarritoDeCompra> findById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(CarritoDeCompra entity);
}
