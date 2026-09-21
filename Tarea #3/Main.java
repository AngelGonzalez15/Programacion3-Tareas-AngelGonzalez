import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) 
    { 
       
     String[] productos = {
            "Laptop", "Mouse", "Teclado", "Monitor", "Audífonos"
        };

        double[] precios = {
            45000.0, 850.0, 1200.0, 12000.0, 2500.0
        };

        int[] cantidades = {10, 50, 30, 8, 25};

            Scanner sc = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("5. Ejercicio 5");
            System.out.println("6. Ejercicio 6");
            System.out.println("0. Salir");
            System.out.println("==========================");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    Inventario(productos, precios, cantidades);
                    break;

                case 2:
                    MatrizCalificaciones();
                    break;

                case 3:
                    
                    break;

                case 4:
                    probarBusqueda(productos, precios, cantidades);
                    break;

                case 5:
                    ejercicio5();
                    break;

                case 6:
                    ejercicio6();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
    }

    public static void Inventario(String[] productos,  double[] precios ,int[] cantidades)
    {

        double totalGeneral = 0;

        System.out.println("Productos\t Precios\t Cantidades\t Valor Total");

        for(int i = 0; i < productos.length; i++ )
            {
                // calcular el valor total.
                double valorTotal = precios[i] * cantidades[i];
                valorTotal += totalGeneral;
                 

                System.out.println(String.format("%-15s %,12.2f %10d", productos[i],precios[i],cantidades[i]));

            }
             // mostrar el total general 
            System.out.println(String.format("Total General %,.2f",totalGeneral));

             // aqui se muestra el producto mas caro y el mas barato.
            int indiceC = 0;
            int indiceB = 0;

            for(int i = 0; i < precios.length; i++)
                {
                    if(precios[i] > precios[indiceC])
                    {
                        indiceC = i;
                    }
                    if(precios[i] < precios[indiceB])
                    {
                        indiceB = i;
                    }
                }
            
            System.out.println(" EL PRODUCTO MAS CARO ES " + productos[indiceC] + "Y CUESTA " + precios[indiceC] );
            System.out.println();
            System.out.println(" EL PRODUCTO MAS BARATO ES " + productos[indiceB] + "Y CUESTA " + precios[indiceB] );

          // aqui se muestra el producto con el inventario menor..

           System.out.println("Objeto con el inventario mas bajo..");

           for(int i = 0; i < cantidades.length; i++)
            {
                if(cantidades[i] < 15)
                    {
                       System.out.println("PRODUCTO: " + productos[i] + " cantidad: " + cantidades[i]);
                    }
            }
            
            // este ordena por el metodo de burbuja 
            for(int i = 0; i < precios.length - 1; i++)
                {
                    for(int j = 0; j < precios.length - 1 - i ; j++)
                        {
                            if(precios[i] < precios[j + 1] )
                                {
                                  
                                 // Intercambiar precios
                                    double tempPrecio = precios[j];
                                    precios[j] = precios[j + 1];
                                    precios[j + 1] = tempPrecio;

                                    // Intercambiar productos
                                    String tempProducto = productos[j];
                                    productos[j] = productos[j + 1];
                                    productos[j + 1] = tempProducto;

                                    // Intercambiar cantidades
                                    int tempCantidad = cantidades[j];
                                    cantidades[j] = cantidades[j + 1];
                                    cantidades[j + 1] = tempCantidad;
                                }
                        }
               }
             // 5. Mostrar inventario ordenado

            System.out.println("\nINVENTARIO ORDENADO");

            for (int i = 0; i < productos.length; i++)
            {
                System.out.println(String.format(Locale.US,
                    "%-15s %,12.2f %10d",
                    productos[i], precios[i], cantidades[i]));  
            }           
    }

        public static  void MatrizCalificaciones()
        {
            String[] nombres = {"Ana", "Luis", "Maria", "Carlos"};

             double[][] parciales = {  
                   {8.5, 9.0, 7.5}, 
                   {6.0, 5.5, 7.0}, 
                   {9.0, 8.5, 9.5}, 
                   {4.5, 6.0, 5.0} };

            System.out.printf("ESTUDIANTE\t ", "PARCIAL 1\t ", "PARCIAL 2\t ",
                "PARCIAL 3\t ",  "PROMEDIO\t ",  "ESTADO");

            double[] promedio = new double[parciales.length ];

            int aprovados = 0;
            int reprovados = 0;
            double sumaTodos = 0;

            for(int i = 0; i < parciales.length; i++ )
                {
                    double suma = 0;

                    for(int j = 0; j < nombres[i].length(); j++)
                        {
                            double promedios = suma / parciales[i].length;

                            promedio[i] = promedios;
                            sumaTodos  = promedios;

                            String Estado;

                            if(promedios >= 6.0)
                                {
                                    Estado = "Aprovado";
                                    aprovados++;
                                } else {
                                    Estado = "Reprovado";
                                    reprovados++;
                                 }


                                 // calcuala el promedio de cada parcial..

                                 System.out.println("Promedio de cada parcial:");

                                 for(int k = 0; k < parciales[0].length; k++)
                                    {
                                        double sumaa = 0; 

                                        for(int l = 0; l < parciales.length; l++ )
                                            {
                                                suma +=parciales[i][j];
                                            }

                                            double promedioParcial = suma / parciales.length;

                                            System.out.printf(" \"Parcial %d: %.2f%n\",\n" + j + 1, promedioParcial);
                                    }

                            // ENCONTAR AL MEJOR Y POR ESTUDUAMTE....

                            int mejor = 0;
                            int peor = 0;

                            for(int f = 0; f < promedio.length; f++)
                            {
                                    if(promedio[f] > promedio[mejor])
                                        {
                                            mejor  =  f;
                                        } else if (promedio[f] < promedio[peor])
                                            {
                                                peor = f;
                                            }
                            }
                                System.out.println("\nMEJOR ESTUDIANTE: "
                                 + nombres[mejor] + " - "
                                 + String.format("%.2f", promedio[mejor]));

                                System.out.println("PEOR ESTUDIANTE: "
                                + nombres[peor] + " - "
                                + String.format( "%.2f", promedio[peor]));


                                // mostar la cantidad de aprovados y reprovados..

                                System.out.println("Resumen del grupo:");
                                System.out.println("APROVADOS:  " + aprovados);
                                System.out.println("REPROVADOS:  " + reprovados);

                        }
                }
        }

        public static int  BusquedaYremplazo(String[] productos,  double[] precios ,int[] cantidades, String busqueda)
        {
           for (int i = 0; i < productos.length; i++) {

                if (productos[i].toLowerCase().contains(busqueda.toLowerCase())) {
                   return i;
                }
           }
                return -1;  
        }

        public static void probarBusqueda(String[] productos,  double[] precios ,int[] cantidades) 
        {

         String[] busquedas = {"lap", "MOUSE", "table"};

          for (String busqueda : busquedas) 
            {

           int indice = BusquedaYremplazo(productos, precios, cantidades, busqueda);

            if (indice != -1) {
               System.out.println("Producto encontrado: " + productos[indice]);
            } else {
             System.out.println("No se encontro: " + busqueda);
            }
           }

        }
        
        public static void  Procesador() {

           String datos = "1001,Juan Perez,Programador,45000\n"
                          + "1002,Ana Lopez,Analista,55000\n"
                          + "1003,Carlos Diaz,Programador,50000\n"
                          + "1004,Maria Gomez,Gerente,75000\n"
                          + "1005,Pedro Santos,Analista,48000";

            String[] empleados = datos.split("\n");

             double suma = 0;

            String[] primerEmpleado = empleados[0].split(",");

            double mayor = Double.parseDouble(primerEmpleado[3]);
             double menor = Double.parseDouble(primerEmpleado[3]);

             String empleadoMayor = primerEmpleado[1];
            String empleadoMenor = primerEmpleado[1];

             System.out.println("===== EMPLEADOS =====");

            for (String empleado : empleados)
            {
                String[] datosEmpleado = empleado.split(",");

                String codigo = datosEmpleado[0];
                String nombre = datosEmpleado[1];
                String puesto = datosEmpleado[2];
                double salario = Double.parseDouble(datosEmpleado[3]);

                System.out.println("Codigo: " + codigo);
                System.out.println("Nombre: " + nombre);
                System.out.println("Puesto: " + puesto);
                System.out.println("Salario: " + salario);
                System.out.println("--------------------");

                suma += salario;

                if (salario > mayor)
                {
                    mayor = salario;
                    empleadoMayor = nombre;
                }

                if (salario < menor) 
                {
                    menor = salario;
                    empleadoMenor = nombre;
                }
            }

                double promedio = suma / empleados.length;

                System.out.println("Salario promedio: " + promedio);
                System.out.println("Mayor salario: " + empleadoMayor + " - " + mayor);
                System.out.println("Menor salario: " + empleadoMenor + " - " + menor);

                System.out.println("\n===== PROGRAMADORES =====");

            for (String empleado : empleados) {

            String[] datosEmpleado = empleado.split(",");

        if (datosEmpleado[2].equalsIgnoreCase("Programador")) {
            System.out.println(datosEmpleado[1]);
        }
    }
  } 
   
        public static String validarEstudiante(String nombre,String matricula, String correo) {

            if (nombre == null || nombre.trim().isEmpty()) {
                return "El nombre no puede estar vacio";
            }

             String[] palabras = nombre.trim().split("\\s+");

             if (palabras.length < 2) {
                return "El nombre debe tener por lo menos dos palabras";
             }

            if (!matricula.startsWith("202")) {
             return "La matricula debe comenzar con 202";
            }

            if (matricula.length() != 9) {
              return "La matricula debe tener 9 caracteres";
           }

            if (!correo.contains("@")) {
                return "El correo debe contener @";
            }

            if (!correo.endsWith(".edu")) {
            return "El correo debe terminar en .edu";
            }

            return "Estudiante valido";
        } 

        public static void ejercicio5() {

            String resultado1 = validarEstudiante(
            "Juan Perez",
            "202312345",
            "juan@gmail.edu"
             );

            System.out.println(resultado1);

            String resultado2 = validarEstudiante(
            "Juan",
            "202312345",
            "juan@gmail.edu"
            );

            System.out.println(resultado2);

            String resultado3 = validarEstudiante(
            "Ana Lopez",
            "201312345",
            "ana@gmail.edu"
            );

            System.out.println(resultado3);

            String resultado4 = validarEstudiante(
            "Pedro Santos",
            "202312345",
            "pedro@gmail.com"
            );

            System.out.println(resultado4);
        }

        public static void ejercicio6() {

            Calendar fecha = Calendar.getInstance();

            SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formato2 = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formato3 =
                new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");

            System.out.println("Fecha actual:");
            System.out.println(formato1.format(fecha.getTime()));
            System.out.println(formato2.format(fecha.getTime()));
            System.out.println(formato3.format(fecha.getTime()));

            // 90 dias despues
            fecha.add(Calendar.DAY_OF_YEAR, 90);

            System.out.println("\nFecha 90 dias despues:");
            System.out.println(formato1.format(fecha.getTime()));

            // Regresamos a la fecha actual
            fecha = Calendar.getInstance();

            // 6 meses antes
            fecha.add(Calendar.MONTH, -6);

            System.out.println("\nFecha 6 meses antes:");
            System.out.println(formato1.format(fecha.getTime()));

            // Edad
            Scanner sc = new Scanner(System.in);

            System.out.print("\nDigite su año de nacimiento: ");
            int añoNacimiento = sc.nextInt();

            Calendar hoy = Calendar.getInstance();

            int añoActual = hoy.get(Calendar.YEAR);

            int edad = añoActual - añoNacimiento;

            System.out.println("Edad aproximada: " + edad + " años");

            // Dias hasta el 31 de diciembre
            Calendar finAño = Calendar.getInstance();
            finAño.set(Calendar.MONTH, Calendar.DECEMBER);
            finAño.set(Calendar.DAY_OF_MONTH, 31);

            long diferencia = finAño.getTimeInMillis()
             - hoy.getTimeInMillis();

            long dias = diferencia / (1000 * 60 * 60 * 24);

             System.out.println("Dias hasta el 31 de diciembre: " + dias);
        }
      
}



