package com.saidtokmak.livebetting.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BulletinDTO {

    private UUID bulletinId;
    private String title;
    private String leagueName;
    private String homeTeam;
    private String awayTeam;
    private Float homeWinOdds;
    private Float drawOdds;
    private Float awayWinOdds;
    private String matchStartTime;

}
