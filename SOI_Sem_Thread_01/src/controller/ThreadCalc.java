package controller;

import java.util.concurrent.Semaphore;

public class ThreadCalc extends Thread{
	
	private int idThread;
	private Semaphore semaforobd;
	
	public ThreadCalc(int idThread, Semaphore semaforobd) {
		this.idThread = idThread;
		this.semaforobd = semaforobd;
	}
	@Override
	public void run() {
		int resto_divisao;
		double tcalcmin;
		double tcalcmax;
		int qtd_loops;
		double t_transacaobd;
		// Checar qual id será
		resto_divisao = idThread % 3;
		System.out.println("Id: "+idThread+" resto da divisão: "+resto_divisao);
		switch(resto_divisao) {
		
			case 0:
				tcalcmin = 0.2;
				tcalcmax = 1;
				qtd_loops = 2;
				t_transacaobd = 1;
				operacao(tcalcmin, tcalcmax, t_transacaobd, qtd_loops);
				break;
			case 1:
				tcalcmin = 0.5;
				tcalcmax = 1.5;
				qtd_loops = 3;
				t_transacaobd = 1.5;
				operacao(tcalcmin, tcalcmax, t_transacaobd, qtd_loops);
				break;
			case 2:
				tcalcmin = 1;
				tcalcmax = 2;
				qtd_loops = 3;
				t_transacaobd = 1.5;
				operacao(tcalcmin, tcalcmax, t_transacaobd, qtd_loops);
				break;
		}
	}
	
	public void operacao(double t_min, double t_max, double t_transacaobd, int qtd_loops) {
		System.out.println("ID: "+idThread+" iniciando as operações."
				+ "\nTempo min: "+t_min
				+ "\nTempo max: "+t_max
				+ "\nQuantidade: "+qtd_loops);
		for (int op = 0; op < qtd_loops; op ++) {
			calculo(t_min, t_max);
			try {
				// Seção crítica
				semaforobd.acquire();
				transacao(t_transacaobd);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				semaforobd.release();
			}
			
		}
		System.out.println("#### A ID "+idThread+" encerrou todas suas operações!");
		
	}
	
	public void calculo(double t_min, double t_max) {
		double tempo = (Math.random() * ((t_max - t_min))) + t_min;
		System.out.println("ID: "+idThread+" calculando. Levará "+tempo+" segundos");
		try {
			sleep((long) (tempo * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ID: "+idThread+" realizou cálculo em "+tempo+" segundos");
	}
	
	public void transacao(double t_transacaobd) {
		System.out.println("ID: "+idThread+" transação de bd será realizada após "+t_transacaobd+" segundos");
		try {
			sleep((long) (t_transacaobd*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ID: "+idThread+" transação de bd realizada em "+t_transacaobd+" segundos");
	}
	
}
