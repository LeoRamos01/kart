package gympass.kart.tratamentos;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import gympass.kart.testutils.TesteUtils;
import gympass.kart.vo.Ranking;
import gympass.kart.vo.Volta;

public class CalculaRankingTest {

	private CalculaRanking calculaRanking;

	@Before
	public void setUp() throws Exception {
		calculaRanking = new CalculaRanking();
	}

	@Test
	public void testGetRanking() {

		List<Ranking> retornado = calculaRanking.getRankings(TesteUtils.listPilotos());
		List<Ranking> esperado = new ArrayList<>();

		Ranking primeiro = new Ranking(1, "038", "F.MASSA", 2, TesteUtils.duration1.plus(TesteUtils.duration3));
		Ranking segundo = new Ranking(2, "035", "S.Vetel", 1, TesteUtils.duration2);
		Ranking terceiro = new Ranking(3, "032", "Raikonen", 1, TesteUtils.duration1);

		primeiro.setDuracao("2min:1s:627");
		segundo.setDuracao("1min:2s:360");
		terceiro.setDuracao("1min:2s:852");

		esperado.add(primeiro);
		esperado.add(segundo);
		esperado.add(terceiro);

		assertEquals(esperado, retornado);
	}

	@Test
	public void testMelhorVoltaCadaPiloto() {

		List<Pair<String, String>> retornado = calculaRanking.melhorVoltaCadaPiloto(TesteUtils.listPilotos());

		List<Pair<String, String>> esperado = new ArrayList<>();

		esperado.add(Pair.of("038 - F.MASSA", "Volta: 2"));
		esperado.add(Pair.of("035 - S.Vetel", "Volta: 1"));
		esperado.add(Pair.of("032 - Raikonen", "Volta: 1"));

		assertEquals(esperado, retornado);
	}

	@Test
	public void testMelhorVoltaCorrida() {

		Pair<String, Volta> retornado = calculaRanking.melhorVoltaCorrida(TesteUtils.listPilotos());

		Pair<String, Volta> esperado = Pair.of("038 - F.MASSA",
				new Volta(2, TesteUtils.duration3, new BigDecimal("50.275"), LocalTime.of(23, 51, 8, 277000000)));

		assertEquals(esperado, retornado);
	}

	@Test
	public void testVelocidadeMediaPiloto() {

		List<Pair<String, BigDecimal>> retornado = calculaRanking.velocidadeMediaPiloto(TesteUtils.listPilotos());

		List<Pair<String, BigDecimal>> esperado = new ArrayList<>();

		esperado.add(Pair.of("038 - F.MASSA", new BigDecimal("47.275")));
		esperado.add(Pair.of("035 - S.Vetel", new BigDecimal("44.333")));
		esperado.add(Pair.of("032 - Raikonen", new BigDecimal("44.275")));

		assertEquals(esperado, retornado);
	}

	@Test
	public void testTempoPilotosAposVencedor() {

		List<Ranking> rankings = calculaRanking.getRankings(TesteUtils.listPilotos());
		Ranking segundo = new Ranking(2, "099", "segundo", 2, TesteUtils.duration1.plus(TesteUtils.duration3).plus(Duration.ofSeconds(1)));
		segundo.setDuracao("2min:2s:627");
		rankings.add(1, segundo);
		
		List<Pair<String, String>> retornado = calculaRanking
				.tempoPilotosAposVencedor(rankings);

		List<Pair<String, String>> esperado = new ArrayList<>();
		
		esperado.add(Pair.of("099 - segundo", "00min:01s:00 de atraso."));
		esperado.add(Pair.of("035 - S.Vetel", "Não completou a corrida."));
		esperado.add(Pair.of("032 - Raikonen", "Não completou a corrida."));

		System.out.println(retornado);
		System.out.println(esperado);
		
		assertEquals(esperado, retornado);
		assertEquals(4, rankings.size());
	}

}
