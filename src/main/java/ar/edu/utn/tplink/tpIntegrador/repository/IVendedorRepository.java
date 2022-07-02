package ar.edu.utn.tplink.tpIntegrador.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.tplink.tpIntegrador.app.DTO.VendedorDTO;
import ar.edu.utn.tplink.tpIntegrador.model.Vendedor;



@RepositoryRestResource(path="vendedores", excerptProjection = VendedorDTO.class)
public interface IVendedorRepository extends PagingAndSortingRepository<Vendedor, Integer>{
	
	Optional<Vendedor> findByNombre(String nombre);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Vendedor entity);
}
