package com.example.camhoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    List<Item> list;
    Context context;
    ItemDetailAdapter.OnItemClick clickListener;

    public ItemAdapter(List<Item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setClickListener(ItemDetailAdapter.OnItemClick clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_item, null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = list.get(position);
        holder.txtvDesc.setText(item.getDesc());
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
        public TextView txtvDesc;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtvDesc = itemView.findViewById(R.id.tvDesc);
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
