package com.gestion.estudiantes;

/**
 * Clase principal (Main) que sirve como punto de entrada de la aplicación.
 * Realiza la instanciación de objetos, asignación de atributos,
 * invocación de métodos y prueba de la lógica del sistema.
 * 
 * @author Estudiante de Ingeniería / Tecnologías de la Información
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   SISTEMA DE GESTIÓN DE ESTUDIANTES Y CALIFICACIONES (POO JAVA)  ");
        System.out.println("==================================================================\n");

        // ---------------------------------------------------------------------
        // 1. INSTANCIACIÓN DE OBJETOS USANDO CONSTRUCTORES PARÁMETRIZADOS Y DEFECTO
        // ---------------------------------------------------------------------
        System.out.println(">>> 1. Creando objetos e invocando constructores...");
        
        // Objeto 1: Instanciación con constructor parametrizado
        Estudiante est1 = new Estudiante("2026-001", "María Fernanda López", "Ingeniería en Sistemas", 4);
        
        // Objeto 2: Instanciación con constructor parametrizado
        Estudiante est2 = new Estudiante("2026-002", "Carlos Eduardo Ramírez", "Ingeniería Software", 4);
        
        // Objeto 3: Instanciación con constructor por defecto e invocación de setters
        Estudiante est3 = new Estudiante();
        est3.setMatricula("2026-003");
        est3.setNombreCompleto("Ana Sofía Martínez");
        est3.setCarrera("Ciencia de Datos");
        est3.setSemestre(2);

        // ---------------------------------------------------------------------
        // 2. USO DE MÉTODOS PARA REGISTRAR CALIFICACIONES (COMPORTAMIENTO)
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 2. Registrando calificaciones para cada estudiante...");

        // Calificaciones para Estudiante 1
        est1.agregarCalificacion(9.5);
        est1.agregarCalificacion(8.8);
        est1.agregarCalificacion(9.2);

        // Calificaciones para Estudiante 2
        est2.agregarCalificacion(6.5);
        est2.agregarCalificacion(5.8);
        est2.agregarCalificacion(6.2);

        // Calificaciones para Estudiante 3 (incluyendo prueba de validación)
        est3.agregarCalificacion(10.0);
        est3.agregarCalificacion(9.8);
        est3.agregarCalificacion(15.0); // Nota inválida para probar el filtro de seguridad

        // ---------------------------------------------------------------------
        // 3. IMPRESIÓN DE FICHAS TÉCNICAS INDIVIDUALES
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 3. Fichas técnicas individuales (invocación de métodos):");
        System.out.println(est1.obtenerFichaTecnica());
        System.out.println(est2.obtenerFichaTecnica());
        System.out.println(est3.obtenerFichaTecnica());

        // ---------------------------------------------------------------------
        // 4. CREACIÓN DEL CURSO Y ASOCIACIÓN DE OBJETOS
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 4. Creando Curso e inscribiendo estudiantes...");
        Curso cursoPOO = new Curso("INF-301", "Programación Orientada a Objetos", "Dr. Roberto Gómez");

        cursoPOO.inscribirEstudiante(est1);
        cursoPOO.inscribirEstudiante(est2);
        cursoPOO.inscribirEstudiante(est3);

        // ---------------------------------------------------------------------
        // 5. GENERACIÓN DEL REPORTE FINAL DEL CURSO
        // ---------------------------------------------------------------------
        System.out.println("\n>>> 5. Reporte consolidado del curso:");
        cursoPOO.imprimirReporteCurso();

        System.out.println("==================================================================");
        System.out.println("   EJECUCIÓN FINALIZADA CON ÉXITO - DEMOSTRACIÓN POO COMPLETA     ");
        System.out.println("==================================================================");
    }
}
