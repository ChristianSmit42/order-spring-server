package de.neuefische.orderspringserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private ArrayList<Product> orderedProducts = new ArrayList<>();
}
