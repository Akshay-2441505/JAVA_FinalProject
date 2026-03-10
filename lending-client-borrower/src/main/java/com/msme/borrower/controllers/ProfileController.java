package com.msme.borrower.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProfileController {

  @FXML
  private Label nameLabel;

  @FXML
  private Label emailLabel;

  @FXML
  private Label gstinLabel;

  @FXML
  private Label turnoverLabel;

  @FXML
  public void initialize() {
    // Fetch from /api/v1/borrowers/profile
    nameLabel.setText("Acme Corporation");
    emailLabel.setText("admin@acmecorp.com");
    gstinLabel.setText("22AAAAA0000A1Z5");
    turnoverLabel.setText("₹ 5,000,000");
  }
}
