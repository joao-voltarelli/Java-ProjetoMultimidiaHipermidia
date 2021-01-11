package projetosmh;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.util.Duration;

public class MediaBar extends HBox {

	Duration ponto;
	Button botaoPlay;
	Label labelVolume;
	TextField comando;
	MediaPlayer player;
	Button botaoComando;
	Slider tempo, volume;
	PlayerMediaJavaFX teste;

	public MediaBar(MediaPlayer objetoPlayer, Imagens imagens) {
		
		tempo = new Slider();
		volume = new Slider();
		botaoPlay = new Button();
		comando = new TextField();
		labelVolume = new Label("Volume");
		botaoComando = new Button("Visualizar");
		
		getStylesheets().add("file:css/slider.css");
		
		botaoPlay.setStyle("-fx-background-image: url('file:midia//pause.png');" +
		   		   		   "-fx-background-repeat: no-repeat;" +
		           		   "-fx-background-position: center;" + 
		   		   		   "-fx-min-width: 28px; " +
						   "-fx-min-height: 28px;" +
		   		   		   "-fx-background-color: transparent;");
		
		player = objetoPlayer;
		
		tempo.setId("sliderTempo");

		setStyle("-fx-background-color: lightgray;");
		
		setMaxHeight(30);

		setAlignment(Pos.CENTER);
		
		volume.setPrefWidth(70); 
		volume.setMinWidth(30);
		volume.setValue(100);
		tempo.setValue(0);
		
		HBox.setHgrow(tempo, Priority.ALWAYS);

		getChildren().add(botaoPlay);
		getChildren().add(tempo);
		getChildren().add(labelVolume);
		getChildren().add(volume);
		getChildren().add(comando);
		getChildren().add(botaoComando);

		botaoComando.setOnAction((ActionEvent event) -> {

            if (comando.getText().equals("esconder pneu")) {
                imagens.pneu.setVisible(false);
                imagens.porcentagemP.setVisible(false);
            }

            else if (comando.getText().equals("mostrar pneu")) {
                imagens.pneu.setVisible(true);
                imagens.porcentagemP.setVisible(true);
            }

            else if (comando.getText().equals("esconder combustivel") || (comando.getText().equals("esconder gasolina"))) {
                imagens.combustivel.setVisible(false);
                imagens.porcentagemC.setVisible(false);
            }

            else if (comando.getText().equals("mostrar combustivel") || (comando.getText().equals("mostrar gasolina"))) {
                imagens.combustivel.setVisible(true);
                imagens.porcentagemC.setVisible(true);
            }

            else 
                comando.setText("Invalido, tente novamente");

        });

		botaoPlay.setOnAction((ActionEvent evento) -> {
			Status status = player.getStatus();

			if (status == Status.PLAYING) {
				updateValues();
				if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
					player.seek(player.getStartTime());
					player.play();
				} else {
					player.pause();
					botaoPlay.setStyle("-fx-background-image: url('file:midia//play.png');" +
			   		   		   "-fx-background-repeat: no-repeat;" +
			           		   "-fx-background-position: center;" + 
			   		   		   "-fx-min-width: 28px; " +
							   "-fx-min-height: 28px;" +
			   		   		   "-fx-background-color: transparent;");
				}
			}

			if (status == Status.HALTED || status == Status.STOPPED || status == Status.PAUSED) {
				player.play();
				botaoPlay.setStyle("-fx-background-image: url('file:midia//pause.png');" +
		   		   		   "-fx-background-repeat: no-repeat;" +
		           		   "-fx-background-position: center;" + 
		   		   		   "-fx-min-width: 28px; " +
						   "-fx-min-height: 28px;" +
		   		   		   "-fx-background-color: transparent;");
			}
		});

		player.currentTimeProperty().addListener((Observable observador) -> {
			updateValues();
		});

		volume.valueProperty().addListener((Observable observador) -> {
			if (volume.isPressed()) {
				player.setVolume(volume.getValue() / 100);
			}
		});
	}

	protected void updateValues() {
		Platform.runLater(() -> {
			tempo.setValue(player.getCurrentTime().toMillis()/player.getTotalDuration().toMillis()*100);
		});
	}
}
