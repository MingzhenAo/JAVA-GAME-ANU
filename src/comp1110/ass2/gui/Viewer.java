package comp1110.ass2.gui;

import comp1110.ass2.RailroadInk;
import comp1110.ass2.TileRotate;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.event.*;

import java.util.ArrayList;
import java.util.List;

import static comp1110.ass2.RailroadInk.*;

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
    private final Group controls = new Group();
    TextField textField;

    /**
     * used to set the proper rotation
     *
     * @param a
     * @param n
     * @return
     */
    static ImageView rotation(ImageView a, int n) {
        if (n > 3) {
            a.setScaleX(-1);
            n = n - 4;
        }
        if (n == 1) {
            a.setRotate(90);
        }
        if (n == 2) {
            a.setRotate(180);
        }
        if (n == 3) {
            a.setRotate(270);
        }
        return a;
    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer
        if (placement.length() == 5) {
            placing(placement);
        } else {
            String[] placementArray = getPlacementStringArray(placement);
            for (int i = 0; i < placementArray.length; i++) {
                placing(placementArray[i]);
            }
        }
    }

    /**
     * Draw a placement or a sets of placements in the window, this is the method
     *
     * @param placement
     */
    void placing(String placement) {
        if (isTilePlacementWellFormed(placement)) {
            int n = 0;
            switch (placement.substring(0, 2)) {
                case "A0":
                    Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString());
                    ImageView a0 = new ImageView(A0);
                    a0.setFitHeight(80);
                    a0.setFitWidth(80);
                    a0.setX(300 + 80 * Integer.valueOf(placement.substring(3, 4)));
                    a0.setY(90 + 80 * (placement.charAt(2) - 'A'));
                    rotation(a0, Integer.valueOf(placement.substring(4, 5)));
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
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        //set highway exits
        Image highexit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "HighExit.png").toString());
        ImageView viewhigh1 = new ImageView(highexit);
        viewhigh1.setX(370);
        viewhigh1.setY(20);
        viewhigh1.setFitWidth(100);
        viewhigh1.setFitHeight(100);
        root.getChildren().add(viewhigh1);

        ImageView viewhigh2 = new ImageView(highexit);
        viewhigh2.setX(690);
        viewhigh2.setY(20);
        viewhigh2.setFitWidth(100);
        viewhigh2.setFitHeight(100);
        root.getChildren().add(viewhigh2);

        ImageView viewhigh3 = new ImageView(highexit);
        viewhigh3.setRotate(270);
        viewhigh3.setX(230);
        viewhigh3.setY(320);
        viewhigh3.setFitWidth(100);
        viewhigh3.setFitHeight(100);
        root.getChildren().add(viewhigh3);

        ImageView viewhigh4 = new ImageView(highexit);
        viewhigh4.setRotate(90);
        viewhigh4.setX(830);
        viewhigh4.setY(320);
        viewhigh4.setFitWidth(100);
        viewhigh4.setFitHeight(100);
        root.getChildren().add(viewhigh4);

        ImageView viewhigh5 = new ImageView(highexit);
        viewhigh5.setRotate(180);
        viewhigh5.setX(370);
        viewhigh5.setY(620);
        viewhigh5.setFitWidth(100);
        viewhigh5.setFitHeight(100);
        root.getChildren().add(viewhigh5);

        ImageView viewhigh6 = new ImageView(highexit);
        viewhigh6.setRotate(180);
        viewhigh6.setX(690);
        viewhigh6.setY(620);
        viewhigh6.setFitWidth(100);
        viewhigh6.setFitHeight(100);
        root.getChildren().add(viewhigh6);

        //set railway exits
        Image railexit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "RailExit.png").toString());
        ImageView viewrail1 = new ImageView(railexit);
        viewrail1.setX(530);
        viewrail1.setY(20);
        viewrail1.setFitWidth(100);
        viewrail1.setFitHeight(100);
        root.getChildren().add(viewrail1);

        ImageView viewrail2 = new ImageView(railexit);
        viewrail2.setRotate(270);
        viewrail2.setX(230);
        viewrail2.setY(160);
        viewrail2.setFitWidth(100);
        viewrail2.setFitHeight(100);
        root.getChildren().add(viewrail2);

        ImageView viewrail3 = new ImageView(railexit);
        viewrail3.setRotate(270);
        viewrail3.setX(230);
        viewrail3.setY(480);
        viewrail3.setFitWidth(100);
        viewrail3.setFitHeight(100);
        root.getChildren().add(viewrail3);

        ImageView viewrail4 = new ImageView(railexit);
        viewrail4.setRotate(90);
        viewrail4.setX(830);
        viewrail4.setY(160);
        viewrail4.setFitWidth(100);
        viewrail4.setFitHeight(100);
        root.getChildren().add(viewrail4);

        ImageView viewrail5 = new ImageView(railexit);
        viewrail5.setRotate(90);
        viewrail5.setX(830);
        viewrail5.setY(480);
        viewrail5.setFitWidth(100);
        viewrail5.setFitHeight(100);
        root.getChildren().add(viewrail5);

        ImageView viewrail6 = new ImageView(railexit);
        viewrail6.setRotate(180);
        viewrail6.setX(530);
        viewrail6.setY(620);
        viewrail6.setFitWidth(100);
        viewrail6.setFitHeight(100);
        root.getChildren().add(viewrail6);


        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        root.getChildren().add(m);
        root.getChildren().add(controls);

        makeControls();
        showTiles(generateDiceRoll());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //show dragable tiles
    void showTiles(String diceRoll) {
        //S0
        Image S0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S0.png").toString());
        ImageView s0 = new ImageView(S0);
        s0.setFitHeight(80);
        s0.setFitWidth(80);
        s0.setX(30);
        s0.setY(90);
        //rotation(s0, Integer.valueOf(placement.substring(4,5)));
        /*
         s0.setOnDragDetected(mouseEvent -> {
            s0.setX(mouseEvent.getX());
            s0.setY(mouseEvent.getY());
        });
         */
        s0.setOnMouseDragged(mouseEvent -> {
            s0.setX(mouseEvent.getX() - 40);
            s0.setY(mouseEvent.getY() - 40);
        });
        root.getChildren().add(s0);
        //S1
        Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S1.png").toString());
        ImageView s1 = new ImageView(S1);
        s1.setFitHeight(80);
        s1.setFitWidth(80);
        s1.setX(30);
        s1.setY(190);
        //rotation(s1, Integer.valueOf(placement.substring(4,5)));
        root.getChildren().add(s1);
        //S2
        Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S2.png").toString());
        ImageView s2 = new ImageView(S2);
        s2.setFitHeight(80);
        s2.setFitWidth(80);
        s2.setX(30);
        s2.setY(290);
        //rotation(s2, Integer.valueOf(placement.substring(4,5)));
        root.getChildren().add(s2);
        //S3
        Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S3.png").toString());
        ImageView s3 = new ImageView(S3);
        s3.setFitHeight(80);
        s3.setFitWidth(80);
        s3.setX(30);
        s3.setY(390);
        //rotation(s3, Integer.valueOf(placement.substring(4,5)));
        root.getChildren().add(s3);
        //S4
        Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S4.png").toString());
        ImageView s4 = new ImageView(S4);
        s4.setFitHeight(80);
        s4.setFitWidth(80);
        s4.setX(30);
        s4.setY(490);
        //rotation(s4, Integer.valueOf(placement.substring(4,5)));
        root.getChildren().add(s4);
        //S5
        Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "S5.png").toString());
        ImageView s5 = new ImageView(S5);
        s5.setFitHeight(80);
        s5.setFitWidth(80);
        s5.setX(30);
        s5.setY(590);
        //rotation(s5, Integer.valueOf(placement.substring(4,5)));
        root.getChildren().add(s5);
        //ABs
        String[] rollString = new String[4];
        for (int i = 0; i < 4; i++) {
            rollString[i] = diceRoll.substring(2 * i, 2 * i + 2);
        }
        if (rollString[0] == rollString[1])
            rollString[1] = "";
        if (rollString[0] == rollString[2])
            rollString[2] = "";
        if (rollString[1] == rollString[2])
            rollString[2] = "";
        for (int i = 0; i < 4; i++) {
            switch (rollString[i]) {
                case "A0":
                    Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A0.png").toString());
                    ImageView a0 = new ImageView(A0);
                    a0.setFitHeight(80);
                    a0.setFitWidth(80);
                    a0.setX(130);
                    a0.setY(90 + 100 * i);
                    //rotation(a0, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(a0);
                    break;
                case "A1":
                    Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A1.png").toString());
                    ImageView a1 = new ImageView(A1);
                    a1.setFitHeight(80);
                    a1.setFitWidth(80);
                    a1.setX(130);
                    a1.setY(90 + 100 * i);
                    //rotation(a1, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(a1);
                    break;
                case "A2":
                    Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A2.png").toString());
                    ImageView a2 = new ImageView(A2);
                    a2.setFitHeight(80);
                    a2.setFitWidth(80);
                    a2.setX(130);
                    a2.setY(90 + 100 * i);
                    //rotation(a2, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(a2);
                    break;
                case "A3":
                    Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A3.png").toString());
                    ImageView a3 = new ImageView(A3);
                    a3.setFitHeight(80);
                    a3.setFitWidth(80);
                    a3.setX(130);
                    a3.setY(90 + 100 * i);
                    //rotation(a3, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(a3);
                    break;
                case "A4":
                    Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A4.png").toString());
                    ImageView a4 = new ImageView(A4);
                    a4.setFitHeight(80);
                    a4.setFitWidth(80);
                    a4.setX(130);
                    a4.setY(90 + 100 * i);
                    //rotation(a4, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(a4);
                    break;
                case "A5":
                    Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "A5.png").toString());
                    ImageView a5 = new ImageView(A5);
                    a5.setFitHeight(80);
                    a5.setFitWidth(80);
                    a5.setX(130);
                    a5.setY(90 + 100 * i);
                    //rotation(a5, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(a5);
                    break;
                case "B0":
                    Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B0.png").toString());
                    ImageView b0 = new ImageView(B0);
                    b0.setFitHeight(80);
                    b0.setFitWidth(80);
                    b0.setX(130);
                    b0.setY(90 + 100 * i);
                    //rotation(b0, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(b0);
                    break;
                case "B1":
                    Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B1.png").toString());
                    ImageView b1 = new ImageView(B1);
                    b1.setFitHeight(80);
                    b1.setFitWidth(80);
                    b1.setX(130);
                    b1.setY(90 + 100 * i);
                    //rotation(b1, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(b1);
                    break;
                case "B2":
                    Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE + "B2.png").toString());
                    ImageView b2 = new ImageView(B2);
                    b2.setFitHeight(80);
                    b2.setFitWidth(80);
                    b2.setX(130);
                    b2.setY(90 + 100 * i);
                    //rotation(b2, Integer.valueOf(placement.substring(4,5)));
                    root.getChildren().add(b2);
                    break;
                default:
                    break;
            }
        }
    }
}


    //test
    /*
    class TileDrag extends Polygon {
        double mouseX, mouseY;      // the last known mouse positions (used when dragging)
        double startX, startY;
        TileDrag(double startX, double startY){
            this.startX = startX;
            this.startY = startY;
            setLayoutX(startX);
            setLayoutY(startY);
        }
        setOnMousePressed(e -> {      // mouse press indicates begin of drag
            mouseX = e.getSceneX();
            mouseY = event.getSceneY();
        });

        setOnMouseDragged(event -> {      // mouse is being dragged
            draggable.toFront();
            double movementX = event.getSceneX() - mouseX;
            double movementY = event.getSceneY() - mouseY;
            draggable.drag(movementX, movementY);
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
        });

        setOnMouseReleased(event -> {     // drag is complete
            if (draggable.onBoard()) {
                draggable.setPosition();
                String placementString = getPlacementString();
                if (RailroadInk.isValidPlacementSequence(placementString)) {
                    // place piece
                    draggable.snapToGrid();
                    if (IQStars.fixOrientations(placementString) != null && IQStars.fixOrientations(placementString).equals(iqStars.getSolution())) {
                        showCompletion();
                    }
                } else {
                    piecePlacements[piece.piece.ordinal()] = IQStars.NOT_PLACED;
                    draggable.snapToHome();
                }
            } else {
                draggable.snapToHome();
            }
        });

        /* event handlers */
