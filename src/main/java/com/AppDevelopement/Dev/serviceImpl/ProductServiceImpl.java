
package com.AppDevelopement.Dev.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AppDevelopement.Dev.bean.ProductRequest;
import com.AppDevelopement.Dev.entity.Product;
import com.AppDevelopement.Dev.repository.ProductRepo;
import com.AppDevelopement.Dev.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    Gson gson=new Gson();

    @Override
    public String saveProduct(ProductRequest request) {

        Product product=new Product();

        product.setProductName(request.getProductName());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());

        productRepo.save(product);

        JsonObject obj=new JsonObject();
        obj.addProperty("msg","Product Saved");
        obj.addProperty("status","SUCCESS");

        return obj.toString();
    }

    @Override
    public String getAllProduct() {

        List<Product> list=productRepo.findAll();

        return gson.toJson(list);
    }

    @Override
    public String getSingleProduct(int productId) {

        Optional<Product> opt=productRepo.findById(productId);

        if(opt.isPresent()) {

            return gson.toJson(opt.get());

        } else {

            JsonObject obj=new JsonObject();
            obj.addProperty("msg","Product Not Found");
            obj.addProperty("status","FAILURE");

            return obj.toString();
        }
    }

    @Override
    public String updateProduct(int productId, ProductRequest request) {

        Optional<Product> opt=productRepo.findById(productId);

        if(opt.isPresent()) {

            Product product=opt.get();

            product.setProductName(request.getProductName());
            product.setQuantity(request.getQuantity());
            product.setPrice(request.getPrice());
            product.setDescription(request.getDescription());

            productRepo.save(product);

            JsonObject obj=new JsonObject();
            obj.addProperty("msg","Product Updated");
            obj.addProperty("status","SUCCESS");

            return obj.toString();

        } else {

            JsonObject obj=new JsonObject();
            obj.addProperty("msg","Product Not Found");
            obj.addProperty("status","FAILURE");

            return obj.toString();
        }
    }

    @Override
    public String deleteProduct(int productId) {

        Optional<Product> opt=productRepo.findById(productId);

        if(opt.isPresent()) {

            productRepo.deleteById(productId);

            JsonObject obj=new JsonObject();
            obj.addProperty("msg","Product Deleted");
            obj.addProperty("status","SUCCESS");

            return obj.toString();

        } else {

            JsonObject obj=new JsonObject();
            obj.addProperty("msg","Product Not Found");
            obj.addProperty("status","FAILURE");

            return obj.toString();
        }
    }
}
