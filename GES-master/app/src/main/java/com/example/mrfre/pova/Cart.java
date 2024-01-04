package com.example.mrfre.pova;

import android.content.Intent;
import android.provider.ContactsContract;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {


    //vars
    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<String>toppings = new ArrayList<>();
    private String orderList2 = "";
    ArrayList<Items> myOrder = new ArrayList<Items>();
    double total = 0.0;
    TextView totals;
    ImageView sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("Cart");

        totals = (TextView)findViewById(R.id.textViewTotals);
        sad = (ImageView)findViewById(R.id.imageViewSadCart);
        myOrder = (ArrayList<Items>) CartLogic.myOrder.clone();
        for (Items ob : myOrder)
        {
            itemNames.add(ob.getName());
            toppings.add(ob.getIngredients());
            quantity.add(ob.quantity);
            double totalPrice = ob.quantity * ob.getPrice();
            prices.add(totalPrice);
        }
        if(itemNames.size() == 0){
            sad.setVisibility(View.VISIBLE);
            totals.setText("*Sigh Cart is Empty...");
        }
        else {
            sad.setVisibility(View.INVISIBLE);
            initRecyclerView();
            calculateTotal();
            totals.setText("Total Price: $" + String.valueOf(total) + "\n" + "Total Calories: " + CarlsJr.totalCalories);
        }
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerListView);
        CartRecyclerViewAdapter adapter = new CartRecyclerViewAdapter(this,itemNames,toppings,quantity,prices);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void checkoutOnClick(View view) {
        if(itemNames.size() == 0){
            Toast.makeText(this, "Cart is Empty", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i = new Intent(Cart.this, Checkout.class);
            startActivity(i);
            finish();
        }
    }

    public void backToMenu(View view) {
        Intent i = new Intent(this, CarlsJr.class);
        startActivity(i);
        finish();
    }

    private void calculateTotal() {
        for(int i = 0; i < prices.size(); i++){
            total += prices.get(i);
        }
        total = Math.round(total*100.0)/100.0;
    }
}
