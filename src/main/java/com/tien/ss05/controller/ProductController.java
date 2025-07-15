package com.tien.ss05.controller;

import com.tien.ss05.model.dto.response.DataResponse;
import com.tien.ss05.model.entity.Product;
import com.tien.ss05.model.wrapper.ProductList;
import com.tien.ss05.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Product>>> getProducts() {
        return new ResponseEntity<>(new DataResponse<>(productService.getAllProducts(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<ProductList> getProductsXml() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ProductList(products));
    }

    @PostMapping
    public ResponseEntity<DataResponse<Product>> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(new DataResponse<>(productService.createProduct(product), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Product>> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(new DataResponse<>(updatedProduct, HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<String>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(new DataResponse<>("Xóa thành công", HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
    }


}
