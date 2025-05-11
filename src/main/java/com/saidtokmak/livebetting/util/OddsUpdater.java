package com.saidtokmak.livebetting.util;

import com.saidtokmak.livebetting.entity.Bulletin;
import com.saidtokmak.livebetting.repository.BulletinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class OddsUpdater {

    private static final float minOdds = 1.0f;
    private static final float maxOdds = 4.0f;

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.00");

    private final BulletinRepository bulletinRepository;

    @Scheduled(cron = "*/1 * * * * ?")
    public void updateOdds() {
        List<Bulletin> bulletins = bulletinRepository.findAll();

        if (CollectionUtils.isEmpty(bulletins)) {
            System.out.println("No bulletins found to update.");
            return;
        }

        bulletins.forEach(bulletin -> {
            Random random = new Random();

            bulletin.setHomeWinOdds(Float.valueOf(decimalFormat.format(minOdds + random.nextFloat() * (maxOdds - minOdds))));
            bulletin.setDrawOdds(Float.valueOf(decimalFormat.format(random.nextFloat() * (maxOdds - minOdds) + minOdds)));
            bulletin.setAwayWinOdds(Float.valueOf(decimalFormat.format(random.nextFloat() * (maxOdds - minOdds) + minOdds)));

            bulletinRepository.saveAndFlush(bulletin);
        });
    }
}
