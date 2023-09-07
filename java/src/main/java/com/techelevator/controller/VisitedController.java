package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VisitedShopDao;
import com.techelevator.model.FavoritedShop;
import com.techelevator.model.VisitedShop;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class VisitedController {


    private VisitedShopDao visitedShopDao;
    private UserDao userDao;

    public VisitedController(VisitedShopDao visitedShopDao, UserDao userDao) {
        this.visitedShopDao = visitedShopDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="/visited", method= RequestMethod.GET)
    public List<VisitedShop> getAllVisitedShops(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        List<VisitedShop> visited = visitedShopDao.getVisitedShopsList(userId);
        if (visited == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found.");
        } else {
            return visited;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/visited/{id}", method = RequestMethod.POST)
    public VisitedShop addShopToVisited(@PathVariable("id") int shopId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        VisitedShop visitedShop = new VisitedShop(shopId, userId);
        return visitedShopDao.addVisitedShop(visitedShop);
    }

    @RequestMapping(path="/visited/{id}", method = RequestMethod.DELETE)
    public void deleteVisitedShop(@PathVariable("id") int shopId, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        visitedShopDao.deleteShop(shopId, userId);
    }

}
