package com.hohmeister.evosim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) {
        final Scene scene = new Scene(new StackPane(new Label("Hello World")), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
