package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
        view.getScene().getWindow().addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        model.moveTiles(Direction.UP);
                        break;
                    case RIGHT:
                        model.moveTiles(Direction.RIGHT);
                        break;
                    case DOWN:
                        model.moveTiles(Direction.DOWN);
                        break;
                    case LEFT:
                        model.moveTiles(Direction.LEFT);
                        break;
                    default:
                        keyEvent.consume();
                        break;
                }
            }
        });
    }
    private void updateView() {

    }
}
