package ControlVelocidad;
public class ControlVelocidad {
	public Acelerador acelera;
	public Almacenamiento almacena;
	public Eje eje;
	public Freno freno;
	public Motor motor;
	public Palanca estadoPalanca;
	private Reloj reloj;
	private Automatico automatico;
	public ControlVelocidad() {
		acelera = new Acelerador();
		almacena = new Almacenamiento();
		automatico = new Automatico();
		eje = new Eje();
		freno = new Freno();
		motor = new Motor();
		estadoPalanca = new Palanca();
		reloj = new Reloj(this);
	}
	public void start(){
		reloj.start();
	}
	public void controlarEstado() {
		int incremento=0, decremento=0;

		if(motor.leerEstado()){
			if(estadoPalanca.leerEstado() == Palanca.APAGADO){
				if(acelera.leerEstado()){
					incremento = (int) acelera.actualizarAcelerador(eje.velAnterior);
					acelera.incrementar(incremento, eje);
					calcularVelcidad();

				}
				if(freno.leerEstado()){
					decremento = (int) freno.actualizarFreno();
					freno.decremento(decremento, eje);
					calcularVelcidad();

				}
				if(!acelera.leerEstado() && !freno.leerEstado()){
					freno.decremento(Freno.ROZAMIENTO, eje);
					calcularVelcidad();

				}
			}
			if(estadoPalanca.leerEstado() == Palanca.MANTENIENDO){
				almacena.almacenarVelSeleccionada();
				automatico.mantenerVelocidad(acelera, freno,almacena, eje);
				calcularVelcidad();

			}
			if(estadoPalanca.leerEstado() == Palanca.REINICIANDO){
				automatico.mantenerVelocidad(acelera, freno, almacena, eje);
				calcularVelcidad();		

			}
		}
		else{
			if(freno.leerEstado()){
				decremento = (int) freno.actualizarFreno();
				freno.decremento(decremento, eje);
				calcularVelcidad();

			}
			freno.decremento(Freno.ROZAMIENTO, eje);
			calcularVelcidad();

		}
	}
	public void cambiarPalanca(int aInt_estado) {
		estadoPalanca.cambiarEstado(aInt_estado);
	}
	public int obtenerVel(){
		return almacena.leerVelocidad();		
	}
	public double obtenerDist(){
		return almacena.leerDistancia();
	}
	public int obtenerRev(){
		return eje.leerRevoluciones();	
	}
	public long obtenerRevtotal(){
		return eje.leerRevolucionesTotales();	
	}
	
	protected void calcularVelcidad(){
		eje.calcularVelocidad(almacena);
	}
	public int leerVelSeleccionada() {
		return almacena.leerVelSeleccionada();
	}
	//Metodo equals reescrito
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		
		if(obj instanceof ControlVelocidad){
			ControlVelocidad aux = (ControlVelocidad) obj;
		
			if((this.acelera.equals(aux.acelera))
				&& (this.eje.equals(aux.eje))
				&& (this.almacena.equals(aux.almacena))
				&& (this.freno.equals(aux.freno))
				&& (this.motor.equals(aux.motor))
				&& (this.estadoPalanca.equals(aux.estadoPalanca))
				&& (this.reloj.equals(aux.reloj))
				&& (this.automatico.equals(aux.automatico)))
						result = true;
		}
		return result;
	}
	
	//Getter para pruebas unitarias
	public Reloj getReloj(){
		return this.reloj;
	}
	public Acelerador getAcelera() {
		return acelera;
	}
	public Almacenamiento getAlmacena() {
		return almacena;
	}
	public Eje getEje() {
		return eje;
	}
	public Freno getFreno() {
		return freno;
	}
	public Motor getMotor() {
		return motor;
	}
	public Palanca getEstadoPalanca() {
		return estadoPalanca;
	}
	public Automatico getAutomatico() {
		return automatico;
	}
	
	
	
}