
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Gestor {

    private static final String Archivo = "estudiantes.dat";
    private static final String Copia = "copia_estudiantes.dat";

    private ArrayList<Estudiantes> estudiantes;

    public Gestor() {
        estudiantes = new ArrayList<>();
        cargarDatos();
    }

    // REGISTRAR ESTUDIANTE
    public boolean RegistraEstudiante(Estudiantes estudiante) {

        for (Estudiantes e : estudiantes) {

            if (e.getMatricula().equals(estudiante.getMatricula())) {
                return false;
            }
        }

        estudiantes.add(estudiante);
        guardarDatos();
        return true;
    }

    public void mostarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // ELIMINAR ESTUDIANTE
    public void eliminarEstudiante(String matricula) {

        estudiantes.removeIf(e -> e.getMatricula().equals(matricula));
        guardarDatos();
    }

    // CONSULTAR ESTUDIANTE
    public Estudiantes consultarEstudiante(String matricula) {

        for (Estudiantes e : estudiantes) {

            if (e.getMatricula().equals(matricula)) {
                return e;
            }
        }

        return null;
    }

    // MODIFICAR ESTUDIANTE
    public boolean modificarEstudiante(String matricula, String nombre,
            String carrera, double calificacion) {

        Estudiantes estudiante = consultarEstudiante(matricula);

        if (estudiante != null) {

            estudiante.setNombre(nombre);
            estudiante.setCarrera(carrera);
            estudiante.setCalificacion(calificacion);

            guardarDatos();
            return true;
        }

        return false;
    }

    // OBTENER TODOS LOS ESTUDIANTES
    public ArrayList<Estudiantes> getEstudiantes() {
        return estudiantes;
    }

    // CANTIDAD TOTAL DE ESTUDIANTES
    public int totalEstudiantes() {
        return estudiantes.size();
    }

    // CALCULAR PROMEDIO GENERAL
    public double promedioGeneral() {

        if (estudiantes.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for (Estudiantes e : estudiantes) {
            suma += e.getCalificacion();
        }

        return suma / estudiantes.size();
    }

    // CANTIDAD DE ESTUDIANTES APROBADOS
    public int totalAprobados() {

        int aprobados = 0;

        for (Estudiantes e : estudiantes) {

            if (e.getCalificacion() >= 70) {
                aprobados++;
            }
        }

        return aprobados;
    }

    // CANTIDAD DE ESTUDIANTES REPROBADOS
    public int totalReprobados() {

        int reprobados = 0;

        for (Estudiantes e : estudiantes) {

            if (e.getCalificacion() < 70) {
                reprobados++;
            }
        }

        return reprobados;
    }

    // GUARDAR DATOS AUTOMÁTICAMENTE
    public void guardarDatos() {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(Archivo))) {

            oos.writeObject(estudiantes);

        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // CARGAR DATOS
    public void cargarDatos() {

        File archivo = new File(Archivo);

        if (archivo.exists()) {

            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(archivo))) {

                estudiantes = (ArrayList<Estudiantes>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        }
    }

    // CREAR COPIA DE SEGURIDAD
    public boolean crearCopia() {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(Copia))) {

            oos.writeObject(estudiantes);
            return true;

        } catch (IOException e) {
            System.out.println("Error al crear la copia: " + e.getMessage());
            return false;
        }
    }

    // RESTAURAR COPIA DE SEGURIDAD
    public boolean restaurarCopia() {

        File archivo = new File(Copia);

        if (!archivo.exists()) {
            return false;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(archivo))) {

            estudiantes = (ArrayList<Estudiantes>) ois.readObject();

            guardarDatos();

            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al restaurar la copia: " + e.getMessage());
            return false;
        }
    }
}

