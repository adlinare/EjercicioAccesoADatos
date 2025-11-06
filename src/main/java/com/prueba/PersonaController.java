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
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonaController implements Initializable {

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnadd;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private TableColumn<Persona, String> cApellido;

    @FXML
    private TableColumn<Persona, String> cDni;

    @FXML
    private TableColumn<Persona, Integer> cEdad;

    @FXML
    private TableColumn<Persona, String> cNombre;

    @FXML
    private Label lError;

    @FXML
    private TableView<Persona> tPersona;

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
    	lError.setStyle("-fx-text-fill: red;");
    	if(tfDni.getText().isBlank() || tfName.getText().isBlank() ||tfSurname.getText().isBlank() ||tfAge.getText().isBlank()) {
    		lError.setText("Debes rellenar todos los campos");
    	} else {
    		PersonaDAO pdao = new PersonaDAO();
        	Persona p = new Persona(tfDni.getText(), tfName.getText(), tfSurname.getText(), Integer.parseInt(tfAge.getText()));
        	lError.setText(pdao.add(p));
        	initialize(null, null);
    	}
    	
    }

    @FXML
    void oaEdit(ActionEvent event) {
    	PersonaDAO pdao = new PersonaDAO();
    	Persona p = new Persona(tfDni.getText(), tfName.getText(), tfSurname.getText(), Integer.parseInt(tfAge.getText()));
    	lError.setStyle("-fx-text-fill: red;");
    	lError.setText(pdao.update(p));
    	initialize(null, null);
    	

    }

    @FXML
    void oaMetodo(ActionEvent event) {

    }

    @FXML
    void oaPasarObjeto(ActionEvent event) {
    	try {
			App.setRoot("Interfaz2");
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
    	PersonaDAO pdao = new PersonaDAO();
    	lError.setStyle("-fx-text-fill: red;");
    	lError.setText(pdao.crearDDL());

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btnCancelar.setDisable(true);
		btnEdit.setDisable(true);
		tfDni.setText("");
		tfName.setText("");
		tfSurname.setText("");
		tfAge.setText("");
		
		PersonaDAO pdao = new PersonaDAO();
		cDni.setCellValueFactory(new PropertyValueFactory<Persona,String>("dni"));
	    cNombre.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
	    cApellido.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellido"));
	    cEdad.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("edad"));
		
		tPersona.setItems(pdao.getAll());
		
		
	}
	
	@FXML
    void oaCliked() {
		Persona pselec = tPersona.getSelectionModel().getSelectedItem();
		if (pselec != null) {
			btnCancelar.setDisable(false);
			btnEdit.setDisable(false);
			tfDni.setDisable(true);
			tfDni.setText(pselec.getDni());
			tfName.setText(pselec.getNombre());
			tfSurname.setText(pselec.getApellido());
			tfAge.setText(String.valueOf(pselec.getEdad()));
		}

    }
	
	@FXML
    void oaCancelarE(ActionEvent event) {
		btnEdit.setDisable(true);
		btnCancelar.setDisable(true);
		tfDni.setDisable(false);
		tfDni.setText("");
		tfName.setText("");
		tfSurname.setText("");
		tfAge.setText("");
    }

}
