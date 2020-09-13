package controller;

//extends Threads
//Todos os parâmetros são passados pelo construtor
//Método run()

public class ThreadSoma extends Thread{
	
	private int[] vetor;
	private int numero_linha;
	
	public ThreadSoma(int[] vetor, int numero_linha) {
		this.vetor = vetor;
		this.numero_linha = numero_linha;
	}
	
	public void run() {
		bloqueia_tempo();
		for (int number : vetor) {
			System.out.print(number);
		}
		System.out.println();
		int soma = somalinha();
		System.out.println("Soma da linha " + numero_linha + " : "+soma);
		
	}
	
	private int somalinha() {
		int soma_linha = 0;
		for (int item : vetor) {
			soma_linha += item;
		}
		return soma_linha;
	}
	
	private void bloqueia_tempo() {
		// Bloquear alguma Thread por x ms
		int tempo = 10;
		try {
			sleep(tempo * numero_linha);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
