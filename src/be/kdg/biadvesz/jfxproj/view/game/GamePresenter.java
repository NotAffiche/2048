package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.*;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.model.helpers.FileHelper;
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
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;

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
    //adds event listeners
    private void addEventListeners() {
        view.getBtLeave().setOnAction(actionEvent -> {
            //creates new screen
            Lobby lModel = new Lobby(model.getPlayername());
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
        view.getBtSave().setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Data File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("2048 Game files", "*.2048")
            );
            File selectedFile = fileChooser.showSaveDialog(view.getScene().getWindow());
            if ((selectedFile != null)) {
                FileHelper.saveGame(selectedFile, model);
            }
            view.requestFocus();
        });
        view.getBtLoad().setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load Data File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("2048 Game files", "*.2048")
            );
            File selectedFile = fileChooser.showOpenDialog(view.getScene().getWindow());
            if ((selectedFile != null) && (Files.isReadable(Paths.get(selectedFile.toURI())))) {
                FileHelper.loadGame(selectedFile, model);
                updateView();
            }
            view.requestFocus();
        });
    }
    //adds KEY events listeners (to keyboard buttons, has to be called explicitly otherwise the events do not work)
    public void addKeyEventHandlers() {
        //every movement key needs to have its own btUndo disable otherwise it'd get disabled on any key press
        view.requestFocus();
        view.getScene().setOnKeyPressed(keyEvent -> {
            if (!(keyEvent.getCode().equals(KeyCode.UP) || keyEvent.getCode().equals(KeyCode.LEFT) || keyEvent.getCode().equals(KeyCode.RIGHT) || keyEvent.getCode().equals(KeyCode.DOWN)))
                keyEvent.consume();
            if (!model.getState().equals(Gamestate.FINISHED)) {
                if (keyEvent.getCode().equals(KeyCode.UP)) {
                    if (!model.tryMove(Direction.UP)) {
                        keyEvent.consume();
                    }
                    view.getBtUndo().setDisable(false);
                } else if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                    if (!model.tryMove(Direction.DOWN)) {
                        keyEvent.consume();
                    }
                    view.getBtUndo().setDisable(false);
                } else if (keyEvent.getCode().equals(KeyCode.LEFT)) {
                    if (!model.tryMove(Direction.LEFT)) {
                        keyEvent.consume();
                    }
                    view.getBtUndo().setDisable(false);
                } else if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
                    if (!model.tryMove(Direction.RIGHT)) {
                        keyEvent.consume();
                    }
                    view.getBtUndo().setDisable(false);
                }
            }
            //try to end game
            model.attemptGameEnd();
            //update the actual view
            updateView();
        });
    }
    //updates the view
    public void updateView() {
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
        view.getLblHighscore().setText("Highscore:\n " + model.getHighscore());
        view.getLblScore().setText("Score:\n" + model.getScore());
        if (model.getState().equals(Gamestate.FINISHED)) {
            if (model.found2048()) {//win
                WinGame winGame = new WinGame(model.getPlayername());
                WinGameView winGameView = new WinGameView(model.getScore());
                WinGamePresenter winGamePresenter = new WinGamePresenter(winGame, winGameView, model, view, this);
                view.getScene().setRoot(winGameView);
            } else {//lose
                LoseGame loseGame = new LoseGame(model.getPlayername());
                LoseGameView loseGameView;
                if (model.found2048()) {
                    loseGameView = new LoseGameView(model.getScore(), true);
                } else {
                    loseGameView = new LoseGameView(model.getScore(), false);
                }
                LoseGamePresenter loseGamePresenter = new LoseGamePresenter(loseGame, loseGameView, model, view, this);
                view.getScene().setRoot(loseGameView);
                loseGamePresenter.addKeyEventHandlers();
            }
        }
    }
}
