package be.kdg.biadvesz.jfxproj.view.lobby;

import be.kdg.biadvesz.jfxproj.model.Lobby;

public class LobbyPresenter {
    private Lobby model;
    private LobbyView view;


    public LobbyPresenter(Lobby model, LobbyView view) {
        this.model = model;
        this.view = view;
    }

}
