package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class Loteria extends CasillaTransferidora{

    public Loteria(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibir(Jugador jugador) throws CantidadInsuficiente {
        super.recibir(jugador);
        banco.transferir(this.montoACobrar, jugador);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.LOTERIA;
    }

    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero ){
         super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("tipo", "Loteria");
    }
}
