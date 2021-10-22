package br.com.alura.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.alura.model.Bitcoin;
import br.com.alura.service.BitcoinService;

@Path("/bitcoins") // Api interna
public class BitcoinResource {

	@Inject //Injecao de dependencia (como o Autowired)
	@RestClient // Avisar que é um cliente REST
	BitcoinService bitcoinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar() {
		return bitcoinService.listar();
	}

}