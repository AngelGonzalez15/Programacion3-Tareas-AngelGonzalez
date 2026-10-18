import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
  public static void main(String[] args) throws Exception {

    launch(args);

  }
   double presupuestoTotal = 0.0;
   double totalGastado = 0.0;

    Label estado = new Label("Gastado: RD$ 0.00 | Disponible: RD$ 0.00");

  @Override
    public void start(Stage primaryStage) throws Exception {
      primaryStage.setTitle("Control de Gastos Mensuales");

      Label Titulo =new Label("Presupuesto Mensual");

      TextField ps = new TextField("Digita el presupuesto...");

      Button boton = new Button("Fijar");
      boton.setStyle("-fx-background-color: #ffffff");

      Label cc =new Label("Registrar los gastos");

      TextField des = new TextField();
      des.setPromptText("Descripcion....");
      TextField mon = new TextField();
      mon.setPromptText("Digita el monto..");

      Button bt = new Button("Agregar gasto..");
      bt.setStyle("-fx-background-color: #ffffff");
      
      VBox contenedorGastos = new VBox(4);
      boton.setOnAction(e -> 
      {
        try
        {
          presupuestoTotal = Double.parseDouble(ps.getText());

          Actualizar();
        } catch (NumberFormatException ex)
        {
          estado.setText("Digita un presupuesto valido");
        }
        
      });


       bt.setOnAction(e -> {
        try{
          String descripcion = des.getText();
          double monto = Double.parseDouble(mon.getText());
          
          if(descripcion.isEmpty() || monto <= 0)
          {
            estado.setText("verifica la descripcion y el monto");
            return;
          }

          if(monto <=  presupuestoTotal - totalGastado){
          HBox fila = new HBox(10);

          Label detalle = new Label(descripcion + " -- RD$ " + monto);

          Button eliminar = new Button("X");
          
          //elimina el gasto 
          eliminar.setOnAction(e1 ->  {
            totalGastado -= monto;
            contenedorGastos.getChildren().remove(fila);
            Actualizar();
          });

          fila.getChildren().addAll(detalle,eliminar);
          contenedorGastos.getChildren().add(fila);

          totalGastado += monto;
          Actualizar();

          des.clear();
          mon.clear();
   
        } else 
        {
          estado.setText("El gasto supera el dinero disponible"); 
        }
      } catch (NumberFormatException ex)
      {
        estado.setText("Digita un monto valido");
      }
      
    });
   
      VBox root = new VBox(10);

        root.getChildren().addAll(
            Titulo, ps, boton, estado,
            cc, des, mon, bt, contenedorGastos
        );

        root.setStyle("-fx-padding: 15;");

        Scene escena = new Scene(root, 500, 600);

        primaryStage.setScene(escena);
        primaryStage.show();
    
  }

  public void Actualizar() {
    double disponible = presupuestoTotal - totalGastado;
    estado.setText(String.format("Gastado: RD$ %.2f | Disponible: RD$ %.2f", totalGastado, disponible));

     double porcentaje = 0;

     if(presupuestoTotal > 0)
      {
        porcentaje = (totalGastado / presupuestoTotal) * 100;
      }

      String mensaje = String.format(
        "Gastado: RD$ %.2f | Disponible: RD$ %.2f",
        totalGastado, disponible
      );


      if (porcentaje < 70)
        {
          estado.setStyle("-fx-text-fill:  #2fa535;");

        } else if(porcentaje <= 100)
        {
          estado.setStyle("-fx-text-fill:  #f6fa02;");

        } else 
        {
          estado.setStyle("-fx-text-fill:  #d40808;");
          mensaje += "|  Presupuesto exedido!...";
        }
  }
}
