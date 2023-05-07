package com.example.control3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Historique extends AppCompatActivity {
private Button accu;
private ListView listv;
database d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
        accu=findViewById(R.id.btn_cal);
        listv=findViewById(R.id.listv);

        d=new database(this);

        ArrayList<String> p= d.getdata();

        ArrayAdapter<String> adpt= new ArrayAdapter<String>(Historique.this, android.R.layout.simple_list_item_1,p);
        listv.setAdapter(adpt);

        accu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Historique.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}