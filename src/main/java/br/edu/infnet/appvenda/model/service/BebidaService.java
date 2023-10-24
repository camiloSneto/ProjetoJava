package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Bebida;

@Service
public class BebidaService {
	private Map<Integer, Bebida> mapaBebida = new HashMap<Integer, Bebida>();
	
	public void incluir(Bebida bebida) {
		mapaBebida.put(bebida.getCodigo(), bebida);
	}
	
	public Collection<Bebida> obterLista() {
		return mapaBebida.values();
	}
}
