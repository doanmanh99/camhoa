package com.example.camhoa.widget;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.camhoa.R;
import com.example.camhoa.Theme;
import com.example.camhoa.ThemeAdapter;
import com.example.camhoa.User;
import com.example.camhoa.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentFavoriteTheme extends Fragment {
    RecyclerView recyclerView;
    List<Theme> list;
    ThemeAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_favorite_theme,container,false);
        recyclerView=view.findViewById(R.id.recyclerView);
        getData();
        return view;
    }

    private void getData() {
        list=new ArrayList<>();
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new Theme("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        adapter=new ThemeAdapter(list,getContext());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("RESUME","FragmentFavoriteTheme");
    }

}
