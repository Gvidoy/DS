import java.util.ArrayList;
import java.util.Random;


public class Cliente extends Thread{
	Equipo equipo;
	private VisitanteEquipo visitante;
	private int peticiones = 0;
	final private int descuento = 5;
	
	public Cliente(Equipo equipo, VisitanteEquipo visitante){
		this.equipo = equipo;
		this.visitante = visitante;
	}
	
	//@Override
	public void run(){
		visitante.visitar(equipo);
		double coste = visitante.costeTotal();
		if(peticiones > 25){
			//System.out.println("---------------Descuento EXTRA-------------------- " + visitante.getNombreVisitante() );
			coste = (coste * 5) /100;
		}
		
		System.out.println("Visitante tipo: " + visitante.getNombreVisitante()+ " coste de "+ equipo.nombre()+ "  " + coste);
	}
	public void setPeticiones(int peticiones){
		this.peticiones = peticiones;
	}
	public String getNombreVisitante(){
		return visitante.getNombreVisitante();
	}


	public static void main(String[] args) {
		//Equipos
		Equipo bus;
		bus = new Bus ("ide", 1.2, 3.4, 10.0);
		
		
		Equipo disco;
		disco = new Disco ("sagate", 5.2, 6.4, 10.0);
		
		Equipo targeta;
		targeta = new Targeta ("vebo", 3.2, 6.4, 10.0);
		
		//Array de hebras
		ArrayList<Cliente> arrayHebras = new ArrayList<Cliente>();
		VisitanteEquipo visitante;
		Random rnd = new Random();
		int randon = rnd.nextInt(3);
		int nVip = 0;
		int nMayorista = 0;
		int nSinDescuento = 0;
		
		//Creo los visitantes aleatoriamente
		for (int i = 0; i < 70; i++){
			randon = rnd.nextInt(3);
			if(randon == 0){
				nVip++;
				visitante = new Vip();
			}else if(randon == 1){
				nMayorista++;
				visitante = new Mayorista();
			}else{
				nSinDescuento++;
				visitante = new SinDescuento();
			}
			
			arrayHebras.add(new Cliente (bus,visitante)); 
		}
		
		System.out.println("El numero de visitantes Vip es " + nVip);
		System.out.println("El numero de visitantes Mayorista es " + nMayorista);
		System.out.println("El numero de visitantes SinDescuento es " + nSinDescuento);
		
		String Nombre;
		
		//indico los descuentos en funcion de las peticiones > 25 
		for(Cliente T: arrayHebras){
			Nombre = T.getNombreVisitante();
			if((nVip > 25) && (Nombre == "VIP") ){
				T.setPeticiones(nVip);
			}else if ((nVip > 25) && (Nombre == "MAYORISTA") ){
				T.setPeticiones(nMayorista);
			}else{
				T.setPeticiones(nSinDescuento);
			}
		//Inicio las hebras	
		}
		
		for(Cliente T: arrayHebras){
			T.start();
		}
		
	}

}