/*
        setOnScroll(event -> {            // scroll to change orientation
            draggable.rotate();
            if (draggable.onBoard()) {
                draggable.setPosition();
                String placementString = getPlacementString();
                if (IQStars.isValidPlacement(placementString)) {
                    // place piece
                    draggable.snapToGrid();
                } else {
                    piecePlacements[draggable.piece.ordinal()] = IQStars.NOT_PLACED;
                    draggable.snapToHome();
                }
            } else {
                draggable.snapToHome();
            }
            event.consume();
        });
    }



    protected void drag(double movementX, double movementY, ImageView imageView) {
        imageView.setLayoutX(imageView.getLayoutX() + movementX);
        imageView.setLayoutY(imageView.getLayoutY() + movementY);
        /*
        for (Star star : stars) {
            star.setTranslateX(getLayoutX());
            star.setTranslateY(getLayoutY());
        }
         */



    //copied from ass1
/*
    class tile extends Polygon{
        double mouseX,mouseY;
        double startX,startY;
        FXTile tile;
        tile(double startX, double startY, FXTile tile){
            this.startX = startX;
            this.startY = startY;
            setLayoutX(startX);
            setLayoutY(startY);
            this.tile = tile;
            if (tile instanceof DraggableFXTile) {
                DraggableFXTile draggable = (DraggableFXTile) tile;
                setOnMousePressed(event -> {      // mouse press indicates begin of drag
                    mouseX = event.getSceneX();
                    mouseY = event.getSceneY();
                });

                setOnMouseDragged(event -> {      // mouse is being dragged
                    draggable.toFront();
                    double movementX = event.getSceneX() - mouseX;
                    double movementY = event.getSceneY() - mouseY;
                    draggable.drag(movementX, movementY);
                    mouseX = event.getSceneX();
                    mouseY = event.getSceneY();
                });

                setOnMouseReleased(event -> {     // drag is complete
                    if (draggable.onBoard()) {
                        draggable.setPosition();
                        String placementString = getPlacementString();
                        if (RailroadInk.isValidPlacementSequence(placementString)) {
                            // place piece
                            draggable.snapToGrid();
                            if (IQStars.fixOrientations(placementString) != null && IQStars.fixOrientations(placementString).equals(iqStars.getSolution())) {
                                showCompletion();
                            }
                        } else {
                            piecePlacements[piece.piece.ordinal()] = IQStars.NOT_PLACED;
                            draggable.snapToHome();
                        }
                    } else {
                        draggable.snapToHome();
                    }
                });

                /* event handlers */
