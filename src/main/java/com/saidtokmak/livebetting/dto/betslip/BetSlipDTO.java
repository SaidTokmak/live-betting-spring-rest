package com.saidtokmak.livebetting.dto.betslip;

import com.saidtokmak.livebetting.enums.BetTypes;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.UUID;

@Data
public class BetSlipDTO {

    private UUID id;
    private String customerId;
    private String bulletinId;
    private BetTypes betType;
    private Float oldOdds;
    private Float newOdds;
    private Float stake;
    private Integer multipleBetCount;
    private Double potentialPayout;
    private String status;
}
