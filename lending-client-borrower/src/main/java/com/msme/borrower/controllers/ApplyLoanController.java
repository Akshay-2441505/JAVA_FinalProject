package com.msme.borrower.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ApplyLoanController {

  @FXML
  private TextField amountField;

  @FXML
  private TextField tenureField;

  @FXML
  private ComboBox<String> purposeComboBox;

  @FXML
  public void initialize() {
    purposeComboBox.setItems(FXCollections.observableArrayList(
        "Working Capital",
        "Equipment Purchase",
        "Business Expansion",
        "Debt Refinancing"));
  }

  @FXML
  public void handleSubmit() {
    if (amountField.getText().isEmpty() || tenureField.getText().isEmpty() || purposeComboBox.getValue() == null) {
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Validation Error");
      alert.setHeaderText(null);
      alert.setContentText("Please fill in all fields.");
      alert.showAndWait();
      return;
    }

    System.out.println("Submitting loan for: " + amountField.getText());
    // Call API /api/v1/borrowers/loans -> Navigate to Success or My Loans

    Alert success = new Alert(AlertType.INFORMATION);
    success.setTitle("Application Submitted");
    success.setHeaderText(null);
    success.setContentText("Your loan application has been submitted and is under review.");
    success.showAndWait();
  }
}
