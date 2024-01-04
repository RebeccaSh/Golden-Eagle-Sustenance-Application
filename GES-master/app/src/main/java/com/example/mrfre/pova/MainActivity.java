package com.example.mrfre.pova;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDB = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myDB.clearTable();
        addToDB();
        setAdapter();

    }

    private  void setAdapter(){
        ListView resList = (ListView)findViewById(R.id.resListView);
        ArrayList<String> restaurants = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, restaurants);
        restaurants.add("Carls Jr.");
        restaurants.add("Johnny's Kitchen");
        restaurants.add("El Pollo Loco");
        restaurants.add("Rice Garden");
        resList.setAdapter(arrayAdapter);
        resList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i){
                    case 0:
                        intent = new Intent(MainActivity.this, CarlsJr.class);
                        intent.putExtra("test", 4.56);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Functionality for selected restaurant has not yet been implemented", Toast.LENGTH_SHORT);
                        break;
                }
            }
        });
    }
    void addToDB() {
        //Insert Burgers into Data Base ////////////////////////////////////////////////////////////
        myDB.insertData("Big Carl®", 920, 6.95,
                "Two charbroiled beef patties, our classic sauce, two slices of American cheese, and lettuce all on a seeded bun.",
                "Lettuce,Classic Sauce");
        myDB.insertData("Double Western Bacon Cheeseburger®", 1100, 6.00,
                "Two Charbroiled All-Beef Patties, Two Strips of Bacon, Two Slices of Melted American Cheese, Crispy Onion Rings and Tangy BBQ Sauce on a seeded bun.",
                "Thick-Cut Applewood-Smoked Bacon,Onion Rings,BBQ Sauce,Cheese");

        //Insert Fries into Data Base //////////////////////////////////////////////////////////////
        myDB.insertData("Natural-Cut French Fries - Small", 300, 1.17,
                "Premium-quality, Skin-on, Natural Cut French Fries.",
                "Small");
        myDB.insertData("Natural-Cut French Fries - Medium", 430, 1.99,
                "Premium-quality, Skin-on, Natural Cut French Fries.",
                "Medium");
        myDB.insertData("Natural-Cut French Fries - Large", 460, 2.19,
                "Premium-quality, Skin-on, Natural Cut French Fries.",
                "Large");
        myDB.insertData("Crisscut® Fries", 450, 2.19,
                "Crispy Bites of Crisscut Potatoes.",
                ""); //No Custom

        myDB.insertData("Onion Rings", 530, 2.19,
                "Onion rings cooked up crispy and golden brown.",
                ""); //No Custom
        myDB.insertData("Fried Zucchini", 330, 2.69,
                "Bites of Crispy, Breaded Zucchini", //Corrected Spelling of Zucchini
                ""); //No Custom

        //Insert Drinks into DataBase //////////////////////////////////////////////////////////////
        myDB.insertData("Fuze® Raspberry Tea", 150, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Gold Peak® Iced Tea", 12, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Coca-Cola®", 250, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Diet Coke®", 0, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Coca-Cola Zero™", 0, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Sprite®", 240, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Barq’s® Rootbeer", 280, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Powerade® Mountain Blast", 140, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Cherry Coke®", 260, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Hi-C® Flashin’ Fruit Punch", 260, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Dr Pepper®", 230, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Diet Dr Pepper®", 0, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Fanta® Orange", 280, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");
        myDB.insertData("Minute Maid Light™ Lemonade", 10, 0,
                "Hit edit to see Price and Size",
                "Small (1.69),Medium (1.89),Large (2.19)");

        //Shakes ///////////////////////////
        myDB.insertData("Vanilla Hand-Scooped Ice Cream Shake™", 700, 3.29,
                "Creamy, Hand-Scooped Ice Cream Blended with Milk and Vanilla Syrup then Topped with Whipped Topping.",
                ""); //No Custom
        myDB.insertData("Chocolate Hand-Scooped Ice Cream Shake™", 690, 3.29,
                "Creamy, Hand-Scooped Ice Cream Blended with Milk and Chocolate Syrup then topped with Whipped Topping",
                ""); //No Custom
        myDB.insertData("Strawberry Hand-Scooped Ice Cream Shake™", 690, 3.29,
                "Creamy, Hand-Scooped Ice Cream Blended with Milk and Strawberry Syrup then topped with Whipped Topping.",
                ""); //No Custom
        myDB.insertData("Oreo® Cookie Hand-Scooped Ice Cream Shake™", 710, 3.29,
                "Creamy, Hand-Scooped Ice Cream Blended with Milk and OREO® Cookie Pieces then topped with Whipped Topping.",
                ""); //No Custom

        //Energy Drinks /////////////////////
        myDB.insertData("Monster Energy®", 200, 1.89,
                "The ideal combo of the right ingredients in the right proportion to deliver the big bad buzz that only Monster can. Monster packs a powerful punch but has a smooth easy drinking flavor.", //No Description
                ""); //No Custom

        //Water /////////////////////////////
        myDB.insertData("Dasani® Water", 0, 1.69,
                "DASANI® combines filtration with added minerals to create a fresh, clean, and premium tasting water that is pure and delicious.", //No Description
                ""); //No Custom

        //Coffee ////////////////////////////
        myDB.insertData("Colombian Blend Coffee", 10, 0,
                "Hit edit to see Price and Size",
                "Small (1.29),Medium (1.59),Large (1.79)");
        myDB.insertData("Decaffeinated Coffee", 10, 0,
                "Hit edit to see Price and Size",
                "Small (1.29),Medium (1.59),Large (1.79)");

        //Juice //////////////////////////////
        myDB.insertData("Minute Maid® Orange Juice", 150, 1.69,
                "Authentic, timeless and downright deliciously refreshing juice made from perfectly ripe, natural oranges.", //No Description
                ""); //No Custom

        //Milk /////////////////////////////
        myDB.insertData("1% Fat Milk", 150, 1.29,
                "1% Milk",
                ""); //No Custom

        //Insert Desserts into Database ////////////////////////////////////////////////////////////
        myDB.insertData("Chocolate Chip Cookies", 330, .89,
                "A delicious chocolte chip cookie with a crispy exterior and a smooth buttery interior.",
                "");
        myDB.insertData("Strawberry Swirl Cheesecake", 320, 2.19,
                "A delicious creamy cheesecake baked with a flavorful swirl of strawberry jam",
                "");
        myDB.insertData("Chocolate Cake", 290, 1.99,
                "A fluffy chocolate cake topped with delicious whip cream",
                "Whip,No Whip");
        myDB.insertData("Jolly Rancher Milkshake", 810, 3.29,
                "A Handmade American Classic of our vanilla milkshake with a taste of Jolly Rancher candy mixed right in.",
                "Small (1.29),Medium (1.59),Large (1.79)");
    }

    public void switchToRes(View view) {
        Intent i = new Intent(this, RestaurantView.class);
        startActivity(i);
        finish();
    }
}
