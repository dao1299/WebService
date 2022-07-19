package com.example.retrofitassignment.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitassignment.R;
import com.example.retrofitassignment.network.MarsProperty;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListImageAdapter extends RecyclerView.Adapter<ListImageAdapter.ViewHolder>{

    ArrayList<MarsProperty> marsPropertyList;



    onClickItemMars onClickItemMars;
    private String TAG = "ListImageAdapter";

    public ListImageAdapter(ArrayList<MarsProperty> marsPropertyList,onClickItemMars onClickItemMars) {
        this.marsPropertyList = marsPropertyList;
        this.onClickItemMars = onClickItemMars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarsProperty marsProperty = marsPropertyList.get(position);
        displayData(marsProperty, holder);
    }

    private void displayData(MarsProperty marsProperty, ViewHolder holder) {
        View view = holder.getView();
        ImageView imgMars = view.findViewById(R.id.imgMars);
        Log.i(TAG, "displayData: "+marsProperty);
        Uri uri = Uri.parse(marsProperty.imgSrcUrl).buildUpon().scheme("https").build();
        Picasso.with(imgMars.getContext())
                .load(uri)
                .placeholder(R.drawable.loading_img)
                .error(R.drawable.ic_broken_image)
                .into(imgMars);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItemMars.onClick(marsProperty);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marsPropertyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        View view;

        ViewHolder(View view) {
            super(view);
            this.view = view;
        }

        View getView() {
            return view;
        }
    }

    public interface onClickItemMars{
        void onClick(MarsProperty marsProperty);
    }


}
