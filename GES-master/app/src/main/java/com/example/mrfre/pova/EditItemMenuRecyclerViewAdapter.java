package com.example.mrfre.pova;

import android.content.Context;
import androidx.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditItemMenuRecyclerViewAdapter extends RecyclerView.Adapter<EditItemMenuRecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> toppings;
    private Context context;

    public EditItemMenuRecyclerViewAdapter(Context context, ArrayList<String> toppings) {
        this.toppings = toppings;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.edit_item_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.topping.setText(toppings.get(i));
    }

    @Override
    public int getItemCount() {
        return toppings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView topping;
        Switch aSwitch;
        RelativeLayout parentLayout;
        String toastText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topping = (TextView) itemView.findViewById(R.id.topping);
            aSwitch = (Switch)itemView.findViewById(R.id.itemSwitch);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.editItemParent);
            /*check to see if item being edited is a drink
            if so make all switches false (don't want all drinks added to cart by default, up to user to decide which drink to add)
            else make all switches true (all ingredients come in item by default therefore switches are all on)
             */
            if(CarlsJr.isDrink){
                aSwitch.setChecked(false);
                toastText = "Drink ";
            }
            else {
                toastText = "Ingredient ";
                aSwitch.setChecked(true);
            }
            aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){

                        Toast.makeText(context, toastText + "Added", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(context, toastText + "Removed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
