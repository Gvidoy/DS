package ControlVelocidad;
public final class Eje {
	public final double RADIO = 0.8;
	private int vueltas;
	private long vueltasTotales;
	private CalculadorVel calculadorVel;
	public final int MAXVUELTAS = 10000 ;
	public int velAnterior;
	public Eje() {
		calculadorVel = new CalculadorVel();
		vueltas = 0;
		vueltasTotales = 0;
	}
	synchronized public void incrementarVueltas(int aumento) {
		if(vueltas<=MAXVUELTAS || aumento<0){
			vueltas += aumento;
			if(vueltas < 0){
				vueltas = 0;
			}
		}
	}
	synchronized public void resetear() {
		vueltasTotales = 0;
	}

	synchronized public int leerRevoluciones() {
		return vueltas;
	}
	synchronized public long leerRevolucionesTotales() {
		return vueltasTotales;
	}
	synchronized public void calcularVelocidad(Almacenamiento almacena){
		velAnterior = calculadorVel.calcularVelocidad(vueltas, RADIO, almacena);
		vueltasTotales += vueltas/24;
	}
	
	//implementacion de getCalculadorVel para pruebas unitarias
	
	public CalculadorVel getCalculadorVel(){
		return this.calculadorVel;
	}
	
	public void setVelAnterior(int velAnterior){
		this.velAnterior = velAnterior;
	}
	
	//Redefinicion de equals
	
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
	
		
		if(obj instanceof Eje){
			Eje aux = (Eje) obj;
		
			if((this.vueltas == aux.vueltas)
				&& (this.vueltasTotales == aux.vueltasTotales)
				&& (this.calculadorVel.equals(aux.calculadorVel))
				&& (this.velAnterior == aux.velAnterior))
				result = true;
		}
		return result;
	}
}