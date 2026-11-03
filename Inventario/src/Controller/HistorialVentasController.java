package Controller;


import Modelo.GestorInventario;
import Modelo.Ventas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class HistorialVentasController {

    @FXML
    private TableView<Ventas> tablaVentas;

    @FXML
    private TableColumn<Ventas, Integer> colCodigo;

    @FXML
    private TableColumn<Ventas, String> colNombre;

    @FXML
    private TableColumn<Ventas, Integer> colCantidad;

    @FXML
    private TableColumn<Ventas, Double> colPrecio;

    @FXML
    private TableColumn<Ventas, Double> colTotal;

    @FXML
    private Label lblTotalVentas;

    private GestorInventario gestor;

    // Recibimos el mismo gestor que utiliza el resto del sistema.
    public void setGestor(GestorInventario gestor) {
        this.gestor = gestor;
        cargarTabla();
    }

    private void cargarTabla() {

        if (gestor == null) {
            return;
        }

        // Relacionamos cada columna con una propiedad de Ventas.
        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigoProducto"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombreProducto"));

        colCantidad.setCellValueFactory(
                new PropertyValueFactory<>("cantidadVendida"));

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precioUnitario"));

        colTotal.setCellValueFactory(
                new PropertyValueFactory<>("totalVenta"));

        // Obtenemos todas las ventas registradas.
        ArrayList<Ventas> ventas = gestor.getVentas();

        ObservableList<Ventas> listaVentas =
                FXCollections.observableArrayList(ventas);

        tablaVentas.setItems(listaVentas);

        // Mostramos el dinero generado.
        double total = gestor.totalVentas();

        lblTotalVentas.setText(
                "Total generado: RD$ " + String.format("%.2f", total));
    }

    @FXML
    private void volverMenu() {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Historial de ventas");
        alerta.setHeaderText(null);
        alerta.setContentText("Para regresar al menú, utiliza la navegación principal.");
        alerta.showAndWait();
    }
}
