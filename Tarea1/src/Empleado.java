import java.util.Scanner;

public class Empleado extends Personaa {
      
    public String Puesto;
    public double Salario;

    public Empleado(String nombre, int edad, String puesto, double salario) 
    {
        super(nombre, edad);
        this.Puesto = puesto;
        this.Salario = salario;
    }

   public  String getPuesto()
   {
    return Puesto;
   }

   public double getSalario()
   {
    return Salario;
   }

   public void setPuesto(String puesto)
   {
    this.Puesto = puesto;
   }

   public void setSalario(double salario)
   {
    this.Salario = salario;
   }

   public void MostrarDatos()
   {
    System.out.println("Nombre; " + nombre);
    System.out.println("Edad: " + edad);
    System.out.println("Puesto: " + Puesto);
    System.out.println("Salario: " + Salario);
   }

   public void CalcularBono()
   {
    double bono = Salario * 0.10;
    System.out.println("Este es el Bono: " + bono);
   }

   

}