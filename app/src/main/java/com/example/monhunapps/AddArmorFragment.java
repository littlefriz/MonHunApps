package com.example.monhunapps;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddArmorFragment extends Fragment{

    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    MyDatabaseHelper myDB;
    ArrayList<String> set_id, set_armor, set_weapon;
    AddArmorAdapter addArmorAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_armor, container, false);

        recyclerView = view.findViewById(R.id.rv_add_armor);
        add_btn = view.findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(getActivity());
        set_id = new ArrayList<>();
        set_armor = new ArrayList<>();
        set_weapon = new ArrayList<>();

        storeDataInArrays();

        addArmorAdapter = new AddArmorAdapter(getActivity(), set_id, set_armor, set_weapon);
        recyclerView.setAdapter(addArmorAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                set_id.add(cursor.getString(0));
                set_armor.add(cursor.getString(1));
                set_weapon.add(cursor.getString(2));
            }
        }
    }
}