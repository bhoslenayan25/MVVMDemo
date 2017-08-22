package com.example.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mvvmdemo.databinding.ActivityMainBinding;

import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerViewMaster.setLayoutManager(layoutManager);

        ProductAdapter adapter = new ProductAdapter(getProducts(), this);
        binding.recyclerViewMaster.setAdapter(adapter);
    }

    private ArrayList<ProductEntity> getProducts() {
        ArrayList<ProductEntity> productDetails = null;
        try {
            InputStream is = getAssets().open("products.json");
            int size = is.available();
            byte buffer[] = new byte[size];
            is.read(buffer);
            is.close();
            String bufferString = new String(buffer);
            productDetails = Parser.getProductList(bufferString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDetails;
    }
}
