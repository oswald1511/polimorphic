package org.fiuba.algo3.model;

import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.Tablero;

import java.util.List;
import java.util.Random;

public class Juego {
    private List<Jugador> jugadores;
    private Tablero tablero;
    private Random dado;

    public Juego(List<Jugador> jugadores){
        this.jugadores = jugadores;
        this.tablero = new Tablero(this.jugadores.size());
    }

    public void moverJugador(int indiceJugador) throws Exception{
        Jugador jugador = this.getJugador(indiceJugador);
        this.tablero.mover(indiceJugador,jugarDado(),jugador);
    }

    public Integer jugarDado(){
        return this.dado.nextInt(1,7);
    }

    public Jugador getJugador(int inidiceJugador){
        return this.jugadores.get(inidiceJugador);
    }

    public boolean seAcabo(){
        //todo
        return false;
    }
}
