package controller;

import java.util.Random;

public class Sapo {
	
	private int numero;
	private int distancia_percorrida = 0;

	public Sapo(int numero) {
		this.numero = numero;
	}
	
	public void pular() {
		Random gerador = new Random();
		int distancia = gerador.nextInt(10);
		distancia_percorrida += distancia;
	}

	public int getNumero() {
		return numero;
	}

	public int getDistancia_percorrida() {
		return distancia_percorrida;
	}

	public void setDistancia_percorrida(int distancia_percorrida) {
		this.distancia_percorrida = distancia_percorrida;
	}
	
	
}
