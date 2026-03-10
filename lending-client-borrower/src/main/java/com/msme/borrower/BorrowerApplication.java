package com.msme.borrower;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BorrowerApplication extends Application {

  @Override
  public void start(Stage primaryStage) {
    // Apply AtlantaFX Primer Light theme for the borrower app
    Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

    StackPane root = new StackPane(new Label("MSME Lending Borrower Application"));
    Scene scene = new Scene(root, 800, 600);

    primaryStage.setTitle("MSME Lending Sandbox - Borrower");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
