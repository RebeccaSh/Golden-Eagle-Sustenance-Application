package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class RestaurantView extends AppCompatActivity {

    ArrayList<String> customerCopy = new ArrayList<>();
    ArrayList<String> orderCopy = new ArrayList<>();
    ArrayList<String> timeCopy = new ArrayList<>();
    ArrayList<String> displayCopy = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_view);
        setTitle("Orders");


        setAdapter();
    }


    public void setAdapter() {
        /*queries orders from the servers and save the name and time in customer arraylist, and the order in the order arraylist
        customer arraylist is used to populate the listview that will display the customer name and pickup time
        */
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Order");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                //there is data on server
                ArrayList<String> customer = new ArrayList<>();
                ArrayList<String> order = new ArrayList<>();
                ArrayList<String> time = new ArrayList<>();
                ArrayList<String> display = new ArrayList<>();
                if(e == null && objects.size() > 0){
                    for(ParseObject object: objects){
                        customer.add(object.getString("name"));
                        time.add(object.getString("time"));
                        display.add(object.getString("name") + " (" + object.getString("time") + ")");
                        order.add(object.getString("order"));
                    }
                }
                //copy data into arrays that will be used in adapter
                for(int i = 0; i < customer.size(); i++){
                    customerCopy.add(customer.get(i));
                    timeCopy.add(time.get(i));
                    orderCopy.add(order.get(i));
                }
                ListView customers = (ListView) findViewById(R.id.listviewCustomer);
                ArrayAdapter<String>  arrayAdapter = new ArrayAdapter<>(RestaurantView.this, android.R.layout.simple_list_item_1, display);
                customers.setAdapter(arrayAdapter);
                customers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(RestaurantView.this, DisplayOrder.class);
                        intent.putExtra("customer", customerCopy.get(i));
                        intent.putExtra("time", timeCopy.get(i));
                        intent.putExtra("order", orderCopy.get(i));
                        startActivity(intent);
                        finish();
                    }
                });
                Log.i("Contents1", String.valueOf(customerCopy.size()));
            }
        });
    }

    public void backToMain(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
