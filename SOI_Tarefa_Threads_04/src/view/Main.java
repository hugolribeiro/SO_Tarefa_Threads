/*
 * Fazer uma aplicação de uma corrida de sapos, com 5 Threads, 
 * cada Thread controlando 1 sapo. Deve haver um tamanho máximo para cada pulo do sapo (em metros) 
 * e a distância máxima para que os sapos percorram. A cada salto, 
 * um sapo pode dar uma salto de 0 até o tamanho máximo do salto (valor aleatório). 
 * Após dar um salto, a Thread, para cada sapo, deve mostrar no console, 
 * qual foi o tamanho do salto e quanto o sapo percorreu. 
 * Assim que o sapo percorrer a distância máxima, 
 * a Thread deve apresentar que o sapo chegou e qual sua colocação.
 * @Hugo Leça Ribeiro
 */

package view;

import controller.Corrida;
import controller.ThreadSapo;

public class Main {

	public static void main(String[] args) {
		// Chamando cada thread de sapo
		Corrida corr = new Corrida();
		for (int sapo = 1; sapo < 6; sapo ++) {
			Thread Tcorridasapo = new ThreadSapo(sapo, corr);
			Tcorridasapo.start();
		}
		
	}

}
