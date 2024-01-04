package com.example.mrfre.pova;

class Items
{
    String name, ingredients;
    int quantity = 0;
    double price= 0.0;

    Items(String name, String ingredients, int quantity, double itemPrice)
    {
        this.name = name;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.price = itemPrice;
    }

    Items()
    {
        name = null;
        ingredients = null;
        quantity = 0;
        if(CarlsJr.isDrink){
            price = EditItemMenu.drinkPrice;
        }
        else{
            price = CarlsJr.price;
        }
    }

    void addItem(String order)
    {
        if(order.contains("Double Western Bacon Cheeseburger®"))
        {
            name = "Double Western Bacon Cheeseburger®";
            ingredients = order.substring(name.length()+1, order.length());
        }

        else if(order.contains("Big Carl®"))
        {
            name = "Big Carl®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Natural-Cut French Fries - Small"))
        {
            name = "Natural-Cut French Fries - Small";
            ingredients = "";
        }
        else if(order.contains("Natural-Cut French Fries - Medium"))
        {
            name = "Natural-Cut French Fries - Mediums";
            ingredients = "";
        }
        else if(order.contains("Natural-Cut French Fries - Large"))
        {
            name = "Natural-Cut French Fries - Large";
            ingredients = "";
        }
        else if(order.contains("Crisscut® Fries"))
        {
            name = "Crisscut® Fries";
            ingredients = "";
        }
        else if(order.contains("Onion Rings"))
        {
            name = "Onion Rings";
            ingredients = "";
        }
        else if(order.contains("Fried Zucchini"))
        {
            name = "Fried Zucchini";
            ingredients = "";
        }
        else if(order.contains("Fuze® Raspberry Tea"))
        {
            name = "Fuze® Raspberry Te";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Gold Peak® Iced Tea"))
        {
            name = "Gold Peak® Iced Tea";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Coca-Cola®"))
        {
            name = "Coca-Cola®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Diet Coke®"))
        {
            name = "Diet Coke®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Coca-Cola Zero™"))
        {
            name = "Coca-Cola Zero™";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Sprite®"))
        {
            name = "Sprite®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Barq’s® Rootbeer"))
        {
            name = "Barq’s® Rootbeer";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Powerade® Mountain Blast"))
        {
            name = "Powerade® Mountain Blast";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Cherry Coke®"))
        {
            name = "Cherry Coke®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Hi-C® Flashin’ Fruit Punch"))
        {
            name = "Hi-C® Flashin’ Fruit Punch";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Dr Pepper®"))
        {
            name = "Dr Pepper®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Diet Dr Pepper®"))
        {
            name = "Diet Dr Pepper®";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Fanta® Orange"))
        {
            name = "Fanta® Orange";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Fanta® Strawberry"))
        {
            name = "Fanta® Strawberry";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Minute Maid Light™ Lemonade"))
        {
            name = "Minute Maid Light™ Lemonade";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Vanilla Hand-Scooped Ice Cream Shake™"))
        {
            name = "Vanilla Hand-Scooped Ice Cream Shake™";
            ingredients = "";
        }
        else if(order.contains("Chocolate Hand-Scooped Ice Cream Shake™"))
        {
            name = "Chocolate Hand-Scooped Ice Cream Shake™";
            ingredients = "";
        }

        else if(order.contains("Strawberry Hand-Scooped Ice Cream Shake™"))
        {
            name = "Strawberry Hand-Scooped Ice Cream Shake™";
            ingredients = "";
        }
        else if(order.contains("Oreo® Cookie Hand-Scooped Ice Cream Shake™"))
        {
            name = "Oreo® Cookie Hand-Scooped Ice Cream Shake™";
            ingredients = "";
        }
        else if(order.contains("Monster Energy®"))
        {
            name = "Monster Energy®";
            ingredients = "";
        }
        else if(order.contains("Dasani® Water"))
        {
            name = "Dasani® Water";
            ingredients = "";
        }
        else if(order.contains("Colombian Blend Coffee"))
        {
            name = "Colombian Blend Coffee";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Decaffeinated Coffee"))
        {
            name = "Decaffeinated Coffee";
            ingredients = order.substring(name.length()+1, order.length());
        }
        else if(order.contains("Minute Maid® Orange Juice"))
        {
            name = "Minute Maid® Orange Juice";
            ingredients = "";
        }
        else if(order.contains("1% Fat Milk"))
        {
            name = "1% Fat Milk";
            ingredients = "";
        }
        else if(order.contains("Chocolate Chip Cookies"))
        {
            name = "Chocolate Chip Cookies";
            ingredients = "";
        }
        else if(order.contains("Strawberry Swirl Cheesecake"))
        {
            name = "Strawberry Swirl Cheesecake";
            ingredients = "";
        }
        else if(order.contains("Chocolate Cake"))
        {
            name = "Chocolate Cake";
            ingredients = "";
        }
        else if(order.contains("Jolly Rancher Milkshake"))
        {
            name = "Jolly Rancher Milkshake";
            ingredients = "";
        }
    }


    String getName()
    {
        return name;
    }

    String getIngredients()
    {
        return ingredients;
    }

    Double getPrice(){

        return price;
    }
}
