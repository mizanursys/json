package com.nadxlib.json;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllListAdapter extends RecyclerView.Adapter<AllListAdapter.AllDataViewHolder> {

    private Context mCtx;
    private List<JSONObject> all_list =new ArrayList<>();


    public AllListAdapter(Context mCtx, List<JSONObject> all_list) {
        this.mCtx = mCtx;
        this.all_list = all_list;

    }

    @Override
    public AllDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //ViewHolder For RecyclerView
        View view = inflater.inflate(R.layout.all_post, parent, false);
        final AllDataViewHolder alldataViewHolder=new AllDataViewHolder(view);

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int position=alldataViewHolder.getAdapterPosition();
                Toast.makeText(mCtx,"Item at position "+position+" deleted",Toast.LENGTH_SHORT).show();

                notifyDataSetChanged();

                return true;
            }
        });




        return new AllDataViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final AllDataViewHolder holder, final int position) {
        try {
            final JSONObject list_jsonobject = all_list.get(position);



                holder.emp_name.setText(list_jsonobject.getString("employee_name"));


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }




    @Override
    public int getItemCount() {

        try {
            return all_list.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    class AllDataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView emp_name;


        @SuppressLint("CutPasteId")
        public AllDataViewHolder(View itemView) {
            super(itemView);

            emp_name=itemView.findViewById(R.id.emp_name);


        }

        @Override
        public void onClick(View view) {

        }
    }

}


