package Controller;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import model.Personaje;

public class Controller {

    @FXML
    TextField txtNombre;

    @FXML
    TextField txtPoder;

    @FXML
    TextField txtOrigen;

    @FXML
    TextField txtTecnica;

    @FXML
    ComboBox<String> cbRaza;

    @FXML
    TextField txtEdad;

    @FXML
    GridPane tablaPersonajes;

    int fila = 1;

    @FXML
    public void initialize(){
        inicio();
    }

    @FXML

    public void inicio(){
        cbRaza.getItems().addAll(
            "Saiyajin",
            "Humano",
            "Namekiano",
            "Androide",
            "Majin",
            "Freezer Race"
        );

    }

    @FXML
    public void agregarPersonaje(){
        
        try{

            String nombre = txtNombre.getText();
            String raza = cbRaza.getValue();
            int poder = Integer.parseInt(txtPoder.getText());
            String origen = txtOrigen.getText();
            String tecnica = txtTecnica.getText();
            int edad = Integer.parseInt(txtEdad.getText());

            Personaje p = new Personaje(
                nombre,
                raza,
                poder,
                origen,
                tecnica,
                edad
            );

            
            tablaPersonajes.add(new Label(p.getNombre()),0,fila);
            tablaPersonajes.add(new Label(p.getRaza()),1,fila);
            tablaPersonajes.add(new Label(String.valueOf(p.getNivelPoder())),2,fila);
            tablaPersonajes.add(new Label(p.getPlanetaOrigen()),3,fila);
            tablaPersonajes.add(new Label(p.getTecnicaEspecial()),4,fila);
            tablaPersonajes.add(new Label(String.valueOf(p.getEdad())),5,fila);

            fila++;

        }catch(Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Datos incorrectos");
            alert.show();
        }

    }

}
        

    

  