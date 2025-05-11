package com.saidtokmak.livebetting.service.impl;

import com.saidtokmak.livebetting.dto.BulletinDTO;
import com.saidtokmak.livebetting.dto.CreateBulletinRequestDTO;
import com.saidtokmak.livebetting.entity.Bulletin;
import com.saidtokmak.livebetting.mapper.BulletinMapper;
import com.saidtokmak.livebetting.repository.BulletinRepository;
import com.saidtokmak.livebetting.service.BulletinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BulletinServiceImpl implements BulletinService {

    private final BulletinRepository bulletinRepository;
    private final BulletinMapper bulletinMapper;

    @Override
    public String createBulletin(CreateBulletinRequestDTO createBulletinRequestDTO) {
        Bulletin bulletin = bulletinRepository.save(bulletinMapper.toEntity(createBulletinRequestDTO));
        return bulletin.getId().toString();
    }

    @Override
    public List<BulletinDTO> getAllBulletins() {
        return bulletinRepository.findAll()
                .stream()
                .map(bulletinMapper::toDTO)
                .toList();
    }

    @Override
    public BulletinDTO getBulletinById(String bulletinId) {
        return bulletinRepository.findById(UUID.fromString(bulletinId))
                .map(bulletinMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Bulletin not found"));
    }

    @Override
    public void deleteBulletin(String bulletinId) {
        bulletinRepository.deleteById(UUID.fromString(bulletinId));
    }
}
