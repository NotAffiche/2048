package be.kdg.biadvesz.jfxproj.view.losegame;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.LoseGame;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.view.game.GamePresenter;
import be.kdg.biadvesz.jfxproj.view.game.GameView;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import be.kdg.biadvesz.jfxproj.view.wingame.WinGameView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoseGamePresenter {
    //ATTRIB
    private LoseGame model;
    private LoseGameView view;

    private Game oldGameModel;
    private GameView oldGameView;
    private GamePresenter oldGamePresenter;

    public LoseGamePresenter(LoseGame model, LoseGameView view, Game gameModel, GameView gameView, GamePresenter gamePresenter) {
        this.model = model;
        this.view = view;
        this.oldGameModel = gameModel;
        this.oldGameView = gameView;
        this.oldGamePresenter = gamePresenter;
        addEventHandlers();
        addKeyEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtExitGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                oldGameModel.endGame();
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
                GameView gameView = new GameView(oldGameModel.getGridSize());
                Game gameModel = new Game(model.getPlayerName(), oldGameModel.getGridSize());
                GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
                view.getScene().setRoot(gameView);
                gamePresenter.addKeyEventHandlers();
            }
        });
    }

    public void addKeyEventHandlers() {
        view.requestFocus();
        view.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                keyEvent.consume();
            }
        });
    }
}
