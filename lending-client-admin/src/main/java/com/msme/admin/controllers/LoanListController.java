package com.msme.admin.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LoanListController {

  @FXML
  private TableView<LoanApplicationViewModel> loanTable;

  @FXML
  private TableColumn<LoanApplicationViewModel, String> idColumn;

  @FXML
  private TableColumn<LoanApplicationViewModel, String> borrowerColumn;

  @FXML
  private TableColumn<LoanApplicationViewModel, String> amountColumn;

  @FXML
  private TableColumn<LoanApplicationViewModel, String> statusColumn;

  @FXML
  private TableColumn<LoanApplicationViewModel, Integer> scoreColumn;

  @FXML
  public void initialize() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    borrowerColumn.setCellValueFactory(new PropertyValueFactory<>("borrowerName"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    scoreColumn.setCellValueFactory(new PropertyValueFactory<>("riskScore"));

    // Placeholder
    loadDummyData();
  }

  private void loadDummyData() {
    ObservableList<LoanApplicationViewModel> data = FXCollections.observableArrayList(
        new LoanApplicationViewModel("APP-101", "Acme Corp", "₹5,000,000", "PENDING", 85),
        new LoanApplicationViewModel("APP-102", "Global Tech", "₹1,000,000", "APPROVED", 95));
    loanTable.setItems(data);
  }

  // Inner view model for the table
  public static class LoanApplicationViewModel {
    private String id;
    private String borrowerName;
    private String amount;
    private String status;
    private int riskScore;

    public LoanApplicationViewModel(String id, String borrowerName, String amount, String status, int riskScore) {
      this.id = id;
      this.borrowerName = borrowerName;
      this.amount = amount;
      this.status = status;
      this.riskScore = riskScore;
    }

    public String getId() {
      return id;
    }

    public String getBorrowerName() {
      return borrowerName;
    }

    public String getAmount() {
      return amount;
    }

    public String getStatus() {
      return status;
    }

    public int getRiskScore() {
      return riskScore;
    }
  }
}
