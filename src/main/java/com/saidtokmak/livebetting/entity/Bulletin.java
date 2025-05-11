package com.saidtokmak.livebetting.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "bulletins")
public class Bulletin {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Column(name = "league_name")
    private String leagueName;

    @Column(name = "home_team")
    private String homeTeam;

    @Column(name = "away_team")
    private String awayTeam;

    @Column(name = "home_win_odds")
    private Float homeWinOdds;

    @Column(name = "draw_odds")
    private Float drawOdds;

    @Column(name = "away_win_odds")
    private Float awayWinOdds;

    @Column(name = "match_start_time")
    private Date matchStartTime;

    @ManyToMany(mappedBy = "bulletins")
    private List<BetSlip> betSlips;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

}
