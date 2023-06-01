package com.example.product.util;

import com.example.similarProducts.models.ProductDetail;

/**
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Victor Munayco</li>
 * </ul>
 * @version 1.0
 */
public class BodyResponseBuilder {

  /**
   * convertToProductDetailResponse.
   * @return convert to ProductDetail
   */
  public static ProductDetail convertToProductDetailResponse(
          com.example.existingApis.models.ProductDetail productDetail) {

    return new ProductDetail()
            .id(productDetail.getId())
            .name(productDetail.getName())
            .price(productDetail.getPrice())
            .availability(productDetail.isAvailability());

  }
}
