/*
 * Para tal, usar uma variável sentido, que será alterado pela Thread que controla cada carro com a movimentação do carro. 
 * Quando a Thread tiver a possibilidade de ser executada, ela deve imprimir em console o sentido que o carro está passando. 
 * Só pode passar um carro por vez no cruzamento.
 */
package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Cruzamento {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		Thread tCarro1 = new ThreadCarro(1, semaforo, "->");
		tCarro1.start();
		Thread tCarro2 = new ThreadCarro(2, semaforo, "<-");
		tCarro2.start();
		Thread tCarro3 = new ThreadCarro(3, semaforo, "^");
		tCarro3.start();
		Thread tCarro4 = new ThreadCarro(4, semaforo, "v");
		tCarro4.start();
	}

}
