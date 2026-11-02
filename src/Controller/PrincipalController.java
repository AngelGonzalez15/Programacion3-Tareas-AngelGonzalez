
package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController {

    @FXML
    private void IrRegistrar() {
        abrirVentana("/View/Registro.fxml", "Registrar");
    }

    @FXML
    private void IrConsultar() {
        abrirVentana("/View/Consultar.fxml", "Consultar");
    }

    @FXML
    private void IrEstadisticas() {
        abrirVentana("/View/Estadisticas.fxml", "Estadísticas Académicas");
    }

    @FXML
    private void IrCopias() {
        abrirVentana("/View/Copias.fxml", "Copias de Seguridad");
    }

    private void abrirVentana(String archivo, String titulo) {

        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource(archivo)
            );

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
