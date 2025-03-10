package org.fiuba.algo3.model.Jugador.Estado;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.CasillaComprable;
import org.fiuba.algo3.model.Casilleros.Propiedad;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.Map;

public interface Estado {
    public void moverse(int tirada) throws JugadorEncarcelado;
    public void pagarFianza(double monto,Banco banco) throws CantidadInsuficiente;
    public void acordar(Jugador jugador, String propiedad, Map<String, CasillaComprable> propiedades) throws CantidadInsuficiente;
    void construirEn(String nombrePropiedad) throws CantidadInsuficiente;
    void venderConstruccion(String nombrePropiedad);
}
