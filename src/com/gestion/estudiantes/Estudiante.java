package com.gestion.estudiantes;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un Estudiante dentro del sistema de gestión académica.
 * Aplica los principios de Programación Orientada a Objetos (POO):
 * - Encapsulamiento (atributos privados con métodos accesores get/set).
 * - Uso de Constructores (sobrecarga de constructores).
 * - Lógica de negocio encapsulada en métodos propios de la clase.
 * 
 * @author Estudiante de Ingeniería / Tecnologías de la Información
 * @version 1.0
 */
public class Estudiante {

    // =========================================================================
    // ATRIBUTOS (Estado del Objeto - Encapsulamiento con modificador private)
    // =========================================================================
    /** Identificador único del estudiante */
    private String matricula;

    /** Nombre completo del estudiante */
    private String nombreCompleto;

    /** Carrera o programa académico al que pertenece */
    private String carrera;

    /** Semestre actual que cursa el estudiante */
    private int semestre;

    /** Lista de calificaciones obtenidas por el estudiante */
    private List<Double> calificaciones;

    // =========================================================================
    // CONSTRUCTORES (Inicialización de Objetos)
    // =========================================================================

    /**
     * Constructor por defecto (sin parámetros).
     * Inicializa los atributos con valores neutros por defecto y la lista de calificaciones.
     */
    public Estudiante() {
        this.matricula = "SIN-MATRICULA";
        this.nombreCompleto = "Estudiante No Registrado";
        this.carrera = "General";
        this.semestre = 1;
        this.calificaciones = new ArrayList<>();
    }

    /**
     * Constructor parametrizado principal.
     * Permite instanciar un objeto Estudiante especificando sus datos iniciales.
     * 
     * @param matricula      Código único de matrícula.
     * @param nombreCompleto Nombre y apellidos del estudiante.
     * @param carrera        Nombre de la carrera universitaria.
     * @param semestre       Número de semestre actual.
     */
    public Estudiante(String matricula, String nombreCompleto, String carrera, int semestre) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        setSemestre(semestre); // Usa el setter para validar el semestre
        this.calificaciones = new ArrayList<>();
    }

    // =========================================================================
    // MÉTODOS DE LÓGICA DE NEGOCIO (Comportamiento del Objeto)
    // =========================================================================

    /**
     * Agrega una nueva calificación a la lista del estudiante tras validar que sea válida (0.0 a 10.0).
     * 
     * @param nota Calificación numéica a registrar.
     * @return true si la nota fue registrada con éxito, false si fue inválida.
     */
    public boolean agregarCalificacion(double nota) {
        if (nota >= 0.0 && nota <= 10.0) {
            this.calificaciones.add(nota);
            System.out.println("  [+] Nota " + nota + " agregada exitosamente a " + this.nombreCompleto);
            return true;
        } else {
            System.out.println("  [!] ERROR: La nota " + nota + " está fuera del rango permitido (0.0 - 10.0).");
            return false;
        }
    }

    /**
     * Calcula el promedio ponderado de las calificaciones registradas.
     * 
     * @return Promedio como double, o 0.0 si no tiene calificaciones.
     */
    public double calcularPromedio() {
        if (calificaciones == null || calificaciones.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        return suma / calificaciones.size();
    }

    /**
     * Evalúa la condición académica del estudiante basada en su promedio.
     * 
     * @return Cadena con la condición: "APROBADO", "EN RIESGO ACADÉMICO" o "REPROBADO".
     */
    public String evaluarEstadoAcademico() {
        double promedio = calcularPromedio();
        if (calificaciones.isEmpty()) {
            return "SIN CALIFICACIONES";
        } else if (promedio >= 7.0) {
            return "APROBADO (Regular)";
        } else if (promedio >= 6.0) {
            return "EN RIESGO ACADÉMICO";
        } else {
            return "REPROBADO";
        }
    }

    /**
     * Genera una ficha técnica resumida del estudiante en formato de texto.
     * 
     * @return Ficha técnica descriptiva del estudiante.
     */
    public String obtenerFichaTecnica() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========================================\n");
        sb.append("         FICHA DEL ESTUDIANTE           \n");
        sb.append("=========================================\n");
        sb.append("Matrícula    : ").append(matricula).append("\n");
        sb.append("Nombre       : ").append(nombreCompleto).append("\n");
        sb.append("Carrera      : ").append(carrera).append("\n");
        sb.append("Semestre     : ").append(semestre).append("° Semestre\n");
        sb.append("Notas        : ").append(calificaciones.toString()).append("\n");
        sb.append(String.format("Promedio     : %.2f\n", calcularPromedio()));
        sb.append("Estado       : ").append(evaluarEstadoAcademico()).append("\n");
        sb.append("=========================================");
        return sb.toString();
    }

    // =========================================================================
    // MÉTODOS GETTERS Y SETTERS (Encapsulamiento)
    // =========================================================================

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        if (semestre > 0 && semestre <= 14) {
            this.semestre = semestre;
        } else {
            System.out.println("  [!] Advertencia: Semestre " + semestre + " fuera de rango. Se asigna 1.");
            this.semestre = 1;
        }
    }

    public List<Double> getCalificaciones() {
        return new ArrayList<>(calificaciones); // Retorna copia para preservar encapsulamiento
    }
}
