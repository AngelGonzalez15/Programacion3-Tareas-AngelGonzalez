package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorInventario {

    private static final String archivo = "productos.txt"; 
    private static final String archivoVentas = "ventas.txt";

    private ArrayList<Producto> productos;
    private ArrayList<Ventas> ventas;

    public GestorInventario() {
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();
        cargarProductos();
        cargarVentas();
    }

   public boolean agregarProducto(Producto producto) {

        for (Producto p : productos) {

            if (p.getCodigo() == producto.getCodigo()) {
            return false;
            }
        }

        productos.add(producto);

        guardarProductos();

        return true;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

   

    public Producto consultarProducto(int codigo) {

        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
               
                return p;
            }
        }
        return null;
    }

   public void guardarProductos() {
       try
       {
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Producto p : productos) {
            bw.write(p.getCodigo() + "," + p.getNombre() + "," + p.getPrecio() + "," + p.getCantidad());
            bw.newLine();
        }
        bw.close();

       } catch (IOException e) {
        System.out.println("Error al guardar los productos: " + e.getMessage());
    }
    }

    
    public void cargarProductos() {

       productos.clear();

      try {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");

            int codigo = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            double precio = Double.parseDouble(datos[2]);
            int cantidad = Integer.parseInt(datos[3]);

            Producto producto = new Producto(
                codigo, nombre, precio, cantidad
            );

            productos.add(producto);
        }

        br.close();

      } catch (IOException e) {
        System.out.println("Error al cargar los productos: " + e.getMessage());
      }
    }

    public boolean registrarVenta(int codigo, int cantidad) {

    // 1. Validar la cantidad
    if (cantidad <= 0) {
        System.out.println("La cantidad debe ser mayor que cero.");
        return false;
    }

    // 2. Buscar el producto
    Producto producto = consultarProducto(codigo);

    // 3. Verificar que exista
    if (producto == null) {
        System.out.println("Producto no encontrado.");
        return false;
    }

    // 4. Verificar las existencias
    if (producto.getCantidad() < cantidad) {
        System.out.println("Inventario insuficiente.");
        return false;
    }

    // 5. Crear el objeto Venta
    Ventas venta = new Ventas(
        producto.getCodigo(),
        producto.getNombre(),
        cantidad,
        producto.getPrecio(),
        cantidad * producto.getPrecio()
    );

    // 6. Descontar las unidades
    producto.setCantidad(producto.getCantidad() - cantidad);

    // 7. Actualizar el archivo de productos
    guardarProductos();

     // 8. Registrar la venta
      guardarVenta(venta);

     // 9. Agregar la venta a la lista
      ventas.add(venta);

    System.out.println("Venta realizada correctamente.");
    System.out.println("Total: RD$ " + venta.getTotalVenta());

    return true;
    
   }

    private void guardarVenta(Ventas venta) {
        try {
            FileWriter fw = new FileWriter(archivoVentas, true);
            BufferedWriter bw = new BufferedWriter(fw);
    
            bw.write(venta.getCodigoProducto() + "," + venta.getNombreProducto() + "," + venta.getCantidadVendida() + "," + venta.getPrecioUnitario() + "," + venta.getTotalVenta());
            bw.newLine();
    
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
        }
    }

    public void cargarVentas() {

      ventas.clear();

      try {
          FileReader fr = new FileReader(archivoVentas);
          BufferedReader br = new BufferedReader(fr);

          String linea;

          while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");

            int codigo = Integer.parseInt(datos[0]);
            String nombre = datos[1];
            int cantidad = Integer.parseInt(datos[2]);
            double precio = Double.parseDouble(datos[3]);
            double total = Double.parseDouble(datos[4]);
            Ventas venta = new Ventas(
                codigo, nombre, cantidad, precio, total
            );

            ventas.add(venta);
          }

          br.close();

        } catch (IOException e) {
          System.out.println("Error al cargar las ventas: " + e.getMessage());
        }
   }

    public double totalVentas() {

      double total = 0;

      for (Ventas v : ventas) {
        total += v.getTotalVenta();
      }

      return total;
    }

    public ArrayList<Ventas> getVentas() {
    return ventas;
    
    }

    
}
