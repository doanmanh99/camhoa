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

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemHolder>{
    List<User> list;
    Context context;
    UserAdapter.OnItemClick clickListener;
    public void setClickListener(UserAdapter.OnItemClick clickListener) {
        this.clickListener = clickListener;
    }

    public UserAdapter(List<User> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.line_user,null);
        UserAdapter.ItemHolder itemHolder=new UserAdapter.ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        User item=list.get(position);
        holder.tvName.setText(item.getTvName());
        Picasso.get().load(item.getImgAvatar()).into(holder.imgAvatar);
        Picasso.get().load(item.getImgSample()).into(holder.imgSample);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface OnItemClick{
        void onItemClick(int position);
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public ImageView imgSample;
        public ImageView imgAvatar;
        public TextView tvName;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar=itemView.findViewById(R.id.imgAvatar);
            imgSample=itemView.findViewById(R.id.imgSample);
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
