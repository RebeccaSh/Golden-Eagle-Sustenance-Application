package com.example.mrfre.pova;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Checkout extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout backgroudRL;
    EditText firstNameET;
    EditText lastNameET;
    EditText cardNumET;
    EditText monthET;
    EditText yearET;
    EditText cscET;
    EditText cardHolderNameET;
    EditText middleIET;
    EditText streetET;
    EditText cityET;
    EditText stateET;
    EditText postalET;
    EditText countryET;

    String firstName;
    String lastName;
    String cardNum;
    int month;
    int year;
    String csc;
    String cardHolderName;
    String middleI;
    String street;
    String city;
    String state;
    String postal;
    String country;
    String lastFour;
    String time = "";

    Spinner spin;
    int time1 = 15;
    int time2 = 30;
    int time3 = 45;
    int timeSelected = 0;
    ArrayList <String> times = new ArrayList<>();
    ArrayAdapter <String> arrayAdapter;

    public static double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        setTitle("Checkout");

        backgroudRL = (RelativeLayout) findViewById(R.id.background);
        firstNameET = (EditText)findViewById(R.id.editTextFirstName);
        lastNameET = (EditText)findViewById(R.id.editTextLastName);
        cardNumET = (EditText)findViewById(R.id.editTextCardNum);
        monthET = (EditText)findViewById(R.id.editTextMonth);
        yearET = (EditText)findViewById(R.id.editTextYear);
        cscET = (EditText)findViewById(R.id.editTextCSC);
        cardHolderNameET = (EditText)findViewById(R.id.editTextCardHolderName);
        middleIET = (EditText)findViewById(R.id.editTextMiddleName);
        streetET = (EditText)findViewById(R.id.editTextStreet);
        cityET = (EditText)findViewById(R.id.editTextCity);
        stateET = (EditText)findViewById(R.id.editTextState);
        postalET = (EditText)findViewById(R.id.editTextPostal);
        countryET = (EditText)findViewById(R.id.editTextCountry);

        spin = (Spinner) findViewById(R.id.spinner);
        times.add(time1 + " minutes");times.add(time2 + " minutes");times.add(time3 + " minutes");
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, times);
        spin.setAdapter(arrayAdapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        timeSelected = time1;
                        break;
                    case 1:
                        timeSelected = time2;
                        break;
                    case 2:
                        timeSelected = time3;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                timeSelected = time1;
            }
        });

        backgroudRL.setOnClickListener(this);

    }

    //get user information
    private boolean getInfo(){
        boolean isValid = true;
        try {
            firstName =  firstNameET.getText().toString();
            lastName =  lastNameET.getText().toString();
            cardNum =  cardNumET.getText().toString();
            month =  Integer.parseInt(monthET.getText().toString());
            year = Integer.parseInt(yearET.getText().toString());
            csc =  cscET.getText().toString();
            cardHolderName =  cardHolderNameET.getText().toString();
            middleI =  middleIET.getText().toString();
            street =  streetET.getText().toString();
            city =  cityET.getText().toString();
            state =  stateET.getText().toString();
            postal =  postalET.getText().toString();
            country =  countryET.getText().toString();
            lastFour = "" + cardNum.charAt(12) + cardNum.charAt(13) + cardNum.charAt(14) + cardNum.charAt(15);
        }
        catch (Exception x){
            isValid = false;
        }
        return isValid;
    }

    private boolean verifyCardNum(){
        boolean isValid = true;
        char curChar = ' ';
        //valid card number should be 16 characters
        if(cardNum.length() != 16){
            //Toast.makeText(this, "Invalid Card Number Entered", Toast.LENGTH_SHORT).show();
            isValid = false;
        }
        //ascii values of 0-9 should be between 48 and 57, anything below or above is not a number
        else {
            for (int i = 0; i < cardNum.length(); i++) {
                curChar = cardNum.charAt(i);
                if (curChar < 48 || curChar > 57) {
                    //Toast.makeText(this, "Invalid Character Entered in Card Number", Toast.LENGTH_SHORT).show();
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    private boolean verifyExpirationDate(){
        boolean isValid = true;
        Calendar c = Calendar.getInstance();
        int curMonth = c.get(Calendar.MONTH);
        int curYear = c.get(Calendar.YEAR);
        //invalid numbers entered into month or year text fields
        if(String.valueOf(month).length() < 2 || String.valueOf(year).length() < 4){
            isValid = false;
            Log.i("Failed","month or year length");
        }
        else {
            if (year < curYear) {
                isValid = false;
            }
            else if(year > curYear) { //year >= curYear
                isValid = true;
            }
            else{
               if(month < curMonth){ //2018/ 09
                    isValid = false;
                }
                else{
                    isValid = true;
               }
            }
        }
        return isValid;
    }

    private boolean verifyCSC(){
        boolean isValid = true;
        if(csc.length() < 3){
            isValid = false;
        }
        return isValid;
    }

    private boolean verifyState(){
        boolean isValid = true;
        if(state.length() < 2){
            isValid = false;

        }
        return isValid;
    }

    private boolean verifyPostalCode(){
        boolean isValid = true;
        char curChar;
        if(postal.length() < 5){
            isValid = false;
        }
        else{
            //ascii values of 0-9 should be between 48 and 57, anything below or above is not a number
            for(int i = 0; i < postal.length(); i++){
                curChar = postal.charAt(i);
                if(curChar < 48 || curChar > 57){
                    //Toast.makeText(this, "Invalid Character Entered in Card Number", Toast.LENGTH_SHORT).show();
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    public void confirmClick(View view) {
        //all should be true for a valid card
        boolean isValid = getInfo() && verifyExpirationDate() && verifyCardNum() && verifyCSC() && verifyPostalCode() && verifyState();
        if(isValid){
            setPickUpTime();
            calculateTotal();
            Intent i = new Intent(this, ConfirmationScreen.class);
            i.putExtra("firstN", firstName);
            i.putExtra("middle",middleI);
            i.putExtra("lastN", lastName);
            i.putExtra("street",street);
            i.putExtra("city",city);
            i.putExtra("postal",postal);
            i.putExtra("country",country);
            i.putExtra("lastFour",lastFour);
            i.putExtra("pickUp",time);
            startActivity(i);
            finish();
        }
        else{
            Toast.makeText(this, "Problem Verifying Card", Toast.LENGTH_SHORT).show();
        }
    }

    private void setPickUpTime(){
        Calendar cal = Calendar.getInstance();
        int h = cal.get(Calendar.HOUR);
        int m = cal.get(Calendar.MINUTE);
        //if current minutes + selected minutes is over 60 then a new hour needs to be added  to current hour. Also need to calculate appropriate minutes
        if((m + timeSelected) > 60){
            h += 1;
            if(h > 12){
                h = h % 12;
            }
            m = (m+timeSelected) - 60;
        }
        else{
            m += timeSelected;
        }
        if(m < 10){
            time = h + ":0" + m;
        }
        else{
            time = h + ":" + m;
        }
        //PASS TIME INTO CONFIRMATION SCREEN ALONG WITH REST OF VARIABLES THAT WILL BE DISPLAYED
        Log.e("TEST", time);
    }
    private void calculateTotal() {
        for(int i = 0; i < CartRecyclerViewAdapter.prices.size(); i++){
            total += CartRecyclerViewAdapter.prices.get(i);
        }
        total = Math.round(total*100.0)/100.0;
    }

    @Override
    public void onClick(View view) {
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }

    public void back(View view) {
        Intent i = new Intent(this, Cart.class);
        startActivity(i);
        finish();
    }
}
