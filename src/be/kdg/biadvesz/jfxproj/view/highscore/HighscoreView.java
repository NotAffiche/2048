package be.kdg.biadvesz.jfxproj.view.highscore;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HighscoreView extends BorderPane {
    //ATTRIB
    private Label lbTitle;
    private Button bgoback;
    private TableView tvHighScores;

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
        lbTitle = new Label("Highscores");
        bgoback = new Button("Back");
        tvHighScores = new TableView();

    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        HBox hboxTitle = new HBox();
        HBox hboxNaamEnScore = new HBox();
        HBox hboxbutton = new HBox();

        //ADD to HBOX
        hboxbutton.getChildren().addAll(bgoback);
        hboxTitle.getChildren().addAll(lbTitle);

        //FONTS
        lbTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        bgoback.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));

        //PADDINGS

        bgoback.setPadding(new Insets(12, 30, 12, 30));

        //table
        tvHighScores.setEditable(false);

        TableColumn rank = new TableColumn("Rank");
        TableColumn playername = new TableColumn("Playername");
        TableColumn highscore = new TableColumn("Score");
        tvHighScores.setMaxWidth(400);
        rank.setMaxWidth(50);
        rank.setMinWidth(50);
        playername.setMaxWidth(200);
        playername.setMinWidth(200);
        highscore.setMaxWidth(150);
        highscore.setMinWidth(150);

        tvHighScores.getColumns().addAll(rank, playername, highscore);

        //CREATE VBOX
        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(tvHighScores,hboxTitle);

        //POSITIONS
        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxNaamEnScore.setAlignment(Pos.CENTER);
        // hboxbutton.setAlignment(Pos.BOTTOM_RIGHT);


        super.setTop(hboxTitle);
        super.setCenter(mainBox);
        super.setBottom(bgoback);

        //BACKGROUND
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
