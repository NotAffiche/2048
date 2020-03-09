package be.kdg.biadvesz.jfxproj.view.losegame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class LoseGameView extends BorderPane {
    private Label lblWon;
    private Label lblText;
    private Button btExitGame;
    private Button btRestart;
    private Image imRestart;
    private Image imExit;

    //GET
    public Button getBtExitGame() {
        return btExitGame;
    }

    public Button getBtRestart() {
        return btRestart;
    }

    //CTOR

    public LoseGameView() {

        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        //LABELS
        lblWon = new Label("You lose");
        lblText = new Label("sorry, you've lost the game");
        //IMAGES

        imExit = new Image(getClass().getResourceAsStream("exit.png"));
        imRestart = new Image(getClass().getResourceAsStream("restart.jpg"));
        //BUTTONS

        btExitGame = new Button("", new ImageView(imExit));
        btRestart = new Button("", new ImageView(imRestart));
    }

    private void layoutNodes() {
        //ALLROUND PADDING
        super.setPadding(new Insets(10));

        //HBOXES
        HBox hboxTitle = new HBox();
        HBox hboxText = new HBox();
        HBox hboxRestart = new HBox();
        HBox hboxContinue = new HBox();
        HBox hboxExit = new HBox();

        //ADD TO HBOX
        hboxTitle.getChildren().add(lblWon);
        hboxText.getChildren().add(lblText);
        hboxRestart.getChildren().add(btRestart);
        hboxExit.getChildren().add(btExitGame);

        //FONTS
        lblWon.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 62));
        lblText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

        //PADDINGS
        lblText.setPadding(new Insets(40, 0, 0, 0));
        lblWon.setPadding(new Insets(10, 0, 0, 0));


        //CEATE VBOX
        VBox mainbox = new VBox();
        mainbox.setPadding(new Insets(10));
        mainbox.getChildren().addAll(lblWon, lblText, btRestart, btExitGame);

        //POSITIONS
        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxText.setAlignment(Pos.CENTER);
        hboxRestart.setAlignment(Pos.BOTTOM_LEFT);
        hboxContinue.setAlignment(Pos.BOTTOM_CENTER);
        hboxExit.setAlignment(Pos.BOTTOM_RIGHT);

        super.setTop(hboxTitle);
        super.setCenter(mainbox);


        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
