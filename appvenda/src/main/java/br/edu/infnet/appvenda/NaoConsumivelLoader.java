package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.NaoConsumivel;
import br.edu.infnet.appvenda.model.service.NaoConsumivelService;

@Order(3)
@Component
public class NaoConsumivelLoader implements ApplicationRunner {

	@Autowired
	private NaoConsumivelService naoConsumivelService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/naoConsumivel.txt");
		BufferedReader  leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null){
			
			campos = linha.split(";");
			

			NaoConsumivel naoConsumivel = new NaoConsumivel();
				
			naoConsumivel.setCodigo(Integer.valueOf(campos[0]));
			naoConsumivel.setDescricao(campos[1]);
			naoConsumivel.setEstoque(Boolean.valueOf(campos[2]));
			naoConsumivel.setPreco(Float.valueOf(campos[3]));
			naoConsumivel.setMarca(campos[4]);
			naoConsumivel.setMaterial(campos[5]);
			naoConsumivel.setPeso(Float.valueOf(campos[6]));
				
			naoConsumivelService.incluir(naoConsumivel);
				
			
			
			linha = leitura.readLine();
		}
		
		for(NaoConsumivel naoConsumivel: naoConsumivelService.obterLista()) {
			System.out.println("[NaoConsumivel] " + naoConsumivel);
		}
		leitura.close();		
	}

}
