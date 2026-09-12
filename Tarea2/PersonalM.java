public class PersonalM extends  Personas {
 
    private String area;

    public PersonalM(int codigo, String nombre, String apellido, double salario, String area)
      {
        super(codigo, nombre, apellido, salario);
        this.area = area;

      }

      public String getArea() {
          return area;
      }

      public void setArea(String area) {
          this.area = area;
      }

      @Override
      public void Trabajar() {
        
        System.out.println(getNombre() + " " + getApellido() + " Pertenece al area de: " + getArea());
        
      }

      @Override 
      public String toString()
      {
        return super.toString() + "Area asignada: " + getArea();
      }
   
}
