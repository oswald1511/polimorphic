package org.fiuba.algo3.view.Principal.Tablero.Casilleros;

import javafx.scene.Group;
import javafx.scene.control.Label;
import org.fiuba.algo3.model.Casilleros.Casillero;
import org.fiuba.algo3.model.Configuracion;
import org.fiuba.algo3.view.Principal.Tablero.Orientacion;

public class TransporteView extends CasilleroView{

    protected Label propietario;

    public TransporteView(Double anchoCasilla, Double altoCasilla, Casillero casillero, Orientacion orientacion, Configuracion configuracion) {
        super(anchoCasilla, altoCasilla, casillero, orientacion, configuracion);
        this.orientacion = orientacion;
        Label precio = new Label(this.informacionCasillero.get("precio"));
        this.setearFormatoEtiqueta(precio);
        this.propietario = new Label("Dueño: " +this.informacionCasillero.get("propietario"));
        this.propietario.setStyle("-fx-text-fill: blue;");
        this.setearFormatoEtiqueta(this.propietario);
        cajaInformacion.getChildren().addFirst(new Group(propietario));
        this.cajaInformacion.getChildren().add(new Group(precio));
    }

    @Override
    public void dibujar() {
        super.dibujar();
        this.casillero.aportarInformacionCasillero(this.informacionCasillero);
        this.dibujarEtiqueta();
    }

    protected Double tamanioFuente(){
        return this.altoCasilla * 0.06;
    }

    public void dibujarEtiqueta(){
        this.propietario.setText("Dueño: " +this.informacionCasillero.get("propietario"));
    }

    protected String claveTexto() {
        return "nombre";
    }

    protected double factorDeCrecimientoImagen() {
        return 0.4;
    }

}
