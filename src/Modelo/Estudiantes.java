package Modelo;

import java.io.Serializable;

public class Estudiantes implements Serializable {
    private String matricula;
    private String nombre;
    private String carrera;
    private double calificacion;
    
    public Estudiantes(String matricula, String nombre, String carrera, double calificacion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.calificacion = calificacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getCalificacion() {
        return calificacion;
    } 

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

}
