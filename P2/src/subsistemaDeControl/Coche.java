package subsistemaDeControl;

public class Coche {
	private Motor motor;
	private Pedal freno;
	private Pedal acelerador;
	private Palanca palanca;
	private Mantenimientos niveles;
	private double aceleracion;
	private double velocidad;
	private double velocidadAutomatica;
	private long timeStart, timeEnd, timeTotal, timeParcial,timeStartUltimo;
	
	
	
	private static Coche coche;
	
	private Coche(){
		this.timeStart = 0;
		this.timeEnd = 0;
		this.timeTotal = 0;
		this.timeParcial = 0;
		
		this.velocidadAutomatica = 0;
		this.aceleracion = 0;
		this.velocidad = 0;
		
		this.motor = new Motor(); 
		this.freno = new Pedal();
		this.acelerador = new Pedal();
		this.palanca = new Palanca();
		
		IMantenimiento creadorMantenimientos = new FactoriaNiveles();

		Nivel aceite = creadorMantenimientos.crearNivel(ETiposNiveles.ACEITE);
		Nivel pastillas = creadorMantenimientos.crearNivel(ETiposNiveles.PASTILLAS);
		Nivel general = creadorMantenimientos.crearNivel(ETiposNiveles.GENERAL);
		Nivel combustible = creadorMantenimientos.crearNivel(ETiposNiveles.COMBUSTIBLE);
		
		this.niveles = new Mantenimientos();
		niveles.addNivel(aceite);
		niveles.addNivel(pastillas);
		niveles.addNivel(general);
		niveles.addNivel(combustible);
	}

	public static Coche getCoche(){
		if(coche == null){
			coche = new Coche();
		}
		return coche;
	}
	
	public double getVelocidad(){
		return velocidad;
	}
	
	public double getVelocidadAutomatica(){
		return velocidadAutomatica;
	}
	
	public double getAceleracion(){
		return aceleracion;
	}
	
	public Motor getMotor() {
		return motor;
	}

	public Pedal getFreno() {
		return freno;
	}

	public Pedal getAcelerador() {
		return acelerador;
	}
	
	public Palanca getPalanca() {
		return palanca;
	}
	
	public double getVelocidadMedia(){
		return motor.getRotacionUltimoEncendido()*1000/(calcularTiempoUltimoEncendido()) * 3.6;
	}

	public double getRevoluciones(){
		return velocidad / (0.33*0.00377*32);
	}
	
	public Nivel getNivel(ETiposNiveles tipo) {
		return niveles.getNivel(tipo);
	}
	public void setVelocidadAutomatica(){	
		this.velocidadAutomatica = velocidad;
	}
	
	public void setAceleracion(double a){
		this.aceleracion = a;
	}
		
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	public long calcularTiempo(){
		
		long aux = 0;
		
		if(motor.getEstado() == true){
			timeParcial = System.currentTimeMillis();
			aux = timeTotal + (timeParcial - timeStart);
		}
		
		return ((aux/1000)+1);
	}
	
	public long calcularTiempoUltimoEncendido(){
		long aux = 0;
		
		if(motor.getEstado() == true){
			timeParcial = System.currentTimeMillis();
			aux = (timeParcial - timeStartUltimo);
		}
		
		return ((aux/1000)+1);
	}

	public void calcularDistancia(){
	     motor.setRotacionTotalMotor(motor.getRotacionTotalMotor()+(this.velocidad*1000/3600)/100000);
	     motor.setRotacionUltimoEncendido(motor.getRotacionUltimoEncendido()+(this.velocidad*1000/3600)/100000);	
	}
	
	public void apagarMotor(){
		motor.setEstado(false);
		velocidadAutomatica = 0;
		timeEnd = System.currentTimeMillis();
		timeTotal += (timeEnd - timeStart);
		motor.setRotacionUltimoEncendido(0);
	}
	
	public void encenderMotor(){
		motor.setEstado(true);
		timeStart = System.currentTimeMillis();
		timeStartUltimo = System.currentTimeMillis();
	}

	public void acelerar(){
		if(motor.getEstado() == true && acelerador.getEstado() == true && freno.getEstado() == false && (this.motor.getRotacionTotalMotor() - this.getNivel(ETiposNiveles.COMBUSTIBLE).getRotacion()) < this.getNivel(ETiposNiveles.COMBUSTIBLE).getMAX()){		
			aceleracion = 10; // POTENCIA DE ACELERACION
		}
	}
	
	public void desacelerar(){
		aceleracion = 0;
		freno.setAutomatico(false);

	}
	
	public void frenoAutomatico(){
		aceleracion = -6; // POTENCIA DE FRENADO
		freno.setAutomatico(true);
	}
	
	public void frenar(){
		if((palanca.getEstado() == EEstadoPalanca.AUTOMATICO || palanca.getEstado() == EEstadoPalanca.REINICIAR) ){
			palanca.setEstado(EEstadoPalanca.APAGADO);
		}
		aceleracion = -6; // POTENCIA DE FRENADO
	}
	
	public void rellenarNivel(ETiposNiveles nivel){
		niveles.getNivel(nivel).setRotacion(motor.getRotacionTotalMotor());
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Coche aux;
		
		if(obj instanceof Coche){
			aux = (Coche) obj;
		
			if((this.motor.equals(aux.motor))
				&& (this.freno.equals(aux.freno))
				&& (this.acelerador.equals(aux.acelerador))
				&& (this.palanca.equals(aux.palanca))
				&& (this.niveles.equals(aux.niveles))
				&& (this.aceleracion == aux.aceleracion)
				&& (this.velocidad == aux.velocidad)
				&& (this.velocidadAutomatica == aux.velocidadAutomatica)
				&& (this.timeStart == aux.timeStart)
				&& (this.timeEnd == aux.timeEnd)
				&& (this.timeTotal == aux.timeTotal)
				&& (this.timeParcial == aux.timeParcial)
				&& (this.timeStartUltimo == aux.timeStartUltimo))
						result = true;
		}
		return result;
	}


}
