package com.example.nonel.bootcamp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nonel.bootcamp.Model.Products;

import java.util.ArrayList;

public class DeliveryListFragment extends Fragment implements View.OnClickListener
{

    private DeliveryListFragment instance;
    DeliveryFragmentActivity activity_delivery;


    public DeliveryListFragment getInstance(){
        if(instance == null){
            instance = new DeliveryListFragment();
        }
        return instance;
    }

    private ArrayList<Products> fillProducts(){
        ArrayList<Products> products = new ArrayList<Products>();

        for(int i=1; i<10; i++){
            Products meal = new Products();
            meal.setName("Meal "+i);
            meal.setPrice(10f * i);
            meal.setDescription("Meal " + i + " desc");

            products.add(meal);
        }

        return products;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //return inflater.inflate(R.layout.fragment_delivery_list, container);

        View view = inflater.inflate(R.layout.fragment_delivery_list, container, false);

        ArrayList<Products> products = fillProducts();

        final ProductAdapter product_adapter = new ProductAdapter(view.getContext(), products);

        ListView product_list_view = (ListView) view.findViewById(R.id.lv_delivery_list);

        ((ListView) view.findViewById(R.id.lv_delivery_list)).setAdapter(product_adapter);

        product_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Products select = (Products) parent.getAdapter().getItem(position);
                activity_delivery.fillFragmentView(select);
                //Log.i("List View", select.getName());
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        activity_delivery = (DeliveryFragmentActivity) this.getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
    }
}
