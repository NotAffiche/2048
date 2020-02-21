package be.kdg.biadvesz.jfxproj.view.howtoplay;

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
        lblRules = new Label("- Move all numbers on the board horizontally / vertically.\n- Comgine matching numbers\n- Aim for 2048 or even higher.");
        bGoBack = new Button("Go back");
    }

    private void layoutNodes() {
        HBox hboxTitle = new HBox();
        HBox hboxRules = new HBox();
        hboxTitle.getChildren().add(lblTitle);
        hboxRules.getChildren().add(lblRules);
        super.setTop(hboxTitle);
        super.setCenter(hboxRules);
        super.setBottom(bGoBack);
    }
}
