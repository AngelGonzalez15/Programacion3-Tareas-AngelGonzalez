import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner T = new Scanner(System.in);

         
            int opcion;

        do{
            System.out.println("1. Calculadora"); // Listo
            System.out.println("2. Par o impar"); // Listo
            System.out.println("3. Tabla de multiplicar"); // Listo
            System.out.println("4. Numeros del 1 al 100"); // Listo
            System.out.println("5. Clase Persona"); // Listo
            System.out.println("6. Clase Rectangulo"); // Listo
            System.out.println("7. Clase Empleado");
            System.out.println("8. Clase Figuras");
            System.out.println("9. Contador de vocales");
            System.out.println("10. Calculador de notas");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opcion del 1 al 10");
            opcion = T.nextInt();
                
         switch (opcion)
         {
            case 1: 

              Calculadora();
              break;

            case 2:

               ParImpar();
               break;

            case 3:

                TablaMultiplicar();
                break;

            case 4:

                numeros();
                break;

            case 5:

                Persona();
                break;

            case 6:

                Rectangulo();
                break;

            case 7:

                Empleado();
                break;

            case 8:

                Figura();
                break;

            case 9:
               
              ContadorVocales();
               break;

            case 10:
               CalcularNotas();
               break;

            case 0:

                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opcion invalida, por favor ingrese una opcion del 1 al 10");
                break;

        }
        
        } while (opcion != 0 || opcion >= 10);
    }

    public static void Calculadora() 
    {
      Scanner T = new Scanner(System.in);
      System.out.println("========= Calculadora ===========");
      System.out.println();
     
      int opcion;

      do{

        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("0. Salir");
        System.out.println("Ingrese una opcion del 1 al 4");
        opcion = T.nextInt();

       } while (opcion < 0 || opcion > 4);

       System.out.println("Ingrese el primer numero");
       double num1 = T.nextDouble();
       System.out.println("Ingrese el segundo numero");
       double num2 = T.nextDouble();
     
        if (opcion == 1 )
        {
            double resultado = num1 + num2;
            System.out.println("El resultado de la suma es: " + resultado);
            System.out.println();
        }  
        else if (opcion == 2 )
        {
                double resultado = num1 - num2;
                System.out.println("El resultado de la resta es: " + resultado);
                System.out.println();
            }  
        else if (opcion == 3 )
           {
                 double resultado = num1 * num2;
                System.out.println("El resultado de la multiplicacion es: " + resultado);
                System.out.println();
           } 
        else if (opcion == 4 )
            {
                 double resultado = num1 / num2;
                 System.out.println("El resultado de la division es: " + resultado);
                 System.out.println();
            }         
  }

     public static void ParImpar()
     {
    Scanner T = new Scanner(System.in);

    System.out.println("========= Par o impar ===========");

    System.out.println("Ingrese un numero:");
    double num = T.nextDouble();

    if (num % 2 == 0)
    {
        System.out.println("El numero es par");
        System.out.println();
    }
    else
    {
        System.out.println("El numero es impar");
        System.out.println();
    }
  }

  public static void TablaMultiplicar()
  {
    Scanner T = new Scanner(System.in);

    System.out.println("========= Tabla de multiplicar ===========");
    int num = T.nextInt();
    
    for(int i = 1; i<=10; i++)
    {
        System.out.println(num + " x " + i + " = " + (num * i));
    }

  }

  public static void numeros()
  {
    System.out.println("========= Numeros del 1 al 100 ===========");

      // cuanodo el numero sea multiplo de 3 qn vez del numero se mostrara "Fizz"
      // cuando el numero sea multiplo de 5 en vez del numero se mostrara "Buzz"
      // y cuando el numero sea multiplo de 3 y 5 en vez del numero se mostrara "FizzBuzz"

     for(int i = 0 ; i <= 100; i++)
        {

          if(i % 3 == 0 && i % 5 == 0)
            {
                System.out.println("FizzBuzz");
            } 
             else if (i % 3 == 0 )
            {
                System.out.println("Fizz");
            } 
             else if (i % 5 == 0)
            {
                System.out.println("Buzz");
            } 
             else
            {
                System.out.println(i);
            }
        } 
  }

  public static void Persona()
  {

     Scanner T =  new Scanner (System.in);
     
     System.out.println("========= Clase Persona ===========");

     System.out.println("Ingrese el nombre de la persona");
     String nombre = T.nextLine();
     System.out.println("Ingrese la edad de la persona");
     int edad = T.nextInt();
     T.nextLine();     // Limpiar el buffer
     System.out.println("Ingrese el correo de la persona");
     String correo = T.nextLine();

     Persona p = new Persona(nombre, edad, correo);
     p.MostrarImformacion();
  }

  public static void Rectangulo()
  {

    Scanner T = new Scanner(System.in);

    System.out.println("========= Clase Rectangulo ===========");

    System.out.println("Ingrese la base del rectangulo");
    double base = T.nextDouble();
    System.out.println("Ingrese la altura del rectangulo");
    double altura = T.nextDouble();

    Rectangulo r = new Rectangulo(base, altura);
    System.out.println("El Area del rectangulo es: " + r.calcularArea());
    System.out.println("El Perimetro del rectangulo es: " + r.calcularPerimetro());

  }

   public static void Empleado()
   {
      Scanner T = new Scanner (System.in);

      System.out.println("========= Clase Empleado ===========");
      System.out.println();

       System.out.println("Ingrese el nombre del empleado");
       String nombre = T.nextLine();
       System.out.println("ingrese la edad del empleado");
       int edad =  T.nextInt();
       T.nextLine(); // Limpiar el buffer
       System.out.println("Ingrese el puesto del empleado");
       String puesto = T.nextLine();
       System.out.println("Ingrese el salario del empleado");
       double salario = T.nextDouble();

       Empleado E = new Empleado(nombre, edad, puesto, salario);
       E.CalcularBono();
       System.out.println("========= Datos del Empleado ===========");
       E.MostrarDatos();    
   }

   public static void Figura()
   {
     Scanner T = new  Scanner(System.in);
     System.out.println("========= Clase Figura ===========");
      System.out.println();

     Figura f = null;
     int opcion;

    do
    { 
        System.out.println("=== CÁLCULO DE ÁREAS ===");
        System.out.println("1. Tringulo");
        System.out.println("2. Circulo");
        System.out.println("0. Salir");
        System.out.println("Selecciona una figura");
        opcion = T.nextInt();

        switch (opcion) {
            case 1:

                System.out.println("Ingrese la base:");
                double base = T.nextDouble();
                System.out.println("Ingrese la Altura:");
                double altura = T.nextDouble();
                f = new triangulo(base, altura);
                System.out.println("El area es" + f.CalcularArea());
                break;

            case 2: 

            System.out.println("ingresa el Radio:");
            double radio = T.nextDouble();
            f = new Circulo(radio);
            System.out.println("El area es: " + f.CalcularArea());

            break;

            case 0:
                
            System.out.println("Saliendo del sistema....");
            break;

            default:
                  System.out.println("Opcion invalida");
                break;
        }
        
    }while( opcion != 0);
   }

   
    public static void ContadorVocales()
   {
    Scanner T  = new Scanner(System.in);

    System.out.println("=======Contador de Vocales=========");

     System.out.println("Escribe una frase:");
     String frase = T.nextLine();

     int contador = 0; 

     String frasesMinusculas = frase.toLowerCase();

     for(int i = 0; i < frasesMinusculas.length(); i++)
        {
          char caracter = frasesMinusculas.charAt(i);

          if(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u')
            {
                contador++;
            }

        }

        System.out.println("La frase contiene "+ contador + " vocales.");
    }
     
    public static void CalcularNotas()
    {
        Scanner T  = new Scanner(System.in);

        System.out.println("Ingresa tu nombre:");
        String nombre = T.nextLine();

        int[] nota = new int[5];

        System.out.println("Digita tus notas:");

        for(int i = 0; i < nota.length; i++)
            {
                 System.out.println("Nota ->" + i + 1 + ":" );
                 nota[i] = T.nextInt();
            }
    
           Estudiante E = new Estudiante(nombre, nota);

           System.out.println("\nEstudiante: " + E.getNombre());
        System.out.println("El promedio es de: " + E.calcularPromedio());
        E.obtenerCalificacion();
    
    }

}