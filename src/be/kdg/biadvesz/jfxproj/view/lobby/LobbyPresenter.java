package be.kdg.biadvesz.jfxproj.view.lobby;

import be.kdg.biadvesz.jfxproj.model.Game;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.game.GamePresenter;
import be.kdg.biadvesz.jfxproj.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LobbyPresenter {
    //ATTRIB
    private Lobby model;
    private LobbyView view;

    //CTOR
    public LobbyPresenter(Lobby model, LobbyView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    //METHODS
    private void addEventHandlers() {
        view.getbPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView gameView = new GameView();
                Game gameModel = new Game();
                GamePresenter gamePresenter = new GamePresenter(gameModel, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();
            }
        });
    }
}
