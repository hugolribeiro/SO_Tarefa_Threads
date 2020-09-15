package controller;

import java.util.Random;

//extends Threads
//Todos os parâmetros são passados pelo construtor
//Método run()

public class ThreadSapo extends Thread {
	
	private int sapo;
	private int distancia_percorrida = 0;
	private Corrida corr;
	
	public ThreadSapo(int sapo, Corrida corr) {
		this.sapo = sapo;
		this.corr = corr;
	}

	@Override
	public void run() {
		while (distancia_percorrida < corr.getPercurso_total()) {
			pular();
			
		}
		corr.cruzou_linha(sapo);
		System.out.println("Sapo nº "+sapo+" cruzou a linha de chegada em "+corr.getQtd_ganhadores()+"º");
	}
	
	public void pular() {
		Random gerador = new Random();
		int distancia = gerador.nextInt(10)+1;
		distancia_percorrida += distancia;
		System.out.println("O sapo "+sapo+" pulou "+distancia+" metros");
	}

}
