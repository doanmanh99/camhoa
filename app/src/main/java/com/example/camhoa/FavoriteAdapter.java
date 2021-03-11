package com.example.camhoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ItemHolder> {

    List<ItemDetail> list;
    Context context;
    FavoriteAdapter.OnItemClick clickListener;

    public FavoriteAdapter(List<ItemDetail> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setClickListener(FavoriteAdapter.OnItemClick clickListener) {
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public FavoriteAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_favorite, null);
        FavoriteAdapter.ItemHolder itemHolder = new FavoriteAdapter.ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ItemHolder holder, int position) {
        ItemDetail item = list.get(position);
        holder.tvDesc.setText(item.getTvDesc());
        holder.tvName.setText(item.getTvName());
        Picasso.get().load(item.getImgAvatar()).into(holder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface OnItemClick {
        void onItemClick(int position);
    }
    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgAvatar;
        public TextView tvName, tvDesc;
        public CardView cardView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvName = itemView.findViewById(R.id.tvName);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener != null) {
                        clickListener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
