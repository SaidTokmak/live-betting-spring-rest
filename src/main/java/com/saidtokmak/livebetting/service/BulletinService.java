package com.saidtokmak.livebetting.service;

import com.saidtokmak.livebetting.dto.bulletin.BulletinDTO;
import com.saidtokmak.livebetting.dto.bulletin.CreateBulletinRequestDTO;

import java.util.List;

public interface BulletinService {

    String createBulletin(CreateBulletinRequestDTO createBulletinRequestDTO);
    List<BulletinDTO> getAllBulletins();
    BulletinDTO getBulletinById(String bulletinId);
    void deleteBulletin(String bulletinId);
}
