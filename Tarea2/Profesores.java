public class Profesores extends Personas implements conbono {
    
      private String asignatura;
      private int horas;

      public Profesores(int codigo, String nombre, String apellido, double salario, String asignatura, int horas)
      {
        
        super(codigo, nombre, apellido, salario);
        this.asignatura = asignatura;
        this.horas = horas;

      }

      public String getAsignatura() {
          return asignatura;
      }

      public int getHoras() {
          return horas;
      }

      public void setAsignatura(String asignatura) {
          this.asignatura = asignatura;
      }

      public void setHoras(int horas) {
          this.horas = horas;
      }

      @Override
      public void Trabajar() {
        System.out.println(getNombre() + " " + getApellido() + " imparte la materia de: " + getAsignatura() + " durante " + getHoras() + " horas.");
      }

      @Override
      public double Calcularbono() {
       
          return getSalario() * 0.15; 
      }

      @Override 
      public  String toString()
      {
        return super.toString() + "Asignatura: " + asignatura + "Horas: " + horas;
      }

}
