package be.kdg.biadvesz.jfxproj.view.wingame;

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

public class WinGameView extends BorderPane {
    //ATTRIB
    private Label lblWon;
    private Label lblText;
    private Button btContinue;
    private Button btExitGame;
    private Button btRestart;
    private int score;

    //GET
    Button getBtContinue() {
        return btContinue;
    }
    Button getBtExitGame() {
        return btExitGame;
    }
    Button getBtRestart() {
        return btRestart;
    }

    //CTOR
    public WinGameView(int score) {
        this.score = score;
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        //LABELS
        lblWon = new Label("Congratulations!");
        lblText = new Label("Congratulations, you have won 2048!\nFinal score: " + score);

        btContinue = new Button("Continue");
        btExitGame = new Button("Exit");
        btRestart = new Button("Restart");
    }

    private void layoutNodes() {
        //ALLROUND PADDING
        super.setPadding(new Insets(10));

        //HBOXES
        HBox hboxTitle = new HBox();
        HBox hboxText = new HBox();
        HBox hbbuttons = new HBox(12);


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //ADD TO HBOX
        hboxTitle.getChildren().add(lblWon);
        hboxText.getChildren().add(lblText);
        hbbuttons.getChildren().addAll(btExitGame,btContinue,btRestart);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //FONTS
        lblWon.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 50));
        lblText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 17));
        btContinue.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        btRestart.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        btExitGame.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //PADDINGS

        lblWon.setPadding(new Insets(40, 0, 0, 0));
        lblText.setPadding(new Insets(0, 0, 0, 0));

        hbbuttons.setPadding(new Insets(0, 0, 10, 0));


        btRestart.setPadding(new Insets(12, 30, 12, 30));
        btContinue.setPadding(new Insets(12, 30, 12, 30));
        btExitGame.setPadding(new Insets(12, 30, 12, 30));

        btExitGame.setMinWidth(125);
        btContinue.setMinWidth(125);
        btRestart.setMinWidth(125);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //COLORS
        btExitGame.setStyle("-fx-background-color: rgb(250, 211, 102)");
        btContinue.setStyle("-fx-background-color: rgb(250, 211, 102)");
        btRestart.setStyle("-fx-background-color: rgb(250, 211, 102)");




        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //VBOX
        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(lblText,hbbuttons);


        //POSITIONS
        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hbbuttons.setAlignment(Pos.BOTTOM_CENTER);
        mainBox.setAlignment(Pos.CENTER);


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        super.setTop(hboxTitle);
        super.setCenter(mainBox);
        super.setBottom(hbbuttons);
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));


    }
}
