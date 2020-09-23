package controller;

import java.util.concurrent.Semaphore;

public class ThreadPrato extends Thread {
	
	private int idPrato;
	private Semaphore semaforo;
	
	public ThreadPrato(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		boolean par = (idPrato % 2 == 0);
		if (par) {
			lasanha();
		}
		else {
			sopa_cebola();
		}
		//a entrega será crítica
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}
	
	public void lasanha() {
		double tempo_preparo = (Math.random() * ((1.2) - 0.6)) + 0.6;
		System.out.println("A lasanha de ID "+idPrato+" levará "+tempo_preparo+" segundos para ficar pronta.");
		double tempo_percorrido = 0;
		int porcentagem_concluida;
		while (tempo_percorrido < tempo_preparo) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tempo_percorrido += 0.1;
			if (tempo_percorrido >= tempo_preparo) {
				break;
			}
			porcentagem_concluida = (int) (tempo_percorrido*100/tempo_preparo);
			System.out.println("O prato da lasanha, ID "+idPrato+" está "+porcentagem_concluida+"% concluído");
		}
		System.out.println("O prato da lasanha, ID "+idPrato+" foi concluído!");
	}
	
	public void sopa_cebola() {
		double tempo_preparo = (Math.random() * ((0.8) - 0.5)) + 0.5;
		System.out.println("A sopa de cebola de ID "+idPrato+" levará "+tempo_preparo+" segundos para ficar pronta.");
		double tempo_percorrido = 0;
		int porcentagem_concluida;
		while (tempo_percorrido < tempo_preparo) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 0.1s de espera
			tempo_percorrido += 0.1;
			if (tempo_percorrido >= tempo_preparo) {
				break;
			}
			porcentagem_concluida = (int) (tempo_percorrido*100/tempo_preparo);
			System.out.println("O prato da sopa de cebola, ID "+idPrato+" está "+porcentagem_concluida+"% concluído");
		}
		System.out.println("O prato da sopa de cebola, ID "+idPrato+" foi concluído!");
	}
	
	public void entrega() {
		if (idPrato % 2 == 0) {
			System.out.println("\n####Você entregou a lasanha ID "+idPrato+" parabéns!!####\n");
		}
		else {
			System.out.println("\n####Você entregou a sopa de cebola ID "+idPrato+" parabéns!!####\n");
		}
	}

}
