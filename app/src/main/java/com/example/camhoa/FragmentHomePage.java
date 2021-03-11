package com.example.camhoa;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentHomePage extends Fragment implements ItemDetailAdapter.OnItemClick {
    RecyclerView recyclerview;
    ImageView imgBack;
    List<ItemDetail> list;
    ItemDetailAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!isTablet(getContext())) {
            View view = inflater.inflate(R.layout.fragment_home_page, container, false);
            recyclerview = view.findViewById(R.id.recyclerview);
            imgBack = view.findViewById(R.id.imgBack);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentHome()).commit();
                }
            });
            getData();
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_home_page_ipad, container, false);
            recyclerview = view.findViewById(R.id.recyclerview);
            imgBack = view.findViewById(R.id.imgBack);
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentHome()).commit();
                }
            });
            getDataIpad();
            return view;
        }
    }

    private void getDataIpad() {
        list = new ArrayList<>();
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));

        adapter = new ItemDetailAdapter(list, getContext());
        recyclerview.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerview.setLayoutManager(gridLayoutManager);
        recyclerview.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    public Boolean isTablet(Context context) {
        return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }

    private void getData() {
        list = new ArrayList<>();
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));
        list.add(new ItemDetail("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5", "Cắm hoa hình tam giác", "It is a long established fact that a reader will be distracted by the readable content of ..."));

        adapter = new ItemDetailAdapter(list, getContext());
        recyclerview.setHasFixedSize(true);
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(verticalLayoutManager);
        recyclerview.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentTutorial()).addToBackStack(null).commit();
    }
}
