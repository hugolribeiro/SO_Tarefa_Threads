package controller;

public class Corrida {
	
	private int percurso_total = 50;
	private int [] ganhadores = new int[5];
	private int qtd_ganhadores = 0;
	
	public Corrida() {
		this.setPercurso_total(percurso_total);
	}
	
	public void cruzou_linha(int numero) {
		ganhadores[qtd_ganhadores] = numero;
		qtd_ganhadores += 1;
	}

	public int getPercurso_total() {
		return percurso_total;
	}

	public void setPercurso_total(int percurso_total) {
		this.percurso_total = percurso_total;
	}
	
	public boolean verifica_terminou() {
		if (qtd_ganhadores == 5) {
			return true;
		}
		else {
			return false;
		}
	}

	public int[] getGanhadores() {
		return ganhadores;
	}

	public int getQtd_ganhadores() {
		return qtd_ganhadores;
	}
	
}
