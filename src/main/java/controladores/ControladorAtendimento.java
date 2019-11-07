package controladores;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class ControladorAtendimento {
	
	@FXML Pane pAtendimento;
	@FXML TabPane tpAtendimento;
	
	@FXML 
    private void initialize() {
		
		tpAtendimento.prefWidthProperty().bind(pAtendimento.widthProperty());
		tpAtendimento.prefHeightProperty().bind(pAtendimento.heightProperty());
		
	}
	
}
