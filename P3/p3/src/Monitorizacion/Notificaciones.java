package Monitorizacion;
import ControlVelocidad.Eje;
public class Notificaciones {
	private long _ateriorRevolAceite;
	private long _ateriorRevolPastillas;
	private long _anteriorRevolRevision;
	protected long _revolAceite;
	protected long _revolPastillas;
	protected long _revolRevision;
	private long _inicialAceite;
	private long _inicialPastillas;
	private long _inicialRevision;
	private long _revActuales;
	public final static String NOTIFACEITE = "Aceite";
	public final static String NOTIFPASTILLAS = "Pastillas";
	public final static String NOTIFREV = "Rev General";
	protected Notificaciones() {
		_inicialAceite = 500000; 
		_inicialPastillas = 1000000; 
		_inicialRevision = 10000000; 
		_revolAceite =  _ateriorRevolAceite = 0;
		_revolPastillas = _ateriorRevolPastillas = 0;
		_revolRevision = _anteriorRevolRevision = 0;
	}
	protected void actualizarNotificaciones(Eje eje){
		_revActuales = eje.leerRevolucionesTotales();
		_revolAceite = _revActuales - _ateriorRevolAceite;
		_revolPastillas = _revActuales - _ateriorRevolPastillas;
		_revolRevision = _revActuales - _anteriorRevolRevision;
	}
	protected long leerRevolAceite() {
		return _revolAceite;
	}
	protected long leerRevolPastillas() {
		return _revolPastillas;
	}
	protected long leerRevolRevision() {
		return _revolRevision;
	}
	protected void iniciarAceite() {
		_ateriorRevolAceite = _revActuales;
	}
	protected void iniciarPastillas() {
		_ateriorRevolPastillas = _revActuales;
	}
	protected void iniciarRevision() {
		_anteriorRevolRevision = _revActuales;
	}
	protected boolean notificarAceite() {
		boolean notifica;
		if(_revolAceite >= _inicialAceite){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	protected boolean notificarPastillas() {
		boolean notifica;
		if(_revolPastillas >= _inicialPastillas){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	protected boolean notificarRevision() {
		boolean notifica;
		if(_revolRevision >= _inicialRevision){
			notifica = true;
		}
		else{
			notifica = false;
		}
		return notifica;
	}
	protected String leerNotifAceite() {
		return NOTIFACEITE;
	}
	protected String leerNotifPastillas() {
		return NOTIFPASTILLAS;
	}
	protected String leerNotifRevision() {
		return NOTIFREV;
	}
	
	//Reescribir el metodo equals
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		
		if(obj instanceof Notificaciones){
			Notificaciones aux = (Notificaciones) obj;
		
			if((this._ateriorRevolAceite == aux._ateriorRevolAceite)
				&& (this._ateriorRevolPastillas == aux._ateriorRevolPastillas)
				&& (this._anteriorRevolRevision == aux._anteriorRevolRevision)
				&& (this._revolAceite == aux._revolAceite)
				&& (this._revolPastillas == aux._revolPastillas)
				&& (this._revolRevision == aux._revolRevision)
				&& (this._inicialAceite == aux._inicialAceite)
				&& (this._inicialPastillas == aux._inicialPastillas)
				&& (this._inicialRevision == aux._inicialRevision)
				&& (this._revActuales == aux._revActuales))
						result = true;
		}
		return result;
	}
	
	//Getters para Junit
	
	public long get_ateriorRevolAceite() {
		return _ateriorRevolAceite;
	}
	public long get_ateriorRevolPastillas() {
		return _ateriorRevolPastillas;
	}
	public long get_anteriorRevolRevision() {
		return _anteriorRevolRevision;
	}
	
	public long get_inicialAceite() {
		return _inicialAceite;
	}
	public long get_inicialPastillas() {
		return _inicialPastillas;
	}
	public long get_inicialRevision() {
		return _inicialRevision;
	}
	public long get_revActuales() {
		return _revActuales;
	}

	

	
	
}