package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	
	private int idPessoa;
	private Semaphore semaforo;
	
	public ThreadPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		pessoaAndando();
//		Seção crítica
		try {
			semaforo.acquire();
			pessoaEntrando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
//			-- Fim seção crítica --
		}
		
	}
	
	public void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = 0;;
		int tempo = 1000; //1000ms
		while (distanciaPercorrida < distanciaTotal) {
			deslocamento = (int) (Math.random() * 2 + 4);
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (distanciaPercorrida > 200) {
				System.out.println("#" + idPessoa + " já andou 200 metros");
				break;
			}
			else {
				System.out.println("#" + idPessoa + " já andou " + distanciaPercorrida + " metros");
			}
		}
		System.out.println("#" + idPessoa + " chegou à porta.");
	}
	
	public void pessoaEntrando() {
		System.out.println("#" + idPessoa + " vai abrir a porta para entrar...");
		int time = (int) (Math.random() * 1000 + 1000);
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("#" + idPessoa + " já cruzou a porta.");
	}

}
