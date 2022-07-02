package ar.edu.utn.tplink.tpIntegrador.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.tplink.tpIntegrador.app.DTO.ProductoDTO;
import ar.edu.utn.tplink.tpIntegrador.model.Producto;


@RepositoryRestResource(path="productos", excerptProjection = ProductoDTO.class)
public interface IProductoRepository extends PagingAndSortingRepository<Producto, Integer>{
	
	Optional<Producto> findByNombre(String nombre);
	
	Page<Producto> findAll(Pageable page);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Producto entity);

	Object save(Optional<Producto> productoEncontrado);
}
