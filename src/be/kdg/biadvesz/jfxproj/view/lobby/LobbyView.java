package be.kdg.biadvesz.jfxproj.view.lobby;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LobbyView {
    //ATTRIB
    private Label lblName;
    private TextField tfName;
    private Button bHowTo;
    private Button bHighscores;
    private Button bPlay;

    //GET

    //SET

    //CTOR
    public LobbyView() {
        initNodes();
        layoutNodes();
    }

    //METHODS
    private void initNodes() {
        lblName = new Label();
    }
    private void layoutNodes() {

    }
}
