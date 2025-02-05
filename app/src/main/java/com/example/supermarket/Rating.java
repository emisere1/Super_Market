package com.example.supermarket;

public class Rating {

    private int ratingID;
    private String marketAddress;
    private String market;
    private String liquor;
    private String produce;
    private String meat;
    private String cheese;
    private String checkout;

    public Rating() {
        ratingID = -1;
    }

    public int getRatingID() {
        return ratingID;
    }
    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }
    public String getMarketAddress() {
        return marketAddress;
    }
    public void setMarketAddress(String marketAddress) {
        this.marketAddress = marketAddress;
    }
    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }
    public String getLiquor() {
        return liquor;
    }
    public void setLiquor(String liquor) {
        this.liquor = liquor;
    }
    public String getProduce() {
        return produce;
    }
    public void setProduce(String produce) {
        this.produce = produce;
    }
    public String getMeat() {
        return meat;
    }
    public void setMeat(String meat) {
        this.meat = meat;
    }
    public String getCheese() {
        return cheese;
    }
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }
    public String getCheckout() {
        return checkout;
    }
    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
