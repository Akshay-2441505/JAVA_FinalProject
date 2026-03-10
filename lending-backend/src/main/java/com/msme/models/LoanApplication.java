package com.msme.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loan_applications")
@Data
@NoArgsConstructor
public class LoanApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID appId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "borrower_id", nullable = false)
  private BorrowerProfile borrower;

  @Column(nullable = false)
  private BigDecimal requestedAmount;

  @Column(nullable = false)
  private Integer tenureMonths;

  private String purpose;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private LoanStatus status = LoanStatus.PENDING;

  private Integer riskScore;

  // Storing JSON or comma-separated flags
  private String riskFlags;

  @Column(updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  private LocalDateTime updatedAt = LocalDateTime.now();

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
