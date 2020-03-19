package be.kdg.biadvesz.jfxproj;

import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        //set app image
        stage.getIcons().add(new Image("/2048_logo.png"));

        //create main screen
        LobbyView view = new LobbyView();
        Lobby model = new Lobby();
        LobbyPresenter lp = new LobbyPresenter(model, view);
        Scene lobbyScene = new Scene(view);
        lobbyScene.setFill(Color.BLACK);
        stage.setScene(lobbyScene);

        //config app size for all screens
        stage.setResizable(false);
        stage.setWidth(450);
        stage.setHeight(600);

        //display app
        stage.show();
    }
}
