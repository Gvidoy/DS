package subsistemaDeMonitorizacion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ObservableTest.class, ObservadorAceleracionTest.class, ObservadorDeEstadoMotorTest.class,
		ObservadorDeRevolucionesTest.class, ObservadorFrenoTest.class, ObservadorMantenimientoAceiteTest.class,
		ObservadorMantenimientoCombustibleTest.class, ObservadorMantenimientoGeneralTest.class,
		ObservadorMantenimientoPastillasTest.class, ObservadorPalancaTest.class, ObservadorRotacionesTotalesTest.class,
		ObservadorTiempoTotalTest.class, ObservadorVelocidadAutomaticaTest.class, ObservadorVelocidadMediaTest.class,
		ObservadorVelocidadTest.class })
public class TestSuiteSubsistemaDeMonitorizacion {

}
