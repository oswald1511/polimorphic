package org.fiuba.algo3.view;

import javafx.scene.layout.BorderPane;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;
import org.fiuba.algo3.model.Tablero.Tablero;

import java.util.List;

public class DisposicionPrincipal extends BorderPane {

    public DisposicionPrincipal(Configuracion configuracion, List<Jugador> jugadores) {
        TableroView tableroVista = new TableroView(configuracion);
        Tablero tablero = new Tablero(jugadores, configuracion);
        Juego juego = new Juego(jugadores, tablero, configuracion);
        OpcionesView opcionesView = new OpcionesView(juego, configuracion, tableroVista, jugadores);
        this.setCenter(tableroVista);
        this.setRight(opcionesView);
    }
}
