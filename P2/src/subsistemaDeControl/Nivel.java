package subsistemaDeControl;

public abstract class Nivel {
	private ETiposNiveles tipo;
	private double rotacion;
	
	public Nivel(ETiposNiveles tipo) {
		this.rotacion = 0;
		this.tipo = tipo;
	}

	public ETiposNiveles getTipo() {
		return tipo;
	}

	public double getRotacion() {
		return rotacion;
	}
	
	public abstract int getMAX();
	
	public void setRotacion(double rotacion) {
		this.rotacion = rotacion;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Nivel aux;
		
		if(obj instanceof Nivel){
			aux = (Nivel) obj;
		
			if((this.tipo == aux.tipo)
				&& (this.rotacion == aux.rotacion)
					&& (this.getMAX() == aux.getMAX()))
						result = true;
		}
		return result;
	}
}
