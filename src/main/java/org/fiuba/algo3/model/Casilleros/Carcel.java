package org.fiuba.algo3.model.Casilleros;

import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.HashMap;

public class Carcel extends Casillero{

    private Integer diasCondena;

    public Carcel(Integer diasCondena){
        this.diasCondena = diasCondena;
    }

    public void encarcelar(Jugador jugador){
        jugador.encarcelar(this.diasCondena);
    }

    public void sacar(Jugador jugador){
        super.sacar(jugador);
    }

    public TipoCasillero obtenerTipoCasillero(){
        return TipoCasillero.CARCEL;
    }

    public void aportarInformacionCasillero(HashMap<String, String> infoCasillero ){
        super.aportarInformacionCasillero(infoCasillero);
        infoCasillero.put("tipo", "Carcel");
    }
}
