package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GamePresenter {
    //ATTRIB
    private Game model;
    private GameView view;

    //CTOR
    public GamePresenter(Game mode, GameView view) {
        this.model = mode;
        this.view = view;
        addEventListeners();
        updateView();
    }

    //METHODS
    private void addEventListeners() {
        view.getBtLeave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Lobby lModel = new Lobby();
                LobbyView lView = new LobbyView();
                LobbyPresenter lp = new LobbyPresenter(lModel, lView);
                view.getScene().setRoot(lView);
            }
        });
        view.tmpbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                model.startGame();
            }
        });
    }
    private void updateView() {

    }
}
