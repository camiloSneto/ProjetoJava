package br.edu.infnet.appvenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appvenda.clients.IInformacaoClient;
import br.edu.infnet.appvenda.model.domain.Informacao;

@Service
public class InformacaoService {

	@Autowired
	private IInformacaoClient informacaoClient;

	public List<Informacao> obterLista() {
		return informacaoClient.obterLista();
	}

	public Informacao incluir(Informacao informacao) {
		return informacaoClient.incluir(informacao);
	};
}
