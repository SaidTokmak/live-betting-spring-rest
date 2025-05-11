package com.saidtokmak.livebetting.dto.betslip;

import com.saidtokmak.livebetting.enums.BetTypes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SlipBulletinDTO {

    private String bulletinId;
    private Float oldOdds;
    private Float newOdds;
    private BetTypes betType;
}
