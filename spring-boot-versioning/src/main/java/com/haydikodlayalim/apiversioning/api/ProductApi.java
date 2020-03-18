package com.haydikodlayalim.apiversioning.api;

import com.haydikodlayalim.apiversioning.dto.ProductV1;
import com.haydikodlayalim.apiversioning.dto.ProductV2;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductApi {

    // URI Versioning

    // http://localhost:8080/api/v1/product
    @GetMapping(value = "/v1/product")
    public ResponseEntity<ProductV1> pathVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
    }

    // http://localhost:8080/api/v2/product
    @GetMapping(value = "/v2/product")
    public ResponseEntity<ProductV2> pathVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
    }


    // Param Versioning
    // http://localhost:8080/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product", params = "apiVersion=1")
    public ResponseEntity<ProductV1> paramVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
    }

    // http://localhost:8080/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product",  params = "apiVersion=2")
    public ResponseEntity<ProductV2> paramVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
    }

    // Header Versioning
    // http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-API-VERSION=1")
    public ResponseEntity<ProductV1> headerVersioningProductV1() {
        return ResponseEntity.of(Optional.of(new ProductV1("HP Laptop")));
    }

    // http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product",  headers = "X-API-VERSION=2")
    public ResponseEntity<ProductV2> headerVersioningProductV2() {
        return ResponseEntity.of(Optional.of(new ProductV2("HP Laptop", BigDecimal.TEN)));
    }
}
