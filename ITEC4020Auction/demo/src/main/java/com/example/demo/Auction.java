package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "auction")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionID;

    @OneToOne
    @JoinColumn(name = "item_id")
    private CatalogueItem item;

    @OneToOne
    @JoinColumn(name = "winning_bid_id")
    private Bid winningBid; 

    private boolean isActive;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String auctionType;
    

    public Auction() {}

    public Auction(CatalogueItem itemOnAuction, LocalDateTime startTime, LocalDateTime endTime, String auctionType) {
        this.item = itemOnAuction;
        this.startTime = startTime;
        this.endTime = endTime;
        this.auctionType = auctionType;
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public void setWinningBid(Bid winningBid) {
        this.winningBid = winningBid;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }
}
