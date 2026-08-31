// PROGRAMACION ORIENTA OBJETOS 

import java.util.Random;

public class TestCronometro {

    public static void main(String[] args) {

        int[] numeros = new int[100000];

        Random aleatorio = new Random();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = aleatorio.nextInt(100000);
        }

        Cronometro cronometro = new Cronometro();

        for (int i = 0; i < numeros.length - 1; i++) {

            int minimo = i;

            for (int j = i + 1; j < numeros.length; j++) {

                if (numeros[j] < numeros[minimo]) {
                    minimo = j;
                }
            }
            int temporal = numeros[i];
            numeros[i] = numeros[minimo];
            numeros[minimo] = temporal;
        }

        cronometro.detener();

        System.out.println("Tiempo de ordenación: " + cronometro.lapsoDeTiempo() 
        + " milisegundos"
        );
    }
}
