package subsistemaDeControl;

public class Palanca {
	private EEstadoPalanca estado; 
	
	public Palanca(){
		this.estado = EEstadoPalanca.APAGADO;
	}

	public EEstadoPalanca getEstado() {
		return estado;
	}

	public void setEstado(EEstadoPalanca estado) {
		this.estado = estado;
	}	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Palanca aux;
		
		if(obj instanceof Palanca){
			aux = (Palanca) obj;
			if(this.estado == aux.estado){
				result = true;
			}
		}
		
		return result;
	}
}
