
package Controller;

import Modelo.GestorInventario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class PrincipalController {

    // Una sola instancia para todo el sistema
    private GestorInventario gestor = new GestorInventario();

    @FXML
    private void irInventario(ActionEvent event) {
        abrirVentana("/View/Inventario.fxml", event);
    }

    @FXML
    private void irRegistrarProducto(ActionEvent event) {
        abrirVentana("/View/Registro.fxml", event);
    }

    @FXML
    private void irRegistrarVenta(ActionEvent event) {
        abrirVentana("/View/Ventas.fxml", event);
    }

    @FXML
    private void irHistorialVentas(ActionEvent event) {
        abrirVentana("/View/HistorialVentas.fxml", event);
    }

    private void abrirVentana(String archivo, ActionEvent event) {

        try {

            URL ubicacion = getClass().getResource(archivo);

            if (ubicacion == null) {
                throw new IOException(
                    "No se encontró el archivo: " + archivo
                );
            }

            FXMLLoader loader = new FXMLLoader(ubicacion);

            Parent root = loader.load();

            // Obtener el controlador de la ventana
            Object controlador = loader.getController();

            // Compartir el mismo gestor con las demás ventanas
            if (controlador instanceof RegistroController) {
                ((RegistroController) controlador).setGestor(gestor);
            }

            if (controlador instanceof InventarioController) {
                ((InventarioController) controlador).setGestor(gestor);
            }

            if (controlador instanceof VentaController) {
                ((VentaController) controlador).setGestor(gestor);
            }

            // Obtener la ventana actual
            Stage escenario = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            // Cambiar el contenido de la ventana
            escenario.setScene(new Scene(root));

            escenario.show();

        } catch (IOException e) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);

            alerta.setTitle("Error");
            alerta.setHeaderText("No se pudo abrir la ventana");
            alerta.setContentText(e.getMessage());

            alerta.showAndWait();

            e.printStackTrace();
        }
    }
}
