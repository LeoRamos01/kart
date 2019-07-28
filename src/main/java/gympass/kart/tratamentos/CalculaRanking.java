package gympass.kart.tratamentos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import gympass.kart.vo.Piloto;
import gympass.kart.vo.Ranking;
import gympass.kart.vo.Volta;

/**
 * 
 * Determina as posições de chegada, tempos, etc.
 * 
 * @author leonardorm
 *
 */
public class CalculaRanking {

	public List<Ranking> getRanking(List<Piloto> pilotos) {

		List<Ranking> rankings = new ArrayList<>();

		pilotos.forEach(piloto -> {

			Duration duracaoProva = piloto.getVoltas().stream().map(Volta::getTempoVolta).reduce(Duration::plus).get();

			Ranking ranking = new Ranking(null, piloto.getId(), piloto.getNome(), piloto.getVoltas().size(),
					duracaoProva);

			String duracao = formataDuracao(duracaoProva.toMillis());

			ranking.setDuracao(duracao);

			rankings.add(ranking);

		});

		Collections.sort(rankings, Comparator.comparing(Ranking::getTempoTotal));

		setaColocacoes(rankings);

		return rankings;

	}

	/**
	 * 
	 * Calcula a melhor volta de cada piloto: isto é: aquela na qual o piloto
	 * concluiu em menor tempo.
	 * 
	 * @param pilotos
	 * @return
	 */
	public List<Pair<String, Integer>> melhorVoltaCadaPiloto(List<Piloto> pilotos) {

		return pilotos.stream().map(piloto -> {

			Collections.sort(piloto.getVoltas(), Comparator.comparing(Volta::getTempoVolta));

			Volta melhorVolta = piloto.getVoltas().get(0);

			return Pair.of(concatenaPilotoComId(piloto), melhorVolta.getIdVolta());

		}).collect(Collectors.toList());

	}

	/**
	 * 
	 * Calcula a melhor volta da corrida.
	 * 
	 * @param pilotos
	 * @return
	 */
	public Pair<String,Volta> melhorVoltaCorrida(List<Piloto> pilotos) {

		List<Pair<String, Volta>> lista = pilotos.stream().map(piloto -> {
			return Pair.of(concatenaPilotoComId(piloto),
					piloto.getVoltas().stream().min(Comparator.comparing(Volta::getVelocidadeMediaVolta)).get());
		}).collect(Collectors.toList());
		
		Collections.sort(lista, Comparator.comparing(pair -> pair.getRight().getVelocidadeMediaVolta()));
		Collections.reverse(lista);

		return lista.get(0);
	}

	public List<Pair<String, BigDecimal>> velocidadeMediaPiloto(List<Piloto> pilotos) {

		return pilotos.stream().map(piloto -> {

			BigDecimal mediaVelocidade = piloto.getVoltas().stream().map(Volta::getVelocidadeMediaVolta)
					.reduce(BigDecimal::add).get()
					.divide(BigDecimal.valueOf(piloto.getVoltas().size()), 3, RoundingMode.HALF_EVEN);

			return Pair.of(concatenaPilotoComId(piloto), mediaVelocidade);
		}).collect(Collectors.toList());

	}
	
	public List<Pair<String, String>> tempoPilotosAposVencedor(List<Ranking> rankings) {
		
		Ranking primeiro = rankings.remove(0);
		
		List<Pair<String, String>> atrasosPilotos = new ArrayList<>();
		
		for (Ranking ranking : rankings) {
			
			// 4min:15s:153
			PeriodFormatter formatter = new PeriodFormatterBuilder()
			        .printZeroAlways().minimumPrintedDigits(2)
			        .appendMinutes().appendSuffix("min:").appendSeconds().appendSuffix("s:").appendMillis()
			        .toFormatter();
			
			Period periodAtual = formatter.parsePeriod(ranking.getDuracao());
			Period periodPrimeiro = formatter.parsePeriod(primeiro.getDuracao());
			
			Period atraso = periodAtual.minus(periodPrimeiro).normalizedStandard();
			String atrasoString = formatter.print(atraso);
			
			atrasosPilotos.add(Pair.of(ranking.getIdPiloto() + " - " + ranking.getNomePiloto(), atrasoString));
			
		}
		
		return atrasosPilotos;
		
	}

	/**
	 * 
	 * A lista já vem ordenada por menor tempo, então o primeiro é o primeiro da
	 * lista e assim por diante.
	 * 
	 * @param rankings
	 */
	private void setaColocacoes(List<Ranking> rankings) {
		Integer aux = 0;
		for (Ranking ranking : rankings) {
			ranking.setPosicaoChegada(++aux);
		}
	}

	private String formataDuracao(long millis) {

		long days = TimeUnit.MILLISECONDS.toDays(millis);
		millis -= TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
		millis -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
		millis -= TimeUnit.SECONDS.toMillis(seconds);

		StringBuilder sb = new StringBuilder(64);
		sb.append(minutes);
		sb.append("min:");
		sb.append(seconds);
		sb.append("s:");
		sb.append(millis);

		return (sb.toString());
	}

	private String concatenaPilotoComId(Piloto piloto) {
		return piloto.getId() + " - " + piloto.getNome();
	}

}
