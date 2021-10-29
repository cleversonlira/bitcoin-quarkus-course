package br.com.alura.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.alura.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class OrdemRepositoryTest {
	
	@InjectMock
	OrdemRepository ordemRepository;

	@Test
	public void testarSeListAllRetornaOrdensCorretas() {		
		Ordem ordem1 = new Ordem();
		Ordem ordem2 = new Ordem();
		List<Ordem> ordens = Arrays.asList(ordem1, ordem2);
		Mockito.when(ordemRepository.listAll()).thenReturn(ordens);
		Assertions.assertSame(ordem1, ordemRepository.listAll().get(0));
	}
	
}







