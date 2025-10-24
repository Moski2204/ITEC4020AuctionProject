package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "bids")
public class Bid {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    private boolean bidWinStatus;

    @ManyToOne
    @JoinColumn(name = "bidder_id")
    private User bidder;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBidWinStatus() {
        return bidWinStatus;
    }

    public void setBidWinStatus(boolean bidWinStatus) {
        this.bidWinStatus = bidWinStatus;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    // public CatalogueItem getItem() {
    //     return auction.getitem;
    // }

   

}