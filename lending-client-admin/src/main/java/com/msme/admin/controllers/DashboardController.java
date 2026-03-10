package com.msme.admin.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.chart.XYChart;

public class DashboardController {

  @FXML
  private PieChart loanStatusChart;

  @FXML
  private LineChart<String, Number> trendingChart;

  @FXML
  private Label totalLoansLabel;

  @FXML
  private Label totalAmountLabel;

  @FXML
  public void initialize() {
    // Placeholder data logic, would be replaced by HTTP calls to /api/v1/admin/...
    loadDummyData();
  }

  private void loadDummyData() {
    // Populate PieChart
    PieChart.Data approved = new PieChart.Data("Approved", 45);
    PieChart.Data rejected = new PieChart.Data("Rejected", 10);
    PieChart.Data pending = new PieChart.Data("Pending", 25);
    loanStatusChart.getData().addAll(approved, rejected, pending);

    // Populate LineChart
    XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.setName("Loan Volume");
    series.getData().add(new XYChart.Data<>("Jan", 100));
    series.getData().add(new XYChart.Data<>("Feb", 120));
    series.getData().add(new XYChart.Data<>("Mar", 150));
    series.getData().add(new XYChart.Data<>("Apr", 130));
    trendingChart.getData().add(series);

    totalLoansLabel.setText("80");
    totalAmountLabel.setText("₹15,000,000");
  }
}
