package ControlVelocidad;
public class CalculadorVel {
	protected void almacenarVelocidad(int Int_velocidad, Almacenamiento almacena) {
		almacena.almacenarVelocidad(Int_velocidad);
	}
	protected int calcularVelocidad(int vueltas, double radio, Almacenamiento almacena) {
		int v = 0;
		v= (int) (vueltas*radio)/40;
		almacena.almacenarVelocidad(v);
		return v;
	}
	
	
	//Metodo equal sobrescrito
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof CalculadorVel){
				result = true;
		}
		return result;
	}
	
	
}