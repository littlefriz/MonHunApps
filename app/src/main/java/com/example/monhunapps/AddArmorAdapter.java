package com.example.monhunapps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddArmorAdapter extends RecyclerView.Adapter<AddArmorAdapter.MyViewHolder> {
    private Context context;
    Activity activity;
    private ArrayList set_id, set_armor, set_weapon;
    int position;

    AddArmorAdapter(Context context, ArrayList set_id, ArrayList set_armor, ArrayList set_weapon){
        this.context = context;
        this.set_id = set_id;
        this.set_armor = set_armor;
        this.set_weapon = set_weapon;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddArmorAdapter.MyViewHolder holder, final int position) {
        holder.armor_id_txt.setText(String.valueOf(set_id.get(position)));
        holder.armor_title_txt.setText(String.valueOf(set_armor.get(position)));
        holder.weapon_title_txt.setText(String.valueOf(set_weapon.get(position)));
        holder.rv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id",String.valueOf(set_id.get(position)));
                intent.putExtra("armor",String.valueOf(set_armor.get(position)));
                intent.putExtra("weapon",String.valueOf(set_weapon.get(position)));
                context.startActivity(intent);

            }
        });

        }

    @Override
    public int getItemCount() {
        return set_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView armor_id_txt, armor_title_txt, weapon_title_txt;
        RelativeLayout rv_main;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            armor_id_txt = itemView.findViewById(R.id.armor_id_txt);
            armor_title_txt = itemView.findViewById(R.id.armor_title_txt);
            weapon_title_txt = itemView.findViewById(R.id.weapon_title_txt);
            rv_main = itemView.findViewById(R.id.rv_main);
        }
    }
}
