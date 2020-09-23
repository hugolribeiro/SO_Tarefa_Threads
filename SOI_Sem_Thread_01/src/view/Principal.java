package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforobd = new Semaphore(permissoes);
		
		for (int idCalc = 1; idCalc < 22; idCalc ++) {
			Thread tCalc = new ThreadCalc(idCalc, semaforobd);
			tCalc.start();
			
		}
		
	}

}
