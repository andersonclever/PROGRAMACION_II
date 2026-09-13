public class AlgebraVectorial {
    private double x;
    private double y;

    public AlgebraVectorial() {
        this.x = 0;
        this.y = 0;
    }

    public AlgebraVectorial(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double longitud() {
        return Math.sqrt(x * x + y * y);
    }

    public AlgebraVectorial suma(AlgebraVectorial b) {
        return new AlgebraVectorial(x + b.x, y + b.y);
    }

    public AlgebraVectorial resta(AlgebraVectorial b) {
        return new AlgebraVectorial(x - b.x, y - b.y);
    }

    public double productoEscalar(AlgebraVectorial b) {
        return x * b.x + y * b.y;
    }

    public double productoVectorial(AlgebraVectorial b) {
        return x * b.y - y * b.x;
    }

    // a) |a + b| = |a - b|
    public boolean perpendicular(AlgebraVectorial b) {
        return Math.abs(
            this.suma(b).longitud() - this.resta(b).longitud()
        ) < 0.000001;
    }

    // b) |a - b| = |b - a|
    public boolean perpendicular(AlgebraVectorial b, String criterio) {
        return Math.abs(
            this.resta(b).longitud() - b.resta(this).longitud()
        ) < 0.000001;
    }

    // c) a · b = 0
    public boolean perpendicular(AlgebraVectorial b, int criterio) {
        return Math.abs(this.productoEscalar(b)) < 0.000001;
    }

    // d) |a + b|² = |a|² + |b|²
    public boolean perpendicular(AlgebraVectorial b, double criterio) {
        double izquierda = Math.pow(this.suma(b).longitud(), 2);

        double derecha = Math.pow(this.longitud(), 2)
                + Math.pow(b.longitud(), 2);

        return Math.abs(izquierda - derecha) < 0.000001;
    }

    // e) a = r b
    public boolean paralela(AlgebraVectorial b, double r) {
        return Math.abs(x - r * b.x) < 0.000001
                && Math.abs(y - r * b.y) < 0.000001;
    }

    // f) a × b = 0
    public boolean paralela(AlgebraVectorial b) {
        return Math.abs(this.productoVectorial(b)) < 0.000001;
    }

    // g) Proyección de a sobre b
    public AlgebraVectorial proyeccion(AlgebraVectorial b) {
        double producto = this.productoEscalar(b);
        double longitudCuadrado = Math.pow(b.longitud(), 2);

        if (longitudCuadrado == 0) {
            throw new ArithmeticException(
                "No se puede proyectar sobre el vector cero."
            );
        }

        double factor = producto / longitudCuadrado;

        return new AlgebraVectorial(factor * b.x, factor * b.y);
    }

    // h) Componente de a en la dirección de b
    public double componente(AlgebraVectorial b) {
        double longitudB = b.longitud();

        if (longitudB == 0) {
            throw new ArithmeticException(
                "No se puede calcular sobre el vector cero."
            );
        }

        return this.productoEscalar(b) / longitudB;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}