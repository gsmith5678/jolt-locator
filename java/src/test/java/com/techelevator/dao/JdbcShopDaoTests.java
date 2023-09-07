package com.techelevator.dao;

import com.techelevator.model.CoffeeShop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcShopDaoTests extends BaseDaoTests{

    private static final CoffeeShop COFFEE_SHOP_1 = new CoffeeShop(1,"test_name", "test_image", "test_link", 1, 1, "test_highlights", "test_menu",
            "9-5", "9-5", "9-5", "9-5", "9-5", "9-5", "9-5", 39.91948f,-82.99417f, 10 , "test_address", 1, 1, true);

    private JdbcShopDao dao;


    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcShopDao(jdbcTemplate);
    }

    @Test
    public void getShopList_finds_shop_information() {
        List<CoffeeShop> coffeeShop = dao.getShopList();
        Assert.assertEquals(1, coffeeShop.size());
        Assert.assertEquals(COFFEE_SHOP_1.getShopId(), coffeeShop.get(0).getShopId());
        Assert.assertEquals(COFFEE_SHOP_1.getShop(), coffeeShop.get(0).getShop());
        Assert.assertEquals(COFFEE_SHOP_1.getAddress(), coffeeShop.get(0).getAddress());
        Assert.assertEquals(COFFEE_SHOP_1.getMonday(), coffeeShop.get(0).getMonday());
    }





}
