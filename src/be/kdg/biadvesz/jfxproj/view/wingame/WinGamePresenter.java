package be.kdg.biadvesz.jfxproj.view.wingame;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.WinGame;
import be.kdg.biadvesz.jfxproj.model.enums.Direction;
import be.kdg.biadvesz.jfxproj.model.enums.Gamestate;
import be.kdg.biadvesz.jfxproj.view.game.GamePresenter;
import be.kdg.biadvesz.jfxproj.view.game.GameView;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

public class WinGamePresenter {
    //ATTRIB
    private WinGame model;
    private WinGameView view;

    private Game oldGameModel;
    private GameView oldGameView;
    private GamePresenter oldGamePresenter;

    public WinGamePresenter(WinGame model, WinGameView view, Game gameModel, GameView gameView, GamePresenter gamePresenter) {
        this.model = model;
        this.view = view;
        this.oldGameModel = gameModel;
        this.oldGameView = gameView;
        this.oldGamePresenter = gamePresenter;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtContinue().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                oldGameModel.setState(Gamestate.CONTINUE);
                view.getScene().setRoot(oldGameView);
                oldGamePresenter.addKeyEventHandlers();
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
                GameView gameView = new GameView(oldGameModel.getGridSize());
                Game gameModel = new Game(model.getPlayerName(), oldGameModel.getGridSize());
                GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
                view.getScene().setRoot(gameView);
                gamePresenter.addKeyEventHandlers();
            }
        });
    }
}
