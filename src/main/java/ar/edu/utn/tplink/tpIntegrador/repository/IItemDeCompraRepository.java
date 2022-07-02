package ar.edu.utn.tplink.tpIntegrador.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.tplink.tpIntegrador.app.DTO.ItemDeCompraDTO;
import ar.edu.utn.tplink.tpIntegrador.model.ItemDeCompra;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path="items", excerptProjection = ItemDeCompraDTO.class)
public interface IItemDeCompraRepository extends PagingAndSortingRepository<ItemDeCompra, Integer>{
	
	Optional<ItemDeCompra> findById(Integer id);
	
	Page<ItemDeCompra> findAll(Pageable page);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(ItemDeCompra entity);


}
