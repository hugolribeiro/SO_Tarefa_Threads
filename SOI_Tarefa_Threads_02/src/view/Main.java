package view;

import controller.ThreadID;

public class Main {

	public static void main(String[] args) {
		

		// Laço para gerar cada uma das 5 threads com seus ids passados como parâmetros
		
		for (int thread = 0; thread < 5; thread ++) {
			Thread TId = new ThreadID(thread);
			TId.start();
		}
	}

}
