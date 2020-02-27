package be.kdg.biadvesz.jfxproj.view.howtoplay;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HowToPlayView extends BorderPane {
    //ATTRIB
    private Label lblTitle;
    private Label lblrule1;
    private Label lblrule2;
    private Label lblrule3;
    private Button bGoBack;

    //GET
    public Button getbGoBack() {
        return bGoBack;
    }

    //CTOR
    public HowToPlayView() {
        initNodes();
        layoutNodes();
    }

    //METHODS
    private void initNodes() {
        lblTitle = new Label("How To Play");

        lblrule1 = new Label("1) Move all tiles on the board \n horizontally and/or vertically");
        lblrule2 = new Label("2) Combine matching numbers");
        lblrule3 = new Label("3) Aim for 2048 or even higher");
        bGoBack = new Button("Go back");
    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        HBox hboxTitle = new HBox();
        HBox hboxRule1 = new HBox();
        HBox hboxRule2 = new HBox();
        HBox hboxRule3 = new HBox();

        //ADD TO HBOX

        hboxTitle.getChildren().add(lblTitle);
        hboxRule1.getChildren().add(lblrule1);
        hboxRule2.getChildren().add(lblrule2);
        hboxRule3.getChildren().add(lblrule3);

        //FONTS

        lblTitle.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 62));
        lblrule1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        lblrule2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        lblrule3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));


        //PADDINGS

        lblTitle.setPadding(new Insets(40, 0, 0, 0));
        lblrule1.setPadding(new Insets(0, 0, 0, 30));
        lblrule2.setPadding(new Insets(20, 0, 20, 30));
        lblrule3.setPadding(new Insets(0, 0, 0, 30));

        //CREATE VBOX

        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(10));
        mainBox.getChildren().addAll(lblrule1, lblrule2, lblrule3);

        //POSITIONS

        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxRule1.setAlignment(Pos.CENTER);
        hboxRule2.setAlignment(Pos.CENTER);
        hboxRule3.setAlignment(Pos.CENTER);
        mainBox.setAlignment(Pos.CENTER_LEFT);


        super.setTop(hboxTitle);
        super.setCenter(mainBox);
        super.setBottom(bGoBack);
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
