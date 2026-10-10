package com.gestion.estudiantes;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Curso o Asignatura Universitaria.
 * Gestiona un grupo de objetos de la clase Estudiante y calcula métricas grupales.
 * Demuestra la relación de composición/asociación entre clases en POO.
 * 
 * @author Estudiante de Ingeniería / Tecnologías de la Información
 * @version 1.0
 */
public class Curso {

    // =========================================================================
    // ATRIBUTOS PRIVADOS
    // =========================================================================
    /** Código de la asignatura */
    private String codigoCurso;

    /** Nombre del curso o materia */
    private String nombreMateria;

    /** Nombre del profesor titular */
    private String profesorTitular;

    /** Lista de objetos Estudiante inscritos */
    private List<Estudiante> estudiantesInscritos;

    // =========================================================================
    // CONSTRUCTORES
    // =========================================================================

    /**
     * Constructor parametrizado.
     * 
     * @param codigoCurso    Código de identificación del curso.
     * @param nombreMateria  Nombre descriptivo del curso.
     * @param profesorTitular Nombre del docente a cargo.
     */
    public Curso(String codigoCurso, String nombreMateria, String profesorTitular) {
        this.codigoCurso = codigoCurso;
        this.nombreMateria = nombreMateria;
        this.profesorTitular = profesorTitular;
        this.estudiantesInscritos = new ArrayList<>();
    }

    // =========================================================================
    // MÉTODOS DE GESTIÓN
    // =========================================================================

    /**
     * Inscribe a un estudiante en el curso.
     * 
     * @param estudiante Objeto de tipo Estudiante.
     */
    public void inscribirEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.estudiantesInscritos.add(estudiante);
            System.out.println("  [+] Estudiante " + estudiante.getNombreCompleto() + 
                               " inscrito exitosamente en " + this.nombreMateria);
        } else {
            System.out.println("  [!] ERROR: Intentando inscribir un objeto Estudiante nulo.");
        }
    }

    /**
     * Calcula el promedio general de todos los estudiantes inscritos en el curso.
     * 
     * @return Promedio general del grupo.
     */
    public double calcularPromedioGeneralCurso() {
        if (estudiantesInscritos.isEmpty()) {
            return 0.0;
        }
        double sumaPromedios = 0.0;
        for (Estudiante est : estudiantesInscritos) {
            sumaPromedios += est.calcularPromedio();
        }
        return sumaPromedios / estudiantesInscritos.size();
    }

    /**
     * Muestra en consola la lista detallada de estudiantes del curso con sus promedios.
     */
    public void imprimirReporteCurso() {
        System.out.println("\n========================================================");
        System.out.println("  REPORTE ACADÉMICO DEL CURSO: " + nombreMateria.toUpperCase());
        System.out.println("  Código: " + codigoCurso + " | Profesor: " + profesorTitular);
        System.out.println("========================================================");
        
        if (estudiantesInscritos.isEmpty()) {
            System.out.println("  No hay estudiantes inscritos en este curso.");
        } else {
            for (int i = 0; i < estudiantesInscritos.size(); i++) {
                Estudiante est = estudiantesInscritos.get(i);
                System.out.printf("  %d. [%s] %-25s | Promedio: %5.2f | Estado: %s\n",
                        (i + 1),
                        est.getMatricula(),
                        est.getNombreCompleto(),
                        est.calcularPromedio(),
                        est.evaluarEstadoAcademico());
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("  PROMEDIO GENERAL DEL GRUPO: %.2f\n", calcularPromedioGeneralCurso());
        System.out.println("========================================================\n");
    }

    // Getters y Setters
    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }

    public String getNombreMateria() { return nombreMateria; }
    public void setNombreMateria(String nombreMateria) { this.nombreMateria = nombreMateria; }

    public String getProfesorTitular() { return profesorTitular; }
    public void setProfesorTitular(String profesorTitular) { this.profesorTitular = profesorTitular; }

    public List<Estudiante> getEstudiantesInscritos() {
        return new ArrayList<>(estudiantesInscritos);
    }
}
