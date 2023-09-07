package com.techelevator.dao;
import com.techelevator.model.FavoritedShop;

import java.util.List;

public interface FavoritedShopDao {

    List<FavoritedShop> getFavoriteShopsList(int userId);
    FavoritedShop addFavorite(FavoritedShop favoritedShop);
    void deleteShop(int userId, int shopId);

}
