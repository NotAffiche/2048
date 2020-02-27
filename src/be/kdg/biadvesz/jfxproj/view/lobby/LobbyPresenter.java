package be.kdg.biadvesz.jfxproj.view.lobby;

import be.kdg.biadvesz.jfxproj.model.Game;
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
        addEventHandlers();
        updateView();
    }

    //METHODS
    private void addEventHandlers() {
        view.getbPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (model.getPlayerName() == null) {
                    //todo replace this bullshit
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Name");
                    alert.setContentText("Please fill in a playername.");
                    alert.showAndWait();
                } else {
                    GameView gameView = new GameView(4);
                    Game gameModel = new Game(model.getPlayerName());
                    GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
                    view.getScene().setRoot(gameView);
                }
            }
        });
        view.getbHowTo().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HowToPlayView htpView = new HowToPlayView();
                HowToPlayPresenter htpPresenter = new HowToPlayPresenter(model, htpView);
                view.getScene().setRoot(htpView);
            }
        });
        view.getbHighscores().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HighscoreView highscoreView = new HighscoreView();
                HighscorePresenter highscorePresenter = new HighscorePresenter(model,highscoreView);
                view.getScene().setRoot(highscoreView);
            }
        });
        view.getTfName().setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                model.setPlayerName(view.getTfName().getText());
            }
        });
    }

    private void updateView() {
    }
}
