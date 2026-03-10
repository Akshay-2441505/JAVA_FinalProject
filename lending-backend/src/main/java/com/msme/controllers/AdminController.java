package com.msme.controllers;

import com.msme.models.LoanApplication;
import com.msme.models.LoanStatus;
import com.msme.repositories.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

  @Autowired
  private LoanApplicationRepository loanRepository;

  @GetMapping("/loans")
  public ResponseEntity<List<LoanApplication>> getAllLoans() {
    return ResponseEntity.ok(loanRepository.findAll());
  }

  @GetMapping("/loans/status/{status}")
  public ResponseEntity<List<LoanApplication>> getLoansByStatus(@PathVariable LoanStatus status) {
    return ResponseEntity.ok(loanRepository.findByStatus(status));
  }

  @PatchMapping("/loans/{appId}/status")
  public ResponseEntity<?> updateLoanStatus(@PathVariable UUID appId, @RequestParam LoanStatus newStatus) {
    return loanRepository.findById(appId).map(loan -> {
      loan.setStatus(newStatus);
      loanRepository.save(loan);
      return ResponseEntity.ok(loan);
    }).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
