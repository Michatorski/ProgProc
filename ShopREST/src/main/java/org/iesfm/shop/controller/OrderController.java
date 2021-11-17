package org.iesfm.shop.controller;

import org.iesfm.shop.Order;
import org.iesfm.shop.dao.ClientDAO;
import org.iesfm.shop.dao.OrderDAO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OrderController {
    private ClientDAO clientDAO;
    private OrderDAO orderDAO;

    @RequestMapping(method = RequestMethod.GET, path = "/clients/{id}/orders")
    public List<Order> list(){
        List<Order> order = orderDAO.list();

        if (order == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ERROR 404, order not found"
            );
        } else {
            return order;
        }
    }

}
