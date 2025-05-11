package com.saidtokmak.livebetting.controller;

import com.saidtokmak.livebetting.dto.bulletin.BulletinDTO;
import com.saidtokmak.livebetting.dto.bulletin.CreateBulletinRequestDTO;
import com.saidtokmak.livebetting.service.BulletinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bulletins")
@RequiredArgsConstructor
public class BulletinController {

    private final BulletinService bulletinService;

    @GetMapping
    public ResponseEntity<List<BulletinDTO>> getAllBulletins() {
        return new ResponseEntity<>(bulletinService.getAllBulletins(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBulletin(@Valid @RequestBody CreateBulletinRequestDTO request) {
        return new ResponseEntity<>(bulletinService.createBulletin(request), HttpStatus.CREATED);
    }

    @GetMapping("/bulletin-id/{bulletinId}")
    public ResponseEntity<BulletinDTO> getAllBulletins(@PathVariable String bulletinId) {
        return new ResponseEntity<>(bulletinService.getBulletinById(bulletinId), HttpStatus.OK);
    }

    @DeleteMapping("/bulletin-id/{bulletinId}")
    public ResponseEntity<String> deleteBulletin(@PathVariable String bulletinId) {
        bulletinService.deleteBulletin(bulletinId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
