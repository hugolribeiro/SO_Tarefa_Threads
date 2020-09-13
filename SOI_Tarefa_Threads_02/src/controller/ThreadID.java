package controller;

public class ThreadID extends Thread {
	
	private int number;
	
	public ThreadID(int number) {
		this.number = number;
	}
	
	public void run() {
		long id = 0;
		System.out.println("Id desta Thread("+number+"): " + getId());
	}

}
