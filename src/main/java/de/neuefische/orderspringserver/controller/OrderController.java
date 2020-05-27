package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.Order;
import de.neuefische.orderspringserver.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("order")
public class OrderController {
    private OrderService orderService = new OrderService();

    @GetMapping("allOrders")
    public Collection<Order> allOrders(){
        return Collections.unmodifiableCollection(orderService.listOrders());
    }

    @GetMapping("{searchParameter}")
    public Collection<Order> getOrderById(@PathVariable() String searchParameter){
        return Collections.unmodifiableCollection(orderService.getOrderById(searchParameter));
    }


    @PutMapping("addOrder")
    public void addOrder(@RequestBody Order order){
        orderService.addOrder(order);
    }


}
