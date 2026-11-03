
package Controller;

import Modelo.GestorInventario;
import Modelo.Producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class InventarioController implements Initializable {

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, Integer> colCodigo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colCantidad;

    @FXML
    private TableColumn<Producto, Double> colValorTotal;

    @FXML
    private TextField txtBuscar;

    @FXML
    private Label lblTotalProductos;

    @FXML
    private Label lblValorInventario;

    private GestorInventario gestor;

    private ObservableList<Producto> listaProductos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        colCantidad.setCellValueFactory(
                new PropertyValueFactory<>("cantidad"));

        colValorTotal.setCellValueFactory(
                new PropertyValueFactory<>("valorTotal"));
    }

    public void setGestor(GestorInventario gestor) {
        this.gestor = gestor;
        cargarTabla();
    }

    private void cargarTabla() {

        if (gestor == null) {
            return;
        }

        listaProductos = FXCollections.observableArrayList(
                gestor.getProductos());

        tablaProductos.setItems(listaProductos);

        actualizarTotales();
    }

    private void actualizarTotales() {

        int cantidadProductos = gestor.getProductos().size();

        double total = 0;

        for (Producto p : gestor.getProductos()) {
            total += p.getValorTotal();
        }

        lblTotalProductos.setText(
                "Total de productos: " + cantidadProductos);

        lblValorInventario.setText(
                "Valor del inventario: RD$ " + String.format("%.2f", total));
    }

    @FXML
    private void buscarProducto() {

        if (gestor == null) {
            return;
        }

        String texto = txtBuscar.getText().trim().toLowerCase();

        ObservableList<Producto> resultado =
                FXCollections.observableArrayList();

        for (Producto p : gestor.getProductos()) {

            if (texto.isEmpty()
                    || String.valueOf(p.getCodigo()).contains(texto)
                    || p.getNombre().toLowerCase().contains(texto)) {

                resultado.add(p);
            }
        }

        tablaProductos.setItems(resultado);
    }
}
