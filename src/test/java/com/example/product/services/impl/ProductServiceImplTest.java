package com.example.product.services.impl;

import static org.mockito.ArgumentMatchers.anyString;

import com.example.existingApis.models.ProductDetail;
import com.example.existingApis.models.SimilarProducts;
import com.example.product.proxy.ExistingApiClientRest;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Victor Munayco</li>
 * </ul>
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

  @Mock
  private ExistingApiClientRest existingApiClientRest;

  @InjectMocks
  private ProductServiceImpl productService;

  @Test
  public void getProductSimilarTest() {

    SimilarProducts similarProducts = new SimilarProducts();
    similarProducts.add(0,"1");

    ProductDetail productDetail = new ProductDetail()
            .id("1").availability(true)
            .price(new BigDecimal(1.0))
            .name("a");

    Mockito.when(existingApiClientRest.similarids(anyString())).thenReturn( similarProducts);
    Mockito.when(existingApiClientRest.productId(anyString())).thenReturn(productDetail);

    var test = productService.getProductSimilar("1");

    Assertions.assertEquals("1", test.get(0).getId());

  }

}