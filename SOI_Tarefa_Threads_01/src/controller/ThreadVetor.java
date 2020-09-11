package controller;

public class ThreadVetor extends Thread {
	
	private int number;
	private int [] vetor;
	
	public ThreadVetor(int number, int[]vetor) {
		this.number = number;
		this.vetor = vetor;
	}
	
	@Override
	public void run() {
		calc();
	}
	
	private void calc() {
		int soma = 0;
		// caso o número seja par faremos o for convencional
		if (number % 2 == 0) {
			double tempoInicial1 = System.nanoTime();
			for (int i = 0; i < vetor.length; i ++) {
				soma += vetor[i];
			}
			double tempoFinal1 = System.nanoTime();
			double tempoTotal1 = tempoFinal1 - tempoInicial1;
			tempoTotal1 = tempoTotal1 / Math.pow(10,  9);
			System.out.println("Algoritmo 1 ===> " + tempoTotal1 + "s");
			
		}
		// caso o número seja ímpar faremos foreach
		else {
			double tempoInicial2 = System.nanoTime();
			for (int item : vetor) {
				soma += item;
			}
			double tempoFinal2 = System.nanoTime();
			double tempoTotal2 = tempoFinal2 - tempoInicial2;
			tempoTotal2 = tempoTotal2 / Math.pow(10, 9);
			System.out.println("Algoritmo 2 ===> " + tempoTotal2 + "s");
		}
		
	}
}
