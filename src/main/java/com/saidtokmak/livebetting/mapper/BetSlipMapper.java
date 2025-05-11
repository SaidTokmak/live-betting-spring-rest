package com.saidtokmak.livebetting.mapper;

import com.saidtokmak.livebetting.dto.betslip.BetSlipDTO;
import com.saidtokmak.livebetting.entity.BetSlip;
import org.mapstruct.Mapper;

@Mapper
public interface BetSlipMapper {

    BetSlipDTO toDTO(BetSlip betSlip);
}
