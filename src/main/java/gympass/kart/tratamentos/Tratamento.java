package gympass.kart.tratamentos;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gympass.kart.vo.Linha;
import gympass.kart.vo.Piloto;
import gympass.kart.vo.Volta;

/**
 * 
 * Classe responsável por transformar uma {@link List} de {@link Linha} em uma {@link List} de {@link Piloto}
 * realizando uma série de tratamentos.
 * 
 * @author leonardorm
 *
 */
public class Tratamento {

	/**
	 * 
	 * Corrige nomes e retorna {@link List} de {@link Piloto pilotos}
	 * 
	 * @param lista
	 * @return
	 */
	public List<Piloto> retornaPilotos(List<Linha> lista) {

		Map<String, List<Linha>> map = lista.stream().collect(Collectors.groupingBy(Linha::getIdPiloto));

		corrigeNomes(map);
		
		List<Piloto> pilotos = extrairPilotosComVoltas(map);

		return pilotos;
	}

	/**
	 * 
	 * Mapeia de {@link Linha} para {@link Piloto} a partir do {@link Map};
	 * 
	 * @param map
	 * @return
	 */
	private List<Piloto> extrairPilotosComVoltas(Map<String, List<Linha>> map) {
		
		List<Piloto> pilotos = map.entrySet().stream().map(entry -> {
			
			String idPiloto = entry.getKey();
			
			List<Linha> linhasPiloto = entry.getValue();
			
			List<Volta> voltasPiloto = linhasPiloto.stream().map(l -> new Volta(l.getNumeroVolta(), l.getTempoVolta(),
					l.getVelocidadeMediaVolta(), l.getHora())).collect(Collectors.toList());
			
			return new Piloto(idPiloto, linhasPiloto.get(0).getNomePiloto(), voltasPiloto);
			
		}).collect(Collectors.toList());
		
		return pilotos;
	}

	/**
	 * 
	 * Os nomes de alguns pilotos variam ao longo das linhas.
	 * <p>
	 * Normalizando para a primeira ocorrência do nome.
	 * 
	 * @param map
	 */
	private void corrigeNomes(Map<String, List<Linha>> map) {
		map.entrySet().forEach(entry -> {

			List<Linha> linhasDoPilotoOrdenadasPorHora = entry.getValue().stream()
					.sorted(Comparator.comparing(Linha::getHora)).collect(Collectors.toList());

			Linha primeiraLinhaDoPiloto = linhasDoPilotoOrdenadasPorHora.get(0);

			linhasDoPilotoOrdenadasPorHora.forEach(l -> l.setNomePiloto(primeiraLinhaDoPiloto.getNomePiloto()));

		});
	}

}
