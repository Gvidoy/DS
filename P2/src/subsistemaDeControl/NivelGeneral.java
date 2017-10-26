package subsistemaDeControl;

public class NivelGeneral extends Nivel {	
	private final int MAX = 50000/400;//Km //(int) Math.pow(10,9);

	public NivelGeneral() {
		super(ETiposNiveles.GENERAL);
	}

	public int getMAX() {
		return MAX;
	}
	
}