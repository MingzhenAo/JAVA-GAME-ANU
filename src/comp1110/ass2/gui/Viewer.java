package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1400;
    private static final int VIEWER_HEIGHT = 800;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        // FIXME Task 4: implement the simple placement viewer

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
        for(int i = 0; i < 7; i++) {
            ColumnConstraints column = new ColumnConstraints(80);
            m.getColumnConstraints().add(column);
        }

        for(int i = 0; i < 7; i++) {
            RowConstraints row = new RowConstraints(80);
            m.getRowConstraints().add(row);
        }
        m.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        m.setLayoutX(450);
        m.setLayoutY(90);

        //set exits
        Image highexit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "HighExit.png").toString());
        ImageView viewhigh1 = new ImageView(highexit);
        viewhigh1.setX(520);
        viewhigh1.setY(20);
        viewhigh1.setFitWidth(100);
        viewhigh1.setFitHeight(100);
        ImageView viewhigh2 = new ImageView(highexit);
        viewhigh2.setX(840);
        viewhigh2.setY(20);
        viewhigh2.setFitWidth(100);
        viewhigh2.setFitHeight(100);
        root.getChildren().add(viewhigh1);
        root.getChildren().add(viewhigh2);

        Image railexit = new Image(Viewer.class.getResource(Viewer.URI_BASE+"RailExit.jpg").toString());

        /*
        Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A0.jpg").toString());
        Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A1.jpg").toString());
        Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A2.jpg").toString());
        Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A3.jpg").toString());
        Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A4.jpg").toString());
        Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A5.jpg").toString());
        Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B0.jpg").toString());
        Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B1.jpg").toString());
        Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B2.jpg").toString());
        Image B3 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B3.jpg").toString());
        Image S0 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S0.jpg").toString());
        Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S1.jpg").toString());
        Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S2.jpg").toString());
        Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S3.jpg").toString());
        Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S4.jpg").toString());
        Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S5.jpg").toString());
        Image HighExit = new Image(Viewer.class.getResource(Viewer.URI_BASE+"HighExit.jpg").toString());
        Image RailExit = new Image(Viewer.class.getResource(Viewer.URI_BASE+"RailExit.jpg").toString());
        */

        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        root.getChildren().add(m);
        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
