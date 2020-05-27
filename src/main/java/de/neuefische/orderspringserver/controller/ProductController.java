package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.Product;
import de.neuefische.orderspringserver.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;


@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("product")
public class ProductController {
    private ProductService productService = new ProductService();

    @GetMapping("allProducts")
    public Collection<Product> listAll(){
        return Collections.unmodifiableCollection(productService.listAll());
    }

    @GetMapping("{searchParameter}")
    public Collection<Product> findProducts(@PathVariable() String searchParameter){
        return Collections.unmodifiableCollection(productService.searchProducts(searchParameter));
    }

}
