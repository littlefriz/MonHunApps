package com.example.monhunapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    EditText set_input_armor,set_input_weapon;
    Button finish_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        set_input_armor = findViewById(R.id.add_nama_set);
        set_input_weapon = findViewById(R.id.add_nama_weapon);
        finish_btn = findViewById(R.id.finish_btn);
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addSet(set_input_armor.getText().toString().trim(),
                        set_input_weapon.getText().toString().trim());
            }
        });
    }
}