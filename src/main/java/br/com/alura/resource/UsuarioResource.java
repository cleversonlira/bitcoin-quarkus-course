package br.com.alura.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.Usuario;
import br.com.alura.repository.UsuarioRepository;

@Path("/usuarios")
public class UsuarioResource {

	@Inject
	private UsuarioRepository repository;
	
	
	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Usuario.inserir(usuario);
	}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() {
		return Usuario.listAll();
	}
	
	
}
