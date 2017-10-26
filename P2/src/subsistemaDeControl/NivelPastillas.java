package subsistemaDeControl;

public class NivelPastillas extends Nivel {
	private final int MAX = 40000/400;//Km//(int) Math.pow(10,8);

	public NivelPastillas() {
		super(ETiposNiveles.PASTILLAS);
	}

	public int getMAX() {
		return MAX;
	}
}