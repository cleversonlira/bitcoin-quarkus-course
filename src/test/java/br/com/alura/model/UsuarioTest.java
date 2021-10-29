package br.com.alura.model;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {

	@Test
	public void testarSeFindByIdOptionalRetornaUsuarioCorreto() {
		PanacheMock.mock(Usuario.class);
		Usuario usuario = new Usuario();
		Optional<PanacheEntityBase> userOptional = Optional.of(usuario);
		Mockito.when(Usuario.findByIdOptional(40)).thenReturn(userOptional);
		Assertions.assertSame(usuario, Usuario.findByIdOptional(40).get());
	}	
}
