package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class DisplayOrder extends AppCompatActivity {

    TextView orderTV;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order);
        setTitle("Orders");
        orderTV = (TextView)findViewById(R.id.textViewOrder);

        displayOrder();
    }

    private void displayOrder() {
        Intent i = getIntent();
        name = i.getStringExtra("customer");
        String order = i.getStringExtra("order");
        String time = i.getStringExtra("time");
        orderTV.setText(name + " " + time + "\n\n" + order);
    }

    public void back(View view) {
        Intent i = new Intent(this, RestaurantView.class);
        startActivity(i);
        finish();
    }

    public void remove(View view) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Order");
        query.whereEqualTo("name",name);
        query.setLimit(1);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null && objects.size() > 0){
                    for(ParseObject obj: objects){
                        obj.deleteInBackground();
                        Toast.makeText(DisplayOrder.this, name + " removed from list", Toast.LENGTH_SHORT).show();
                        Log.i("Order", name +  "deleted");
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
