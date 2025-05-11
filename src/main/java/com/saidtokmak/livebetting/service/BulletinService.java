package com.saidtokmak.livebetting.service;

import com.saidtokmak.livebetting.dto.BulletinDTO;
import com.saidtokmak.livebetting.dto.CreateBulletinRequestDTO;

import java.util.List;

public interface BulletinService {

    String createBulletin(CreateBulletinRequestDTO createBulletinRequestDTO);
    List<BulletinDTO> getAllBulletins();
    BulletinDTO getBulletinById(String bulletinId);
    void deleteBulletin(String bulletinId);
}
