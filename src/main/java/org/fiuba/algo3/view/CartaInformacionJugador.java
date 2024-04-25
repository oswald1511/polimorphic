package org.fiuba.algo3.view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import org.fiuba.algo3.model.Juego;
import org.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayList;
import java.util.HashMap;


public class CartaInformacionJugador extends VBox {

    private Double ancho;
    private Double alto;

    public CartaInformacionJugador(Double ancho, Double alto, Jugador jugador){
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        this.setWidth(ancho);
        this.setHeight(alto);
        this.ancho = ancho;
        this.alto = alto;
        HashMap<String, String> informacionJugador = new HashMap<>();
        jugador.informarDetalles(informacionJugador);
        Rectangle cabecera = new Rectangle(ancho, alto*0.3);

        String nombre = "Nombre: " + informacionJugador.get("propietario");
        String dineroDisponible = "Dinero disponible: " + informacionJugador.get("dinero disponible");
        Color color = Color.valueOf(informacionJugador.get("color jugador"));
        cabecera.setFill(color);
        this.getChildren().add(new Group(cabecera));
        this.agegarEtiqueta(nombre);
        this.agegarEtiqueta(dineroDisponible);
        this.agegarEtiqueta("Propiedades:");
        ArrayList<String> propiedades = new ArrayList<>();
        jugador.cargarNombreDePropiedadesEnPosesion(propiedades);
        for( String propiedad: propiedades){
            this.agegarEtiqueta(propiedad);
        }

    }

    private void agegarEtiqueta(String textoEtiqueta ){
        Label etiqueta = new Label(textoEtiqueta);
        etiqueta.setMaxWidth(this.ancho);
        etiqueta.setMaxHeight(this.alto*0.3);
        etiqueta.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(etiqueta);
    }
}
