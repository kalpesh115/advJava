
package com.AppDevelopement.Dev.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppDevelopement.Dev.bean.OrderRequest;
import com.AppDevelopement.Dev.entity.Orders;
import com.AppDevelopement.Dev.entity.Product;
import com.AppDevelopement.Dev.repository.OrderRepo;
import com.AppDevelopement.Dev.repository.ProductRepo;
import com.AppDevelopement.Dev.service.OrderService;
import com.google.gson.JsonObject;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    @Override
    public String placeOrder(OrderRequest request) {

        Optional<Product> opt = productRepo.findById(request.getProductId());

        JsonObject obj = new JsonObject();

        if(opt.isPresent()) {

            Product product = opt.get();

            int availableQty = product.getQuantity();

            if(request.getOrderQuantity() > availableQty) {

                obj.addProperty("msg","Only "+availableQty+" products left");
                obj.addProperty("status","FAILURE");

                return obj.toString();
            }

            int remainingQty = availableQty - request.getOrderQuantity();

            product.setQuantity(remainingQty);

            productRepo.save(product);

            Orders order = new Orders();

            order.setProduct(product);

            order.setOrderQuantity(request.getOrderQuantity());

            order.setTotalPrice(product.getPrice() * request.getOrderQuantity());

            orderRepo.save(order);

            obj.addProperty("msg","Order Placed Successfully");
            obj.addProperty("remainingStock",remainingQty);
            obj.addProperty("status","SUCCESS");

            return obj.toString();

        } else {

            obj.addProperty("msg","Product Not Found");
            obj.addProperty("status","FAILURE");

            return obj.toString();
        }
    }
}