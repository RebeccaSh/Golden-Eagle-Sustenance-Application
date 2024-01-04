package com.example.mrfre.pova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class ConfirmationScreen extends AppCompatActivity {

    TextView orderDetails;
    TextView billingInfo;
    TextView total;

    String textDetails = "";
    String billingText = "";
    String pickUpTime = "";
    String firstName;
    String lastName;

    ParseObject order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_screen);

        order = new ParseObject("Order");
        orderDetails = (TextView)findViewById(R.id.textViewDetails);
        billingInfo = (TextView)findViewById(R.id.textViewBillingInfo);
        total = (TextView)findViewById(R.id.textViewOrderTotal);

        getTexts();
        setTexts();
        pushOrder();
    }

    private void getTexts() {
        //use extras passed from checkout activity to create strings that will be used to set the text for textview
        Intent intent = getIntent();
        firstName = intent.getStringExtra("firstN");
        lastName = intent.getStringExtra("lastN");
        String middle = intent.getStringExtra("middle");
        String street = intent.getStringExtra("street");
        String city = intent.getStringExtra("city");
        String postal = intent.getStringExtra("postal");
        String country = intent.getStringExtra("country");
        String lastFour = intent.getStringExtra("lastFour");
        pickUpTime = intent.getStringExtra("pickUp");
        billingText = firstName + " " + middle + " " + lastName + "\n"
                      + street + ", " + city + " " + postal + "\n"
                      + country + "\n"
                      + "Payment Ending in " + lastFour;

        //iterate through arraylists from cart activity to get order details
        for(int i = 0; i< CartRecyclerViewAdapter.itemNames.size(); i++){
            textDetails = textDetails + CartRecyclerViewAdapter.itemQuantities.get(i) + " " + CartRecyclerViewAdapter.itemNames.get(i) + " " + CartRecyclerViewAdapter.toppings.get(i) + "\n";
        }
    }

    //push users name, order and pickup time to parse server
    private void pushOrder(){
        order.put("name",firstName + " " + lastName);
        order.put("order", textDetails);
        order.put("time",pickUpTime);
        order.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Log.i("Order", "Saved");
                }
                else{
                    Log.i("Order", "Failed");
                }
            }
        });
    }


    //set the textviews that will be displayed to the user
    private void setTexts() {
        orderDetails.setText(textDetails + "\nPick Up Time: " + pickUpTime);
        billingInfo.setText(billingText);
        total.setText("Order Total: $" + Checkout.total);
    }

    public void home(View view) {
        CartLogic.myOrder.clear();
        CarlsJr.totalCalories = 0;
        CarlsJr.calories = 0;
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
