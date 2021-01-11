package projetosmh;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class PlayerJFX extends BorderPane {
	
	Media video;
	StackPane painel; 
	MediaPlayer player;
	MediaView visualizador;
	MediaBar barraControle;

	final DoubleProperty width, height;

	public PlayerJFX(String file, Imagens imagens) { 

		video = new Media(file); 
		painel = new StackPane();
		player = new MediaPlayer(video);
		visualizador = new MediaView(player);
		
		painel.getChildren().add(visualizador);
		
		width = visualizador.fitWidthProperty();
		height = visualizador.fitHeightProperty();

		visualizador.setPreserveRatio(true);
		
		width.bind(Bindings.selectDouble(visualizador.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(visualizador.sceneProperty(), "height"));

		setCenter(painel);
		barraControle = new MediaBar(player, imagens); 
		painel.setAlignment(Pos.BOTTOM_CENTER);
		painel.getChildren().add(barraControle);
		setStyle("-fx-background-color:#bfc2c7"); 
		player.play(); 
		
	}
}
