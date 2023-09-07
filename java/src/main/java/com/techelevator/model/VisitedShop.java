package com.techelevator.model;

public class VisitedShop {

    private int shopId;
    private int userId;

    public VisitedShop() {}

    public VisitedShop(int shopId, int userId) {
        this.shopId = shopId;
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
