package com.example.product.proxy;

import com.example.existingApis.models.ProductDetail;
import com.example.existingApis.models.SimilarProducts;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Victor Munayco</li>
 * </ul>
 * @version 1.0
 */
@FeignClient(name = "foo", url = "${url-existing-api}")
public interface ExistingApiClientRest {

  @GetMapping("/product/{productId}/similarids")
  SimilarProducts similarids(@PathVariable String productId);

  @GetMapping("/product/{productId}")
  ProductDetail productId(@PathVariable String productId);

}
