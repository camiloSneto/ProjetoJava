package br.edu.infnet.appvenda.model.domain;

public class Produto {
	private String descricao;
	private int codigo;
	private double preco;
	private boolean estoque;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s  ", codigo, descricao, estoque, preco);	
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
}
