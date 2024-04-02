package Casilleros;

public class ControladorDeHipotecaActivo implements ControladorDeHipotecas {

    private String nombrePropiedad;
    private Arrendador arrendador;
    private Hipotecador hipotecador;
    private Deshipotecador deshipotecador;

    public ControladorDeHipotecaActivo(String nombrePropiedad, Arrendador arrendador) {
        this.nombrePropiedad = nombrePropiedad;
        this.arrendador = arrendador;
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
    }

    @Override
    public Arrendador hipotecar(Cartera cartera) {
        Arrendador arrendadorHipotecado = this.hipotecador.hipotecar(cartera);
        this.hipotecador = new HipotecadorNulo(arrendadorHipotecado);
        this.deshipotecador = new DeshipotecadorActivo(this.nombrePropiedad, this.arrendador);
        return arrendadorHipotecado;
    }

    @Override
    public Arrendador deshipotecar(Cartera cartera) throws CantidadInsuficiente{
        Arrendador arrendador = this.deshipotecador.deshipotecar(cartera);
        this.hipotecador = new HipotecadorActivo(this.nombrePropiedad, this.arrendador);
        this.deshipotecador = new DeshipotecadorNulo(new ArrendadorHipotecado(this.arrendador));
        return arrendador;
    }
}
