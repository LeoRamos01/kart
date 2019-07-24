package gympass.kart.tratamentos;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

			Ranking ranking = new Ranking(null, piloto.getId(), piloto.getNome(), piloto.getVoltas().size(), duracaoProva);
			
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
	 * A lista já vem ordenada por menor tempo, então o primeiro é o primeiro da lista e assim por diante.
	 * 
	 * @param rankings
	 */
	private void setaColocacoes(List<Ranking> rankings) {
		Integer aux = 0;
		for (Ranking ranking : rankings) {
			ranking.setPosicaoChegada(++aux);
		}
	}

	 public String formataDuracao(long millis) {

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

	        return(sb.toString());
	    }
	
}
