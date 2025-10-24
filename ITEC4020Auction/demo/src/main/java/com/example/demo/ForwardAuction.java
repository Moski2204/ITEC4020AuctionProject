package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "forward_auction")
public class ForwardAuction extends Auction {

    private double remainingAuctionTime;

   @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Bid> bids = new ArrayList<>();

    public double getRemainingAuctionTime() {
        return remainingAuctionTime;
    }

    public void setRemainingAuctionTime(double remainingAuctionTime) {
        this.remainingAuctionTime = remainingAuctionTime;
    }


}