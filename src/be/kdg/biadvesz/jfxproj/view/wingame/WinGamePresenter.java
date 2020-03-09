package be.kdg.biadvesz.jfxproj.view.wingame;

import be.kdg.biadvesz.jfxproj.model.Lobby;
import be.kdg.biadvesz.jfxproj.model.WinGame;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyPresenter;
import be.kdg.biadvesz.jfxproj.view.lobby.LobbyView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class WinGamePresenter {
    //ATTRIB
    private WinGame model;
    private WinGameView view;

    public WinGamePresenter(WinGame model, WinGameView vieAw) {
        this.model = model;
        this.view = view;
        addEventHandlers();
    }

    private void addEventHandlers() {
//        view.getBtContinue().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //"POP-UP" SLUITEN
//
//            }
//        });
//        view.getBtExitGame().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //TODO
//                //GAME AFSLUTEN
//
//                Lobby lobbymodel = new Lobby();
//                LobbyView lobbyView = new LobbyView();
//                lobbymodel.setPlayerName(model.getPlayerName());
//                LobbyPresenter lobbyPresenter = new LobbyPresenter(lobbymodel, lobbyView);
//                view.getScene().setRoot(lobbyView);
//
//            }
//        });
//        view.getBtRestart().setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                //TODO
//                //NIEUW GAME STARTEN
//
//            }
//        });
    }
}
