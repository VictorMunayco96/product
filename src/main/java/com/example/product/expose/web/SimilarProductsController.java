package com.example.product.expose.web;

import com.example.product.services.ProductService;
import com.example.similarProducts.api.ProductApi;
import com.example.similarProducts.models.SimilarProducts;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Victor Munayco</li>
 * </ul>
 * @version 1.0
 */
@RestController
public class SimilarProductsController implements ProductApi {

  @Autowired
  private ProductService productService;

  @Override
  public ResponseEntity<SimilarProducts> getProductSimilar(String productId) {

    SimilarProducts similarProducts = Optional.ofNullable(productService.getProductSimilar(productId))
            .orElse(new SimilarProducts());

    if (similarProducts.size() > 0) {
      return new ResponseEntity<>(similarProducts, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new SimilarProducts(), HttpStatus.NO_CONTENT);
    }
  }

}
