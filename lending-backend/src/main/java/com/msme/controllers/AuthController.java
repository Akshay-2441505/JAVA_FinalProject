package com.msme.controllers;

import com.msme.controllers.dto.AuthLoginRequest;
import com.msme.controllers.dto.AuthRegisterRequest;
import com.msme.models.BorrowerProfile;
import com.msme.repositories.BorrowerRepository;
import com.msme.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  @Autowired
  private BorrowerRepository borrowerRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtService jwtService;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody @Valid AuthRegisterRequest request) {
    if (borrowerRepository.findByEmail(request.getEmail()).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
    }

    BorrowerProfile profile = new BorrowerProfile();
    profile.setEmail(request.getEmail());
    profile.setPasswordHash(passwordEncoder.encode(request.getPassword()));
    profile.setName(request.getName());
    profile.setGstin(request.getGstin());
    profile.setAnnualTurnover(request.getAnnualTurnover());
    profile.setNetProfitDetails(request.getNetProfitDetails());

    borrowerRepository.save(profile);

    String token = jwtService.generateToken(profile.getEmail());
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody @Valid AuthLoginRequest request) {
    BorrowerProfile profile = borrowerRepository.findByEmail(request.getEmail()).orElse(null);

    if (profile == null || !passwordEncoder.matches(request.getPassword(), profile.getPasswordHash())) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    String token = jwtService.generateToken(profile.getEmail());
    Map<String, String> response = new HashMap<>();
    response.put("token", token);
    return ResponseEntity.ok(response);
  }
}
