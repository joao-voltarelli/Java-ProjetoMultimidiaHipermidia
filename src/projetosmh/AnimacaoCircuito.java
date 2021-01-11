package projetosmh;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class AnimacaoCircuito {

	private float dx = (float) -1.2, dy = (float) 0.12;
	Button [] botao = new Button[11];
	Circle carro;

	void percorreCircuito(Scene scene, PlayerJFX objetoPlayer) {
            
		carro = new Circle(740, 52, 5);
		carro.setFill(Color.SILVER);

		final Group root = (Group) scene.getRoot();

		Timeline tl = new Timeline();
		tl.setCycleCount(Animation.INDEFINITE);
		initBtnsArray();

		botao[0].setLayoutX(699);
		botao[0].setLayoutY(50);

		botao[1].setLayoutX(655);
		botao[1].setLayoutY(55);

		botao[2].setLayoutX(687);
		botao[2].setLayoutY(32);

		botao[3].setLayoutX(748);
		botao[3].setLayoutY(12);

		botao[4].setLayoutX(805);
		botao[4].setLayoutY(10);

		botao[5].setLayoutX(914);
		botao[5].setLayoutY(26);

		botao[6].setLayoutX(940);
		botao[6].setLayoutY(94);

		botao[7].setLayoutX(855);
		botao[7].setLayoutY(55);

		botao[8].setLayoutX(883);
		botao[8].setLayoutY(125);

		botao[9].setLayoutX(863);
		botao[9].setLayoutY(195);

		botao[10].setLayoutX(805);
		botao[10].setLayoutY(75);

		KeyFrame moveCarro = new KeyFrame(Duration.seconds(.2000),
				new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {


				if(carro.getTranslateX() == -36.000001430511475 && carro.getTranslateY() == 3.5999999195337296) {
					root.getChildren().add(carro);
					root.getChildren().addAll(botao);
				}

				if(carro.getTranslateX() == -80.40000319480896 && carro.getTranslateY() == 8.039999820291996) {
					dx = (float) 0.7;
					dy =  (float) -0.5;
				}

				if(carro.getTranslateX() == -50.300003707408905 && carro.getTranslateY() == -13.460000179708004) {
					dx = (float) 3.5;
					dy =  (float) -1.2;
					
				}

				if(carro.getTranslateX() == 2.199996292591095 && carro.getTranslateY() == -31.46000089496374) {
					dx = (float) 1.5;
					dy =  (float) -0.7;
					
				}

				if(carro.getTranslateX() == 14.199996292591095 && carro.getTranslateY() == -37.06000079959631) {
					dx = (float) 1.5;
					dy =  (float) 0.7;
					
				}

				if(carro.getTranslateX() == 24.699996292591095 && carro.getTranslateY() == -32.16000088304281) {
					dx = (float) 2.5;
					dy =  (float) -0.3;
					
				}

				if(carro.getTranslateX() == 64.6999962925911 && carro.getTranslateY() == -36.960001073777676) {
					dx = (float) 2.2;
					dy =  (float) 0.3;
					
				}

				if(carro.getTranslateX() == 179.09999877214432 && carro.getTranslateY() == -21.36000045388937) {
					dx = (float) 0.2;
					dy =  (float) 1;
					
				}

				if(carro.getTranslateX() == 181.69999881088734 && carro.getTranslateY() == -8.36000045388937) {
					dx = (float) 1;
					dy =  (float) 0.3;
					
				}

				if(carro.getTranslateX() == 203.69999881088734 && carro.getTranslateY() == -1.760000191628933) {
					dx = (float) 0.4;
					dy =  (float) 1.7;
					
				}

				if(carro.getTranslateX() == 214.0999989658594 && carro.getTranslateY() == 42.44000104814768) {
					dx = (float) -1;
					dy =  (float) 0.5;
					
				}

				if(carro.getTranslateX() == 204.0999989658594 && carro.getTranslateY() == 47.44000104814768) {
					dx = (float) -1;
					dy =  (float) -0.5;
					
				}

				if(carro.getTranslateX() == 199.0999989658594 && carro.getTranslateY() == 44.94000104814768) {
					dx = (float) -0.1;
					dy =  (float) -0.8;
					
				}

				if(carro.getTranslateX() == 196.29999892413616 && carro.getTranslateY() == 22.540000714361668) {
					dx = (float) -1.6;
					dy =  (float) -0.3;
					
				}

				if(carro.getTranslateX() == 121.09999780356884 && carro.getTranslateY() == 8.440000154078007) {
					dx = (float) -0.6;
					dy =  (float) 1.3;
					
				} 

				if(carro.getTranslateX() == 110.2999973744154 && carro.getTranslateY() == 31.839999295771122) {
					dx = (float) 1.8;
					dy =  (float) 2.1;
					
				} 

				if(carro.getTranslateX() == 149.89999632537365 && carro.getTranslateY() == 78.03999719768763) {
					dx = (float) -0.6;
					dy =  (float) 1;
					
				} 

				if(carro.getTranslateX() == 136.09999577701092 && carro.getTranslateY() == 101.03999719768763) {
					dx = (float) 0.6;
					dy =  (float) 1;
					
				} 

				if(carro.getTranslateX() == 154.09999649226665 && carro.getTranslateY() == 131.03999719768763) {
					dx = (float) -1.2;
					dy =  (float) 0.9;
					
				}

				if(carro.getTranslateX() == 128.89999549090862 && carro.getTranslateY() == 149.9399966970086) {
					dx = (float) -1;
					dy =  (float) -1;
					
				}

				if(carro.getTranslateX() == 103.89999549090862 && carro.getTranslateY() == 124.93999669700861) {
					dx = (float) -1;
					dy =  (float) -5;
					
				}

				if(carro.getTranslateX() == 90.89999549090862 && carro.getTranslateY() == 59.93999669700861) {
					dx = (float) -1;
					dy =  (float) -1.5;
					
				}

				if(carro.getTranslateX() == 70.89999549090862 && carro.getTranslateY() == 29.93999669700861) {
					dx = (float) -1.7;
					dy =  (float) -0.24;
					
				}

				if(carro.getTranslateX() == 18.199994012713432 && carro.getTranslateY() == 22.49999686330557) {
					dx = (float) -1.7;
					dy =  (float) -1.4;
					
				}

				if(carro.getTranslateX() == -2.2000065594911575 && carro.getTranslateY() == 5.699997149407864) {
					dx = (float) 0.4;
					dy =  (float) -0.5;
					
				}

				if(carro.getTranslateX() == 2.1999935060739517 && carro.getTranslateY() == 0.19999714940786362) {
					dx = (float) -1;
					dy =  (float) 0.1;
					
				}

				if(carro.getTranslateX() == -31.80000649392605 && carro.getTranslateY() == 3.5999972000718117) {
					dx = (float) 0; dy = (float) 0; }

				botao[0].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.036762407111442345));

					carro.setTranslateX(-36.000001430511475);
					carro.setTranslateY(3.5999999195337296);

					root.getChildren().remove(carro);
					root.getChildren().removeAll(botao);

					dx = (float) -1.2;
					dy = (float) 0.12;

				});

				botao[1].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.09041937851587639));

					carro.setTranslateX(-80.40000319480896);
					carro.setTranslateY(8.039999820291996);

				});

				botao[2].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.15104753124450856));

					carro.setTranslateX(-50.300003707408905);
					carro.setTranslateY(-13.460000179708004);

				});

				botao[3].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.18329804686554635));

					carro.setTranslateX(14.199996292591095);
					carro.setTranslateY(-37.06000079959631);

				});

				botao[4].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.21414024302715018));

					carro.setTranslateX(64.6999962925911);
					carro.setTranslateY(-36.960001073777676);

				});

				botao[5].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.28758410283663144));

					carro.setTranslateX(179.09999877214432);
					carro.setTranslateY(-21.36000045388937);

				});

				botao[6].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.40229358648356554));

					carro.setTranslateX(204.0999989658594);
					carro.setTranslateY(47.44000104814768);

				});

				botao[7].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.5141141515579749));

					carro.setTranslateX(121.09999780356884);
					carro.setTranslateY(8.440000154078007);

				});

				botao[8].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.5679119549083523));

					carro.setTranslateX(149.89999632537365);
					carro.setTranslateY(78.03999719768763);

				});

				botao[9].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.6668463969335883));

					carro.setTranslateX(128.89999549090862);
					carro.setTranslateY(149.9399966970086);

				});

				botao[10].setOnAction((ActionEvent evento) -> {

					objetoPlayer.barraControle.player.seek(objetoPlayer.barraControle.player.getMedia().getDuration().multiply(0.7461347824997204));

					carro.setTranslateX(70.89999549090862);
					carro.setTranslateY(29.93999669700861);

				});
                                
                                Status status = objetoPlayer.player.getStatus();

                                if (status != Status.PAUSED) {
                                    carro.setTranslateX(carro.getTranslateX() + dx);
                                    carro.setTranslateY(carro.getTranslateY() + dy); 
                                }
			}
		});

		tl.getKeyFrames().add(moveCarro);
		tl.play();
	}
	
	public void encerraBotoes() {
		for (int i=0; i<botao.length; i++) {
			botao[i].setVisible(false);
		}
	}

	private void initBtnsArray() {
		for(int i = 0; i < botao.length; i++) {
			botao[i] = new Button("Button-"+i);
			botao[i].setStyle(
					"-fx-background-radius: 5em; " +
							"-fx-min-width: 10px; " +
							"-fx-min-height: 10px; " +
							"-fx-max-width: 10px; " +
							"-fx-max-height: 10px;" +
							"-fx-background-color: blue;" +
							"-fx-cursor: pointer;"
					);
		}
	}
}
