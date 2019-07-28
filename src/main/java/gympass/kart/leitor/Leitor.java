package gympass.kart.leitor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import gympass.kart.vo.Linha;

/**
 * 
 * Classe responsável por ler o kart.txt.
 * 
 * @author leonardo
 *
 */
public class Leitor {

	private static final String filePath = "src/main/resources/kart.txt";

	/**
	 * 
	 * Transforma cada linha do kart.txt num {@link Linha}.
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Linha> ler() throws IOException {
		
		InputStream is = new FileInputStream(filePath);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		pularCabecalho(reader, 1);
		
		List<Linha> lista = new ArrayList<Linha>();
		String linhaTxt = null;
		
		while ((linhaTxt = reader.readLine()) != null) {
			
			Linha linha = extrairLinhaParaObjeto(linhaTxt);

			lista.add(linha);
			
		}
		
		reader.close();
		is.close();
		
		return lista;
	}

	/**
	 * 
	 * A partir de uma linha de texto transforma para o objeto {@link Linha}.
	 * 
	 * @param linhaTxt
	 * @return
	 */
	protected Linha extrairLinhaParaObjeto(String linhaTxt) {
		String hora = linhaTxt.substring(0, 12);

		String idPiloto = linhaTxt.substring(18, 21);
		
		String nomePiloto = linhaTxt.substring(24, 38).trim();
		
		String numeroVolta = linhaTxt.substring(58, 59);

		String tempoMinutoVolta = linhaTxt.substring(64, 65);
		String tempoSegundoVolta = linhaTxt.substring(66, 68);
		String tempoMillisVolta = linhaTxt.substring(69, 72);
		
		Duration tempoVolta = Duration.ofMinutes(Integer.parseInt(tempoMinutoVolta)).plusSeconds(Integer.parseInt(tempoSegundoVolta))
				.plusMillis(Integer.parseInt(tempoMillisVolta));

		String velocidadeMediaVolta = linhaTxt.substring(96, 102).trim().replace(",", ".");
		
		Linha linha = new Linha(
				LocalTime.parse(hora),
				nomePiloto, 
				idPiloto, 
				Integer.parseInt(numeroVolta), 
				tempoVolta, 
				new BigDecimal(velocidadeMediaVolta));
		
		return linha;
	}

	/**
	 * 
	 * Pula um número n de linhas de cabeçalho.
	 * 
	 * @param reader
	 * @param n
	 * @throws IOException
	 */
	private void pularCabecalho(BufferedReader reader, Integer n) throws IOException {
		for (int i = 0; i < n; i++) {
			reader.readLine();
		}
	}
	
}
