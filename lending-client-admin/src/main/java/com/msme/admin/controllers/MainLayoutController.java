package com.msme.admin.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainLayoutController {

  @FXML
  private StackPane contentArea;

  @FXML
  public void initialize() {
    showDashboard();
  }

  @FXML
  public void showDashboard() {
    loadView("/fxml/Dashboard.fxml");
  }

  @FXML
  public void showLoans() {
    loadView("/fxml/LoanList.fxml");
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
