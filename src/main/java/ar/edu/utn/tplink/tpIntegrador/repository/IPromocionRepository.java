package ar.edu.utn.tplink.tpIntegrador.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.tplink.tpIntegrador.model.Promocion;


@RepositoryRestResource(path ="promociones")
public interface IPromocionRepository extends PagingAndSortingRepository<Promocion,Integer> {
    
}
