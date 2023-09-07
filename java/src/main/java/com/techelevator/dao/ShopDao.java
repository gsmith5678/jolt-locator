package com.techelevator.dao;

import com.techelevator.model.CoffeeShop;

import java.util.List;

public interface ShopDao {
    List<CoffeeShop> getShopList();
    void addNewShop(CoffeeShop coffeeShop);

    List<CoffeeShop> getShopListForAdmin();

    List<CoffeeShop> approveShop(int shopId);

    List<CoffeeShop> unApproveShop(int shopId);

    List<CoffeeShop> deleteShop(int shopId);
}

