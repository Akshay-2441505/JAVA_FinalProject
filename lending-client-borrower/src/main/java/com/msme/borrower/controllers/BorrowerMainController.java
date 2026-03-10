package com.msme.borrower.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class BorrowerMainController {

  @FXML
  private StackPane contentArea;

  @FXML
  public void initialize() {
    showProfile();
  }

  @FXML
  public void showProfile() {
    loadView("/fxml/Profile.fxml");
  }

  @FXML
  public void showApplyLoan() {
    loadView("/fxml/ApplyLoan.fxml");
  }

  private void loadView(String fxmlPath) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
      Node view = loader.load();
      contentArea.getChildren().setAll(view);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
