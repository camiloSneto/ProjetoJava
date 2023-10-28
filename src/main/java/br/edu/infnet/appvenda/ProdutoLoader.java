package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Bebida;
import br.edu.infnet.appvenda.model.domain.NaoConsumivel;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner  {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produto.txt");
		BufferedReader  leitura = new BufferedReader(file);
		Vendedor vendedor = new Vendedor();
		String linha = leitura.readLine();
		
		String[] campos = null;
		
		while(linha != null){
			
			campos = linha.split(";");
			
			
			vendedor.setId(Integer.valueOf(campos[8]));
			
			switch (campos[7]) {
			
			case "NC":
				NaoConsumivel produto = new NaoConsumivel();
				
				produto.setCodigo(Integer.valueOf(campos[0]));
				produto.setDescricao(campos[1]);
				produto.setEstoque(Boolean.valueOf(campos[2]));
				produto.setPreco(Float.valueOf(campos[3]));
				produto.setMarca(campos[4]);
				produto.setMaterial(campos[5]);
				produto.setPeso(Float.valueOf(campos[6]));
				produto.setVendedor(vendedor);			
				
				produtoService.incluir(produto);
				
				break;
			case "B":
				Bebida bebida = new Bebida();
				
				bebida.setCodigo(Integer.valueOf(campos[0]));
				bebida.setDescricao(campos[1]);
				bebida.setEstoque(Boolean.valueOf(campos[2]));
				bebida.setPreco(Float.valueOf(campos[3]));
				bebida.setSabor(campos[4]);
				bebida.setAlcoolico(Boolean.valueOf(campos[5]));
				bebida.setVolume(Float.valueOf(campos[6]));
				bebida.setVendedor(vendedor);
				
				produtoService.incluir(bebida);
				break;
			default:
				break;
			}

			linha = leitura.readLine();
		}
		
		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);
		}
		
		System.out.println("Produtos do vendedor: " + vendedor.getId());
		for(Produto produto: produtoService.obterLista(vendedor.getId())) {
			System.out.println("[Produto] " + produto);
		}
		
		leitura.close();		
	}
}
