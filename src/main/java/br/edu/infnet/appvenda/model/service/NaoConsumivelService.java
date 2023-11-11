package br.edu.infnet.appvenda.model.service;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.NaoConsumivel;
import br.edu.infnet.appvenda.model.repository.NaoConsumivelRepository;

@Service
public class NaoConsumivelService {
	
	@Autowired
	private NaoConsumivelRepository naoConsumivelRepository;
	
	public void incluir(NaoConsumivel naoConsumivel) {
		naoConsumivelRepository.save(naoConsumivel);
	}
	
	public Collection<NaoConsumivel> obterLista() {
		return (Collection<NaoConsumivel>) naoConsumivelRepository.findAll();	
	}
}
