package ar.edu.utn.tplink.tpIntegrador.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.tplink.tpIntegrador.model.Usuario;
import ar.edu.utn.tplink.tpIntegrador.repository.IUsuarioRepository;



@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class UsuarioControllerComplement {
	
	@Autowired
	IUsuarioRepository repoUsuario;
	/*
	@PostMapping()
	public Usuario authenticate(String user, String password) {
		
		Optional<Usuario>usuario = repoUsuario.findByUsuarioAndContrasenia(user,password);
		
		Usuario usua = usuario.get();
		return usua;
	}
	*/
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "usuarios")
	public @ResponseBody Usuario create(@RequestBody Usuario usuario) {
	   repoUsuario.save(usuario);
	   return usuario;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "usuarios")
	public @ResponseBody Iterable<Usuario> getUsuarios(){
		return repoUsuario.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "usuarios/{id}")
	public @ResponseBody ResponseEntity<Usuario> getUsuarios(@PathVariable("id") Long id){
		Optional<Usuario> optional = repoUsuario.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return null;
		
	}
	
	
    
}
