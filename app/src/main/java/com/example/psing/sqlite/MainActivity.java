package com.example.psing.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    databasehelper mydb;
    EditText editname,editsurname,editmarks;
    Button badddata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new databasehelper(this);
        editname=(EditText)findViewById(R.id.editText);
        editsurname=(EditText)findViewById(R.id.editText2);
        editmarks=(EditText)findViewById((R.id.editText3));
        badddata=(Button)findViewById(R.id.button_add);
        adddata();
    }
    public void adddata(){
        badddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted=mydb.insertdata(editname.getText().toString(),editsurname.getText().toString(),editmarks.getText().toString());
                if(isinserted =true)
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data NOT Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
