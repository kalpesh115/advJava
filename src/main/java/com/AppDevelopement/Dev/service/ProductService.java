
package com.AppDevelopement.Dev.service;

import com.AppDevelopement.Dev.bean.ProductRequest;

public interface ProductService {

    String saveProduct(ProductRequest request);

    String getAllProduct();

    String getSingleProduct(int productId);

    String updateProduct(int productId,ProductRequest request);

    String deleteProduct(int productId);
}