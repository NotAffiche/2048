package be.kdg.biadvesz.jfxproj.view.losegame;

import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.LoseGame;
import be.kdg.biadvesz.jfxproj.model.WinGame;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import be.kdg.biadvesz.jfxproj.view.wingame.WinGameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoseGamePresenter {
    //ATTRIB
    private LoseGame model;
    private LoseGameView view;

    public LoseGamePresenter(LoseGame model, WinGameView vieAw) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
        view.getBtExitGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //TODO
                //GAME AFSLUTEN

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
                //TODO
                //NIEUW GAME STARTEN

            }
        });
    }
}
