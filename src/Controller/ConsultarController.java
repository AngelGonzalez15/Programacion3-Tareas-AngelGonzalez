package Controller;
import Modelo.Estudiantes;
import Modelo.Gestor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConsultarController {
    
     @FXML
    private TextField matriculaField;
    @FXML 
    private TextField nombreField;
    @FXML
    private TextField carreraField;
    @FXML
    private TextField calificacionField;

    private Gestor gestor = new Gestor();
    
    @FXML 
    private void Consultar()
    {
        String matricula = matriculaField.getText();
        Estudiantes estudiante = gestor.consultarEstudiante(matricula);
        
        if (estudiante != null) {
            // Mostrar los datos del estudiante en la interfaz
            nombreField.setText(estudiante.getNombre());
            carreraField.setText(estudiante.getCarrera());
            calificacionField.setText(String.valueOf(estudiante.getCalificacion()));
        } else {
            gestor.mostarMensaje("Estudiante no encontrado.");
        }
    }
}
