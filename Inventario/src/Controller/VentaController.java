
package Controller;

import Modelo.GestorInventario;
import Modelo.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VentaController {

    private GestorInventario gestor;

    public void setGestor(GestorInventario gestor) {
        this.gestor = gestor;
    }

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtPrecioProducto;

    @FXML
    private TextField txtCantidad;

    @FXML
    private Button btnVender;


    private Producto productoEncontrado;

    // Buscar el producto mientras escribimos su nombre
    @FXML
    private void buscarProducto() {

        String nombre = txtNombreProducto.getText().trim();

        productoEncontrado = null;
        txtPrecioProducto.clear();

        if (nombre.isEmpty()) {
            return;
        }

        for (Producto p : gestor.getProductos()) {

            if (p.getNombre().equalsIgnoreCase(nombre)) {

                productoEncontrado = p;

                txtPrecioProducto.setText(
                    "RD$ " + String.format("%.2f", p.getPrecio())
                );

                break;
            }
        }
    }

    // Registrar la venta
    @FXML
    private void registrarVenta() {

        if (productoEncontrado == null) {
            mostrarMensaje("Producto no encontrado.");
            return;
        }

        try {

            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (cantidad <= 0) {
                mostrarMensaje("La cantidad debe ser mayor que cero.");
                return;
            }

            if (gestor.registrarVenta(
                    productoEncontrado.getCodigo(), cantidad)) {

                mostrarMensaje("Venta registrada correctamente.");

                limpiarCampos();

            } else {

                mostrarMensaje(
                    "No hay suficiente existencia para realizar la venta."
                );
            }

        } catch (NumberFormatException e) {

            mostrarMensaje("Introduzca una cantidad válida.");
        }
    }

    private void limpiarCampos() {

        txtNombreProducto.clear();
        txtPrecioProducto.clear();
        txtCantidad.clear();

        productoEncontrado = null;
    }

    private void mostrarMensaje(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Registro de ventas");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);

        alerta.showAndWait();
    }
}
