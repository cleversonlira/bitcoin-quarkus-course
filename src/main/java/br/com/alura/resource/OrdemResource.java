package br.com.alura.resource;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;

@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemRepository ordemRepository;

	@POST
	@Transactional
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Ordem ordem) {
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}

}
