package src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas;

import src.main.java.org.fiuba.algo3.model.Banco.Banco;
import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Cartera.Cartera;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.Arrendador;
import src.main.java.org.fiuba.algo3.model.Casilleros.Arrendador.ArrendadorHipotecado;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador.Deshipotecador;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorActivo;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Deshipotecador.DeshipotecadorNulo;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador.Hipotecador;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorActivo;
import src.main.java.org.fiuba.algo3.model.Casilleros.ControladorDeHipotecas.Hipotecador.HipotecadorNulo;

public class ControladorDeHipotecaActivo implements ControladorDeHipotecas {

    private String nombrePropiedad;
    private Arrendador arrendador;
    private Hipotecador hipotecador;
    private Deshipotecador deshipotecador;
    private Banco banco;

    public ControladorDeHipotecaActivo(String nombrePropiedad, Arrendador arrendador, Banco banco) {
        this.nombrePropiedad = nombrePropiedad;
        this.arrendador = arrendador;
        this.banco = banco;
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente {
        Arrendador arrendador = this.deshipotecador.deshipotecar(cartera);
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
        return arrendador;
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        Arrendador arrendadorHipotecado = this.hipotecador.hipotecar(cartera);
        this.hipotecador = new HipotecadorNulo(arrendadorHipotecado);
        this.deshipotecador = new DeshipotecadorActivo(this.nombrePropiedad, this.arrendador, this.banco);
        return arrendadorHipotecado;
    }
}
