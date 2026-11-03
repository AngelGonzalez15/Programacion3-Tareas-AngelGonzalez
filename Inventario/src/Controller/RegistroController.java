
package Controller;

import Modelo.GestorInventario;
import Modelo.Producto;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistroController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private Button btnRegistrar;

    private GestorInventario gestor = new GestorInventario();

    @FXML
    private void registrarProducto() {

        try {

            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            if (codigo <= 0 || nombre.isEmpty() ||
                precio <= 0 || cantidad < 0) {

                mostrarMensaje("Verifique los datos del producto.");
                return;
            }

            Producto producto = new Producto(
                codigo, nombre, precio, cantidad
            );

            if (gestor.agregarProducto(producto)) {

                mostrarMensaje("Producto registrado correctamente.");
                limpiarCampos();

            } else {

                mostrarMensaje("Ya existe un producto con ese código.");

            }

        } catch (NumberFormatException e) {

            mostrarMensaje("Introduzca valores numéricos válidos.");

        }
    }

    private void limpiarCampos() {

        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtCantidad.clear();

    }

    private void mostrarMensaje(String mensaje) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Registro de productos");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    public void setGestor(GestorInventario gestor2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setGestor'");
    }
}
