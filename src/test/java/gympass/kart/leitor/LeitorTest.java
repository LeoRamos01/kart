package gympass.kart.leitor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gympass.kart.vo.Linha;

public class LeitorTest {
	
	private Leitor leitor;

	@Before
	public void setUp() throws Exception {
		leitor = new Leitor();
	}

	@Test
	public void testLer() throws IOException {
		List<Linha> list = leitor.ler();
		assertEquals(Integer.valueOf(23), Integer.valueOf(list.size()));
	}

	@Test
	public void testExtrairLinhaParaObjeto() {

		Linha linhaExtraida = 
				leitor
				.extrairLinhaParaObjeto(
				"23:49:08.277      038 – F.MASSA                           1     1:02.852                        44,275");

		Duration tempoVolta = Duration.ofMinutes(1).plus(Duration.ofSeconds(2)).plus(Duration.ofMillis(852));
		
		Linha linhaEsperada = new Linha(LocalTime.of(23, 49, 8, 277000000), "F.MASSA", "038", 1, tempoVolta,
				new BigDecimal("44.275"));

		assertEquals(linhaEsperada, linhaExtraida);
	}

}
