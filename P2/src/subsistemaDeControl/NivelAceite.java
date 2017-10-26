package subsistemaDeControl;

public class NivelAceite extends Nivel {
	private final int MAX = 12500/400; //KM //5*((int) Math.pow(10,6));
	public NivelAceite() {
		super(ETiposNiveles.ACEITE);
	}

	public int getMAX() {
		return MAX;
	}
}
