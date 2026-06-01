
package com.AppDevelopement.Dev.bean;

import lombok.Data;

@Data
public class ProductRequest {

    private String productName;

    private int quantity;

    private double price;

    private String description;
}
