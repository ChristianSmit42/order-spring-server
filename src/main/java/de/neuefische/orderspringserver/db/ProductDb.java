package de.neuefische.orderspringserver.db;

import de.neuefische.orderspringserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;


@Repository
public class ProductDb {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductDb(){
        products.add(new Product(UUID.randomUUID().toString(), "Karotte"));
        products.add(new Product(UUID.randomUUID().toString(), "Tomate"));
        products.add(new Product(UUID.randomUUID().toString(), "Kiwi"));
        products.add(new Product(UUID.randomUUID().toString(), "Marmelade"));
    }


    public Collection<Product> listAll() {
        return Collections.unmodifiableCollection(products);
    }

    public Collection<Product> getProducts(String searchParameter) {
        ArrayList<Product> matchingProducts= new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().startsWith(searchParameter.toLowerCase()) || product.getId().toLowerCase().startsWith(searchParameter.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }
}
