package com.msme.controllers.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class LoanApplicationRequest {
  @NotNull(message = "Requested amount is required")
  @Min(value = 1000, message = "Minimum loan amount is 1000")
  private BigDecimal requestedAmount;

  @NotNull(message = "Tenure is required")
  @Min(value = 1, message = "Minimum tenure is 1 month")
  private Integer tenureMonths;

  private String purpose;
}
