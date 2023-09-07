package com.techelevator.dao;

import com.techelevator.model.FavoritedShop;
import com.techelevator.model.VisitedShop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVisitedShopsDao  implements VisitedShopDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcVisitedShopsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<VisitedShop> getVisitedShopsList(int userId) {
        List<VisitedShop> shopsOutput = new ArrayList<>();
        String sql = "SELECT coffee_shops.shop_id AS coffee_shop_id, users.user_id AS current_user_id, shop_name\n" +
                "FROM coffee_shops\n" +
                "JOIN visited ON visited.shop_id = coffee_shops.shop_id\n" +
                "JOIN users on users.user_id = visited.user_id\n" +
                "WHERE users.user_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            VisitedShop shop = new VisitedShop();
            shop.setShopId(results.getInt("coffee_shop_id"));
            shop.setUserId(results.getInt("current_user_id"));
            shopsOutput.add(shop);
        }
        return shopsOutput;
    }

    @Override
    public VisitedShop addVisitedShop(VisitedShop visitedShop) {

        VisitedShop shop = new VisitedShop();

        String sql = "INSERT INTO visited\n" +
                "VALUES (?, ?)\n" +
                "RETURNING shop_id, user_id";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, visitedShop.getUserId(), visitedShop.getShopId());
        if(result.next()) {
            shop.setUserId(result.getInt("user_id"));
            shop.setShopId(result.getInt("shop_id"));
        }
        return shop;
    }

    @Override
    public void deleteShop(int shopId, int userId) {
        String sql = "DELETE FROM visited WHERE shop_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, shopId, userId);
    }

}
