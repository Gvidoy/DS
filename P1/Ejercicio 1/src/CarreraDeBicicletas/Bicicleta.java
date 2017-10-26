package CarreraDeBicicletas;

public class Bicicleta {

	private int dorsal;
	private TC tipo;
	private Ruedas ruedaDelantera;
	private Ruedas ruedaTrasera;
	private Cuadro cuadro;
	private Manillar manillar;
	
	private void manillarCarretera(){
		manillar = new ManillarCarretera();
	}
	private void manillarMontana(){
		manillar = new ManillarMontana();
	}
	private void cuadroCarretera(){
		cuadro = new CuadroCarretera();
	}
	private void cuadroMontana(){
		cuadro = new CuadroMontana();
	}
	private void ruedasCarretera(){
		ruedaDelantera = new RuedaCarretera();
		ruedaTrasera = new RuedaCarretera();
	}
	private void ruedasMontana(){
		ruedaDelantera = new RuedaMontana();
		ruedaTrasera = new RuedaMontana();
	}
	
	
	public Bicicleta(int dorsal, TC tipo){
		this.dorsal = dorsal;
		this.tipo = tipo;
		if (tipo == TC.CARRETERA){
			this.manillarCarretera();
			this.cuadroCarretera();
			this.ruedasCarretera();
		} else if (tipo == TC.MONTANA){
			this.manillarMontana();
			this.cuadroMontana();
			this.ruedasMontana();
		} else{
			System.out.println("Error al crear manillar");
		}
		
	}
	public int dorsal(){
		return dorsal;
	}
	public TC tipo(){
		return tipo;
	}
	public String toString(){
		String tipoBicicleta;
		if(this.tipo == TC.CARRETERA){
			tipoBicicleta = "bicicleta{tipo carretera} Dorsal " + dorsal;
		} else if(this.tipo == TC.MONTANA){
			tipoBicicleta = "bicicleta{tipo montaña} " + dorsal;
		}else{
			tipoBicicleta = "Bicicleca NO CREADA CORRECTAMENTE";
		}
		return tipoBicicleta;
	}
	
	public String getruedaDelantera(){
		return ruedaDelantera.getRef();
	}
	public String getruedaTrasera(){
		return ruedaTrasera.getRef();
	}
	public String getcuadro(){
		return cuadro.getRef();
	}
	public String getManillar(){
		return manillar.getRef();
	}
	
}
