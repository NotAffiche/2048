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
                    view.getGrid()[col][row].setStyle("-fx-background-color: rgb(204,192,178);");
                } else {
                    view.getGrid()[col][row].setText(Integer.toString(t.getValue()));
                    String hexCol = Integer.toString(t.getColor().getVal());
                    System.out.println(hexCol);
//                    view.getGrid()[col][row].setStyle(String.format("-fx-background-color: %f", t.getColor().getVal()));
                    if (t.getValue()==2 || t.getValue()==4) {
                        view.getGrid()[col][row].setStyle("-fx-text-fill: #766C62; -fx-alignment: center; -fx-font-size: 15px;");
                    } else {
                        view.getGrid()[row][col].setStyle("-fx-text-fill: #FFFFFF; -fx-alignment: center; -fx-font-size: 15px;");
                    }
                }
            }
        }
    }

}
