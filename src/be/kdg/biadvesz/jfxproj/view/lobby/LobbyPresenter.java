package be.kdg.biadvesz.jfxproj.view.lobby;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Highscore;
import be.kdg.biadvesz.jfxproj.model.HowToPlay;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.game.GamePresenter;
import be.kdg.biadvesz.jfxproj.view.game.GameView;
import be.kdg.biadvesz.jfxproj.view.highscore.HighscorePresenter;
import be.kdg.biadvesz.jfxproj.view.highscore.HighscoreView;
import be.kdg.biadvesz.jfxproj.view.howtoplay.HowToPlayPresenter;
import be.kdg.biadvesz.jfxproj.view.howtoplay.HowToPlayView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;

public class LobbyPresenter {
    //ATTRIB
    private Lobby model;
    private LobbyView view;

    //CTOR
    public LobbyPresenter(Lobby model, LobbyView view) {
        this.model = model;
        this.view = view;
        if (model.getPlayerName() != null) {
            view.getTfName().setText(model.getPlayerName());
            view.getbPlay().setDisable(false);
        }
        addEventHandlers();
        updateView();
    }

    //METHODS
    private void addEventHandlers() {
        view.getbPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView gameView = new GameView(4);
                Game gameModel = new Game(model.getPlayerName(), 4);
                GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
                view.getScene().setRoot(gameView);
                gamePresenter.addKeyEventHandlers();
            }
        });
        view.getbHowTo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HowToPlayView htpView = new HowToPlayView();
                HowToPlay htpModel = new HowToPlay(model.getPlayerName());
                HowToPlayPresenter htpPresenter = new HowToPlayPresenter(htpModel, htpView);
                view.getScene().setRoot(htpView);
            }
        });
        view.getbHighscores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HighscoreView highscoreView = new HighscoreView();
                Highscore hsModel = new Highscore(model.getPlayerName());
                HighscorePresenter highscorePresenter = new HighscorePresenter(hsModel,highscoreView);
                view.getScene().setRoot(highscoreView);
            }
        });
        view.getTfName().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                model.setPlayerName(view.getTfName().getText());
                if (model.getPlayerName() != null && !model.getPlayerName().isBlank() && !model.getPlayerName().isEmpty()) {
                    view.getbPlay().setDisable(false);
                } else {
                    view.getbPlay().setDisable(true);
                }
            }
        });
    }

    private void updateView() {
    }
}
