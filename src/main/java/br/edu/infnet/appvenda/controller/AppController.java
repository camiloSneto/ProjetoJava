package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.BebidaService;
import br.edu.infnet.appvenda.model.service.NaoConsumivelService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.InformacaoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private NaoConsumivelService naoConsumivelService;
	@Autowired
	private BebidaService bebidaService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private InformacaoService informacaoService;

	@GetMapping(value = "/")
	public String showHome(Model model) {

		model.addAttribute("informacoes", informacaoService.obterLista());

		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeNaoConsumivel", naoConsumivelService.obterQtde());
		model.addAttribute("qtdeBebida", bebidaService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		return "home";
	}

	@GetMapping(value = "/naoconsumivel/lista")
	public String obterNaoConsumivelLista(Model model) {
		model.addAttribute("listagem", naoConsumivelService.obterLista());
		model.addAttribute("titulo", "Produtos Não Pereciveis: ");
		return showHome(model);
	}

	@GetMapping(value = "/bebida/lista")
	public String obterBebidaLista(Model model) {
		model.addAttribute("listagem", bebidaService.obterLista());
		model.addAttribute("titulo", "Bebidas: ");
		return showHome(model);
	}

	@GetMapping(value = "/produto/lista")
	public String obterProdutoLista(Model model) {
		model.addAttribute("listagem", produtoService.obterLista());
		model.addAttribute("titulo", "Todos Produtos: ");
		return showHome(model);
	}
}
