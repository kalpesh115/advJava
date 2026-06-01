package com.AppDevelopement.Dev.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.AppDevelopement.Dev.service.AppServiceResTem;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class AppServiceResTemImpl implements  AppServiceResTem {
	
	
	
	@Autowired
	@Qualifier("restTemplateTwo")
	RestTemplate restemplate;
	
	public String getApiCall() {
	
		String response =restemplate.getForObject("https://dummyjson.com/products" , String.class);
		Gson gson=new Gson();
		JsonArray arr =gson.fromJson(response, JsonArray.class);
		return arr.toString();
		
	}

	@Override
    public String getIdAndPrice() {

        String response = restemplate.getForObject("https://dummyjson.com/products", String.class );
        Gson gson = new Gson();
        JsonObject root = gson.fromJson(response, JsonObject.class);
        JsonArray arr = root.getAsJsonArray("products");
        JsonArray result = new JsonArray();
        
        for (int i = 0; i < arr.size(); i++) {

            JsonObject product = arr.get(i).getAsJsonObject();

            JsonObject obj = new JsonObject();
            obj.addProperty("id", product.get("id").getAsInt());
            obj.addProperty("price", product.get("price").getAsDouble());

            result.add(obj);
        }

        return result.toString();
    }
}

	


