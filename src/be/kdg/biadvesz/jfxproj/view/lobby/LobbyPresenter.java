package be.kdg.biadvesz.jfxproj.view.lobby;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.game.GamePresenter;
import be.kdg.biadvesz.jfxproj.view.game.GameView;
import be.kdg.biadvesz.jfxproj.view.howtoplay.HowToPlayPresenter;
import be.kdg.biadvesz.jfxproj.view.howtoplay.HowToPlayView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

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
                GameView gameView = new GameView(4);
                Game gameModel = new Game();
                GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
                view.getScene().setRoot(gameView);
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
                Alert wip = new Alert(Alert.AlertType.INFORMATION);
                wip.setTitle("WIP");
                wip.setHeaderText("Work In Progress");
                wip.setContentText("Highscores are currently unavailable.");
                wip.showAndWait();
            }
        });
    }

    private void updateView() {
        view.getLblName().setText("2048 Game");
    }
}
