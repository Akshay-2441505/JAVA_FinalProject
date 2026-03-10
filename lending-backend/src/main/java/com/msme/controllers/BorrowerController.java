package com.msme.controllers;

import com.msme.controllers.dto.LoanApplicationRequest;
import com.msme.models.BorrowerProfile;
import com.msme.models.LoanApplication;
import com.msme.repositories.BorrowerRepository;
import com.msme.repositories.LoanApplicationRepository;
import com.msme.services.AmortizationService;
import com.msme.services.RiskEngineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/borrowers")
public class BorrowerController {

  @Autowired
  private LoanApplicationRepository loanRepository;

  @Autowired
  private BorrowerRepository borrowerRepository;

  @Autowired
  private RiskEngineService riskEngineService;

  @Autowired
  private AmortizationService amortizationService;

  // Helper to get authenticated user
  private BorrowerProfile getAuthenticatedUser() {
    return (BorrowerProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

  @GetMapping("/profile")
  public ResponseEntity<?> getProfile() {
    return ResponseEntity.ok(getAuthenticatedUser());
  }

  @PostMapping("/loans")
  public ResponseEntity<?> applyForLoan(@RequestBody @Valid LoanApplicationRequest request) {
    BorrowerProfile borrower = borrowerRepository.findById(getAuthenticatedUser().getId())
        .orElseThrow(() -> new RuntimeException("Borrower not found"));

    LoanApplication loan = new LoanApplication();
    loan.setBorrower(borrower);
    loan.setRequestedAmount(request.getRequestedAmount());
    loan.setTenureMonths(request.getTenureMonths());
    loan.setPurpose(request.getPurpose());

    // Evaluate Risk instantly using our engine
    RiskEngineService.RiskAssessment assessment = riskEngineService.evaluateRisk(loan, borrower);
    loan.setRiskScore(assessment.score());
    loan.setRiskFlags(String.join(",", assessment.flags()));

    loanRepository.save(loan);

    return ResponseEntity.status(HttpStatus.CREATED).body(loan);
  }

  @GetMapping("/loans")
  public ResponseEntity<List<LoanApplication>> myLoans() {
    return ResponseEntity.ok(loanRepository.findByBorrower_Id(getAuthenticatedUser().getId()));
  }

  @GetMapping("/calculate-emi")
  public ResponseEntity<?> calculateEmi(@RequestParam BigDecimal principal, @RequestParam int tenureMonths) {
    // Flat 12% sample interest
    BigDecimal emi = amortizationService.calculateMonthlyEmi(principal, 12.0, tenureMonths);
    Map<String, BigDecimal> response = new HashMap<>();
    response.put("monthlyEmi", emi);
    return ResponseEntity.ok(response);
  }
}
