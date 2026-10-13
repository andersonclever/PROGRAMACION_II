import java.util.Random;
import java.util.Scanner;



class Juego {
    protected int numeroDeVidas;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        numeroDeVidas = 3;
    }

    public void actualizaRecord() {
        if (record == 0 || numeroDeVidas > record) {
            record = numeroDeVidas;
        }
        System.out.println("Record: " + record);
    }

    public boolean quitaVida() {
        numeroDeVidas--;
        System.out.println("Vidas restantes: " + numeroDeVidas);
        return numeroDeVidas > 0;
    }
}




class JuegoAdivinaNumero extends Juego {
    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public void juega() {
        reiniciaPartida();

        Random random = new Random();
        Scanner teclado = new Scanner(System.in);

        numeroAAdivinar = random.nextInt(11);

        System.out.println("Adivina un numero entre 0 y 10.");

        while (numeroDeVidas > 0) {
            System.out.print("Introduce un numero: ");
            int numero = teclado.nextInt();

            if (numero == numeroAAdivinar) {
                System.out.println("Acertaste!!");
                actualizaRecord();
                return;
            }

            if (!quitaVida()) {
                System.out.println("Se acabaron las vidas.");
                System.out.println("El numero era: " + numeroAAdivinar);
                return;
            }

            if (numero < numeroAAdivinar) {
                System.out.println("El numero a adivinar es mayor.");
            } else {
                System.out.println("El numero a adivinar es menor.");
            }

            System.out.println("Intentalo de nuevo.");
        }
    }
}


public class Aplicacion1 {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
        juego.juega();
    }
}