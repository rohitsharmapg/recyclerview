package com.example.rohit.demorecyclerview.Sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohit.demorecyclerview.Adapter;
import com.example.rohit.demorecyclerview.Model;
import com.example.rohit.demorecyclerview.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;

public class Firstcls extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    Button button;
    EditText name,mobileno,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        databaseHelper=new DatabaseHelper(this);
        button=(Button)findViewById(R.id.button);
        name=(EditText)findViewById(R.id.textt1);
        mobileno=(EditText)findViewById(R.id.textt2);
        email=(EditText)findViewById(R.id.textt3);


button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

boolean result =databaseHelper.insertData(name.getText().toString(), Integer.parseInt(mobileno.getText().toString()),
        email.getText().toString());
if (result)
    Toast.makeText(Firstcls.this, "This is succesfully in SQLite DataBase..",
            Toast.LENGTH_LONG).show();

else
    Toast.makeText(Firstcls.this, "This is not succesful",
            Toast.LENGTH_LONG).show();


    }
});


    }
}