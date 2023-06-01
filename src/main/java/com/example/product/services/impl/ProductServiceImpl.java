package com.example.product.services.impl;

import static com.example.product.util.BodyResponseBuilder.convertToProductDetailResponse;

import com.example.existingApis.models.ProductDetail;
import com.example.product.proxy.ExistingApiClientRest;
import com.example.product.services.ProductService;
import com.example.similarProducts.models.SimilarProducts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Victor Munayco</li>
 * </ul>
 * @version 1.0
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ExistingApiClientRest existingApiClientRest;

  @Override
  public SimilarProducts getProductSimilar(String productId) {

    com.example.existingApis.models.SimilarProducts similarProductsFeign;
    try {
      similarProductsFeign = existingApiClientRest.similarids(productId);
    } catch (Exception ex) {
      return null;
    }

    SimilarProducts similarProductsResponse = new SimilarProducts();
    similarProductsFeign.forEach(listSimilarId -> {
      ProductDetail productDetail;
      try {
        productDetail = existingApiClientRest.productId(listSimilarId);
        similarProductsResponse.add(convertToProductDetailResponse(productDetail));
      } catch (Exception e) {
        log.info(e.getMessage());
      }
    });
    return similarProductsResponse;
  }
}