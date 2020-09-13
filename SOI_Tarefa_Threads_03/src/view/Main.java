/*
 * Fazer uma aplicação que insira números aleatórios em uma matriz 3 x 5 e tenha 3
 * Threads, onde cada Thread calcula a soma dos valores de cada linha, imprimindo a identificação
 * da linha e o resultado da soma.
 * 
 * @Hugo Leça Ribeiro
 */

package view;

import java.util.Random;

import controller.ThreadSoma;

public class Main {

	public static void main(String[] args) {
		
		// Iniciando matriz
		int matriz[][] = new int[3][5];
		
		//Instanciando o Random
		Random gerador = new Random();
		
		// Inserindo números aleatórios na matriz
		for (int linha = 0; linha < 3; linha ++) {
			for (int coluna = 0; coluna < 5; coluna ++) {
				matriz[linha][coluna] = gerador.nextInt(10);
			}
		}
		
		// Visualizando a matriz
		for (int linha = 0; linha < 3; linha ++) {
			for (int coluna = 0; coluna < 5; coluna ++) {
				System.out.print(matriz[linha][coluna]+" ");
			}
			System.out.println();
		}
		
		// Chamando cada thread com seu vetor (linha da matriz)
		int vetor[] = new int[5];
		for (int linha = 0; linha < 3; linha ++) {
			for (int coluna = 0; coluna < 5; coluna ++) {
				vetor[coluna] = matriz[linha][coluna];
			}
			for (int item : vetor) {
				System.out.print(item + " ");
			}
			System.out.println();
			Thread Tcalclinha = new ThreadSoma(vetor, linha);
			Tcalclinha.start();
		}
		
	}

}
