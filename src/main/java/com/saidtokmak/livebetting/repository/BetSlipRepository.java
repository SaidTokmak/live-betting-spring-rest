package com.saidtokmak.livebetting.repository;

import com.saidtokmak.livebetting.entity.BetSlip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BetSlipRepository extends JpaRepository<BetSlip, UUID> {
}
