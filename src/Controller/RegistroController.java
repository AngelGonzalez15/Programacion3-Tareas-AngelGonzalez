package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Modelo.Gestor;
import Modelo.Estudiantes;

public class RegistroController {
    
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
    private void Registrar()
    { 
        // obtener los campos 
        String nombre = nombreField.getText();
        String matricula = matriculaField.getText();
        String carrera = carreraField.getText();

        if (nombre.isEmpty() || matricula.isEmpty() || carrera.isEmpty()) {
            gestor.mostarMensaje("Error: Todos los campos son obligatorios.");
            return;
        }

        try{
           double calificacion = Double.parseDouble(calificacionField.getText());
           
           if(calificacion < 0  || calificacion > 100){
                gestor.mostarMensaje("Error: La calificación debe estar entre 0 y 100.");
                return;
            }

           Estudiantes etudiante = new Estudiantes(
            matricula, nombre, carrera, calificacion
            );

            boolean registrado = gestor.RegistraEstudiante(etudiante);
            
            if (registrado) {
                gestor.mostarMensaje("Estudiante registrado correctamente.");
            } else {
                gestor.mostarMensaje("Error: La matrícula ya está registrada.");
            }
        } catch (NumberFormatException e) {
            gestor.mostarMensaje("Error: La calificación debe ser un número válido.");
        }
    }

}
