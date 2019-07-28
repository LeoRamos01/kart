package gympass.kart.testutils;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gympass.kart.vo.Linha;
import gympass.kart.vo.Piloto;
import gympass.kart.vo.Volta;

public class TesteUtils {
	
	public static Duration duration1 = Duration.ofMinutes(1).plus(Duration.ofSeconds(2)).plus(Duration.ofMillis(852));
	public static Duration duration2 = Duration.ofMinutes(1).plus(Duration.ofSeconds(2)).plus(Duration.ofMillis(360));
	public static Duration duration3 = Duration.ofSeconds(58).plus(Duration.ofMillis(775));

	public static List<Linha> listLinhas() {
		return Arrays.asList(
				new Linha(LocalTime.of(23, 49, 8, 277000000), "F.MASSA", "038", 1, duration1, new BigDecimal("44.275")),
				new Linha(LocalTime.of(23, 49, 11, 277000000), "S.Vetel", "035", 1, duration2, new BigDecimal("44.333")),
				new Linha(LocalTime.of(23, 51, 8, 277000000), "NOME_ERRADO", "038", 2, duration3, new BigDecimal("50.275")),
				new Linha(LocalTime.of(23, 49, 8, 277000000), "Raikonen", "032", 1, duration1, new BigDecimal("44.275")));
	}
	
	public static List<Piloto> listPilotos() {
		List<Piloto> pilotosEsperados = new ArrayList<>();
		
		// massa
		List<Volta> voltasMassa = new ArrayList<>();
		Volta volta1Massa = new Volta(1, duration1, new BigDecimal("44.275"), LocalTime.of(23, 49, 8, 277000000));
		Volta volta2Massa = new Volta(2, duration3, new BigDecimal("50.275"), LocalTime.of(23, 51, 8, 277000000));
		voltasMassa.add(volta1Massa);
		voltasMassa.add(volta2Massa);
		Piloto felipeMassa = new Piloto("038", "F.MASSA", voltasMassa);
		
		// vetel
		List<Volta> voltasVetel = new ArrayList<>();
		Volta volta1Vetel = new Volta(1, duration2, new BigDecimal("44.333"), LocalTime.of(23, 49, 11, 277000000));
		voltasVetel.add(volta1Vetel);
		Piloto vetel = new Piloto("035", "S.Vetel", voltasVetel);
		
		// raikonen
		List<Volta> voltasRaikonen = new ArrayList<>();
		Volta volta1Raikonen = new Volta(1, duration1, new BigDecimal("44.275"), LocalTime.of(23, 49, 8, 277000000));
		voltasRaikonen.add(volta1Raikonen);
		Piloto raikonen = new Piloto("032", "Raikonen", voltasRaikonen);
		
		pilotosEsperados.add(felipeMassa);
		pilotosEsperados.add(vetel);
		pilotosEsperados.add(raikonen);
		
		return pilotosEsperados;
	}
	
}
