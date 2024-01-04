package com.example.mrfre.pova;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import androidx.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder>{

    public static ArrayList<String> itemNames = new ArrayList<>();
    public static ArrayList<String> toppings = new ArrayList<>();
    public static ArrayList<Integer> itemQuantities = new ArrayList<>();
    public static ArrayList<Double> prices = new ArrayList<>();
    private Context context;
    DataBaseHelper myDB;

    public CartRecyclerViewAdapter(Context context, ArrayList<String> itemNames, ArrayList<String> toppings, ArrayList<Integer> itemQuantities, ArrayList<Double> prices) {
        this.itemNames = itemNames;
        this.toppings = toppings;
        this.itemQuantities = itemQuantities;
        this.prices = prices;
        this.context = context;
        myDB = new DataBaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitems, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.itemName.setText(itemNames.get(i));
        viewHolder.ingredients.setText(toppings.get(i));
        viewHolder.price.setText("$" + Double.toString(prices.get(i)));
        viewHolder.quantity.setText(Integer.toString(itemQuantities.get(i)));
    }

    private void setupEditItem(String name) {
        Cursor cursor = myDB.getData(name);
        String customs = "";
        while(cursor.moveToNext()){
            customs = cursor.getString(5);
        }
        Intent i = new Intent(context, EditItemMenu.class);
        i.putExtra("itemName", name);
        i.putExtra("customs", customs);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView quantity;
        TextView price;
        TextView ingredients;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            ingredients = (TextView) itemView.findViewById(R.id.textViewToppings);
            quantity = (TextView) itemView.findViewById(R.id.quantity);
            price = (TextView) itemView.findViewById(R.id.price);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
        }
    }
}
