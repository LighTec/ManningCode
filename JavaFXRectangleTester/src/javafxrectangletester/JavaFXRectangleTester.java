/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxrectangletester;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author kell-gigabyte
 */
public class JavaFXRectangleTester extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    private Rectangle rect;

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        this.rect = new Rectangle(20, 20, 200, 200);

        this.rect.setFill(Color.BLUE);
        Random r = new Random();

        this.rect.setOnMouseClicked((MouseEvent t) -> {
            changeRectColor(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        });

        this.rect.setStrokeWidth(3);
        this.rect.setStroke(Color.BLACK);
        group.getChildren().add(this.rect);

        Scene scene = new Scene(group, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void changeRectColor(int r, int g, int b) {
        this.rect.setFill(Color.rgb(r, g, b));
    }

}
