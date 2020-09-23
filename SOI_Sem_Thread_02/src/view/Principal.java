package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPrato;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int prato = 1; prato < 6; prato ++) {
			Thread tPrato = new ThreadPrato(prato, semaforo);
			tPrato.start();
		}
	}

}
