package be.kdg.biadvesz.jfxproj.view.wingame;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.winGame;
import be.kdg.biadvesz.jfxproj.view.game.GamePresenter;
import be.kdg.biadvesz.jfxproj.view.game.GameView;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class winGamePresenter {
    //ATTRIB
    private winGame model;
    private winGameView view;

    public winGamePresenter(winGame model, winGameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtContinue().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


            }
        });
        view.getBtExitGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Lobby lobbymodel = new Lobby();
                LobbyView lobbyView = new LobbyView();
                lobbymodel.setPlayerName(model.getPlayerName());
                LobbyPresenter lobbyPresenter = new LobbyPresenter(lobbymodel, lobbyView);
                view.getScene().setRoot(lobbyView);

            }
        });
        view.getBtRestart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


            }
        });
    }
}
