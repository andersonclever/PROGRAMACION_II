// PROGRAMA ORIENTADO A OBJETOS

public class Estadisticas {

    private double[] numeros;

    public Estadisticas(double[] numeros) {
        this.numeros = numeros;
    }

    public double promedio() {
        double suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        return suma / numeros.length;
    }

    public double desviacion() {
        double media = promedio();
        double suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += Math.pow(numeros[i] - media, 2);
        }

        return Math.sqrt(suma / (numeros.length - 1));
    }
}