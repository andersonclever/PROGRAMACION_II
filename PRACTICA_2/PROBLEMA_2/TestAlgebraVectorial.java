public class TestAlgebraVectorial {
    public static void main(String[] args) {

        AlgebraVectorial a = new AlgebraVectorial(3, 4);
        AlgebraVectorial b = new AlgebraVectorial(4, -3);
        AlgebraVectorial c = new AlgebraVectorial(6, 8);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);
        System.out.println("Vector c = " + c);

        System.out.println("\nPERPENDICULARIDAD");

        // Criterio del enciso  a
        System.out.println(a.perpendicular(b));

        // Criterio del enciso b
        System.out.println(a.perpendicular(b, "resta"));

        // Criterio del enciso c
        System.out.println(a.perpendicular(b, 1));

        // Criterio del enciso d
        System.out.println(a.perpendicular(b, 1.0));

        System.out.println("\nPARALELISMO");

        System.out.println("Criterio e: " + a.paralela(c, 0.5));

        System.out.println("Criterio f: " + a.paralela(c));

        System.out.println("\nPROYECCION");

        System.out.println("Proyeccion de a sobre b = "
                + a.proyeccion(b));

        System.out.println("\nCOMPONENTE");

        System.out.println("Componente de a en b = "
                + a.componente(b));
    }
}