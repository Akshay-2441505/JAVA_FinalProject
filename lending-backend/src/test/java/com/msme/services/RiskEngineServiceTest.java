package com.msme.services;

import com.msme.models.BorrowerProfile;
import com.msme.models.LoanApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RiskEngineServiceTest {

  private RiskEngineService riskEngineService;

  @BeforeEach
  void setUp() {
    riskEngineService = new RiskEngineService();
  }

  @Test
  void testEvaluateRisk_HighDebtRatio() {
    BorrowerProfile profile = new BorrowerProfile();
    profile.setAnnualTurnover(new BigDecimal("100000")); // 1 Lakh
    profile.setNetProfitDetails(new BigDecimal("10000"));

    LoanApplication app = new LoanApplication();
    app.setRequestedAmount(new BigDecimal("60000")); // 60k is > 50% of 1 Lakh

    RiskEngineService.RiskAssessment result = riskEngineService.evaluateRisk(app, profile);

    assertTrue(result.flags().contains("HIGH_DEBT_RATIO"));
    assertEquals(75, result.score()); // 100 - 25
  }

  @Test
  void testEvaluateRisk_LowProfitMargin() {
    BorrowerProfile profile = new BorrowerProfile();
    profile.setAnnualTurnover(new BigDecimal("1000000"));
    profile.setNetProfitDetails(new BigDecimal("20000")); // 2% profit margin

    LoanApplication app = new LoanApplication();
    app.setRequestedAmount(new BigDecimal("100000"));

    RiskEngineService.RiskAssessment result = riskEngineService.evaluateRisk(app, profile);

    assertTrue(result.flags().contains("LOW_PROFIT_MARGIN"));
    assertEquals(85, result.score()); // 100 - 15
  }

  @Test
  void testEvaluateRisk_HighAmountRequest() {
    BorrowerProfile profile = new BorrowerProfile();
    profile.setAnnualTurnover(new BigDecimal("20000000"));
    profile.setNetProfitDetails(new BigDecimal("2000000"));

    LoanApplication app = new LoanApplication();
    app.setRequestedAmount(new BigDecimal("6000000")); // > 50Lakhs

    RiskEngineService.RiskAssessment result = riskEngineService.evaluateRisk(app, profile);

    assertTrue(result.flags().contains("HIGH_AMOUNT_REQUEST"));
    assertEquals(90, result.score()); // 100 - 10
  }
}
