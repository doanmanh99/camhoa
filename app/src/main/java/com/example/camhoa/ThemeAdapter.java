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

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ItemHolder>{
    List<Theme> list;
    Context context;
    ItemDetailAdapter.OnItemClick clickListener;
    public ThemeAdapter(List<Theme> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setClickListener(ItemDetailAdapter.OnItemClick clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ThemeAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.line_theme,null);
        ThemeAdapter.ItemHolder itemHolder=new ThemeAdapter.ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeAdapter.ItemHolder holder, int position) {
        Theme item=list.get(position);
        holder.tvName.setText(item.getTvName());
        Picasso.get().load(item.getImgBackgroud()).into(holder.imgBackgroud);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnItemClick{
        void onItemClick(int position);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgBackgroud;
        public TextView tvName;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgBackgroud=itemView.findViewById(R.id.imgBackgroud);
            tvName=itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (clickListener!=null){
                        clickListener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
