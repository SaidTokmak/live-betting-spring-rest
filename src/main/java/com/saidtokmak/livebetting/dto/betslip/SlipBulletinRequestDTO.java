package com.saidtokmak.livebetting.dto.betslip;

import com.saidtokmak.livebetting.enums.BetTypes;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SlipBulletinRequestDTO {

    @NotNull(message = "Event ID cannot be null")
    private String eventId;

    @NotNull(message = "Bet type cannot be null")
    private BetTypes betType;
}
