package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.clients.IEnderecoClient;
import br.edu.infnet.appvenda.model.domain.Endereco;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Vendedor pesquisar(String cpf) {
		return vendedorRepository.findByCpf(cpf);
	}
	
	public void incluir(Vendedor vendedor) {
		
		String cep = vendedor.getEndereco().getCep();
		Endereco endereco = enderecoClient.buscarCep(cep);
		vendedor.setEndereco(endereco);
		
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista() {
		return (Collection<Vendedor>) vendedorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public long obterQtde() {
    	return vendedorRepository.count();
	}
	
	public void excluir(Integer id) {
		vendedorRepository.deleteById(id);
	}
}
