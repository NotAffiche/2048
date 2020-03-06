package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.Tile;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;

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
                //ends game
                model.endGame();
                //creates new screen
                Lobby lModel = new Lobby();
                lModel.setPlayerName(model.getPlayername());
                LobbyView lView = new LobbyView();
                LobbyPresenter lp = new LobbyPresenter(lModel, lView);
                view.getScene().setRoot(lView);
            }
        });
    }
    private void updateView() {
        for (int row=0;row<model.getGrid().length;row++) {
            for (int col=0;col<model.getGrid()[row].length;col++) {
                Tile t = model.getGrid()[row][col];
                if (t==null) {
                    view.getGrid()[col][row].setText("");
                } else {
                    view.getGrid()[col][row].setText(Integer.toString(t.getValue()));
                    switch (t.getValue()) {
                        case 2:
                            break;
                        case 4:
                            break;
                        case 8:
                            break;
                        case 16:
                            break;
                        case 32:
                            break;
                        case 64:
                            break;
                        case 128:
                            break;
                        case 256:
                            break;
                        case 512:
                            break;
                        case 1024:
                            break;
                        case 2048:
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

}
