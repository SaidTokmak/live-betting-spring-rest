package com.saidtokmak.livebetting.service;

import com.saidtokmak.livebetting.dto.betslip.BetSlipDTO;
import com.saidtokmak.livebetting.dto.betslip.CreateBetSlipRequestDTO;
import com.saidtokmak.livebetting.dto.betslip.CreateBetSlipResponseDTO;

import java.util.List;

public interface BetSlipService {

    CreateBetSlipResponseDTO createBetSlip(CreateBetSlipRequestDTO createBetSlipRequestDTO);
    List<BetSlipDTO> getAllBetSlips();
}
