package subsistemaDeControl;

public class NivelCombustible extends Nivel {
	private final int MAX = 833/100; // suponiendo gasto 6L/100km y tanque de 50L

	public NivelCombustible() {
		super(ETiposNiveles.COMBUSTIBLE);
	}

	public int getMAX() {
		return MAX;
	}
}
