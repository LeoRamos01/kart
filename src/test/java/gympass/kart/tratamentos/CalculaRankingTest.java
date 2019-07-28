package gympass.kart.tratamentos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gympass.kart.testutils.TesteUtils;
import gympass.kart.vo.Piloto;
import gympass.kart.vo.Ranking;

public class CalculaRankingTest {
	
	private CalculaRanking calculaRanking;

	@Before
	public void setUp() throws Exception {
		calculaRanking = new CalculaRanking();
	}

	@Test
	public void testGetRanking() {
		
		List<Piloto> pilotos = TesteUtils.listPilotos();
		
		List<Ranking> rankings = calculaRanking.getRankings(pilotos);
		List<Ranking> rankingsEsperados = new ArrayList<>();
		
		Ranking primeiro = new Ranking(1, "038", "F.MASSA", 2, TesteUtils.duration1.plus(TesteUtils.duration3));
		Ranking segundo = new Ranking(2, "035", "S.Vetel", 1, TesteUtils.duration2);
		Ranking terceiro = new Ranking(3, "032", "Raikonen", 1, TesteUtils.duration1);
		
		primeiro.setDuracao("2min:1s:627");
		segundo.setDuracao("1min:2s:360");
		terceiro.setDuracao("1min:2s:852");
		
		rankingsEsperados.add(primeiro);
		rankingsEsperados.add(segundo);
		rankingsEsperados.add(terceiro);
		
		System.out.println(rankings);
		System.out.println(rankingsEsperados);
		
		assertEquals(rankingsEsperados, rankings);
	}

	@Test
	public void testMelhorVoltaCadaPiloto() {
		fail("Not yet implemented");
	}

	@Test
	public void testMelhorVoltaCorrida() {
		fail("Not yet implemented");
	}

	@Test
	public void testVelocidadeMediaPiloto() {
		fail("Not yet implemented");
	}

	@Test
	public void testTempoPilotosAposVencedor() {
		fail("Not yet implemented");
	}

}
