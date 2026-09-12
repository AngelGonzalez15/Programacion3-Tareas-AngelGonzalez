public class Persona {

    private String nombre;
    private int edad;
    private String correo;

    // contuructor

    public Persona(String nombre, int edad, String correo)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre( )
    {
        return nombre;
 
    }

    public int getEdad()
    {
        return edad;
    }

    public String getcorreo()
    {
        return correo;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    } 

    public void  MostrarImformacion()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Correo: " + correo);
    }
    
}
