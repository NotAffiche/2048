package be.kdg.biadvesz.jfxproj.view.highscore;

import be.kdg.biadvesz.jfxproj.model.Highscore;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.howtoplay.HowToPlayView;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HighscorePresenter {

    private Highscore model;
    private HighscoreView view;

    public HighscorePresenter(Highscore model, HighscoreView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }


    private void addEventHandlers() {
        view.getBgoback().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Lobby lobbyModel = new Lobby();
                LobbyView lobbyView = new LobbyView();
                lobbyModel.setPlayerName(model.getPlayerName());
                LobbyPresenter lobbyPresenter = new LobbyPresenter(lobbyModel, lobbyView);
                view.getScene().setRoot(lobbyView);
            }
        });
    }

}