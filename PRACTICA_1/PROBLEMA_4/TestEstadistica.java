// PROGRAMA ORIENTADO A OBJETOS

import java.util.Scanner;

public class TestEstadistica {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double[] numeros = new double[10];

        System.out.print("Ingrese 10 números: ");

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextDouble();
        }

        Estadisticas estadisticas = new Estadisticas(numeros);

        System.out.println(
            "El promedio es " + estadisticas.promedio()
        );

        System.out.println(
            "La desviación estandard es " + estadisticas.desviacion()
        );

        teclado.close();
    }
}

