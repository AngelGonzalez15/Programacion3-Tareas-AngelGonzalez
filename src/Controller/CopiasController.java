
package Controller;

import Modelo.Gestor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CopiasController {

    @FXML
    private Label mensajeLabel;

    private Gestor gestor = new Gestor();

    @FXML
    private void VerCopia() {

        if (gestor.crearCopia()) {

            mensajeLabel.setText("Copia de seguridad creada correctamente.");

        } else {

            mensajeLabel.setText("Error al crear la copia de seguridad.");
        }
    }

    @FXML
    private void restaurarCopia() {

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Restaurar copia");
        alerta.setHeaderText("¿Deseas restaurar la copia de seguridad?");
        alerta.setContentText("Los datos actuales serán reemplazados por los datos de la copia.");

        alerta.showAndWait().ifPresent(respuesta -> {

            if (respuesta == ButtonType.OK) {

                if (gestor.restaurarCopia()) {

                    mensajeLabel.setText("Copia restaurada correctamente.");

                } else {

                    mensajeLabel.setText("No se pudo restaurar la copia.");
                }
            }
        });
    }
}

