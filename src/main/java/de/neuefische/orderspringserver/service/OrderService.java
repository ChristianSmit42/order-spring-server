package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.db.OrderDb;
import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderDb orderDb;

    public void addOrder(Order order){
        orderDb.addOrder(order);
    }

    public Collection<Order> listOrders(){
        return Collections.unmodifiableCollection(orderDb.listOfOrders());
    }

    public Collection<Order> getOrderById(String id){
        return orderDb.getOrderById(id);
    }
}
