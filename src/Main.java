import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Puc Poker");
        titulo.getStyleClass().add("label");
        Button jogar = new Button("Jogar");
        Button sair = new Button("Sair");
        
         jogar.setOnAction(_ -> {
            
            System.out.println("Iniciando o jogo...");
        });

        sair.setOnAction(_ -> {
            stage.close();
        });

        VBox layout = new VBox(20, titulo, jogar,sair);
        layout.getStyleClass().add("vbox");
        
        Scene scene = new Scene(layout, 400, 300);

        // Aplica o CSS da pasta assets/css
        scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Poker FX");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
