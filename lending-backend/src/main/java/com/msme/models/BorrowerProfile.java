package com.msme.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "borrower_profiles")
@Data
@NoArgsConstructor
public class BorrowerProfile {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String passwordHash;

  @Column(nullable = false)
  private String name;

  private String gstin;

  // Financial Data (For Risk Engine)
  private BigDecimal annualTurnover;
  private BigDecimal netProfitDetails;
}
