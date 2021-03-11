package com.example.camhoa;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavoriteFavorite extends Fragment {
    RecyclerView recyclerView;
    List<ItemDetail> list;
    FavoriteAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_favorite_favorite,container,false);
        recyclerView=view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getData();
    }

    private void getData() {
        list=new ArrayList<>();
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","Cắm hoa hình tam giác","It is a long established fact that a reader will be distracted by the readable content of ..."));
        adapter=new FavoriteAdapter(list,getContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("E","RESUME");
    }
}
