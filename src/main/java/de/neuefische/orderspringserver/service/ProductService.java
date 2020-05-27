package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Product;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;


@NoArgsConstructor
@Service
public class ProductService {
    private ProductDb productDb = new ProductDb();

    public Collection<Product> listAll(){
        return Collections.unmodifiableCollection(productDb.listAll());
    }

    public Collection<Product> searchProducts(String searchParameter){
        return Collections.unmodifiableCollection(productDb.getProducts(searchParameter));
    }
}


