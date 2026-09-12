public class PersonalAD extends Personas implements conbono {
    
    private String departamento;
    private String cargo;


    public PersonalAD(int codigo, String nombre, String apellido, double salario, String departamento, String cargo)
      {
        super(codigo, nombre, apellido, salario);
        this.departamento = departamento;
        this.cargo = cargo;
      }

      public String getDepartamento() {
          return departamento;
      }

      public String getCargo() {
          return cargo;
      } 

      public void setDepartamento(String departamento) {
          this.departamento = departamento;
      }

      public void setCargo(String cargo) {
          this.cargo = cargo;
      }

      @Override
      public void Trabajar() {
        
          System.out.println(getNombre() + " " + getApellido() + " Pertenece al departamento de: " + getDepartamento());
      }

      @Override
      public double Calcularbono()
       {
         return getSalario() * 0.10;
      }

      @Override 
      public  String toString()
      {
        return super.toString() + "Departamento: " + getDepartamento() + "Cargo: " + getCargo();
      }

      
      
}
