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
    private Button btLoad;
    private Button btSave;
    private int gridSize;
    private Label[][] grid;

    //GET
    Button getBtLeave() {
        return btLeave;
    }
    Label[][] getGrid() { return grid; }
    Label getLblScore() { return lblScore; }
    Button getBtUndo() { return btUndo; }
    Button getBtLoad() { return btLoad; }
    Button getBtSave() { return btSave; }

    //CTOR
    public GameView(int gridSize) {
        this.gridSize = gridSize;
        initialise();
        layoutnodes();
    }

    //METHODS
    private void initialise() {
        //INIT
        lblTitle = new Label("2048 Game");
        lblScore = new Label(String.format("Score: \n %4s","0"));
        lblHighscore = new Label(String.format("Highscore: \n %7s","0"));
        btLeave = new Button("Leave");
        btUndo = new Button("Undo");
        btUndo.setDisable(true);
        grid = new Label[gridSize][gridSize];
        btLoad = new Button("Load");
        btSave = new Button("Save");
    }

    private void layoutnodes() {
        super.setPadding(new Insets(12));
        HBox hBoxTop = new HBox();
        //PADDING
        lblScore.setPadding(new Insets(0, 50, 0, 15));
        lblTitle.setPadding(new Insets(0, 20, 0, 0));
        //SET FONT
        lblTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 25));
        lblScore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        lblHighscore.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        //ADD TO HBOX
        hBoxTop.getChildren().addAll(lblTitle, lblScore, lblHighscore);
        hBoxTop.setAlignment(Pos.CENTER);
        super.setTop(hBoxTop);

        VBox buttonsVBox = new VBox();




        BorderPane bpButtonLeaveUndo = new BorderPane();
        bpButtonLeaveUndo.setRight(btLoad);
        bpButtonLeaveUndo.setLeft(btSave);

        btLeave.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        btUndo.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        btLeave.setPadding(new Insets(12, 30, 12, 30));
        btUndo.setPadding(new Insets(12, 30, 12, 30));


        BorderPane bpButtonSaveLoad = new BorderPane();
        bpButtonSaveLoad.setRight(btLeave);
        bpButtonSaveLoad.setLeft(btUndo);

        btLoad.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        btSave.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 15));
        btLoad.setPadding(new Insets(12, 34, 12, 34));
        btSave.setPadding(new Insets(12, 30, 12, 32));


        buttonsVBox.setSpacing(5);
        buttonsVBox.getChildren().addAll(bpButtonSaveLoad, bpButtonLeaveUndo);
        super.setBottom(buttonsVBox);

        HBox hboxmidden = new HBox();
        //Making of 2048 GRID
        int gridPaneSize = 350;

        GridPane gridPane = new GridPane();
        gridPane.setHgap(7);
        gridPane.setVgap(7);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #BCAEA1;");
        gridPane.setMinSize(gridPaneSize, gridPaneSize);
        gridPane.setMaxSize(gridPaneSize, gridPaneSize);

        for (int row=0;row<grid.length;row++) {
            for (int col=0;col<grid[row].length;col++) {
                Label lblTile = new Label();
                grid[row][col] = lblTile;
                double tileSize = gridPaneSize/(gridSize+1);
                lblTile.setMinSize(tileSize, tileSize);
                gridPane.add(lblTile, row, col);
            }
        }
        //INSERTING GRID INTO hbox
        hboxmidden.setPadding(new Insets(70, 10,10,10));
        hboxmidden.setAlignment(Pos.CENTER);
        hboxmidden.getChildren().addAll(gridPane);

        super.setCenter(hboxmidden);

        //background color
        super.setBackground(new Background(new BackgroundFill(Color.rgb(250, 248, 239), CornerRadii.EMPTY, Insets.EMPTY)));

        //COLORS
        btUndo.setStyle("-fx-background-color: rgb(250, 211, 102)");
        btSave.setStyle("-fx-background-color: rgb(250, 211, 102)");
        btLoad.setStyle("-fx-background-color: rgb(250, 211, 102)");
        btLeave.setStyle("-fx-background-color: rgb(250, 211, 102)");
    }
}
