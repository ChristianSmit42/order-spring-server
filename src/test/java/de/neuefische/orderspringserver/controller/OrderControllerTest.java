package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.db.OrderDb;
import de.neuefische.orderspringserver.model.Order;
import de.neuefische.orderspringserver.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderDb orderDb;

    @BeforeEach
    public void resetDatabase(){
        orderDb.clearDb();
    }

    @Test
    public void getAllOrdersShouldReturnEmptyList() {
        // GIVEN
        // WHEN
        ResponseEntity<Order[]> response = restTemplate.getForEntity("http://localhost:" + port + "/order/allOrders", Order[].class);
        HttpStatus statusCode = response.getStatusCode();
        Order[] orders = response.getBody();
        // THEN
        assertEquals(0, orders.length);
    }

    @Test
    public void addOrdershouldAddOrderToDbAndReturnOrder(){
        // PUT
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("420", "Pflaume"));
        products.add(new Product("240", "Birne"));

        Order order =new Order("1",products);
        HttpEntity<Order> requestEntity = new HttpEntity<>(order);

        // WHEN
        ResponseEntity<Order> putResponse = restTemplate.exchange("http://localhost:"+port+"/order/addOrder", HttpMethod.PUT,requestEntity, Order.class);

        // THEN
        assertEquals(HttpStatus.OK,putResponse.getStatusCode());
        assertNotNull(putResponse.getBody());
        assertEquals(order,putResponse.getBody());
        assertTrue(orderDb.listOfOrders().contains(order));
    }

    @Test
    public void getAllOrdersShouldReturnAllOrders() {
        // POST
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("420", "Pflaume"));
        products.add(new Product("240", "Birne"));

        orderDb.addOrder(new Order("1",products));
        orderDb.addOrder(new Order("2",products));
        // WHEN

        ResponseEntity<Order[]> response = restTemplate.getForEntity("http://localhost:"+port+"/order/allOrders", Order[].class);
        HttpStatus statusCode = response.getStatusCode();
        assertEquals(HttpStatus.OK,statusCode);
        // THEN
        assertEquals(new Order("1",products),response.getBody()[0]);
        assertEquals(new Order("2",products),response.getBody()[1]);


    }

}