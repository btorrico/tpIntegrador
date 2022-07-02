package ar.edu.utn.tplink.tpIntegrador.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.edu.utn.tplink.tpIntegrador.model.Usuario;


@RepositoryRestResource(path="usuarios")
public interface IUsuarioRepository extends PagingAndSortingRepository<Usuario,Long> {

	//@RestResource(exported=false)
	//Usuario findByNombreDeUsuario(String nombreDeUsuario);
	
	 //Optional<Usuario> findByUsuarioAndContrasenia(String user, String password);
		
	//Page<Usuario> findAll(Pageable page);
	
//	List<Usuario>findaAll();

	
    
}