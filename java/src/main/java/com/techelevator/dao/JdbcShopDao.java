package com.techelevator.dao;

import com.techelevator.model.CoffeeShop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcShopDao implements ShopDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcShopDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<CoffeeShop> getShopList() {
        List<CoffeeShop> shopsOutput = new ArrayList<>();
        String sql = "SELECT coffee_shops.shop_id, distance,shop_name, main_image, website_link, price_range, rating, highlights, menu_link, address, sunday, monday, tuesday, wednesday, thursday, friday, saturday, latitude, longitude\n" +
                "FROM coffee_shops\n" +
                "JOIN shop_address ON shop_address.shop_id = coffee_shops.shop_id\n" +
                "JOIN address ON shop_address.address_id = address.address_id\n" +
                "JOIN hours ON hours.shop_id = coffee_shops.shop_id\n" +
                "WHERE isApproved = true\n" +           //TODO: added this to not show anything false
                "ORDER BY shop_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            CoffeeShop shop = new CoffeeShop();
            shop.setShopId(results.getInt("shop_id"));
            shop.setShop(results.getString("shop_name"));
            shop.setImage(results.getString("main_image"));
            shop.setWebLink(results.getString("website_link"));
            shop.setPrice(results.getInt("price_range"));
            shop.setRating(results.getInt("rating"));
            shop.setHighlights(results.getString("highlights"));
            shop.setMenuLink(results.getString("menu_link"));
            shop.setAddress(results.getString("address"));
            shop.setSunday(results.getString("sunday"));
            shop.setMonday(results.getString("monday"));
            shop.setTuesday(results.getString("tuesday"));
            shop.setWednesday(results.getString("wednesday"));
            shop.setThursday(results.getString("thursday"));
            shop.setFriday(results.getString("friday"));
            shop.setSaturday(results.getString("saturday"));
            shop.setLatitude(results.getFloat("latitude"));
            shop.setLongitude(results.getFloat("longitude"));
            shop.setDistance(results.getInt("distance"));
            shopsOutput.add(shop);
        }
        return shopsOutput;
    }

    @Override
    public List<CoffeeShop> getShopListForAdmin() {
        List<CoffeeShop> shopsOutput = new ArrayList<>();
        String sql = "SELECT coffee_shops.shop_id, distance,shop_name, main_image, website_link, price_range, rating, highlights, menu_link, address, sunday, monday, tuesday, wednesday, thursday, friday, saturday, latitude, longitude, isapproved\n" +
                "FROM coffee_shops\n" +
                "JOIN shop_address ON shop_address.shop_id = coffee_shops.shop_id\n" +
                "JOIN address ON shop_address.address_id = address.address_id\n" +
                "JOIN hours ON hours.shop_id = coffee_shops.shop_id\n" +
                "ORDER BY shop_name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            CoffeeShop shop = new CoffeeShop();
            shop.setShopId(results.getInt("shop_id"));
            shop.setShop(results.getString("shop_name"));
            shop.setImage(results.getString("main_image"));
            shop.setWebLink(results.getString("website_link"));
            shop.setPrice(results.getInt("price_range"));
            shop.setRating(results.getInt("rating"));
            shop.setHighlights(results.getString("highlights"));
            shop.setMenuLink(results.getString("menu_link"));
            shop.setAddress(results.getString("address"));
            shop.setSunday(results.getString("sunday"));
            shop.setMonday(results.getString("monday"));
            shop.setTuesday(results.getString("tuesday"));
            shop.setWednesday(results.getString("wednesday"));
            shop.setThursday(results.getString("thursday"));
            shop.setFriday(results.getString("friday"));
            shop.setSaturday(results.getString("saturday"));
            shop.setLatitude(results.getFloat("latitude"));
            shop.setLongitude(results.getFloat("longitude"));
            shop.setDistance(results.getInt("distance"));
            shop.setApproved(results.getBoolean("isapproved"));
            shopsOutput.add(shop);
        }
        return shopsOutput;
    }

    @Override
    public List<CoffeeShop> approveShop(int shopId){
        String sql = "UPDATE coffee_shops\n" +
                "SET isApproved = true\n" +
                "WHERE shop_id = ?";
        jdbcTemplate.update(sql, shopId);
        List<CoffeeShop> shopsOutput = getShopListForAdmin();
        return shopsOutput;
    }

    @Override
    public List<CoffeeShop> unApproveShop(int shopId) {
        String sql = "UPDATE coffee_shops\n" +
                "SET isApproved = false\n" +
                "WHERE shop_id = ?";
        jdbcTemplate.update(sql, shopId);
        List<CoffeeShop> shopsOutput = getShopListForAdmin();
        return shopsOutput;
    }

    @Override
    public List<CoffeeShop> deleteShop(int shopId) {
        String sql = "DELETE FROM shop_address\n" +
                "WHERE shop_id = ?\n" +
                "RETURNING address_id\n";
        int addressId = jdbcTemplate.queryForObject(sql, Integer.class, shopId);
        String sql2 = "DELETE FROM address\n" +
                "WHERE address_id = ?";
        jdbcTemplate.update(sql2, addressId);
        String sql3 = "DELETE FROM hours\n" +
                "WHERE shop_id = ?\n";
        jdbcTemplate.update(sql3, shopId);
        String sql4 = "DELETE FROM favorites\n" +
                "WHERE shop_id = ?\n";
        jdbcTemplate.update(sql4, shopId);
        String sql5 = "DELETE FROM visited\n" +
                "WHERE shop_id = ?\n";
        jdbcTemplate.update(sql5, shopId);
        String sql6 = "DELETE FROM coffee_shops\n" +
                "WHERE shop_id = ?";
        jdbcTemplate.update(sql6, shopId);

        List<CoffeeShop> shopsOutput = getShopListForAdmin();
        return shopsOutput;
    }

    @Override
    public void addNewShop(CoffeeShop coffeeShop) {

        String sql = "INSERT INTO coffee_shops (shop_name, main_image, website_link, price_range, rating, highlights, menu_link, latitude, longitude) " +
                "VALUES (?,?,?,?,?,?,?,?,?) RETURNING shop_id; ";
        int shopId = jdbcTemplate.queryForObject(sql, Integer.class, coffeeShop.getShop(), coffeeShop.getImage(), coffeeShop.getWebLink(),
                coffeeShop.getPrice(), coffeeShop.getRating(), coffeeShop.getHighlights(), coffeeShop.getMenuLink(), coffeeShop.getLatitude(), coffeeShop.getLongitude());
        coffeeShop.setShopId(shopId);

        String sql2 = "INSERT INTO address (address) " +
                "VALUES (?) RETURNING address_id; ";
        int address = jdbcTemplate.queryForObject(sql2, Integer.class, coffeeShop.getAddress());
        coffeeShop.setAddressId(address);

        String sql3 = "INSERT INTO hours (shop_id, monday, tuesday, wednesday, thursday, friday, saturday, sunday) " +
                "VALUES (?,?,?,?,?,?,?,?) RETURNING hours_id; ";
        int hours = jdbcTemplate.queryForObject(sql3, Integer.class, shopId, coffeeShop.getMonday(), coffeeShop.getTuesday(), coffeeShop.getWednesday(), coffeeShop.getThursday(), coffeeShop.getFriday(), coffeeShop.getSaturday(), coffeeShop.getSunday());
        coffeeShop.setHoursId(hours);

        String sql4 = "INSERT INTO shop_address (shop_id, address_id) " +
                "VALUES (?,?); ";

        jdbcTemplate.update(sql4, shopId, address);


    }


}
