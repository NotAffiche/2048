package be.kdg.biadvesz.jfxproj.view.highscore;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HighscoreView extends BorderPane {
    //ATTRIB
    private Label lblTitel;
    private Label lbscorePname;

    private Button bgoback;

    //GETTERS
    public Button getBgoback() {
        return bgoback;
    }

    //SETTERS
    public void setBgoback(Button bgoback) {
        this.bgoback = bgoback;
    }

    //CONSTRUCTOR
    public HighscoreView() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        lblTitel = new Label("highscores");
        lbscorePname = new Label(String.format("%s %40s", "score", "playername"));
        bgoback = new Button("back");
    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        HBox hboxTitle = new HBox();
        HBox hboxNaamEnScore = new HBox();

        //ADD to HBOX
        hboxTitle.getChildren().add(lblTitel);
        hboxNaamEnScore.getChildren().addAll(lbscorePname);

        //FONTS
        lblTitel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        lbscorePname.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));

        //PADDINGS
        lblTitel.setPadding(new Insets(15, 0, 0, 0));
        lbscorePname.setPadding(new Insets(50, 0, 0, 0));

        //CREATE VBOX
        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(lbscorePname);

        //POSITIONS
        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxNaamEnScore.setAlignment(Pos.CENTER);
        super.setTop(hboxTitle);
        super.setCenter(mainBox);
        super.setBottom(bgoback);

        //BACKGROUND
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
