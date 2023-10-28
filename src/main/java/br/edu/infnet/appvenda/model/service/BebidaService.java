package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Bebida;
import br.edu.infnet.appvenda.model.repository.BebidaRepository;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository bebidaRepository;
	
	public void incluir(Bebida bebida) {
		bebidaRepository.save(bebida);
	}
	
	public Collection<Bebida> obterLista() {
		return (Collection<Bebida>) bebidaRepository.findAll();
	}
}
