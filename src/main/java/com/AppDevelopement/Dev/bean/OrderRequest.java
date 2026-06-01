
package com.AppDevelopement.Dev.bean;

import lombok.Data;

@Data
public class OrderRequest {

    private int productId;

    private int orderQuantity;
}