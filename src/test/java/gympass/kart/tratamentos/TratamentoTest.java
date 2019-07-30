package gympass.kart.tratamentos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gympass.kart.testutils.TesteUtils;
import gympass.kart.vo.Linha;
import gympass.kart.vo.Piloto;

public class TratamentoTest {

	private Tratamento tratamento;

	@Before
	public void setUp() throws Exception {
		tratamento = new Tratamento();
	}

	@Test
	public void testRetornaPilotos() {

		List<Linha> lista = TesteUtils.listLinhas();

		List<Piloto> pilotosRetornados = tratamento.retornaPilotos(lista);

		List<Piloto> pilotosEsperados = new ArrayList<>(TesteUtils.listPilotos());

		Collections.sort(pilotosRetornados, Comparator.comparing(Piloto::getNome));
		Collections.sort(pilotosEsperados, Comparator.comparing(Piloto::getNome));

		assertEquals(pilotosEsperados, pilotosRetornados);
	}

}
