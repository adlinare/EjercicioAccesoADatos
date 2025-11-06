package com.prueba;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PersonaOController implements Initializable{

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnadd;

    @FXML
    private TableColumn<PersonaO, String> cApellido;

    @FXML
    private TableColumn<?, ?> cDni;

    @FXML
    private TableColumn<?, ?> cEdad;

    @FXML
    private TableColumn<?, ?> cNombre;

    @FXML
    private Label lError;

    @FXML
    private TableView<?> tPersona;

    @FXML
    private TextField tfAge;

    @FXML
    private TextField tfDni;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSurname;

    @FXML
    void oaAdd(ActionEvent event) {

    }

    @FXML
    void oaEdit(ActionEvent event) {

    }

    @FXML
    void oaMetodo(ActionEvent event) {

    }

    @FXML
    void oaPasarNormal(ActionEvent event) {
    	try {
			App.setRoot("Interfaz");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void oaProcedimiento(ActionEvent event) {

    }
    
    @FXML
    void oaDdl(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
