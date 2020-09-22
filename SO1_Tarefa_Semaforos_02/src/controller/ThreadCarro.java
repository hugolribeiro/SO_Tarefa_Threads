package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private String direcao;
	
	public ThreadCarro(int idCarro, Semaphore semaforo, String direcao) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.direcao = direcao;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			carroAndando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("O carro "+idCarro+", que vai para a direção "+direcao+" saiu do cruzamento.");
			semaforo.release();
		}
		
	}
	
	public void carroAndando() {
		System.out.println("O carro "+idCarro+" está no cruzamento.");
	}
}
