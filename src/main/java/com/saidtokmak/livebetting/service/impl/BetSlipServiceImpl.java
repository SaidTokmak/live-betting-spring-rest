package com.saidtokmak.livebetting.service.impl;

import com.saidtokmak.livebetting.dto.betslip.BetSlipDTO;
import com.saidtokmak.livebetting.dto.betslip.CreateBetSlipRequestDTO;
import com.saidtokmak.livebetting.dto.betslip.CreateBetSlipResponseDTO;
import com.saidtokmak.livebetting.dto.betslip.SlipBulletinDTO;
import com.saidtokmak.livebetting.dto.bulletin.BulletinDTO;
import com.saidtokmak.livebetting.entity.BetSlip;
import com.saidtokmak.livebetting.entity.Bulletin;
import com.saidtokmak.livebetting.enums.BetTypes;
import com.saidtokmak.livebetting.mapper.BetSlipMapper;
import com.saidtokmak.livebetting.mapper.BulletinMapper;
import com.saidtokmak.livebetting.repository.BetSlipRepository;
import com.saidtokmak.livebetting.service.BetSlipService;
import com.saidtokmak.livebetting.service.BulletinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class BetSlipServiceImpl implements BetSlipService {

    private final BulletinService bulletinService;
    private final BetSlipRepository betSlipRepository;
    private final BulletinMapper bulletinMapper;
    private final BetSlipMapper betSlipMapper;

    @Override
    @Transactional(timeout = 2, isolation = Isolation.READ_UNCOMMITTED)
    public CreateBetSlipResponseDTO createBetSlip(CreateBetSlipRequestDTO createBetSlipRequestDTO) {
        CreateBetSlipResponseDTO response = new CreateBetSlipResponseDTO();

        List<SlipBulletinDTO> responseSlipBulletinsDTO = new ArrayList<>();
        List<Bulletin> bulletins = new ArrayList<>();

        AtomicReference<Double> totalOdds = new AtomicReference<>(1.0);

        createBetSlipRequestDTO.getSlipBulletins().forEach(bulletin -> {
            BulletinDTO bulletinById = bulletinService.getBulletinById(bulletin.getEventId());
            bulletins.add(bulletinMapper.toEntityFromBulletinDTO(bulletinById));
            Float odds = getOdds(bulletinById, bulletin.getBetType());
            totalOdds.updateAndGet(v -> v * odds);
            responseSlipBulletinsDTO.add(SlipBulletinDTO.builder()
                    .bulletinId(bulletinById.getBulletinId().toString())
                    .betType(bulletin.getBetType())
                    .oldOdds(odds).build());
        });

        BetSlip betSlip = new BetSlip();
        betSlip.setMultipleBetCount(createBetSlipRequestDTO.getMultipleBetCount());
        betSlip.setStatus("PENDING");
        betSlip.setPotentialPayout(createBetSlipRequestDTO.getMultipleBetCount() * createBetSlipRequestDTO.getBetAmount() * totalOdds.get());
        betSlip.setBulletins(bulletins);
        betSlip.setBetAmount(createBetSlipRequestDTO.getBetAmount());

        BetSlip savedBetSlip = betSlipRepository.saveAndFlush(betSlip);

        response.setBetSlipId(savedBetSlip.getId().toString());
        response.setBetAmount(savedBetSlip.getBetAmount());
        response.setPotentialWinAmount(savedBetSlip.getPotentialPayout());
        response.setMultipleBetCount(savedBetSlip.getMultipleBetCount());
        response.setBetSlipStatus(savedBetSlip.getStatus());
        response.setBetSlipCreatedAt(savedBetSlip.getCreatedAt());
        response.setSlipBulletins(responseSlipBulletinsDTO);

        createBetSlipRequestDTO.getSlipBulletins().forEach(bulletin -> {
            BulletinDTO bulletinById = bulletinService.getBulletinById(bulletin.getEventId());
            response.getSlipBulletins().stream()
                    .filter(slipBulletinDTO -> slipBulletinDTO.getBulletinId().equals(bulletin.getEventId()))
                    .findFirst()
                    .ifPresent(slipBulletinDTO -> {
                        slipBulletinDTO.setNewOdds(getOdds(bulletinById, bulletin.getBetType()));
                    });
        });

        return response;
    }

    private float getOdds(BulletinDTO bulletinById, BetTypes betType) {
        return switch (betType) {
            case HOME_WIN -> bulletinById.getHomeWinOdds();
            case AWAY_WIN -> bulletinById.getAwayWinOdds();
            case DRAW -> bulletinById.getDrawOdds();
            default -> 1;
        };
    }

    @Override
    public List<BetSlipDTO> getAllBetSlips() {
        return betSlipRepository.findAll().stream()
                .map(betSlipMapper::toDTO)
                .toList();
    }
}
