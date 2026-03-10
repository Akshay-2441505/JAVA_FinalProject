package com.msme.admin;

import atlantafx.base.theme.PrimerDark;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AdminApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Apply AtlantaFX Primer Dark theme for a sleek modern look
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        StackPane root = new StackPane(new Label("MSME Lending Admin Area"));
        Scene scene = new Scene(root, 1024, 768);

        primaryStage.setTitle("MSME Lending Sandbox - Admin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
