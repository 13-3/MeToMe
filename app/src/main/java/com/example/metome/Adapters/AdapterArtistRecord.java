package com.example.metome.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metome.R;

import java.util.ArrayList;

public class AdapterArtistRecord extends RecyclerView.Adapter<AdapterArtistRecord.HolderRecord> {

    private Context context;
    private ArrayList<ModelArtistRecord> recordsList;

    public AdapterArtistRecord(Context context, ArrayList<ModelArtistRecord> recordsList) {
        this.context = context;
        this.recordsList = recordsList;
    }

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.artist_record,parent,false);

        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {

        //getting and handling data

        ModelArtistRecord modelArtistRecord = recordsList.get(position);
        String piece_name = modelArtistRecord.getName();
        String piece_image = modelArtistRecord.getImage();

        //set data to views

        holder.ivPiece_image.setImageURI(Uri.parse(piece_image));
        holder.tvPiece_name.setText(piece_name);


    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    class HolderRecord extends RecyclerView.ViewHolder {

        ImageView ivPiece_image;
        TextView tvPiece_name;


        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            tvPiece_name = itemView.findViewById(R.id.tvPiece_name);
            ivPiece_image = itemView.findViewById(R.id.ivPeice_image);


        }
    }
}