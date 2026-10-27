
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto(null, null, null, null);
        int opcion;

        do
        {
            System.out.println("====== Systema de Inventario ======");
            System.out.println("1- Registrar Producto");
            System.out.println("2- Consultar inventario");
            System.out.println("3- Buscar producto por codigo");
            System.out.println("4- Calcular valor del inventario");
            System.out.println("5- Crear copia de seguridad");
            System.out.println("6- Recuperar copia de seguridad");
            System.out.println("7- Salir");

            System.out.println("Seleccione una opcion:");
            opcion = sc.nextInt();
            sc.nextLine();

            try
            {
                switch (opcion) {
                    case 1:
                        producto.RegistrarProductos(sc);
                        break;
                    case 2:
                        producto.ConsultarInventario();
                        break;
                    case 3:
                        producto.BuscarProducto(sc);
                        break;
                    case 4:
                        producto.ValorInventario();
                        break;
                    case 5:
                        producto.GuardarCopia();
                        break;
                    case 6:
                        producto.RecuperarCopiaSeguridad();
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema....");
                        break;
                    default:
                        System.out.println("opcion invalida..");
                        break;
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Error:" + e.getMessage());
            }

        }while(opcion != 7);
        
    }
}
