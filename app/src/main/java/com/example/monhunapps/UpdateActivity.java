package com.example.monhunapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    TextView updt_armor,updt_weapon;
    Button updt_btn,delete_btn;
    String id,weapon,armor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updt_weapon = findViewById(R.id.updt_nama_weapon);
        updt_armor = findViewById(R.id.updt_nama_set);
        updt_btn = findViewById(R.id.updt_btn);
        delete_btn = findViewById(R.id.delete_btn);
        getIntentData();
        updt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                armor = updt_armor.getText().toString().trim();
                weapon = updt_weapon.getText().toString().trim();
                myDB.updateData(id,weapon,armor);
            }
        });
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            confirmDialog();
            }
        });
    }

    void getIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("armor")
                && getIntent().hasExtra("weapon")){
                id = getIntent().getStringExtra("id");
                armor = getIntent().getStringExtra("armor");
                weapon = getIntent().getStringExtra("weapon");

                updt_armor.setText(armor);
                updt_weapon.setText(weapon);
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + armor + " ?");
        builder.setMessage("Are you sure you want to delete " + armor + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
