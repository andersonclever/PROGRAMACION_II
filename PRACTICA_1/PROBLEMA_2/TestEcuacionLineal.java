// PROGRAMACION ORIENTA OBJETOS 

import java.util.Scanner;

public class TestEcuacionLineal {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese a, b, c, d, e, f: ");

        double a = teclado.nextDouble();
        double b = teclado.nextDouble();
        double c = teclado.nextDouble();
        double d = teclado.nextDouble();
        double e = teclado.nextDouble();
        double f = teclado.nextDouble();

        EcuacionLineal ecuacion =  new EcuacionLineal(a, b, c, d, e, f);

        if (ecuacion.tieneSolucion()) {

            System.out.println(
                "x = " + ecuacion.getX() +
                ", y = " + ecuacion.getY()
            );

        } else {

            System.out.println("La ecuación no tiene solución");
        }
    }
}
