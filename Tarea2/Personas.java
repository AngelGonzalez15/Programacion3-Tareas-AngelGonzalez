public abstract class Personas {
   
    private int codigo;
    private String nombre;
    private String apellido;
    private double salario;

    public Personas(int codigo, String nombre, String apellido, double salario )
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalario() {
        return salario;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract void Trabajar();

    @Override 
    public String toString()
    {
        return "Nombre y Apellido: " + nombre + " " + apellido  
                + "Codigo: " + codigo + " salario: " + salario;
    }

    
}
