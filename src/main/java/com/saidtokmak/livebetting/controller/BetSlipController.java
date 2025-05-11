package com.saidtokmak.livebetting.controller;

import com.saidtokmak.livebetting.dto.betslip.BetSlipDTO;
import com.saidtokmak.livebetting.dto.betslip.CreateBetSlipRequestDTO;
import com.saidtokmak.livebetting.dto.betslip.CreateBetSlipResponseDTO;
import com.saidtokmak.livebetting.service.BetSlipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bet-slips")
public class BetSlipController {

    private final BetSlipService betSlipService;

    @PostMapping
    public ResponseEntity<CreateBetSlipResponseDTO> createSlip(@Valid @RequestBody CreateBetSlipRequestDTO request) {
        return new ResponseEntity<>(betSlipService.createBetSlip(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BetSlipDTO>> getAllBetSlips() {
        return new ResponseEntity<>(betSlipService.getAllBetSlips(), HttpStatus.OK);
    }
}
