package com.example.control3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class calculer extends AppCompatActivity {
private EditText p,t;
private Button calcc,accu,hist;
private TextView im;
private ImageView img;
database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculer);
        p=findViewById(R.id.poids);
        t=findViewById(R.id.taille);
        calcc=findViewById(R.id.btn_calcc);
        accu=findViewById(R.id.btn_Acc);
        hist=findViewById(R.id.btn_hist);
        im=findViewById(R.id.imc);
        img=findViewById(R.id.img);

        //db=new data_imc(this);
        //public boolean ajout()

//        Date d= new Date();
//        String datt = d.toString();
//        db=new data_imc(this);


        db = new database(this);


        calcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float poi=0,tai=0,imcc=0;
                poi=Float.parseFloat(p.getText().toString());
                tai=Float.parseFloat(t.getText().toString());
                tai=tai/100;
                imcc=poi/(tai*tai);
                im.setText("Votre IMC :" + imcc);

                if (imcc>0) {
                    if (imcc < 18.5) {
                        img.setImageResource(R.drawable.maigreur);

                    }else if (imcc < 25) {
                        img.setImageResource(R.drawable.normal);

                    }else if (imcc < 30) {
                        img.setImageResource(R.drawable.surpoids);

                    }else if (imcc < 40) {
                        img.setImageResource(R.drawable.obesitemoderee);

                    }else {
                        img.setImageResource(R.drawable.obesitesevere);

                    }

                }else {
                    im.setText("erorr :(");
                }
                String i =String.valueOf(imcc);
                im.setText(""+i);
                Date d =new Date();
                String da =d.toString();


                Boolean checkinsertdata = db.insertIMC(i, da);
                if (checkinsertdata == true)
                    Toast.makeText(calculer.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(calculer.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();



            }

        });
        accu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(calculer.this,MainActivity.class);
                startActivity(intent);
            }
        });
        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(calculer.this,Historique.class);
                startActivity(intent);
            }
        });


    }
}