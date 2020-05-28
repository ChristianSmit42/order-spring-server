package de.neuefische.orderspringserver.db;

import de.neuefische.orderspringserver.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Repository
public class OrderDb {
    private ArrayList<Order> orders = new ArrayList<>();

    public Collection<Order> listOfOrders(){
        return Collections.unmodifiableCollection(orders);
    }
    public Collection<Order> getOrderById(String id){
        ArrayList<Order> matchingOrders = new ArrayList<>();
        for(Order order:orders){
            if(order.getId().toLowerCase().startsWith(id.toLowerCase())){
                matchingOrders.add(order);
            }
        }
        return Collections.unmodifiableCollection(matchingOrders);
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public void clearDb(){
        this.orders.clear();
    }

}
