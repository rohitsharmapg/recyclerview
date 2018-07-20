package com.example.rohit.demorecyclerview;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import gun0912.tedbottompicker.TedBottomPicker;
import gun0912.tedbottompicker.util.RealPathUtil;
import io.realm.Realm;
import io.realm.RealmChangeListener;

public class MainActivity extends AppCompatActivity {
    private List<Model> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter mAdapter;
    ArrayList<Model> list_history;
    Adapter history_adapter;

    Realm realm;
    RealmChangeListener realmChangeListener;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //INTILIZE REALM


//retrive


        //ADd

        button=(Button)findViewById(R.id.button);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        list_history= new ArrayList<>();


         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {




                 if (Utils.CheckallPermissionS(MainActivity.this)) {

                     TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(MainActivity.this)
                             .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                                 @Override
                                 public void onImageSelected(Uri uri) {
//                        file = new File(image_path);


                                    String userimage = RealPathUtil.getRealPath(getApplicationContext(), uri);

                                     list_history.add(new Model(userimage));
                                     setAdapter();
                                     Model model=new Model();




                                 }
                             })
                             .create();

                     tedBottomPicker.show(getSupportFragmentManager());
                 }
             }
         });
    }
    public void setAdapter() {
        history_adapter= new Adapter(MainActivity.this,list_history);
        recyclerView.setLayoutManager(verticalRecycleHandle(this));
        recyclerView.setAdapter(history_adapter);
    }
    public static LinearLayoutManager verticalRecycleHandle(Activity activity)
    {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return linearLayoutManager;

    }
}
