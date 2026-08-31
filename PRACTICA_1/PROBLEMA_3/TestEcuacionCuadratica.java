// PROGRAMA ORIENTADO A OBJETOS

import java.util.Scanner;

public class TestEcuacionCuadratica {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese a, b, c: ");

        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        double c = teclado.nextDouble();

        EcuacionesCuadratica ecuacion =
                new EcuacionesCuadratica(a, b, c);

        double discriminante = ecuacion.getDiscriminante();

        if (discriminante > 0) {

            System.out.println(
                "La ecuación tiene dos raíces "
                + ecuacion.getRaiz1()
                + " y "
                + ecuacion.getRaiz2()
            );

        } else if (discriminante == 0) {

            System.out.println(
                "La ecuación tiene una raíz "
                + ecuacion.getRaiz1()
            );

        } else {

            System.out.println(
                "La ecuación no tiene raíces reales"
            );
        }

        teclado.close();
    }
}