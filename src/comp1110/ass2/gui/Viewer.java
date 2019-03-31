package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

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
        JFrame jFrame=new JFrame("Board");
        //设置窗口的大小（7个格子，每个格子宽，高为100个像素）
        jFrame.setSize(700,700);
        //窗口的位置
        jFrame.setLocation(300,300);
        //格子的行数，列数
        int m=7;
        //格子的像素
        int n=100;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                //在每个位置添加标签
                JLabel jLabel=new JLabel();
                //标签的大小为格子的大小
                jLabel.setSize(n,n);
                //标签的位置为索引乘以格子的高度/宽度
                jLabel.setLocation(i*n,j*n);
                //放置黑色方块
                jLabel.setBackground(Color.WHITE);
                //设置边框颜色
                jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                //设置不透明度为不透明
                jLabel.setOpaque(true);
                jFrame.add(jLabel);
            }
        }
        //窗体设置可见
        jFrame.setVisible(true);
        //关闭退出
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
