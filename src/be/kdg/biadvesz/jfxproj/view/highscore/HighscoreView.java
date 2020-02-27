package be.kdg.biadvesz.jfxproj.view.highscore;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HighscoreView extends BorderPane {
    //ATTRIB
    private Label lblTitel;
    private Label lbscore;
    private Label lbName;
    private TextField tfscore;
    private Button bgoback;

    //GETTERS
    public Label getLblTitel() {
        return lblTitel;
    }

    public Label getLbscore() {
        return lbscore;
    }

    public TextField getTfscore() {
        return tfscore;
    }

    public Button getBgoback() {
        return bgoback;
    }

    public Label getLbName() {
        return lbName;
    }

    //SETTERS
    public void setLblTitel(Label lblTitel) {
        this.lblTitel = lblTitel;
    }

    public void setLbscore(Label lbscore) {
        this.lbscore = lbscore;
    }

    public void setTfscore(TextField tfscore) {
        this.tfscore = tfscore;
    }


    public void setBgoback(Button bgoback) {
        this.bgoback = bgoback;
    }

    public void setLbName(Label lbName) {
        this.lbName = lbName;
    }
    //CONSTRUCTOR


    public HighscoreView() {
        initNodes();
        layoutNodes();
    }

    private void initNodes() {
        lblTitel = new Label("highscores");
        lbscore = new Label("score");
        bgoback = new Button("back");
        lbName = new Label("playername");
    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        HBox hboxTitle = new HBox();
        HBox hboxNaamEnScore = new HBox();

        //ADD to HBOX
        hboxTitle.getChildren().add(lblTitel);
        hboxNaamEnScore.getChildren().addAll(lbscore, lbName);

        //FONTS

        lblTitel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
        lbName.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        lbscore.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));

        //PADDINGS

        lblTitel.setPadding(new Insets(15, 0, 0, 0));
        lbName.setPadding(new Insets(75, 0, 20, 0));
        lbName.setPadding(new Insets(0, 0, 0, 0));

        //CREATE VBOX
        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(lbscore, lbName);

        //POSITIONS

        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxNaamEnScore.setAlignment(Pos.CENTER);

        super.setTop(hboxTitle);
        super.setCenter(mainBox);
        super.setBottom(bgoback);

        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));



    }


}
