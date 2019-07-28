package gympass.kart;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import gympass.kart.leitor.Leitor;
import gympass.kart.tratamentos.CalculaRanking;
import gympass.kart.tratamentos.Tratamento;
import gympass.kart.vo.Linha;
import gympass.kart.vo.Piloto;
import gympass.kart.vo.Ranking;
import gympass.kart.vo.Volta;

/**
 * 
 * Entrada da aplicação.
 * 
 * @author leonardo
 *
 */
public class KartApplication {
	
	static CalculaRanking calculaRanking = new CalculaRanking();
	
	public static void main(String[] args) throws IOException {
		
		List<Linha> lista = new Leitor().ler();
		
		List<Piloto> pilotos = new Tratamento().retornaPilotos(lista);
		
		List<Ranking> rankings = calculaRanking.getRanking(pilotos);
		System.out.println("Problema)");
		System.out.println("Posição Chegada, Código Piloto, Nome Piloto, Qtde Voltas Completadas e Tempo Total de Prova:");
		rankings.forEach(System.out::println);
		System.out.println("\n===========================================================================================\n");
		
		List<Pair<String, Integer>> melhorVoltaCadaPiloto = calculaRanking.melhorVoltaCadaPiloto(pilotos);
		System.out.println("Bônus - 1)");
		System.out.println("Melhor volta dos pilotos:");
		melhorVoltaCadaPiloto.forEach(System.out::println);
		System.out.println("\n===========================================================================================\n");
		
		Pair<String, Volta> melhorVoltaCorrida = calculaRanking.melhorVoltaCorrida(pilotos);
		System.out.println("Bônus - 2)");
		System.out.println("Melhor volta da corrida:");
		System.out.println(melhorVoltaCorrida);
		System.out.println("\n===========================================================================================\n");
		
		List<Pair<String, BigDecimal>> velocidadeMediaPiloto = calculaRanking.velocidadeMediaPiloto(pilotos);
		System.out.println("Bônus - 3)");
		System.out.println("Velocidade média por piloto:");
		velocidadeMediaPiloto.forEach(System.out::println);
		System.out.println("\n===========================================================================================\n");
		
		List<Pair<String, String>> tempoPilotosAposVencedor = calculaRanking.tempoPilotosAposVencedor(rankings);
		System.out.println("Bônus - 4)");
		System.out.println("Tempos de atraso:");
		tempoPilotosAposVencedor.forEach(System.out::println);
		System.out.println("\n===========================================================================================\n");
		
	}
	
}
