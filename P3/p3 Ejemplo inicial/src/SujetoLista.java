import java.util.List;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SujetoLista extends Sujeto {

    public List<IObservador> coleccionObservadores() {

    return observadores;

   }

}