/*
                setOnScroll(event -> {            // scroll to change orientation
                    draggable.rotate();
                    if (draggable.onBoard()) {
                        draggable.setPosition();
                        String placementString = getPlacementString();
                        if (IQStars.isValidPlacement(placementString)) {
                            // place piece
                            draggable.snapToGrid();
                        } else {
                            piecePlacements[draggable.piece.ordinal()] = IQStars.NOT_PLACED;
                            draggable.snapToHome();
                        }
                    } else {
                        draggable.snapToHome();
                    }
                    event.consume();
                });
            }
        }
    }
    */

    /*
    class DraggableFXTile extends FXTile {
        double homeX, homeY;         // the position in the window where the piece should be when not on the board

        /**
         * Construct a draggable piece
         *
         * @param id The piece identifier ('A' - 'L')
         */
/*
        DraggableFXTile(char id) {
            super(id);

            int index = id - 'A';
            int homeCol = (index % PIECES_PER_HOME_ROW);
            this.homeX = homeCol * HEX_HEIGHT * (Piece.MAX_PIECE_WIDTH + 0.4) + HEX_HEIGHT;
            int homeRow = index / PIECES_PER_HOME_ROW;
            this.homeY = BOARD_HEIGHT + MARGIN_Y + HEX_HEIGHT * 0.5 + Piece.MAX_PIECE_WIDTH * HEX_HEIGHT * homeRow;

            snapToHome();
        }

        protected void drag(double movementX, double movementY) {
            setLayoutX(getLayoutX() + movementX);
            setLayoutY(getLayoutY() + movementY);
            for (Star star : stars) {
                star.setTranslateX(getLayoutX());
                star.setTranslateY(getLayoutY());
                star.setOpacity(0.5);
                star.toFront();
            }
        }
    }

    class FXTile extends Group {
        final Tile tile;
        int col;
        int row;
        int rotation;
        Rotate rotate;
        List<Star> stars = new ArrayList<>();
        boolean invisible = false;

        FXTile(char id) {
            if (!(id >= 'A' && id <= 'L')) {
                throw new IllegalArgumentException("Bad piece id: '" + id + "'");
            }
            piece = Piece.valueOf(String.valueOf(id));

            Color pieceColor = getColorForPiece(piece);

            for (Hex hex : piece.shape) {
                double xOffset = hex.row % 2 == 0 ? 0 : 0.5;
                // distance between rows is 3/4 HEX_HEIGHT; distance between columns is HEX_WIDTH
                Star star = new Star((xOffset + hex.col) * HEX_WIDTH, hex.row * 3.0 / 4 * HEX_HEIGHT, pieceColor, this);
                stars.add(star);
                pieces.getChildren().add(star);
            }

            rotate = new Rotate(); // Pivot X Top-Left corner
            rotate.setPivotX(0);
            rotate.setPivotY(0);
            getTransforms().add(rotate);
        }
    }
    */
