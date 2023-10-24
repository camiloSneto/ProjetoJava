package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.NaoConsumivel;

@Service
public class NaoConsumivelService {
	private Map<Integer, NaoConsumivel> mapaNaoConsumivel = new HashMap<Integer, NaoConsumivel>();
	
	public void incluir(NaoConsumivel naoConsumivel) {
		mapaNaoConsumivel.put(naoConsumivel.getCodigo(), naoConsumivel);
	}
	
	public Collection<NaoConsumivel> obterLista() {
		return mapaNaoConsumivel.values();
	}
}
