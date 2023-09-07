package com.techelevator.controller;

import com.techelevator.dao.FavoritedShopDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FavoritedShop;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

//TODO: add preauth


//@PreAuthorize("isAuthenticated")
@CrossOrigin
@RestController
public class FavoritedController {

    private FavoritedShopDao favoritedShopDao;
    private UserDao userDao;

    public FavoritedController(FavoritedShopDao favoritedShopDao, UserDao userDao) {
        this.favoritedShopDao = favoritedShopDao;
        this.userDao = userDao;
    }


    @RequestMapping(path="/favorites", method= RequestMethod.GET)
    public List<FavoritedShop> getAllFavoritedShops(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        List<FavoritedShop> favorites = favoritedShopDao.getFavoriteShopsList(userId);
        if (favorites == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found.");
        } else {
            return favorites;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/favorites/{id}", method = RequestMethod.POST)
    public FavoritedShop addShopToFavorites(@PathVariable("id") int shopId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        FavoritedShop favoritedShop = new FavoritedShop(shopId, userId);
        return favoritedShopDao.addFavorite(favoritedShop);
    }

    @RequestMapping(path="/favorites/{id}", method = RequestMethod.DELETE)
    public void deleteFavoriteShop(@PathVariable("id") int shopId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        favoritedShopDao.deleteShop(shopId, userId);
    }

}
