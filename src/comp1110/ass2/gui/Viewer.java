package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Optional;

import static comp1110.ass2.RailroadInk.*;
import static javafx.scene.paint.Color.CYAN;

//fx config: --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules=javafx.controls,javafx.fxml,javafx.media

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 798;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group rootEasyAI = new Group();
    private final Group controls = new Group();
    private final Group controlsEasyAI = new Group();
    TextField textField;
    String a = "";
    String b = "";
    String c = "";

    /**
     * Author: Yusen Wei
     * used to set the proper rotation
     * @param imageview
     * @param n the rotation count
     * @return the proper rotated imageview
     */
    static ImageView rotation(ImageView imageview, int n) {
        if (n == 0) {
            imageview.setRotate(0);
        }
        if (n == 1) {
            imageview.setRotate(90);
        }
        if (n == 2) {
            imageview.setRotate(180);
        }
        if (n == 3) {
            imageview.setRotate(270);
        }
        if (n == 4) {
            imageview.setScaleX(-1);
            imageview.setRotate(0);
        }
        if (n == 5) {
            imageview.setScaleX(-1);
            imageview.setRotate(90);
        }
        if (n == 6) {
            imageview.setScaleX(-1);
            imageview.setRotate(180);
        }
        if (n == 7) {
            imageview.setScaleX(-1);
            imageview.setRotate(270);
        }
        return imageview;
    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement, Group root) {
        // FIXME Task 4: implement the simple placement viewer
        if (placement.length() == 5) {
            placing(placement, root);
        } else {
            String[] placementArray = getPlacementStringArray(placement);
            for (int i = 0; i < placementArray.length; i++) {
                placing(placementArray[i], root);
            }
        }
    }

    /**
     * Author: Yusen Wei
     * Draw a placement or a sets of placements in the window, this is the method, and also adds the background of color cyan
     * @param placement
     * @param root
     */
    void placing(String placement, Group root) {
        if (isTilePlacementWellFormed(placement)) {
            switch (placement.substring(0, 2)) {
                case "A0":
                    Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString());
                    ImageView a0 = new ImageView(A0);
                    a0.setFitHeight(80);
                    a0.setFitWidth(80);
                    a0.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a0.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a0, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle.setFill(CYAN);
                    root.getChildren().add(rectangle);
                    root.getChildren().add(a0);
                    break;
                case "A1":
                    Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A1.png").toString());
                    ImageView a1 = new ImageView(A1);
                    a1.setFitHeight(80);
                    a1.setFitWidth(80);
                    a1.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a1.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a1, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle1 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle1.setFill(CYAN);
                    root.getChildren().add(rectangle1);
                    root.getChildren().add(a1);
                    break;
                case "A2":
                    Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A2.png").toString());
                    ImageView a2 = new ImageView(A2);
                    a2.setFitHeight(80);
                    a2.setFitWidth(80);
                    a2.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a2.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a2, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle2 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle2.setFill(CYAN);
                    root.getChildren().add(rectangle2);
                    root.getChildren().add(a2);
                    break;
                case "A3":
                    Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A3.png").toString());
                    ImageView a3 = new ImageView(A3);
                    a3.setFitHeight(80);
                    a3.setFitWidth(80);
                    a3.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a3.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a3, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle3 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle3.setFill(CYAN);
                    root.getChildren().add(rectangle3);
                    root.getChildren().add(a3);
                    break;
                case "A4":
                    Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A4.png").toString());
                    ImageView a4 = new ImageView(A4);
                    a4.setFitHeight(80);
                    a4.setFitWidth(80);
                    a4.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a4.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a4, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle4 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle4.setFill(CYAN);
                    root.getChildren().add(rectangle4);
                    root.getChildren().add(a4);
                    break;
                case "A5":
                    Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A5.png").toString());
                    ImageView a5 = new ImageView(A5);
                    a5.setFitHeight(80);
                    a5.setFitWidth(80);
                    a5.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a5.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a5, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle5 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle5.setFill(CYAN);
                    root.getChildren().add(rectangle5);
                    root.getChildren().add(a5);
                    break;
                case "B0":
                    Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B0.png").toString());
                    ImageView b0 = new ImageView(B0);
                    b0.setFitHeight(80);
                    b0.setFitWidth(80);
                    b0.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    b0.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(b0, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle6 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle6.setFill(CYAN);
                    root.getChildren().add(rectangle6);
                    root.getChildren().add(b0);
                    break;
                case "B1":
                    Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B1.png").toString());
                    ImageView b1 = new ImageView(B1);
                    b1.setFitHeight(80);
                    b1.setFitWidth(80);
                    b1.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    b1.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(b1, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle7 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle7.setFill(CYAN);
                    root.getChildren().add(rectangle7);
                    root.getChildren().add(b1);
                    break;
                case "B2":
                    Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B2.png").toString());
                    ImageView b2 = new ImageView(B2);
                    b2.setFitHeight(80);
                    b2.setFitWidth(80);
                    b2.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    b2.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(b2, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle8 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle8.setFill(CYAN);
                    root.getChildren().add(rectangle8);
                    root.getChildren().add(b2);
                    break;
                case "S0":
                    Image S0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S0.png").toString());
                    ImageView s0 = new ImageView(S0);
                    s0.setFitHeight(80);
                    s0.setFitWidth(80);
                    s0.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    s0.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(s0, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle9 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle9.setFill(CYAN);
                    root.getChildren().add(rectangle9);
                    root.getChildren().add(s0);
                    break;
                case "S1":
                    Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S1.png").toString());
                    ImageView s1 = new ImageView(S1);
                    s1.setFitHeight(80);
                    s1.setFitWidth(80);
                    s1.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    s1.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(s1, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle10 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle10.setFill(CYAN);
                    root.getChildren().add(rectangle10);
                    root.getChildren().add(s1);
                    break;
                case "S2":
                    Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S2.png").toString());
                    ImageView s2 = new ImageView(S2);
                    s2.setFitHeight(80);
                    s2.setFitWidth(80);
                    s2.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    s2.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(s2, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle11 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle11.setFill(CYAN);
                    root.getChildren().add(rectangle11);
                    root.getChildren().add(s2);
                    break;
                case "S3":
                    Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S3.png").toString());
                    ImageView s3 = new ImageView(S3);
                    s3.setFitHeight(80);
                    s3.setFitWidth(80);
                    s3.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    s3.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(s3, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle12 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle12.setFill(CYAN);
                    root.getChildren().add(rectangle12);
                    root.getChildren().add(s3);
                    break;
                case "S4":
                    Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S4.png").toString());
                    ImageView s4 = new ImageView(S4);
                    s4.setFitHeight(80);
                    s4.setFitWidth(80);
                    s4.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    s4.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(s4, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle13 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle13.setFill(CYAN);
                    root.getChildren().add(rectangle13);
                    root.getChildren().add(s4);
                    break;
                case "S5":
                    Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S5.png").toString());
                    ImageView s5 = new ImageView(S5);
                    s5.setFitHeight(80);
                    s5.setFitWidth(80);
                    s5.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    s5.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(s5, Integer.valueOf(placement.substring(4, 5)));
                    Rectangle rectangle14 = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
                    rectangle14.setFill(CYAN);
                    root.getChildren().add(rectangle14);
                    root.getChildren().add(s5);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText(), root);
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    /**
     * Author: Yusen Wei
     * This method to set the board including all the fird line, central area, exits
     * @param group
     */
    private void setBoard(Group group) {
        //set board
        GridPane m = new GridPane();
        for (int i = 0; i < 7; i++) {
            ColumnConstraints column = new ColumnConstraints(80);
            m.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 7; i++) {
            RowConstraints row = new RowConstraints(80);
            m.getRowConstraints().add(row);
        }
        m.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        m.setLayoutX(300);
        m.setLayoutY(90);

        //set inner area
        GridPane h = new GridPane();
        ColumnConstraints column = new ColumnConstraints(240);
        h.getColumnConstraints().add(column);
        RowConstraints row = new RowConstraints(240);
        h.getRowConstraints().add(row);
        h.setStyle("-fx-border-color: red; -fx-border-width: 1; -fx-background-color: transparent; -fx-grid-lines-visible: false;");
        h.setLayoutX(459);
        h.setLayoutY(249);

        //set highway exits
        Image highexit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "HighExit.png").toString());
        ImageView viewhigh1 = new ImageView(highexit);
        viewhigh1.setX(370);
        viewhigh1.setY(20);
        viewhigh1.setFitWidth(100);
        viewhigh1.setFitHeight(100);
        group.getChildren().add(viewhigh1);

        ImageView viewhigh2 = new ImageView(highexit);
        viewhigh2.setX(690);
        viewhigh2.setY(20);
        viewhigh2.setFitWidth(100);
        viewhigh2.setFitHeight(100);
        group.getChildren().add(viewhigh2);

        ImageView viewhigh3 = new ImageView(highexit);
        viewhigh3.setRotate(270);
        viewhigh3.setX(230);
        viewhigh3.setY(320);
        viewhigh3.setFitWidth(100);
        viewhigh3.setFitHeight(100);
        group.getChildren().add(viewhigh3);

        ImageView viewhigh4 = new ImageView(highexit);
        viewhigh4.setRotate(90);
        viewhigh4.setX(830);
        viewhigh4.setY(320);
        viewhigh4.setFitWidth(100);
        viewhigh4.setFitHeight(100);
        group.getChildren().add(viewhigh4);

        ImageView viewhigh5 = new ImageView(highexit);
        viewhigh5.setRotate(180);
        viewhigh5.setX(370);
        viewhigh5.setY(620);
        viewhigh5.setFitWidth(100);
        viewhigh5.setFitHeight(100);
        group.getChildren().add(viewhigh5);

        ImageView viewhigh6 = new ImageView(highexit);
        viewhigh6.setRotate(180);
        viewhigh6.setX(690);
        viewhigh6.setY(620);
        viewhigh6.setFitWidth(100);
        viewhigh6.setFitHeight(100);
        group.getChildren().add(viewhigh6);

        //set railway exits
        Image railexit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "RailExit.png").toString());
        ImageView viewrail1 = new ImageView(railexit);
        viewrail1.setX(530);
        viewrail1.setY(20);
        viewrail1.setFitWidth(100);
        viewrail1.setFitHeight(100);
        group.getChildren().add(viewrail1);

        ImageView viewrail2 = new ImageView(railexit);
        viewrail2.setRotate(270);
        viewrail2.setX(230);
        viewrail2.setY(160);
        viewrail2.setFitWidth(100);
        viewrail2.setFitHeight(100);
        group.getChildren().add(viewrail2);

        ImageView viewrail3 = new ImageView(railexit);
        viewrail3.setRotate(270);
        viewrail3.setX(230);
        viewrail3.setY(480);
        viewrail3.setFitWidth(100);
        viewrail3.setFitHeight(100);
        group.getChildren().add(viewrail3);

        ImageView viewrail4 = new ImageView(railexit);
        viewrail4.setRotate(90);
        viewrail4.setX(830);
        viewrail4.setY(160);
        viewrail4.setFitWidth(100);
        viewrail4.setFitHeight(100);
        group.getChildren().add(viewrail4);

        ImageView viewrail5 = new ImageView(railexit);
        viewrail5.setRotate(90);
        viewrail5.setX(830);
        viewrail5.setY(480);
        viewrail5.setFitWidth(100);
        viewrail5.setFitHeight(100);
        group.getChildren().add(viewrail5);

        ImageView viewrail6 = new ImageView(railexit);
        viewrail6.setRotate(180);
        viewrail6.setX(530);
        viewrail6.setY(620);
        viewrail6.setFitWidth(100);
        viewrail6.setFitHeight(100);
        group.getChildren().add(viewrail6);

        //set board
        group.getChildren().add(m);
        group.getChildren().add(h);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        //set board
        setBoard(root);
        diceRoll = generateDiceRoll();
     
        showNormalTiles(diceRoll);
        root.getChildren().add(controls);

        makeControls();

        //show my stuff
        showSpecialTiles();
        nextRound();
        setAIScene(primaryStage, scene);
        setRoundCount();

        //end the game if there is no more valid moves
        //if (GenerateMoves.generateValidMoves(boardString, diceRoll).size() == 0)
        //endGame(primaryStage);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //set new stage
    //private void startAgain(Stage stage) throws Exception{
    //start(stage);
    //}

    //set AI scene
    Scene easyAIScene = new Scene(rootEasyAI, VIEWER_WIDTH, VIEWER_HEIGHT);

    //set AI scene method
    private void setAIScene(Stage primaryStage, Scene scene) {
        //set AI scene

        setBoard(rootEasyAI);
        rootEasyAI.getChildren().add(controlsEasyAI);
        Button button2 = new Button("     My  View     ");
        Button button = new Button("     AI  View     ");
        HBox hb = new HBox();
        hb.getChildren().addAll(button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(560);
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(button2);
        hb2.setSpacing(10);
        hb2.setLayoutX(130);
        hb2.setLayoutY(560);
        controls.getChildren().add(hb);
        controlsEasyAI.getChildren().add(hb2);
        button.setOnAction(e -> {
            primaryStage.setScene(easyAIScene);
        });
        button2.setOnAction(e2 -> {
            primaryStage.setScene(scene);
        });
    }

    /**
     * Author: Yusen Wei
     * the method to show the next round label and to set the next round
     */
    private void nextRound() {
        Button button = new Button("Next Round");
        button.setOnAction(e -> {
            System.out.println("the boardString for next round: " + boardString);
            if (isValidPlacementSequence(boardString)) {
                roundCount++;
                if(roundCount == 9)
                    endGame();
                diceRoll = "";
                diceRoll = generateDiceRoll();
                clearNormalTiles();
                showNormalTiles(diceRoll);
                setRoundCount();
                a = generateMove(b, generateDiceRoll());
                b += a;
                makePlacement(b, rootEasyAI);
                //my new task 10 version
                //validMoves = GenerateMoves.generateValidMoves(boardString, diceRoll);
                //my old task 10 version
                //validMoves = GenerateMoves.generateStrictMoves(boardString, diceRoll);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("InValid Placement");
                alert.setHeaderText(null);
                alert.setContentText("Can't go to next round because the placement is not valid, please recheck!");
                alert.showAndWait();
            }

        });
        HBox hb = new HBox();
        hb.getChildren().addAll(button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(520);
        controls.getChildren().add(hb);
    }

    /**
     * Author: Yusen Wei
     * the method to clear all the unused normal tiles at the beginning of each round
     */
    private void clearNormalTiles() {
        for (var v : root.getChildren()) {
            if (v instanceof ImageView) {
                if (((ImageView) v).getX() == 130) {
                    v.setVisible(false);
                }
            }
        }
    }


    /**
     * Author: Yusen Wei
     * the method to end the game
     */
    private void endGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("You have completed the game");
        alert.setHeaderText("");
        alert.setContentText("You have completed the game, the basic score you got is: " +  + getBasicScore(boardString) + "/n" + "the total score you got is: " + getAdvancedScore(boardString));
        alert.showAndWait();
    }


    //the parameter that stores which round we are at
    int roundCount = 1;

    /**
     * Author: Yusen Wei
     * the method to set the roundCount label
     */
    private void setRoundCount() {
        Label labelRound = new Label("Round " + roundCount);
        labelRound.setFont(new Font("Verdana", 50));
        HBox roundBox = new HBox();
        roundBox.setStyle("-fx-background-color: #FFFFFF;");
        roundBox.getChildren().add(labelRound);
        roundBox.setSpacing(30);
        roundBox.setLayoutX(30);
        roundBox.setLayoutY(10);
        root.getChildren().add(roundBox);
    }

    /**
     * Author: Yusen Wei
     * the method to show all the special tiles to be placed
     */
    void showSpecialTiles() {
        //S0
        Image S0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S0.png").toString());
        ImageView s0 = new ImageView(S0);
        s0.setFitHeight(80);
        s0.setFitWidth(80);
        s0.setX(30);
        s0.setY(90);
        moveTile(s0);
        root.getChildren().add(s0);
        //S1
        Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S1.png").toString());
        ImageView s1 = new ImageView(S1);
        s1.setFitHeight(80);
        s1.setFitWidth(80);
        s1.setX(30);
        s1.setY(190);
        moveTile(s1);
        root.getChildren().add(s1);
        //S2
        Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S2.png").toString());
        ImageView s2 = new ImageView(S2);
        s2.setFitHeight(80);
        s2.setFitWidth(80);
        s2.setX(30);
        s2.setY(290);
        moveTile(s2);
        root.getChildren().add(s2);
        //S3
        Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S3.png").toString());
        ImageView s3 = new ImageView(S3);
        s3.setFitHeight(80);
        s3.setFitWidth(80);
        s3.setX(30);
        s3.setY(390);
        moveTile(s3);
        root.getChildren().add(s3);
        //S4
        Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S4.png").toString());
        ImageView s4 = new ImageView(S4);
        s4.setFitHeight(80);
        s4.setFitWidth(80);
        s4.setX(30);
        s4.setY(490);
        moveTile(s4);
        root.getChildren().add(s4);
        //S5
        Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S5.png").toString());
        ImageView s5 = new ImageView(S5);
        s5.setFitHeight(80);
        s5.setFitWidth(80);
        s5.setX(30);
        s5.setY(590);
        moveTile(s5);
        root.getChildren().add(s5);
    }

    /**
     * Author: Yusen Wei
     * This method to show the 4 normal tiles based on diceRoll
     * @param diceRoll
     */
    void showNormalTiles(String diceRoll) {
        //ABs
        String[] rollString = new String[4];
        for (int i = 0; i < 4; i++) {
            rollString[i] = diceRoll.substring(2 * i, 2 * i + 2);
        }
        for (int i = 0; i < 4; i++) {
            switch (rollString[i]) {
                case "A0":
                    Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString());
                    ImageView a0 = new ImageView(A0);
                    a0.setFitHeight(80);
                    a0.setFitWidth(80);
                    a0.setX(130);
                    a0.setY(90 + 100 * i);
                    moveTile(a0);
                    root.getChildren().add(a0);
                    break;
                case "A1":
                    Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A1.png").toString());
                    ImageView a1 = new ImageView(A1);
                    a1.setFitHeight(80);
                    a1.setFitWidth(80);
                    a1.setX(130);
                    a1.setY(90 + 100 * i);
                    moveTile(a1);
                    root.getChildren().add(a1);
                    break;
                case "A2":
                    Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A2.png").toString());
                    ImageView a2 = new ImageView(A2);
                    a2.setFitHeight(80);
                    a2.setFitWidth(80);
                    a2.setX(130);
                    a2.setY(90 + 100 * i);
                    moveTile(a2);
                    root.getChildren().add(a2);
                    break;
                case "A3":
                    Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A3.png").toString());
                    ImageView a3 = new ImageView(A3);
                    a3.setFitHeight(80);
                    a3.setFitWidth(80);
                    a3.setX(130);
                    a3.setY(90 + 100 * i);
                    moveTile(a3);
                    root.getChildren().add(a3);
                    break;
                case "A4":
                    Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A4.png").toString());
                    ImageView a4 = new ImageView(A4);
                    a4.setFitHeight(80);
                    a4.setFitWidth(80);
                    a4.setX(130);
                    a4.setY(90 + 100 * i);
                    moveTile(a4);
                    root.getChildren().add(a4);
                    break;
                case "A5":
                    Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A5.png").toString());
                    ImageView a5 = new ImageView(A5);
                    a5.setFitHeight(80);
                    a5.setFitWidth(80);
                    a5.setX(130);
                    a5.setY(90 + 100 * i);
                    moveTile(a5);
                    root.getChildren().add(a5);
                    break;
                case "B0":
                    Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B0.png").toString());
                    ImageView b0 = new ImageView(B0);
                    b0.setFitHeight(80);
                    b0.setFitWidth(80);
                    b0.setX(130);
                    b0.setY(90 + 100 * i);
                    moveTile(b0);
                    root.getChildren().add(b0);
                    break;
                case "B1":
                    Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B1.png").toString());
                    ImageView b1 = new ImageView(B1);
                    b1.setFitHeight(80);
                    b1.setFitWidth(80);
                    b1.setX(130);
                    b1.setY(90 + 100 * i);
                    moveTile(b1);
                    root.getChildren().add(b1);
                    break;
                case "B2":
                    Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B2.png").toString());
                    ImageView b2 = new ImageView(B2);
                    b2.setFitHeight(80);
                    b2.setFitWidth(80);
                    b2.setX(130);
                    b2.setY(90 + 100 * i);
                    moveTile(b2);
                    root.getChildren().add(b2);
                    break;
                default:
                    break;
            }
        }
    }

    //store the diceRoll String for each round
    String diceRoll = "";
    //store the valid move option for each round
    //ArrayList<String>  validMoves = new ArrayList<>();
    //the placement string when dragging and rotating
    String placementStringDragging = "";
    //the boardString of the game
    String boardString = "";
    //boardString arrayList
    //ArrayList<String> boardStringList = new ArrayList<>();

    /**
     * Author: Yusen Wei
     * the method to move the tiles
     * @param imageView
     */
    private void moveTile(ImageView imageView) {
        /*
        if (roundCount != 0){
            if (!imageView.getImage().getUrl().substring(113,114).equals("s") && Integer.valueOf(boardString.substring(boardString.length() - 1, boardString.length())) < 3){

            }
        }
         */
        dragTile(imageView);
        imageView.setOnMouseReleased(mouseEvent -> {
            updateBoardString();
        });
    }


    /**
     * Author: Yusen Wei
     * the method to drag the tiles
     * @param imageView
     */
    private void dragTile(ImageView imageView) {
        imageView.setOnMouseDragged(mouseEvent -> {
            imageView.setX(mouseEvent.getSceneX() - 40);
            imageView.setY(mouseEvent.getSceneY() - 40);
            placementStringDragging = "";
            placementStringDragging += imageView.getImage().getUrl().substring(imageView.getImage().getUrl().length() - 6, imageView.getImage().getUrl().length() - 4);
            placementStringDragging.toUpperCase();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (imageView.getX() > 280 + i * 80 && imageView.getX() < 320 + i * 80 && imageView.getY() > 70 + j * 80 && imageView.getY() < 110 + j * 80) {
                        placementStringDragging += (char) ((int) 'A' + j);
                        placementStringDragging += i;
                        placementStringDragging += rotationCount;
                    }
                }
            }
            rotateTile(imageView);
            inPosition(imageView);
        });

    }

    //the parameter to record the scroll count
    int rotationCount = 0;


    /**
     * Author: Yusen Wei
     * the methods to rotate the tiles based on the rotationCount
     * @param imageView
     */
    private void rotateTile(ImageView imageView) {
        imageView.setOnScroll(scrollEvent -> {
            rotationCount++;
            while (rotationCount > 7)
                rotationCount -= 8;
            rotation(imageView, rotationCount);
            placementStringDragging = placementStringDragging.substring(0, 4);
            placementStringDragging += rotationCount;
            System.out.println(placementStringDragging);
        });
    }

    /**
     * Author: Yusen Wei
     * check the tile is in position or not, if it's near the area of a placed slot, snap the tile to the correct position
     * @param imageView
     */
    private void inPosition(ImageView imageView) {
        //origin slots in place
        for (int i = 0; i < 6; i++) {
            if (imageView.getX() > 10 && imageView.getX() < 50 && imageView.getY() > 70 + i * 100 && imageView.getY() < 110 + i * 100) {
                imageView.setX(30);
                imageView.setY(90 + i * 100);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (imageView.getX() > 110 && imageView.getX() < 150 && imageView.getY() > 70 + i * 100 && imageView.getY() < 110 + i * 100) {
                imageView.setX(130);
                imageView.setY(90 + i * 100);
            }
        }
        //task 10 way to implement inPlace
        /*
        if (validMoves.contains(placementStringDragging)){
            imageView.setX(Integer.valueOf(placementStringDragging.substring(3,4)) * 80 + 300);
            imageView.setY(((int)placementStringDragging.charAt(2) - 65) * 80 + 90);
        }
         */

        //task 6 way to implement inPlace
        /*
        if (isValidPlacementSequence(boardString + placementStringDragging)) {
            imageView.setX(Integer.valueOf(placementStringDragging.substring(3, 4)) * 80 + 300);
            imageView.setY(((int) placementStringDragging.charAt(2) - 65) * 80 + 90);
        }
         */

        //always in place,adds flexibility
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (imageView.getX() > 280 + i * 80 && imageView.getX() < 320 + i * 80 && imageView.getY() > 70 + j * 80 && imageView.getY() < 110 + j * 80) {
                    imageView.setX(300 + i * 80);
                    imageView.setY(90 + j * 80);
                }
            }
        }
    }

    /**
     * Author: Yusen Wei
     * the method to refresh the boardString of the whole board every time the mouse is released
     */
    private void updateBoardString() {
        //initialise boardString
        boardString = "";
        //listen on mouse release, each time mouse released scan the whole screen to give the boardString
        //record how many S tile are in the board
        //int sCount = 0;
        //for S
        for (var v : root.getChildren()) {
            if (v instanceof ImageView) {
                if (((ImageView) v).getX() >= 300 && ((ImageView) v).getX() <= 860 && ((ImageView) v).getY() >= 90 && ((ImageView) v).getY() <= 650) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (((ImageView) v).getY() == 90 + i * 80) {
                                if (((ImageView) v).getX() == 300 + j * 80) {
                                    boardString += ((ImageView) v).getImage().getUrl().substring(((ImageView) v).getImage().getUrl().length() - 6, ((ImageView) v).getImage().getUrl().length() - 4).toUpperCase();
                                    boardString += (char) ((int) 'A' + i);
                                    boardString += j;
                                    boardString += reverseRotation((ImageView) v);
                                    //sCount ++;
                                }
                            }
                        }
                    }
                }
            }
        }
        //for Abs
        //recording which round we are at
        //boardString += roundCount;
        //boardString += sCount;=
        System.out.println(boardString);
    }

    /**
     * Author: Yusen Wei
     * This method reverses the rotation process and gets the rotation count value
     * @param imageView
     */
    private int reverseRotation(ImageView imageView) {
        int count = 0;
        if (imageView.getScaleX() == -1)
            count += 4;
        if (imageView.getRotate() == 90)
            count += 1;
        if (imageView.getRotate() == 180)
            count += 2;
        if (imageView.getRotate() == 270)
            count += 3;
        return count;
    }

    /*
    public static void main(String[] args) {
        launch(args);
    }
     */
}
