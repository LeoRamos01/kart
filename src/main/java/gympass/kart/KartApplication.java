package gympass.kart;

import java.io.IOException;
import java.util.List;

import gympass.kart.leitor.Leitor;
import gympass.kart.tratamentos.Tratamento;
import gympass.kart.vo.Linha;
import gympass.kart.vo.Piloto;

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
		
		System.out.println(pilotos);
		
	}
	
}
