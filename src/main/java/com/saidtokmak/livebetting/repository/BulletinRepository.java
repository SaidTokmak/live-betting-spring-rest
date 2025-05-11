package com.saidtokmak.livebetting.repository;

import com.saidtokmak.livebetting.entity.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BulletinRepository extends JpaRepository<Bulletin, UUID> {
}
