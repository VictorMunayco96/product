package com.example.product.services;

import com.example.similarProducts.models.SimilarProducts;

/**
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Victor Munayco</li>
 * </ul>
 * @version 1.0
 */
public interface ProductService {

  SimilarProducts getProductSimilar(String productId);

}
