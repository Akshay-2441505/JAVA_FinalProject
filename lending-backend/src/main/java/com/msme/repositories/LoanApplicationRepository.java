package com.msme.repositories;

import com.msme.models.LoanApplication;
import com.msme.models.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, UUID> {
  List<LoanApplication> findByBorrower_Id(UUID borrowerId);

  List<LoanApplication> findByStatus(LoanStatus status);
}
