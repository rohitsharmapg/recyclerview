package com.example.rohit.demorecyclerview;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends  RecyclerView.Adapter<Adapter.HistoryViewHolder> {


        Context context;
public ArrayList<Model> list_history;
        FragmentManager fragmentManager;

        Adapter.HistoryViewHolder hviewholder;
public Adapter(Context context, ArrayList<Model> list_history)
        {
        this.context=context;
        this.list_history=list_history;

        }

@Override
public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.imageviewhan,null);
        hviewholder= new HistoryViewHolder(view);
        return hviewholder;
        }

@Override
public void onBindViewHolder(HistoryViewHolder holder, int position) {

        Utils.glideimageview(context,list_history.get(position).getImage(), holder.userimage);



    }

    @Override
    public int getItemCount() {
        return list_history.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        // @BindView(R.id.img_history_user)
        ImageView userimage;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            //       ButterKnife.bind(this,itemView);

            userimage=(ImageView)itemView.findViewById(R.id.imageview);


        }
    }
}