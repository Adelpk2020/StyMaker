package com.example.stylemakerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> productsNames;
    ArrayList<Integer> productsImages;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> productsNames, ArrayList<Integer> productsImages) {
        this.context = context;
        this.productsImages = productsImages;
        this.productsNames = productsNames;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(productsNames.get(position));
        holder.image.setImageResource(productsImages.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context,DesignType.class);
                //intent.putExtra("image", productsImages.get(position)); // put image data in Intent
               // context.startActivity(intent); // start Intent
                //Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return productsNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name =  itemView.findViewById(R.id.product_name);
            image =  itemView.findViewById(R.id.product_image);

        }
    }
}
