package com.techelevator.dao;

import com.techelevator.model.CoffeeShop;
import com.techelevator.model.FavoritedShop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFavoritedShopDao implements FavoritedShopDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFavoritedShopDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<FavoritedShop> getFavoriteShopsList(int userId) {
        List<FavoritedShop> shopsOutput = new ArrayList<FavoritedShop>();
        String sql = "SELECT coffee_shops.shop_id AS coffee_shop_id, users.user_id AS current_user_id, shop_name\n" +
                "FROM coffee_shops\n" +
                "JOIN favorites ON favorites.shop_id = coffee_shops.shop_id\n" +
                "JOIN users on users.user_id = favorites.user_id\n" +
                "WHERE users.user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            FavoritedShop shop = new FavoritedShop();
            shop.setShopId(results.getInt("coffee_shop_id"));
            shop.setUserId(results.getInt("current_user_id"));
            shopsOutput.add(shop);
        }
        return shopsOutput;
    }

    @Override
    public FavoritedShop addFavorite(FavoritedShop favoritedShop) {
        FavoritedShop shop = new FavoritedShop();

        String sql = "INSERT INTO favorites\n" +
                "VALUES (?, ?)\n" +
                "RETURNING shop_id, user_id";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, favoritedShop.getUserId(), favoritedShop.getShopId());
        if(result.next()) {
            shop.setUserId(result.getInt("user_id"));
            shop.setShopId(result.getInt("shop_id"));
        }
        return shop;
    }

    @Override
    public void deleteShop(int shopId, int userId) {
        String sql = "DELETE FROM favorites WHERE shop_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, shopId, userId);
    }
}
