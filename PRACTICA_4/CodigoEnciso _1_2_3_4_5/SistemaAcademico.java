
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// HERENCIA: Persona <- Estudiante, Docente

abstract class Persona {

    private final String nombre;
    private final String ci;

    protected Persona(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCi() {
        return ci;
    }

    public abstract String toString();
}

class Estudiante extends Persona {

    private final String codigo;
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    public Estudiante(String nombre, String ci, String codigo) {
        super(nombre, ci);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Inscripcion inscribirse(Materia materia) {

        Inscripcion inscripcion =
            new Inscripcion(this, materia, LocalDate.now());

        inscripciones.add(inscripcion);
        materia.registrarInscripcion(inscripcion);

        return inscripcion;
    }

    public List<Inscripcion> getInscripciones() {
        return Collections.unmodifiableList(inscripciones);
    }

    @Override
    public String toString() {
        return "Estudiante " + getNombre()
            + " (codigo " + codigo + ")";
    }
}

class Docente extends Persona {

    private final String especialidad;
    private final List<Materia> materias = new ArrayList<>();

    public Docente(String nombre, String ci, String especialidad) {
        super(nombre, ci);
        this.especialidad = especialidad;
    }

    public void dictar(Materia materia) {
        materias.add(materia);
        materia.setDocente(this);
    }

    // DEPENDENCIA: utiliza Acta temporalmente

    public Acta generarActa(Materia materia) {
        return new Acta(materia);
    }

    public List<Materia> getMaterias() {
        return Collections.unmodifiableList(materias);
    }

    @Override
    public String toString() {
        return "Docente " + getNombre()
            + " (" + especialidad + ")";
    }
}

// COMPOSICION: Universidad -> Carrera

class Universidad {

    private final String nombre;
    private final List<Carrera> carreras = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public Carrera crearCarrera(String nombreCarrera) {

        Carrera carrera = new Carrera(nombreCarrera);
        carreras.add(carrera);

        return carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Carrera> getCarreras() {
        return Collections.unmodifiableList(carreras);
    }
}

// AGREGACION: Carrera -> Docente

class Carrera {

    private final String nombre;
    private final List<Docente> docentes = new ArrayList<>();

    Carrera(String nombre) {
        this.nombre = nombre;
    }

    public void agregarDocente(Docente docente) {
        docentes.add(docente);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Docente> getDocentes() {
        return Collections.unmodifiableList(docentes);
    }
}

// COMPOSICION: Materia -> Horario

class Materia {

    private final String codigo;
    private final int creditos;
    private Docente docente;

    private final List<Horario> horarios = new ArrayList<>();
    private final List<Inscripcion> inscripciones = new ArrayList<>();

    public Materia(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public Horario agregarHorario(LocalDate fecha, String aula) {

        Horario horario = new Horario(fecha, aula);
        horarios.add(horario);

        return horario;
    }

    void registrarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public Docente getDocente() {
        return docente;
    }

    public List<Horario> getHorarios() {
        return Collections.unmodifiableList(horarios);
    }

    public List<Inscripcion> getInscripciones() {
        return Collections.unmodifiableList(inscripciones);
    }
}

class Horario {

    private final LocalDate fecha;
    private final String aula;

    Horario(LocalDate fecha, String aula) {
        this.fecha = fecha;
        this.aula = aula;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getAula() {
        return aula;
    }
}

// INTERFAZ CALIFICABLE

interface Calificable {

    double calcularNota();
}

// ASOCIACION: Estudiante - Inscripcion
// ASOCIACION: Materia - Inscripcion

class Inscripcion implements Calificable {

    private final Estudiante estudiante;
    private final Materia materia;
    private final LocalDate fecha;
    private double nota;

    Inscripcion(Estudiante estudiante, Materia materia, LocalDate fecha) {
        this.estudiante = estudiante;
        this.materia = materia;
        this.fecha = fecha;
    }

    public void registrarNota(double nota) {

        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException(
                "La nota debe estar entre 0 y 100"
            );
        }

        this.nota = nota;
    }

    @Override
    public double calcularNota() {
        return nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}

// DEPENDENCIA: Docente utiliza Acta

class Acta {

    private final LocalDate fecha = LocalDate.now();
    private final String contenido;

    Acta(Materia materia) {

        StringBuilder sb = new StringBuilder();

        sb.append("ACTA ")
          .append(materia.getCodigo())
          .append(" - ")
          .append(fecha)
          .append('\n');

        for (Inscripcion i : materia.getInscripciones()) {

            sb.append(i.getEstudiante().getNombre())
              .append(" : ")
              .append(i.calcularNota())
              .append('\n');
        }

        this.contenido = sb.toString();
    }

    @Override
    public String toString() {
        return contenido;
    }
}

// CLASE PRINCIPAL

public class SistemaAcademico {

    public static void main(String[] args) {

        // COMPOSICION: Universidad crea Carrera

        Universidad umsa = new Universidad("UMSA");

        Carrera informatica = umsa.crearCarrera("Informatica");

        // AGREGACION: Carrera agrega Docente

        Docente docente = new Docente(
            "Ana Alba",
            "1234567",
            "Ingenieria de Software"
        );

        informatica.agregarDocente(docente);

        // ASOCIACION: Docente dicta Materia

        Materia poo = new Materia("INF-121", 6);

        docente.dictar(poo);

        // COMPOSICION: Materia crea Horarios

        poo.agregarHorario(
            LocalDate.of(2026, 7, 2),
            "Aula 101"
        );

        poo.agregarHorario(
            LocalDate.of(2026, 7, 9),
            "Aula 101"
        );

        // ASOCIACION: Estudiante - Inscripcion

        Estudiante e1 = new Estudiante(
            "Carlos Flores",
            "7654321",
            "E-001"
        );

        Estudiante e2 = new Estudiante(
            "Maria Salas",
            "7654322",
            "E-002"
        );

        Inscripcion i1 = e1.inscribirse(poo);
        Inscripcion i2 = e2.inscribirse(poo);

        i1.registrarNota(85);
        i2.registrarNota(92);

        // HERENCIA + POLIMORFISMO

        List<Persona> personas = Arrays.asList(docente, e1, e2);

        personas.forEach(p -> System.out.println(p));

        // INTERFAZ CALIFICABLE

        Calificable c = i1;

        System.out.println(
            "Nota de " + e1.getNombre() + ": " + c.calcularNota()
        );

        // DEPENDENCIA: Docente utiliza Acta

        Acta acta = docente.generarActa(poo);

        System.out.println(acta);
    }
}


class Ayudante extends Estudiante {

    public Ayudante(
        String nombre,
        String ci,
        String codigo
    ) {
        super(nombre, ci, codigo);
    }
}

