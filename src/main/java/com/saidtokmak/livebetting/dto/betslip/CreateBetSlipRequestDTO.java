package com.saidtokmak.livebetting.dto.betslip;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class CreateBetSlipRequestDTO {

    @NotNull(message = "Bet option cannot be null")
    @Max(value = 500, message = "Maximum 500 bet options are allowed")
    private int multipleBetCount;

    @NotNull(message = "Bet amount cannot be null")
    @DecimalMax(value = "10000.0", message = "Bet amount cannot exceed 10000")
    private double betAmount;

    @NotNull(message = "At least one bulletin is required")
    List<SlipBulletinRequestDTO> slipBulletins;
}
