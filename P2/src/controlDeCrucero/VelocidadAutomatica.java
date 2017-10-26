package controlDeCrucero;



public class VelocidadAutomatica {
	private double velocidadMantener;
	private boolean estadoAcelerador;
	private boolean estadoFreno;
	
	public VelocidadAutomatica(){
		this.velocidadMantener = 0;
		this.estadoAcelerador = false;
		this.estadoFreno = false;
	}
	
	public double getVelocidadMantener(){
		return velocidadMantener;
	}
	
	public void setVelocidadMantener(double velocidadMantener){
		this.velocidadMantener = velocidadMantener;
	}
	
	public boolean getEstadoAceleradorAuto(){
		return estadoAcelerador;
	}
	
	public boolean getEstadoFrenoAuto(){
		return estadoFreno;
	}
	
	public void automatica(double velocidad){
		
		if(velocidad < (velocidadMantener - 2)){
			estadoAcelerador = true;
		}else{
			estadoAcelerador = false;
		}
		
		if(velocidad > (velocidadMantener)){
			estadoFreno = true;
		}else{
			estadoFreno = false;
		}
		
		
		
	
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		VelocidadAutomatica aux;

		if(obj instanceof VelocidadAutomatica){
			aux = (VelocidadAutomatica) obj;
		
			if(this.velocidadMantener == aux.velocidadMantener){
				if(this.estadoAcelerador == aux.estadoAcelerador){
					if(this.estadoFreno == aux.estadoFreno){
							result = true;
					}
				}
			}
		}
		
		return result;
	}
}
