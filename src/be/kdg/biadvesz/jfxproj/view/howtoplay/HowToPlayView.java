package be.kdg.biadvesz.jfxproj.view.howtoplay;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HowToPlayView extends BorderPane {
    //ATTRIB
    private Label lblTitle;
    private Label lblRules;
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
        lblRules = new Label("- Move all tiles on the board horizontally  \n   and / or vertically.\n- Combine matching numbers\n- Aim for 2048 or even higher.");
        bGoBack = new Button("Go back");
    }

    private void layoutNodes() {
        super.setPadding(new Insets(10));
        HBox hboxTitle = new HBox();
        HBox hboxRules = new HBox();
        hboxTitle.getChildren().add(lblTitle);
        hboxRules.getChildren().add(lblRules);
        lblTitle.setStyle("-fx-font-size: 62px;");
        lblRules.setStyle("-fx-font-size: 18px;");
        hboxTitle.setAlignment(Pos.TOP_CENTER);
        hboxRules.setAlignment(Pos.CENTER);
        super.setTop(hboxTitle);
        super.setCenter(hboxRules);
        super.setBottom(bGoBack);
    }
}
