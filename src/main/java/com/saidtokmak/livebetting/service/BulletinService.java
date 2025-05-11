package com.saidtokmak.livebetting.service;

import com.saidtokmak.livebetting.dto.BulletinDTO;
import com.saidtokmak.livebetting.dto.CreateBulletinRequestDTO;

import java.util.List;
import java.util.UUID;

public interface BulletinService {

    String createBulletin(CreateBulletinRequestDTO createBulletinRequestDTO);
    List<BulletinDTO> getAllBulletins();
    BulletinDTO getBulletinById(String bulletinId);
    //void updateBulletin(UUID bulletinId, UpdateBulletinRequestDTO updateBulletinRequestDTO);
    void deleteBulletin(String bulletinId);
}
