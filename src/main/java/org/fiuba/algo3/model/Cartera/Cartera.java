package org.fiuba.algo3.model.Cartera;
import org.fiuba.algo3.model.Jugador.Transferible;

public interface Cartera extends Transferible{
    void transferir(Double monto, Transferible arrendador) throws CantidadInsuficiente;

}
