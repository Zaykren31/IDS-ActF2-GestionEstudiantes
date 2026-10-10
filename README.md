# Sistema de Gestión de Estudiantes (Java POO)

## 📌 Descripción del Proyecto
Esta aplicación es un desarrollo simple en **Java** diseñado para demostrar los conceptos fundamentales de la **Programación Orientada a Objetos (POO)**:
- **Declaración de Clases y Definición de Atributos** con encapsulamiento (`private`).
- **Instanciación de Objetos** utilizando constructores por defecto y parametrizados.
- **Implementación de Métodos de Lógica de Negocio** y métodos accesores (`getters` y `setters`).
- **Relaciones entre Clases** (Asociación/Composición entre `Curso` y `Estudiante`).

---

## 🏗️ Estructura del Proyecto

```text
GestionEstudiantesPOO/
├── src/
│   └── com/
│       └── gestion/
│           └── estudiantes/
│               ├── Estudiante.java   # Clase de dominio (Estudiante)
│               ├── Curso.java        # Clase contenedora (Curso/Materia)
│               └── Main.java         # Clase principal con método main()
├── README.md                         # Documentación del repositorio
└── .gitignore                        # Filtro de archivos no rastreados
```

---

## 💻 Conceptos Clave de POO Aplicados

### 1. Clases y Atributos
- `Estudiante`: Representa un alumno con matrícula, nombre, carrera, semestre y una lista de calificaciones.
- `Curso`: Representa una asignatura universitaria que contiene una lista de objetos `Estudiante`.

### 2. Constructores
- **Constructor Parametrizado**: Permite inicializar objetos directamente con datos completos.
- **Constructor Por Defecto**: Inicializa atributos con valores de resguardo por seguridad.

### 3. Encapsulamiento y Métodos
- Todos los atributos están definidos como `private`.
- El acceso se realiza exclusivamente mediante métodos accesores `get` y `set`.
- Métodos de negocio como `calcularPromedio()`, `evaluarEstadoAcademico()` y `agregarCalificacion()` con validación de rango (0.0 a 10.0).

---

## 🚀 Cómo Compilar y Ejecutar

### Opción A: Desde Terminal (CLI)
1. Abrir la terminal en la raíz del proyecto.
2. Compilar las clases en una carpeta `bin`:
   ```bash
   javac -d bin src/com/gestion/estudiantes/*.java
   ```
3. Ejecutar la aplicación:
   ```bash
   java -cp bin com.gestion.estudiantes.Main
   ```

### Opción B: Desde un IDE (IntelliJ IDEA / Eclipse / NetBeans / VS Code)
1. Abrir el proyecto en el IDE de su preferencia.
2. Asegurarse de tener configurado el JDK (versión 8 o superior).
3. Ubicar la clase `Main.java` y hacer clic en **Run / Ejecutar**.

---

## 🛠️ Comandos Git Utilizados para el Repositorio

```bash
git init
git add .
git commit -m "feat: Implementación inicial del sistema de gestión de estudiantes en Java"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/IDS-ActF2-GestionEstudiantes.git
git push -u origin main
```

---
*Desarrollado para la Actividad Fundamental F2 de Ingeniería y Tecnologías de la Información.*
