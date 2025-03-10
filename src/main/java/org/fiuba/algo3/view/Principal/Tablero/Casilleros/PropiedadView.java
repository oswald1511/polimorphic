package org.fiuba.algo3.view.Principal.Tablero.Casilleros;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.view.Principal.Tablero.Orientacion;

import java.util.ArrayList;

public class PropiedadView extends TransporteView {

    private Rectangle sectorViviendas;

    private ArrayList<ImageView> viviendas;

    public PropiedadView(Double anchoCasilla, Double altoCasilla, Casillero casillero, Orientacion orientacion, Configuracion configuracion) {
        super(anchoCasilla, altoCasilla, casillero, orientacion, configuracion);
        this.sectorViviendas = new Rectangle(0,0, obtenerProyeccion(anchoSectorViviendas(), altoSectorViviendas()), obtenerProyeccion(altoSectorViviendas(), anchoSectorViviendas()));
        sectorViviendas.setStroke(Color.BLACK);
        Color color = Color.valueOf(this.informacionCasillero.get("color"));
        sectorViviendas.setFill(color);
        sectorViviendas.setStrokeWidth(3);
        this.getChildren().add(sectorViviendas);
        this.viviendas = new ArrayList<>();
    }

    @Override
    public void dibujar() {
        super.dibujar();
        Integer cantidadDeViviendasConstruidas = Integer.valueOf(informacionCasillero.get("cantidad de construcciones"));
        dibujarViviendas(cantidadDeViviendasConstruidas, "file:src/main/java/org/fiuba/algo3/view/imagenes/casa.png");
        if (cantidadDeViviendasConstruidas == 5) {
            dibujarViviendas(1, "file:src/main/java/org/fiuba/algo3/view/imagenes/casaRoja.png");
        }

    }

    private void dibujarViviendas(Integer cantidadDeViviendasADibujar, String direccionImagenVivienda) {

        this.getChildren().removeAll(this.viviendas);
        this.viviendas.clear();
        for(int i = 0; i < cantidadDeViviendasADibujar; i++) {
            ImageView imagen = new ImageView(direccionImagenVivienda);
            imagen.setX(obtenerProyeccion(this.anchoCasilla / 4, 0.0) * i);
            imagen.setY(obtenerProyeccion(0.0, this.anchoCasilla / 4) * i);
            imagen.setFitWidth(this.anchoCasilla / 4);
            imagen.setFitHeight(this.altoCasilla * 0.2);
            imagen.setRotate(this.orientacion.obtenerGrados());
            this.getChildren().add(imagen);
            this.viviendas.add(imagen);
        }
    }

    protected Double anchoSectorViviendas(){
        return anchoCasilla;
    }

    protected Double altoSectorViviendas(){
        return this.altoMaximoNombre();
    }

}