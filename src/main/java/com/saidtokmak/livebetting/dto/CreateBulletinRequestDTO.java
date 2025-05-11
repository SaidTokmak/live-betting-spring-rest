package com.saidtokmak.livebetting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CreateBulletinRequestDTO {

    private String title;

    @NotNull(message = "League name cannot be null")
    private String leagueName;

    @NotNull(message = "Home team cannot be null")
    private String homeTeam;

    @NotNull(message = "Away team cannot be null")
    private String awayTeam;

    @NotNull(message = "Home win odds cannot be null")
    private Float homeWinOdds;

    @NotNull(message = "Draw odds cannot be null")
    private Float drawOdds;

    @NotNull(message = "Away win odds cannot be null")
    private Float awayWinOdds;

    @NotNull(message = "Match start time cannot be null")
    private Date matchStartTime;
}
