import java.util.Random;

public class Cliente extends Thread{

	Observable unObservable;
	int Maxt;
	int Mint;
	
	public Cliente (Observable unObservable, int Maxt, int Mint){
		this.unObservable = unObservable;
		this.Maxt = Maxt;
		this.Mint = Mint;
	}
	
	//Simulador
	public void run(){
		Random rnd = new Random();
		int temperatura = Maxt;
		while (true){
			temperatura = rnd.nextInt(Maxt - Mint) + Mint;
			try {
				Thread.sleep(60000);
				}
				catch(java.lang.InterruptedException e){
					    e.printStackTrace();
				}
			unObservable.notificarObservador(temperatura);
			}
		
	}
	
	
	public static void main(String[] args) {
		Observador pantallaC = new PantallaCelsius();
		Observador pantallaF = new PantallaFahrenheit();
		Observador pantallaK = new PantallaKelvin();
		int max = 40;
		int min = 9;
		
		Observable observablePantalla = new ObservablePantalla();
		observablePantalla.incluisObservador(pantallaC);
		observablePantalla.incluisObservador(pantallaF);
		observablePantalla.incluisObservador(pantallaK);


		Cliente simulador = new Cliente(observablePantalla, max, min);
		
		//Inicio del simulador
		simulador.start();
		
		
		
	}

}
