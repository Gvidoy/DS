package Monitorizacion;
import ControlVelocidad.Eje;
public class CalculadorVelMed {
	private double _velMedia;
	private long sumatoria_vel;
	private double sumatoria_gas;
	private double _gastoMedio;
	private double _gastoValorAnterior;
	private int _tiempo_gas, tiempo_vel;
	protected CalculadorVelMed() {
		_velMedia = 0;
		sumatoria_vel = 0;
		sumatoria_gas = 0.0;
		_tiempo_gas = tiempo_vel = 1;
		_gastoValorAnterior = 100.0;
	}
	protected void calcularVelocidadMedia(Eje aEje_e) {

		if(aEje_e.velAnterior != 0){

			if(sumatoria_vel < 1000000000){
				sumatoria_vel += aEje_e.velAnterior;
				_velMedia = sumatoria_vel /tiempo_vel;
				tiempo_vel++;
			}
			else{
				resetearTiempo();
			}
		}
	}
	protected void resetearTiempo() {
		sumatoria_gas = sumatoria_vel = 0;
		_tiempo_gas = tiempo_vel = 1;
	}
	protected double leerVelMedia() {
		return _velMedia;
	}
	public void calcularGastoMedio(Eje aEje_e, Deposito depo) {

		if(aEje_e.velAnterior != 0){
			if(sumatoria_gas < 1000000000){
				if(_gastoValorAnterior - depo.leerNivelActual() > 0){
					sumatoria_gas += _gastoValorAnterior - depo.leerNivelActual();
				}
				_gastoValorAnterior = depo.leerNivelActual();
				_gastoMedio = (sumatoria_gas*100) /_tiempo_gas;
				_tiempo_gas++;
			}
			else{
				resetearTiempo();
			}
		}
	}
	public double leerGastoMedio() {
		return _gastoMedio;
	}
	
	//Reescrito test equals
	
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		
		if(obj instanceof CalculadorVelMed){
			CalculadorVelMed aux = (CalculadorVelMed) obj;
		
			if((this._velMedia == aux._velMedia)
				&& (this.sumatoria_vel == aux.sumatoria_vel)
				&& (this.sumatoria_gas == aux.sumatoria_gas)
				&& (this._gastoMedio == aux._gastoMedio)
				&& (this._gastoValorAnterior == aux._gastoValorAnterior)
				&& (this._tiempo_gas == aux._tiempo_gas)
				&& (this.tiempo_vel == aux.tiempo_vel))
						result = true;
		}
		return result;
	}
	
	//Getter pruebas unitarias
	
	public double get_velMedia() {
		return _velMedia;
	}
	public long getSumatoria_vel() {
		return sumatoria_vel;
	}
	public double getSumatoria_gas() {
		return sumatoria_gas;
	}
	public double get_gastoMedio() {
		return _gastoMedio;
	}
	public double get_gastoValorAnterior() {
		return _gastoValorAnterior;
	}
	public int get_tiempo_gas() {
		return _tiempo_gas;
	}
	public int getTiempo_vel() {
		return tiempo_vel;
	}
	public void setSumatoria_vel(long sumatoria_vel){
		this.sumatoria_vel = sumatoria_vel;
	}
	
	public void setSumatoria_gas(double sumatoria_gas){
		this.sumatoria_gas = sumatoria_gas;
	}
	

	
}