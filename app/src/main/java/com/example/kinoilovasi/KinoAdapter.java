package com.example.kinoilovasi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class KinoAdapter extends RecyclerView.Adapter<KinoAdapter.KinoViewHolder> {

    private List<Kino> kinoList;
    private Context context;

    public KinoAdapter(List<Kino> kinoList, Context context) {
        this.kinoList = kinoList;
        this.context = context;
    }

    @NonNull
    @Override
    public KinoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KinoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.kino_item_layout, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull KinoViewHolder holder, int position) {
        Kino kino = kinoList.get(position);
        Glide.with(holder.itemView.getContext()).load(kino.getImg()).placeholder(R.drawable.loading).into(holder.imgMovie);
        holder.tvMovieName.setText(kino.getName());
        holder.tvMovieAge.setText("Ko'rish yoshi: " + kino.getSight_age() + "+");
        holder.llKinoPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PlayerActivity.class);
                intent.putSerializable("kino",kino);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kinoList.size();
    }

    class KinoViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llKinoPlayer;
        ImageView imgMovie;
        TextView tvMovieName;
        TextView tvMovieAge;

        public KinoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMovie = itemView.findViewById(R.id.imgMovie);
            tvMovieName = itemView.findViewById(R.id.tvMovieName);
            tvMovieAge = itemView.findViewById(R.id.tvMovieAge);
            llKinoPlayer = itemView.findViewById(R.id.llKinoPlayer);
        }
    }
}
