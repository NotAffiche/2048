package be.kdg.biadvesz.jfxproj.view.howtoplay;

import be.kdg.biadvesz.jfxproj.model.HowToPlay;
import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HowToPlayPresenter {
    //ATTRIB
    private HowToPlay model;
    private HowToPlayView view;

    //CTOR
    public HowToPlayPresenter(HowToPlay model, HowToPlayView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    //METHODS
    private void addEventHandlers() {
        view.getbGoBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Lobby lobbyModel = new Lobby(model.getPlayerName());
                LobbyView lobbyView = new LobbyView();
                LobbyPresenter lobbyPresenter = new LobbyPresenter(lobbyModel, lobbyView);
                view.getScene().setRoot(lobbyView);
            }
        });
    }
}
