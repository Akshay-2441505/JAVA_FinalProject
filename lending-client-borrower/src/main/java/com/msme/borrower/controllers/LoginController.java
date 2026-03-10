package com.msme.borrower.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

  @FXML
  private TextField emailField;

  @FXML
  private PasswordField passwordField;

  @FXML
  public void handleLogin(javafx.event.ActionEvent event) {
    // Authenticate via API /api/v1/auth/login
    System.out.println("Logging in: " + emailField.getText());

    // On success, navigate to Main Dashboard
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BorrowerMain.fxml"));
      Parent root = loader.load();
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(new Scene(root, 1000, 700));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void handleRegister() {
    System.out.println("Switching to registration view...");
    // Handle navigation to a Registration.fxml
  }
}
