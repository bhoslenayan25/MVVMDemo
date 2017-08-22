package com.example.mvvmdemo;


import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Nayan on 27/10/2016.
 */

public class Parser {

    //ProductDetails
    public static ArrayList<ProductEntity> getProductList(String response) {
        ArrayList results = new ArrayList<ProductEntity>();

        try {
            JSONArray jsonArray = new JSONArray(response);
            ProductEntity obj;
            for (int i = 0; i < jsonArray.length(); i++) {
                obj = new ProductEntity();
                obj.setId(jsonArray.getJSONObject(i).getString("id"));
                obj.setImageURL("p"+jsonArray.getJSONObject(i).getString("image"));
                obj.setBrand(jsonArray.getJSONObject(i).getString("brand"));
                obj.setName(jsonArray.getJSONObject(i).getString("name"));
                obj.setPrice(jsonArray.getJSONObject(i).getString("price"));
                obj.setRatings(Float.parseFloat(jsonArray.getJSONObject(i).getString("ratings")));
                obj.setReviews("");
                results.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}
