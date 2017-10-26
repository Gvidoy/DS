package Monitorizacion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalculadorVelMedTest.class, DepositoTest.class, MonitorizacionTest.class, NotificacionesTest.class,
		RelojMTest.class, ReseteoTest.class })
public class AllTestsMonitorizacion {

}
