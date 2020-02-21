package be.kdg.biadvesz.jfxproj.view.game;

import be.kdg.biadvesz.jfxproj.model.Game;

public class GamePresenter {
    private Game model;
    private GameView view;

    public GamePresenter(Game mode, GameView view) {
        this.model = mode;
        this.view = view;
    }
}
