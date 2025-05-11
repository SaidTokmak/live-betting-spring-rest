package com.saidtokmak.livebetting.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OddsUpdater {

    @Scheduled(cron = "*/1 * * * * ?")
    public static void updateOdds(String bulletinId, Float homeWinOdds, Float drawOdds, Float awayWinOdds) {
        // Logic to update the odds in the bulletin

        // This is a placeholder for the actual implementation
        System.out.println("Updating odds for bulletin ID: " + bulletinId);
        System.out.println("Home Win Odds: " + homeWinOdds);
        System.out.println("Draw Odds: " + drawOdds);
        System.out.println("Away Win Odds: " + awayWinOdds);
    }
}
