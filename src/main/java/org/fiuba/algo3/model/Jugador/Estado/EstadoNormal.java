package org.fiuba.algo3.model.Jugador.Estado;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Casilleros.Propiedad;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.Map;

public class EstadoNormal implements Estado {
    private Jugador jugador;
    public EstadoNormal(Jugador jugador) {
        this.jugador = jugador;
    }
    @Override
    public void moverse(int tirada) {
    }

    @Override
    public void pagarFianza(double monto,Banco banco) throws CantidadInsuficiente {

    }

    @Override
    public void acordar(Jugador jugador, String propiedad, Map<String, Propiedad> propiedades) throws CantidadInsuficiente {
        jugador.transferir(propiedades.get(propiedad).tasar(), this.jugador);
    }
}
