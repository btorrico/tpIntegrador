package ar.edu.utn.tplink.tpIntegrador.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.tplink.tpIntegrador.model.Administrador;


@RepositoryRestResource(path= "administradores")
public interface IAdministradorRepository extends PagingAndSortingRepository<Administrador,Integer>{
    

}
