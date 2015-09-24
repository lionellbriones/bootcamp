package com.example.nonel.bootcamp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nonel.bootcamp.Model.Products;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<Products> productList;
    private Context mContext;

    public ProductAdapter(Context context, ArrayList<Products> productList){
        this.mContext = context;
        this.productList = productList;
    }

    @Override
    public Products getItem(int position) {
        return productList.get(position);
    }

    public int getCount() {
        return productList.size();
    }

    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        //UI ELEMENTS
        TextView tv_meal_name;
        TextView tv_meal_description;
        TextView tv_meal_price;

        public ViewHolder(View v){
            tv_meal_name = (TextView) v.findViewById(R.id.tv_meal_name);
            tv_meal_description = (TextView) v.findViewById(R.id.tv_meal_description);
            tv_meal_price = (TextView) v.findViewById(R.id.tv_meal_price);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View childView = convertView;
        ViewHolder holder;
        Products item = getItem(position);

        if(childView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childView = inflater.inflate(R.layout.item_product, parent, false);
            holder = new ViewHolder(childView);
            childView.setTag(holder);
        }else{
            holder = (ViewHolder) childView.getTag();
        }

        holder.tv_meal_name.setText(item.getName());
        holder.tv_meal_description.setText(item.getDescription());
        holder.tv_meal_price.setText("P "+Float.toString(item.getPrice()));
        return childView;
    }
}
