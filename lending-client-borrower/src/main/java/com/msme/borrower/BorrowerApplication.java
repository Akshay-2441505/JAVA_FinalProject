package com.msme.borrower;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class BorrowerApplication extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Apply AtlantaFX Primer Light theme for the borrower app
    Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
    Scene scene = new Scene(loader.load(), 1000, 700);

    primaryStage.setTitle("MSME Lending Sandbox - Borrower");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
