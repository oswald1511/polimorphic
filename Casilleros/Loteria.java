package Casilleros;

public class Loteria extends CasillaTransferidora{

    public Loteria(Double montoACobrar) {
        super(montoACobrar);
    }

    @Override
    public void recibirJugador(Jugador jugador) {
        Banco banco = Banco.getBanco();
        banco.transferir(this.montoACobrar, jugador);
    }
}
