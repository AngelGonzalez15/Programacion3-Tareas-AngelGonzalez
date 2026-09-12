import java.util.Scanner;

public class Estudiante {

    private String nombre;
    private int[] nota;

    public Estudiante(String nombre, int[] nota)
    {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int[] getNota()
    {
        return nota;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public void setNota(int[] nota)
    {
        this.nota = nota;
    }

    public double calcularPromedio()
    {
       int suma = 0;

        for(int i = 0; i < this.nota.length; i++)
        {
            suma += this.nota[i];
        }

        // Se agrega (double) para que no pierda decimales
        double promedio = (double) suma / this.nota.length;

        return promedio;
           
    }

    public void obtenerCalificacion()
    {
        double promedio = calcularPromedio();

            if(promedio >= 60)
                {
                    System.out.println("Estas Aprobado");
                }
                 else 
                {
                         System.out.println("Haz Reprobado");
                }  
    }
}
