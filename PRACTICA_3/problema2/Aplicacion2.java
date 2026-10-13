import java.util.Random;
import java.util.Scanner;


class Juego {
    protected int numeroDeVidas;
    protected int vidasIniciales;
    protected int record;

    public Juego(int numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
        this.vidasIniciales = numeroDeVidas;
        this.record = 0;
    }

    public void reiniciaPartida() {
        numeroDeVidas = vidasIniciales;
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
    protected Scanner teclado = new Scanner(System.in);
    protected Random random = new Random();

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    protected void generaNumero() {
        numeroAAdivinar = random.nextInt(11);
    }

    public void juega() {
        reiniciaPartida();
        generaNumero();

        System.out.println("Adivina un numero entre 0 y 10.");

        while (numeroDeVidas > 0) {
            System.out.print("Introduce un numero: ");
            int numero = teclado.nextInt();

            if (!validaNumero(numero)) {
                System.out.println("Error: introduce un numero entre 0 y 10.");
                continue;
            }

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
        }
    }
}




class JuegoAdivinaPar extends JuegoAdivinaNumero {

    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            System.out.println("Error: el numero debe estar entre 0 y 10.");
            return false;
        }

        if (numero % 2 != 0) {
            System.out.println("Error: debes introducir un numero par.");
            return false;
        }

        return true;
    }

    @Override
    protected void generaNumero() {
        numeroAAdivinar = random.nextInt(6) * 2;
    }
}



class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (numero < 0 || numero > 10) {
            System.out.println("Error: el numero debe estar entre 0 y 10.");
            return false;
        }

        if (numero % 2 == 0) {
            System.out.println("Error: debes introducir un numero impar.");
            return false;
        }

        return true;
    }

    @Override
    protected void generaNumero() {
        numeroAAdivinar = random.nextInt(5) * 2 + 1;
    }
}





public class Aplicacion2 {
    public static void main(String[] args) {
        JuegoAdivinaNumero juego1 = new JuegoAdivinaNumero(3);
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(3);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);

        System.out.println("JUEGO DE ADIVINAR NUMEROS");
        juego1.juega();

        System.out.println("\nJUEGO DE ADIVINAR NUMEROS PARES");
        juego2.juega();

        System.out.println("\nJUEGO DE ADIVINAR NUMEROS IMPARES");
        juego3.juega();
    }
}