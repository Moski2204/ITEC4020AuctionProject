package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;        

@Entity
@Table(name = "users")
public class User {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String firstName;
    private String lastName;

    private String userName;
    private String passWord;
    private String email;

    // Relationship: One User can list many items
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CatalogueItem> itemsListed = new ArrayList<>();

    // Relationship: One User can place many bids
    @OneToMany(mappedBy = "bidder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bid> bidsPlaced = new ArrayList<>();

    // Constructors
    public User() {}

    public User(String username, String password, String email, String firstName, String lastName) {
        this.userName = username;
        this.passWord = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

     public User(String username, String password, String email, String firstName, String lastName, int id) {
        this.userName = username;
        this.passWord = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = id;
    }
  

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CatalogueItem> getItemsListed() {
        return itemsListed;
    }

    public void setItemsListed(List<CatalogueItem> itemsListed) {
        this.itemsListed = itemsListed;
    }

    public List<Bid> getBidsPlaced() {
        return bidsPlaced;
    }

    public void setBidsPlaced(List<Bid> bidsPlaced) {
        this.bidsPlaced = bidsPlaced;
    }


}
