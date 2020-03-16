package be.kdg.biadvesz.jfxproj.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class GameView extends BorderPane {
    //ATTRIB
    private Label lblTitle;
    private Label lblScore;
    private Label lblHighscore;
    private Button btLeave;
    private Button btUndo;
    private int gridSize;
    private Label[][] grid;

    //GET
    public Button getBtLeave() {
        return btLeave;
    }
    public Label[][] getGrid() { return grid; }
    public Label getLblScore() { return lblScore; }
    public Button getBtUndo() { return btUndo; }

    //CTOR
    public GameView(int gridSize) {
        this.gridSize = gridSize;
        initialise();
        layoutnodes();
    }

    //METHODS
    private void initialise() {
        lblTitle = new Label("2048 Game");
        lblScore = new Label(String.format("Score: \n %4s","0"));
        lblHighscore = new Label(String.format("Highscore: \n %7s","0"));
        btLeave = new Button("Leave");
        btUndo = new Button("Undo");
        btUndo.setDisable(true);
        grid = new Label[gridSize][gridSize];
    }

    private void layoutnodes() {
        super.setPadding(new Insets(12));
        HBox hBoxTop = new HBox();

        lblScore.setPadding(new Insets(0, 50, 0, 15));
        lblTitle.setPadding(new Insets(0, 20, 0, 0));

        lblTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        lblScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblHighscore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        hBoxTop.getChildren().addAll(lblTitle, lblScore, lblHighscore);
        hBoxTop.setAlignment(Pos.CENTER);
        super.setTop(hBoxTop);

        BorderPane bpButtonSave = new BorderPane();
        bpButtonSave.setRight(btLeave);
        bpButtonSave.setLeft(btUndo);
        btLeave.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        btLeave.setPadding(new Insets(12, 30, 12, 30));
        btUndo.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 16));
        btUndo.setPadding(new Insets(12, 30, 12, 30));
        super.setBottom(bpButtonSave);

        HBox hboxmidden = new HBox();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(7);
        gridPane.setVgap(7);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #BCAEA1;");
        gridPane.setMinSize(350, 350);
        gridPane.setMaxSize(350, 350);

        for (int row=0;row<grid.length;row++) {
            for (int col=0;col<grid[row].length;col++) {
                Label lblTile = new Label();
                grid[row][col] = lblTile;
                lblTile.setMinSize(77, 77);
                gridPane.add(lblTile, row, col);
            }
        }

        hboxmidden.setPadding(new Insets(70, 10,10,10));
        hboxmidden.setAlignment(Pos.CENTER);
        hboxmidden.getChildren().addAll(gridPane);

        super.setCenter(hboxmidden);

        //background color
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
