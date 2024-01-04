package com.example.mrfre.pova;

import java.util.ArrayList;

public class CartLogic {
    private String orderList2 = "";
    public static ArrayList<Items> myOrder = new ArrayList<Items>();
    //vars
    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Double> prices = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<String>toppings = new ArrayList<>();

    public void run(String order){
        this.orderList2 = order;
        checkList(myOrder, orderList2);
        for (Items ob : myOrder)
        {
            itemNames.add(ob.getName());
            toppings.add(ob.getIngredients());
            quantity.add(ob.quantity);
            double totalPrice = ob.quantity * ob.getPrice();
            prices.add(totalPrice);
        }
    }

    public static void checkList(ArrayList<Items> myOrder, String order)
    {
        //Temporary declarations
        boolean isSame = false;
        Items dummyOrder = new Items();
        dummyOrder.addItem(order);

        //Empty List
        if (myOrder.size() == 0)
        {
            isSame= true;
            dummyOrder.quantity += 1;
            myOrder.add(dummyOrder);
        }

        //Non Empty List checks for duplicate
        else
        {
            for(Items obj : myOrder)
            {
                if (dummyOrder.name.equals(obj.name) && dummyOrder.ingredients.equals(obj.ingredients))
                {
                    isSame = true;
                    obj.quantity += 1;
                }
            }
        }

        //Adds to list if duplicate does not exist
        if (isSame == false)
        {
            dummyOrder.quantity += 1;
            myOrder.add(dummyOrder);
        }
    }

    public static void removeItem(ArrayList<Items> myOrder, String order) {
        Items dummyOrder2 = new Items();
        dummyOrder2.addItem(order);


        if (myOrder.size() != 0) {
            for (Items obj : myOrder) {
                if (dummyOrder2.name.equals(obj.name) && dummyOrder2.ingredients.equals(obj.ingredients)) {
                    obj.quantity -= 1;

                }
            }
        }
    }

}
