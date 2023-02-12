package com.andchen;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class SnakeGameApplication extends Application {
    public static int x = 75;
    public static int y = 95;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApplication.class.getResource("hello-view.fxml"));
        stage.setTitle( "Click the Target!" );

        Group root = new Group();

        Scene scene = new Scene( root );
        stage.setScene( scene );

        Canvas canvas = new Canvas( 500, 500 );
        root.getChildren().add( canvas );

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            if(key.getCode() == KeyCode.RIGHT) {
                x += 5;
            } else if(key.getCode() == KeyCode.LEFT) {
                x += -5;
            } else if(key.getCode() == KeyCode.UP) {
                y += 5;
            } else if(key.getCode() == KeyCode.DOWN) {
                y += -5;
            }
        });

        GraphicsContext gc = canvas.getGraphicsContext2D();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // Clear the canvas
                gc.setFill(Color.LIGHTBLUE);
                gc.fillRect(0,0, 512,512);

                gc.setFill(Color.DARKBLUE);
                gc.fillRect(x,y, 30,30);
            }

        }.start();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}