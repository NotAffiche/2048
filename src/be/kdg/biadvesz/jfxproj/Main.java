package be.kdg.biadvesz.jfxproj;

import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        LobbyView view = new LobbyView();
        Lobby model = new Lobby();
        LobbyPresenter lp = new LobbyPresenter(model, view);
        Scene lobbyScene = new Scene(view);
        stage.setScene(lobbyScene);
        stage.setResizable(false);
        stage.setWidth(450);
        stage.setHeight(600);
        stage.show();
    }
}
