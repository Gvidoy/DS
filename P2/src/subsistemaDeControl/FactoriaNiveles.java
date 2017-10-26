package subsistemaDeControl;

public class FactoriaNiveles implements IMantenimiento{
	public Nivel crearNivel(ETiposNiveles tipo){
		if (tipo == ETiposNiveles.ACEITE){
			return new NivelAceite();
		}else if (tipo == ETiposNiveles.PASTILLAS){
			return new NivelPastillas();
		}else if (tipo == ETiposNiveles.GENERAL){
			return new NivelGeneral();
		} else if (tipo == ETiposNiveles.COMBUSTIBLE){
			return new NivelCombustible();
		}else{
			return null;
		}
	}
}
