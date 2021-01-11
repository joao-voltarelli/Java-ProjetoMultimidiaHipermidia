package projetosmh;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PlayerMediaJavaFX extends Application {

	Imagens imagens;
	PlayerJFX player;
	AnimacaoCircuito animacao;
	Timeline tempoC, tempoP, tempoPorcentagemC, tempoPorcentagemP, timelineFim;
	KeyFrame eventoC, eventoP, eventoPorcentagemC, eventoPorcentagemP, fim;

	private String URLVIDEO = "file:///C://temp//video.mp4";

	@Override
	public void start(Stage plano) throws Exception {

		imagens = new Imagens();
		animacao = new AnimacaoCircuito();
		player = new PlayerJFX(URLVIDEO, imagens);

		Group painel = new Group();
		painel.getChildren().add(player);
		Scene cena = new Scene(painel, 960, 540);

		animacao.percorreCircuito(cena, player);
		chama_eventos();

		painel.getChildren().addAll(imagens.combustivel, imagens.pneu, imagens.circuito, imagens.porcentagemC, imagens.porcentagemP);

		plano.setTitle("Projeto SMH - Monitoramento durante o percurso de um trajeto");
		plano.setScene(cena);
		plano.show();
	}

	public static void main(String[] args) {
		launch();
	}

	public void chama_eventos(){
		eventoC = new KeyFrame(Duration.millis(1000), tarefa -> atualizaCombustivel());
		tempoC = new Timeline(eventoC);
		tempoC.setCycleCount(Animation.INDEFINITE);
		tempoC.play();

		eventoP = new KeyFrame(Duration.millis(1000), tarefa -> atualizaPneu());
		tempoP = new Timeline(eventoP);
		tempoP.setCycleCount(Animation.INDEFINITE);
		tempoP.play();

		eventoPorcentagemC = new KeyFrame(Duration.millis(1000), tarefa -> atualizaPorcentagemC());
		tempoPorcentagemC = new Timeline(eventoPorcentagemC);
		tempoPorcentagemC.setCycleCount(Animation.INDEFINITE);
		tempoPorcentagemC.play();

		eventoPorcentagemP = new KeyFrame(Duration.millis(1000), tarefa -> atualizaPorcentagemP());
		tempoPorcentagemP = new Timeline(eventoPorcentagemP);
		tempoPorcentagemP.setCycleCount(Animation.INDEFINITE);
		tempoPorcentagemP.play();
		
		fim = new KeyFrame(Duration.millis(1000), tarefa ->  finalizaImagens());
		timelineFim = new Timeline(fim);
		timelineFim.setCycleCount(Animation.INDEFINITE);
		timelineFim.play();
	}
	
	public void finalizaImagens() {
		if(player.player.getCurrentTime().toSeconds() >= 123.535480651) {
			imagens.combustivel.setVisible(false);
			imagens.porcentagemC.setVisible(false);
			imagens.pneu.setVisible(false);
			imagens.porcentagemP.setVisible(false);
			imagens.circuito.setVisible(false);
			animacao.carro.setVisible(false);
			animacao.encerraBotoes();
		}
	}

	public KeyFrame atualizaCombustivel(){
		if(player.player.getCurrentTime().toSeconds() < 25)
			imagens.combustivel.setFill(Color.DARKGREEN);

		if(player.player.getCurrentTime().toSeconds() >= 25 && player.player.getCurrentTime().toSeconds() < 50)
			imagens.combustivel.setFill(Color.LIGHTGREEN);

		if(player.player.getCurrentTime().toSeconds() >= 50 && player.player.getCurrentTime().toSeconds() < 75)
			imagens.combustivel.setFill(Color.YELLOW);

		if(player.player.getCurrentTime().toSeconds() >= 75 && player.player.getCurrentTime().toSeconds() < 100)
			imagens.combustivel.setFill(Color.ORANGE);

		if(player.player.getCurrentTime().toSeconds() >= 100 && player.player.getCurrentTime().toSeconds() < 125)
			imagens.combustivel.setFill(Color.DARKORANGE);

		if(player.player.getCurrentTime().toSeconds() >= 125)
			imagens.combustivel.setFill(Color.RED);

		return null;
	}

	public KeyFrame atualizaPneu(){
		if(player.player.getCurrentTime().toSeconds() < 21)
			imagens.pneu.setFill(Color.DARKGREEN);

		if(player.player.getCurrentTime().toSeconds() >= 21 && player.player.getCurrentTime().toSeconds() < 42)
			imagens.pneu.setFill(Color.LIGHTGREEN);

		if(player.player.getCurrentTime().toSeconds() >= 42 && player.player.getCurrentTime().toSeconds() < 63)
			imagens.pneu.setFill(Color.YELLOW);

		if(player.player.getCurrentTime().toSeconds() >= 63 && player.player.getCurrentTime().toSeconds() < 84)
			imagens.pneu.setFill(Color.ORANGE);

		if(player.player.getCurrentTime().toSeconds() >= 84 && player.player.getCurrentTime().toSeconds() < 105)   
			imagens.pneu.setFill(Color.DARKORANGE);

		if(player.player.getCurrentTime().toSeconds() >= 105 && player.player.getCurrentTime().toSeconds() < 126)
			imagens.pneu.setFill(Color.RED);

		if(player.player.getCurrentTime().toSeconds() >= 126)
			imagens.pneu.setFill(Color.DARKRED);

		return null;
	}

	public KeyFrame atualizaPorcentagemC(){
		if(player.player.getCurrentTime().toSeconds() < 10){
			imagens.nivel_combustivel = 45;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 10 && player.player.getCurrentTime().toSeconds() < 20){
			imagens.nivel_combustivel = 44;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 20 && player.player.getCurrentTime().toSeconds() < 30){
			imagens.nivel_combustivel = 43;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 30 && player.player.getCurrentTime().toSeconds() < 40){
			imagens.nivel_combustivel = 42;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 40 && player.player.getCurrentTime().toSeconds() < 50){
			imagens.nivel_combustivel = 41;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 50 && player.player.getCurrentTime().toSeconds() < 60){
			imagens.nivel_combustivel = 40;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 60 && player.player.getCurrentTime().toSeconds() < 70){
			imagens.nivel_combustivel = 39;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 70 && player.player.getCurrentTime().toSeconds() < 80){
			imagens.nivel_combustivel = 38;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 80 && player.player.getCurrentTime().toSeconds() < 90){
			imagens.nivel_combustivel = 37;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 90 && player.player.getCurrentTime().toSeconds() < 100){
			imagens.nivel_combustivel = 36;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 100 && player.player.getCurrentTime().toSeconds() < 110){
			imagens.nivel_combustivel = 35;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 110 && player.player.getCurrentTime().toSeconds() < 120){
			imagens.nivel_combustivel = 34;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 120 && player.player.getCurrentTime().toSeconds() < 130){
			imagens.nivel_combustivel = 33;
			imagens.porcentagemC.setText(Integer.toString(imagens.nivel_combustivel) + "%");
		}

		return null;
	}

	public KeyFrame atualizaPorcentagemP(){
		if(player.player.getCurrentTime().toSeconds() < 8){
			imagens.desgaste_pneu = 70;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 8 && player.player.getCurrentTime().toSeconds() < 16){
			imagens.desgaste_pneu = 71;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 16 && player.player.getCurrentTime().toSeconds() < 24){
			imagens.desgaste_pneu = 72;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 24 && player.player.getCurrentTime().toSeconds() < 32){
			imagens.desgaste_pneu = 73;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 32 && player.player.getCurrentTime().toSeconds() < 40){
			imagens.desgaste_pneu = 74;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 40 && player.player.getCurrentTime().toSeconds() < 48){
			imagens.desgaste_pneu = 75;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 48 && player.player.getCurrentTime().toSeconds() < 56){
			imagens.desgaste_pneu = 76;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 56 && player.player.getCurrentTime().toSeconds() < 64){
			imagens.desgaste_pneu = 77;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 64 && player.player.getCurrentTime().toSeconds() < 72){
			imagens.desgaste_pneu = 78;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 72 && player.player.getCurrentTime().toSeconds() < 80){
			imagens.desgaste_pneu = 79;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 80 && player.player.getCurrentTime().toSeconds() < 88){
			imagens.desgaste_pneu = 80;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 88 && player.player.getCurrentTime().toSeconds() < 96){
			imagens.desgaste_pneu = 81;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 96 && player.player.getCurrentTime().toSeconds() < 104){
			imagens.desgaste_pneu = 82;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 104 && player.player.getCurrentTime().toSeconds() < 112){
			imagens.desgaste_pneu = 83;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 112 && player.player.getCurrentTime().toSeconds() < 120){
			imagens.desgaste_pneu = 84;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 120 && player.player.getCurrentTime().toSeconds() < 128){
			imagens.desgaste_pneu = 85;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		if(player.player.getCurrentTime().toSeconds() >= 128){
			imagens.desgaste_pneu = 86;
			imagens.porcentagemP.setText(Integer.toString(imagens.desgaste_pneu) + "%");
		}

		return null;
	}

}
