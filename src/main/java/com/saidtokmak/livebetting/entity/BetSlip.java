package com.saidtokmak.livebetting.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "betslips")
public class BetSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id")
    private String customerId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "bet_slip_bulletin",
            joinColumns = @JoinColumn(name = "bet_slip_id"),
            inverseJoinColumns = @JoinColumn(name = "bulletin_id")
    )
    private List<Bulletin> bulletins;

    @Column(name = "multiple_bet_count")
    private Integer multipleBetCount;

    @Column(name = "bet_amount")
    private Double betAmount;

    @Column(name = "potential_payout")
    private Double potentialPayout;

    private String status = "PENDING";

    @Column(name = "created_at")
    @CreationTimestamp
    private String createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private String updatedAt;
}
