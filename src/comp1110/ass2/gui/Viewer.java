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
     * used to set the proper rotation
     * @param a
     * @param n
     */
    static ImageView rotation(ImageView a, int n){
        if (n > 3){
            a.usesMirroring();
            n = n - 4;
        }
        if (n == 1){
            a.setRotate(90);
        }
        if (n == 2){
            a.setRotate(180);
        }
        if (n == 3){
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
        int n = 0;
        switch (placement.substring(0,2)){
            case "A0":
                Image A0 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A0.png").toString());
                ImageView a0 = new ImageView(A0);
                a0.setFitHeight(80);
                a0.setFitWidth(80);
                a0.setX(450 + 80 * Integer.valueOf(placement.substring(3,4)));
                a0.setY(90 + 80 * (placement.charAt(2) - 'A'));
                rotation(a0, Integer.valueOf(placement.substring(4,5)));
                root.getChildren().add(a0);
        }

        Image A1 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A1.png").toString());
        Image A2 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A2.png").toString());
        Image A3 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A3.png").toString());
        Image A4 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A4.png").toString());
        Image A5 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"A5.png").toString());
        Image B0 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B0.png").toString());
        Image B1 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B1.png").toString());
        Image B2 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B2.png").toString());
        Image B3 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"B3.png").toString());
        Image S0 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S0.png").toString());
        Image S1 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S1.png").toString());
        Image S2 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S2.png").toString());
        Image S3 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S3.png").toString());
        Image S4 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S4.png").toString());
        Image S5 = new Image(Viewer.class.getResource(Viewer.URI_BASE+"S5.png").toString());


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

        //set highway exits
        Image highexit = new Image(Viewer.class.getResource(Viewer.URI_BASE + "HighExit.png").toString());
        ImageView viewhigh1 = new ImageView(highexit);
        viewhigh1.setX(520);
        viewhigh1.setY(20);
        viewhigh1.setFitWidth(100);
        viewhigh1.setFitHeight(100);
        root.getChildren().add(viewhigh1);

        ImageView viewhigh2 = new ImageView(highexit);
        viewhigh2.setX(840);
        viewhigh2.setY(20);
        viewhigh2.setFitWidth(100);
        viewhigh2.setFitHeight(100);
        root.getChildren().add(viewhigh2);

        ImageView viewhigh3 = new ImageView(highexit);
        viewhigh3.setRotate(270);
        viewhigh3.setX(380);
        viewhigh3.setY(320);
        viewhigh3.setFitWidth(100);
        viewhigh3.setFitHeight(100);
        root.getChildren().add(viewhigh3);

        ImageView viewhigh4 = new ImageView(highexit);
        viewhigh4.setRotate(90);
        viewhigh4.setX(980);
        viewhigh4.setY(320);
        viewhigh4.setFitWidth(100);
        viewhigh4.setFitHeight(100);
        root.getChildren().add(viewhigh4);

        ImageView viewhigh5 = new ImageView(highexit);
        viewhigh5.setRotate(180);
        viewhigh5.setX(520);
        viewhigh5.setY(620);
        viewhigh5.setFitWidth(100);
        viewhigh5.setFitHeight(100);
        root.getChildren().add(viewhigh5);

        ImageView viewhigh6 = new ImageView(highexit);
        viewhigh6.setRotate(180);
        viewhigh6.setX(840);
        viewhigh6.setY(620);
        viewhigh6.setFitWidth(100);
        viewhigh6.setFitHeight(100);
        root.getChildren().add(viewhigh6);

        //set railway exits
        Image railexit = new Image(Viewer.class.getResource(Viewer.URI_BASE+"RailExit.png").toString());
        ImageView viewrail1 = new ImageView(railexit);
        viewrail1.setX(680);
        viewrail1.setY(20);
        viewrail1.setFitWidth(100);
        viewrail1.setFitHeight(100);
        root.getChildren().add(viewrail1);

        ImageView viewrail2 = new ImageView(railexit);
        viewrail2.setRotate(270);
        viewrail2.setX(380);
        viewrail2.setY(160);
        viewrail2.setFitWidth(100);
        viewrail2.setFitHeight(100);
        root.getChildren().add(viewrail2);

        ImageView viewrail3 = new ImageView(railexit);
        viewrail3.setRotate(270);
        viewrail3.setX(380);
        viewrail3.setY(480);
        viewrail3.setFitWidth(100);
        viewrail3.setFitHeight(100);
        root.getChildren().add(viewrail3);

        ImageView viewrail4 = new ImageView(railexit);
        viewrail4.setRotate(90);
        viewrail4.setX(980);
        viewrail4.setY(160);
        viewrail4.setFitWidth(100);
        viewrail4.setFitHeight(100);
        root.getChildren().add(viewrail4);

        ImageView viewrail5 = new ImageView(railexit);
        viewrail5.setRotate(90);
        viewrail5.setX(980);
        viewrail5.setY(480);
        viewrail5.setFitWidth(100);
        viewrail5.setFitHeight(100);
        root.getChildren().add(viewrail5);

        ImageView viewrail6 = new ImageView(railexit);
        viewrail6.setRotate(180);
        viewrail6.setX(680);
        viewrail6.setY(620);
        viewrail6.setFitWidth(100);
        viewrail6.setFitHeight(100);
        root.getChildren().add(viewrail6);



        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        root.getChildren().add(m);
        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
