package be.kdg.biadvesz.jfxproj.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class GameView extends BorderPane {
    private Label lblTitle;
    private Label lblScore;
    private Label lblHighscore;
    private Button btLeave;
    private int gridSize;

    public Button tmpbutton = new Button("Temp");

    public Button getBtLeave() {
        return btLeave;
    }

    public GameView(int gridSize) {
        this.gridSize = gridSize;
        initialise();
        layoutnodes();
    }


    private void initialise() {
        lblTitle = new Label("2048 Game");
        lblTitle.setStyle("-fx-font-size: 16px");
        lblScore = new Label("Score: \n 0");
        lblHighscore = new Label("Highscore: \n 0");
        btLeave = new Button("Leave");
    }


    private void layoutnodes() {
        super.setPadding(new Insets(10));
        super.getChildren().add(lblTitle);

        HBox hBoxTop = new HBox();
        lblTitle.setPrefWidth(100);
        lblHighscore.setPrefWidth(100);
        lblScore.setPrefWidth(50);
        hBoxTop.getChildren().addAll(lblTitle, lblScore, lblHighscore);
        hBoxTop.setAlignment(Pos.CENTER);
        super.setTop(hBoxTop);

        HBox hboxmidden = new HBox();

        GridPane gridPane = new GridPane();
        Button[][] btn = new Button[gridSize][gridSize];

        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn.length;j++){
                btn[i][j] = new Button("0");
                btn[i][j].setPrefSize(75, 75);
                gridPane.add(btn[i][j], i, j);
            }
        }
        hboxmidden.setPadding(new Insets(70,10,10,10));
        hboxmidden.setAlignment(Pos.CENTER);
        hboxmidden.getChildren().addAll(gridPane);
        super.setCenter(hboxmidden);


        super.setPadding(new Insets(10));
        BorderPane bpButtonSave = new BorderPane();
        bpButtonSave.setRight(btLeave);
        btLeave.setPrefWidth(100);
//        super.setBottom(bpButtonSave);
        super.setBottom(tmpbutton);
    }

    public Label getLblTitle() { return lblTitle; }
    public Label getLblScore() { return lblScore; }
    public Label getLblHighscore() {
        return lblHighscore;
    }
}
