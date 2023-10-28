package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TNaoConsumivel")
public class NaoConsumivel extends Produto {
	
	private String marca;
	private String material;
	private float peso;

	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), marca, material, peso);	
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
