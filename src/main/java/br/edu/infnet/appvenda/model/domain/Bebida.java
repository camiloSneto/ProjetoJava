package br.edu.infnet.appvenda.model.domain;

public class Bebida extends Produto {
	
	private String sabor;
	private boolean alcoolico;
	private float volume;
	
	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s ", super.toString(), sabor, alcoolico, volume);	
	}
	
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public boolean isAlcoolico() {
		return alcoolico;
	}
	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}
}
