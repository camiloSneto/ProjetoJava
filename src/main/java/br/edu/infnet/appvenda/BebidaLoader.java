package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Bebida;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.BebidaService;

@Order(2)
@Component
public class BebidaLoader implements ApplicationRunner {

	@Autowired
	private BebidaService bebidaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/bebida.txt");
		BufferedReader  leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null){
			
			campos = linha.split(";");
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[7]));

			Bebida bebida = new Bebida();
			
			bebida.setCodigo(Integer.valueOf(campos[0]));
			bebida.setDescricao(campos[1]);
			bebida.setEstoque(Boolean.valueOf(campos[2]));
			bebida.setPreco(Float.valueOf(campos[3]));
			bebida.setSabor(campos[4]);
			bebida.setAlcoolico(Boolean.valueOf(campos[5]));
			bebida.setVolume(Float.valueOf(campos[6]));
			bebida.setVendedor(vendedor);
			
			bebidaService.incluir(bebida);
				
			
			
			linha = leitura.readLine();
		}
		
		for(Bebida bebida: bebidaService.obterLista()) {
			System.out.println("[Bebida] " + bebida);
		}
		leitura.close();		
	}
}
