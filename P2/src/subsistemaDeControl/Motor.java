package subsistemaDeControl;

public class Motor {
	private boolean estado;
	private double revolucionActual;
	private double rotacionTotalMotor;
	private double rotacionUltimoEncendido;
	
	public Motor(){
		this.estado = false;
		this.revolucionActual = 0;
		this.rotacionTotalMotor = 0;
		this.rotacionUltimoEncendido = 0;
	}

	public boolean getEstado() {
		return estado;
	}
	
	public double getRevolucionActual() {
		return revolucionActual;
	}
	
	public double getRotacionTotalMotor() {
		return rotacionTotalMotor;
	}
	
	
	public String getEstadoToString(){
		String estado_motor;
		if (estado == false){
			estado_motor = "apagado";
		}
		else {
			estado_motor =  "encendido";
		}
		return estado_motor;
	}

	public double getRotacionUltimoEncendido() {
		return rotacionUltimoEncendido;
	}
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setRevolucionActual(double revolucionActual) {
		this.revolucionActual = revolucionActual;
	}

	public void setRotacionTotalMotor(double rotacionTotalMotor) {
		this.rotacionTotalMotor = rotacionTotalMotor;
	}

	public void setRotacionUltimoEncendido(double rotacionUltimoEncendido) {
		this.rotacionUltimoEncendido = rotacionUltimoEncendido;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Motor aux;
		
		if(obj instanceof Motor){
			aux = (Motor) obj;
		
			if(this.estado == aux.estado){
				if(this.revolucionActual == aux.revolucionActual){
					if(this.rotacionTotalMotor == aux.rotacionTotalMotor){
						if(this.rotacionUltimoEncendido == aux.rotacionUltimoEncendido){
							result = true;
						}
					}
				}
				
			}
		}
		
		return result;
	}
}
