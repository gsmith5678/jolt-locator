package com.techelevator.dao;

import com.techelevator.model.VisitedShop;

import java.util.List;

public interface VisitedShopDao {

    List<VisitedShop> getVisitedShopsList(int userId);
    VisitedShop addVisitedShop(VisitedShop visitedShop);
    void deleteShop(int userId, int shopId);
}
