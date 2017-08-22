package com.example.mvvmdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvvmdemo.databinding.ProductCardViewBinding;

import java.util.List;

/**
 * Created by nayan on 22/8/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder>{

    private List<ProductEntity> mProducts;
    private Context mContext;

    public ProductAdapter(List<ProductEntity> mProducts, Context mContext) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProductCardViewBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.product_card_view, parent, false);

        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        ProductCardViewBinding binding = holder.binding;
        binding.setPvm(new ProductViewModel(mProducts.get(position), mContext));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }


    public class ProductHolder extends RecyclerView.ViewHolder{
        ProductCardViewBinding binding;

        public ProductHolder(ProductCardViewBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
    }
}
