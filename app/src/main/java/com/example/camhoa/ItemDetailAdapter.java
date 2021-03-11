package com.example.camhoa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemDetailAdapter extends RecyclerView.Adapter<ItemDetailAdapter.ItemHolder> {

    List<ItemDetail> list;
    Context context;
    ItemDetailAdapter.OnItemClick clickListener;

    public ItemDetailAdapter(List<ItemDetail> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setClickListener(OnItemClick clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.line_item_detail, null);
        ItemDetailAdapter.ItemHolder itemHolder = new ItemDetailAdapter.ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
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
//            cardView = itemView.findViewById(R.id.cardView);
//            Display mdisp = itemView.getContext().getDisplay();
//            Point mdispSize = new Point();
//            mdisp.getSize(mdispSize);
//            float height=0;
//            height= mdispSize.y/context.getResources().getDisplayMetrics().density;
//            Log.e("aaaa", String.valueOf(height*0.096));
//            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (height * 0.096));
//            cardView=new CardView(context);
//            cardView.setLayoutParams(layoutParams);
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
