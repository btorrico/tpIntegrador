package ar.edu.utn.tplink.tpIntegrador.repository;


import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import ar.edu.utn.tplink.tpIntegrador.app.DTO.ProveedorDTO;
import ar.edu.utn.tplink.tpIntegrador.model.Proveedor;



@RepositoryRestResource(path="proveedores", excerptProjection = ProveedorDTO.class)
public interface IProveedorRepository extends PagingAndSortingRepository<Proveedor, Integer>{
	
	Optional<Proveedor> findByNombre(String nombre);
	
	@Override
	@RestResource(exported=false)
	void deleteById(Integer id);
	
	@Override
	@RestResource(exported=false)
	void delete(Proveedor entity);
}
