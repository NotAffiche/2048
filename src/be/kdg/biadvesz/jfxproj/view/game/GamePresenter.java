package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.*;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import be.kdg.biadvesz.jfxproj.view.losegame.LoseGamePresenter;
import be.kdg.biadvesz.jfxproj.view.losegame.LoseGameView;
import be.kdg.biadvesz.jfxproj.view.wingame.WinGamePresenter;
import be.kdg.biadvesz.jfxproj.view.wingame.WinGameView;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.Background;
import javafx.util.Duration;

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
        view.getBtLeave().setOnAction(actionEvent ->  {
            //ends game
            model.endGame();
            //creates new screen
            Lobby lModel = new Lobby();
            lModel.setPlayerName(model.getPlayername());
            LobbyView lView = new LobbyView();
            LobbyPresenter lp = new LobbyPresenter(lModel, lView);
            view.getScene().setRoot(lView);
        });
        view.getBtUndo().setOnAction(actionEvent -> {
            model.undo();
            view.getBtUndo().setDisable(true);
            view.requestFocus();
            updateView();
        });
    }

    public void addKeyEventHandlers() {
        view.requestFocus();
        view.getScene().setOnKeyPressed(keyEvent -> {
            if (model.getState().equals(Gamestate.ONGOING)) {
                if (keyEvent.getCode().equals(KeyCode.UP)) {
                    if (!model.tryMove(Direction.UP)) {
                        keyEvent.consume();
                    }
                } else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                    if (!model.tryMove(Direction.DOWN)) {
                        keyEvent.consume();
                    }
                } else if (keyEvent.getCode().equals(KeyCode.LEFT)) {
                    if (!model.tryMove(Direction.LEFT)) {
                        keyEvent.consume();
                    }
                } else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
                    if (!model.tryMove(Direction.RIGHT)) {
                        keyEvent.consume();
                    }
                }
                //debug
                else if (keyEvent.getCode().equals(KeyCode.N)) {
                    model.createTile(2048);
                }
                view.getBtUndo().setDisable(false);
            }
            //try to end game
            model.attemptGameEnd();
            //update the actual view
            updateView();
        });
    }
        private void updateView () {
            for (int row = 0; row < model.getGrid().length; row++) {
                for (int col = 0; col < model.getGrid()[row].length; col++) {
                    Tile t = model.getGrid()[row][col];
                    if (t == null) {
                        view.getGrid()[col][row].setText("");
                        view.getGrid()[col][row].setStyle("-fx-background-color: rgb(204,192,178);");
                    } else {
                        view.getGrid()[col][row].setText(Integer.toString(t.getValue()));
                        String hexCol = "#" + Integer.toHexString(t.getColor().getVal());
                        if (t.getValue() == 2 || t.getValue() == 4) {
                            view.getGrid()[col][row].setStyle("-fx-text-fill: #766C62; -fx-alignment: center; -fx-font-size: 24px; -fx-font-weight: bold; -fx-background-color: " + hexCol + ";");
                        } else {
                            view.getGrid()[col][row].setStyle("-fx-text-fill: #FFFFFF; -fx-alignment: center; -fx-font-size: 24px; -fx-font-weight: bold; -fx-background-color: " + hexCol + ";");
                        }
                    }
                }
            }
            view.getLblScore().setText("Score:\n" + model.getScore());
            if (model.getState().equals(Gamestate.FINISHED)) {
                if (model.found2048()) {//win
                    WinGame winGame = new WinGame(model.getPlayername());
                    WinGameView winGameView = new WinGameView();
                    WinGamePresenter winGamePresenter = new WinGamePresenter(winGame, winGameView, model, view, this);
                    view.getScene().setRoot(winGameView);
                } else {//lose
                    LoseGame loseGame = new LoseGame(model.getPlayername());
                    LoseGameView loseGameView = new LoseGameView();
                    LoseGamePresenter loseGamePresenter = new LoseGamePresenter(loseGame, loseGameView, model, view, this);
                    view.getScene().setRoot(loseGameView);
                    loseGamePresenter.addKeyEventHandlers();
                }
            }
            //draw debug roster
            System.out.println(" ");
            drawRoster();
        }

    // temp debug roster
    private void drawRoster() {
//        for (Tile[] rows : model.getGrid()) {
//            for (Tile t : rows) {
//                try {
//                    System.out.printf("%d ", t.getValue());
//                } catch (Exception ex) {
//                    System.out.print("0 ");
//                }
//            }
//            System.out.println(" ");
//        }
    }
}
