package com.techelevator.controller;

import com.techelevator.dao.JdbcShopDao;
import com.techelevator.dao.ShopDao;
import com.techelevator.model.CoffeeShop;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: add preauth

@CrossOrigin
@RestController
public class ShopController {
    private ShopDao shopDao;

    public ShopController(ShopDao shopDao){
        this.shopDao = shopDao;
    }

    @RequestMapping(path = "/shops", method = RequestMethod.GET)
    public List<CoffeeShop> getAllShops(){
        return shopDao.getShopList();
    }

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public List<CoffeeShop> getShopListForAdmin() {
        return shopDao.getShopListForAdmin();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addshops", method = RequestMethod.POST)
    public void addNewShop(@RequestBody CoffeeShop coffeeShop) {
        shopDao.addNewShop(coffeeShop);
    }

    @RequestMapping(path= "/approved/{id}", method = RequestMethod.PUT)
    public List<CoffeeShop> approveShop(@PathVariable("id") int shopId) {
        return shopDao.approveShop(shopId);

    }

    @RequestMapping(path= "/unapproved/{id}", method = RequestMethod.PUT)
    public List<CoffeeShop> unApproveShop(@PathVariable("id") int shopId) {
        return shopDao.unApproveShop(shopId);
    }

    @RequestMapping(path= "/delete/{id}", method = RequestMethod.DELETE)
    public List<CoffeeShop> deleteShop(@PathVariable("id") int shopId) {
        return shopDao.deleteShop(shopId);
    }
}
