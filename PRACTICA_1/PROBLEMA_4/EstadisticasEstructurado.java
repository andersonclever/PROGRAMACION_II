// PROGRAMA MODULAR Y ESTRUCTURADO

import java.util.Scanner;

public class EstadisticasEstructurado {

    public static double promedio(double[] numeros) {
        double suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        return suma / numeros.length;
    }

    public static double desviacion(double[] numeros) {
        double media = promedio(numeros);
        double suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += Math.pow(numeros[i] - media, 2);
        }

        return Math.sqrt(suma / (numeros.length - 1));
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        double[] numeros = new double[10];

        System.out.print("Ingrese 10 números: ");

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = teclado.nextDouble();
        }

        System.out.println("El promedio es " + promedio(numeros));
        System.out.println("La desviación  es " + desviacion(numeros));

    }
}