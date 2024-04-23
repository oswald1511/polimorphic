package org.fiuba.algo3.view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import org.fiuba.algo3.model.Casilleros.Casillero;
import java.util.ArrayList;
import java.util.HashMap;

public class CasilleroView extends Pane {

    protected double anchoCasilla;
    protected double altoCasilla;
    protected Orientacion orientacion;
    protected Pane cajaInformacion;

    protected Casillero casillero;

    protected ArrayList<Node> jugadoresEnCasilla;

    protected HashMap<String, String> informacionCasillero;


    public CasilleroView(Double anchoCasilla, Double altoCasilla, Casillero casillero, HashMap<String, String> informacionCasillero, String direccionImagen, Orientacion orientacion){
        this.orientacion = orientacion;
        this.jugadoresEnCasilla = new ArrayList<>();
        this.anchoCasilla = anchoCasilla;
        this.informacionCasillero = informacionCasillero;
        this.casillero = casillero;
        this.altoCasilla = altoCasilla;
        this.cajaInformacion = this.orientacion.obtenerPaneAcorde();
        cajaInformacion.setLayoutX(obtenerProyeccion(comienzoSectorInformacionX(), comienzoSectorInformacionY()));
        cajaInformacion.setLayoutY(obtenerProyeccion(comienzoSectorInformacionY(), comienzoSectorInformacionX()));
        cajaInformacion.setPrefHeight(obtenerProyeccion(altoSectorInformacion(), anchoSectorInformacion()));
        cajaInformacion.setPrefWidth(obtenerProyeccion(anchoSectorInformacion(), altoSectorInformacion()));
        Rectangle informacionDeLaCasilla = new Rectangle(obtenerProyeccion(comienzoCasillaX(),comienzoCasillaY()),obtenerProyeccion(comienzoCasillaY(),comienzoCasillaX()), obtenerProyeccion(this.anchoCasilla, this.altoCasilla), obtenerProyeccion(this.altoCasilla, this.anchoCasilla));
        informacionDeLaCasilla.setStrokeWidth(3);
        informacionDeLaCasilla.setFill(Color.WHITE);
        informacionDeLaCasilla.setStroke(Color.BLACK);
        Label nombreEtiqueta = new Label(this.obtenerTextoCasilla());
        nombreEtiqueta.setMaxWidth(anchoMaximoNombre());
        nombreEtiqueta.setMaxHeight(altoMaximoNombre());
        nombreEtiqueta.setTextAlignment(TextAlignment.CENTER);
        nombreEtiqueta.setWrapText(true);
        nombreEtiqueta.setRotate(this.orientacion.obtenerGrados());
        Image imagen = new Image(direccionImagen);
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(anchoImagen());
        imageView.setFitHeight(altoImagen());
        imageView.setRotate(this.orientacion.obtenerGrados());
        cajaInformacion.getChildren().add(new Group(nombreEtiqueta));
        cajaInformacion.getChildren().add(new Group(imageView));
        this.getChildren().add(new Group(informacionDeLaCasilla));
        this.getChildren().add(new Group(cajaInformacion));
    }

    public CasilleroView(Double anchoCasilla, Double altoCasilla, Casillero casillero, HashMap<String, String> informacionCasillero, Orientacion orientacion){
        this(anchoCasilla, altoCasilla, casillero, informacionCasillero, rutaImagenPorDefecto(), orientacion);
    }

    protected String obtenerTextoCasilla(){
        return this.informacionCasillero.get("tipo");
    }

    protected static String rutaImagenPorDefecto(){
        return "file:src/main/java/org/fiuba/algo3/view/imagenes/personaje_monopoly.png";
    }

    protected Double obtenerProyeccion(Double portraitValor, Double landscapeValor){
        ArrayList<Double> valoresPosibles = new ArrayList<>();
        valoresPosibles.add(portraitValor);
        valoresPosibles.add(landscapeValor);
        return valoresPosibles.get(this.obtenerIndice());
    }

    protected int obtenerIndice(){
        Double indiceDouble = Math.abs(Math.sin(Math.toRadians(this.orientacion.obtenerGrados())));
        int indice = indiceDouble.intValue();
        return indice;
    }

    protected Double altoImagen() {
        return altoCasilla * 0.3;
    }

    protected Double comienzoCasillaX(){
        return 0.0;
    }

    protected Double comienzoCasillaY(){
        return 0.0;
    }

    protected Double comienzoSectorInformacionX(){
        return 0.0;
    }

    protected Double comienzoSectorInformacionY(){
        return altoMaximoNombre();
    }

    protected Double anchoSectorInformacion(){
        return anchoCasilla;
    }

    protected Double anchoImagen(){
        return anchoCasilla * 0.5;
    }

    protected Double altoMaximoNombre() {
        return altoCasilla * 0.2;
    }

    protected Double anchoMaximoNombre() {
        return anchoCasilla * 0.75;
    }

    protected Double altoSectorInformacion() {
        return altoCasilla * 0.8;
    }

    public void dibujar() {
        this.getChildren().removeAll(this.jugadoresEnCasilla);
        this.jugadoresEnCasilla.clear();
        ArrayList<String> coloresJugadores= this.casillero.obtenerColoresJugadores();
        for ( String colorJugador : coloresJugadores){
            Color color = Color.valueOf(colorJugador);
            this.dibujarJugador(color);
        }
    }

    private void dibujarJugador(Color color) {

        Circle jugador = new Circle(posicionXJugador(), posicionYJugador(), radioCirculoJugador(), color);
        this.getChildren().add(jugador);
        this.jugadoresEnCasilla.add(jugador);
    }

    private double posicionYJugador() {
        return this.getHeight() * 0.5 + diametroCirculoJugador() * this.jugadoresEnCasilla.size();
    }

    private double diametroCirculoJugador() {
        return radioCirculoJugador() * 2;
    }

    private double posicionXJugador() {
        return this.getWidth() * 0.5 + radioCirculoJugador();
    }

    private Double radioCirculoJugador(){
        return 10.0;
    }
}
