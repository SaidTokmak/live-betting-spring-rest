package com.saidtokmak.livebetting.dto.betslip;

import lombok.Data;

import java.util.List;

@Data
public class CreateBetSlipResponseDTO {

    private List<SlipBulletinDTO> slipBulletins;
    private String betSlipId;
    private int multipleBetCount;
    private double betAmount;
    private String betSlipStatus;
    private String betSlipCreatedAt;
    private double potentialWinAmount;

}
