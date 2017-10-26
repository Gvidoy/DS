package subsistemaDeControl;

import java.util.ArrayList;

public class Mantenimientos {
	public ArrayList<Nivel> niveles;

	public Mantenimientos() {
		this.niveles = new ArrayList<Nivel>();
	}
	
	public Nivel getNivel(ETiposNiveles tipo){
		Nivel aux = null;
		
		for(Nivel t : niveles){
			
			if(t.getTipo() == tipo){
			
				aux = t;
			}
		}
		return aux;
	}
	
	public void addNivel(Nivel nuevoNivel){
		niveles.add(nuevoNivel);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Mantenimientos aux;
		
		if(obj instanceof Mantenimientos){
			aux = (Mantenimientos) obj; 
			if(this.niveles.equals(aux.niveles)){
				result =true;
			}
		}
		
		return result;
	}
	
}
