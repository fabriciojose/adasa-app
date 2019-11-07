package controladores;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

public class ControladorPrincipal {

	@FXML AnchorPane apPrincipal;
	Pane pMenu;
	WebView wv;

	BorderPane bpSuperior;

	Button btnMenu, btnLogo, btnShare;

	TranslateTransition trDireitaMenu, trEsquerdaMenu;

	TranslateTransition trSubirMapa, trCentralizarMapa, trDescerMapa;

	TranslateTransition trSubirYoutube, trCentralizarYoutube, trDescerYoutube;

	TranslateTransition trSubirSEI, trCentralizarSEI, trDescerSEI;

	TranslateTransition trSubirAtendimento, trDescerAtendimento;


	Double dblMenu, dblMapa, dblYoutube, dblAtendimento;

	AnchorPane pMapa, pYoutube, pSEI;
	AnchorPane pLateral;
	Pane pAtendimento;

	@FXML 
	private void initialize() {

		Platform.runLater(new Runnable(){

			public void run() {

				// O nó em sí, que será mostrado
				WebView wvMapa = new WebView();
				WebEngine weMapa = wvMapa.getEngine();
				weMapa.load(getClass().getResource("/html/mapMarker.html").toExternalForm()); // originalMap

				AnchorPane.setTopAnchor(wvMapa, 0.0);
				AnchorPane.setLeftAnchor(wvMapa , 0.0);
				AnchorPane.setRightAnchor(wvMapa , 0.0);
				AnchorPane.setBottomAnchor(wvMapa, 0.0);

				pMapa.getChildren().add(wvMapa);


				// O nó em sí, que será mostrado
				WebView wvYoutube = new WebView();
				WebEngine weYoutube = wvYoutube.getEngine();
				weYoutube.load(getClass().getResource("/html/youtube.html").toExternalForm()); // originalMap

				AnchorPane.setTopAnchor(wvYoutube, 0.0);
				AnchorPane.setLeftAnchor(wvYoutube , 0.0);
				AnchorPane.setRightAnchor(wvYoutube , 0.0);
				AnchorPane.setBottomAnchor(wvYoutube, 0.0);

				pYoutube.getChildren().add(wvYoutube);


				// O nó em sí, que será mostrado
				WebView webViewSEI = new WebView();
				// A engine é do tipo WebEngine
				webViewSEI.getEngine().load("https://sei.df.gov.br/sip/login.php?sigla_orgao_sistema=GDF&sigla_sistema=SEI");

				AnchorPane.setTopAnchor(webViewSEI, 0.0);
				AnchorPane.setLeftAnchor(webViewSEI , 0.0);
				AnchorPane.setRightAnchor(webViewSEI , 0.0);
				AnchorPane.setBottomAnchor(webViewSEI, 0.0);

				pSEI.getChildren().add(webViewSEI);

			}

		});

		pMapa = new AnchorPane();
		//pMapa.setStyle("-fx-background-color: yellow");
		pMapa.setPrefSize(800, 600);

		AnchorPane.setTopAnchor(pMapa, 0.0);
		AnchorPane.setLeftAnchor(pMapa, 0.0);
		AnchorPane.setRightAnchor(pMapa, 0.0);
		AnchorPane.setBottomAnchor(pMapa, 0.0);

		pYoutube = new AnchorPane();
		//pYoutube.setStyle("-fx-background-color: pink");
		pYoutube.setPrefSize(800, 200);
		pYoutube.setTranslateY(-1100.0);

		AnchorPane.setTopAnchor(pYoutube, 0.0);
		AnchorPane.setLeftAnchor(pYoutube, 0.0);
		AnchorPane.setRightAnchor(pYoutube, 0.0);
		AnchorPane.setBottomAnchor(pYoutube, 0.0);

		pSEI = new AnchorPane();
		//pSEI.setStyle("-fx-background-color: #00ffbf");
		pSEI.setPrefSize(800, 200);
		pSEI.setTranslateY(1100.0);

		AnchorPane.setTopAnchor(pSEI, 0.0);
		AnchorPane.setLeftAnchor(pSEI, 0.0);
		AnchorPane.setRightAnchor(pSEI, 0.0);
		AnchorPane.setBottomAnchor(pSEI, 0.0);

		apPrincipal.getChildren().addAll(pYoutube, pSEI, pMapa);

		pLateral = new AnchorPane();
		//pLateral.setStyle("-fx-background-color: brown");
		pLateral.setPrefSize(90, 300);

		trSubirMapa = new TranslateTransition(new Duration(350), pMapa);
		trSubirMapa.setToY(-1050);
		trCentralizarMapa = new TranslateTransition(new Duration(350), pMapa);
		trCentralizarMapa.setToY(0.0);
		trDescerMapa = new TranslateTransition(new Duration(350), pMapa);
		trDescerMapa.setToY(1050.0);

		trSubirYoutube = new TranslateTransition(new Duration(350), pYoutube);
		trSubirYoutube.setToY(-1050.0);
		trCentralizarYoutube = new TranslateTransition(new Duration(350), pYoutube);
		trCentralizarYoutube.setToY(0.0);
		trDescerYoutube = new TranslateTransition(new Duration(350), pYoutube);
		trDescerYoutube.setToY(1050.0);

		trSubirSEI = new TranslateTransition(new Duration(350), pSEI);
		trSubirSEI.setToY(-1050.0);
		trCentralizarSEI = new TranslateTransition(new Duration(350), pSEI);
		trCentralizarSEI.setToY(0.0);
		trDescerSEI = new TranslateTransition(new Duration(350), pSEI);
		trDescerSEI.setToY(1050.0);


		Button btnYoutube = new Button("Youtube");
		btnYoutube.setPrefSize(90, 30);
		btnYoutube.setLayoutY(0.0);


		Button btnMapa = new Button("Mapa");
		btnMapa.setPrefSize(90, 30);
		btnMapa.setLayoutY(30.0);

		Button btnSEI = new Button("SEI");
		btnSEI.setPrefSize(90, 30);
		btnSEI.setLayoutY(60.0);

		Button btnAtendimento = new Button("Atendimento");
		btnAtendimento.setPrefSize(90, 30);
		btnAtendimento.setLayoutY(90.0);

		btnMapa.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				movimentarFundo ("pMapa");

			}
		});

		btnYoutube.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				movimentarFundo("pYoutube");

			}
		});

		btnSEI.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				movimentarFundo ("pSEI");

			}
		});

		pLateral.getChildren().addAll(btnYoutube, btnMapa, btnSEI, btnAtendimento);

		AnchorPane.setTopAnchor(pLateral, 250.0);
		AnchorPane.setLeftAnchor(pLateral, 10.0);
		AnchorPane.setBottomAnchor(pLateral, 250.0);

		apPrincipal.getChildren().add(pLateral);

		bpSuperior = new BorderPane();
		//bpSuperior.setStyle("-fx-background-color: red");
		bpSuperior.setPrefSize(20, 80);

		AnchorPane.setTopAnchor(bpSuperior, 0.0);
		AnchorPane.setLeftAnchor(bpSuperior, 0.0);
		AnchorPane.setRightAnchor(bpSuperior, 0.0);

		apPrincipal.getChildren().add(bpSuperior);

		btnMenu = new Button("Menu");
		btnMenu.setPrefSize(30, 30);

		btnLogo = new Button("Logo");
		btnLogo.setPrefSize(30, 30);

		btnShare = new Button("Share");
		btnShare.setPrefSize(30, 30);

		bpSuperior.setLeft(btnMenu);
		bpSuperior.setCenter(btnLogo);
		bpSuperior.setRight(btnShare);

		btnMenu.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				if (pMenu == null) {

					pMenu = new Pane();
					pMenu.getStyleClass().add("pane-class");


					//pMenu.setStyle("-fx-background-color: blue");
					pMenu.setPrefSize(300, 300);

					pMenu.setTranslateX(-305.0);

					apPrincipal.getChildren().add(pMenu);

					AnchorPane.setTopAnchor(pMenu, 0.0);
					AnchorPane.setBottomAnchor(pMenu, 0.0);

					trDireitaMenu = new TranslateTransition(new Duration(350), pMenu);
					trDireitaMenu.setToX(0.0);
					trEsquerdaMenu = new TranslateTransition(new Duration(350), pMenu);
					trEsquerdaMenu.setToX(-305.0);

					Button btnMenuInterno = new Button("X");

					btnMenuInterno.setPrefSize(30, 30);

					btnMenuInterno.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent e) {

							trEsquerdaMenu.play();
						}
					});

					pMenu.getChildren().add(btnMenuInterno);

				}

				dblMenu =  pMenu.getTranslateY();

				if(dblMenu.equals(0.0)){

					trDireitaMenu.play(); 
				}
				else {
					trEsquerdaMenu.play();
				}

			}
		});

		btnAtendimento.setOnAction((ActionEvent evt)->{

			if (pAtendimento == null ) {

				pAtendimento = new Pane();

				trDescerAtendimento = new TranslateTransition(new Duration(350), pAtendimento);
				trDescerAtendimento.setToY(880.0);
				trSubirAtendimento = new TranslateTransition(new Duration(350), pAtendimento);
				trSubirAtendimento.setToY(0.0);

				AnchorPane.setTopAnchor(pAtendimento, 150.0);

				apPrincipal.widthProperty().addListener((obs, oldVal, newVal) -> {
					//System.out.println("listener " + (Double) newVal  * 0.16);

					Double dbl = ((Double) newVal  * 0.16);

					AnchorPane.setLeftAnchor(pAtendimento, dbl);
					AnchorPane.setRightAnchor(pAtendimento, dbl);

					/*
					 * listener 216.0 tela de 15", notebook
					 *	listener 307.2 tela de 22", monitor 
					 */

				});

				AnchorPane.setLeftAnchor(pAtendimento, 307.2);
				AnchorPane.setRightAnchor(pAtendimento, 307.2);


				AnchorPane.setBottomAnchor(pAtendimento, 115.0);

				pAtendimento.setTranslateY(880.0);

				pAtendimento.setMinWidth(3000.0);

				apPrincipal.getChildren().add(pAtendimento);

				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Atendimento.fxml"));
				Pane p = new  Pane();
				loader.setRoot(p);
				loader.setController(new ControladorAtendimento());
				try {
					loader.load();
				} catch (IOException e) {
					System.out.println("erro na abertura do pane outorga");
					e.printStackTrace();
				}
				pAtendimento.getChildren().add(p);

				p.setStyle("-fx-background-color: blue");

				p.minWidthProperty().bind(pAtendimento.widthProperty());
				p.minHeightProperty().bind(pAtendimento.heightProperty());

				p.maxWidthProperty().bind(pAtendimento.widthProperty());
				p.maxHeightProperty().bind(pAtendimento.heightProperty());


			}

			dblAtendimento =  pAtendimento.getTranslateY();

			if(dblAtendimento.equals(0.0)){
				trDescerAtendimento.play();

			} else {

				trSubirAtendimento.play();



			}

		});



	}

	public void	movimentarFundo (String strPane){

		if(strPane.equals("pMapa")){

			trSubirYoutube.play();
			trCentralizarMapa.play(); 
			trDescerSEI.play();

		}

		else if (strPane.equals("pYoutube")) {

			trDescerMapa.play();
			trCentralizarYoutube.play();
			trDescerSEI.play();

		}

		else {

			trCentralizarSEI.play();
			trSubirMapa.play();
			trSubirYoutube.play();
		}

	}

}
