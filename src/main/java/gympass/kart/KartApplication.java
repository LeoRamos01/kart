package gympass.kart;

import java.io.IOException;
import java.util.List;

import gympass.kart.leitor.Leitor;
import gympass.kart.tratamentos.CalculaRanking;
import gympass.kart.tratamentos.Tratamento;
import gympass.kart.vo.Linha;
import gympass.kart.vo.Piloto;
import gympass.kart.vo.Ranking;

/**
 * 
 * Entrada da aplicação.
 * 
 * @author leonardo
 *
 */
public class KartApplication {
	
	public static void main(String[] args) throws IOException {
		
		List<Linha> lista = new Leitor().ler();
		
		List<Piloto> pilotos = new Tratamento().retornaPilotos(lista);
		
		List<Ranking> rankings = new CalculaRanking().getRanking(pilotos);
		
		rankings.stream().map(r -> r.getDuracao()).forEach(System.out::println);
	}
	
}
