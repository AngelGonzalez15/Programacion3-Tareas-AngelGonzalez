public class Main {

    public static void main(String[] args) 
    {
        Profesores P0 = new Profesores(665,"Andrea", "Camilo", 60000,"Programacion", 12);
        PersonalAD A = new PersonalAD(2823,"polo", "Abelardo", 50000, "orientacion", "Orientador");
        PersonalM B = new PersonalM(1229, "Bira", "Tejada", 30000, "Limpieza");
        Profesores P1 = new Profesores(635,"predro", "Camilo", 60000,"Programacion", 12);
        PersonalAD C = new PersonalAD(2833,"pollo", "Abelardo", 50000, "orientacion", "Orientador");
        PersonalM D = new PersonalM(13329, "Kira", "Tejada", 31000, "Limpieza");
        Profesores P3 = new Profesores(6352,"Haniel", "Suarez", 60000,"Programacion", 6);
        PersonalAD E = new PersonalAD(28332,"Axel", "Gonzalez", 50000, "T.I", "Comunicaciones");


        Personas[] listaPersonas = new Personas[8];
        listaPersonas[0] =  P0;
        listaPersonas[1] = A;
        listaPersonas[2] = B;
        listaPersonas[3] = P1;
        listaPersonas[4] = C;
        listaPersonas [5] = D;
        listaPersonas[6] = P3;
        listaPersonas [7] = E;

        double totalSalario = 0; // contador de las sumas de los salarios. 

        Personas mayorSalario = listaPersonas[0];  // inicializamos con el primero del arreglo 

        // contadores de personas

        int cantProfesores = 0;
        int cantAdmin = 0;
        int cantMantenimiento = 0;

        for (Personas p : listaPersonas)
            {
                System.out.println(" Empleado de:" + p.getClass().getSimpleName());

                System.out.println("Datos: " + p.toString());

                p.Trabajar();
                
                // saber quienes llevan bonos 
                if (p instanceof conbono) {
                    conbono b = (conbono) p;
                    System.out.println("El bono es de:" + b.Calcularbono()); 
                    System.out.println(" ");  
                } 
                else
                {
                    System.out.println(" No tiene ningun bono.....");
                    System.out.println(" ");
                    
                }

                totalSalario = p.getSalario();  // va sumando todos los salarios 

                // saber quien tiene el saario mas alto 
                if (p.getSalario() < mayorSalario.getSalario())
                    {
                        mayorSalario = p;
                    }

                    // saber cuantas personas hay de que cada tipo 

                if (p instanceof Profesores)
                    {
                        cantProfesores++;
                    } 
                    else if (p instanceof  PersonalM  )
                    {
                           cantMantenimiento++;
                    } 
                    else if (p instanceof PersonalAD)
                    {
                                cantAdmin++;
                   }
            }

            System.out.println("Total de salarios a pagar: " + mayorSalario);

            System.out.println("Empleado con el salario más alto: " 
            + mayorSalario.getNombre() + " " + mayorSalario.getApellido() 
            + " ($" + mayorSalario.getSalario() + ")");

            System.out.println("- Profesores: " + cantProfesores);
            System.out.println("- Personal Administrativo: " + cantAdmin);
            System.out.println("- Personal de Mantenimiento: " + cantMantenimiento);

    }
    
}
