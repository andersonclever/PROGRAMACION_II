// PROGRAMACION ORIENTA OBJETOS 

public class Cronometro {

    private long inicia;
    private long finaliza;



    public Cronometro() {
        inicia = System.currentTimeMillis();
    }

    public void reinicia() {
        inicia = System.currentTimeMillis();
    }

    public void detener() {
        finaliza = System.currentTimeMillis();
    }

    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }
}
