package com.msme.repositories;

import com.msme.models.BorrowerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowerRepository extends JpaRepository<BorrowerProfile, UUID> {
  Optional<BorrowerProfile> findByEmail(String email);
}
