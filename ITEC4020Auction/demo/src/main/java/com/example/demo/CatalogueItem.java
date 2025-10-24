package com.example.demo;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalogue_items")
public class CatalogueItem {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String itemName;
    private String description;
    private int startingPrice;
    private int reservePrice;
    private int shippingCost;



    // Relationship: many items can belong to one seller (User)
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    // Relationship: one item can have one auction
   @OneToOne(mappedBy = "item")
    private Auction auction;

    public CatalogueItem() {}

    public CatalogueItem(String itemName, String description, int startingPrice, int reservePrice, int shippingCost, User seller) {
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.reservePrice = reservePrice;
        this.seller = seller;
        this.shippingCost = shippingCost;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }

    public int getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    public int getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(int shippingCost) {
        this.shippingCost = shippingCost;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
