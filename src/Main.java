import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("BlackJack ");
        Button jogar = new Button("Jogar");
        Button sair = new Button("Sair");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        titulo.getStyleClass().add("label");

        VBox layout = new VBox(20, titulo, jogar, sair);
        layout.getStyleClass().add("vbox");

        Scene scene = new Scene(layout, screenBounds.getWidth() - 1, screenBounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Poker FX");
        stage.show();

        jogar.setOnAction(_ -> {
            
            DeckOfCards deck = new DeckOfCards();
            Dealer dealer = new Dealer();
            Jogador jogador1 = new Jogador("Jogador 1");
            //Jogador jogador2 = new Jogador("Jogador 2");
            

            blackJack bj = new blackJack(deck, dealer, jogador1);
            bj.startGUI(stage);

        });

        sair.setOnAction(_ -> {
            stage.close();
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
