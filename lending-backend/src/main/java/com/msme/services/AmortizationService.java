package com.msme.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class AmortizationService {

  /**
   * Calculates the monthly EMI using the formula:
   * EMI = P x R x (1+R)^N / [(1+R)^N-1]
   */
  public BigDecimal calculateMonthlyEmi(BigDecimal principal, double annualInterestRate, int tenureMonths) {
    if (principal == null || annualInterestRate <= 0 || tenureMonths <= 0) {
      return BigDecimal.ZERO;
    }

    double monthlyInterestRate = annualInterestRate / 12 / 100;
    double mathPow = Math.pow(1 + monthlyInterestRate, tenureMonths);
    double emi = principal.doubleValue() * monthlyInterestRate * mathPow / (mathPow - 1);

    return new BigDecimal(emi).setScale(2, RoundingMode.HALF_UP);
  }
}
