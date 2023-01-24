package wordle.halpinsam;

import java.util.Arrays;

import javax.swing.JLabel;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class FXdriver extends Application {
	Feedback fback = new Feedback(5);
	final Game g = new Game();	
	String word = g.getWord();
	char[] wLetters = g.getLetters(word);
	String[]wLet = new String(wLetters).split("");
	
	
	@Override
	public void start(Stage stage) throws Exception {
		Font font1 = new Font("Arial", 25);
		Font font2 = new Font("Arial", 40);
		Font font3 = new Font("Arial", 20);
		
		Label title = new Label("WORDLE");
		title.setFont(font2);
		
		BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill background_fill2 = new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill background_fill3 = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
		
		
		HBox textHolder = new HBox(40);
		TextField text = new TextField();
		
		Background yellow = new Background(background_fill2);
		Background green = new Background(background_fill3);
		Background background = new Background(background_fill);
		
		Label won = new Label("");
		VBox holder = new VBox(100);
		HBox letters = new HBox(40);
		Label l1 = new Label("       -");
		l1.setBackground(background);
		l1.setMinSize(100, 100);
		l1.setFont(font1);
		Label l2 = new Label("       -");
		l2.setBackground(background);
		l2.setMinSize(100, 100);
		l2.setFont(font1);
		Label l3 = new Label("       -");
		l3.setBackground(background);
		l3.setMinSize(100, 100);
		l3.setFont(font1);
		Label l4 = new Label("       -");
		l4.setBackground(background);
		l4.setMinSize(100, 100);
		l4.setFont(font1);
		Label l5 = new Label("       -");
		l5.setBackground(background);
		l5.setMinSize(100, 100);
		l5.setFont(font1);
		
		Label[] labels = new Label[5];
		labels[0] = l1;
		labels[1] = l2;
		labels[2] = l3;
		labels[3] = l4;
		labels[4] = l5;

		Button newWrd = new Button("NEW WORD");
		Button btn = new Button("ENTER");
		newWrd.setFont(font3);
		btn.setFont(font3);
		
		newWrd.setOnAction(e -> {
			for (int i =0; i<word.length(); i++) {
				labels[i].setText("       -");
				labels[i].setBackground(background);
			}
			
			word = g.getWord();
			wLetters = g.getLetters(word);
			wLet = new String(wLetters).split("");
			won.setText("");
			
			
		});
		
		btn.setOnAction(e -> {
			String inWord = text.getText();
			char[] arr1 = inWord.toCharArray();
			String[] arr2 = new String(arr1).split("");
			
			fback.setFeedback(inWord, word);
			
			for (int i =0; i<word.length(); i++) {
				labels[i].setText("       " + arr2[i]);
				if (fback.getState(i) == TileState.CORRECT) {
					labels[i].setBackground(green);
				}
				else if(fback.getState(i) == TileState.INWORD) {
					labels[i].setBackground(yellow);
				}
				else if(fback.getState(i) == TileState.NOTINWORD) {
					labels[i].setBackground(background);
				}
			}
			
			
			if((l1.getBackground() == green)&&
					(l2.getBackground() == green)
					&&(l3.getBackground() == green)
					&&(l4.getBackground() == green)
					&&(l5.getBackground() == green)){
				won.setText("YOU WON");
			}
			
			
			
		});
		
		
		textHolder.getChildren().addAll(text,btn,newWrd);
		textHolder.setAlignment(Pos.CENTER);
	
		letters.getChildren().addAll(l1,l2,l3,l4,l5);
		letters.setAlignment(Pos.CENTER);
	
		holder.getChildren().addAll(title, letters, textHolder);
		holder.setAlignment(Pos.CENTER);
		holder.getChildren().add(won);
		Scene scene = new Scene(holder, 800, 800);
		stage.setScene(scene);
		
		stage.show(); 
		

	}
	

	public static void main(String[] args) {
		launch(args);

	}

}
