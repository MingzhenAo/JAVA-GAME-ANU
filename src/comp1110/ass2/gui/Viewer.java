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
     *
     * @param imageview
     * @param n         the rotation count
     * @return the proper rotated imageview
     */
    static ImageView rotation(ImageView imageview, int n) {
        if (n == 0) {
            imageview.setScaleX(1);
            imageview.setRotate(0);
        }
        if (n == 1) {
            imageview.setScaleX(1);
            imageview.setRotate(90);
        }
        if (n == 2) {
            imageview.setScaleX(1);
            imageview.setRotate(180);
        }
        if (n == 3) {
            imageview.setScaleX(1);
            imageview.setRotate(270);
        }
        if (n == 4) {
            imageview.setScaleX(1);
            imageview.setScaleX(-1);
            imageview.setRotate(0);
        }
        if (n == 5) {
            imageview.setScaleX(1);
            imageview.setScaleX(-1);
            imageview.setRotate(90);
        }
        if (n == 6) {
            imageview.setScaleX(1);
            imageview.setScaleX(-1);
            imageview.setRotate(180);
        }
        if (n == 7) {
            imageview.setScaleX(1);
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
     * the method for the console to place the tiles with a cyan background
     * @param imageView
     */
    private void consolePlacing (ImageView imageView, String placement, Group root){
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
        imageView.setY(90 + 80 * (placement.charAt(2) - 'A'));
        rotation(imageView, Integer.valueOf(placement.substring(4, 5)));
        Rectangle rectangle = new Rectangle(300 + 80 * Integer.valueOf(placement.substring(3, 4)), 90 + 80 * (placement.charAt(2) - 'A'), 80, 80);
        rectangle.setFill(CYAN);
        root.getChildren().add(rectangle);
        root.getChildren().add(imageView);
    }

    /**
     * Author: Yusen Wei
     * Draw a placement or a sets of placements in the window, this is the method, and also adds the background of color cyan
     *
     * @param placement
     * @param root
     */
    void placing(String placement, Group root) {
        if (isTilePlacementWellFormed(placement)) {
            switch (placement.substring(0, 2)) {
                case "A0":
                    Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString());
                    ImageView a0 = new ImageView(A0);
                    consolePlacing(a0, placement, root);
                    break;
                case "A1":
                    Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A1.png").toString());
                    ImageView a1 = new ImageView(A1);
                    consolePlacing(a1, placement, root);
                    break;
                case "A2":
                    Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A2.png").toString());
                    ImageView a2 = new ImageView(A2);
                    consolePlacing(a2, placement, root);
                    break;
                case "A3":
                    Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A3.png").toString());
                    ImageView a3 = new ImageView(A3);
                    consolePlacing(a3, placement, root);
                    break;
                case "A4":
                    Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A4.png").toString());
                    ImageView a4 = new ImageView(A4);
                    consolePlacing(a4, placement, root);
                    break;
                case "A5":
                    Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A5.png").toString());
                    ImageView a5 = new ImageView(A5);
                    consolePlacing(a5, placement, root);
                    break;
                case "B0":
                    Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B0.png").toString());
                    ImageView b0 = new ImageView(B0);
                    consolePlacing(b0, placement, root);
                    break;
                case "B1":
                    Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B1.png").toString());
                    ImageView b1 = new ImageView(B1);
                    consolePlacing(b1, placement, root);
                    break;
                case "B2":
                    Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B2.png").toString());
                    ImageView b2 = new ImageView(B2);
                    consolePlacing(b2, placement, root);
                    break;
                case "S0":
                    Image S0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S0.png").toString());
                    ImageView s0 = new ImageView(S0);
                    consolePlacing(s0, placement, root);
                    break;
                case "S1":
                    Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S1.png").toString());
                    ImageView s1 = new ImageView(S1);
                    consolePlacing(s1, placement, root);
                    break;
                case "S2":
                    Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S2.png").toString());
                    ImageView s2 = new ImageView(S2);
                    consolePlacing(s2, placement, root);
                    break;
                case "S3":
                    Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S3.png").toString());
                    ImageView s3 = new ImageView(S3);
                    consolePlacing(s3, placement, root);
                    break;
                case "S4":
                    Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S4.png").toString());
                    ImageView s4 = new ImageView(S4);
                    consolePlacing(s4, placement, root);
                    break;
                case "S5":
                    Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S5.png").toString());
                    ImageView s5 = new ImageView(S5);
                    consolePlacing(s5, placement, root);
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
     *
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
        Image highExit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "HighExit.png").toString());
        ImageView viewHigh1 = new ImageView(highExit);
        viewHigh1.setX(370);
        viewHigh1.setY(20);
        viewHigh1.setFitWidth(100);
        viewHigh1.setFitHeight(100);
        group.getChildren().add(viewHigh1);

        ImageView viewHigh2 = new ImageView(highExit);
        viewHigh2.setX(690);
        viewHigh2.setY(20);
        viewHigh2.setFitWidth(100);
        viewHigh2.setFitHeight(100);
        group.getChildren().add(viewHigh2);

        ImageView viewHigh3 = new ImageView(highExit);
        viewHigh3.setRotate(270);
        viewHigh3.setX(230);
        viewHigh3.setY(320);
        viewHigh3.setFitWidth(100);
        viewHigh3.setFitHeight(100);
        group.getChildren().add(viewHigh3);

        ImageView viewHigh4 = new ImageView(highExit);
        viewHigh4.setRotate(90);
        viewHigh4.setX(830);
        viewHigh4.setY(320);
        viewHigh4.setFitWidth(100);
        viewHigh4.setFitHeight(100);
        group.getChildren().add(viewHigh4);

        ImageView viewHigh5 = new ImageView(highExit);
        viewHigh5.setRotate(180);
        viewHigh5.setX(370);
        viewHigh5.setY(620);
        viewHigh5.setFitWidth(100);
        viewHigh5.setFitHeight(100);
        group.getChildren().add(viewHigh5);

        ImageView viewHigh6 = new ImageView(highExit);
        viewHigh6.setRotate(180);
        viewHigh6.setX(690);
        viewHigh6.setY(620);
        viewHigh6.setFitWidth(100);
        viewHigh6.setFitHeight(100);
        group.getChildren().add(viewHigh6);

        //set railway exits
        Image railExit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "RailExit.png").toString());
        ImageView viewRail1 = new ImageView(railExit);
        viewRail1.setX(530);
        viewRail1.setY(20);
        viewRail1.setFitWidth(100);
        viewRail1.setFitHeight(100);
        group.getChildren().add(viewRail1);

        ImageView viewRail2 = new ImageView(railExit);
        viewRail2.setRotate(270);
        viewRail2.setX(230);
        viewRail2.setY(160);
        viewRail2.setFitWidth(100);
        viewRail2.setFitHeight(100);
        group.getChildren().add(viewRail2);

        ImageView viewRail3 = new ImageView(railExit);
        viewRail3.setRotate(270);
        viewRail3.setX(230);
        viewRail3.setY(480);
        viewRail3.setFitWidth(100);
        viewRail3.setFitHeight(100);
        group.getChildren().add(viewRail3);

        ImageView viewRail4 = new ImageView(railExit);
        viewRail4.setRotate(90);
        viewRail4.setX(830);
        viewRail4.setY(160);
        viewRail4.setFitWidth(100);
        viewRail4.setFitHeight(100);
        group.getChildren().add(viewRail4);

        ImageView viewRail5 = new ImageView(railExit);
        viewRail5.setRotate(90);
        viewRail5.setX(830);
        viewRail5.setY(480);
        viewRail5.setFitWidth(100);
        viewRail5.setFitHeight(100);
        group.getChildren().add(viewRail5);

        ImageView viewRail6 = new ImageView(railExit);
        viewRail6.setRotate(180);
        viewRail6.setX(530);
        viewRail6.setY(620);
        viewRail6.setFitWidth(100);
        viewRail6.setFitHeight(100);
        group.getChildren().add(viewRail6);

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
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

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

    //record the inital boardString at the start of each round
    String roundInitialBoardString = "";

    /**
     * Author: Yusen Wei
     * the method to show the next round label and to set the next round
     */
    private void nextRound() {
        Button button = new Button("Next Round");
        button.setOnAction(e -> {
            System.out.println("the boardString for next round: " + boardString);
            if (isValidPlacementSequence(boardString) && isSpecialTilesProper(boardString, roundInitialBoardString)) {
                //lock Special tiles if three are already placed
                lockSpecialTiles(boardString);
                roundCount++;
                if (roundCount == 9)
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
                lockTiles();
                roundInitialBoardString = boardString;
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
     * lock the special tile column if three are already placed
     * @param boardString
     */
    private void lockSpecialTiles(String boardString){
        String[] current = getPlacementStringArray(boardString);
        int currentCount = 0;
        for (var v : current){
            if (v.substring(0,1).equals("S"))
                currentCount ++;
        }
        if (currentCount >= 3){
            for (var v : root.getChildren()) {
                if (v instanceof ImageView) {
                    if (((ImageView) v).getX() == 30) {
                        v.setDisable(true);
                    }
                }
            }
        }
    }

    /**
     * Author: Yusen Wei
     * check if more than one tiles are placed at one round, you can't go to next round
     * @param boardString the current boardString
     * @param roundInitialBoardString the BoardString at the beginning of each round
     * @return true if only one Special is placed
     */
    private boolean isSpecialTilesProper(String boardString, String roundInitialBoardString){
        String[] current = getPlacementStringArray(boardString);
        String[] initial = getPlacementStringArray(roundInitialBoardString);
        int currentCount = 0;
        int initialCount = 0;
        for (var v : current){
            if (v.substring(0,1).equals("S"))
                currentCount ++;
        }
        //System.out.println(currentCount);
        for (var v : initial){
            if (v.substring(0,1).equals("S"))
                initialCount ++;
        }
        //System.out.println(initialCount);
        if (currentCount - initialCount > 1)
            return false;
        return true;
    }

    /**
     * Author: Yusen Wei
     * the method to lock the previous in positioned tiles
     */
    private void lockTiles(){
        for (var v : root.getChildren()) {
            if (v instanceof ImageView) {
                if (((ImageView) v).getX() >= 300 && ((ImageView) v).getX() <= 860 && ((ImageView) v).getY() >= 90 && ((ImageView) v).getY() <= 650) {
                    v.setDisable(true);
                }
            }
        }
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
        alert.setContentText("You have completed the game!\nBasic score: " + getBasicScore(boardString) + "     AI: " + getBasicScore(b) + "\nTotal score: " + getAdvancedScore(boardString) + "     AI: " + getAdvancedScore(b));
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
        showSpecialTile(s0, 0);
        //S1
        Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S1.png").toString());
        ImageView s1 = new ImageView(S1);
        showSpecialTile(s1, 1);
        //S2
        Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S2.png").toString());
        ImageView s2 = new ImageView(S2);
        showSpecialTile(s2, 2);
        //S3
        Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S3.png").toString());
        ImageView s3 = new ImageView(S3);
        showSpecialTile(s3, 3);
        //S4
        Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S4.png").toString());
        ImageView s4 = new ImageView(S4);
        showSpecialTile(s4, 4);
        //S5
        Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S5.png").toString());
        ImageView s5 = new ImageView(S5);
        showSpecialTile(s5, 5);
    }

    /**
     * Author: Yusen Wei
     * the method to put every special tile
     * @param imageView
     * @param i the order of the special tiles
     */
    private void showSpecialTile(ImageView imageView, int i){
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setX(30);
        imageView.setY(90 + 100 * i);
        imageView.setPickOnBounds(true);
        moveTile(imageView);
        root.getChildren().add(imageView);
    }

    /**
     * Author: Yusen Wei
     * This method to show the 4 normal tiles based on diceRoll
     *
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
                    placeNormalTiles(a0, i);
                    break;
                case "A1":
                    Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A1.png").toString());
                    ImageView a1 = new ImageView(A1);
                    placeNormalTiles(a1, i);
                    break;
                case "A2":
                    Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A2.png").toString());
                    ImageView a2 = new ImageView(A2);
                    placeNormalTiles(a2, i);
                    break;
                case "A3":
                    Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A3.png").toString());
                    ImageView a3 = new ImageView(A3);
                    placeNormalTiles(a3, i);
                    break;
                case "A4":
                    Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A4.png").toString());
                    ImageView a4 = new ImageView(A4);
                    placeNormalTiles(a4, i);
                    break;
                case "A5":
                    Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A5.png").toString());
                    ImageView a5 = new ImageView(A5);
                    placeNormalTiles(a5, i);
                    break;
                case "B0":
                    Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B0.png").toString());
                    ImageView b0 = new ImageView(B0);
                    placeNormalTiles(b0, i);
                    break;
                case "B1":
                    Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B1.png").toString());
                    ImageView b1 = new ImageView(B1);
                    placeNormalTiles(b1, i);
                    break;
                case "B2":
                    Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B2.png").toString());
                    ImageView b2 = new ImageView(B2);
                    placeNormalTiles(b2, i);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Author: Yusen Wei
     * place the normal tiles
     * @param imageView
     * @param i the order of the normal tile
     */
    private void placeNormalTiles(ImageView imageView, int i){
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        imageView.setX(130);
        imageView.setY(90 + 100 * i);
        imageView.setPickOnBounds(true);
        moveTile(imageView);
        root.getChildren().add(imageView);
    }

    //store the diceRoll String for each round
    String diceRoll = "";
    //the placement string when dragging and rotating
    String placementStringDragging = "";
    //the boardString of the game
    String boardString = "";

    /**
     * Author: Yusen Wei
     * the method to move the tiles
     *
     * @param imageView
     */
    private void moveTile(ImageView imageView) {
        dragTile(imageView);
        imageView.setOnMouseReleased(mouseEvent -> {
            updateBoardString();
        });
    }


    /**
     * Author: Yusen Wei
     * the method to drag the tiles
     *
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
     *
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
     *
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
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(boardString);
    }

    /**
     * Author: Yusen Wei
     * This method reverses the rotation process and gets the rotation count value
     *
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
