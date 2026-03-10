package com.msme.services;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmortizationServiceTest {

  @Test
  void testCalculateMonthlyEmi() {
    AmortizationService service = new AmortizationService();

    // P=100000, R=12% annual, N=12 months
    // Expected EMI: ~8884.88
    BigDecimal principal = new BigDecimal("100000");
    double interest = 12.0;
    int months = 12;

    BigDecimal emi = service.calculateMonthlyEmi(principal, interest, months);

    assertEquals(new BigDecimal("8884.88"), emi);
  }
}
