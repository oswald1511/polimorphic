package src.main.java.org.fiuba.algo3.model.Casilleros;

//Probablemente no se necesite esta clase, ya que el casillero de loteria hace lo mismo.

import src.main.java.org.fiuba.algo3.model.Banco.Banco;
import src.main.java.org.fiuba.algo3.model.Cartera.CantidadInsuficiente;
import src.main.java.org.fiuba.algo3.model.Jugador.Jugador;

public class Inicio extends CasillaTransferidora {

    public Inicio(Double montoACobrar, Banco banco) {
        super(montoACobrar, banco);
    }

    @Override
    public void recibirJugador(Jugador jugador) throws CantidadInsuficiente {
        super.recibirJugador(jugador);
        this.banco.transferir(this.montoACobrar, jugador);
    }
}
