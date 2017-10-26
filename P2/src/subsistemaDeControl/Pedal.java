package subsistemaDeControl;

public  class Pedal {
	private boolean estado;
	private boolean automatico;
	
	public Pedal() {
		this.estado = false;
		this.automatico = false;
	}

	public boolean getEstado() {
		return estado;
	}

	public String getEstadoToString(){
		String estado_pedal;
		if (estado == false){
			estado_pedal = "libre";
		}
		else {
			estado_pedal =  "presionado";
		}
		
		if(automatico == true){
			estado_pedal =  "FRENADO AUTOMATICO";
		}
		
		return estado_pedal;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setAutomatico(boolean auto){
		this.automatico = auto;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Pedal aux;
		
		if(obj instanceof Pedal){
			aux = (Pedal) obj;
		
			if(this.estado == aux.estado){
				if(this.automatico == aux.automatico){
					result = true;
				}
			}
		}
		
		return result;
	}
	
}
