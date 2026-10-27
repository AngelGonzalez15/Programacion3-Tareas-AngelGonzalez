import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Producto  implements  Serializable {
    Scanner sc = new Scanner(System.in);

   private String codigo;
   private String nombre;
   private String precio;
   private String cantidad;
   
   public ArrayList<Producto> productos = new ArrayList<>();
   private static File arc = new File("inventario.txt");

   public Producto(String nombre,String codigo,String precio,String cantidad)
   {
     this.nombre = nombre;
     this.codigo = codigo;
     this.precio = precio;
     this.cantidad = cantidad;
   }

   
   public String getCantidad() {
    return cantidad;
   }

   public String getCodigo()
    {
       return codigo;
    }

   public String getNombre()
   {
       return nombre;
   }

   public String getPrecio() {
       return precio;
   }

   public void setCantidad(String cantidad) 
   {
       this.cantidad = cantidad;
   }

   public void setCodigo(String codigo)
   {
       this.codigo = codigo;
   }

   public void setNombre(String nombre) 
   {
       this.nombre = nombre;
   }
   
   public void setPrecio(String precio) 
   {
       this.precio = precio;
   }
   
   public void RegistrarProductos(Scanner sc)
   {
       System.out.println("Registro de productos:");

       System.out.println("Nombre del producto:");
       String nombre = sc.nextLine();

       System.out.println("Codigo del Producto:");
       String codigo = sc.nextLine();
       

       System.out.println("Precio del producto:");
       String  precio = sc.nextLine();

       System.out.println("Cantidad de productos:");
       String cantidad = sc.nextLine();

       if(verificacion(codigo))
        {
            System.out.println("El producto ya existe....");
        }else
        {

           Producto nuevoProducto = new Producto(nombre, codigo, precio, cantidad);
           productos.add(nuevoProducto);

           try(BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.txt",true)))
           {
              bw.write(codigo + ";" + nombre + ";" + precio + ";" + cantidad);
              bw.newLine();

              System.out.println("El producto se registro correctamente...");
           } catch(IOException e)
           {
              System.out.println("Error al guardar el producto: " + e.getMessage());
           }
           
        }   
   }

   public boolean verificacion(String codigo)
   {
      for (Producto p : productos)
        {
            if(p.getCodigo().equals(codigo))
                {
                    return true;
                }
        }
      return false;
   }

   public void ConsultarInventario()
   {
     try(BufferedReader br = new BufferedReader(new FileReader("inventario.txt")))
     {
        String linea;
        boolean inventarioVacio = true;

        while((linea = br.readLine()) !=null)
        {
            inventarioVacio = false;
            
            String[] datos = linea.split(";");

            System.out.println("codigo: " + datos[0]);
            System.out.println("nombre: " + datos[1]);
            System.out.println("precio: " + datos[2]);
            System.out.println("cantidad: " + datos[3]);
        }

        if(inventarioVacio = true)
            {
                System.out.println("El inventario esta vacio");
            }

     }catch (IOException e)
     {
        System.out.println("Error al leer el inventario: " + e.getMessage());
     }
   }

   public void BuscarProducto(Scanner sc)
   {
     System.out.println("Ingresa el codigo del producto que buscas");
     String codigoB = sc.nextLine();

     boolean encontrado =  false;

    try(BufferedReader br = new BufferedReader(new FileReader("inventario.txt")))
     {
        String linea;
    
        while((linea = br.readLine()) !=null)
        {      
            String[] datos = linea.split(";");

            if(datos[0].equalsIgnoreCase(codigoB))
            {
              System.out.println("Producto encontrado");

              System.out.println("codigo: " + datos[0]);
              System.out.println("nombre: " + datos[1]);
              System.out.println("precio: " + datos[2]);
              System.out.println("cantidad: " + datos[3]);

              encontrado = true;
              break;
            }
        }
    } catch (IOException e)
    {
        System.out.println("Error: Producto no encontrado" + e.getMessage());
    }
   }


   public void ValorInventario()
   {
      double total =  0;
      boolean inventariovacio = true;

      try(BufferedReader br = new BufferedReader(new FileReader("inventario.txt")))
      {
        String linea;
    
        while((linea = br.readLine()) !=null)
        {      
            String[] datos = linea.split(";");

            double precio = Double.parseDouble(datos[2]);
            int cantidad = Integer.parseInt(datos[3]);

            double valorP = precio * cantidad;

            total += valorP;

            inventariovacio = false;
        }

        if(inventariovacio)
        {
            System.out.println("El inventario esta vacio.");
        } else 
        {
           System.out.printf("Valor total del inventario: $ %,.2f%n", total);
        }

      }catch (IOException e)
      {
        System.out.println("Error al leer al inventario: " + e.getMessage());
      }
    }

   public void GuardarCopia()
   {
     try(ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("inventario.dat")))
     {
        salida.writeObject(productos);

        System.out.println("Copia de seguridad guardada...");
     }catch (IOException e)
     {
        System.out.println("Error al guardar la copia: " + e.getMessage());
     }
   } 

   public void RecuperarCopiaSeguridad()
   {
    try (ObjectInputStream entrada = new ObjectInputStream( new FileInputStream("inventario.dat")))
    {
        ArrayList<Producto> recuperados = (ArrayList<Producto>) entrada.readObject();

        productos.clear();
        productos.addAll(recuperados);

        System.out.println("Copia de seguridad recuperada correctamente.");

    }
    catch (IOException | ClassNotFoundException e)
    {
        System.out.println("Error al recuperar la copia: " + e.getMessage());
    }
   }

}
