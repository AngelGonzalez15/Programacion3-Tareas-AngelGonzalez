
package Controller;

import Modelo.Gestor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EstadisticasController {

    @FXML
    private Label totalLabel;

    @FXML
    private Label promedioLabel;

    @FXML
    private Label aprobadosLabel;

    @FXML
    private Label reprobadosLabel;

    private Gestor gestor = new Gestor();

    @FXML
    public void initialize() {

        totalLabel.setText(String.valueOf(gestor.totalEstudiantes()));

        promedioLabel.setText(
            String.format("%.2f", gestor.promedioGeneral())
        );

        aprobadosLabel.setText(String.valueOf(gestor.totalAprobados()));

        reprobadosLabel.setText(String.valueOf(gestor.totalReprobados()));
    }
}
