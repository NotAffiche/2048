package be.kdg.biadvesz.jfxproj.view.wingame;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class winGameView extends BorderPane {
    private Label lblWon;
    private Label lblText;
    private Button btContinue;
    private Button btExitGame;
    private Button btRestart;
    private Image imContinue;
    private Image imRestart;
    private Image imExit;

    //GET
    public Button getBtContinue() {
        return btContinue;
    }

    public Button getBtExitGame() {
        return btExitGame;
    }

    public Button getBtRestart() {
        return btRestart;
    }

    //CTOR

    public winGameView() {

        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        //LABELS
        lblWon = new Label("Congratulations");
        lblText = new Label("Congratulations, you have won 2048!");
        //IMAGES
        imContinue = new Image(getClass().getResourceAsStream("continue.png"));
        imExit = new Image(getClass().getResourceAsStream("exit.png"));
        imRestart = new Image(getClass().getResourceAsStream("restart.jpg"));
        //BUTTONS
        btContinue = new Button("", new ImageView(imContinue));
        btExitGame = new Button("", new ImageView(imExit));
        btRestart = new Button("", new ImageView(imRestart));

    }

    private void layoutNodes() {
    }
}
