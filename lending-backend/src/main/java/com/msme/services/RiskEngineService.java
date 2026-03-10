package com.msme.services;

import com.msme.models.BorrowerProfile;
import com.msme.models.LoanApplication;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class RiskEngineService {

  public record RiskAssessment(int score, List<String> flags) {
  }

  public RiskAssessment evaluateRisk(LoanApplication app, BorrowerProfile profile) {
    int score = 100;
    List<String> flags = new ArrayList<>();

    // Rule 1: Debt-to-Turnover Ratio
    if (profile.getAnnualTurnover() != null && profile.getAnnualTurnover().compareTo(BigDecimal.ZERO) > 0) {
      BigDecimal ratio = app.getRequestedAmount().divide(profile.getAnnualTurnover(), 2, RoundingMode.HALF_UP);
      if (ratio.compareTo(new BigDecimal("0.5")) > 0) {
        score -= 25;
        flags.add("HIGH_DEBT_RATIO");
      }
    } else {
      score -= 20;
      flags.add("NO_TURNOVER_DECLARED");
    }

    // Rule 2: Profit Margin Check
    if (profile.getNetProfitDetails() != null && profile.getAnnualTurnover() != null
        && profile.getAnnualTurnover().compareTo(BigDecimal.ZERO) > 0) {
      BigDecimal profitMargin = profile.getNetProfitDetails().divide(profile.getAnnualTurnover(), 2,
          RoundingMode.HALF_UP);
      if (profitMargin.compareTo(new BigDecimal("0.05")) < 0) {
        score -= 15;
        flags.add("LOW_PROFIT_MARGIN");
      }
    } else {
      score -= 10;
      flags.add("MISSING_PROFIT_DATA");
    }

    // Rule 3: High amount request generic flag
    if (app.getRequestedAmount().compareTo(new BigDecimal("5000000")) > 0) {
      score -= 10;
      flags.add("HIGH_AMOUNT_REQUEST");
    }

    return new RiskAssessment(Math.max(0, score), flags);
  }
}
