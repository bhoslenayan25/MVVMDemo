package com.example.mvvmdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by nayan on 22/8/17.
 */

public class ProductViewModel extends BaseObservable {

    private ProductEntity mProduct;
    private Context mContext;

    public ProductViewModel(ProductEntity product,Context context) {
        this.mContext = context;
        this.mProduct = product;
    }


    public String getImageURL() {
        return mProduct.getImageURL();
    }

    @BindingAdapter({"image"})
    public void loadImage(ImageView view,String url){
        view.setImageResource(mContext.getResources().getIdentifier(
                url, "drawable", mContext.getPackageName()));
    }

    public String getBrand() {
        return mProduct.getBrand();
    }

    public String getName() {
        return mProduct.getName();
    }

    public String getPrice() {
        return mProduct.getPrice();
    }

    public Float getRating() {
        return mProduct.getRatings();
    }

    public String getRatingText() {
        return String.valueOf(mProduct.getRatings());
    }

}
