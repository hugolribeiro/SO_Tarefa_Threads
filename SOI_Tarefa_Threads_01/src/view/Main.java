package view;

import java.util.Random;

import controller.ThreadVetor;

public class Main {

	public static void main(String[] args) {
		
		int [] vetor = new int[1000];
		
		Random gerador = new Random();
		for (int i = 0; i < 1000; i ++) {
			vetor[i] = gerador.nextInt(101);
		}
		
		Thread tCalc = new ThreadVetor(1, vetor);
		tCalc.start();
		Thread tCalc1 = new ThreadVetor(2, vetor);
		tCalc1.start();
	}

}
