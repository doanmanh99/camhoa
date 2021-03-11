package com.example.camhoa;

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

import com.example.camhoa.widget.FragmentCreatePost;

import java.util.ArrayList;
import java.util.List;

public class FragmentTutorialFeedback extends Fragment implements UserAdapter.OnItemClick{
    ImageView imgAdd;
    RecyclerView recyclerView;
    List<User> list;
    UserAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tutorial_feedback, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);
        imgAdd=view.findViewById(R.id.imgAdd);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment,new FragmentCreatePost()).commit();
            }
        });
        getData();
        return view;

    }

    private void getData() {
        list=new ArrayList<>();
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        list.add(new User("https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","https://cf.shopee.vn/file/ad5966fbe2e61ee75ed0c73e400afac5","AAA"));
        adapter=new UserAdapter(list,getContext());
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this::onItemClick);
    }

    @Override
    public void onItemClick(int position) {
        getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment,new FragmentUserDetail()).commit();
    }
}
