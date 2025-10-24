package com.example.demo;
import jakarta.persistence.*;

@Entity
@Table(name = "dutch_auction")
public class DutchAuction extends Auction {
 private double decrementRate;

    public double getDecrementRate() {
        return decrementRate;
    }

    public void setDecrementRate(double decrementRate) {
        this.decrementRate = decrementRate;
    }



    
}

